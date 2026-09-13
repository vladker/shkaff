package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0859e0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5176a;
    public final p027e3.o b;
    public p011b3.c c;
    public final AtomicReference d = new AtomicReference();
    public volatile long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5177f;

    public C0859e0(p112t3.e eVar, p027e3.o oVar) {
        this.f5176a = eVar;
        this.b = oVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.dispose();
        p033f3.d.a(this.d);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5177f) {
            return;
        }
        this.f5177f = true;
        AtomicReference atomicReference = this.d;
        p011b3.c cVar = (p011b3.c) atomicReference.get();
        if (cVar != p033f3.d.f3969a) {
            ((C0854d0) cVar).a();
            p033f3.d.a(atomicReference);
            this.f5176a.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.d);
        this.f5176a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5177f) {
            return;
        }
        long j6 = this.e + 1;
        this.e = j6;
        p011b3.c cVar = (p011b3.c) this.d.get();
        if (cVar != null) {
            cVar.dispose();
        }
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The ObservableSource supplied is null");
            io.reactivex.G g6 = (io.reactivex.G) objApply;
            C0854d0 c0854d0 = new C0854d0(this, j6, obj);
            AtomicReference atomicReference = this.d;
            while (!atomicReference.compareAndSet(cVar, c0854d0)) {
                if (atomicReference.get() != cVar) {
                    return;
                }
            }
            g6.subscribe(c0854d0);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            dispose();
            this.f5176a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5176a.onSubscribe(this);
        }
    }
}
