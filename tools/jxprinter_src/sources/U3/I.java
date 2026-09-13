package U3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class I implements Iterable, P3.a {
    public static final H Companion = new H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f726a;
    public final long b;
    public final long c;

    public I(long j6, long j7, long j8) {
        if (j8 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j8 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f726a = j6;
        this.b = I3.e.m814getProgressionLastElement7ftBX0g(j6, j7, j8);
        this.c = j8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof I)) {
            return false;
        }
        if (isEmpty() && ((I) obj).isEmpty()) {
            return true;
        }
        I i5 = (I) obj;
        return this.f726a == i5.f726a && this.b == i5.b && this.c == i5.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j6 = this.f726a;
        int iM1247constructorimpl = ((int) p147z3.J.m1247constructorimpl(j6 ^ p147z3.J.m1247constructorimpl(j6 >>> 32))) * 31;
        long j7 = this.b;
        int iM1247constructorimpl2 = (iM1247constructorimpl + ((int) p147z3.J.m1247constructorimpl(j7 ^ p147z3.J.m1247constructorimpl(j7 >>> 32)))) * 31;
        long j8 = this.c;
        return iM1247constructorimpl2 + ((int) ((j8 >>> 32) ^ j8));
    }

    public boolean isEmpty() {
        long j6 = this.c;
        long j7 = this.b;
        long j8 = this.f726a;
        if (j6 > 0) {
            return Long.compareUnsigned(j8, j7) > 0;
        }
        return Long.compareUnsigned(j8, j7) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<p147z3.J> iterator() {
        return new J(this.f726a, this.b, this.c);
    }

    public String toString() {
        StringBuilder sb;
        long j6 = this.c;
        long j7 = this.b;
        long j8 = this.f726a;
        if (j6 > 0) {
            sb = new StringBuilder();
            sb.append((Object) p147z3.J.m1290toStringimpl(j8));
            sb.append("..");
            sb.append((Object) p147z3.J.m1290toStringimpl(j7));
            sb.append(" step ");
            sb.append(j6);
        } else {
            sb = new StringBuilder();
            sb.append((Object) p147z3.J.m1290toStringimpl(j8));
            sb.append(" downTo ");
            sb.append((Object) p147z3.J.m1290toStringimpl(j7));
            sb.append(" step ");
            sb.append(-j6);
        }
        return sb.toString();
    }
}
