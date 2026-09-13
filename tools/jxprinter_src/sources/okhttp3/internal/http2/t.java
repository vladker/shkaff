package okhttp3.internal.http2;

import A4.C0173p;
import A4.f0;
import A4.h0;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.C1375v;
import okhttp3.C1376w;
import okhttp3.C1378y;
import okhttp3.H;
import okhttp3.I;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class t implements p118u4.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f6642g = p107s4.d.immutableList("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f6643h = p107s4.d.immutableList("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.z f6644a;
    public final t4.h b;
    public final s c;
    public volatile A d;
    public final I e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f6645f;

    public t(H h6, t4.h hVar, okhttp3.z zVar, s sVar) {
        this.b = hVar;
        this.f6644a = zVar;
        this.c = sVar;
        List list = h6.b;
        I i5 = I.H2_PRIOR_KNOWLEDGE;
        this.e = list.contains(i5) ? i5 : I.HTTP_2;
    }

    public static S readHttp2HeadersList(C1376w c1376w, I i5) throws ProtocolException {
        ArrayList arrayList = new ArrayList(20);
        int iF = c1376w.f();
        p118u4.i iVar = null;
        for (int i6 = 0; i6 < iF; i6++) {
            String strC = c1376w.c(i6);
            String strG = c1376w.g(i6);
            if (strC.equals(":status")) {
                iVar = p118u4.i.parse("HTTP/1.1 " + strG);
            } else if (!f6643h.contains(strC)) {
                p107s4.a.f8232a.getClass();
                arrayList.add(strC);
                arrayList.add(strG.trim());
            }
        }
        if (iVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        S s6 = new S();
        s6.c(i5);
        s6.f6543a = iVar.b;
        s6.b = iVar.c;
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        C1375v c1375v = new C1375v();
        Collections.addAll(c1375v.f6676a, strArr);
        s6.c = c1375v;
        return s6;
    }

    @Override // p118u4.c
    public final void cancel() {
        this.f6645f = true;
        if (this.d != null) {
            this.d.a(EnumC1358b.CANCEL);
        }
    }

    @Override // p118u4.c
    public final t4.h connection() {
        return this.b;
    }

    @Override // p118u4.c
    public final f0 createRequestBody(M m6, long j6) {
        return this.d.b();
    }

    @Override // p118u4.c
    public void finishRequest() {
        this.d.b().close();
    }

    @Override // p118u4.c
    public void flushRequest() {
        this.c.flush();
    }

    @Override // p118u4.c
    public final h0 openResponseBodySource(T t6) {
        return this.d.f6585g;
    }

    @Override // p118u4.c
    public S readResponseHeaders(boolean z6) throws ProtocolException {
        S http2HeadersList = readHttp2HeadersList(this.d.takeHeaders(), this.e);
        if (z6) {
            p107s4.a.f8232a.getClass();
            if (http2HeadersList.f6543a == 100) {
                return null;
            }
        }
        return http2HeadersList;
    }

    @Override // p118u4.c
    public final long reportedContentLength(T t6) {
        return p118u4.e.a(t6);
    }

    @Override // p118u4.c
    public C1376w trailers() {
        return this.d.trailers();
    }

    @Override // p118u4.c
    public void writeRequestHeaders(M m6) throws IOException {
        if (this.d != null) {
            return;
        }
        boolean z6 = m6.body() != null;
        C1376w c1376w = m6.c;
        ArrayList arrayList = new ArrayList(c1376w.f() + 4);
        arrayList.add(new C1359c(m6.b, C1359c.f6600f));
        C0173p c0173p = C1359c.f6601g;
        C1378y c1378y = m6.f6539a;
        String str = c1378y.f6682g;
        int iIndexOf = str.indexOf(47, c1378y.f6680a.length() + 3);
        String strSubstring = str.substring(iIndexOf, p107s4.d.f(iIndexOf, str.length(), str, "?#"));
        String strEncodedQuery = c1378y.encodedQuery();
        if (strEncodedQuery != null) {
            strSubstring = strSubstring + '?' + strEncodedQuery;
        }
        arrayList.add(new C1359c(strSubstring, c0173p));
        String strHeader = m6.header(HttpHeaders.HOST);
        if (strHeader != null) {
            arrayList.add(new C1359c(strHeader, C1359c.f6603i));
        }
        arrayList.add(new C1359c(c1378y.f6680a, C1359c.f6602h));
        int iF = c1376w.f();
        for (int i5 = 0; i5 < iF; i5++) {
            String lowerCase = c1376w.c(i5).toLowerCase(Locale.US);
            if (!f6642g.contains(lowerCase) || (lowerCase.equals("te") && c1376w.g(i5).equals("trailers"))) {
                arrayList.add(new C1359c(lowerCase, c1376w.g(i5)));
            }
        }
        this.d = this.c.newStream(arrayList, z6);
        if (this.f6645f) {
            this.d.a(EnumC1358b.CANCEL);
            throw new IOException("Canceled");
        }
        z zVar = this.d.f6587i;
        long j6 = ((p118u4.f) this.f6644a).f8739g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVar.timeout(j6, timeUnit);
        this.d.f6588j.timeout(((p118u4.f) this.f6644a).f8740h, timeUnit);
    }
}
