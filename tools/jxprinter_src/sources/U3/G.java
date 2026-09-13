package U3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G extends D implements InterfaceC0213j, z {
    public static final F Companion = new F();
    private static final G EMPTY = new G(-1, 0, 1);

    public final boolean c(int i5) {
        return Integer.compareUnsigned(this.f724a, i5) <= 0 && Integer.compareUnsigned(i5, this.b) <= 0;
    }

    @Override // U3.InterfaceC0213j, U3.z
    public final /* synthetic */ boolean contains(Comparable comparable) {
        return c(((p147z3.G) comparable).f9124a);
    }

    @Override // U3.D
    public boolean equals(Object obj) {
        if (!(obj instanceof G)) {
            return false;
        }
        if (isEmpty() && ((G) obj).isEmpty()) {
            return true;
        }
        G g6 = (G) obj;
        return this.f724a == g6.f724a && this.b == g6.b;
    }

    @Override // U3.z
    public final Comparable getEndExclusive() {
        int i5 = this.b;
        if (i5 != -1) {
            return p147z3.G.a(p147z3.G.m1188constructorimpl(i5 + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // U3.InterfaceC0213j
    public final Comparable getEndInclusive() {
        return p147z3.G.a(this.b);
    }

    @Override // U3.InterfaceC0213j, U3.z
    public final Comparable getStart() {
        return p147z3.G.a(this.f724a);
    }

    @Override // U3.D
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f724a * 31) + this.b;
    }

    @Override // U3.D, U3.InterfaceC0213j
    public final boolean isEmpty() {
        return Integer.compareUnsigned(this.f724a, this.b) > 0;
    }

    @Override // U3.D
    public String toString() {
        return ((Object) p147z3.G.m1231toStringimpl(this.f724a)) + ".." + ((Object) p147z3.G.m1231toStringimpl(this.b));
    }

    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA$annotations, reason: not valid java name */
    public static /* synthetic */ void m823getEndExclusivepVg5ArA$annotations() {
    }
}
