package org.zky.genshinwidgets.widgets

import android.content.Context
import android.text.TextUtils
import android.util.Log
import androidx.datastore.preferences.core.MutablePreferences
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

class GlanceCallbackAction(private val needToast: Boolean = true) : ActionCallback {

    var roleInfoSp: String by PreferenceDelegate(SpCst.KEY_ROLE_INFO, "")

    override suspend fun onRun(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        withContext(context = Dispatchers.IO) {
            if (TextUtils.isEmpty(loginCookie)) {
                updateWidget(context, glanceId) {
                    it[booleanPreferencesKey("is_login")] = false
                }
                return@withContext
            }
            val roleInfo: UserRole = if (roleInfoSp.isNotEmpty()) {
                roleInfoSp.fromJsonOrNull<UserRole>() ?: Request.getUserRole()?.findGenshinRole()
            } else {
                Request.getUserRole()?.findGenshinRole()
            } ?: return@withContext

            if (parameters[GenshinDailyNoteWidget.ACTION_PARAMETERS_KEY] == ACTION_REQUEST_SIGN) {
                val sign = Request.sign(roleInfo.game_uid, roleInfo.region)
                if (sign?.get("code") == "ok") {
                    signDate = format.format(Date())
                    R.string.sign_success.toast()
                }
            }

            val gameRecord =
                Request.getGameRecord(roleInfo.game_uid, roleInfo.region) ?: return@withContext
            gameRecord.expeditions.forEach {
                val file = imageUrlToFile(it.avatar_side_icon)
                if (file != null) {
                    if (!file.exists() || file.length() == 0L) {
                        file.createNewFile()
                        Request.download(it.avatar_side_icon, file)
                    }
                }
            }
            withContext(context = Dispatchers.Main) {
                updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
                    it.toMutablePreferences().apply {
                        val toJson = gameRecord.toJson()
                        this[booleanPreferencesKey("is_login")] = true
                        this[stringPreferencesKey("data")] = toJson
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