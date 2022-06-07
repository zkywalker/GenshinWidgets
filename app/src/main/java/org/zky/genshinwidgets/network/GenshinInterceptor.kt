package org.zky.genshinwidgets.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.utils.MD5
import org.zky.genshinwidgets.utils.loginCookie
import java.util.*

class GenshinInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (request.url.encodedPath == ApiCst.REQUEST_PATH_SIGN) {
            return chain.proceed(request)
        }
        val builder: Request.Builder = request.newBuilder()
        val ts = "${Date().time / 1000}"
        val random = "${((Math.random() + 1) * 100000).toInt()}"
        val check = MD5(
            "salt=${ApiCst.SALT}&t=$ts&r=$random${if (request.url.query == null) "" else "&b=&q=${request.url.query}"}"
        )
        val ds = "$ts,$random,$check"

        builder.addHeader("DS", ds)
            .addHeader("Accept", "application/json, text/plain, */*")
            .addHeader("x-rpc-app_version", "2.20.1")
            .addHeader("x-rpc-client_type", "5")
        if (request.header("Cookie") == null) {
            builder.addHeader("Cookie", loginCookie)
        } else {
            Log.d("kyle", "already has Cookie: ${request.header("Cookie")}")
        }
        return chain.proceed(builder.build())
    }

}