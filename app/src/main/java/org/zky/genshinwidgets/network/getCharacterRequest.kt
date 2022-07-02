package org.zky.genshinwidgets.network

import org.zky.genshinwidgets.cst.ApiCst

//{"role_id":"123","server":"cn_gf01"}
data class getCharacterRequest(val role_id:String, val server:String)
