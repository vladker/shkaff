package com.library.base.util.http;

import A4.C0169l;
import A4.InterfaceC0171n;
import android.net.NetworkInfo;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.location.LocationRequestCompat;
import com.google.common.net.HttpHeaders;
import java.nio.charset.Charset;
import kotlin.jvm.internal.D;
import okhttp3.A;
import okhttp3.B;
import okhttp3.C1351d;
import okhttp3.L;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import okhttp3.W;
import okhttp3.z;
import p051j0.a;
import p118u4.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class RequestCacheInterceptor implements A {
    private Charset charset = Charset.forName("UTF-8");
    private final String TAG = "RequestCacheInterceptor";

    @Override // okhttp3.A
    public T intercept(z zVar) {
        M mA = ((f) zVar).d;
        if (mA.b.equals(ShareTarget.METHOD_POST)) {
            return zVar.proceed(mA.b().a());
        }
        String str = mA.f6539a.f6682g;
        String string = HttpCacheHandle.get(str);
        boolean z6 = string != null;
        NetworkInfo activeNetworkInfo = D.f5685a.getActiveNetworkInfo();
        if ((activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) && z6) {
            L lB = mA.b();
            String string2 = C1351d.f6557m.toString();
            if (string2.isEmpty()) {
                lB.b.c(HttpHeaders.CACHE_CONTROL);
            } else {
                lB.b.d(HttpHeaders.CACHE_CONTROL, string2);
            }
            mA = lB.a();
        }
        T tProceed = zVar.proceed(mA);
        W wBody = tProceed.body();
        NetworkInfo activeNetworkInfo2 = D.f5685a.getActiveNetworkInfo();
        if (activeNetworkInfo2 != null && activeNetworkInfo2.isAvailable()) {
            InterfaceC0171n interfaceC0171nD = wBody.d();
            interfaceC0171nD.request(LocationRequestCompat.PASSIVE_INTERVAL);
            C0169l c0169lBuffer = interfaceC0171nD.buffer();
            B bContentType = wBody.contentType();
            if (bContentType != null) {
                this.charset = bContentType.charset(Charset.forName("UTF-8"));
            }
            string = c0169lBuffer.m118clone().readString(this.charset);
            HttpCacheHandle.put(str, string);
            a.d("RequestCacheInterceptor", "put cache-> key:" + str + " -> value:" + string);
        }
        S sB = tProceed.b();
        sB.f6543a = z6 ? 200 : tProceed.c;
        return sB.body(W.create(wBody.contentType(), string.getBytes())).a();
    }
}
