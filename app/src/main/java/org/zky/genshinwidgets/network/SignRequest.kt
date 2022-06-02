package org.zky.genshinwidgets.network

import org.zky.genshinwidgets.cst.ApiCst

data class SignRequest(val uid:String,val region:String, val act_id:String = ApiCst.GENSHIN_ACT_ID)
