package U3;

/* JADX INFO: renamed from: U3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0205b implements Iterable, P3.a {
    public static final C0204a Companion = new C0204a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f728a;
    public final char b;
    public final int c;

    public C0205b(char c, char c6, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f728a = c;
        this.b = (char) I3.d.getProgressionLastElement((int) c, (int) c6, i5);
        this.c = i5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0205b)) {
            return false;
        }
        if (isEmpty() && ((C0205b) obj).isEmpty()) {
            return true;
        }
        C0205b c0205b = (C0205b) obj;
        return this.f728a == c0205b.f728a && this.b == c0205b.b && this.c == c0205b.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f728a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i5 = this.c;
        char c = this.b;
        char c6 = this.f728a;
        if (i5 > 0) {
            return kotlin.jvm.internal.E.h(c6, c) > 0;
        }
        return kotlin.jvm.internal.E.h(c6, c) < 0;
    }

    public String toString() {
        StringBuilder sb;
        char c = this.b;
        char c6 = this.f728a;
        int i5 = this.c;
        if (i5 > 0) {
            sb = new StringBuilder();
            sb.append(c6);
            sb.append("..");
            sb.append(c);
            sb.append(" step ");
            sb.append(i5);
        } else {
            sb = new StringBuilder();
            sb.append(c6);
            sb.append(" downTo ");
            sb.append(c);
            sb.append(" step ");
            sb.append(-i5);
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public A3.F iterator() {
        return new C0206c(this.f728a, this.b, this.c);
    }
}
