package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W1 extends AbstractC0676c implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4489a;

    public W1(AbstractC0979l abstractC0979l) {
        this.f4489a = abstractC0979l;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        return io.reactivex.plugins.a.onAssembly(new C0756m0(this.f4489a, 3));
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f4489a.subscribe((InterfaceC0984q) new V1(interfaceC0679f, 0));
    }
}
