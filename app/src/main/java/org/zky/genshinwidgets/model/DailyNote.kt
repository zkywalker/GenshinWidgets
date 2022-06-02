package org.zky.genshinwidgets.model

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.ui.graphics.Color
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.res.color
import org.zky.genshinwidgets.utils.application

/**
 * {
 * data={
 * current_resin=145.0, max_resin=160.0,
 * resin_recovery_time=6802, finished_task_num=0.0, total_task_num=4.0, is_extra_task_reward_received=false,
 * remain_resin_discount_num=3.0, resin_discount_num_limit=3.0, current_expedition_num=5.0, max_expedition_num=5.0,
 * expeditions=[{avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Ambor.png, status=Ongoing, remained_time=8835}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Chongyun.png, status=Finished, remained_time=0}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Keqing.png, status=Finished, remained_time=0}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Sara.png, status=Finished, remained_time=0}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Bennett.png, status=Finished, remained_time=0}],
 * current_home_coin=1050.0, max_home_coin=2400.0, home_coin_recovery_time=160249, calendar_url=,
 * transformer={obtained=true, recovery_time={Day=6.0, Hour=0.0, Minute=0.0, Second=0.0, reached=false}, wiki=https://bbs.mihoyo.com/ys/obc/content/1562/detail?bbs_presentation_style=no_header}
 * },
 * message=OK, retcode=0.0
 * }
 */
data class DailyNote(
    val current_resin: Int,
    val max_resin: Int,
    val resin_recovery_time: Long,
    val finished_task_num: Int,
    val total_task_num: Int,
    val is_extra_task_reward_received: Boolean,
    val remain_resin_discount_num: Int,
    val resin_discount_num_limit: Int,
    val current_expedition_num: Int,
    val max_expedition_num: Int,
    val expeditions: List<ExpeditionDetail>,
    val current_home_coin: Int,
    val max_home_coin: Int,
    val home_coin_recovery_time: Long,
    val calendar_url: String,
    val transformer: Transformer,
)

//{avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Ambor.png, status=Ongoing, remained_time=8835}
data class ExpeditionDetail(
    val avatar_side_icon: String,
    val status: String,
    val remained_time: Long,
)

//{obtained=true, recovery_time={Day=6.0, Hour=0.0, Minute=0.0, Second=0.0, reached=false}, wiki=https://bbs.mihoyo.com/ys/obc/content/1562/detail?bbs_presentation_style=no_header}
data class Transformer(
    val obtained: Boolean,
    val recovery_time: TransformerRecoveryTime,
    val wiki: String,
)

data class TransformerRecoveryTime(
    val Day: Int,
    val Hour: Int,
    val Minute: Int,
    val Second: Int,
    val reached: Boolean,
)

fun Transformer.getMessage(): String {
    if (!obtained) {
        return application.getString(R.string.unavailable)
    }
    if (recovery_time.reached) {
        return application.getString(R.string.reached)
    }
    return recovery_time.run {
        val stringBuilder = StringBuilder()
        if (Day != 0) {
            stringBuilder.append("$Day Day")
        }
        if (Hour != 0) {
            if (stringBuilder.isNotEmpty()) {
                stringBuilder.append("/")
            }
            stringBuilder.append("$Hour Hour")
        }
        if (Minute != 0) {
            if (stringBuilder.isNotEmpty()) {
                stringBuilder.append("/")
            }
            stringBuilder.append("$Minute Min")
        }
        stringBuilder.toString()
    }
}

fun Transformer.getTextStyle(): TextStyle {
    if (!obtained) {
        return TextStyle(color = ColorProvider(color.error))
    }
    if (recovery_time.reached) {
        return TextStyle(color = ColorProvider(color.explored))
    }
    return TextStyle(color = ColorProvider(Color.White))
}