package org.zky.genshinwidgets.network

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
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
        val buffer = Buffer()
        request.body?.writeTo(buffer)
        val body = buffer.readUtf8()
        Log.i("kyle", "method:${request.method},body:$body")
        val stringBuilder = StringBuilder()
        stringBuilder.append("salt=${ApiCst.SALT}&t=$ts&r=$random")
        if (request.method == "POST" && !TextUtils.isEmpty(body)) {
            val body = Gson().toJson(Test("165255180", "cn_gf01"))

            stringBuilder.append("&b=${body}&q=")
        } else if (request.url.query != null) {
            stringBuilder.append("&b=&q=${request.url.query}")
        }
        val check = MD5(stringBuilder.toString())
        val ds = "$ts,$random,$check"

        builder.addHeader("DS", ds)
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.11.1",
            )
            .addHeader("Accept", "application/json, text/plain, */*")
            .addHeader("x-rpc-app_version", "2.21.1")
            .addHeader("x-rpc-client_type", "5")
            .addHeader("X-Requested-With", "com.mihoyo.hyperion")
        if (request.header("Cookie") == null) {
            builder.addHeader("Cookie", loginCookie)
        } else {
            Log.d("kyle", "already has Cookie: ${request.header("Cookie")}")
        }
        return chain.proceed(builder.build())
    }

}