package t4;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.C1348a;
import okhttp3.X;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadPoolExecutor f8689g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8690a;
    public final long b;
    public final W2.c c;
    public final ArrayDeque d;
    public final p075n1.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8691f;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = p107s4.d.f8235a;
        f8689g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new p107s4.c("OkHttp ConnectionPool", true));
    }

    public i() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.c = new W2.c(this, 18);
        this.d = new ArrayDeque();
        this.e = new p075n1.a(15);
        this.f8690a = 5;
        this.b = timeUnit.toNanos(5L);
    }

    public final void a(X x6, IOException iOException) {
        if (x6.b.type() != Proxy.Type.DIRECT) {
            C1348a c1348a = x6.f6549a;
            c1348a.f6555g.connectFailed(c1348a.f6553a.k(), x6.b.address(), iOException);
        }
        p075n1.a aVar = this.e;
        synchronized (aVar) {
            ((LinkedHashSet) aVar.b).add(x6);
        }
    }

    public final int b(h hVar, long j6) {
        ArrayList arrayList = hVar.f8687p;
        int i5 = 0;
        while (i5 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i5);
            if (reference.get() != null) {
                i5++;
            } else {
                p130w4.i.f8835a.i(((n) reference).f8698a, "A connection to " + hVar.c.f6549a.f6553a + " was leaked. Did you forget to close a response body?");
                arrayList.remove(i5);
                hVar.f8682k = true;
                if (arrayList.isEmpty()) {
                    hVar.f8688q = j6 - this.b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    public boolean transmitterAcquirePooledConnection(C1348a c1348a, o oVar, List<X> list, boolean z6) {
        for (h hVar : this.d) {
            if (!z6 || hVar.f8679h != null) {
                if (hVar.isEligible(c1348a, list)) {
                    oVar.a(hVar);
                    return true;
                }
            }
        }
        return false;
    }
}
