package org.zky

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.text.TextUtils
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import org.zky.genshinwidgets.database.DatabaseStore
import org.zky.genshinwidgets.utils.*
import org.zky.genshinwidgets.widgets.Config
import java.util.Date


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        val builder = VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        builder.detectFileUriExposure()
        safeRun { Firebase.crashlytics.setCrashlyticsCollectionEnabled(Config.crashReport) }
        handleHistoryData()
    }

    private fun handleHistoryData() {
        if (!TextUtils.isEmpty(loginCookie)) {
            insertAccountByCookie(loginCookie)
            loginCookie = ""
        }
    }

}