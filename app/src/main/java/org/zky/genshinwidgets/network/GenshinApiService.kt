package org.zky.genshinwidgets.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.model.*
import retrofit2.Call
import retrofit2.http.*


interface GenshinApiService {

    @GET("${ApiCst.REQUEST_PATH_GET_USER_ROLE}?game_biz=hk4e_cn")
    suspend fun getUserRole(): Response<GetUserRole>

    @GET(ApiCst.REQUEST_PATH_GET_GAME_RECORD)
    suspend fun getGameRecord(
        @Query("role_id") roleId: String,
        @Query("server") server: String
    ): Response<DailyNote>

    @GET("${ApiCst.REQUEST_PATH_SIGN_REWARD}?act_id=${ApiCst.GENSHIN_ACT_ID}")
    suspend fun getSignReward(): Response<SignReward>

    @GET(ApiCst.REQUEST_PATH_SIGN_INFO)
    suspend fun getSignInfo(
        @Query("act_id") act_id: String = ApiCst.GENSHIN_ACT_ID,
        @Query("region") region: String,
        @Query("uid") uid: String
    ): Response<SignInfo>

    // {data={code=ok}, message=OK, retcode=0.0}
    @POST(ApiCst.REQUEST_PATH_SIGN)
    suspend fun sign(@Body body: RequestBody): Response<HashMap<String, Any>>

    @Streaming
    @GET
     fun download(@Url url: String): Call<ResponseBody>

}