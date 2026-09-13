package U3;

/* JADX INFO: renamed from: U3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0209f implements InterfaceC0211h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f730a;
    public final double b;

    public C0209f(double d, double d6) {
        this.f730a = d;
        this.b = d6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.InterfaceC0211h, U3.InterfaceC0213j, U3.z
    public final boolean contains(Comparable comparable) {
        double dDoubleValue = ((Number) comparable).doubleValue();
        return dDoubleValue >= this.f730a && dDoubleValue <= this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0209f)) {
            return false;
        }
        if (isEmpty() && ((C0209f) obj).isEmpty()) {
            return true;
        }
        C0209f c0209f = (C0209f) obj;
        return this.f730a == c0209f.f730a && this.b == c0209f.b;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Double.hashCode(this.b) + (Double.hashCode(this.f730a) * 31);
    }

    @Override // U3.InterfaceC0213j
    public final boolean isEmpty() {
        return this.f730a > this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.InterfaceC0211h
    public final boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return ((Number) comparable).doubleValue() <= ((Number) comparable2).doubleValue();
    }

    public String toString() {
        return this.f730a + ".." + this.b;
    }

    @Override // U3.InterfaceC0211h, U3.InterfaceC0213j
    public Double getEndInclusive() {
        return Double.valueOf(this.b);
    }

    @Override // U3.InterfaceC0211h, U3.InterfaceC0213j, U3.z
    public Double getStart() {
        return Double.valueOf(this.f730a);
    }
}
