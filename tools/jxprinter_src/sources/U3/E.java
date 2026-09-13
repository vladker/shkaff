package U3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f725a;
    public boolean b;
    public final int c;
    public int d;

    public E(int i5, int i6, int i7) {
        this.f725a = i6;
        boolean z6 = false;
        int iCompareUnsigned = Integer.compareUnsigned(i5, i6);
        if (i7 <= 0 ? iCompareUnsigned >= 0 : iCompareUnsigned <= 0) {
            z6 = true;
        }
        this.b = z6;
        this.c = p147z3.G.m1188constructorimpl(i7);
        this.d = this.b ? i5 : i6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i5 = this.d;
        if (i5 != this.f725a) {
            this.d = p147z3.G.m1188constructorimpl(this.c + i5);
        } else {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
        }
        return p147z3.G.a(i5);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
