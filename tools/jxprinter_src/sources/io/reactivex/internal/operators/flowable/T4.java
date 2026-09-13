package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T4 extends AtomicInteger implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = 2428527070996323976L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4448a;
    public final p083o3.d b;
    public final long c;
    public final long d;
    public final ArrayDeque e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f4450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f4451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f4452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public t5.d f4456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f4457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Throwable f4458o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f4459p;

    public T4(t5.c cVar, long j6, long j7, int i5) {
        super(1);
        this.f4448a = cVar;
        this.c = j6;
        this.d = j7;
        this.b = new p083o3.d(i5);
        this.e = new ArrayDeque();
        this.f4449f = new AtomicBoolean();
        this.f4450g = new AtomicBoolean();
        this.f4451h = new AtomicLong();
        this.f4452i = new AtomicInteger();
        this.f4453j = i5;
    }

    public final boolean a(boolean z6, boolean z7, t5.c cVar, p083o3.d dVar) {
        if (this.f4459p) {
            dVar.clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        Throwable th = this.f4458o;
        if (th != null) {
            dVar.clear();
            cVar.onError(th);
            return true;
        }
        if (!z7) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public final void b() {
        if (this.f4452i.getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4448a;
        p083o3.d dVar = this.b;
        int iAddAndGet = 1;
        do {
            long j6 = this.f4451h.get();
            long j7 = 0;
            while (j7 != j6) {
                boolean z6 = this.f4457n;
                p123v3.d dVar2 = (p123v3.d) dVar.poll();
                boolean z7 = dVar2 == null;
                if (a(z6, z7, cVar, dVar)) {
                    return;
                }
                if (z7) {
                    break;
                }
                cVar.onNext(dVar2);
                j7++;
            }
            if (j7 == j6 && a(this.f4457n, dVar.isEmpty(), cVar, dVar)) {
                return;
            }
            if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f4451h.addAndGet(-j7);
            }
            iAddAndGet = this.f4452i.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        this.f4459p = true;
        if (this.f4449f.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4457n) {
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((t5.a) it.next()).onComplete();
        }
        this.e.clear();
        this.f4457n = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4457n) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((t5.a) it.next()).onError(th);
        }
        this.e.clear();
        this.f4458o = th;
        this.f4457n = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4457n) {
            return;
        }
        long j6 = this.f4454k;
        if (j6 == 0 && !this.f4459p) {
            getAndIncrement();
            p123v3.d dVarCreate = p123v3.d.create(this.f4453j, this);
            this.e.offer(dVarCreate);
            this.b.offer(dVarCreate);
            b();
        }
        long j7 = j6 + 1;
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((t5.a) it.next()).onNext(obj);
        }
        long j8 = this.f4455l + 1;
        if (j8 == this.c) {
            this.f4455l = j8 - this.d;
            t5.a aVar = (t5.a) this.e.poll();
            if (aVar != null) {
                aVar.onComplete();
            }
        } else {
            this.f4455l = j8;
        }
        if (j7 == this.d) {
            this.f4454k = 0L;
        } else {
            this.f4454k = j7;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4456m, dVar)) {
            this.f4456m = dVar;
            this.f4448a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4451h, j6);
            AtomicBoolean atomicBoolean = this.f4450g;
            boolean z6 = atomicBoolean.get();
            long j7 = this.d;
            if (z6 || !atomicBoolean.compareAndSet(false, true)) {
                this.f4456m.request(p122v2.a.d(j7, j6));
            } else {
                this.f4456m.request(p122v2.a.c(this.c, p122v2.a.d(j7, j6 - 1)));
            }
            b();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f4456m.cancel();
        }
    }
}
