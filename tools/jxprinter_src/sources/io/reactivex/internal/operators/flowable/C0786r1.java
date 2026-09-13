package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.r1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0786r1 extends AbstractC0979l {
    public final t5.b b;
    public final Enum c;
    public final boolean d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4747f;

    /* JADX WARN: Multi-variable type inference failed */
    public C0786r1(t5.b bVar, p027e3.o oVar, boolean z6, int i5, int i6) {
        this.b = bVar;
        this.c = (Enum) oVar;
        this.d = z6;
        this.e = i5;
        this.f4747f = i6;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [e3.o, java.lang.Enum] */
    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        ?? r6 = this.c;
        t5.b bVar = this.b;
        if (p002a.c.c(r6, bVar, cVar)) {
            return;
        }
        bVar.subscribe(new C0727h1(this.e, this.f4747f, r6, cVar, this.d));
    }
}
