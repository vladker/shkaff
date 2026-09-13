package com.library.base.frame;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.multidex.MultiDexApplication;
import com.library.base.util.http.HttpCacheHandle;
import com.orhanobut.hawk.Hawk;
import kotlin.jvm.internal.D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FrameApplication extends MultiDexApplication {
    public static String defaultLang = "zh";
    private final String TAG = "FrameApplication";

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        D.f5685a = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        Hawk.init(getApplicationContext()).build();
    }

    public void openHttpCache() {
        HttpCacheHandle.init(getApplicationContext());
    }
}
