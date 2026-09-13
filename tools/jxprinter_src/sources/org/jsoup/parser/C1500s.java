package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1500s extends B {
    public C1500s() {
        super("BeforeHtml", 1);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.b()) {
            c1467b.m(this);
            return false;
        }
        if (o6.a()) {
            c1467b.y((I) o6);
            return true;
        }
        if (B.a(o6)) {
            c1467b.x((H) o6);
            return true;
        }
        boolean zE = o6.e();
        C1502t c1502t = B.c;
        if (zE) {
            M m6 = (M) o6;
            if (m6.normalName.equals("html")) {
                c1467b.w(m6);
                c1467b.f7592l = c1502t;
                return true;
            }
        }
        if (o6.d() && W4.b.c(((L) o6).normalName, A.e)) {
            org.jsoup.nodes.m mVar = new org.jsoup.nodes.m(c1467b.h("html", c1467b.f7673h), null);
            c1467b.C(mVar);
            c1467b.e.add(mVar);
            c1467b.f7592l = c1502t;
            return c1467b.d(o6);
        }
        if (o6.d()) {
            c1467b.m(this);
            return false;
        }
        org.jsoup.nodes.m mVar2 = new org.jsoup.nodes.m(c1467b.h("html", c1467b.f7673h), null);
        c1467b.C(mVar2);
        c1467b.e.add(mVar2);
        c1467b.f7592l = c1502t;
        return c1467b.d(o6);
    }
}
