package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0820x extends AtomicReference implements InterfaceC0984q, p011b3.c {
    private static final long serialVersionUID = -8498650778633225126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0826y f4821a;

    public C0820x(C0826y c0826y) {
        this.f4821a = c0826y;
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
        lazySet(p094q3.g.f7849a);
        C0826y c0826y = this.f4821a;
        c0826y.e.delete(this);
        if (c0826y.e.b() == 0) {
            p094q3.g.a(c0826y.f4834g);
            c0826y.f4836i = true;
            c0826y.b();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        lazySet(p094q3.g.f7849a);
        C0826y c0826y = this.f4821a;
        p094q3.g.a(c0826y.f4834g);
        c0826y.e.delete(this);
        c0826y.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        C0826y c0826y = this.f4821a;
        c0826y.getClass();
        try {
            Object objCall = c0826y.b.call();
            p039g3.A.b(objCall, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) objCall;
            Object objApply = c0826y.d.apply(obj);
            p039g3.A.b(objApply, "The bufferClose returned a null Publisher");
            t5.b bVar = (t5.b) objApply;
            long j6 = c0826y.f4839l;
            c0826y.f4839l = 1 + j6;
            synchronized (c0826y) {
                try {
                    LinkedHashMap linkedHashMap = c0826y.f4840m;
                    if (linkedHashMap == null) {
                        return;
                    }
                    linkedHashMap.put(Long.valueOf(j6), collection);
                    C0832z c0832z = new C0832z(c0826y, j6);
                    c0826y.e.add(c0832z);
                    bVar.subscribe(c0832z);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            p094q3.g.a(c0826y.f4834g);
            c0826y.onError(th2);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
