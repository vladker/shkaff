package U3;

/* JADX INFO: renamed from: U3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0214k implements z {
    private final Comparable<Object> endExclusive;
    private final Comparable<Object> start;

    public C0214k(Comparable<Object> start, Comparable<Object> endExclusive) {
        kotlin.jvm.internal.E.f(start, "start");
        kotlin.jvm.internal.E.f(endExclusive, "endExclusive");
        this.start = start;
        this.endExclusive = endExclusive;
    }

    @Override // U3.z
    public boolean contains(Comparable<Object> comparable) {
        return y.contains(this, comparable);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0214k)) {
            return false;
        }
        if (y.isEmpty(this) && y.isEmpty((C0214k) obj)) {
            return true;
        }
        C0214k c0214k = (C0214k) obj;
        return kotlin.jvm.internal.E.a(getStart(), c0214k.getStart()) && kotlin.jvm.internal.E.a(getEndExclusive(), c0214k.getEndExclusive());
    }

    @Override // U3.z
    public Comparable<Object> getEndExclusive() {
        return this.endExclusive;
    }

    @Override // U3.z
    public Comparable<Object> getStart() {
        return this.start;
    }

    public final int hashCode() {
        if (y.isEmpty(this)) {
            return -1;
        }
        return getEndExclusive().hashCode() + (getStart().hashCode() * 31);
    }

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }
}
