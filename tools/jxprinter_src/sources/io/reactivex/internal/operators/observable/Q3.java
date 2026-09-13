package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q3 extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = 3256684027868224024L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P3 f5095a;
    public final int b;
    public boolean c;

    public Q3(P3 p6, int i5) {
        this.f5095a = p6;
        this.b = i5;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        P3 p6 = this.f5095a;
        int i5 = this.b;
        if (this.c) {
            p6.getClass();
            return;
        }
        p6.f5088g = true;
        p6.a(i5);
        com.android.billingclient.api.v1.f(p6.f5086a, p6, p6.f5087f);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        P3 p6 = this.f5095a;
        int i5 = this.b;
        p6.f5088g = true;
        p033f3.d.a(p6.e);
        p6.a(i5);
        com.android.billingclient.api.v1.h(p6.f5086a, th, p6, p6.f5087f);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (!this.c) {
            this.c = true;
        }
        this.f5095a.d.set(this.b, obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
