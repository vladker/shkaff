package U3;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends I implements InterfaceC0213j, z {
    public static final K Companion = new K();
    private static final L EMPTY = new L(-1, 0);

    public L(long j6, long j7) {
        super(j6, j7, 1L);
    }

    public final boolean c(long j6) {
        return Long.compareUnsigned(this.f726a, j6) <= 0 && Long.compareUnsigned(j6, this.b) <= 0;
    }

    @Override // U3.InterfaceC0213j, U3.z
    public final /* synthetic */ boolean contains(Comparable comparable) {
        return c(((p147z3.J) comparable).f9126a);
    }

    @Override // U3.I
    public boolean equals(Object obj) {
        if (!(obj instanceof L)) {
            return false;
        }
        if (isEmpty() && ((L) obj).isEmpty()) {
            return true;
        }
        L l6 = (L) obj;
        return this.f726a == l6.f726a && this.b == l6.b;
    }

    @Override // U3.z
    public final Comparable getEndExclusive() {
        long j6 = this.b;
        if (j6 != -1) {
            return p147z3.J.a(p147z3.J.m1247constructorimpl(p147z3.J.m1247constructorimpl(((long) 1) & KeyboardMap.kValueMask) + j6));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // U3.InterfaceC0213j
    public final Comparable getEndInclusive() {
        return p147z3.J.a(this.b);
    }

    @Override // U3.InterfaceC0213j, U3.z
    public final Comparable getStart() {
        return p147z3.J.a(this.f726a);
    }

    @Override // U3.I
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j6 = this.f726a;
        int iM1247constructorimpl = ((int) p147z3.J.m1247constructorimpl(j6 ^ p147z3.J.m1247constructorimpl(j6 >>> 32))) * 31;
        long j7 = this.b;
        return iM1247constructorimpl + ((int) p147z3.J.m1247constructorimpl(p147z3.J.m1247constructorimpl(j7 >>> 32) ^ j7));
    }

    @Override // U3.I, U3.InterfaceC0213j
    public final boolean isEmpty() {
        return Long.compareUnsigned(this.f726a, this.b) > 0;
    }

    @Override // U3.I
    public String toString() {
        return ((Object) p147z3.J.m1290toStringimpl(this.f726a)) + ".." + ((Object) p147z3.J.m1290toStringimpl(this.b));
    }

    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m825getEndExclusivesVKNKU$annotations() {
    }
}
