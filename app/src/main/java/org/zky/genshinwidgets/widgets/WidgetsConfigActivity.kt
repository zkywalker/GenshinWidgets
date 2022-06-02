package org.zky.genshinwidgets.widgets

import android.appwidget.AppWidgetManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.glance.action.actionParametersOf
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.launch
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.main.DefaultCard
import org.zky.genshinwidgets.main.MainActivity
import org.zky.genshinwidgets.model.WidgetsConfigModel
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.utils.getString
import org.zky.genshinwidgets.utils.loginCookie
import org.zky.genshinwidgets.utils.startActivity
import org.zky.genshinwidgets.utils.toast

class WidgetsConfigActivity : AppCompatActivity() {

    private var mAppWidgetId: Int = AppWidgetManager.INVALID_APPWIDGET_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras?.also {
            mAppWidgetId = it.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        } ?: kotlin.run {
            mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
        }

        setContent {
            MaterialTheme(colors = MaterialTheme.colors.copy(primary = color.primary)) {
                RootView(mAppWidgetId, onConfirmClick, onHomeClick) {
                    finish()
                }
            }
        }
    }

    private val onHomeClick: () -> Unit = {
        startActivity<MainActivity>()
        finish()
    }

    private val onConfirmClick: (WidgetsConfigModel) -> Unit = {
        lifecycleScope.launch {
            Config.launchTarget = it.targetLaunchApp

            val ids = GlanceAppWidgetManager(this@WidgetsConfigActivity).getGlanceIds(
                GenshinDailyNoteWidget::class.java
            )
            if (ids.isEmpty()) {
                R.string.add_widget_fialed.toast()
                finish()
                return@launch
            }
            val curId = ids.last()
            GlanceCallbackAction().onRun(this@WidgetsConfigActivity, curId, actionParametersOf())
            val resultIntent = Intent()
            resultIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId)
            setResult(RESULT_OK, resultIntent)
            finish()
            // todo auto refresh seems not work when app died -_-
//            GlanceReceiver.startRefreshAlarm(application, WidgetsConfig.autoRefreshMs)
        }
    }
}


val launchTargets = arrayOf(
    getString(R.string.current_app) to "",
    getString(R.string.genshin) to ApiCst.APP_PACKAGE_NAME_GENSHIN,
    getString(R.string.yun_genshin) to ApiCst.APP_PACKAGE_NAME_GENSHIN_CLOUD,
    getString(R.string.miyoushe) to ApiCst.APP_PACKAGE_NAME_BBS,
)

@Composable
private fun RootView(
    widgetId: Int,
    onConfirmClick: (WidgetsConfigModel) -> Unit,
    onHomeClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = getString(R.string.config_widget)) },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable(onClick = onBackClick)
                )
            }
        )
    }) {
        var target by remember { mutableStateOf(launchTargets[0].first) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            DefaultCard(
                text = getString(R.string.click_widget_launch),
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                FlowRow {
                    launchTargets.forEach {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(selected = target == it.first, onClick = {
                                target = it.first
                            })
                            Text(text = it.first)
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(loginCookie)) {
                Button(onHomeClick) {
                    Text(getString(R.string.login_plz))
                }
            } else if (widgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                Text(getString(R.string.did_not_add_widget))
            } else {
                Button(onClick = {
                    onConfirmClick(
                        WidgetsConfigModel(
                            launchTargets.find { it.first == target }!!.second
                        )
                    )
                }) {
                    Text(getString(R.string.save_config))
                }
            }
        }
    }
}
