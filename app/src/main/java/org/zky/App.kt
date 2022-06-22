package org.zky

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.text.TextUtils
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import org.zky.genshinwidgets.database.DatabaseStore
import org.zky.genshinwidgets.utils.application
import org.zky.genshinwidgets.utils.loginCookie
import org.zky.genshinwidgets.utils.parseCookie
import org.zky.genshinwidgets.utils.safeRun
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
            val id = parseCookie(loginCookie)["account_id"] ?: return
            if (!TextUtils.isEmpty(id)) {
                val acc = DatabaseStore.queries.selectAccount(id).executeAsOneOrNull()
                if (acc == null) {
                    DatabaseStore.queries.insertAccount(
                        account_id = id,
                        cookie = loginCookie,
                        cookie_updated_at = Date().time,
                        nick_name = "",
                        type = "miyoushe"
                    )
                    return
                }
                if (acc.cookie != loginCookie) {
                    DatabaseStore.queries.updateCookie(loginCookie, Date().time, id)
                }
            }
        }
    }

}