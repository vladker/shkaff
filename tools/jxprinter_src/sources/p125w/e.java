package p125w;

import com.google.common.net.HttpHeaders;
import okhttp3.A;
import okhttp3.L;
import okhttp3.T;
import okhttp3.z;
import p118u4.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements A {
    @Override // okhttp3.A
    public T intercept(z zVar) {
        L lB = ((f) zVar).d.b();
        lB.b.d(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36...");
        return zVar.proceed(lB.a());
    }
}
