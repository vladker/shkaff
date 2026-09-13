package p118u4;

import A3.AbstractC0157z;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.A;
import okhttp3.C1378y;
import okhttp3.H;
import okhttp3.InterfaceC1349b;
import okhttp3.L;
import okhttp3.M;
import okhttp3.T;
import okhttp3.X;
import okhttp3.internal.http2.C1357a;
import okhttp3.z;
import p107s4.a;
import p107s4.d;
import t4.e;
import t4.f;
import t4.j;
import t4.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f8743a;

    public h(H h6) {
        this.f8743a = h6;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:80:0x0103  */
    /* JADX WARN: Code duplicated, block: B:81:0x0107 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0109  */
    /* JADX WARN: Code duplicated, block: B:85:0x0112  */
    /* JADX WARN: Code duplicated, block: B:88:0x0127  */
    private M followUpRequest(T t6, X x6) throws ProtocolException {
        String strHeader;
        C1378y c1378yResolve;
        L lB;
        boolean zEquals;
        if (t6 == null) {
            throw new IllegalStateException();
        }
        M m6 = t6.f6544a;
        int i5 = t6.c;
        String str = m6.b;
        C1378y c1378y = m6.f6539a;
        H h6 = this.f8743a;
        if (i5 == 307 || i5 == 308) {
            if (str.equals(ShareTarget.METHOD_GET) || str.equals("HEAD")) {
                if (h6.f6526s && (strHeader = t6.header(HttpHeaders.LOCATION)) != null && (c1378yResolve = c1378y.resolve(strHeader)) != null && (c1378yResolve.f6680a.equals(c1378y.f6680a) || h6.f6525r)) {
                    lB = m6.b();
                    if (com.bumptech.glide.h.c(str)) {
                        zEquals = str.equals("PROPFIND");
                        if (str.equals("PROPFIND")) {
                            lB.method(str, zEquals ? m6.body() : null);
                        } else {
                            lB.method(ShareTarget.METHOD_GET, null);
                        }
                        if (!zEquals) {
                            lB.b(HttpHeaders.TRANSFER_ENCODING);
                            lB.b(HttpHeaders.CONTENT_LENGTH);
                            lB.b(HttpHeaders.CONTENT_TYPE);
                        }
                    }
                    if (!d.m(c1378y, c1378yResolve)) {
                        lB.b(HttpHeaders.AUTHORIZATION);
                    }
                    lB.d(c1378yResolve);
                    return lB.a();
                }
            }
        } else {
            if (i5 == 401) {
                h6.f6522o.getClass();
                return InterfaceC1349b.lambda$static$0(x6, t6);
            }
            int iIntValue = Integer.MAX_VALUE;
            if (i5 != 503) {
                if (i5 == 407) {
                    if ((x6 != null ? x6.b : h6.proxy()).type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                    h6.f6521n.getClass();
                    return InterfaceC1349b.lambda$static$0(x6, t6);
                }
                if (i5 != 408) {
                    switch (i5) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            if (h6.f6526s) {
                                lB = m6.b();
                                if (com.bumptech.glide.h.c(str)) {
                                    zEquals = str.equals("PROPFIND");
                                    if (str.equals("PROPFIND")) {
                                        lB.method(ShareTarget.METHOD_GET, null);
                                    } else {
                                        lB.method(str, zEquals ? m6.body() : null);
                                    }
                                    if (!zEquals) {
                                        lB.b(HttpHeaders.TRANSFER_ENCODING);
                                        lB.b(HttpHeaders.CONTENT_LENGTH);
                                        lB.b(HttpHeaders.CONTENT_TYPE);
                                    }
                                }
                                if (!d.m(c1378y, c1378yResolve)) {
                                    lB.b(HttpHeaders.AUTHORIZATION);
                                }
                                lB.d(c1378yResolve);
                                return lB.a();
                            }
                        default:
                            return null;
                    }
                } else if (h6.f6527t) {
                    m6.body();
                    if (t6.priorResponse() == null || t6.priorResponse().c != 408) {
                        String strHeader2 = t6.header(HttpHeaders.RETRY_AFTER);
                        if (strHeader2 == null) {
                            iIntValue = 0;
                        } else if (strHeader2.matches("\\d+")) {
                            iIntValue = Integer.valueOf(strHeader2).intValue();
                        }
                        if (iIntValue <= 0) {
                            return m6;
                        }
                    }
                }
            } else if (t6.priorResponse() == null || t6.priorResponse().c != 503) {
                String strHeader3 = t6.header(HttpHeaders.RETRY_AFTER);
                if (strHeader3 != null && strHeader3.matches("\\d+")) {
                    iIntValue = Integer.valueOf(strHeader3).intValue();
                }
                if (iIntValue == 0) {
                    return m6;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean a(IOException iOException, o oVar, boolean z6, M m6) {
        f fVar;
        boolean z7;
        if (this.f8743a.f6527t) {
            if (z6) {
                m6.body();
                if (iOException instanceof FileNotFoundException) {
                    return false;
                }
            }
            if (iOException instanceof ProtocolException) {
                return false;
            }
            if (!(iOException instanceof InterruptedIOException)) {
                if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                    return false;
                }
                fVar = oVar.f8701g;
                synchronized (fVar.c) {
                    z7 = fVar.f8674i;
                    if (!z7) {
                    }
                }
            } else if ((iOException instanceof SocketTimeoutException) && !z6) {
                fVar = oVar.f8701g;
                synchronized (fVar.c) {
                    z7 = fVar.f8674i;
                }
                if (!z7 && oVar.f8701g.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // okhttp3.A
    public T intercept(z zVar) throws IOException {
        M m6 = ((f) zVar).d;
        f fVar = (f) zVar;
        o oVar = fVar.b;
        int i5 = 0;
        T t6 = null;
        while (true) {
            oVar.h(m6);
            if (oVar.f()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    T tProceed = fVar.proceed(m6, oVar, null);
                    if (t6 != null) {
                        tProceed = tProceed.b().priorResponse(t6.b().body(null).a()).a();
                    }
                    t6 = tProceed;
                    e eVarExchange = a.f8232a.exchange(t6);
                    M mFollowUpRequest = followUpRequest(t6, eVarExchange != null ? eVarExchange.d.connection().c : null);
                    if (mFollowUpRequest == null) {
                        if (eVarExchange != null && eVarExchange.e) {
                            if (oVar.f8706l) {
                                throw new IllegalStateException();
                            }
                            oVar.f8706l = true;
                            oVar.e.k();
                        }
                        return t6;
                    }
                    mFollowUpRequest.body();
                    d.c(t6.body());
                    if (oVar.e()) {
                        eVarExchange.d.cancel();
                        eVarExchange.f8669a.exchangeMessageDone(eVarExchange, true, true, null);
                    }
                    i5++;
                    if (i5 > 20) {
                        throw new ProtocolException(AbstractC0157z.k(i5, "Too many follow-up requests: "));
                    }
                    m6 = mFollowUpRequest;
                } catch (IOException e) {
                    if (!a(e, oVar, true ^ (e instanceof C1357a), m6)) {
                        throw e;
                    }
                    oVar.d();
                } catch (j e6) {
                    if (!a(e6.b, oVar, false, m6)) {
                        throw e6.f8692a;
                    }
                    oVar.d();
                }
            } catch (Throwable th) {
                oVar.d();
                throw th;
            }
        }
    }
}
