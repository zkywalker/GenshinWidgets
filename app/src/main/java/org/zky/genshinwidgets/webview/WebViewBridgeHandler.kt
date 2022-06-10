package org.zky.genshinwidgets.webview

import android.util.Log
import android.webkit.JavascriptInterface

open class WebViewBridgeHandler {

    @JavascriptInterface
    fun closePage() {
        Log.i("WebViewActivity", "close")
    }

    @JavascriptInterface
    fun postMessage(paramString: String) {
        Log.i("WebViewActivity", "handler: $paramString")
    }
}