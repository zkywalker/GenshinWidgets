package org.zky.genshinwidgets.widgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import org.zky.genshinwidgets.utils.launchApp

/**
 * this activity is used to wake up the target app by package name
 * cuz android widgets are not supported to wake up other app?
 */
class WakeAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_awake_app)
        val packageName = intent.getStringExtra("package_name")
        Log.i("kyle","packageName: $packageName")
        if (packageName == null || TextUtils.isEmpty(packageName)) {
            finish()
        } else {
            launchApp(packageName)
            finish()
        }
    }
}