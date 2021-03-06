package org.zky.genshinwidgets.network

import okhttp3.Cookie
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.model.*
import retrofit2.Call
import retrofit2.http.*


interface GenshinApiService {

    @GET
    suspend fun getVersionInfo(@Url url: String = ApiCst.API_VERSION_JSON): VersionInfo

    @GET("${ApiCst.REQUEST_PATH_GET_USER_ROLE}?game_biz=hk4e_cn")
    suspend fun getUserRole(@Header("Cookie") cookie: String? = null): Response<GetUserRole>

    @GET(ApiCst.REQUEST_PATH_GET_GAME_RECORD)
    suspend fun getGameRecord(
        @Query("role_id") roleId: String,
        @Query("server") server: String,
        @Header("Cookie") cookie: String? = null
    ): Response<DailyNote>

    @GET("${ApiCst.REQUEST_PATH_SIGN_REWARD}?act_id=${ApiCst.GENSHIN_ACT_ID}")
    suspend fun getSignReward(@Header("Cookie") cookie: String? = null): Response<SignReward>

    @GET(ApiCst.REQUEST_PATH_SIGN_INFO)
    suspend fun getSignInfo(
        @Query("act_id") act_id: String = ApiCst.GENSHIN_ACT_ID,
        @Query("region") region: String,
        @Query("uid") uid: String,
        @Header("Cookie") cookie: String? = null
    ): Response<SignInfo>

    // {data={code=ok}, message=OK, retcode=0.0}
    @POST(ApiCst.REQUEST_PATH_SIGN)
    suspend fun sign(
        @Body body: RequestBody,
        @Header("Cookie") cookie: String? = null
    ): Response<HashMap<String, Any>>

    //https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/character
    @POST(ApiCst.REQUEST_PATH_GET_CHARACTER)
    suspend fun getCharacter(
        @Body body: RequestBody,
        @Header("Cookie") cookie: String? = null
    ): Response<GetCharacter>

    @GET
    suspend fun getGameActivity(
        @Url url: String = ApiCst.API_URL_GAME_ACTIVITY,
        @Header("Cookie") cookie: String? = null
    ): Response<GetGameActivity>

}