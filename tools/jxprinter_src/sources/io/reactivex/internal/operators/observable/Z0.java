package io.reactivex.internal.operators.observable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z0 extends AtomicInteger implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f5135i = new Object();
    private static final long serialVersionUID = -3688291656102519502L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5136a;
    public final p027e3.o b;
    public final p027e3.o c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p011b3.c f5138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f5139h = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f5137f = new ConcurrentHashMap();

    public Z0(io.reactivex.I i5, p027e3.o oVar, p027e3.o oVar2, int i6, boolean z6) {
        this.f5136a = i5;
        this.b = oVar;
        this.c = oVar2;
        this.d = i6;
        this.e = z6;
        lazySet(1);
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5139h.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.f5138g.dispose();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5139h.get();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        ArrayList arrayList = new ArrayList(this.f5137f.values());
        this.f5137f.clear();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            C0845b1 c0845b1 = ((C0840a1) obj).b;
            c0845b1.e = true;
            c0845b1.a();
        }
        this.f5136a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f5137f.values());
        this.f5137f.clear();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            C0845b1 c0845b1 = ((C0840a1) obj).b;
            c0845b1.f5148f = th;
            c0845b1.e = true;
            c0845b1.a();
        }
        this.f5136a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            Object obj2 = objApply != null ? objApply : f5135i;
            ConcurrentHashMap concurrentHashMap = this.f5137f;
            C0840a1 c0840a1 = (C0840a1) concurrentHashMap.get(obj2);
            if (c0840a1 == null) {
                if (this.f5139h.get()) {
                    return;
                }
                C0840a1 c0840a2 = new C0840a1(objApply, new C0845b1(this.d, this, objApply, this.e));
                concurrentHashMap.put(obj2, c0840a2);
                getAndIncrement();
                this.f5136a.onNext(c0840a2);
                c0840a1 = c0840a2;
            }
            try {
                Object objApply2 = this.c.apply(obj);
                p039g3.A.b(objApply2, "The value supplied is null");
                C0845b1 c0845b1 = c0840a1.b;
                c0845b1.b.offer(objApply2);
                c0845b1.a();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                this.f5138g.dispose();
                onError(th);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.f5138g.dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5138g, cVar)) {
            this.f5138g = cVar;
            this.f5136a.onSubscribe(this);
        }
    }
}
