package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q5 extends AbstractC0979l {
    public final t5.b[] b;
    public final Iterable c;
    public final p027e3.o d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4746f;

    public q5(t5.b[] bVarArr, Iterable iterable, p027e3.o oVar, int i5, boolean z6) {
        this.b = bVarArr;
        this.c = iterable;
        this.d = oVar;
        this.e = i5;
        this.f4746f = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        int length;
        t5.b[] bVarArr = this.b;
        if (bVarArr == null) {
            bVarArr = new t5.b[8];
            length = 0;
            for (t5.b bVar : this.c) {
                if (length == bVarArr.length) {
                    t5.b[] bVarArr2 = new t5.b[(length >> 2) + length];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    bVarArr = bVarArr2;
                }
                bVarArr[length] = bVar;
                length++;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            cVar.onSubscribe(p094q3.d.f7843a);
            cVar.onComplete();
            return;
        }
        o5 o5Var = new o5(length, this.e, this.d, cVar, this.f4746f);
        cVar.onSubscribe(o5Var);
        p5[] p5VarArr = o5Var.b;
        for (int i5 = 0; i5 < length && !o5Var.f4722g; i5++) {
            if (!o5Var.f4721f && o5Var.e.get() != null) {
                return;
            }
            bVarArr[i5].subscribe(p5VarArr[i5]);
        }
    }
}
