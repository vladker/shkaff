package U3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f737a;
    public final float b;

    public x(float f6, float f7) {
        this.f737a = f6;
        this.b = f7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.z
    public final boolean contains(Comparable comparable) {
        float fFloatValue = ((Number) comparable).floatValue();
        return fFloatValue >= this.f737a && fFloatValue < this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        float f6 = this.f737a;
        float f7 = this.b;
        if (f6 >= f7) {
            x xVar = (x) obj;
            if (xVar.f737a >= xVar.b) {
                return true;
            }
        }
        x xVar2 = (x) obj;
        return f6 == xVar2.f737a && f7 == xVar2.b;
    }

    public final int hashCode() {
        float f6 = this.f737a;
        float f7 = this.b;
        if (f6 >= f7) {
            return -1;
        }
        return Float.hashCode(f7) + (Float.hashCode(f6) * 31);
    }

    public String toString() {
        return this.f737a + "..<" + this.b;
    }

    @Override // U3.z
    public Float getEndExclusive() {
        return Float.valueOf(this.b);
    }

    @Override // U3.z
    public Float getStart() {
        return Float.valueOf(this.f737a);
    }
}
