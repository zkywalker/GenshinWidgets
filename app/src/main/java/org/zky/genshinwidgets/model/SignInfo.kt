package org.zky.genshinwidgets.model

// {data={total_sign_day=18.0, today=2022-05-26, is_sign=true, first_bind=false, is_sub=false, month_first=false, sign_cnt_missed=8.0}, message=OK, retcode=0.0}
data class SignInfo(
    val total_sign_day: Int,
    val today: String,
    val is_sign: Boolean,
    val first_bind: Boolean,
    val is_sub: Boolean,
    val month_first: Boolean,
    val sign_cnt_missed: Int,
)