package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L1 extends p094q3.a implements InterfaceC0984q {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f4335q = new Object();
    private static final long serialVersionUID = -3688291656102519502L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4336a;
    public final p027e3.o b;
    public final p027e3.o c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f4337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p083o3.d f4338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Queue f4339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t5.d f4340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f4341j = new AtomicBoolean();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f4342k = new AtomicLong();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f4343l = new AtomicInteger(1);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Throwable f4344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f4345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4347p;

    public L1(t5.c cVar, p027e3.o oVar, p027e3.o oVar2, int i5, boolean z6, Map map, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.f4336a = cVar;
        this.b = oVar;
        this.c = oVar2;
        this.d = i5;
        this.e = z6;
        this.f4337f = map;
        this.f4339h = concurrentLinkedQueue;
        this.f4338g = new p083o3.d(i5);
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f4347p = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4341j.compareAndSet(false, true)) {
            i();
            if (this.f4343l.decrementAndGet() == 0) {
                this.f4340i.cancel();
            }
        }
    }

    @Override // p043h3.j
    public final void clear() {
        this.f4338g.clear();
    }

    public final boolean e(boolean z6, boolean z7, t5.c cVar, p083o3.d dVar) {
        if (this.f4341j.get()) {
            dVar.clear();
            return true;
        }
        if (this.e) {
            if (!z6 || !z7) {
                return false;
            }
            Throwable th = this.f4344m;
            if (th != null) {
                cVar.onError(th);
                return true;
            }
            cVar.onComplete();
            return true;
        }
        if (!z6) {
            return false;
        }
        Throwable th2 = this.f4344m;
        if (th2 != null) {
            dVar.clear();
            cVar.onError(th2);
            return true;
        }
        if (!z7) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public final void f() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        if (this.f4347p) {
            p083o3.d dVar = this.f4338g;
            t5.c cVar = this.f4336a;
            while (!this.f4341j.get()) {
                boolean z6 = this.f4345n;
                if (z6 && !this.e && (th = this.f4344m) != null) {
                    dVar.clear();
                    cVar.onError(th);
                    return;
                }
                cVar.onNext(null);
                if (z6) {
                    Throwable th2 = this.f4344m;
                    if (th2 != null) {
                        cVar.onError(th2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            dVar.clear();
            return;
        }
        p083o3.d dVar2 = this.f4338g;
        t5.c cVar2 = this.f4336a;
        int iAddAndGet2 = 1;
        do {
            long j6 = this.f4342k.get();
            long j7 = 0;
            while (j7 != j6) {
                boolean z7 = this.f4345n;
                p022d3.b bVar = (p022d3.b) dVar2.poll();
                boolean z8 = bVar == null;
                if (e(z7, z8, cVar2, dVar2)) {
                    return;
                }
                if (z8) {
                    break;
                }
                cVar2.onNext(bVar);
                j7++;
            }
            if (j7 == j6 && e(this.f4345n, dVar2.isEmpty(), cVar2, dVar2)) {
                return;
            }
            if (j7 != 0) {
                if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.f4342k.addAndGet(-j7);
                }
                this.f4340i.request(j7);
            }
            iAddAndGet2 = addAndGet(-iAddAndGet2);
        } while (iAddAndGet2 != 0);
    }

    public final void i() {
        Queue queue = this.f4339h;
        if (queue != null) {
            int i5 = 0;
            while (true) {
                M1 m6 = (M1) queue.poll();
                if (m6 == null) {
                    break;
                }
                N1 n6 = m6.c;
                n6.f4368f = true;
                n6.f();
                i5++;
            }
            if (i5 != 0) {
                this.f4343l.addAndGet(-i5);
            }
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.f4338g.isEmpty();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4346o) {
            return;
        }
        Iterator it = this.f4337f.values().iterator();
        while (it.hasNext()) {
            N1 n6 = ((M1) it.next()).c;
            n6.f4368f = true;
            n6.f();
        }
        this.f4337f.clear();
        Queue queue = this.f4339h;
        if (queue != null) {
            queue.clear();
        }
        this.f4346o = true;
        this.f4345n = true;
        f();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4346o) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4346o = true;
        Iterator it = this.f4337f.values().iterator();
        while (it.hasNext()) {
            N1 n6 = ((M1) it.next()).c;
            n6.f4369g = th;
            n6.f4368f = true;
            n6.f();
        }
        this.f4337f.clear();
        Queue queue = this.f4339h;
        if (queue != null) {
            queue.clear();
        }
        this.f4344m = th;
        this.f4345n = true;
        f();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        boolean z6;
        if (this.f4346o) {
            return;
        }
        try {
            Object objApply = this.b.apply(obj);
            Object obj2 = objApply != null ? objApply : f4335q;
            Map map = this.f4337f;
            M1 m6 = (M1) map.get(obj2);
            if (m6 != null) {
                z6 = false;
            } else {
                if (this.f4341j.get()) {
                    return;
                }
                int i5 = M1.d;
                M1 m7 = new M1(objApply, new N1(this.d, this, objApply, this.e));
                map.put(obj2, m7);
                this.f4343l.getAndIncrement();
                z6 = true;
                m6 = m7;
            }
            try {
                Object objApply2 = this.c.apply(obj);
                p039g3.A.b(objApply2, "The valueSelector returned null");
                N1 n6 = m6.c;
                n6.b.offer(objApply2);
                n6.f();
                i();
                if (z6) {
                    this.f4338g.offer(m6);
                    f();
                }
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                this.f4340i.cancel();
                onError(th);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.f4340i.cancel();
            onError(th2);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4340i, dVar)) {
            this.f4340i = dVar;
            this.f4336a.onSubscribe(this);
            dVar.request(this.d);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4342k, j6);
            f();
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public p022d3.b poll() {
        return (p022d3.b) this.f4338g.poll();
    }
}
