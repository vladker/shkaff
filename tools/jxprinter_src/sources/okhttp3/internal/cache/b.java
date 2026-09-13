package okhttp3.internal.cache;

import A4.N;
import A4.f0;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import okhttp3.A;
import okhttp3.C1375v;
import okhttp3.C1376w;
import okhttp3.F;
import okhttp3.I;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import okhttp3.z;
import p118u4.f;
import p118u4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements A {
    final e cache;

    public b(e eVar) {
    }

    public static boolean a(String str) {
        return (HttpHeaders.CONNECTION.equalsIgnoreCase(str) || HttpHeaders.KEEP_ALIVE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    public static T b(T t6) {
        return (t6 == null || t6.body() == null) ? t6 : t6.b().body(null).a();
    }

    private T cacheWritingResponse(c cVar, T t6) {
        f0 f0VarA;
        if (cVar == null || (f0VarA = cVar.a()) == null) {
            return t6;
        }
        return t6.b().body(new g(t6.header(HttpHeaders.CONTENT_TYPE), t6.body().c(), N.buffer(new a(t6.body().d(), N.buffer(f0VarA))))).a();
    }

    @Override // okhttp3.A
    public T intercept(z zVar) {
        System.currentTimeMillis();
        f fVar = (f) zVar;
        M m6 = fVar.d;
        d dVar = new d(m6, null);
        if (dVar.networkRequest != null && m6.a().f6563j) {
            dVar = new d(null, null);
        }
        M m7 = dVar.networkRequest;
        T t6 = dVar.cacheResponse;
        if (m7 == null && t6 == null) {
            S s6 = new S();
            s6.d(fVar.d);
            s6.c(I.HTTP_1_1);
            s6.f6543a = 504;
            s6.b = "Unsatisfiable Request (only-if-cached)";
            S sBody = s6.body(p107s4.d.d);
            sBody.d = -1L;
            sBody.e = System.currentTimeMillis();
            return sBody.a();
        }
        if (m7 == null) {
            return t6.b().cacheResponse(b(t6)).a();
        }
        T tProceed = zVar.proceed(m7);
        if (t6 != null) {
            if (tProceed.c == 304) {
                S sB = t6.b();
                C1376w c1376w = t6.e;
                C1376w c1376w2 = tProceed.e;
                ArrayList arrayList = new ArrayList(20);
                int iF = c1376w.f();
                for (int i5 = 0; i5 < iF; i5++) {
                    String strC = c1376w.c(i5);
                    String strG = c1376w.g(i5);
                    if ((!HttpHeaders.WARNING.equalsIgnoreCase(strC) || !strG.startsWith("1")) && (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strC) || HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(strC) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strC) || !a(strC) || c1376w2.get(strC) == null)) {
                        p107s4.a.f8232a.getClass();
                        arrayList.add(strC);
                        arrayList.add(strG.trim());
                    }
                }
                int iF2 = c1376w2.f();
                for (int i6 = 0; i6 < iF2; i6++) {
                    String strC2 = c1376w2.c(i6);
                    if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strC2) && !HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(strC2) && !HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(strC2) && a(strC2)) {
                        F f6 = p107s4.a.f8232a;
                        String strG2 = c1376w2.g(i6);
                        f6.getClass();
                        arrayList.add(strC2);
                        arrayList.add(strG2.trim());
                    }
                }
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                C1375v c1375v = new C1375v();
                Collections.addAll(c1375v.f6676a, strArr);
                sB.c = c1375v;
                sB.d = tProceed.f6545f;
                sB.e = tProceed.f6546g;
                sB.cacheResponse(b(t6)).networkResponse(b(tProceed)).a();
                tProceed.body().close();
                throw null;
            }
            p107s4.d.c(t6.body());
        }
        return tProceed.b().cacheResponse(b(t6)).networkResponse(b(tProceed)).a();
    }
}
