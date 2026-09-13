package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.y3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0830y3 extends p022d3.a {
    public final p022d3.a b;
    public final AbstractC0979l c;

    public C0830y3(p022d3.a aVar, AbstractC0979l abstractC0979l) {
        this.b = aVar;
        this.c = abstractC0979l;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.c.subscribe(cVar);
    }

    @Override // p022d3.a
    public final void connect(p027e3.g gVar) {
        this.b.connect(gVar);
    }
}
