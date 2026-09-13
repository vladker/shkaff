package okhttp3.internal.http2;

import A3.AbstractC0157z;
import A4.C0169l;
import A4.InterfaceC0171n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class s implements Closeable {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ThreadPoolExecutor f6620z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6621a;
    public final o b;
    public final String d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f6624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ThreadPoolExecutor f6625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final D f6626j;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f6635s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final F f6636t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final F f6637u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Socket f6638v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final B f6639w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final r f6640x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LinkedHashSet f6641y;
    public final LinkedHashMap c = new LinkedHashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f6627k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f6628l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6629m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f6630n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6631o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f6632p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f6633q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f6634r = 0;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = p107s4.d.f8235a;
        f6620z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new p107s4.c("OkHttp Http2Connection", true));
    }

    public s(m mVar) {
        F f6 = new F();
        this.f6636t = f6;
        F f7 = new F();
        this.f6637u = f7;
        this.f6641y = new LinkedHashSet();
        this.f6626j = E.f6593a;
        boolean z6 = mVar.f6617f;
        this.f6621a = z6;
        this.b = mVar.e;
        int i5 = z6 ? 1 : 2;
        this.f6622f = i5;
        if (z6) {
            this.f6622f = i5 + 2;
        }
        if (z6) {
            f6.b(7, 16777216);
        }
        String str = mVar.b;
        this.d = str;
        byte[] bArr = p107s4.d.f8235a;
        Locale locale = Locale.US;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new p107s4.c(AbstractC0157z.o("OkHttp ", str, " Writer"), false));
        this.f6624h = scheduledThreadPoolExecutor;
        if (mVar.f6618g != 0) {
            i iVar = new i(this);
            long j6 = mVar.f6618g;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, j6, j6, TimeUnit.MILLISECONDS);
        }
        this.f6625i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new p107s4.c(AbstractC0157z.o("OkHttp ", str, " Push Observer"), true));
        f7.b(7, 65535);
        f7.b(5, 16384);
        this.f6635s = f7.a();
        this.f6638v = mVar.f6616a;
        this.f6639w = new B(mVar.d, z6);
        this.f6640x = new r(this, new w(mVar.c, z6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection(IOException iOException) {
        EnumC1358b enumC1358b = EnumC1358b.PROTOCOL_ERROR;
        close(enumC1358b, enumC1358b, iOException);
    }

    public synchronized void awaitPong() {
        while (this.f6632p < this.f6631o) {
            wait();
        }
    }

    public final synchronized A b(int i5) {
        return (A) this.c.get(Integer.valueOf(i5));
    }

    public final synchronized int c() {
        F f6;
        f6 = this.f6637u;
        return (f6.f6594a & 16) != 0 ? f6.b[4] : Integer.MAX_VALUE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close(EnumC1358b.NO_ERROR, EnumC1358b.CANCEL, null);
    }

    public final synchronized void d(p107s4.b bVar) {
        if (!this.f6623g) {
            this.f6625i.execute(bVar);
        }
    }

    public final synchronized A e(int i5) {
        A a6;
        a6 = (A) this.c.remove(Integer.valueOf(i5));
        notifyAll();
        return a6;
    }

    public final synchronized void f(long j6) {
        long j7 = this.f6634r + j6;
        this.f6634r = j7;
        if (j7 >= this.f6636t.a() / 2) {
            i(0, this.f6634r);
            this.f6634r = 0L;
        }
    }

    public void flush() {
        this.f6639w.flush();
    }

    public final void g(boolean z6, int i5, int i6) {
        try {
            this.f6639w.ping(z6, i5, i6);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void h(int i5, EnumC1358b enumC1358b) {
        try {
            this.f6624h.execute(new j(this, new Object[]{this.d, Integer.valueOf(i5)}, i5, enumC1358b));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void i(int i5, long j6) {
        try {
            this.f6624h.execute(new h(this, new Object[]{this.d, Integer.valueOf(i5)}, i5, j6));
        } catch (RejectedExecutionException unused) {
        }
    }

    public A newStream(List<C1359c> list, boolean z6) {
        return newStream(0, list, z6);
    }

    public void pushDataLater(int i5, InterfaceC0171n interfaceC0171n, int i6, boolean z6) throws IOException {
        C0169l c0169l = new C0169l();
        long j6 = i6;
        interfaceC0171n.require(j6);
        interfaceC0171n.read(c0169l, j6);
        if (c0169l.size() == j6) {
            d(new k(this, new Object[]{this.d, Integer.valueOf(i5)}, i5, c0169l, i6, z6));
            return;
        }
        throw new IOException(c0169l.size() + " != " + i6);
    }

    public A pushStream(int i5, List<C1359c> list, boolean z6) {
        if (this.f6621a) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i5, list, z6);
    }

    public void setSettings(F f6) {
        synchronized (this.f6639w) {
            synchronized (this) {
                if (this.f6623g) {
                    throw new C1357a();
                }
                F f7 = this.f6636t;
                f7.getClass();
                for (int i5 = 0; i5 < 10; i5++) {
                    if (((1 << i5) & f6.f6594a) != 0) {
                        f7.b(i5, f6.b[i5]);
                    }
                }
            }
            this.f6639w.settings(f6);
        }
    }

    public void shutdown(EnumC1358b enumC1358b) {
        synchronized (this.f6639w) {
            synchronized (this) {
                if (this.f6623g) {
                    return;
                }
                this.f6623g = true;
                this.f6639w.goAway(this.e, enumC1358b, p107s4.d.f8235a);
            }
        }
    }

    public void start() {
        start(true);
    }

    public void writeData(int i5, boolean z6, C0169l c0169l, long j6) {
        long j7;
        int iMin;
        long j8;
        if (j6 == 0) {
            this.f6639w.data(z6, i5, c0169l, 0);
            return;
        }
        while (j6 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j7 = this.f6635s;
                            if (j7 <= 0) {
                                if (!this.c.containsKey(Integer.valueOf(i5))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    throw th;
                }
                iMin = Math.min((int) Math.min(j6, j7), this.f6639w.d);
                j8 = iMin;
                this.f6635s -= j8;
            }
            j6 -= j8;
            this.f6639w.data(z6 && j6 == 0, i5, c0169l, iMin);
        }
    }

    public void writeHeaders(int i5, boolean z6, List<C1359c> list) {
        this.f6639w.headers(z6, i5, list);
    }

    public void writePingAndAwaitPong() {
        synchronized (this) {
            this.f6631o++;
        }
        g(false, 3, 1330343787);
        awaitPong();
    }

    public void writeSynReset(int i5, EnumC1358b enumC1358b) {
        this.f6639w.rstStream(i5, enumC1358b);
    }

    private A newStream(int i5, List<C1359c> list, boolean z6) throws Throwable {
        Throwable th;
        boolean z7 = !z6;
        synchronized (this.f6639w) {
            try {
                try {
                    try {
                        synchronized (this) {
                            try {
                                if (this.f6622f > 1073741823) {
                                    try {
                                        shutdown(EnumC1358b.REFUSED_STREAM);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                if (this.f6623g) {
                                    throw new C1357a();
                                }
                                int i6 = this.f6622f;
                                this.f6622f = i6 + 2;
                                A a6 = new A(i6, this, z7, false, null);
                                boolean z8 = !z6 || this.f6635s == 0 || a6.b == 0;
                                if (a6.d()) {
                                    this.c.put(Integer.valueOf(i6), a6);
                                }
                                if (i5 == 0) {
                                    this.f6639w.headers(z7, i6, list);
                                } else {
                                    if (this.f6621a) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    this.f6639w.pushPromise(i5, i6, list);
                                }
                                if (z8) {
                                    this.f6639w.flush();
                                }
                                return a6;
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public void close(EnumC1358b enumC1358b, EnumC1358b enumC1358b2, IOException iOException) {
        A[] aArr;
        try {
            shutdown(enumC1358b);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.c.isEmpty()) {
                    aArr = null;
                } else {
                    aArr = (A[]) this.c.values().toArray(new A[this.c.size()]);
                    this.c.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aArr != null) {
            for (A a6 : aArr) {
                try {
                    a6.close(enumC1358b2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f6639w.close();
        } catch (IOException unused3) {
        }
        try {
            this.f6638v.close();
        } catch (IOException unused4) {
        }
        this.f6624h.shutdown();
        this.f6625i.shutdown();
    }

    public void start(boolean z6) {
        if (z6) {
            B b = this.f6639w;
            b.connectionPreface();
            F f6 = this.f6636t;
            b.settings(f6);
            int iA = f6.a();
            if (iA != 65535) {
                b.windowUpdate(0, iA - 65535);
            }
        }
        new Thread(this.f6640x).start();
    }
}
