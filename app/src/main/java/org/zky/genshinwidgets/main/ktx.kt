package org.zky.genshinwidgets.main

import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.model.GetUserRole
import org.zky.genshinwidgets.model.UserRole

fun GetUserRole.findGenshinRole():UserRole? = list.firstOrNull {
    ApiCst.GAME_BIZ_GENSHIN == it.game_biz && ApiCst.REGION_GENSHIN == it.region
}