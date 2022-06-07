package org.zky

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import org.zky.genshinwidgets.utils.application
import org.zky.genshinwidgets.utils.safeRun
import org.zky.genshinwidgets.widgets.Config


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        val builder = VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        builder.detectFileUriExposure()
        safeRun { Firebase.crashlytics.setCrashlyticsCollectionEnabled(Config.crashReport) }
    }

}