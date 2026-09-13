package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n5 extends AbstractC0683a {
    public final p027e3.o c;
    final t5.b[] otherArray;
    final Iterable<? extends t5.b> otherIterable;

    public n5(AbstractC0979l abstractC0979l, t5.b[] bVarArr, p027e3.o oVar) {
        super(abstractC0979l);
        this.otherArray = bVarArr;
        this.otherIterable = null;
        this.c = oVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        int length;
        t5.b[] bVarArr = this.otherArray;
        if (bVarArr == null) {
            bVarArr = new t5.b[8];
            try {
                length = 0;
                for (t5.b bVar : this.otherIterable) {
                    if (length == bVarArr.length) {
                        bVarArr = (t5.b[]) Arrays.copyOf(bVarArr, (length >> 1) + length);
                    }
                    int i5 = length + 1;
                    bVarArr[length] = bVar;
                    length = i5;
                }
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cVar.onSubscribe(p094q3.d.f7843a);
                cVar.onError(th);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        AbstractC0979l abstractC0979l = this.b;
        if (length == 0) {
            new A0(abstractC0979l, new k5(this), 2).b(cVar);
            return;
        }
        l5 l5Var = new l5(cVar, this.c, length);
        cVar.onSubscribe(l5Var);
        for (int i6 = 0; i6 < length && l5Var.e.get() != p094q3.g.f7849a; i6++) {
            bVarArr[i6].subscribe(l5Var.c[i6]);
        }
        abstractC0979l.subscribe((InterfaceC0984q) l5Var);
    }

    public n5(AbstractC0979l abstractC0979l, Iterable<? extends t5.b> iterable, p027e3.o oVar) {
        super(abstractC0979l);
        this.otherArray = null;
        this.otherIterable = iterable;
        this.c = oVar;
    }
}
