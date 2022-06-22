package org.zky.genshinwidgets.network

import com.google.gson.Gson
import org.zky.genshinwidgets.cst.ApiCst
import org.zky.genshinwidgets.utils.MD5

data class Test(val role_id:String,val server:String)
//1655882573,187347,c079e3ab3aa3c3fca4bd52d0d68b3ff7
fun main(args: Array<String>) {
    val ts = "1655882573"

//    val body = "{ \"role_id\": \"165255180\", \"server\": \"cn_gf01\" }"
    val body = Gson().toJson(Test("165255180", "cn_gf01"))
    val random = "187347"
    val check =
        MD5("salt=${ApiCst.SALT}&t=$ts&r=$random&b=${body}&q=")
    println("$body===$ts,$random,$check")
}