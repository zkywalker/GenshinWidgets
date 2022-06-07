package org.zky.genshinwidgets.widgets

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.ui.unit.TextUnit
import androidx.datastore.preferences.core.MutablePreferences
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.*
import androidx.glance.unit.ColorProvider
import org.zky.genshinwidgets.utils.application
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
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

suspend inline fun <reified T : GlanceAppWidget> Context.getGlanceIds(): List<Int> {
    return GlanceAppWidgetManager(this).getGlanceIds(T::class.java)
        .map { it.getId() }
}

fun GlanceId.getId(): Int {
    return GlanceIdUtils.getId(this)
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

fun Bitmap.save(imageName: String): File {
    val dir =
        File("${application.cacheDir.absolutePath}${File.separator}files${File.separator}img${File.separator}")
    if (!dir.exists()) {
        dir.mkdirs()
    }
    val file =
        File("${application.cacheDir.absolutePath}${File.separator}files${File.separator}img${File.separator}${imageName}")
    if (file.exists() && file.length() > 0) return file
    try {
        val out = FileOutputStream(file)
        compress(Bitmap.CompressFormat.PNG, 90, out)
        out.flush()
        out.close()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return file
}