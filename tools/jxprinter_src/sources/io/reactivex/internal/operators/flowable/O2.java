package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O2 extends AbstractC0683a {
    public final int c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.a f4394f;

    public O2(AbstractC0979l abstractC0979l, int i5, boolean z6, boolean z7, p027e3.a aVar) {
        super(abstractC0979l);
        this.c = i5;
        this.d = z6;
        this.e = z7;
        this.f4394f = aVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe((InterfaceC0984q) new N2(cVar, this.c, this.d, this.e, this.f4394f));
    }
}
