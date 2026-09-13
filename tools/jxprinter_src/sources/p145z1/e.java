package p145z1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9105a;
    public final boolean b;

    public /* synthetic */ e(boolean z6, int i5) {
        this((i5 & 1) != 0 ? false : z6, (i5 & 2) == 0);
    }

    public final e copy(boolean z6, boolean z7) {
        return new e(z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f9105a == eVar.f9105a && this.b == eVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Boolean.hashCode(this.f9105a) * 31);
    }

    public String toString() {
        return "FlipOption(horizontal=" + this.f9105a + ", vertical=" + this.b + ')';
    }

    public e(boolean z6, boolean z7) {
        this.f9105a = z6;
        this.b = z7;
    }
}
