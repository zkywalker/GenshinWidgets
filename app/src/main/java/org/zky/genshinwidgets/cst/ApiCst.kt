package org.zky.genshinwidgets.cst

object ApiCst {

    const val API_VERSION_JSON = "https://raw.githubusercontent.com/zkywalker/GenshinWidgets/main/version.json"

    const val API_URL_GAME_ACTIVITY =
        "https://api-static.mihoyo.com/common/blackboard/ys_obc/v1/get_activity_calendar?app_sn=ys_obc"

    const val MIHOYO_API = "https://api-takumi.mihoyo.com"

    const val MIHOYO_RECORD_API = "https://api-takumi-record.mihoyo.com"

    const val MIHOYO_BBS_LOGIN = "https://m.bbs.mihoyo.com/ys/#/login"

    const val REQUEST_PATH_GET_USER_ROLE = "/binding/api/getUserGameRolesByCookie"

    const val REQUEST_PATH_GET_GAME_RECORD = "/game_record/app/genshin/api/dailyNote"

    const val REQUEST_PATH_SIGN = "/event/bbs_sign_reward/sign"

    const val REQUEST_PATH_SIGN_INFO = "/event/bbs_sign_reward/info"

    const val REQUEST_PATH_SIGN_REWARD = "/event/bbs_sign_reward/home"

    const val REQUEST_PATH_GET_CHARACTER = "/game_record/app/genshin/api/character"

    const val WEB_URL_TODAY_MATERIAL =
        "https://bbs.mihoyo.com/ys/obc/channel/map/193?bbs_presentation_style=no_header&visit_device=mobile"

    const val WEB_URL_ROLE_WIKI =
        "https://bbs.mihoyo.com/ys/obc/channel/map/189/25?bbs_presentation_style=no_header&visit_device=mobile"

    const val WEB_URL_GENSHIN_MAP =
        "https://webstatic.mihoyo.com/ys/app/interactive-map/index.html?bbs_presentation_style=no_header&lang=zh-cn&_markerFps=24#/map/2?shown_types=&center=1303.00,530.00&zoom=-2.00"

    const val WEB_URL_OVERVIEW = "https://webstatic.mihoyo.com/app/community-game-records/index.html#/ys"

    const val WEB_URL_MY_CHAR = "https://webstatic.mihoyo.com/app/community-game-records/index.html?bbs_presentation_style=fullscreen#/ys/role/all?role_id=165255180&server=cn_gf01&access=1"

    const val WEB_URL_JOURNAL = "https://webstatic.mihoyo.com/ys/event/e20200709ysjournal/index.html?bbs_presentation_style=fullscreen&bbs_auth_required=true&mys_source=GameRecord#/"

    const val WEB_URL_DAILY_NOTE = "https://webstatic.mihoyo.com/app/community-game-records/index.html?bbs_presentation_style=fullscreen#/ys/daily/?role_id=165255180&server=cn_gf01"

    const val GENSHIN_ACT_ID = "e202009291139501"

    const val GAME_BIZ_GENSHIN = "hk4e_cn"

    const val REGION_GENSHIN = "cn_gf01"

    const val SALT: String = "xV8v4Qu54lUKrEYFZkJhB8cuOh9Asafs"

    const val BBS_SALT_WEB_OLD = "h8w582wxwgqvahcdkpvdhbh2w9casgfl"

    const val APP_PACKAGE_NAME_GENSHIN = "com.miHoYo.Yuanshen"

    const val APP_PACKAGE_NAME_BBS = "com.mihoyo.hyperion"

    const val APP_PACKAGE_NAME_GENSHIN_CLOUD = "com.miHoYo.cloudgames.ys"

    const val UA_ANDROID =
        "Mozilla/5.0 (Linux; U; Android 9; zh-cn; Redmi Note 5 Build/PKQ1.180904.001) AppleWebKit/537.36 (KHTML, like Gecko)  miHoYoBBS/2.28.1"

    const val UA_IPHONE =
        "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.28.1"
}