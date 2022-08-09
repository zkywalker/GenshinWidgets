package org.zky.genshinwidgets.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.zky.genshinwidgets.cst.ApiCst

class GenshinBBSInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val encodedPath = request.url.encodedPath
        Log.i("kyle", "url = $encodedPath")
        if (encodedPath != ApiCst.REQUEST_PATH_SIGN) {
            return chain.proceed(request)
        }
        val builder: Request.Builder = request.newBuilder()
        builder
            .addHeader("DS", HeaderHelper.getDs())
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.34.1"
            )
            .addHeader(
                "Referer",
                "https://webstatic.mihoyo.com/bbs/event/signin-ys/index.html?bbs_auth_required=true&act_id=${ApiCst.GENSHIN_ACT_ID}&utm_source=bbs&utm_medium=mys&utm_campaign=icon"
            )
            .addHeader("Accept", "application/json, text/plain, */*")
            .addHeader("Accept-Encodinge", "gzip, deflate, br")
            .addHeader("x-rpc-app_version", "2.34.1")
            .addHeader("x-rpc-client_type", "5")
            .addHeader("x-rpc-device_id", HeaderHelper.deviceId)
//        if (request.header("Cookie") == null) {
//            builder.addHeader("Cookie", loginCookie)
//        } else {
//            Log.d("kyle", "already has Cookie: ${request.header("Cookie")}")
//        }
        return chain.proceed(builder.build())
    }

}