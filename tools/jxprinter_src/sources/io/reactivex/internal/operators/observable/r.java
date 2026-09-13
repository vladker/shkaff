package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -8498650778633225126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0927s f5264a;

    public r(C0927s c0927s) {
        this.f5264a = c0927s;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p033f3.d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        lazySet(p033f3.d.f3969a);
        C0927s c0927s = this.f5264a;
        c0927s.e.delete(this);
        if (c0927s.e.b() == 0) {
            p033f3.d.a(c0927s.f5270f);
            c0927s.f5272h = true;
            c0927s.b();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        lazySet(p033f3.d.f3969a);
        C0927s c0927s = this.f5264a;
        p033f3.d.a(c0927s.f5270f);
        c0927s.e.delete(this);
        c0927s.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        C0927s c0927s = this.f5264a;
        c0927s.getClass();
        try {
            Object objCall = c0927s.b.call();
            p039g3.A.b(objCall, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) objCall;
            Object objApply = c0927s.d.apply(obj);
            p039g3.A.b(objApply, "The bufferClose returned a null ObservableSource");
            io.reactivex.G g6 = (io.reactivex.G) objApply;
            long j6 = c0927s.f5275k;
            c0927s.f5275k = 1 + j6;
            synchronized (c0927s) {
                try {
                    LinkedHashMap linkedHashMap = c0927s.f5276l;
                    if (linkedHashMap == null) {
                        return;
                    }
                    linkedHashMap.put(Long.valueOf(j6), collection);
                    C0932t c0932t = new C0932t(c0927s, j6);
                    c0927s.e.add(c0932t);
                    g6.subscribe(c0932t);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            p033f3.d.a(c0927s.f5270f);
            c0927s.onError(th2);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
