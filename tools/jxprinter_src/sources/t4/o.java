package t4;

import androidx.webkit.ProxyConfig;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C1348a;
import okhttp3.C1355h;
import okhttp3.C1371q;
import okhttp3.C1378y;
import okhttp3.F;
import okhttp3.H;
import okhttp3.K;
import okhttp3.M;
import okhttp3.r;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f8699a;
    public final i b;
    public final K c;
    private Object callStackTrace;
    public final C1371q d;
    public final m e;
    private e exchange;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public M f8700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f8701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f8702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8707m;

    public o(H h6, K k6) {
        m mVar = new m(this);
        this.e = mVar;
        this.f8699a = h6;
        F f6 = p107s4.a.f8232a;
        S4.h hVar = h6.f6523p;
        f6.getClass();
        this.b = (i) hVar.b;
        this.c = k6;
        h6.f6513f.getClass();
        this.d = r.f6672a;
        mVar.timeout(h6.f6528u, TimeUnit.MILLISECONDS);
    }

    private IOException maybeReleaseConnection(IOException iOException, boolean z6) {
        h hVar;
        Socket socketReleaseConnectionNoEvents;
        boolean z7;
        synchronized (this.b) {
            if (z6) {
                try {
                    if (this.exchange != null) {
                        throw new IllegalStateException("cannot release connection while it is in use");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hVar = this.f8702h;
            socketReleaseConnectionNoEvents = (hVar != null && this.exchange == null && (z6 || this.f8707m)) ? releaseConnectionNoEvents() : null;
            if (this.f8702h != null) {
                hVar = null;
            }
            z7 = this.f8707m && this.exchange == null;
        }
        p107s4.d.d(socketReleaseConnectionNoEvents);
        if (hVar != null) {
            this.d.getClass();
        }
        if (z7) {
            boolean z8 = iOException != null;
            iOException = timeoutExit(iOException);
            if (z8) {
                this.d.getClass();
                return iOException;
            }
            this.d.getClass();
        }
        return iOException;
    }

    private IOException timeoutExit(IOException iOException) {
        if (this.f8706l || !this.e.k()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void a(h hVar) {
        if (this.f8702h != null) {
            throw new IllegalStateException();
        }
        this.f8702h = hVar;
        hVar.f8687p.add(new n(this, this.callStackTrace));
    }

    public final void b() {
        this.callStackTrace = p130w4.i.f8835a.getStackTraceForCloseable("response.body().close()");
        this.d.getClass();
    }

    public final void c() {
        e eVar;
        h hVar;
        synchronized (this.b) {
            try {
                this.f8705k = true;
                eVar = this.exchange;
                f fVar = this.f8701g;
                if (fVar == null || (hVar = fVar.f8673h) == null) {
                    hVar = this.f8702h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (eVar != null) {
            eVar.d.cancel();
        } else if (hVar != null) {
            p107s4.d.d(hVar.d);
        }
    }

    public final void d() {
        synchronized (this.b) {
            try {
                if (this.f8707m) {
                    throw new IllegalStateException();
                }
                this.exchange = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        boolean z6;
        synchronized (this.b) {
            z6 = this.exchange != null;
        }
        return z6;
    }

    public IOException exchangeMessageDone(e eVar, boolean z6, boolean z7, IOException iOException) {
        boolean z8;
        synchronized (this.b) {
            try {
                e eVar2 = this.exchange;
                if (eVar != eVar2) {
                    return iOException;
                }
                boolean z9 = true;
                if (z6) {
                    z8 = !this.f8703i;
                    this.f8703i = true;
                } else {
                    z8 = false;
                }
                if (z7) {
                    if (!this.f8704j) {
                        z8 = true;
                    }
                    this.f8704j = true;
                }
                if (this.f8703i && this.f8704j && z8) {
                    eVar2.d.connection().f8684m++;
                    this.exchange = null;
                } else {
                    z9 = false;
                }
                return z9 ? maybeReleaseConnection(iOException, false) : iOException;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f() {
        boolean z6;
        synchronized (this.b) {
            z6 = this.f8705k;
        }
        return z6;
    }

    public final e g(z zVar, boolean z6) throws Throwable {
        synchronized (this.b) {
            try {
                try {
                    if (this.f8707m) {
                        throw new IllegalStateException("released");
                    }
                    if (this.exchange != null) {
                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                    }
                    e eVar = new e(this, this.c, this.d, this.f8701g, this.f8701g.a(this.f8699a, zVar, z6));
                    synchronized (this.b) {
                        this.exchange = eVar;
                        this.f8703i = false;
                        this.f8704j = false;
                    }
                    return eVar;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void h(M m6) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        C1355h c1355h;
        M m7 = this.f8700f;
        if (m7 != null) {
            if (p107s4.d.m(m7.f6539a, m6.f6539a) && this.f8701g.b()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            }
            if (this.f8701g != null) {
                maybeReleaseConnection(null, true);
                this.f8701g = null;
            }
        }
        this.f8700f = m6;
        C1378y c1378y = m6.f6539a;
        boolean zEquals = c1378y.f6680a.equals(ProxyConfig.MATCH_HTTPS);
        H h6 = this.f8699a;
        if (zEquals) {
            sSLSocketFactory = h6.f6517j;
            hostnameVerifier = h6.f6519l;
            c1355h = h6.f6520m;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            c1355h = null;
        }
        this.f8701g = new f(this, this.b, new C1348a(c1378y.d, c1378y.e, h6.f6524q, h6.f6516i, sSLSocketFactory, hostnameVerifier, c1355h, h6.f6521n, h6.proxy(), h6.b, h6.c, h6.f6514g), this.c, this.d);
    }

    public IOException noMoreExchanges(IOException iOException) {
        synchronized (this.b) {
            this.f8707m = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public Socket releaseConnectionNoEvents() {
        int size = this.f8702h.f8687p.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            }
            if (((Reference) this.f8702h.f8687p.get(i5)).get() == this) {
                break;
            }
            i5++;
        }
        if (i5 == -1) {
            throw new IllegalStateException();
        }
        h hVar = this.f8702h;
        hVar.f8687p.remove(i5);
        this.f8702h = null;
        if (!hVar.f8687p.isEmpty()) {
            return null;
        }
        hVar.f8688q = System.nanoTime();
        i iVar = this.b;
        iVar.getClass();
        if (hVar.f8682k || iVar.f8690a == 0) {
            iVar.d.remove(hVar);
            return hVar.e;
        }
        iVar.notifyAll();
        return null;
    }
}
