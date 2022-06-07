package org.zky.genshinwidgets.widgets

import android.appwidget.AppWidgetManager
import android.text.TextUtils
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.main.findGenshinRole
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.network.Request
import org.zky.genshinwidgets.utils.*
import java.io.File


class WidgetsConfigViewModel : ViewModel() {

    val widgetImageAlpha = MutableLiveData<Float>()

    val widgetImageCorner = MutableLiveData<Dp>()

    val widgetImageFile = MutableLiveData<File>()

    var isAddWidgetMode = true

    val appWidgetId = MutableLiveData(AppWidgetManager.INVALID_APPWIDGET_ID)

    val widgetCookie = MutableLiveData(loginCookie)

    val cookieDelegate = PreferenceDelegate(SpCst.KEY_COOKIE, "")

    var widgetCookieSp by cookieDelegate

    val roleInfo: MutableLiveData<UserRole?> = MutableLiveData()

    suspend fun requestUserRole(cookie: String? = null): UserRole? {
        // todo did not consider the case that the user has multiple roles
        roleInfo.value = Request.getUserRole(cookie)?.findGenshinRole()
        return roleInfo.value
    }

    fun refreshLocalWidgetCookie() {
        if (TextUtils.isEmpty(widgetCookie.value)) {
            return
        }
        if (appWidgetId.value == null || appWidgetId.value == AppWidgetManager.INVALID_APPWIDGET_ID) {
            return
        }
        cookieDelegate.name = "${SpCst.KEY_COOKIE}_${appWidgetId.value}"
        widgetCookieSp = widgetCookie.value ?: ""
    }


} 