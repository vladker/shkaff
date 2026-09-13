package U3;

/* JADX INFO: renamed from: U3.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0210g implements InterfaceC0211h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f731a;
    public final float b;

    public C0210g(float f6, float f7) {
        this.f731a = f6;
        this.b = f7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.InterfaceC0211h, U3.InterfaceC0213j, U3.z
    public final boolean contains(Comparable comparable) {
        float fFloatValue = ((Number) comparable).floatValue();
        return fFloatValue >= this.f731a && fFloatValue <= this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0210g)) {
            return false;
        }
        if (isEmpty() && ((C0210g) obj).isEmpty()) {
            return true;
        }
        C0210g c0210g = (C0210g) obj;
        return this.f731a == c0210g.f731a && this.b == c0210g.b;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Float.hashCode(this.b) + (Float.hashCode(this.f731a) * 31);
    }

    @Override // U3.InterfaceC0213j
    public final boolean isEmpty() {
        return this.f731a > this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.InterfaceC0211h
    public final boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return ((Number) comparable).floatValue() <= ((Number) comparable2).floatValue();
    }

    public String toString() {
        return this.f731a + ".." + this.b;
    }

    @Override // U3.InterfaceC0211h, U3.InterfaceC0213j
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @Override // U3.InterfaceC0211h, U3.InterfaceC0213j, U3.z
    public Float getStart() {
        return Float.valueOf(this.f731a);
    }
}
