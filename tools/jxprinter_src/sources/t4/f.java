package t4;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import okhttp3.C1348a;
import okhttp3.C1371q;
import okhttp3.H;
import okhttp3.InterfaceC1353f;
import okhttp3.K;
import okhttp3.X;
import okhttp3.internal.http2.s;
import okhttp3.r;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f8670a;
    public final C1348a b;
    public final i c;
    public final InterfaceC1353f d;
    public final r e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f8671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f8672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f8673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public X f8675j;

    public f(o oVar, i iVar, C1348a c1348a, K k6, C1371q c1371q) {
        this.f8670a = oVar;
        this.c = iVar;
        this.b = c1348a;
        this.d = k6;
        this.e = c1371q;
        this.f8672g = new l(c1348a, iVar.e, k6, c1371q);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    private h findConnection(int i5, int i6, int i7, int i8, boolean z6) {
        h hVar;
        Socket socket;
        Socket socketReleaseConnectionNoEvents;
        h hVar2;
        boolean z7;
        X x6;
        boolean z8;
        ArrayList arrayList;
        h hVar3;
        k kVar;
        synchronized (this.c) {
            try {
                if (this.f8670a.f()) {
                    throw new IOException("Canceled");
                }
                this.f8674i = false;
                o oVar = this.f8670a;
                hVar = oVar.f8702h;
                socket = null;
                socketReleaseConnectionNoEvents = (hVar == null || !hVar.f8682k) ? null : oVar.releaseConnectionNoEvents();
                o oVar2 = this.f8670a;
                hVar2 = oVar2.f8702h;
                if (hVar2 != null) {
                    hVar = null;
                } else {
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    z7 = false;
                    x6 = null;
                } else if (this.c.transmitterAcquirePooledConnection(this.b, oVar2, null, false)) {
                    hVar2 = this.f8670a.f8702h;
                    x6 = null;
                    z7 = true;
                } else {
                    x6 = this.f8675j;
                    if (x6 != null) {
                        this.f8675j = null;
                    } else if (c()) {
                        x6 = this.f8670a.f8702h.c;
                    } else {
                        z7 = false;
                        x6 = null;
                    }
                    z7 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        p107s4.d.d(socketReleaseConnectionNoEvents);
        if (hVar != null) {
            this.e.getClass();
        }
        if (z7) {
            this.e.getClass();
        }
        if (hVar2 != null) {
            return hVar2;
        }
        if (x6 != null || ((kVar = this.f8671f) != null && kVar.b < kVar.f8693a.size())) {
            z8 = false;
        } else {
            this.f8671f = this.f8672g.next();
            z8 = true;
        }
        synchronized (this.c) {
            try {
                if (this.f8670a.f()) {
                    throw new IOException("Canceled");
                }
                if (z8) {
                    k kVar2 = this.f8671f;
                    kVar2.getClass();
                    arrayList = new ArrayList(kVar2.f8693a);
                    if (this.c.transmitterAcquirePooledConnection(this.b, this.f8670a, arrayList, false)) {
                        hVar2 = this.f8670a.f8702h;
                        z7 = true;
                    }
                } else {
                    arrayList = null;
                }
                if (!z7) {
                    if (x6 == null) {
                        k kVar3 = this.f8671f;
                        if (!(kVar3.b < kVar3.f8693a.size())) {
                            throw new NoSuchElementException();
                        }
                        ArrayList arrayList2 = kVar3.f8693a;
                        int i9 = kVar3.b;
                        kVar3.b = i9 + 1;
                        x6 = (X) arrayList2.get(i9);
                    }
                    hVar2 = new h(this.c, x6);
                    this.f8673h = hVar2;
                }
                hVar3 = hVar2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z7) {
            this.e.getClass();
            return hVar3;
        }
        hVar3.b(i5, i6, i7, i8, z6, this.d, this.e);
        p075n1.a aVar = this.c.e;
        X x7 = hVar3.c;
        synchronized (aVar) {
            ((LinkedHashSet) aVar.b).remove(x7);
        }
        synchronized (this.c) {
            try {
                this.f8673h = null;
                if (this.c.transmitterAcquirePooledConnection(this.b, this.f8670a, arrayList, true)) {
                    hVar3.f8682k = true;
                    socket = hVar3.e;
                    hVar3 = this.f8670a.f8702h;
                    this.f8675j = x6;
                } else {
                    i iVar = this.c;
                    if (!iVar.f8691f) {
                        iVar.f8691f = true;
                        i.f8689g.execute(iVar.c);
                    }
                    iVar.d.add(hVar3);
                    this.f8670a.a(hVar3);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        p107s4.d.d(socket);
        this.e.getClass();
        return hVar3;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001c A[Catch: all -> 0x0018, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {all -> 0x0018, blocks: (B:4:0x0007, B:6:0x000c, B:11:0x0015, B:15:0x001c), top: B:61:0x0007 }] */
    private h findHealthyConnection(int i5, int i6, int i7, int i8, boolean z6, boolean z7) {
        h hVarFindConnection;
        while (true) {
            hVarFindConnection = findConnection(i5, i6, i7, i8, z6);
            synchronized (this.c) {
                try {
                    if (hVarFindConnection.f8684m != 0) {
                        if (hVarFindConnection.e.isClosed() && !hVarFindConnection.e.isInputShutdown() && !hVarFindConnection.e.isOutputShutdown()) {
                            s sVar = hVarFindConnection.f8679h;
                            if (sVar == null) {
                                if (!z7) {
                                    break;
                                }
                                try {
                                    int soTimeout = hVarFindConnection.e.getSoTimeout();
                                    try {
                                        hVarFindConnection.e.setSoTimeout(1);
                                        if (!hVarFindConnection.f8680i.exhausted()) {
                                            break;
                                        }
                                        hVarFindConnection.e.setSoTimeout(soTimeout);
                                    } finally {
                                        hVarFindConnection.e.setSoTimeout(soTimeout);
                                    }
                                } catch (SocketTimeoutException unused) {
                                } catch (IOException unused2) {
                                    continue;
                                }
                            } else {
                                long jNanoTime = System.nanoTime();
                                synchronized (sVar) {
                                    if (!sVar.f6623g) {
                                        if (sVar.f6630n >= sVar.f6629m || jNanoTime < sVar.f6633q) {
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        hVarFindConnection.c();
                    } else {
                        if (!(hVarFindConnection.f8679h != null)) {
                            break;
                        }
                        if (hVarFindConnection.e.isClosed()) {
                        }
                        hVarFindConnection.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return hVarFindConnection;
    }

    public final p118u4.c a(H h6, z zVar, boolean z6) {
        p118u4.f fVar = (p118u4.f) zVar;
        try {
            return findHealthyConnection(fVar.f8738f, fVar.f8739g, fVar.f8740h, h6.f6532y, h6.f6527t, z6).newCodec(h6, zVar);
        } catch (IOException e) {
            synchronized (this.c) {
                this.f8674i = true;
                throw new j(e);
            }
        } catch (j e6) {
            synchronized (this.c) {
                this.f8674i = true;
                throw e6;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0030 A[Catch: all -> 0x000a, TryCatch #0 {all -> 0x000a, blocks: (B:4:0x0003, B:6:0x0008, B:10:0x000c, B:12:0x0012, B:13:0x001a, B:15:0x001c, B:17:0x0021, B:32:0x004c, B:22:0x0030, B:25:0x003d), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x004b  */
    public final boolean b() {
        l lVar;
        synchronized (this.c) {
            try {
                boolean z6 = true;
                if (this.f8675j != null) {
                    return true;
                }
                if (c()) {
                    this.f8675j = this.f8670a.f8702h.c;
                    return true;
                }
                k kVar = this.f8671f;
                if (kVar == null) {
                    lVar = this.f8672g;
                    if (!(lVar.e < lVar.d.size() || !lVar.f8696g.isEmpty())) {
                        z6 = false;
                    }
                } else {
                    if (!(kVar.b < kVar.f8693a.size())) {
                        lVar = this.f8672g;
                        if (lVar.e < lVar.d.size()) {
                            if (!(lVar.e < lVar.d.size() || !lVar.f8696g.isEmpty())) {
                                z6 = false;
                            }
                        }
                        if (!(lVar.e < lVar.d.size() || !lVar.f8696g.isEmpty())) {
                            z6 = false;
                        }
                    }
                }
                return z6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        h hVar = this.f8670a.f8702h;
        return hVar != null && hVar.f8683l == 0 && p107s4.d.m(hVar.c.f6549a.f6553a, this.b.f6553a);
    }
}
