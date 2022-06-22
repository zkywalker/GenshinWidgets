package org.zky.genshinwidgets.webview

import android.app.Activity
import android.text.TextUtils
import android.util.Log
import android.webkit.JavascriptInterface
import com.google.gson.internal.LinkedTreeMap
import org.zky.genshinwidgets.model.JSJsonParamsBean
import org.zky.genshinwidgets.network.HeaderHelper
import org.zky.genshinwidgets.utils.fromJsonOrNull
import org.zky.genshinwidgets.utils.loginCookie
import org.zky.genshinwidgets.utils.toJson
import org.zky.genshinwidgets.utils.toJsonOrNull

open class WebViewBridgeHandler(val activity: Activity, val excJs: (String) -> Unit = {}) {

    @JavascriptInterface
    fun closePage() {
        Log.i("WebViewActivity", "close")
        activity.finish()
    }

    @JavascriptInterface
    fun postMessage(paramString: String) {
        Log.i("WebViewActivity", "handler: $paramString")
        val jsJsonParamsBean =
            paramString.fromJsonOrNull<JSJsonParamsBean<LinkedTreeMap<Any, Any?>>>() ?: return
        if (jsJsonParamsBean.method == JsMethod.closePage) {
            activity.finish()
            return
        }
        val data = when (jsJsonParamsBean.method) {
            JsMethod.getDS -> hashMapOf("DS" to HeaderHelper.getDs2())
            JsMethod.getDS2 -> {
//                val map: LinkedTreeMap<Any,Any> = jsJsonParamsBean.payload
                var query = jsJsonParamsBean.payload["query"].toJsonOrNull()
                val body = jsJsonParamsBean.payload["body"].toString()
                if (TextUtils.isEmpty(query) || query == "{}") {
                    query = null
                }
                hashMapOf("DS" to HeaderHelper.getDs2(query, body))
            }
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
            JsMethod.getStatusBarHeight -> hashMapOf(/*"statusBarHeight" to "34.909092"*/)
            JsMethod.getCookieInfo -> hashMapOf(
                "cookie" to loginCookie,
                "Cookie" to loginCookie,
                "CookieInfo" to loginCookie,
                "cookieInfo" to loginCookie,
            )
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
    val getDS2 = "getDS2"
    val closePage = "closePage"
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