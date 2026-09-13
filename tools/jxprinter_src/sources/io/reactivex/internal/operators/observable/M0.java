package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M0 extends AbstractC0676c implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5028a;
    public final p027e3.o b;
    public final boolean c;

    public M0(io.reactivex.B b, p027e3.o oVar, boolean z6) {
        this.f5028a = b;
        this.b = oVar;
        this.c = z6;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new J0(this.f5028a, this.b, this.c, 0));
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f5028a.subscribe(new L0(interfaceC0679f, this.b, this.c));
    }
}
