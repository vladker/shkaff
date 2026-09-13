package com.library.base.util.http;

import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import kotlin.jvm.internal.Y;
import okhttp3.G;
import okhttp3.H;
import p051j0.a;
import p107s4.d;
import retrofit2.t0;
import retrofit2.u0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Http {
    public static Http http;
    private final String TAG = "Http";
    private u0 mRetrofit;

    private Http() {
        SSLSocketFactory socketFactory = null;
        String str = (String) Hawk.get("base_server_url", null);
        if (Y.f(str)) {
            a.d("Http", "请设置服务器地址");
            return;
        }
        boolean zBooleanValue = ((Boolean) Hawk.get("base_cache", Boolean.FALSE)).booleanValue();
        int iIntValue = ((Integer) Hawk.get("base_connecttimeout", 20)).intValue();
        int iIntValue2 = ((Integer) Hawk.get("base_writetimeout", 20)).intValue();
        int iIntValue3 = ((Integer) Hawk.get("base_readtimeout", 20)).intValue();
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new TrustAllManager()}, new SecureRandom());
            socketFactory = sSLContext.getSocketFactory();
        } catch (Exception unused) {
        }
        G g6 = new G();
        long j6 = iIntValue;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        g6.f6506t = d.b(j6, timeUnit);
        g6.f6508v = d.b(iIntValue2, timeUnit);
        g6.f6507u = d.b(iIntValue3, timeUnit);
        g6.f6504r = true;
        g6.b(socketFactory, new TrustAllManager());
        g6.f6496j = new TrustAllHostnameVerifier();
        g6.a(new RequestLogInterceptor());
        g6.a(new RequestHeaderInterceptor());
        if (zBooleanValue) {
            g6.a(new RequestCacheInterceptor());
        }
        H h6 = new H(g6);
        t0 t0Var = new t0();
        t0Var.d(h6);
        t0Var.a(str);
        t0Var.f8161a.add(new z5.a(new Gson()));
        this.mRetrofit = t0Var.b();
    }

    public static void addHeader(String str, String str2) {
        HashMap map = (HashMap) Hawk.get("base_header_map", new HashMap());
        map.put(str, str2);
        Hawk.put("base_header_map", map);
    }

    public static <T> T createApi(Class<T> cls) {
        if (http == null) {
            if (Y.f((String) Hawk.get("base_server_url", null))) {
                return null;
            }
            http = new Http();
        }
        return (T) http.mRetrofit.a(cls);
    }

    public static void initHttp(String str, boolean z6, int i5, int i6, int i7) {
        Hawk.put("base_server_url", str);
        Hawk.put("base_cache", Boolean.valueOf(z6));
        Hawk.put("base_connecttimeout", Integer.valueOf(i5));
        Hawk.put("base_writetimeout", Integer.valueOf(i6));
        Hawk.put("base_readtimeout", Integer.valueOf(i7));
        http = null;
    }

    public static boolean isInit() {
        return !Y.f((String) Hawk.get("base_server_url", null));
    }

    public static void initHttp(String str, boolean z6) {
        initHttp(str, z6, 20, 20, 20);
    }

    public static void initHttp(String str) {
        initHttp(str, false, 20, 20, 20);
    }
}
