package org.zky.genshinwidgets.webview

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.webkit.*
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.cst.ApiCst.UA_ANDROID
import org.zky.genshinwidgets.utils.runOnMainThread


open class WebViewActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar

    lateinit var webView: WebView

    val mapOf = mapOf(
        "x-rpc-app_version" to "2.28.1",
        "user-agent" to UA_ANDROID,

        "test" to "hello"
    )

    val js = "javascript:(function() {\n" +
            "    var script=document.createElement('script');\n" +
            "    script.setAttribute('type','text/javascript');\n" +
            "    script.setAttribute('src', 'https://webstatic.mihoyo.com/dora/lib/vconsole/3.2.0/vconsole.min.js');\n" +
            "    script.onload = function(){\n" +
            "        var vConsole = new VConsole();\n" +
            "        console.log('vconsole load suc~' );\n" +
            "    };\n" +
            "    document.getElementsByTagName('head')[0].appendChild(script);\n" +
            "})()"

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_web_view)
            initView()
        }

        internal fun initView() {
            val url = onLoadUrl(intent)
            val title = intent.getStringExtra("title")
            if (url.isNullOrEmpty()) {
                finish()
                return
            }
            supportActionBar?.let {
                it.title = title
                it.setDisplayHomeAsUpEnabled(true)
                it.setHomeButtonEnabled(true)
            }
            progressBar = findViewById(R.id.progress_bar)
            webView = findViewById(R.id.web_view)
            webView.apply {
                val cookieManager: CookieManager = CookieManager.getInstance()
                cookieManager.setAcceptCookie(true)
                cookieManager.setAcceptThirdPartyCookies(this, true)
                webChromeClient = object : WebChromeClient() {
                    override fun onProgressChanged(view: WebView?, newProgress: Int) {
                        super.onProgressChanged(view, newProgress)
                        Log.i("WebViewActivity", "onProgressChanged: $newProgress")
                        progressBar.progress = newProgress
                        if (newProgress == 100) {
                            progressBar.visibility = ProgressBar.GONE
                        }
                    }
                }
                webViewClient = object : WebViewClient() {

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        onWebViewPageFinished(view, url)
                    }


                    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                        Log.i("webview", "shouldOverrideUrlLoading = $url")
                        if (url.startsWith("http")) {
                            view.loadUrl(url, mapOf)
                        }
                        return true
                    }

                    override fun shouldOverrideUrlLoading(
                        view: WebView,
                        request: WebResourceRequest
                    ): Boolean {
                        Log.i("webview", "shouldOverrideUrlLoading = ${request.url}")

                        if (request.url.scheme?.startsWith("http") == true) {
                            view.loadUrl(request.url.toString(), mapOf)
                        }
                        return true
                    }
                }
            }
            webView.settings.apply {
                javaScriptEnabled = true
                useWideViewPort = true
                databaseEnabled = true
                domStorageEnabled = true
                cacheMode = WebSettings.LOAD_NO_CACHE
                displayZoomControls = true
                useWideViewPort = true
                loadWithOverviewMode = true
                setSupportZoom(true)
                builtInZoomControls = true
                loadsImagesAutomatically = true
                defaultTextEncodingName = "UTF-8"
                pluginState = WebSettings.PluginState.ON
                supportMultipleWindows()
                setNeedInitialFocus(true)
                WebView.setWebContentsDebuggingEnabled(true)

                userAgentString = UA_ANDROID

            }
            webView.addJavascriptInterface(WebViewBridgeHandler(this) {
                runOnMainThread {
                    webView.evaluateJavascript(it) {
                        Log.i("kyle", "evaluateJavascript:$it")
                    }
                }
            }, "MiHoYoJSInterface")
            webView.addJavascriptInterface(WebViewBridgeHandler(this), "MiHoYoSDKInvoke")
            webView.loadUrl(url)

        }

        open fun onLoadUrl(intent: Intent?): String? = intent?.getStringExtra("url")

        open fun onWebViewPageFinished(view: WebView?, url: String?) {

        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            super.onOptionsItemSelected(item)
            when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    return true
                }
            }
            return false
        }

    }

