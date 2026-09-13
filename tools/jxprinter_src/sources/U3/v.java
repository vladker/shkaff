package U3;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends s implements InterfaceC0213j, z {
    public static final u Companion = new u();
    private static final v EMPTY = new v(1, 0);

    public v(long j6, long j7) {
        super(j6, j7, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // U3.InterfaceC0213j, U3.z
    public final boolean contains(Comparable comparable) {
        long jLongValue = ((Number) comparable).longValue();
        return this.f734a <= jLongValue && jLongValue <= this.b;
    }

    @Override // U3.s
    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        if (isEmpty() && ((v) obj).isEmpty()) {
            return true;
        }
        v vVar = (v) obj;
        return this.f734a == vVar.f734a && this.b == vVar.b;
    }

    @Override // U3.s
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j6 = this.f734a;
        long j7 = ((long) 31) * (j6 ^ (j6 >>> 32));
        long j8 = this.b;
        return (int) (j7 + (j8 ^ (j8 >>> 32)));
    }

    @Override // U3.s, U3.InterfaceC0213j
    public final boolean isEmpty() {
        return this.f734a > this.b;
    }

    @Override // U3.s
    public String toString() {
        return this.f734a + ".." + this.b;
    }

    @Override // U3.z
    public Long getEndExclusive() {
        long j6 = this.b;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            return Long.valueOf(j6 + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // U3.InterfaceC0213j
    public Long getEndInclusive() {
        return Long.valueOf(this.b);
    }

    @Override // U3.InterfaceC0213j, U3.z
    public Long getStart() {
        return Long.valueOf(this.f734a);
    }

    public static /* synthetic */ void getEndExclusive$annotations() {
    }
}
