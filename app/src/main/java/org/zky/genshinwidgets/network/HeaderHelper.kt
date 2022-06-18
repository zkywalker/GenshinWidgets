package org.zky.genshinwidgets.network

import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.utils.MD5
import org.zky.genshinwidgets.utils.loginCookie
import java.util.*

object HeaderHelper {

    val deviceId = UUID.nameUUIDFromBytes(loginCookie.toByteArray()).toString().replace("-", "")
        .uppercase()

    fun getRandomCode(): String = "${((Math.random() + 1) * 100000).toInt()}"

    fun getTs(): String = "${Date().time / 1000}"

    fun getDs(): String {
        val ts = getTs()
        val random = getRandomCode()
        val check = MD5("salt=${ApiCst.BBS_SALT_WEB_OLD}&t=$ts&r=$random")
        return "$ts,$random,$check"
    }
}