package org.zky.genshinwidgets.model

import org.zky.genshinwidgets.Account
import org.zky.genshinwidgets.GameRole

fun List<GameRole>.convertToUserRoles(): List<UserRole> {
    return map {
        UserRole(
            game_uid = it.game_uid,
            game_biz = it.game_biz,
            region = it.region,
            region_name = it.region_name,
            nickname = it.nickname,
            level = it.level?.toString() ?: "",
            is_chosen = it.is_chosen ?: false,
            is_official = it.is_official ?: false,
            account_id = it.account_id,
            sign_date = it.sign_date ?: 0,
        )
    }
}

fun Account.getTypeName(): String {
    return when (type) {
        "miyoushe" -> "米游社"
        else -> "未知平台"
    }
}