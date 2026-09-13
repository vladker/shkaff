package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1491n extends B {
    public C1491n() {
        super("InFrameset", 19);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (B.a(o6)) {
            c1467b.x((H) o6);
            return true;
        }
        if (o6.a()) {
            c1467b.y((I) o6);
            return true;
        }
        if (o6.b()) {
            c1467b.m(this);
            return false;
        }
        if (!o6.e()) {
            if (o6.d() && ((L) o6).normalName.equals("frameset")) {
                if (c1467b.b("html")) {
                    c1467b.m(this);
                    return false;
                }
                c1467b.F();
                if (!c1467b.f7601u && !c1467b.b("frameset")) {
                    c1467b.f7592l = B.f7537u;
                    return true;
                }
            } else {
                if (!o6.c()) {
                    c1467b.m(this);
                    return false;
                }
                if (!c1467b.b("html")) {
                    c1467b.m(this);
                }
            }
            return true;
        }
        M m6 = (M) o6;
        String str = m6.normalName;
        str.getClass();
        switch (str) {
            case "frameset":
                c1467b.w(m6);
                return true;
            case "html":
                c1467b.f7672g = m6;
                return B.f7523g.c(m6, c1467b);
            case "frame":
                c1467b.z(m6);
                return true;
            case "noframes":
                c1467b.f7672g = m6;
                return B.d.c(m6, c1467b);
            default:
                c1467b.m(this);
                return false;
        }
    }
}
