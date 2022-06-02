package org.zky.genshinwidgets.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.utils.MD5
import org.zky.genshinwidgets.utils.loginCookie
import java.util.*

class GenshinInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (chain.request().url.encodedPath == ApiCst.REQUEST_PATH_SIGN) {
            return chain.proceed(chain.request())
        }
        val builder: Request.Builder = chain.request().newBuilder()
        val ts = "${Date().time / 1000}"
        val random = "${((Math.random() + 1) * 100000).toInt()}"
        val check = MD5(
            "salt=${ApiCst.SALT}&t=$ts&r=$random${if (chain.request().url.query == null) "" else "&b=&q=${chain.request().url.query}"}"
        )
        val ds = "$ts,$random,$check"
        builder.addHeader("DS", ds)
            .addHeader("Accept", "application/json, text/plain, */*")
            .addHeader("x-rpc-app_version", "2.20.1")
            .addHeader("x-rpc-client_type", "5")
            .addHeader("Cookie", loginCookie)
        return chain.proceed(builder.build())
    }

}