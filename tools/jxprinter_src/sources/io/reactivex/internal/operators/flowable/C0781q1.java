package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0781q1 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 8600231336733376951L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4734a;
    public final boolean b;
    public final int c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p027e3.o f4737h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t5.d f4739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4740k;
    public final AtomicLong d = new AtomicLong();
    public final p011b3.b e = new p011b3.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p100r3.c f4736g = new p100r3.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f4735f = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f4738i = new AtomicReference();

    public C0781q1(int i5, p027e3.o oVar, t5.c cVar, boolean z6) {
        this.f4734a = cVar;
        this.f4737h = oVar;
        this.b = z6;
        this.c = i5;
    }

    public final void a() {
        t5.c cVar = this.f4734a;
        AtomicInteger atomicInteger = this.f4735f;
        AtomicReference atomicReference = this.f4738i;
        int iAddAndGet = 1;
        do {
            long j6 = this.d.get();
            long j7 = 0;
            while (true) {
                if (j7 == j6) {
                    break;
                }
                if (this.f4740k) {
                    clear();
                    return;
                }
                if (!this.b && ((Throwable) this.f4736g.get()) != null) {
                    p100r3.c cVar2 = this.f4736g;
                    cVar2.getClass();
                    Throwable thB = p100r3.g.b(cVar2);
                    clear();
                    cVar.onError(thB);
                    return;
                }
                boolean z6 = atomicInteger.get() == 0;
                p083o3.d dVar = (p083o3.d) atomicReference.get();
                Object objPoll = dVar != null ? dVar.poll() : null;
                boolean z7 = objPoll == null;
                if (z6 && z7) {
                    p100r3.c cVar3 = this.f4736g;
                    cVar3.getClass();
                    Throwable thB2 = p100r3.g.b(cVar3);
                    if (thB2 != null) {
                        cVar.onError(thB2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
                if (z7) {
                    break;
                }
                cVar.onNext(objPoll);
                j7++;
            }
            if (j7 == j6) {
                if (this.f4740k) {
                    clear();
                    return;
                }
                if (!this.b && ((Throwable) this.f4736g.get()) != null) {
                    p100r3.c cVar4 = this.f4736g;
                    cVar4.getClass();
                    Throwable thB3 = p100r3.g.b(cVar4);
                    clear();
                    cVar.onError(thB3);
                    return;
                }
                boolean z8 = atomicInteger.get() == 0;
                p083o3.d dVar2 = (p083o3.d) atomicReference.get();
                boolean z9 = dVar2 == null || dVar2.isEmpty();
                if (z8 && z9) {
                    p100r3.c cVar5 = this.f4736g;
                    cVar5.getClass();
                    Throwable thB4 = p100r3.g.b(cVar5);
                    if (thB4 != null) {
                        cVar.onError(thB4);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            if (j7 != 0) {
                p122v2.a.e(this.d, j7);
                if (this.c != Integer.MAX_VALUE) {
                    this.f4739j.request(j7);
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    public final p083o3.d b() {
        while (true) {
            AtomicReference atomicReference = this.f4738i;
            p083o3.d dVar = (p083o3.d) atomicReference.get();
            if (dVar != null) {
                return dVar;
            }
            p083o3.d dVar2 = new p083o3.d(AbstractC0979l.f5366a);
            while (!atomicReference.compareAndSet(null, dVar2)) {
                if (atomicReference.get() != null) {
                }
            }
            return dVar2;
        }
    }

    @Override // t5.d
    public final void cancel() {
        this.f4740k = true;
        this.f4739j.cancel();
        this.e.dispose();
    }

    public final void clear() {
        p083o3.d dVar = (p083o3.d) this.f4738i.get();
        if (dVar != null) {
            dVar.clear();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4735f.decrementAndGet();
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4735f.decrementAndGet();
        p100r3.c cVar = this.f4736g;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!this.b) {
            this.e.dispose();
        }
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        try {
            Object objApply = this.f4737h.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null MaybeSource");
            io.reactivex.y yVar = (io.reactivex.y) objApply;
            this.f4735f.getAndIncrement();
            C0775p1 c0775p1 = new C0775p1(this);
            if (this.f4740k || !this.e.add(c0775p1)) {
                return;
            }
            ((AbstractC0985s) yVar).subscribe(c0775p1);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4739j.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4739j, dVar)) {
            this.f4739j = dVar;
            this.f4734a.onSubscribe(this);
            int i5 = this.c;
            if (i5 == Integer.MAX_VALUE) {
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                dVar.request(i5);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.d, j6);
            if (getAndIncrement() == 0) {
                a();
            }
        }
    }
}
