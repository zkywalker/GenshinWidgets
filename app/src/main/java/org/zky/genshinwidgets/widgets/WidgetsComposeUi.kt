package org.zky.genshinwidgets.widgets

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.action.actionParametersOf
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.main.MainActivity
import org.zky.genshinwidgets.main.secondsToTime2
import org.zky.genshinwidgets.model.*
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.widgets.GlanceCallbackAction.Companion.ACTION_REQUEST_DAILY_NOTE
import org.zky.genshinwidgets.widgets.GlanceCallbackAction.Companion.ACTION_REQUEST_SIGN
import java.text.SimpleDateFormat
import java.util.*

// glance cant support compose preview?

val normalTextStyle = TextStyle(color = ColorProvider(Color.White), fontSize = 13.sp)

val finishTextStyle = TextStyle(color = ColorProvider(color.explored), fontSize = 13.sp)

//var signDate: String by PreferenceDelegate(SpCst.KEY_SIGN_DATE, "")

val format = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)

fun Date?.isSameDate(): Boolean {
    return this != null && format.format(this) == Date().format()
}

@Composable
fun WidgetMain(
    model: DailyNote?,
    role: UserRole? = null,
    image: String?
) {
    val action = actionRunCallback<GlanceCallbackAction>(
        actionParametersOf(GenshinDailyNoteWidget.ACTION_PARAMETERS_KEY to ACTION_REQUEST_DAILY_NOTE)
    )

    val actionSign = actionRunCallback<GlanceCallbackAction>(
        actionParametersOf(GenshinDailyNoteWidget.ACTION_PARAMETERS_KEY to ACTION_REQUEST_SIGN)
    )
    val actionLaunchApp = if (TextUtils.isEmpty(Config.launchTarget)) {
        actionStartActivity(MainActivity::class.java)
    } else {
        actionStartActivity(
            WakeAppActivity::class.java,
            actionParametersOf(GenshinDailyNoteWidget.ACTION_PARAMETERS_PACKAGE to Config.launchTarget)
        )
    }
    Box(modifier = GlanceModifier.size(160.dp)) {
        val fileToBitmap = fileToBitmap(image)
        if (fileToBitmap != null) {
            Image(
                provider = ImageProvider(fileToBitmap),
                contentDescription = "",
                modifier = GlanceModifier.fillMaxSize().appWidgetBackground(),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                provider = ImageProvider(R.drawable.bg_widget_def_c14),
                contentDescription = "",
                modifier = GlanceModifier.fillMaxSize().appWidgetBackground(),
            )
        }
        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(10.dp)
//            .background(imageProvider = ImageProvider(R.drawable.bg_widget_def_c14))
                .clickable(actionLaunchApp),
            contentAlignment = Alignment.TopEnd
        ) {
            if (model == null) {
                Box(modifier = GlanceModifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "no data,click to refresh",
                        modifier = GlanceModifier
                            .fillMaxSize()
                            .padding(10.dp)
                            .clickable(onClick = action),
                        style = normalTextStyle
                    )
                }
            } else {
                Column(modifier = GlanceModifier.fillMaxSize()) {
                    val resinTime = if (model.current_resin != model.max_resin) {
                        "  ${secondsToTime2(model.resin_recovery_time)}后回满"
                    } else {
                        ""
                    }
                    val richesTime = if (model.current_home_coin != model.max_home_coin) {
                        "  ${secondsToTime2(model.home_coin_recovery_time)}后存满"
                    } else {
                        ""
                    }
                    RecordItem(
                        icon = R.drawable.ic_fragile_resin,
                        text = "${model.current_resin}/${model.max_resin}",
                        subText = resinTime,
                        style = if (model.current_resin == model.max_resin) finishTextStyle else normalTextStyle
                    )
                    RecordItem(
                        icon = R.drawable.ic_jar_of_riches,
                        text = "${model.current_home_coin}/${model.max_home_coin}",
                        subText = richesTime,
                        style = if (model.current_home_coin == model.max_home_coin) finishTextStyle else normalTextStyle
                    )
                    var taskDefString = "${model.finished_task_num}/${model.total_task_num}"
                    var taskDefTextStyle = normalTextStyle
                    when {
                        model.is_extra_task_reward_received -> taskDefString =
                            getString(R.string.has_received_reward)
                        model.finished_task_num == model.total_task_num -> taskDefTextStyle =
                            finishTextStyle
                    }
                    Row {
                        RecordItem(
                            modifier = GlanceModifier.padding(end = 2.dp),
                            icon = R.drawable.ic_commision,
                            text = taskDefString,
                            style = taskDefTextStyle
                        )
                        RecordItem(
                            modifier = GlanceModifier.padding(end = 2.dp),
                            icon = R.drawable.ic_domain,
                            text = "${model.remain_resin_discount_num}/${model.resin_discount_num_limit}",
                            style = if (model.remain_resin_discount_num == model.resin_discount_num_limit) {
                                finishTextStyle
                            } else {
                                normalTextStyle
                            }
                        )
                    }
                    RecordItem(
                        icon = R.drawable.ic_parametric_transformer,
                        text = model.transformer.getMessage(),
                        style = model.transformer.getTextStyle()
                    )

                    val activityContentInfos = model.activityContentInfo
                    if (activityContentInfos != null && activityContentInfos.isNotEmpty()) {
                        Row {
                            activityContentInfos.forEach { item ->
                                ActivityContentView(item)
                                Log.d("widget", "activityContentInfos: $item")
                            }
                        }
                    }
                    // spacer to make the bottom of the widget look good
                    if (model.expeditions.isEmpty()) {
                        Spacer(GlanceModifier.height(25.dp))
                    } else {
                        Row {
                            model.expeditions.forEach { item -> ExpeditionDetailView(item) }
                        }
                    }
                }

                Box(
                    modifier = GlanceModifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = GlanceModifier.height(15.dp).clickable(onClick = action),
                    ) {
                        Image(
                            ImageProvider(R.drawable.ic_baseline_refresh_24),
                            contentDescription = "refresh",
                            modifier = GlanceModifier
                                .size(15.dp)
                        )
                        // todo its not stable, cuz it will refresh when recompose
                        Text(
                            text = Date().format(),
                            style = TextStyle(
                                color = ColorProvider(Color.White),
                                fontSize = 10.sp
                            ),
                        )
                    }
                    Row(
                        horizontalAlignment = Alignment.End,
                        modifier = GlanceModifier.fillMaxWidth(),
                    ) {
                        if (Config.showUID && role != null) {
                            Text(
                                text = "UID:${role.game_uid}",
                                style = TextStyle(
                                    color = ColorProvider(color.white_70),
                                    fontSize = 10.sp
                                ),
                                modifier = GlanceModifier
                                    .padding(top = 5.dp)
                                    .clickable(onClick = actionSign)
                            )
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun ActivityContentView(item: ActivityContentInfo) {
    val bitmap = imageUrlToBitmap(item.icon)
    if (bitmap != null) {
        Image(
            ImageProvider(bitmap),
            contentDescription = item.title,
            modifier = GlanceModifier.size(19.dp).padding(end = 3.dp, top = 3.dp)
        )
    } else {
        Image(
            ImageProvider(R.drawable.ic_baseline_refresh_24),
            contentDescription = "refresh",
            modifier = GlanceModifier
                .size(20.dp)
        )
    }
}

@Composable
fun ExpeditionDetailView(item: ExpeditionDetail) {
    val bitmap = imageUrlToBitmap(item.avatar_side_icon)
//    Log.i("kyle", "load image = $bitmap")
    Box(
        modifier = GlanceModifier.size(25.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        val bgRes = when (item.status) {
            "Ongoing" -> R.drawable.bg_widget_item_exploring
            "Finished" -> R.drawable.bg_widget_item_explored
            else -> R.drawable.shape_c100_s1_fff
        }
        Image(
            provider = ImageProvider(bgRes),
            modifier = GlanceModifier.size((25 * 0.65).dp),
            contentDescription = "expedition status"
        )
        if (bitmap != null) {
            Image(
                provider = ImageProvider(bitmap),
                modifier = GlanceModifier.size(25.dp).padding(bottom = 1.dp),
                contentDescription = "avatar"
            )
        }
    }
}

@Composable
fun RecordItem(
    modifier: GlanceModifier = GlanceModifier,
    icon: Int,
    text: String,
    style: TextStyle,
    subText: String = ""
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            provider = ImageProvider(icon),
            modifier = GlanceModifier
                .size(19.dp)
                .padding(end = 3.dp),
            contentDescription = text
        )
        Text(text = text, style = style)
        if (!TextUtils.isEmpty(subText)) {
            Text(text = subText, style = style.copy(fontSize = 9.sp))
        }
    }
}