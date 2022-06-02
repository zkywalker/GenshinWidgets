package org.zky.genshinwidgets.webview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.utils.*

class WebLoginActivity : WebViewActivity() {

    val currentCookieMap by lazy { parseCookie(loginCookie) }

    override fun onLoadUrl(intent: Intent?): String? = ApiCst.MIHOYO_BBS_LOGIN

    override fun onWebViewPageFinished(view: WebView?, url: String?) {
        val cookie = CookieManager.getInstance().getCookie(ApiCst.MIHOYO_BBS_LOGIN)
        Log.i("kyle", "cookie = $cookie")
        val cookieMap = parseCookie(cookie)
        if (checkToken(cookie) && !isSameCookieToken(cookieMap, currentCookieMap)) {
            R.string.get_cookie_success.toast()
            setResult(RESULT_OK)
            loginCookie = cookie
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("webview", "cookie = $loginCookie")
    }

}