package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l5 extends AtomicInteger implements p043h3.a, t5.d {
    private static final long serialVersionUID = 1577321883966341961L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4697a;
    public final p027e3.o b;
    public final m5[] c;
    public final AtomicReferenceArray d;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f4698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p100r3.c f4699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4700h;

    public l5(t5.c cVar, p027e3.o oVar, int i5) {
        this.f4697a = cVar;
        this.b = oVar;
        m5[] m5VarArr = new m5[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            m5VarArr[i6] = new m5(this, i6);
        }
        this.c = m5VarArr;
        this.d = new AtomicReferenceArray(i5);
        this.e = new AtomicReference();
        this.f4698f = new AtomicLong();
        this.f4699g = new p100r3.c();
    }

    public final void a(int i5) {
        int i6 = 0;
        while (true) {
            m5[] m5VarArr = this.c;
            if (i6 >= m5VarArr.length) {
                return;
            }
            if (i6 != i5) {
                m5 m5Var = m5VarArr[i6];
                m5Var.getClass();
                p094q3.g.a(m5Var);
            }
            i6++;
        }
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.e);
        for (m5 m5Var : this.c) {
            m5Var.getClass();
            p094q3.g.a(m5Var);
        }
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (!this.f4700h) {
            AtomicReferenceArray atomicReferenceArray = this.d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = obj;
            int i5 = 0;
            while (i5 < length) {
                Object obj2 = atomicReferenceArray.get(i5);
                if (obj2 != null) {
                    i5++;
                    objArr[i5] = obj2;
                }
            }
            try {
                Object objApply = this.b.apply(objArr);
                p039g3.A.b(objApply, "The combiner returned a null value");
                com.android.billingclient.api.v1.k(this.f4697a, objApply, this, this.f4699g);
                return true;
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cancel();
                onError(th);
                return false;
            }
        }
        return false;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4700h) {
            return;
        }
        this.f4700h = true;
        a(-1);
        com.android.billingclient.api.v1.g(this.f4697a, this, this.f4699g);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4700h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4700h = true;
        a(-1);
        com.android.billingclient.api.v1.i(this.f4697a, th, this, this.f4699g);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (h(obj) || this.f4700h) {
            return;
        }
        ((t5.d) this.e.get()).request(1L);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.e, this.f4698f, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.e, this.f4698f, j6);
    }
}
