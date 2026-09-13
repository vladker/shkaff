package U3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class D implements Iterable, P3.a {
    public static final C Companion = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f724a;
    public final int b;
    public final int c;

    public D(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f724a = i5;
        this.b = I3.e.m815getProgressionLastElementNkh28Cs(i5, i6, i7);
        this.c = i7;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof D)) {
            return false;
        }
        if (isEmpty() && ((D) obj).isEmpty()) {
            return true;
        }
        D d = (D) obj;
        return this.f724a == d.f724a && this.b == d.b && this.c == d.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f724a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i5 = this.c;
        int i6 = this.b;
        int i7 = this.f724a;
        if (i5 > 0) {
            return Integer.compareUnsigned(i7, i6) > 0;
        }
        return Integer.compareUnsigned(i7, i6) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<p147z3.G> iterator() {
        return new E(this.f724a, this.b, this.c);
    }

    public String toString() {
        StringBuilder sb;
        int i5 = this.b;
        int i6 = this.f724a;
        int i7 = this.c;
        if (i7 > 0) {
            sb = new StringBuilder();
            sb.append((Object) p147z3.G.m1231toStringimpl(i6));
            sb.append("..");
            sb.append((Object) p147z3.G.m1231toStringimpl(i5));
            sb.append(" step ");
            sb.append(i7);
        } else {
            sb = new StringBuilder();
            sb.append((Object) p147z3.G.m1231toStringimpl(i6));
            sb.append(" downTo ");
            sb.append((Object) p147z3.G.m1231toStringimpl(i5));
            sb.append(" step ");
            sb.append(-i7);
        }
        return sb.toString();
    }
}
