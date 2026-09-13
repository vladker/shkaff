package U3;

import A3.f0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class s implements Iterable, P3.a {
    public static final r Companion = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f734a;
    public final long b;
    public final long c;

    public s(long j6, long j7, long j8) {
        if (j8 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j8 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f734a = j6;
        this.b = I3.d.getProgressionLastElement(j6, j7, j8);
        this.c = j8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        if (isEmpty() && ((s) obj).isEmpty()) {
            return true;
        }
        s sVar = (s) obj;
        return this.f734a == sVar.f734a && this.b == sVar.b && this.c == sVar.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j6 = 31;
        long j7 = this.f734a;
        long j8 = this.b;
        long j9 = (((j7 ^ (j7 >>> 32)) * j6) + (j8 ^ (j8 >>> 32))) * j6;
        long j10 = this.c;
        return (int) (j9 + (j10 ^ (j10 >>> 32)));
    }

    public boolean isEmpty() {
        long j6 = this.c;
        long j7 = this.b;
        long j8 = this.f734a;
        if (j6 > 0) {
            return j8 > j7;
        }
        return j8 < j7;
    }

    public String toString() {
        StringBuilder sb;
        long j6 = this.c;
        long j7 = this.b;
        long j8 = this.f734a;
        if (j6 > 0) {
            sb = new StringBuilder();
            sb.append(j8);
            sb.append("..");
            sb.append(j7);
            sb.append(" step ");
            sb.append(j6);
        } else {
            sb = new StringBuilder();
            sb.append(j8);
            sb.append(" downTo ");
            sb.append(j7);
            sb.append(" step ");
            sb.append(-j6);
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public f0 iterator() {
        return new t(this.f734a, this.b, this.c);
    }
}
