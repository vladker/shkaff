package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.g1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0721g1 extends AtomicReference implements InterfaceC0984q, p011b3.c {
    private static final long serialVersionUID = -4606175640614850599L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4628a;
    public final C0727h1 b;
    public final int c;
    public final int d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile p043h3.j f4629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4631h;

    public C0721g1(C0727h1 c0727h1, long j6) {
        this.f4628a = j6;
        this.b = c0727h1;
        int i5 = c0727h1.e;
        this.d = i5;
        this.c = i5 >> 2;
    }

    public final void a(long j6) {
        if (this.f4631h != 1) {
            long j7 = this.f4630g + j6;
            if (j7 < this.c) {
                this.f4630g = j7;
            } else {
                this.f4630g = 0L;
                ((t5.d) get()).request(j7);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        this.e = true;
        this.b.b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        lazySet(p094q3.g.f7849a);
        C0727h1 c0727h1 = this.b;
        p100r3.c cVar = c0727h1.f4643h;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.e = true;
        if (!c0727h1.c) {
            c0727h1.f4647l.cancel();
            for (C0721g1 c0721g1 : (C0721g1[]) c0727h1.f4645j.getAndSet(C0727h1.f4639s)) {
                c0721g1.getClass();
                p094q3.g.a(c0721g1);
            }
        }
        c0727h1.b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4631h == 2) {
            this.b.b();
            return;
        }
        C0727h1 c0727h1 = this.b;
        if (c0727h1.get() == 0 && c0727h1.compareAndSet(0, 1)) {
            long j6 = c0727h1.f4646k.get();
            p043h3.j cVar = this.f4629f;
            if (j6 == 0 || !(cVar == null || cVar.isEmpty())) {
                if (cVar == null && (cVar = this.f4629f) == null) {
                    cVar = new p083o3.c(c0727h1.e);
                    this.f4629f = cVar;
                }
                if (!cVar.offer(obj)) {
                    c0727h1.onError(new p017c3.e("Inner queue full?!"));
                    return;
                }
            } else {
                c0727h1.f4640a.onNext(obj);
                if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    c0727h1.f4646k.decrementAndGet();
                }
                a(1L);
            }
            if (c0727h1.decrementAndGet() == 0) {
                return;
            }
        } else {
            p043h3.j cVar2 = this.f4629f;
            if (cVar2 == null) {
                cVar2 = new p083o3.c(c0727h1.e);
                this.f4629f = cVar2;
            }
            if (!cVar2.offer(obj)) {
                c0727h1.onError(new p017c3.e("Inner queue full?!"));
                return;
            } else if (c0727h1.getAndIncrement() != 0) {
                return;
            }
        }
        c0727h1.c();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this, dVar)) {
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f4631h = iC;
                    this.f4629f = gVar;
                    this.e = true;
                    this.b.b();
                    return;
                }
                if (iC == 2) {
                    this.f4631h = iC;
                    this.f4629f = gVar;
                }
            }
            dVar.request(this.d);
        }
    }
}
