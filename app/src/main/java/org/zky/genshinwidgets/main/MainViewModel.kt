package org.zky.genshinwidgets.main

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.model.SignInfo
import org.zky.genshinwidgets.model.SignReward
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.network.*
import org.zky.genshinwidgets.utils.*


class MainViewModel : ViewModel() {

    val roleInfo: MutableLiveData<List<UserRole>> = MutableLiveData()

    val currentUseRole: MutableLiveData<UserRole> = MutableLiveData()

    var roleInfoSp: String by PreferenceDelegate(SpCst.KEY_ROLE_INFO, "")

    val cookie: MutableLiveData<String> = MutableLiveData(loginCookie)

    val signInfo = MutableLiveData<SignInfo?>()

    val signReward = MutableLiveData<SignReward>()

    val pageRequesting = MutableLiveData<Boolean>()

    fun onPageStart() {
        if (TextUtils.isEmpty(loginCookie)) {
            return
        }
        viewModelScope.launch {
            pageRequesting.value = true
            requestUserRole()?.let {
                getSignInfo(it)
            }
            pageRequesting.value = false
        }
    }

    suspend fun requestUserRole(): UserRole? {
        roleInfo.value = Request.getUserRole()?.list?.filter {
            it.game_biz == ApiCst.GAME_BIZ_GENSHIN
        }
        val roles = roleInfo.value ?: return null
        if (roles.isEmpty()) {
            return null
        }
        if (TextUtils.isEmpty(roleInfoSp)) {
            currentUseRole.value = roles[0]
        } else {
            val role = roleInfoSp.fromJsonOrNull<UserRole>()
            currentUseRole.value = roles.find { it.game_uid == role?.game_uid }
        }
        roleInfoSp = if (currentUseRole.value == null) "" else currentUseRole.value.toJson()
        return currentUseRole.value
    }

    fun getSignInfo(role: UserRole?) {
        viewModelScope.launch {
            pageRequesting.value = true

            var useRole = role
            if (useRole == null) {
                useRole = requestUserRole() ?: return@launch
            }
            signReward.value = Request.getSignReward()
            signInfo.value =
                Request.getSignInfo(region = useRole.region, uid = useRole.game_uid)
            pageRequesting.value = false
        }
    }

    fun sign(role: UserRole?) {
        viewModelScope.launch {
            var useRole = role
            if (useRole == null) {
                useRole = requestUserRole() ?: return@launch
            }

            if (Request.sign(uid = useRole.game_uid, region = useRole.region)
                    ?.get("code") == "ok"
            ) {
                getString(R.string.sign_success).toast()
            }
            getSignInfo(role)
        }
    }

    fun onSelectRole(it: UserRole) {
        currentUseRole.value = it
        roleInfoSp = it.toJson()
        getSignInfo(it)
    }

} 