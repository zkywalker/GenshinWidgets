package org.zky.genshinwidgets.model

data class Response<T>(val data: T, val message: String, val retcode: Int)