package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1487l extends B {
    public C1487l() {
        super("AfterBody", 18);
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
        boolean zE = o6.e();
        C1510x c1510x = B.f7523g;
        if (zE && ((M) o6).normalName.equals("html")) {
            c1467b.f7672g = o6;
            return c1510x.c(o6, c1467b);
        }
        if (o6.d() && ((L) o6).normalName.equals("html")) {
            if (c1467b.f7601u) {
                c1467b.m(this);
                return false;
            }
            c1467b.f7592l = B.f7538v;
            return true;
        }
        if (o6.c()) {
            return true;
        }
        c1467b.m(this);
        c1467b.f7592l = c1510x;
        return c1467b.d(o6);
    }
}
