package U3;

import A3.e0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class n implements Iterable, P3.a {
    public static final C0216m Companion = new C0216m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f732a;
    public final int b;
    public final int c;

    public n(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f732a = i5;
        this.b = I3.d.getProgressionLastElement(i5, i6, i7);
        this.c = i7;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (isEmpty() && ((n) obj).isEmpty()) {
            return true;
        }
        n nVar = (n) obj;
        return this.f732a == nVar.f732a && this.b == nVar.b && this.c == nVar.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f732a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i5 = this.c;
        int i6 = this.b;
        int i7 = this.f732a;
        if (i5 > 0) {
            return i7 > i6;
        }
        return i7 < i6;
    }

    public String toString() {
        StringBuilder sb;
        int i5 = this.b;
        int i6 = this.f732a;
        int i7 = this.c;
        if (i7 > 0) {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append("..");
            sb.append(i5);
            sb.append(" step ");
            sb.append(i7);
        } else {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append(" downTo ");
            sb.append(i5);
            sb.append(" step ");
            sb.append(-i7);
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public e0 iterator() {
        return new o(this.f732a, this.b, this.c);
    }
}
