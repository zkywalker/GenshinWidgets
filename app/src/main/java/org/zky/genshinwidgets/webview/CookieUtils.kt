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


@Composable
fun CookieInputDialog(onDismissRequest: () -> Unit, onSubmit: (String) -> Unit) {
    val cookie = remember { mutableStateOf("") }
    val title = remember { mutableStateOf(getString(R.string.input_cookie)) }
    val showLoading = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    Dialog(onDismissRequest = onDismissRequest) {
        Card {
            Box(contentAlignment = Alignment.Center) {
                Column(Modifier.padding(10.dp)) {
                    Text(title.value, modifier = Modifier.padding(bottom = 10.dp))
                    TextField(
                        value = cookie.value, onValueChange = {
                            cookie.value = it
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Row(Modifier.padding(start = 10.dp, end = 10.dp)) {
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(
                            onClick = onDismissRequest,
                            modifier = Modifier.padding(end = 10.dp)
                        ) {
                            Text(getString(R.string.cancel))
                        }
                        Button(onClick = {
                            scope.launch {
                                showLoading.value = true
                                withContext(Dispatchers.IO) {
                                    val userRole = Request.getUserRole(cookie.value)
                                    if (userRole != null) {
                                        onDismissRequest()
                                        withContext(Dispatchers.Main) {
                                            onSubmit(cookie.value)
                                        }
                                    } else {
                                        R.string.error_cookie.toast()
                                    }
                                }
                                showLoading.value = false
                            }
                        }) {
                            Text(getString(R.string.confirm))
                        }
                    }
                }
                if (showLoading.value) {
                    Box(Modifier.size(50.dp)) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}