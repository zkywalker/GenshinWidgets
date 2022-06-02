package org.zky.genshinwidgets.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.utils.MD5
import org.zky.genshinwidgets.utils.loginCookie
import java.util.*

class GenshinBBSInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val encodedPath = chain.request().url.encodedPath
        Log.i("kyle", "url = $encodedPath")
        if (encodedPath != ApiCst.REQUEST_PATH_SIGN) {
            return chain.proceed(chain.request())
        }
        val builder: Request.Builder = chain.request().newBuilder()
        val ts = "${Date().time / 1000}"
        val random = "${((Math.random() + 1) * 100000).toInt()}"
        val check = MD5("salt=${ApiCst.BBS_SALT_WEB_OLD}&t=$ts&r=$random")
        val ds = "$ts,$random,$check"
        builder
            .addHeader("DS", ds)
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) miHoYoBBS/2.3.0"
            )
            .addHeader(
                "Referer",
                "https://webstatic.mihoyo.com/bbs/event/signin-ys/index.html?bbs_auth_required=true&act_id=${ApiCst.GENSHIN_ACT_ID}&utm_source=bbs&utm_medium=mys&utm_campaign=icon"
            )
            .addHeader("Accept-Encodinge", "gzip, deflate, br")
            .addHeader("x-rpc-app_version", "2.3.0")
            .addHeader("x-rpc-client_type", "5")
            .addHeader(
                "x-rpc-device_id",
                UUID.nameUUIDFromBytes(loginCookie.toByteArray()).toString().replace("-", "")
                    .uppercase()
            )
            .addHeader("Cookie", loginCookie)
        return chain.proceed(builder.build())
    }

}