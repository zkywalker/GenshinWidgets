package org.zky.genshinwidgets.widgets

import android.appwidget.AppWidgetManager
import android.text.TextUtils
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.database.DatabaseStore
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.model.WidgetsConfigModel
import org.zky.genshinwidgets.model.convertToUserRoles
import org.zky.genshinwidgets.utils.*
import java.io.File


class WidgetsConfigViewModel : ViewModel() {

    var widgetsConfigModel: WidgetsConfigModel? = null

    val localPickImageFile: MutableLiveData<String> = MutableLiveData()

    val historyPickImage: List<String> by lazy {
        val history = Sp.getValue(SpCst.KEY_HISTORY_PICK_IMAGES, "")
        if (TextUtils.isEmpty(history)) {
            listOf("https://gw.alicdn.com/imgextra/i1/O1CN01wAe0EH1pUlFsEnT58_!!6000000005364-0-tps-747-499.jpg")
        } else {
            history.split(",")
        }
    }

    val widgetImageAlpha = MutableLiveData<Float>()

    val widgetImageCorner = MutableLiveData<Dp>()

    val widgetImageFile = MutableLiveData<File>()

    var isAddWidgetModeFromHome = true

    val appWidgetId = MutableLiveData(AppWidgetManager.INVALID_APPWIDGET_ID)

    val cookieDelegate = PreferenceDelegate(SpCst.KEY_COOKIE, "")

    var widgetCookieSp by cookieDelegate

    val roleInfo: MutableLiveData<List<UserRole>> = MutableLiveData()

    val currentUseRole: MutableLiveData<UserRole> = MutableLiveData()

    val pageRequesting = MutableLiveData<Boolean>()

    val pageLoading = MutableLiveData<Boolean>()

    fun getUserRole(): UserRole? {
        pageRequesting.value = true
        roleInfo.value = DatabaseStore.queries.selectAllRoles().executeAsList().convertToUserRoles()
        val roles = roleInfo.value ?: return null
        if (roles.isEmpty()) {
            return null
        }
        currentUseRole.value = roles[0]
        pageRequesting.value = false
        return currentUseRole.value
    }

    fun refreshLocalWidgetCookie() {
        val role = currentUseRole.value ?: return
        val account =
            DatabaseStore.queries.selectAccount(role.account_id).executeAsOneOrNull() ?: return
        if (TextUtils.isEmpty(account.cookie)) {
            return
        }
        if (appWidgetId.value == null || appWidgetId.value == AppWidgetManager.INVALID_APPWIDGET_ID) {
            return
        }
        cookieDelegate.name = "${SpCst.KEY_COOKIE}_${appWidgetId.value}"
        widgetCookieSp = account.cookie
    }


} 