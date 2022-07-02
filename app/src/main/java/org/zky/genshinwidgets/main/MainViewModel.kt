package org.zky.genshinwidgets.main

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.Account
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.database.DatabaseStore
import org.zky.genshinwidgets.model.*
import org.zky.genshinwidgets.network.*
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.widgets.isSameDate
import java.util.*


class MainViewModel : ViewModel() {

    val showAddWidgetAlert: MutableLiveData<Boolean> = MutableLiveData(false)

    val roleInfo: MutableLiveData<List<UserRole>> = MutableLiveData()

    val currentUseRole: MutableLiveData<UserRole> = MutableLiveData()

    var mainAccount: String by PreferenceDelegate(SpCst.KEY_SELECT_ACCOUNT, "")

    val accounts: MutableLiveData<List<Account>> = MutableLiveData()

    val account: MutableLiveData<Account> = MutableLiveData()

    val signInfo = MutableLiveData<SignInfo?>()

    val signReward = MutableLiveData<SignReward>()

    val pageRequesting = MutableLiveData<Boolean>()

    val characters = MutableLiveData<List<GameCharacter>>()

    val activities = MutableLiveData<List<GameActivity>>()

    val signResponse = MutableLiveData<Pair<Int, Int>>()

    val showSignResponse = MutableLiveData(false)

    val dailyNote = MutableLiveData<DailyNote>()

    fun onPageStart() {
        val accounts = DatabaseStore.queries.selectAllAccounts().executeAsList()
        this.accounts.value = accounts
        if (accounts.isEmpty()) {
            return
        }
        val acc: Account? = if (TextUtils.isEmpty(mainAccount)) {
            accounts.first()
        } else {
            accounts.find {
                it.account_id == mainAccount
            }
        }
        if (acc == null) {
            return
        }
        account.value = acc
        mainAccount = acc.account_id
        viewModelScope.launch {
            pageRequesting.value = true
            val gameRoles = DatabaseStore.queries.selectAllRoles().executeAsList()
            if (gameRoles.isEmpty()) {
                if (accounts.isNotEmpty()) {
                    roleInfo.value = requestUserRole(accounts)
                }
            } else {
                roleInfo.value = gameRoles.convertToUserRoles()
            }
            if (roleInfo.value?.isNotEmpty() == true) {
                val current = currentUseRole.value ?: roleInfo.value?.first()
                if (current != null) {
                    currentUseRole.value = current
                    getSignInfo(current)
                    getCharacters(current)
                    getDailyNote(current, acc)
                }
            }

            activities.value = Request.getGameActivity()?.list?.getTodayActivity()
            // 欣赏500ms的loading，减少刷新频次
            delay(500)
            pageRequesting.value = false
        }
    }

    private suspend fun getDailyNote(current: UserRole, account: Account) {
        dailyNote.value = Request.getGameRecord(
            roleId = current.game_uid,
            server = current.region,
            cookie = account.cookie
        )
    }

    suspend fun requestUserRole(accounts: List<Account>): List<UserRole> {
        val ret = mutableListOf<UserRole>()
        if (accounts.isEmpty()) {
            return ret
        }
        accounts.forEach { account ->
            val getUserRole = Request.getUserRole(account.cookie)?.list?.filter {
                it.game_biz == ApiCst.GAME_BIZ_GENSHIN
            }
            if (getUserRole?.isNotEmpty() == true) {
                getUserRole.forEach {
                    it.account_id = account.account_id
                    ret.add(it)
                    DatabaseStore.queries.insertGameRole(
                        account_id = it.account_id,
                        game_uid = it.game_uid,
                        game_biz = it.game_biz,
                        region = it.region,
                        region_name = it.region_name,
                        nickname = it.nickname,
                        level = it.level.toLongOrNull() ?: 0,
                        is_chosen = it.is_chosen,
                        is_official = it.is_official
                    )
                }
            }
        }
        return ret
    }

    suspend fun getSignInfo(role: UserRole?) {
        val userRole = role ?: roleInfo.value?.first() ?: return
        val account = DatabaseStore.queries.selectAccount(userRole.account_id).executeAsOne()
        signReward.value = Request.getSignReward(account.cookie)
        if (signInfo.value?.is_sign == true) {
            DatabaseStore.queries.updateSignDate(Date().time, userRole.account_id)
        }
        signInfo.value =
            Request.getSignInfo(
                region = userRole.region,
                uid = userRole.game_uid,
                cookie = account.cookie
            )
    }

