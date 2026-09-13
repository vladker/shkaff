package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f885a;
    public final String b;
    public final /* synthetic */ int c;

    public i(String str, String str2, boolean z6, int i5) {
        this.c = i5;
        V4.h.notEmpty(str);
        V4.h.notEmpty(str2);
        this.f885a = p051j0.i.j(str);
        boolean z7 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
        str2 = z7 ? androidx.collection.a.g(1, 1, str2) : str2;
        String strI = (!z6 && z7) ? p051j0.i.i(str2) : p051j0.i.j(str2);
        this.b = strI;
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        switch (this.c) {
            case 0:
                String str = this.f885a;
                if (mVar2.o(str)) {
                    if (this.b.equalsIgnoreCase(mVar2.f(str).trim())) {
                        return true;
                    }
                }
                return false;
            case 1:
                String str2 = this.f885a;
                return mVar2.o(str2) && p051j0.i.i(mVar2.f(str2)).contains(this.b);
            case 2:
                String str3 = this.f885a;
                return mVar2.o(str3) && p051j0.i.i(mVar2.f(str3)).endsWith(this.b);
            case 3:
                return !this.b.equalsIgnoreCase(mVar2.f(this.f885a));
            default:
                String str4 = this.f885a;
                return mVar2.o(str4) && p051j0.i.i(mVar2.f(str4)).startsWith(this.b);
        }
    }

    public final String toString() {
        switch (this.c) {
            case 0:
                return androidx.collection.a.p("[", this.f885a, "=", this.b, "]");
            case 1:
                return androidx.collection.a.p("[", this.f885a, "*=", this.b, "]");
            case 2:
                return androidx.collection.a.p("[", this.f885a, "$=", this.b, "]");
            case 3:
                return androidx.collection.a.p("[", this.f885a, "!=", this.b, "]");
            default:
                return androidx.collection.a.p("[", this.f885a, "^=", this.b, "]");
        }
    }
}
