package org.zky.genshinwidgets.webview;

import static org.zky.genshinwidgets.utils.GlobleKt.application;

import android.os.Build;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;

public class RemoveCookiesTask extends Thread {
    private final ValueCallback<Boolean> mCallback;

    public RemoveCookiesTask(ValueCallback<Boolean> callback) {
        mCallback = callback;
    }

    public void run() {
        Looper.prepare();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().removeAllCookies(mCallback);
        } else {
            CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(application);
            cookieSyncManager.startSync();
            CookieManager.getInstance().removeAllCookie();
            cookieSyncManager.stopSync();
            mCallback.onReceiveValue(true);
            Looper.loop();
        }
    }
}