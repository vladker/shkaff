package A3;

/* JADX INFO: renamed from: A3.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0133b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f36a;
    public final Object b;

    public C0133b0(int i5, Object obj) {
        this.f36a = i5;
        this.b = obj;
    }

    public final C0133b0 copy(int i5, Object obj) {
        return new C0133b0(i5, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0133b0)) {
            return false;
        }
        C0133b0 c0133b0 = (C0133b0) obj;
        return this.f36a == c0133b0.f36a && kotlin.jvm.internal.E.a(this.b, c0133b0.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f36a) * 31;
        Object obj = this.b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f36a + ", value=" + this.b + ')';
    }
}
