package org.zky.genshinwidgets.widgets

import android.text.TextUtils
import android.util.Log
import android.util.SparseArray
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.*
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.layout.*
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.Text
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.model.DailyNote
import org.zky.genshinwidgets.utils.fileToBitmap
import org.zky.genshinwidgets.utils.fromJson
import org.zky.genshinwidgets.utils.fromJsonOrNull

class GenshinDailyNoteWidget : GlanceAppWidget() {

    override val sizeMode = SizeMode.Exact

    override var stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    @Composable
    override fun Content() {
        val preferencesState = currentState<Preferences>()
//        if (preferencesState[booleanPreferencesKey("is_login")] != true) {
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = GlanceModifier
//                    .clickable(actionStartActivity(MainActivity::class.java))
//            ) {
//                Text(text = getString(R.string.did_not_login), style = normalTextStyle)
//            }
//            return
//        }
        preferencesState.runCatching {
            val dailyNote = preferencesState[stringPreferencesKey(PRE_DATA_DAILY_NOTE)] ?: ""
            val userRole = preferencesState[stringPreferencesKey(PRE_DATA_ROLE_INFO)] ?: ""
            val image = preferencesState[stringPreferencesKey(PRE_DATA_BG_IMAGE)] ?: ""

//            Log.i("kyle", "dailyNote = $dailyNote, userRole = $userRole, activityContentInfos = $activityContentInfos, image = $image")
            WidgetMain(dailyNote.fromJsonOrNull(), userRole.fromJsonOrNull(), image)
        }
    }


    companion object {

        val PRE_DATA_DAILY_NOTE = "pre_data_daily_note"
        val PRE_DATA_ROLE_INFO = "pre_data_role_info"
        val PRE_DATA_ACTIVITY = "pre_data_activity_content"
        val PRE_DATA_BG_IMAGE = "pre_data_image_file"

        val ACTION_PARAMETERS_KEY = ActionParameters.Key<String>("parameters_keys")
        val ACTION_PARAMETERS_PACKAGE = ActionParameters.Key<String>("package_name")
        val ACTION_PARAMETERS_BG = ActionParameters.Key<String>("parameters_bg")

        private val SMALL_BOX = DpSize(90.dp, 90.dp)
        private val BIG_BOX = DpSize(180.dp, 180.dp)
        private val VERY_BIG_BOX = DpSize(300.dp, 300.dp)
        private val ROW = DpSize(180.dp, 48.dp)
        private val LARGE_ROW = DpSize(300.dp, 48.dp)
        private val COLUMN = DpSize(48.dp, 180.dp)
        private val LARGE_COLUMN = DpSize(48.dp, 300.dp)
    }
}