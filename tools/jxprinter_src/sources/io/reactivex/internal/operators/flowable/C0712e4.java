package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.e4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0712e4 extends AbstractC0985s implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4599a;

    public C0712e4(AbstractC0979l abstractC0979l) {
        this.f4599a = abstractC0979l;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        this.f4599a.subscribe((InterfaceC0984q) new C0755m(interfaceC0988v));
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        return io.reactivex.plugins.a.onAssembly(new U2(this.f4599a, null, false, 1));
    }
}
