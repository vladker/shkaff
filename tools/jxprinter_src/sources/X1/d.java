package X1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d b = new d("tableDirectory");
    public static final d c = new d("name");
    public static final d d = new d("OS/2");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f839a;

    public d(String str) {
        this.f839a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f839a.equals(((d) obj).f839a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f839a.hashCode();
    }

    public final String toString() {
        return this.f839a;
    }
}
