package org.zky.genshinwidgets.model

data class UserRole(
    val game_biz: String,
    val region: String,
    val game_uid: String,
    val nickname: String,
    val level: String,
    val is_chosen: Boolean,
    val region_name: String,
    val is_official: Boolean,
    var account_id: String = "",
)