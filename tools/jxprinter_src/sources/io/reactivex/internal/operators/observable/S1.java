package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S1 extends AtomicReference implements p011b3.c {
    private static final long serialVersionUID = -1100270633763673112L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5102a;

    public S1(io.reactivex.I i5) {
        this.f5102a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        Object andSet = getAndSet(this);
        if (andSet == null || andSet == this) {
            return;
        }
        ((T1) andSet).a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == this;
    }
}
