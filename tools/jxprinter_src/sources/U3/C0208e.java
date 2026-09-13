package U3;

/* JADX INFO: renamed from: U3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0208e extends C0205b implements InterfaceC0213j, z {
    public static final C0207d Companion = new C0207d();
    private static final C0208e EMPTY = new C0208e(1, 0, 1);

    @Override // U3.InterfaceC0213j, U3.z
    public final boolean contains(Comparable comparable) {
        char cCharValue = ((Character) comparable).charValue();
        return kotlin.jvm.internal.E.h(this.f728a, cCharValue) <= 0 && kotlin.jvm.internal.E.h(cCharValue, this.b) <= 0;
    }

    @Override // U3.C0205b
    public boolean equals(Object obj) {
        if (!(obj instanceof C0208e)) {
            return false;
        }
        if (isEmpty() && ((C0208e) obj).isEmpty()) {
            return true;
        }
        C0208e c0208e = (C0208e) obj;
        return this.f728a == c0208e.f728a && this.b == c0208e.b;
    }

    @Override // U3.C0205b
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f728a * 31) + this.b;
    }

    @Override // U3.C0205b, U3.InterfaceC0213j
    public final boolean isEmpty() {
        return kotlin.jvm.internal.E.h(this.f728a, this.b) > 0;
    }

    @Override // U3.C0205b
    public String toString() {
        return this.f728a + ".." + this.b;
    }

    @Override // U3.z
    public Character getEndExclusive() {
        char c = this.b;
        if (c != 65535) {
            return Character.valueOf((char) (c + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // U3.InterfaceC0213j
    public Character getEndInclusive() {
        return Character.valueOf(this.b);
    }

    @Override // U3.InterfaceC0213j, U3.z
    public Character getStart() {
        return Character.valueOf(this.f728a);
    }

    public static /* synthetic */ void getEndExclusive$annotations() {
    }
}
