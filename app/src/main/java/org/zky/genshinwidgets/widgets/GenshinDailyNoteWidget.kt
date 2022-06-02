package org.zky.genshinwidgets.widgets

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.size
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.Text
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.main.MainActivity
import org.zky.genshinwidgets.model.DailyNote
import org.zky.genshinwidgets.utils.fromJson
import org.zky.genshinwidgets.utils.getString

class GenshinDailyNoteWidget : GlanceAppWidget() {

    override val sizeMode = SizeMode.Single

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
        val data = preferencesState[stringPreferencesKey("data")] ?: ""
        Log.i("kyle", "data = $data")
        Column(GlanceModifier.size(150.dp, 150.dp)) {
            if (TextUtils.isEmpty(data)) {
                WidgetMain(null)
            } else {
                WidgetMain(data.fromJson<DailyNote>())
            }
        }
    }


    companion object {
        val ACTION_PARAMETERS_KEY = ActionParameters.Key<String>("parameters_keys")
        val ACTION_PARAMETERS_PACKAGE = ActionParameters.Key<String>("package_name")

        private val SMALL_BOX = DpSize(90.dp, 90.dp)
        private val BIG_BOX = DpSize(180.dp, 180.dp)
        private val VERY_BIG_BOX = DpSize(300.dp, 300.dp)
        private val ROW = DpSize(180.dp, 48.dp)
        private val LARGE_ROW = DpSize(300.dp, 48.dp)
        private val COLUMN = DpSize(48.dp, 180.dp)
        private val LARGE_COLUMN = DpSize(48.dp, 300.dp)
    }
}