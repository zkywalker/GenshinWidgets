package org.zky.genshinwidgets.widgets

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.util.Log
import androidx.glance.action.actionParametersOf
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.utils.application
import org.zky.genshinwidgets.utils.loginCookie


class GlanceReceiver : GlanceAppWidgetReceiver() {

    val scope = CoroutineScope(context = Dispatchers.Main)

    override val glanceAppWidget: GlanceAppWidget = GenshinDailyNoteWidget()

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("onReceive", "onReceive: ${intent.extras?.get("test")}")

        when (intent.action) {
            ACTION_REFRESH_WIDGET_ALARM -> {
                Log.d("GlanceReceiver", "onReceive: update widget alarm")
                refresh()
//                startRefreshAlarm(application, Config.autoRefreshMs)
            }
            else -> {
                super.onReceive(context, intent)
            }
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        super.onDeleted(context, appWidgetIds)
        Log.i("kyle", "onDeleted: $appWidgetIds")
    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
        Log.i("onReceive", "onEnabled: ")
    }

    private fun refresh() {
        scope.launch {
            val ids = GlanceAppWidgetManager(application).getGlanceIds(
                GenshinDailyNoteWidget::class.java
            )
            if (ids.isEmpty()) {
                return@launch
            }
            val curId = ids.last()
            GlanceCallbackAction(false).onRun(application, curId, actionParametersOf())
        }
    }

    companion object {

        val ACTION_REFRESH_WIDGET_ALARM: String =
            "org.zky.genshinwidgets.action.REFRESH_WIDGET"

        fun startRefreshAlarm(context: Context, autoRefreshMs: Long) {
            val intent = Intent(context, GlanceReceiver::class.java)
            intent.action = ACTION_REFRESH_WIDGET_ALARM
            val sender =
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val alarm = application.getSystemService(ALARM_SERVICE) as AlarmManager?
            alarm?.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                autoRefreshMs,
                autoRefreshMs,
                sender
            )
        }

    }
}