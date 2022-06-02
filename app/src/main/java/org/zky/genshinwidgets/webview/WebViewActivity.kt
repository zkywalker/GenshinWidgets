package org.zky.genshinwidgets.webview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.webkit.*
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import org.zky.genshinwidgets.R

open class WebViewActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
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
                        view.loadUrl(url)
                    }
                    return true
                }

                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    Log.i("webview", "shouldOverrideUrlLoading = ${request.url}")

                    if (request.url.scheme?.startsWith("http") == true) {
                        view.loadUrl(request.url.toString())
                    }
                    return true
                }
            }
        }
        webView.settings.apply {
            javaScriptEnabled = true
            layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
            useWideViewPort = true
            databaseEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
            setAppCachePath(cacheDir.absolutePath)
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
            mixedContentMode = WebSettings.LOAD_NORMAL
        }
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