package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1473e extends B {
    public C1473e() {
        super("InColumnGroup", 11);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (B.a(o6)) {
            c1467b.x((H) o6);
            return true;
        }
        int iB = p050j.n.b(o6.f7560a);
        if (iB == 0) {
            c1467b.m(this);
            return true;
        }
        byte b = 0;
        C1504u c1504u = B.d;
        if (iB != 1) {
            if (iB != 2) {
                if (iB == 3) {
                    c1467b.y((I) o6);
                    return true;
                }
                if (iB != 5) {
                    return d(o6, c1467b);
                }
                if (c1467b.b("html")) {
                    return true;
                }
                return d(o6, c1467b);
            }
            String str = ((L) o6).normalName;
            str.getClass();
            if (str.equals("template")) {
                c1467b.G(o6, c1504u);
                return true;
            }
            if (!str.equals("colgroup")) {
                return d(o6, c1467b);
            }
            if (!c1467b.b(str)) {
                c1467b.m(this);
                return false;
            }
            c1467b.F();
            c1467b.f7592l = B.f7525i;
            return true;
        }
        M m6 = (M) o6;
        String str2 = m6.normalName;
        str2.getClass();
        switch (str2.hashCode()) {
            case -1321546630:
                if (!str2.equals("template")) {
                    b = -1;
                }
                break;
            case 98688:
                b = !str2.equals("col") ? (byte) -1 : (byte) 1;
                break;
            case 3213227:
                b = !str2.equals("html") ? (byte) -1 : (byte) 2;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                c1467b.G(o6, c1504u);
                return true;
            case 1:
                c1467b.z(m6);
                return true;
            case 2:
                c1467b.f7672g = o6;
                return B.f7523g.c(o6, c1467b);
            default:
                return d(o6, c1467b);
        }
    }

    public final boolean d(O o6, C1467b c1467b) {
        if (!c1467b.b("colgroup")) {
            c1467b.m(this);
            return false;
        }
        c1467b.F();
        c1467b.f7592l = B.f7525i;
        c1467b.d(o6);
        return true;
    }
}
