package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L0 extends AtomicInteger implements p011b3.c, io.reactivex.I {
    private static final long serialVersionUID = 8443155186132538303L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5003a;
    public final p027e3.o c;
    public final boolean d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f5004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5005g;
    public final p100r3.c b = new p100r3.c();
    public final p011b3.b e = new p011b3.b();

    public L0(InterfaceC0679f interfaceC0679f, p027e3.o oVar, boolean z6) {
        this.f5003a = interfaceC0679f;
        this.c = oVar;
        this.d = z6;
        lazySet(1);
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5005g = true;
        this.f5004f.dispose();
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5004f.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            p100r3.c cVar = this.b;
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            InterfaceC0679f interfaceC0679f = this.f5003a;
            if (thB != null) {
                interfaceC0679f.onError(thB);
            } else {
                interfaceC0679f.onComplete();
            }
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.b;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        boolean z6 = this.d;
        InterfaceC0679f interfaceC0679f = this.f5003a;
        if (z6) {
            if (decrementAndGet() == 0) {
                cVar.getClass();
                interfaceC0679f.onError(p100r3.g.b(cVar));
                return;
            }
            return;
        }
        dispose();
        if (getAndSet(0) > 0) {
            cVar.getClass();
            interfaceC0679f.onError(p100r3.g.b(cVar));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        try {
            Object objApply = this.c.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            getAndIncrement();
            K0 k6 = new K0(this);
            if (this.f5005g || !this.e.add(k6)) {
                return;
            }
            ((AbstractC0676c) interfaceC0682i).subscribe(k6);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5004f.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5004f, cVar)) {
            this.f5004f = cVar;
            this.f5003a.onSubscribe(this);
        }
    }
}
