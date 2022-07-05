package org.zky.genshinwidgets.model

data class GetGameActivity(val list: List<GameActivity>)

//{
//        "title": "今天是丽莎的生日！",
//        "kind": "4",
//        "img_url": "",
//        "jump_type": "2",
//        "jump_url": "",
//        "content_id": "92",
//        "style": "0",
//        "start_time": "1623168000",
//        "end_time": "1623254399",
//        "font_color": "",
//        "padding_color": "",
//        "drop_day": [
//
//        ],
//        "break_type": "0",
//        "id": "1",
//        "contentInfos": [
//
//        ],
//        "sort": "",
//        "contentSource": [
//
//        ]
//      }
data class GameActivity(
    val title: String,
    val kind: String,
    val img_url: String,
    val jump_type: String,
    val jump_url: String,
    val content_id: String,
    val style: String,
    val start_time: String, // 活动开始时间
    val end_time: String, // 活动结束时间
    val font_color: String,
    val padding_color: String,
    val drop_day: List<String>,
    val break_type: String, // 1.武器 2.人物
    val id: String,
    val contentInfos: List<ActivityContentInfo>,
    val sort: String,
    val contentSource: List<ActivityContentSource>
)

 sealed class ActivityKind(val type: String, val name: String) {

    // 4 生日 2 人物/武器 1 活动
    object Birthday : ActivityKind("4", "生日")
    object Foster : ActivityKind("2", "培养")
    object LimitedTime : ActivityKind("1", "限时任务")

}

//{
//            "content_id": 833,
//            "title": "「勤劳」的教导",
//            "icon": "https://uploadstatic.mihoyo.com/ys-obc/2020/07/01/80410800/12f2a859b67f466b283098b1b018a898_8110279582179675735.png",
//            "bbs_url": ""
//          }
data class ActivityContentInfo(
    val content_id: Int,
    val title: String,
    val icon: String,
    val bbs_url: String
)

//{
//            "content_id": 2291,
//            "title": "菫色之庭",
//            "icon": "https://uploadstatic.mihoyo.com/ys-obc/2021/07/11/79683714/b59bb5e853bb855c7194d60480f7c069_3403329664126743175.png",
//            "bbs_url": ""
//          }
data class ActivityContentSource(
    val content_id: Int,
    val title: String,
    val icon: String,
    val bbs_url: String
)