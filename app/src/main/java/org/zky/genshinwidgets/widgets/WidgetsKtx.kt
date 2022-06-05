package org.zky.genshinwidgets.widgets

import android.content.Context
import androidx.compose.ui.unit.TextUnit
import androidx.datastore.preferences.core.MutablePreferences
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider
import java.text.SimpleDateFormat
import java.util.*


fun Date.format(format: String = "HH:mm:ss"): String {
    return SimpleDateFormat(format, Locale.CHINA).format(this)
}

// this function seems to be useless -_-
suspend fun updateWidget(
    context: Context,
    glanceId: GlanceId,
    updateState: suspend (MutablePreferences) -> Unit,
) {
    updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
        return@updateAppWidgetState it.toMutablePreferences().apply {
            updateState(it.toMutablePreferences())
        }
    }
}

suspend inline fun <reified T:GlanceAppWidget> Context.getGlanceIds(): List<Int> {
    return GlanceAppWidgetManager(this).getGlanceIds(T::class.java).map { GlanceFxxker.getAppWidgetId(it) }
}

fun TextStyle.copy(
    color: ColorProvider? = null,
    fontSize: TextUnit? = null,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    textAlign: TextAlign? = null,
    textDecoration: TextDecoration? = null,
) = TextStyle(
    color ?: this.color,
    fontSize ?: this.fontSize,
    fontWeight ?: this.fontWeight,
    fontStyle ?: this.fontStyle,
    textAlign ?: this.textAlign,
    textDecoration ?: this.textDecoration
)
