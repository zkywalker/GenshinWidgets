package org.zky.genshinwidgets.widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

class PinBroadcastReceiver() : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) {
            return
        }
        val widgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1)
        if (widgetId == -1) {
            return
        }

        val widgetName = intent.getStringExtra("WIDGET_NAME")
        Log.i("PinBroadcastReceiver", "widgetName: $widgetName")
//        val widgetPreferences = WidgetPreferences(context)
//        widgetPreferences.setWidgetValues(widgetId, widgetName)
//        DemoWidgetProvider.updateWidgets(context)
        onPinListener(widgetId)
    }

    companion object {

        fun obtainPendingIntent(
            context: Context,
        ): PendingIntent {
            val intent = Intent(context, PinBroadcastReceiver::class.java)
//            pinnedWidgetCallbackIntent.action = "org.zky.genshinwidgets.PinBroadcastReceiver"
            val bundle = Bundle()
            bundle.putString("WIDGET_NAME", "hello world")
            intent.putExtras(bundle)

            return PendingIntent.getBroadcast(context, 123456, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        var onPinListener: (Int) -> Unit = {}

    }

    data class PinInfo(val widgetId: Int)

}