    suspend fun sign(role: UserRole?): Boolean {
        var useRole = role
        if (useRole == null) {
            useRole = if (roleInfo.value?.isNotEmpty() == true) {
                roleInfo.value!!
            } else {
                requestUserRole(DatabaseStore.queries.selectAllAccounts().executeAsList())
            }.first()
        }
        val account = DatabaseStore.queries.selectAccount(useRole.account_id).executeAsOne()
        if (Request.sign(
                uid = useRole.game_uid,
                region = useRole.region,
                cookie = account.cookie
            )?.get("code") == "ok"
        ) {
            return true
        }
        return false
    }

    fun signMain(useRole: UserRole?) {
        viewModelScope.launch {
            if (sign(useRole)) {
                getSignInfo(useRole)
                R.string.sign_success.toast()
            }
        }
    }

    fun signAll() {
        viewModelScope.launch {
            pageRequesting.value = true
            signResponse.value = signAllReal()
            pageRequesting.value = false
            showSignResponse.value = true
        }
    }

    private suspend fun signAllReal(): Pair<Int, Int> {
        val gameRoles = DatabaseStore.queries.selectAllRoles().executeAsList().convertToUserRoles()
        if (gameRoles.isEmpty()) {
            return 0 to 0
        }
        var success = 0
        gameRoles.forEach {
            if (Date(it.sign_date).isSameDate()) {
                success++
            } else if (sign(it)) {
                success++
                DatabaseStore.queries.updateSignDate(Date().time, it.account_id)
                if (currentUseRole.value?.game_uid == it.game_uid) {
                    getSignInfo(currentUseRole.value)
                }
            }
        }
        return success to gameRoles.size
    }

    fun onSelectRole(it: UserRole) {
        currentUseRole.value = it
        viewModelScope.launch {
            getSignInfo(it)
            getCharacters(it)
        }
    }

    private suspend fun getCharacters(userRole: UserRole, account: Account? = null) {
        val acc = account ?: DatabaseStore.queries.selectAccount(userRole.account_id).executeAsOne()
        val character =
            Request.getCharacter(
                userRole.game_uid,
                userRole.region,
                acc.cookie
            )
        characters.value = character?.avatars
        Log.i("kyle", "character: $character")
    }

    fun saveAccountByCookie(cookie: String) {
        insertAccountByCookie(cookie)
    }

    fun refreshSignInfo(value: UserRole?) {
        viewModelScope.launch {
            pageRequesting.value = true
            getSignInfo(value)
            pageRequesting.value = false
        }
    }

    fun deleteAccount(it: String) {
        DatabaseStore.queries.deleteAccount(it)
        accounts.value = DatabaseStore.queries.selectAllAccounts().executeAsList()
    }

}

// find all activity in today
private fun List<GameActivity>.getTodayActivity(): List<GameActivity> {
    val date = Date()
    val currentTime = date.time / 1000
    val cal: Calendar = Calendar.getInstance()
    cal.time = date
    var realWeek = cal.get(Calendar.DAY_OF_WEEK)
    if (cal.firstDayOfWeek == Calendar.SUNDAY) {
        realWeek -= 1
        if (realWeek == 0) {
            realWeek = 7
        }
    }
    return filter {
        val start = it.start_time.toLongOrNull() ?: 0
        val end = it.end_time.toLongOrNull() ?: 0
        if (start != 0L && end != 0L && (currentTime < start || currentTime > end)) {
            return@filter false
        }
        if (it.drop_day.isNotEmpty() && !it.drop_day.contains("$realWeek")) {
            return@filter false
        }
        true
//                it.kind != "4"
    }.sortedWith { a, b ->
        if (a.kind.equals(b.kind)) {
            return@sortedWith (a.break_type.toIntOrNull()
                ?: 0) - (b.break_type.toIntOrNull() ?: 0)
        }
        return@sortedWith (a.kind.toIntOrNull() ?: 0) - (b.kind.toIntOrNull() ?: 0)
    }
}


