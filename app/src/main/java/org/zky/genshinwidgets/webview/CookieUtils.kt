package org.zky.genshinwidgets.utils

// (useful cookie token): ltoken=jNTz0ZMhkKj2aqFIQDtfLXdBmk9X4nMXWbiubYtz; ltuid=270915355; cookie_token=QggeYVhgEArWcrwUghMqhhe43b6i448bA6rJi4nU; account_id=270915355;
fun checkToken(cookie: String): Boolean {
    return cookie.contains("ltoken") && cookie.contains("ltuid")
}

fun isSameCookieToken(cookieA: Map<String, String>, cookieB: Map<String, String>): Boolean {
    return cookieA["ltoken"] == cookieB["ltoken"] && cookieA["ltuid"] == cookieB["ltuid"]
}

fun parseCookie(cookie: String): Map<String, String> {
    if (cookie.isEmpty()) {
        return mutableMapOf()
    }
    return cookie.split(";").map {
        val split = it.trim().split("=")
        if (split.size == 2) {
            return@map split[0] to split[1]
        }
        return@map "" to ""
    }.toMap()

}