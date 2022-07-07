package org.zky.genshinwidgets.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.model.DailyNote
import org.zky.genshinwidgets.model.ExpeditionDetail
import org.zky.genshinwidgets.model.Transformer
import org.zky.genshinwidgets.model.getMessage
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.res.font
import org.zky.genshinwidgets.res.themes
import org.zky.genshinwidgets.utils.getString


fun secondsToTime(seconds: Long): String {
    val h = seconds / 3600 //小时
    val m = seconds % 3600 / 60 //分钟
    val s = seconds % 3600 % 60 //秒
    if (h > 0) {
        return h.toString() + "小时" + m + "分钟" + s + "秒"
    }
    return if (m > 0) {
        m.toString() + "分钟" + s + "秒"
    } else s.toString() + "秒"
}

fun secondsToTime2(seconds: Long): String {
    val h = seconds / 3600 //小时
    val m = seconds % 3600 / 60 //分钟
    val s = seconds % 3600 % 60 //秒
    if (h > 24) {
        return "${h / 24}d"
    }
    if (h > 0) {
        return "$h:$m"
    }
    return if (m > 0) {
        m.toString() + "m"
    } else s.toString() + "s"
}

@Composable
fun DailyNoteView(model: DailyNote) {
    val normalTextStyle = themes.colors.textPrimary
    val finishTextStyle = color.explored
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            val resinTime = if (model.current_resin != model.max_resin) {
                "  ${secondsToTime(model.resin_recovery_time)}后恢复满"
            } else {
                ""
            }
            RecordItem(
                modifier = Modifier.padding(bottom = 5.dp),
                icon = R.drawable.ic_fragile_resin,
                text = "${model.current_resin}/${model.max_resin}${resinTime}",
                style = if (model.current_resin == model.max_resin) finishTextStyle else normalTextStyle
            )
            val richesTime = if (model.current_home_coin != model.max_home_coin) {
                "  ${secondsToTime(model.home_coin_recovery_time)}后恢复满"
            } else {
                ""
            }
            RecordItem(
                modifier = Modifier.padding(bottom = 5.dp),
                icon = R.drawable.ic_jar_of_riches,
                text = "${model.current_home_coin}/${model.max_home_coin}${richesTime}",
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
            Row(modifier = Modifier.padding(bottom = 5.dp)) {
                RecordItem(
                    modifier = Modifier.padding(end = 15.dp),
                    icon = R.drawable.ic_commision,
                    text = taskDefString,
                    style = taskDefTextStyle
                )
                RecordItem(
                    modifier = Modifier.padding(end = 15.dp),
                    icon = R.drawable.ic_domain,
                    text = "${model.remain_resin_discount_num}/${model.resin_discount_num_limit}",
                    style = if (model.remain_resin_discount_num == model.resin_discount_num_limit) {
                        finishTextStyle
                    } else {
                        normalTextStyle
                    }
                )
                RecordItem(
                    modifier = Modifier.padding(end = 15.dp),
                    icon = R.drawable.ic_parametric_transformer,
                    text = model.transformer.getMessage(),
                    style = model.transformer.getTextColor()
                )
            }
            // spacer to make the bottom of the widget look good
            if (model.expeditions.isEmpty()) {
                Spacer(Modifier.height(25.dp))
            } else {
                Row {
                    model.expeditions.forEach { item ->
                        ExpeditionDetailView(
                            modifier = Modifier.padding(
                                end = 5.dp
                            ), item
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExpeditionDetailView(modifier: Modifier = Modifier, item: ExpeditionDetail) {
    val bgRes = when (item.status) {
        "Ongoing" -> color.exploring
        "Finished" -> color.explored
        else -> Color.White
    }
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(25.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .size((25 * 0.65).dp)
                    .border(1.dp, color = bgRes, CircleShape)
            )
            Image(
                painter = rememberImagePainter(data = item.avatar_side_icon),
                modifier = Modifier
                    .padding(bottom = 1.dp)
                    .size(25.dp),
                contentDescription = "avatar"
            )
        }
        val text = if (item.status == "Ongoing") {
            secondsToTime2(item.remained_time)
        } else {
            getString(R.string.complete)
        }
        Text(text = text, fontSize = font.bodyS, color = bgRes)
    }

}

@Composable
fun RecordItem(modifier: Modifier = Modifier, icon: Int, text: String, style: Color) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(icon),
            modifier = Modifier
                .size(20.dp)
                .padding(end = 5.dp),
            contentDescription = text
        )
        Text(text = text, color = style)
    }
}

@Composable
fun Transformer.getTextColor(): Color {
    if (!obtained) {
        return color.error
    }
    if (recovery_time.reached) {
        return color.explored
    }
    return themes.colors.textPrimary
}