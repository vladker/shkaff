package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0985s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O0 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 8600231336733376951L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5054a;
    public final boolean b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f5055f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p011b3.c f5057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5058i;
    public final p011b3.b c = new p011b3.b();
    public final p100r3.c e = new p100r3.c();
    public final AtomicInteger d = new AtomicInteger(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f5056g = new AtomicReference();

    public O0(io.reactivex.I i5, p027e3.o oVar, boolean z6) {
        this.f5054a = i5;
        this.f5055f = oVar;
        this.b = z6;
    }

    public final void a() {
        io.reactivex.I i5 = this.f5054a;
        AtomicInteger atomicInteger = this.d;
        AtomicReference atomicReference = this.f5056g;
        int iAddAndGet = 1;
        while (!this.f5058i) {
            if (!this.b && ((Throwable) this.e.get()) != null) {
                p100r3.c cVar = this.e;
                cVar.getClass();
                Throwable thB = p100r3.g.b(cVar);
                p083o3.d dVar = (p083o3.d) this.f5056g.get();
                if (dVar != null) {
                    dVar.clear();
                }
                i5.onError(thB);
                return;
            }
            boolean z6 = atomicInteger.get() == 0;
            p083o3.d dVar2 = (p083o3.d) atomicReference.get();
            Object objPoll = dVar2 != null ? dVar2.poll() : null;
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                p100r3.c cVar2 = this.e;
                cVar2.getClass();
                Throwable thB2 = p100r3.g.b(cVar2);
                if (thB2 != null) {
                    i5.onError(thB2);
                    return;
                } else {
                    i5.onComplete();
                    return;
                }
            }
            if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                i5.onNext(objPoll);
            }
        }
        p083o3.d dVar3 = (p083o3.d) this.f5056g.get();
        if (dVar3 != null) {
            dVar3.clear();
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5058i = true;
        this.f5057h.dispose();
        this.c.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5058i;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.d.decrementAndGet();
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.d.decrementAndGet();
        p100r3.c cVar = this.e;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!this.b) {
            this.c.dispose();
        }
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        try {
            Object objApply = this.f5055f.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null MaybeSource");
            io.reactivex.y yVar = (io.reactivex.y) objApply;
            this.d.getAndIncrement();
            N0 n6 = new N0(this);
            if (this.f5058i || !this.c.add(n6)) {
                return;
            }
            ((AbstractC0985s) yVar).subscribe(n6);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5057h.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5057h, cVar)) {
            this.f5057h = cVar;
            this.f5054a.onSubscribe(this);
        }
    }
}
