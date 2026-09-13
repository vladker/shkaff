package okhttp3.internal.http2;

import A4.C0169l;
import A4.InterfaceC0171n;
import A4.h0;
import A4.k0;
import java.io.EOFException;
import java.io.IOException;
import okhttp3.C1376w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class y implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0169l f6650a = new C0169l();
    public final C0169l b = new C0169l();
    public final long c;
    public C1376w d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ A f6652g;

    public y(A a6, long j6) {
        this.f6652g = a6;
        this.c = j6;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long size;
        synchronized (this.f6652g) {
            this.e = true;
            size = this.b.size();
            this.b.a();
            this.f6652g.notifyAll();
        }
        if (size > 0) {
            this.f6652g.d.f(size);
        }
        this.f6652g.cancelStreamIfNecessary();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0092  */
    /* JADX WARN: Code duplicated, block: B:41:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x009d  */
    @Override // A4.h0
    public long read(C0169l c0169l, long j6) throws Throwable {
        Throwable g6;
        long j7;
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: "));
        }
        while (true) {
            synchronized (this.f6652g) {
                try {
                    this.f6652g.f6587i.j();
                    try {
                        A a6 = this.f6652g;
                        if (a6.errorCode != null) {
                            g6 = a6.errorException;
                            if (g6 == null) {
                                g6 = new G(this.f6652g.errorCode);
                            }
                        } else {
                            g6 = null;
                        }
                        if (this.e) {
                            throw new IOException("stream closed");
                        }
                        if (this.b.size() > 0) {
                            C0169l c0169l2 = this.b;
                            j7 = c0169l2.read(c0169l, Math.min(j6, c0169l2.size()));
                            A a7 = this.f6652g;
                            long j8 = a7.f6583a + j7;
                            a7.f6583a = j8;
                            if (g6 != null || j8 < a7.d.f6636t.a() / 2) {
                                break;
                                break;
                            }
                            A a8 = this.f6652g;
                            a8.d.i(a8.c, a8.f6583a);
                            this.f6652g.f6583a = 0L;
                            break;
                        }
                        if (this.f6651f || g6 != null) {
                            j7 = -1;
                            break;
                        }
                        this.f6652g.waitForIo();
                        this.f6652g.f6587i.exitAndThrowIfTimedOut();
                    } catch (Throwable th) {
                        this.f6652g.f6587i.exitAndThrowIfTimedOut();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (j7 != -1) {
                this.f6652g.d.f(j7);
                return j7;
            }
            if (g6 == null) {
                return -1L;
            }
            throw g6;
        }
        this.f6652g.f6587i.exitAndThrowIfTimedOut();
        if (j7 != -1) {
            this.f6652g.d.f(j7);
            return j7;
        }
        if (g6 == null) {
            return -1L;
        }
        throw g6;
    }

    public void receive(InterfaceC0171n interfaceC0171n, long j6) {
        boolean z6;
        boolean z7;
        long size;
        while (j6 > 0) {
            synchronized (this.f6652g) {
                z6 = this.f6651f;
                z7 = this.b.size() + j6 > this.c;
            }
            if (z7) {
                interfaceC0171n.skip(j6);
                this.f6652g.a(EnumC1358b.FLOW_CONTROL_ERROR);
                return;
            }
            if (z6) {
                interfaceC0171n.skip(j6);
                return;
            }
            long j7 = interfaceC0171n.read(this.f6650a, j6);
            if (j7 == -1) {
                throw new EOFException();
            }
            j6 -= j7;
            synchronized (this.f6652g) {
                try {
                    if (this.e) {
                        size = this.f6650a.size();
                        this.f6650a.a();
                    } else {
                        boolean z8 = this.b.size() == 0;
                        this.b.writeAll(this.f6650a);
                        if (z8) {
                            this.f6652g.notifyAll();
                        }
                        size = 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (size > 0) {
                this.f6652g.d.f(size);
            }
        }
    }

    @Override // A4.h0
    public final k0 timeout() {
        return this.f6652g.f6587i;
    }
}
