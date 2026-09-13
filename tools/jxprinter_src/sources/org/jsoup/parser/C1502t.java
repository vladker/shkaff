package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1502t extends B {
    public C1502t() {
        super("BeforeHead", 2);
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
        if (o6.e() && ((M) o6).normalName.equals("html")) {
            return B.f7523g.c(o6, c1467b);
        }
        if (o6.e()) {
            M m6 = (M) o6;
            if (m6.normalName.equals("head")) {
                c1467b.N(c1467b.w(m6));
                c1467b.f7592l = B.d;
                return true;
            }
        }
        if (o6.d() && W4.b.c(((L) o6).normalName, A.e)) {
            c1467b.f("head");
            return c1467b.d(o6);
        }
        if (o6.d()) {
            c1467b.m(this);
            return false;
        }
        c1467b.f("head");
        return c1467b.d(o6);
    }
}
