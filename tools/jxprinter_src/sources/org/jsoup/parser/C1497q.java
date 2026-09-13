package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1497q extends B {
    public C1497q() {
        super("AfterAfterFrameset", 22);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.a()) {
            c1467b.y((I) o6);
            return true;
        }
        if (o6.b() || B.a(o6) || (o6.e() && ((M) o6).normalName.equals("html"))) {
            c1467b.f7672g = o6;
            return B.f7523g.c(o6, c1467b);
        }
        if (o6.c()) {
            return true;
        }
        if (o6.e() && ((M) o6).normalName.equals("noframes")) {
            c1467b.f7672g = o6;
            return B.d.c(o6, c1467b);
        }
        c1467b.m(this);
        return false;
    }
}
