package org.zky.genshinwidgets.widgets

import android.content.Context
import android.text.TextUtils
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.main.findGenshinRole
import org.zky.genshinwidgets.model.UserRole
import org.zky.genshinwidgets.network.Request
import org.zky.genshinwidgets.utils.*
import java.util.*

class GlanceCallbackAction(
    private val needToast: Boolean = true
) :
    ActionCallback {

    private val preferenceDelegate = PreferenceDelegate(SpCst.KEY_ROLE_INFO, "")

    private var roleInfoSp: String by preferenceDelegate

    private val cookieDelegate = PreferenceDelegate(SpCst.KEY_COOKIE, "")

    private var widgetCookieSp by cookieDelegate

    override suspend fun onRun(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        withContext(context = Dispatchers.IO) {
            //refresh preference key
            preferenceDelegate.name = "${SpCst.KEY_ROLE_INFO}_${glanceId.getId()}"
            cookieDelegate.name = "${SpCst.KEY_COOKIE}_${glanceId.getId()}"
            val cookie = widgetCookieSp
            Log.d("cookie", "onRun: cookie = $cookie")
            if (TextUtils.isEmpty(cookie)) {
                updateWidget(context, glanceId) {
                    it[booleanPreferencesKey("is_login")] = false
                }
                return@withContext
            }
            val roleInfo: UserRole = if (roleInfoSp.isNotEmpty()) {
                roleInfoSp.fromJsonOrNull<UserRole>() ?: Request.getUserRole(cookie)
                    ?.findGenshinRole()
            } else {
                Request.getUserRole(cookie)?.findGenshinRole()
            } ?: return@withContext

            if (parameters[GenshinDailyNoteWidget.ACTION_PARAMETERS_KEY] == ACTION_REQUEST_SIGN) {
                val sign = Request.sign(roleInfo.game_uid, roleInfo.region, cookie)
                if (sign?.get("code") == "ok") {
                    signDate = format.format(Date())
                    R.string.sign_success.toast()
                }
            }

            val gameRecord =
                Request.getGameRecord(roleInfo.game_uid, roleInfo.region, cookie)
                    ?: return@withContext
            gameRecord.expeditions.forEach {
                val file = imageUrlToFile(it.avatar_side_icon)
                if (file != null) {
                    if (!file.exists() || file.length() == 0L) {
                        file.createNewFile()
                        Request.download(it.avatar_side_icon, file)
                    }
                }
            }
            var image = parameters[GenshinDailyNoteWidget.ACTION_PARAMETERS_BG] ?: ""
            if (TextUtils.isEmpty(image)) {
                image = Sp.getValue("${SpCst.KEY_IMAGE_BG}_${glanceId.getId()}", "")
            } else {
                Sp.setValue("${SpCst.KEY_IMAGE_BG}_${glanceId.getId()}", image)
            }
            withContext(context = Dispatchers.Main) {
                updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
                    it.toMutablePreferences().apply {
                        val toJson = gameRecord.toJson()
                        this[booleanPreferencesKey("is_login")] = true
                        this[stringPreferencesKey(GenshinDailyNoteWidget.PRE_DATA_ROLE_INFO)] =
                            roleInfo.toJson()
                        this[stringPreferencesKey(GenshinDailyNoteWidget.PRE_DATA_DAILY_NOTE)] =
                            toJson
                        this[stringPreferencesKey(GenshinDailyNoteWidget.PRE_DATA_BG_IMAGE)] =
                            image
                        Log.i("gameRecord = ", toJson)
                    }
                }
                GenshinDailyNoteWidget().update(context, glanceId)
                if (needToast && parameters[GenshinDailyNoteWidget.ACTION_PARAMETERS_KEY] == ACTION_REQUEST_DAILY_NOTE) {
                    R.string.refresh_success.toast()
                }
            }
        }
    }

    companion object {

        val ACTION_REQUEST_DAILY_NOTE = "request_daily_note"

        val ACTION_REQUEST_SIGN = "request_sign"
    }

}