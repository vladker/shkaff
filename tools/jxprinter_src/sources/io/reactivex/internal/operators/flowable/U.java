package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends AbstractC0979l {
    public final t5.b[] b;
    public final boolean c;

    public U(t5.b[] bVarArr, boolean z6) {
        this.b = bVarArr;
        this.c = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        T t6 = new T(this.b, this.c, cVar);
        cVar.onSubscribe(t6);
        t6.onComplete();
    }
}
