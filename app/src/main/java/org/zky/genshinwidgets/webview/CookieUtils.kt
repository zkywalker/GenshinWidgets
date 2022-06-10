package org.zky.genshinwidgets.utils

import android.net.Uri
import android.text.TextUtils
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.network.Request
import java.util.*


// (useful cookie token): ltoken=jNTz0ZMhkKj2aqFIQDtfLXdBmk9X4nMXWbiubYtz; ltuid=270915355; cookie_token=QggeYVhgEArWcrwUghMqhhe43b6i448bA6rJi4nU; account_id=270915355;
fun checkToken(cookie: String): Boolean {
    return cookie.contains("ltoken") && cookie.contains("ltuid")
}

fun isSameCookieToken(cookieA: Map<String, String>, cookieB: Map<String, String>): Boolean {
    return cookieA["ltoken"] == cookieB["ltoken"] && cookieA["ltuid"] == cookieB["ltuid"] && cookieA["cookie_token"] == cookieB["cookie_token"] && cookieA["account_id"] == cookieB["account_id"]
}

fun parseCookie(cookie: String): Map<String, String> {
    if (cookie.isEmpty()) {
        return mutableMapOf()
    }
    return cookie.split(";").map {
        val split = it.trim().split("=")
        if (split.size == 2) {
            return@map split[0] to split[1]
        }
        return@map "" to ""
    }.toMap()

}

fun clearCookieByUrl(
    url: String,
    pCookieManager: CookieManager,
    pCookieSyncManager: CookieSyncManager
) {
    val uri: Uri = Uri.parse(url)
    val host: String? = uri.getHost()
    clearCookieByUrlInternal(url, pCookieManager, pCookieSyncManager)
    clearCookieByUrlInternal("http://.$host", pCookieManager, pCookieSyncManager)
    clearCookieByUrlInternal("https://.$host", pCookieManager, pCookieSyncManager)
}

private fun clearCookieByUrlInternal(
    url: String,
    pCookieManager: CookieManager,
    pCookieSyncManager: CookieSyncManager
) {
    if (TextUtils.isEmpty(url)) {
        return
    }
    val cookieString: String = pCookieManager.getCookie(url)
    val cookie: Vector<String>? = getCookieNamesByUrl(cookieString)
    if (cookie == null || cookie.isEmpty()) {
        return
    }
    val len: Int = cookie.size
    for (i in 0 until len) {
        pCookieManager.setCookie(url, cookie.get(i) + "=-1")
    }
    pCookieSyncManager.sync()
}

private fun getCookieNamesByUrl(cookie: String): Vector<String>? {
    if (TextUtils.isEmpty(cookie)) {
        return null
    }
    val cookieField = cookie.split(";").toTypedArray()
    val len = cookieField.size
    for (i in 0 until len) {
        cookieField[i] = cookieField[i].trim { it <= ' ' }
    }
    val allCookieField: Vector<String> = Vector<String>()
    for (i in 0 until len) {
        if (TextUtils.isEmpty(cookieField[i])) {
            continue
        }
        if (!cookieField[i].contains("=")) {
            continue
        }
        val singleCookieField = cookieField[i].split("=").toTypedArray()
        allCookieField.add(singleCookieField[0])
    }
    return if (allCookieField.isEmpty()) {
        null
    } else allCookieField
}

