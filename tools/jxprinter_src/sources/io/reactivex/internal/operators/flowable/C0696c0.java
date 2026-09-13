package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0696c0 extends AbstractC0683a {
    public final p027e3.o c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4576f;

    public C0696c0(AbstractC0979l abstractC0979l, p027e3.o oVar, int i5, int i6, int i7) {
        super(abstractC0979l);
        this.c = oVar;
        this.d = i5;
        this.e = i6;
        this.f4576f = i7;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe((InterfaceC0984q) new C0690b0(cVar, this.c, this.d, this.e, this.f4576f));
    }
}
