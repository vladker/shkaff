package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends AbstractC0979l {
    final t5.b[] array;
    public final p027e3.o b;
    public final int c;
    public final boolean d;
    final Iterable<? extends t5.b> iterable;

    public S(Iterable<? extends t5.b> iterable, p027e3.o oVar, int i5, boolean z6) {
        this.array = null;
        this.iterable = iterable;
        this.b = oVar;
        this.c = i5;
        this.d = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        int length;
        t5.d dVar = p094q3.d.f7843a;
        t5.b[] bVarArr = this.array;
        if (bVarArr == null) {
            bVarArr = new t5.b[8];
            try {
                Iterator<? extends t5.b> it = this.iterable.iterator();
                p039g3.A.b(it, "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            t5.b next = it.next();
                            p039g3.A.b(next, "The publisher returned by the iterator is null");
                            t5.b bVar = next;
                            if (length == bVarArr.length) {
                                t5.b[] bVarArr2 = new t5.b[(length >> 2) + length];
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                bVarArr = bVarArr2;
                            }
                            bVarArr[length] = bVar;
                            length++;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            cVar.onSubscribe(dVar);
                            cVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        cVar.onSubscribe(dVar);
                        cVar.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                p017c3.d.throwIfFatal(th3);
                cVar.onSubscribe(dVar);
                cVar.onError(th3);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            cVar.onSubscribe(dVar);
            cVar.onComplete();
            return;
        }
        if (length == 1) {
            bVarArr[0].subscribe(new A2(cVar, new Q(this)));
            return;
        }
        O o6 = new O(length, this.c, this.b, cVar, this.d);
        cVar.onSubscribe(o6);
        P[] pArr = o6.c;
        for (int i5 = 0; i5 < length && !o6.f4389l && !o6.f4387j; i5++) {
            bVarArr[i5].subscribe(pArr[i5]);
        }
    }

    public S(t5.b[] bVarArr, p027e3.o oVar, int i5, boolean z6) {
        this.array = bVarArr;
        this.iterable = null;
        this.b = oVar;
        this.c = i5;
        this.d = z6;
    }
}
