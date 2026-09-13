package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0697c1 extends io.reactivex.O implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4577a;
    public final long b;
    public final Object c;

    public C0697c1(AbstractC0979l abstractC0979l, long j6, Object obj) {
        this.f4577a = abstractC0979l;
        this.b = j6;
        this.c = obj;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        return io.reactivex.plugins.a.onAssembly(new Y0(this.f4577a, this.b, this.c, true));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        this.f4577a.subscribe((InterfaceC0984q) new C0691b1(s6, this.b, this.c));
    }
}
