package p065l3;

import io.reactivex.O;
import io.reactivex.V;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends AtomicInteger implements io.reactivex.I, c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final H f5811i = new H(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5812a;
    public final o b;
    public final boolean c;
    public final p100r3.c d = new p100r3.c();
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f5813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5815h;

    public I(io.reactivex.I i5, o oVar, boolean z6) {
        this.f5812a = i5;
        this.b = oVar;
        this.c = z6;
    }

    public final void a() {
        AtomicReference atomicReference = this.e;
        H h6 = f5811i;
        H h7 = (H) atomicReference.getAndSet(h6);
        if (h7 == null || h7 == h6) {
            return;
        }
        d.a(h7);
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f5812a;
        p100r3.c cVar = this.d;
        AtomicReference atomicReference = this.e;
        int iAddAndGet = 1;
        while (!this.f5815h) {
            if (cVar.get() != null && !this.c) {
                i5.onError(g.b(cVar));
                return;
            }
            boolean z6 = this.f5814g;
            H h6 = (H) atomicReference.get();
            boolean z7 = h6 == null;
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
            if (z7 || h6.b == null) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                while (!atomicReference.compareAndSet(h6, null) && atomicReference.get() == h6) {
                }
                i5.onNext(h6.b);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5815h = true;
        this.f5813f.dispose();
        a();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5815h;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5814g = true;
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
        this.f5814g = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        H h6 = f5811i;
        AtomicReference atomicReference = this.e;
        H h7 = (H) atomicReference.get();
        if (h7 != null) {
            d.a(h7);
        }
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null SingleSource");
            V v6 = (V) objApply;
            H h8 = new H(this);
            while (true) {
                H h9 = (H) atomicReference.get();
                if (h9 == h6) {
                    return;
                }
                do {
                    if (atomicReference.compareAndSet(h9, h8)) {
                        ((O) v6).subscribe(h8);
                        return;
                    }
                } while (atomicReference.get() == h9);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5813f.dispose();
            atomicReference.getAndSet(h6);
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (d.g(this.f5813f, cVar)) {
            this.f5813f = cVar;
            this.f5812a.onSubscribe(this);
        }
    }
}
