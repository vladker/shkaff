package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R1 extends AtomicReference implements InterfaceC0984q, p011b3.c {
    private static final long serialVersionUID = 1883890389173668373L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f4420a;
    public final boolean b;
    public final int c;

    /* JADX WARN: Multi-variable type inference failed */
    public R1(Q1 q6, boolean z6, int i5) {
        this.f4420a = (AtomicInteger) q6;
        this.b = z6;
        this.c = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p094q3.g.f7849a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.flowable.Q1, java.util.concurrent.atomic.AtomicInteger] */
    @Override // t5.c
    public final void onComplete() {
        this.f4420a.d(this.b, this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.flowable.Q1, java.util.concurrent.atomic.AtomicInteger] */
    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4420a.b(th);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [io.reactivex.internal.operators.flowable.Q1, java.util.concurrent.atomic.AtomicInteger] */
    @Override // t5.c
    public final void onNext(Object obj) {
        if (p094q3.g.a(this)) {
            this.f4420a.d(this.b, this);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
