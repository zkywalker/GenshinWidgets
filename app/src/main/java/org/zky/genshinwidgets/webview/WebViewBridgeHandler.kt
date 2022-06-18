package org.zky.genshinwidgets.webview

import android.app.Activity
import android.util.Log
import android.webkit.JavascriptInterface
import org.zky.genshinwidgets.model.JSJsonParamsBean
import org.zky.genshinwidgets.network.HeaderHelper
import org.zky.genshinwidgets.utils.fromJsonOrNull
import org.zky.genshinwidgets.utils.loginCookie
import org.zky.genshinwidgets.utils.toJson

open class WebViewBridgeHandler(val activity: Activity, val excJs: (String) -> Unit) {

    @JavascriptInterface
    fun closePage() {
        Log.i("WebViewActivity", "close")
        activity.finish()
    }

    @JavascriptInterface
    fun postMessage(paramString: String) {
        Log.i("WebViewActivity", "handler: $paramString")
        val jsJsonParamsBean =
            paramString.fromJsonOrNull<JSJsonParamsBean<HashMap<Any, Any>>>() ?: return
        val data = when (jsJsonParamsBean.method) {
            JsMethod.getDS -> hashMapOf("DS" to HeaderHelper.getDs())
            JsMethod.getHTTPRequestHeaders -> hashMapOf(
                "x-rpc-device_name" to "Xiaomi M2006J10C",
                "Referer" to "https://app.mihoyo.com",
                "x-rpc-app_version" to "2.28.1",
                "x-rpc-client_type" to "2",
                "x-rpc-device_id" to HeaderHelper.deviceId,
                "x-rpc-channel" to "miyousheluodi",
                "x-rpc-device_model" to "M2006J10C",
                "x-rpc-sys_version" to "11"
            )
            JsMethod.getStatusBarHeight -> hashMapOf("statusBarHeight" to "34.909092")
            JsMethod.getCookieInfo -> hashMapOf("cookie" to loginCookie,"Cookie" to loginCookie,"CookieInfo" to loginCookie,"cookieInfo" to loginCookie,)
            else -> hashMapOf()
        }
        exc(jsJsonParamsBean.getCallback(), JsCallback(data = data).toJson())
    }

    fun exc(methodName: String, callbackStr: String) {
        val toString = StringBuilder("javascript:mhyWebBridge(\"$methodName\"")
            .append(if (callbackStr.isBlank()) "" else ",$callbackStr")
            .append(")")
            .toString()
        excJs(toString)
    }

}

data class JsCallback<T>(val message: String = "", val retcode: Int = 0, val data: T)

object JsMethod {
    val getStatusBarHeight = "getStatusBarHeight"
    val getHTTPRequestHeaders = "getHTTPRequestHeaders"
    val getCookieInfo = "getCookieInfo"
    val getDS = "getDS"
}

//{
//    "DS": "1655381422,j4h16i,ba26e12537ae3a57f613f3f185c3aa97"
//}

//{
//    "message": "",
//    "data": {
//        "statusBarHeight": "34.909092"
//    },
//    "retcode": 0
//}


//{
//    "message": "",
//    "data": {
//        "x-rpc-device_name": "Xiaomi M2006J10C",
//        "Referer": "https://app.mihoyo.com",
//        "x-rpc-app_version": "2.28.1",
//        "x-rpc-client_type": "2",
//        "x-rpc-device_id": "6525cb6c-26ce-3ed7-ab92-13a79640f471",
//        "x-rpc-channel": "miyousheluodi",
//        "x-rpc-device_model": "M2006J10C",
//        "x-rpc-sys_version": "11"
//    },
//    "retcode": 0
//}