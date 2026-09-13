package Q2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f575a;
    public final float b;

    public a(float f6, float f7) {
        this.f575a = f6;
        this.b = f7;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f575a == aVar.f575a && this.b == aVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f575a) ^ Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return this.f575a + "x" + this.b;
    }
}
