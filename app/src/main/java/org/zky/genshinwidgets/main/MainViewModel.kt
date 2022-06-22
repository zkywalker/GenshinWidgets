package org.zky.genshinwidgets.main

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.Account
import org.zky.genshinwidgets.GameRole
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.database.DatabaseStore
import org.zky.genshinwidgets.model.GameCharacter
import org.zky.genshinwidgets.model.SignInfo
import org.zky.genshinwidgets.model.SignReward
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.network.*
import org.zky.genshinwidgets.utils.*


class MainViewModel : ViewModel() {

    val roleInfo: MutableLiveData<List<UserRole>> = MutableLiveData()

    val currentUseRole: MutableLiveData<UserRole> = MutableLiveData()

//    var roleInfoSp: String by PreferenceDelegate(SpCst.KEY_ROLE_INFO, "")

    val cookie: MutableLiveData<String> = MutableLiveData(loginCookie)

    val signInfo = MutableLiveData<SignInfo?>()

    val signReward = MutableLiveData<SignReward>()

    val pageRequesting = MutableLiveData<Boolean>()

    val characters = MutableLiveData<List<GameCharacter>>()

    fun onPageStart() {
        if (TextUtils.isEmpty(loginCookie)) {
            return
        }
        viewModelScope.launch {
            pageRequesting.value = true
            val gameRoles = DatabaseStore.queries.selectAllRoles().executeAsList()
            if (gameRoles.isEmpty()) {
                val accounts = DatabaseStore.queries.selectAllAccounts().executeAsList()
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
                    val character = Request.getCharacter(current.game_uid, current.region)
                    characters.value = character?.avatars
                    Log.i("kyle", "character: $character")
                }
            }
            pageRequesting.value = false
        }
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

    fun getSignInfo(role: UserRole?) {
        viewModelScope.launch {
            pageRequesting.value = true
            val userRole = role ?: roleInfo.value?.first() ?: return@launch
            val account = DatabaseStore.queries.selectAccount(userRole.account_id).executeAsOne()
            signReward.value = Request.getSignReward(account.cookie)
            signInfo.value =
                Request.getSignInfo(
                    region = userRole.region,
                    uid = userRole.game_uid,
                    cookie = account.cookie
                )
            pageRequesting.value = false
        }
    }

    fun sign(role: UserRole?) {
        viewModelScope.launch {
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
                getString(R.string.sign_success).toast()
            }
            getSignInfo(useRole)
        }
    }

    fun onSelectRole(it: UserRole) {
        currentUseRole.value = it
        getSignInfo(it)
    }

    private fun List<GameRole>.convertToUserRoles(): List<UserRole> {
        return map {
            UserRole(
                game_uid = it.game_uid,
                game_biz = it.game_biz,
                region = it.region,
                region_name = it.region_name,
                nickname = it.nickname,
                level = it.level?.toString() ?: "",
                is_chosen = it.is_chosen ?: false,
                is_official = it.is_official ?: false,
                account_id = it.account_id
            )
        }
    }

}


