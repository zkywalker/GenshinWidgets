package org.zky.genshinwidgets.main

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.model.SignInfo
import org.zky.genshinwidgets.model.SignReward
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.network.*
import org.zky.genshinwidgets.utils.*


class MainViewModel : ViewModel() {

    val roleInfo: MutableLiveData<UserRole?> = MutableLiveData()

    var roleInfoSp: String by PreferenceDelegate(SpCst.KEY_ROLE_INFO, "")

    val cookie: MutableLiveData<String> = MutableLiveData(loginCookie)

    val signInfo = MutableLiveData<SignInfo?>()

    val signReward = MutableLiveData<SignReward>()

    fun onPageStart() {
        if (TextUtils.isEmpty(loginCookie)) {
            return
        }
        if (!loadUserRoleFromLocal()) {
            viewModelScope.launch {
                requestUserRole()?.let {
                    getSignInfo(it)
                }
            }
        } else {
            getSignInfo(roleInfo.value)
        }
    }

    fun loadUserRoleFromLocal(): Boolean {
        if (roleInfoSp.isNotEmpty()) {
            roleInfo.value = roleInfoSp.fromJson()
            return true
        }
        return false
    }

    suspend fun requestUserRole(): UserRole? {
        // todo did not consider the case that the user has multiple roles
        roleInfo.value = Request.getUserRole()?.findGenshinRole()
        roleInfoSp = if (roleInfo.value == null) "" else roleInfo.value.toJson()
        return roleInfo.value
    }

    fun getSignInfo(role: UserRole?) {
        viewModelScope.launch {
            var useRole = role
            if (useRole == null) {
                useRole = requestUserRole() ?: return@launch
            }
            signReward.value = Request.getSignReward()
            signInfo.value =
                Request.getSignInfo(region = useRole.region, uid = useRole.game_uid)
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

} 