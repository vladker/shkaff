package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.g3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0723g3 extends AbstractC0979l {
    public final int b;
    public final int c;

    public C0723g3(int i5, int i6) {
        this.b = i5;
        this.c = i5 + i6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        boolean z6 = cVar instanceof p043h3.a;
        int i5 = this.c;
        int i6 = this.b;
        if (z6) {
            cVar.onSubscribe(new C0711e3((p043h3.a) cVar, i6, i5));
        } else {
            cVar.onSubscribe(new C0717f3(cVar, i6, i5));
        }
    }
}
