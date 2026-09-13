package p118u4;

import A4.N;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.A;
import okhttp3.B;
import okhttp3.C1367m;
import okhttp3.C1368n;
import okhttp3.C1375v;
import okhttp3.C1378y;
import okhttp3.L;
import okhttp3.M;
import okhttp3.Q;
import okhttp3.S;
import okhttp3.T;
import okhttp3.z;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.Chars;
import p107s4.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1368n f8735a;

    public a(C1368n c1368n) {
        this.f8735a = c1368n;
    }

    @Override // okhttp3.A
    public T intercept(z zVar) {
        boolean z6;
        M m6 = ((f) zVar).d;
        L lB = m6.b();
        C1378y c1378y = m6.f6539a;
        Q qBody = m6.body();
        if (qBody != null) {
            B bContentType = qBody.contentType();
            if (bContentType != null) {
                lB.b.d(HttpHeaders.CONTENT_TYPE, bContentType.f6483a);
            }
            long jContentLength = qBody.contentLength();
            if (jContentLength != -1) {
                lB.b.d(HttpHeaders.CONTENT_LENGTH, Long.toString(jContentLength));
                lB.b(HttpHeaders.TRANSFER_ENCODING);
            } else {
                lB.b.d(HttpHeaders.TRANSFER_ENCODING, "chunked");
                lB.b(HttpHeaders.CONTENT_LENGTH);
            }
        }
        if (m6.header(HttpHeaders.HOST) == null) {
            lB.b.d(HttpHeaders.HOST, d.h(c1378y, false));
        }
        if (m6.header(HttpHeaders.CONNECTION) == null) {
            lB.b.d(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        }
        if (m6.header(HttpHeaders.ACCEPT_ENCODING) == null && m6.header(HttpHeaders.RANGE) == null) {
            lB.b.d(HttpHeaders.ACCEPT_ENCODING, "gzip");
            z6 = true;
        } else {
            z6 = false;
        }
        C1368n c1368n = this.f8735a;
        c1368n.getClass();
        List list = Collections.EMPTY_LIST;
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (i5 > 0) {
                    sb.append(VectorFormat.DEFAULT_SEPARATOR);
                }
                C1367m c1367m = (C1367m) list.get(i5);
                sb.append(c1367m.f6664a);
                sb.append(Chars.EQ);
                sb.append(c1367m.b);
            }
            lB.b.d(HttpHeaders.COOKIE, sb.toString());
        }
        if (m6.header(HttpHeaders.USER_AGENT) == null) {
            lB.b.d(HttpHeaders.USER_AGENT, "okhttp/3.14.9");
        }
        T tProceed = zVar.proceed(lB.a());
        e.d(c1368n, c1378y, tProceed.e);
        S sB = tProceed.b();
        sB.d(m6);
        if (z6 && "gzip".equalsIgnoreCase(tProceed.header(HttpHeaders.CONTENT_ENCODING)) && e.b(tProceed)) {
            A4.B b = new A4.B(tProceed.body().d());
            C1375v c1375vD = tProceed.e.d();
            c1375vD.c(HttpHeaders.CONTENT_ENCODING);
            c1375vD.c(HttpHeaders.CONTENT_LENGTH);
            ArrayList arrayList = c1375vD.f6676a;
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            C1375v c1375v = new C1375v();
            Collections.addAll(c1375v.f6676a, strArr);
            sB.c = c1375v;
            sB.body(new g(tProceed.header(HttpHeaders.CONTENT_TYPE), -1L, N.buffer(b)));
        }
        return sB.a();
    }
}
