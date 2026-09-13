package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0708e0 extends AbstractC0979l {
    public final t5.b b;
    public final Enum c;
    public final int d;

    /* JADX WARN: Multi-variable type inference failed */
    public C0708e0(t5.b bVar, p027e3.o oVar, int i5) {
        this.b = bVar;
        this.c = (Enum) oVar;
        this.d = i5;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [e3.o, java.lang.Enum] */
    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        ?? r6 = this.c;
        t5.b bVar = this.b;
        if (p002a.c.c(r6, bVar, cVar)) {
            return;
        }
        bVar.subscribe(C0814w.g(cVar, r6, this.d, 1));
    }
}
