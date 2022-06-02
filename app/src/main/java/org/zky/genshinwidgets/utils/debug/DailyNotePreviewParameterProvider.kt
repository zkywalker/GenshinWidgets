package org.zky.genshinwidgets.utils.debug

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import org.zky.genshinwidgets.model.DailyNote
import org.zky.genshinwidgets.model.ExpeditionDetail
import org.zky.genshinwidgets.model.Transformer
import org.zky.genshinwidgets.model.TransformerRecoveryTime


// github copilot YYDS!!!!

// * current_resin=145.0, max_resin=160.0,
// * resin_recovery_time=6802, finished_task_num=0.0, total_task_num=4.0, is_extra_task_reward_received=false,
// * remain_resin_discount_num=3.0, resin_discount_num_limit=3.0, current_expedition_num=5.0, max_expedition_num=5.0,
// * expeditions=[{avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Ambor.png, status=Ongoing, remained_time=8835}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Chongyun.png, status=Finished, remained_time=0}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Keqing.png, status=Finished, remained_time=0}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Sara.png, status=Finished, remained_time=0}, {avatar_side_icon=https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Bennett.png, status=Finished, remained_time=0}],
// * current_home_coin=1050.0, max_home_coin=2400.0, home_coin_recovery_time=160249, calendar_url=,
// * transformer={obtained=true, recovery_time={Day=6.0, Hour=0.0, Minute=0.0, Second=0.0, reached=false}, wiki=https://bbs.mihoyo.com/ys/obc/content/1562/detail?bbs_presentation_style=no_header}
// * },
class DailyNotePreviewParameterProvider : PreviewParameterProvider<DailyNote> {
    override val values = sequenceOf(
        DailyNote(
            current_resin = 145,
            max_resin = 160,
            resin_recovery_time = 6802,
            finished_task_num = 0,
            total_task_num = 4,
            is_extra_task_reward_received = false,
            remain_resin_discount_num = 3,
            resin_discount_num_limit = 3,
            current_expedition_num = 5,
            max_expedition_num = 5,
            expeditions = listOf(
                ExpeditionDetail(
                    avatar_side_icon = "https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Ambor.png",
                    status = "Ongoing",
                    remained_time = 8835
                ),
                ExpeditionDetail(
                    avatar_side_icon = "https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Chongyun.png",
                    status = "Finished",
                    remained_time = 0
                ),
                ExpeditionDetail(
                    avatar_side_icon = "https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Keqing.png",
                    status = "Finished",
                    remained_time = 0
                ),
                ExpeditionDetail(
                    avatar_side_icon = "https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Sara.png",
                    status = "Finished",
                    remained_time = 0
                ),
                ExpeditionDetail(
                    avatar_side_icon = "https://upload-bbs.mihoyo.com/game_record/genshin/character_side_icon/UI_AvatarIcon_Side_Bennett.png",
                    status = "Finished",
                    remained_time = 0
                )
            ),
            current_home_coin = 1050,
            max_home_coin = 2400,
            home_coin_recovery_time = 160249,
            calendar_url = "",
            transformer = Transformer(
                obtained = true,
                recovery_time = TransformerRecoveryTime(
                    Day = 6,
                    Hour = 0,
                    Minute = 0,
                    Second = 0,
                    reached = false
                ),
                wiki = "https://bbs.mihoyo.com/ys/obc/content/1562/detail?bbs_presentation_style=no_header"
            )
        )
    )
}