package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.i1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0733i1 extends AbstractC0683a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f4668g = 0;
    public final p027e3.o c;
    public final boolean d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4669f;

    public C0733i1(AbstractC0979l abstractC0979l, p027e3.o oVar, boolean z6, int i5, int i6) {
        super(abstractC0979l);
        this.c = oVar;
        this.d = z6;
        this.e = i5;
        this.f4669f = i6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        p027e3.o oVar = this.c;
        AbstractC0979l abstractC0979l = this.b;
        if (p002a.c.c(oVar, abstractC0979l, cVar)) {
            return;
        }
        abstractC0979l.subscribe((InterfaceC0984q) new C0727h1(this.e, this.f4669f, this.c, cVar, this.d));
    }
}
