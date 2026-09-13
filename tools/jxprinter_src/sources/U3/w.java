package U3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f736a;
    public final double b;

    public w(double d, double d6) {
        this.f736a = d;
        this.b = d6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.z
    public final boolean contains(Comparable comparable) {
        double dDoubleValue = ((Number) comparable).doubleValue();
        return dDoubleValue >= this.f736a && dDoubleValue < this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        double d = this.f736a;
        double d6 = this.b;
        if (d >= d6) {
            w wVar = (w) obj;
            if (wVar.f736a >= wVar.b) {
                return true;
            }
        }
        w wVar2 = (w) obj;
        return d == wVar2.f736a && d6 == wVar2.b;
    }

    public final int hashCode() {
        double d = this.f736a;
        double d6 = this.b;
        if (d >= d6) {
            return -1;
        }
        return Double.hashCode(d6) + (Double.hashCode(d) * 31);
    }

    public String toString() {
        return this.f736a + "..<" + this.b;
    }

    @Override // U3.z
    public Double getEndExclusive() {
        return Double.valueOf(this.b);
    }

    @Override // U3.z
    public Double getStart() {
        return Double.valueOf(this.f736a);
    }
}
