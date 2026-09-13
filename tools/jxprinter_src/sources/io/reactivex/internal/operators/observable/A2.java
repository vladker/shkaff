package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A2 extends AtomicInteger implements io.reactivex.I {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4864a;
    public final p033f3.h b;
    public final io.reactivex.G c;
    public final p027e3.d d;
    public int e;

    public A2(io.reactivex.I i5, p027e3.d dVar, p033f3.h hVar, io.reactivex.G g6) {
        this.f4864a = i5;
        this.b = hVar;
        this.c = g6;
        this.d = dVar;
    }

    public final void a() {
        if (getAndIncrement() == 0) {
            int iAddAndGet = 1;
            while (!this.b.e()) {
                this.c.subscribe(this);
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f4864a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        io.reactivex.I i5 = this.f4864a;
        try {
            p027e3.d dVar = this.d;
            int i6 = this.e + 1;
            this.e = i6;
            Integer numValueOf = Integer.valueOf(i6);
            ((V1.b) dVar).getClass();
            if (p039g3.A.a(numValueOf, th)) {
                a();
            } else {
                i5.onError(th);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            i5.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f4864a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.h hVar = this.b;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }
}
