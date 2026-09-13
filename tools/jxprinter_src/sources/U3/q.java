package U3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends n implements InterfaceC0213j, z {
    public static final p Companion = new p();
    private static final q EMPTY = new q(1, 0, 1);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.InterfaceC0213j, U3.z
    public final boolean contains(Comparable comparable) {
        int iIntValue = ((Number) comparable).intValue();
        return this.f732a <= iIntValue && iIntValue <= this.b;
    }

    @Override // U3.n
    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        if (isEmpty() && ((q) obj).isEmpty()) {
            return true;
        }
        q qVar = (q) obj;
        return this.f732a == qVar.f732a && this.b == qVar.b;
    }

    @Override // U3.n
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f732a * 31) + this.b;
    }

    @Override // U3.n, U3.InterfaceC0213j
    public final boolean isEmpty() {
        return this.f732a > this.b;
    }

    @Override // U3.n
    public String toString() {
        return this.f732a + ".." + this.b;
    }

    @Override // U3.z
    public Integer getEndExclusive() {
        int i5 = this.b;
        if (i5 != Integer.MAX_VALUE) {
            return Integer.valueOf(i5 + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // U3.InterfaceC0213j
    public Integer getEndInclusive() {
        return Integer.valueOf(this.b);
    }

    @Override // U3.InterfaceC0213j, U3.z
    public Integer getStart() {
        return Integer.valueOf(this.f732a);
    }

    public static /* synthetic */ void getEndExclusive$annotations() {
    }
}
