package U3;

/* JADX INFO: renamed from: U3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0215l implements InterfaceC0213j {
    private final Comparable<Object> endInclusive;
    private final Comparable<Object> start;

    public C0215l(Comparable<Object> start, Comparable<Object> endInclusive) {
        kotlin.jvm.internal.E.f(start, "start");
        kotlin.jvm.internal.E.f(endInclusive, "endInclusive");
        this.start = start;
        this.endInclusive = endInclusive;
    }

    @Override // U3.InterfaceC0213j, U3.z
    public boolean contains(Comparable<Object> comparable) {
        return AbstractC0212i.contains(this, comparable);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0215l)) {
            return false;
        }
        if (AbstractC0212i.isEmpty(this) && AbstractC0212i.isEmpty((C0215l) obj)) {
            return true;
        }
        C0215l c0215l = (C0215l) obj;
        return kotlin.jvm.internal.E.a(getStart(), c0215l.getStart()) && kotlin.jvm.internal.E.a(getEndInclusive(), c0215l.getEndInclusive());
    }

    @Override // U3.InterfaceC0213j
    public Comparable<Object> getEndInclusive() {
        return this.endInclusive;
    }

    @Override // U3.InterfaceC0213j, U3.z
    public Comparable<Object> getStart() {
        return this.start;
    }

    public final int hashCode() {
        if (AbstractC0212i.isEmpty(this)) {
            return -1;
        }
        return getEndInclusive().hashCode() + (getStart().hashCode() * 31);
    }

    @Override // U3.InterfaceC0213j
    public final boolean isEmpty() {
        return AbstractC0212i.isEmpty(this);
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
