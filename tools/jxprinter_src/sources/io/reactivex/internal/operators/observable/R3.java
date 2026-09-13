package io.reactivex.internal.operators.observable;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R3 extends AbstractC0838a {
    final p027e3.o combiner;
    final io.reactivex.G[] otherArray;
    final Iterable<? extends io.reactivex.G> otherIterable;

    public R3(io.reactivex.G g6, io.reactivex.G[] gArr, p027e3.o oVar) {
        super(g6);
        this.otherArray = gArr;
        this.otherIterable = null;
        this.combiner = oVar;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        int length;
        io.reactivex.G[] gArr = this.otherArray;
        if (gArr == null) {
            gArr = new io.reactivex.G[8];
            try {
                length = 0;
                for (io.reactivex.G g6 : this.otherIterable) {
                    if (length == gArr.length) {
                        gArr = (io.reactivex.G[]) Arrays.copyOf(gArr, (length >> 1) + length);
                    }
                    int i6 = length + 1;
                    gArr[length] = g6;
                    length = i6;
                }
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                i5.onSubscribe(p033f3.e.f3970a);
                i5.onError(th);
                return;
            }
        } else {
            length = gArr.length;
        }
        if (length == 0) {
            this.f5141a.subscribe(new G1(i5, new O3(this)));
            return;
        }
        P3 p6 = new P3(i5, this.combiner, length);
        i5.onSubscribe(p6);
        Q3[] q3Arr = p6.c;
        AtomicReference atomicReference = p6.e;
        for (int i7 = 0; i7 < length && !p033f3.d.b((p011b3.c) atomicReference.get()) && !p6.f5088g; i7++) {
            gArr[i7].subscribe(q3Arr[i7]);
        }
        this.f5141a.subscribe(p6);
    }

    public R3(io.reactivex.G g6, Iterable<? extends io.reactivex.G> iterable, p027e3.o oVar) {
        super(g6);
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = oVar;
    }
}
