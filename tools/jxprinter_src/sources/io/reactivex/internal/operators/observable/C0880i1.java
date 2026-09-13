package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.i1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0880i1 extends AbstractC0676c implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5202a;

    public C0880i1(io.reactivex.B b) {
        this.f5202a = b;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new Z(this.f5202a, 3));
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f5202a.subscribe(new C0914p0(interfaceC0679f, 4));
    }
}
