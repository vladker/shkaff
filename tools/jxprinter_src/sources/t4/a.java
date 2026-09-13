package t4;

import androidx.browser.trusted.sharing.ShareTarget;
import okhttp3.A;
import okhttp3.M;
import okhttp3.T;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements A {
    @Override // okhttp3.A
    public T intercept(z zVar) {
        p118u4.f fVar = (p118u4.f) zVar;
        M m6 = fVar.d;
        o oVar = fVar.b;
        return fVar.proceed(m6, oVar, oVar.g(zVar, !m6.b.equals(ShareTarget.METHOD_GET)));
    }
}
