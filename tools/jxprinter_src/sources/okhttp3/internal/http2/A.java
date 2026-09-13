package okhttp3.internal.http2;

import A4.InterfaceC0171n;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.List;
import okhttp3.C1376w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6583a = 0;
    public long b;
    public final int c;
    public final s d;
    public final ArrayDeque e;
    EnumC1358b errorCode;
    IOException errorException;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f6585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f6586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z f6587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z f6588j;

    public A(int i5, s sVar, boolean z6, boolean z7, C1376w c1376w) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        this.f6587i = new z(this);
        this.f6588j = new z(this);
        if (sVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i5;
        this.d = sVar;
        this.b = sVar.f6637u.a();
        y yVar = new y(this, sVar.f6636t.a());
        this.f6585g = yVar;
        x xVar = new x(this);
        this.f6586h = xVar;
        yVar.f6651f = z7;
        xVar.c = z6;
        if (c1376w != null) {
            arrayDeque.add(c1376w);
        }
        if (c() && c1376w != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!c() && c1376w == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean closeInternal(EnumC1358b enumC1358b, IOException iOException) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.f6585g.f6651f && this.f6586h.c) {
                    return false;
                }
                this.errorCode = enumC1358b;
                this.errorException = iOException;
                notifyAll();
                this.d.e(this.c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(EnumC1358b enumC1358b) {
        if (closeInternal(enumC1358b, null)) {
            this.d.h(this.c, enumC1358b);
        }
    }

    public final x b() {
        synchronized (this) {
            try {
                if (!this.f6584f && !c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f6586h;
    }

    public final boolean c() {
        return this.d.f6621a == ((this.c & 1) == 1);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001a  */
    public void cancelStreamIfNecessary() {
        boolean z6;
        boolean zD;
        synchronized (this) {
            try {
                y yVar = this.f6585g;
                if (yVar.f6651f || !yVar.e) {
                    z6 = false;
                } else {
                    x xVar = this.f6586h;
                    if (xVar.c || xVar.b) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                zD = d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z6) {
            close(EnumC1358b.CANCEL, null);
        } else {
            if (zD) {
                return;
            }
            this.d.e(this.c);
        }
    }

    public void checkOutNotClosed() throws IOException {
        x xVar = this.f6586h;
        if (xVar.b) {
            throw new IOException("stream closed");
        }
        if (xVar.c) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                throw new G(this.errorCode);
            }
        }
    }

    public void close(EnumC1358b enumC1358b, IOException iOException) {
        if (closeInternal(enumC1358b, iOException)) {
            this.d.writeSynReset(this.c, enumC1358b);
        }
    }

    public final synchronized boolean d() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            y yVar = this.f6585g;
            if (yVar.f6651f || yVar.e) {
                x xVar = this.f6586h;
                if ((xVar.c || xVar.b) && this.f6584f) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void e(C1376w c1376w, boolean z6) {
        boolean zD;
        synchronized (this) {
            try {
                if (this.f6584f && z6) {
                    this.f6585g.d = c1376w;
                } else {
                    this.f6584f = true;
                    this.e.add(c1376w);
                }
                if (z6) {
                    this.f6585g.f6651f = true;
                }
                zD = d();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zD) {
            return;
        }
        this.d.e(this.c);
    }

    public void receiveData(InterfaceC0171n interfaceC0171n, int i5) {
        this.f6585g.receive(interfaceC0171n, i5);
    }

    public synchronized C1376w takeHeaders() throws IOException {
        this.f6587i.j();
        while (this.e.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.f6587i.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.f6587i.exitAndThrowIfTimedOut();
        if (this.e.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new G(this.errorCode);
        }
        return (C1376w) this.e.removeFirst();
    }

    public synchronized C1376w trailers() throws IOException {
        C1376w c1376w;
        try {
            if (this.errorCode != null) {
                IOException iOException = this.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                throw new G(this.errorCode);
            }
            y yVar = this.f6585g;
            if (!yVar.f6651f || !yVar.f6650a.exhausted() || !this.f6585g.b.exhausted()) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
            c1376w = this.f6585g.d;
            if (c1376w == null) {
                c1376w = p107s4.d.c;
            }
        } catch (Throwable th) {
            throw th;
        }
        return c1376w;
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<C1359c> list, boolean z6, boolean z7) {
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            try {
                this.f6584f = true;
                if (z6) {
                    this.f6586h.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z7) {
            synchronized (this.d) {
                z7 = this.d.f6635s == 0;
            }
        }
        this.d.writeHeaders(this.c, z6, list);
        if (z7) {
            this.d.flush();
        }
    }
}
