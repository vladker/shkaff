package p124v4;

import A3.AbstractC0157z;
import A4.A;
import A4.InterfaceC0170m;
import A4.InterfaceC0171n;
import A4.f0;
import A4.h0;
import A4.k0;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.C1375v;
import okhttp3.C1376w;
import okhttp3.C1378y;
import okhttp3.H;
import okhttp3.I;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Chars;
import p107s4.a;
import p107s4.d;
import p118u4.c;
import p118u4.e;
import p118u4.i;
import t4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f8792a;
    public final h b;
    public final InterfaceC0171n c;
    public final InterfaceC0170m d;
    public int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8793f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C1376w f8794g;

    public g(H h6, h hVar, InterfaceC0171n interfaceC0171n, InterfaceC0170m interfaceC0170m) {
        this.f8792a = h6;
        this.b = hVar;
        this.c = interfaceC0171n;
        this.d = interfaceC0170m;
    }

    public static void a(g gVar, A a6) {
        k0 k0VarDelegate = a6.delegate();
        a6.setDelegate(k0.NONE);
        k0VarDelegate.clearDeadline();
        k0VarDelegate.clearTimeout();
    }

    private String readHeaderLine() {
        String utf8LineStrict = this.c.readUtf8LineStrict(this.f8793f);
        this.f8793f -= (long) utf8LineStrict.length();
        return utf8LineStrict;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1376w readHeaders() {
        C1375v c1375v = new C1375v();
        while (true) {
            String headerLine = readHeaderLine();
            if (headerLine.length() == 0) {
                return new C1376w(c1375v);
            }
            a.f8232a.getClass();
            int iIndexOf = headerLine.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR, 1);
            if (iIndexOf != -1) {
                c1375v.b(headerLine.substring(0, iIndexOf), headerLine.substring(iIndexOf + 1));
            } else if (headerLine.startsWith(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
                c1375v.b("", headerLine.substring(1));
            } else {
                c1375v.b("", headerLine);
            }
        }
    }

    public final d b(long j6) {
        if (this.e == 4) {
            this.e = 5;
            return new d(this, j6);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // p118u4.c
    public final void cancel() {
        h hVar = this.b;
        if (hVar != null) {
            d.d(hVar.d);
        }
    }

    @Override // p118u4.c
    public final h connection() {
        return this.b;
    }

    @Override // p118u4.c
    public f0 createRequestBody(M m6, long j6) {
        if (m6.body() != null) {
            m6.body().getClass();
        }
        if ("chunked".equalsIgnoreCase(m6.header(HttpHeaders.TRANSFER_ENCODING))) {
            if (this.e == 1) {
                this.e = 2;
                return new b(this);
            }
            throw new IllegalStateException("state: " + this.e);
        }
        if (j6 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.e == 1) {
            this.e = 2;
            return new e(this);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // p118u4.c
    public void finishRequest() {
        this.d.flush();
    }

    @Override // p118u4.c
    public void flushRequest() {
        this.d.flush();
    }

    @Override // p118u4.c
    public final h0 openResponseBodySource(T t6) {
        if (!e.b(t6)) {
            return b(0L);
        }
        if ("chunked".equalsIgnoreCase(t6.header(HttpHeaders.TRANSFER_ENCODING))) {
            C1378y c1378y = t6.f6544a.f6539a;
            if (this.e == 4) {
                this.e = 5;
                return new c(this, c1378y);
            }
            throw new IllegalStateException("state: " + this.e);
        }
        long jA = e.a(t6);
        if (jA != -1) {
            return b(jA);
        }
        if (this.e == 4) {
            this.e = 5;
            this.b.c();
            return new f(this);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // p118u4.c
    public S readResponseHeaders(boolean z6) {
        int i5 = this.e;
        if (i5 != 1 && i5 != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            i iVar = i.parse(readHeaderLine());
            S s6 = new S();
            I i6 = iVar.f8744a;
            int i7 = iVar.b;
            s6.c(i6);
            s6.f6543a = i7;
            s6.b = iVar.c;
            s6.c = readHeaders().d();
            if (z6 && i7 == 100) {
                return null;
            }
            if (i7 == 100) {
                this.e = 3;
                return s6;
            }
            this.e = 4;
            return s6;
        } catch (EOFException e) {
            h hVar = this.b;
            throw new IOException(AbstractC0157z.n("unexpected end of stream on ", hVar != null ? hVar.c.f6549a.f6553a.j() : EnvironmentCompat.MEDIA_UNKNOWN), e);
        }
    }

    @Override // p118u4.c
    public final long reportedContentLength(T t6) {
        if (!e.b(t6)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(t6.header(HttpHeaders.TRANSFER_ENCODING))) {
            return -1L;
        }
        return e.a(t6);
    }

    public void skipConnectBody(T t6) {
        long jA = e.a(t6);
        if (jA == -1) {
            return;
        }
        d dVarB = b(jA);
        d.skipAll(dVarB, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        dVarB.close();
    }

    @Override // p118u4.c
    public final C1376w trailers() {
        if (this.e != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        C1376w c1376w = this.f8794g;
        return c1376w != null ? c1376w : d.c;
    }

    public void writeRequest(C1376w c1376w, String str) {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        InterfaceC0170m interfaceC0170m = this.d;
        interfaceC0170m.writeUtf8(str).writeUtf8("\r\n");
        int iF = c1376w.f();
        for (int i5 = 0; i5 < iF; i5++) {
            interfaceC0170m.writeUtf8(c1376w.c(i5)).writeUtf8(": ").writeUtf8(c1376w.g(i5)).writeUtf8("\r\n");
        }
        interfaceC0170m.writeUtf8("\r\n");
        this.e = 1;
    }

    @Override // p118u4.c
    public void writeRequestHeaders(M m6) {
        Proxy.Type type = this.b.c.b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(m6.b);
        sb.append(Chars.SPACE);
        C1378y c1378y = m6.f6539a;
        if (c1378y.f6680a.equals(ProxyConfig.MATCH_HTTPS) || type != Proxy.Type.HTTP) {
            String str = c1378y.f6682g;
            int iIndexOf = str.indexOf(47, c1378y.f6680a.length() + 3);
            String strSubstring = str.substring(iIndexOf, d.f(iIndexOf, str.length(), str, "?#"));
            String strEncodedQuery = c1378y.encodedQuery();
            if (strEncodedQuery != null) {
                strSubstring = strSubstring + '?' + strEncodedQuery;
            }
            sb.append(strSubstring);
        } else {
            sb.append(c1378y);
        }
        sb.append(" HTTP/1.1");
        writeRequest(m6.c, sb.toString());
    }
}
