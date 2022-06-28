package org.zky.genshinwidgets.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.ui.graphics.Color
import com.google.gson.Gson
import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.webview.WebViewActivity


val mainHandler = Handler(Looper.getMainLooper())

val handlerThread = HandlerThread("handlerThread").apply {
    start()
}

val workerHandler = Handler(handlerThread.looper)

var spCookie: String by PreferenceDelegate(SpCst.KEY_COOKIE, "")

@Deprecated("use database now")
var loginCookie: String
    get() = if (checkToken(spCookie)) spCookie else ""
    set(value) {
        spCookie = value
    }

fun runOnMainThread(runnable: () -> Unit) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        runnable()
    } else {
        mainHandler.post(runnable)
    }
}

fun runOnWorkerThread(runnable: () -> Unit) {
    workerHandler.post(runnable)
}

fun String.toast() {
    runOnMainThread { Toast.makeText(application, this, Toast.LENGTH_SHORT).show() }
}

fun Int.toast() {
    getString(this).toast()
}

fun getString(stringRes: Int): String = application.getString(stringRes)

fun getColor(stringRes: Int): Color = Color(application.getColor(stringRes))


fun safeRun(runnable: () -> Unit) {
    try {
        runnable()
    } catch (e: Exception) {
        Log.e("safeRun", e.toString())
    }
}

fun <T> T.toJson(): String = Gson().toJson(this)

fun <T> T?.toJsonOrNull(): String? = if (this == null) null else Gson().toJson(this)

inline fun <reified T> String.fromJson(): T = Gson().fromJson(this, T::class.java)

inline fun <reified T> String.fromJsonOrNull(): T? = try {
    Gson().fromJson(this, T::class.java)
} catch (e: Exception) {
    e.printStackTrace()
    null
}

fun getAppVersionName(): String {
    var versionName = ""
    try {
        versionName =
            application.packageManager.getPackageInfo(application.packageName, 0).versionName
    } catch (e: Exception) {
        e.printStackTrace()
        Log.e("kyle", "getAppVersionName", e)
    }
    return versionName
}

inline fun <reified T : Activity> Context.startActivity(handle: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    if (this is Application) {
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
    }
    intent.handle()
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.startActivityForResult(launcher: ActivityResultLauncher<Intent>) {
    val intent = Intent(this, T::class.java)
    launcher.launch(intent)
}

inline fun Activity.startActivityForResult2(
    launcher: ActivityResultLauncher<Intent>,
    handle: () -> Intent
) {
    launcher.launch(handle())
}

fun Context.startWebViwActivity(title: String, url: String) {
    val intent = Intent(this, WebViewActivity::class.java)
    intent.putExtra("title", title)
    intent.putExtra("url", url)
    startActivity(intent)
}

fun Context.launchApp(packageName: String) {
    packageManager.getLaunchIntentForPackage(packageName)?.let {
        it.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        startActivity(it)
    }
}

fun Context.startBrowser(url: String) {
    val intent = Intent()
    intent.action = "android.intent.action.VIEW"
    intent.data = Uri.parse(url)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}