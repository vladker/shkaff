package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0702d0 extends AbstractC0979l {
    public final t5.b b;
    public final int c;
    public final int d;

    public C0702d0(t5.b bVar, int i5, int i6) {
        this.b = bVar;
        this.c = i5;
        this.d = i6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe(new C0690b0(cVar, p039g3.z.f4010a, this.c, this.d, 1));
    }
}
