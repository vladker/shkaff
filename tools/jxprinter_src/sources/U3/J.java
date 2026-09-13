package U3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f727a;
    public boolean b;
    public final long c;
    public long d;

    public J(long j6, long j7, long j8) {
        this.f727a = j7;
        boolean z6 = false;
        if (j8 <= 0 ? Long.compareUnsigned(j6, j7) >= 0 : Long.compareUnsigned(j6, j7) <= 0) {
            z6 = true;
        }
        this.b = z6;
        this.c = p147z3.J.m1247constructorimpl(j8);
        this.d = this.b ? j6 : j7;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j6 = this.d;
        if (j6 != this.f727a) {
            this.d = p147z3.J.m1247constructorimpl(this.c + j6);
        } else {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
        }
        return p147z3.J.a(j6);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
