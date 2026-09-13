package p065l3;

import io.reactivex.AbstractC0985s;
import io.reactivex.I;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends AtomicInteger implements I, c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final E f5804i = new E(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5805a;
    public final o b;
    public final boolean c;
    public final p100r3.c d = new p100r3.c();
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f5806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5808h;

    public F(I i5, o oVar, boolean z6) {
        this.f5805a = i5;
        this.b = oVar;
        this.c = z6;
    }

    public final void a() {
        AtomicReference atomicReference = this.e;
        E e = f5804i;
        E e6 = (E) atomicReference.getAndSet(e);
        if (e6 == null || e6 == e) {
            return;
        }
        d.a(e6);
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        I i5 = this.f5805a;
        p100r3.c cVar = this.d;
        AtomicReference atomicReference = this.e;
        int iAddAndGet = 1;
        while (!this.f5808h) {
            if (cVar.get() != null && !this.c) {
                i5.onError(g.b(cVar));
                return;
            }
            boolean z6 = this.f5807g;
            E e = (E) atomicReference.get();
            boolean z7 = e == null;
            if (z6 && z7) {
                Throwable thB = g.b(cVar);
                if (thB != null) {
                    i5.onError(thB);
                    return;
                } else {
                    i5.onComplete();
                    return;
                }
            }
            if (z7 || e.b == null) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                while (!atomicReference.compareAndSet(e, null) && atomicReference.get() == e) {
                }
                i5.onNext(e.b);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5808h = true;
        this.f5806f.dispose();
        a();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5808h;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5807g = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (!this.c) {
            a();
        }
        this.f5807g = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        E e = f5804i;
        AtomicReference atomicReference = this.e;
        E e6 = (E) atomicReference.get();
        if (e6 != null) {
            d.a(e6);
        }
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null MaybeSource");
            y yVar = (y) objApply;
            E e7 = new E(this);
            while (true) {
                E e8 = (E) atomicReference.get();
                if (e8 == e) {
                    return;
                }
                do {
                    if (atomicReference.compareAndSet(e8, e7)) {
                        ((AbstractC0985s) yVar).subscribe(e7);
                        return;
                    }
                } while (atomicReference.get() == e8);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5806f.dispose();
            atomicReference.getAndSet(e);
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (d.g(this.f5806f, cVar)) {
            this.f5806f = cVar;
            this.f5805a.onSubscribe(this);
        }
    }
}
