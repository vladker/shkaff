package io.reactivex.internal.operators.observable;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.o2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0911o2 extends AtomicInteger implements p011b3.c {
    private static final long serialVersionUID = 2728361546769921047L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0930s2 f5247a;
    public final io.reactivex.I b;
    public Serializable c;
    public volatile boolean d;

    public C0911o2(C0930s2 c0930s2, io.reactivex.I i5) {
        this.f5247a = c0930s2;
        this.b = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f5247a.a(this);
        this.c = null;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }
}
