package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.o1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0769o1 extends AbstractC0676c implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4717a;
    public final p027e3.o b;
    public final int c;
    public final boolean d;

    public C0769o1(int i5, p027e3.o oVar, AbstractC0979l abstractC0979l, boolean z6) {
        this.f4717a = abstractC0979l;
        this.b = oVar;
        this.d = z6;
        this.c = i5;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        return io.reactivex.plugins.a.onAssembly(new C0751l1(this.f4717a, this.b, this.d, this.c, 0));
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f4717a.subscribe((InterfaceC0984q) new C0763n1(interfaceC0679f, this.b, this.d, this.c));
    }
}
