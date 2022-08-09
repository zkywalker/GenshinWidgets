package org.zky.genshinwidgets.network

import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.database.DatabaseStore
import org.zky.genshinwidgets.utils.MD5
import java.util.*

object HeaderHelper {

    val deviceId by lazy {
        UUID.nameUUIDFromBytes(getACookie().toByteArray()).toString().replace("-", "")
            .uppercase()
    }

    private fun getACookie(): String {
        return DatabaseStore.queries.selectAllAccounts().executeAsList().first().cookie
    }

    fun getRandomCode(): String = "${((Math.random() + 1) * 100000).toInt()}"

    fun getTs(): String = "${Date().time / 1000}"

    fun getDs(): String {
        val ts = getTs()
        val random = getRandomCode()
        val check = MD5("salt=${ApiCst.BBS_SALT_WEB}&t=$ts&r=$random")
        return "$ts,$random,$check"
    }

    fun getDs2(query: String? = null, body: String? = null): String {
        val ts = getTs()
        val random = getRandomCode()
        val check =
            MD5("salt=${ApiCst.SALT}&t=$ts&r=$random&b=${body ?: ""}&q=${query ?: ""}")
        return "$ts,$random,$check"
    }


}