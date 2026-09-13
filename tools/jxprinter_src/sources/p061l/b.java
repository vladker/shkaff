package p061l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5759a;
    public int b;
    public int c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f5762h;

    public b(int i5, b bVar) {
        this.f5759a = i5;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f5760f = bVar.f5760f;
        this.f5761g = bVar.f5761g;
    }

    public final void a(int i5, String str, String str2, String str3) {
        this.b = i5;
        this.d = str;
        this.e = str2;
        this.f5760f = str3;
        if (i5 != 1 && i5 != 7 && i5 != 8) {
            if (i5 == 12) {
                this.f5761g = ((str2.hashCode() * str.hashCode()) + i5) & Integer.MAX_VALUE;
                return;
            } else if (i5 != 13) {
                this.f5761g = ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i5) & Integer.MAX_VALUE;
                return;
            }
        }
        this.f5761g = (str.hashCode() + i5) & Integer.MAX_VALUE;
    }
}
