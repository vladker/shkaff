package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P3 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 1577321883966341961L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5086a;
    public final p027e3.o b;
    public final Q3[] c;
    public final AtomicReferenceArray d;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f5087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5088g;

    public P3(io.reactivex.I i5, p027e3.o oVar, int i6) {
        this.f5086a = i5;
        this.b = oVar;
        Q3[] q3Arr = new Q3[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            q3Arr[i7] = new Q3(this, i7);
        }
        this.c = q3Arr;
        this.d = new AtomicReferenceArray(i6);
        this.e = new AtomicReference();
        this.f5087f = new p100r3.c();
    }

    public final void a(int i5) {
        int i6 = 0;
        while (true) {
            Q3[] q3Arr = this.c;
            if (i6 >= q3Arr.length) {
                return;
            }
            if (i6 != i5) {
                Q3 q6 = q3Arr[i6];
                q6.getClass();
                p033f3.d.a(q6);
            }
            i6++;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.e);
        for (Q3 q6 : this.c) {
            q6.getClass();
            p033f3.d.a(q6);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.e.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5088g) {
            return;
        }
        this.f5088g = true;
        a(-1);
        com.android.billingclient.api.v1.f(this.f5086a, this, this.f5087f);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5088g) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f5088g = true;
        a(-1);
        com.android.billingclient.api.v1.h(this.f5086a, th, this, this.f5087f);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5088g) {
            return;
        }
        AtomicReferenceArray atomicReferenceArray = this.d;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        int i5 = 0;
        objArr[0] = obj;
        while (i5 < length) {
            Object obj2 = atomicReferenceArray.get(i5);
            if (obj2 == null) {
                return;
            }
            i5++;
            objArr[i5] = obj2;
        }
        try {
            Object objApply = this.b.apply(objArr);
            p039g3.A.b(objApply, "combiner returned a null value");
            com.android.billingclient.api.v1.j(this.f5086a, objApply, this, this.f5087f);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.e, cVar);
    }
}
