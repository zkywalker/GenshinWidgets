package org.zky.genshinwidgets.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.webview.WebLoginActivity
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.model.*
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.widgets.format
import org.zky.genshinwidgets.widgets.signDate
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.HashMap

/**
 * rtcode: -100 未登录
 * 10103 新的米游社账号？
 * -1 Data not exists
 */
object Request {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(GenshinInterceptor())
        .addInterceptor(GenshinBBSInterceptor())
        .build()

    private val api: GenshinApiService = Retrofit.Builder().baseUrl(ApiCst.MIHOYO_API)
        .addConverterFactory(LenientGsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(GenshinApiService::class.java)

    private val recordApi = Retrofit.Builder().baseUrl(ApiCst.MIHOYO_RECORD_API)
        .addConverterFactory(LenientGsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(GenshinApiService::class.java)

    private val downloadApi = Retrofit.Builder().baseUrl(ApiCst.MIHOYO_RECORD_API)
        .client(okHttpClient)
        .build().create(GenshinApiService::class.java)


    suspend fun getUserRole(cookie: String? = null): GetUserRole? =
        requestTry { api.getUserRole(cookie).handleResponse() }

    suspend fun getSignReward(cookie: String? = null): SignReward? =
        requestTry { api.getSignReward(cookie).handleResponse() }

    suspend fun getSignInfo(region: String, uid: String, cookie: String? = null): SignInfo? =
        requestTry { api.getSignInfo(region = region, uid = uid, cookie = cookie).handleResponse() }

    suspend fun sign(uid: String, region: String, cookie: String? = null): HashMap<String, Any>? {
        val body = SignRequest(
            uid = uid, region = region,
        ).toJson().toRequestBody("application/json".toMediaTypeOrNull())
        return requestTry {
            api.sign(body, cookie = cookie).handleResponse {
                if (it == -5003) {
                    signDate = format.format(Date())
                }
                false
            }
        }
    }

    suspend fun getGameRecord(roleId: String, server: String, cookie: String? = null): DailyNote? =
        requestTry {
            recordApi.getGameRecord(roleId = roleId, server = server, cookie = cookie)
                .handleResponse()
        }


    suspend fun <T> requestTry(block: suspend () -> T): T? = try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        e.message?.toast()
        null
    }

    fun <T> Response<T>.handleResponse(handleRetCode: (Int) -> Boolean = { false }): T? {
        Log.i("kyle", "handleResponse:$this")
        if (retcode == 0) {
            return data
        }
        if (handleRetCode(retcode)) {
            return data
        }
        when (retcode) {
            -100 -> {
                R.string.did_not_login.toast()
                application.startActivity<WebLoginActivity>()
            }
            else -> {
                "$retcode:$message".toast()
            }
        }
        return null
    }

    private fun okhttp3.Call.to(file: File) {
        val response = execute()
        val fos = FileOutputStream(file)
        response.body?.byteStream()?.let {
            it.copyTo(fos)
            it.close()
        }
        fos.flush()
        fos.close()
    }

    suspend fun download(fileUrl: String, saveFile: File): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val request = okhttp3.Request.Builder().url(fileUrl).get().build()
                okHttpClient.newCall(request).to(saveFile)
                return@withContext true
            } catch (e: Exception) {
                e.printStackTrace().toString().toast()
                return@withContext false
            }
        }
    }

}