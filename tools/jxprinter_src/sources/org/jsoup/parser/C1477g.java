package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1477g extends B {
    public C1477g() {
        super("InRow", 13);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        boolean zE = o6.e();
        C1514z c1514z = B.f7525i;
        if (zE) {
            M m6 = (M) o6;
            String str = m6.normalName;
            if (W4.b.c(str, A.f7518x)) {
                c1467b.k("tr", "template");
                c1467b.w(m6);
                c1467b.f7592l = B.f7531o;
                c1467b.f7595o.add(null);
                return true;
            }
            if (!W4.b.c(str, A.f7490F)) {
                c1467b.f7672g = o6;
                return c1514z.c(o6, c1467b);
            }
            if (c1467b.e("tr")) {
                return c1467b.d(o6);
            }
            return false;
        }
        if (!o6.d()) {
            c1467b.f7672g = o6;
            return c1514z.c(o6, c1467b);
        }
        String str2 = ((L) o6).normalName;
        boolean zEquals = str2.equals("tr");
        C1475f c1475f = B.f7529m;
        if (zEquals) {
            if (!c1467b.v(str2)) {
                c1467b.m(this);
                return false;
            }
            c1467b.k("tr", "template");
            c1467b.F();
            c1467b.f7592l = c1475f;
            return true;
        }
        if (str2.equals("table")) {
            if (c1467b.e("tr")) {
                return c1467b.d(o6);
            }
            return false;
        }
        if (!W4.b.c(str2, A.f7515u)) {
            if (W4.b.c(str2, A.f7491G)) {
                c1467b.m(this);
                return false;
            }
            c1467b.f7672g = o6;
            return c1514z.c(o6, c1467b);
        }
        if (!c1467b.v(str2) || !c1467b.v("tr")) {
            c1467b.m(this);
            return false;
        }
        c1467b.k("tr", "template");
        c1467b.F();
        c1467b.f7592l = c1475f;
        return true;
    }
}
