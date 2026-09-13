package g5;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4023a;
    public String b;
    public String c;
    public int d;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f4023a == null || aVar.b == null || aVar.d != this.d || !aVar.c.equals(this.c)) {
            return false;
        }
        if (aVar.f4023a.equals(this.f4023a) && aVar.b.equals(this.b) && aVar.c.equals(this.c)) {
            return true;
        }
        return aVar.f4023a.equals(this.b) && aVar.b.equals(this.f4023a) && aVar.c.equals(this.c);
    }
}
