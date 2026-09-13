package p145z1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9111a;
    public final int b;
    public final boolean c;
    public final boolean d;

    public m(int i5, int i6, boolean z6, boolean z7) {
        this.f9111a = i5;
        this.b = i6;
        this.c = z6;
        this.d = z7;
    }

    public final m copy(int i5, int i6, boolean z6, boolean z7) {
        return new m(i5, i6, z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f9111a == mVar.f9111a && this.b == mVar.b && this.c == mVar.c && this.d == mVar.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ((Boolean.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f9111a) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "ScaleOption(width=" + this.f9111a + ", height=" + this.b + ", keepRatio=" + this.c + ", keepWidthFirst=" + this.d + ')';
    }
}
