package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1508w extends B {
    public C1508w() {
        super("AfterHead", 5);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (B.a(o6)) {
            c1467b.x((H) o6);
        } else if (o6.a()) {
            c1467b.y((I) o6);
        } else if (o6.b()) {
            c1467b.m(this);
        } else {
            boolean zE = o6.e();
            C1504u c1504u = B.d;
            if (zE) {
                M m6 = (M) o6;
                String str = m6.normalName;
                boolean zEquals = str.equals("html");
                C1510x c1510x = B.f7523g;
                if (zEquals) {
                    c1467b.f7672g = o6;
                    return c1510x.c(o6, c1467b);
                }
                if (str.equals("body")) {
                    c1467b.w(m6);
                    c1467b.f7599s = false;
                    c1467b.f7592l = c1510x;
                } else if (str.equals("frameset")) {
                    c1467b.w(m6);
                    c1467b.f7592l = B.f7536t;
                } else if (W4.b.c(str, A.f7501g)) {
                    c1467b.m(this);
                    org.jsoup.nodes.m mVarQ = c1467b.q();
                    c1467b.e.add(mVarQ);
                    c1467b.G(o6, c1504u);
                    c1467b.K(mVarQ);
                } else {
                    if (str.equals("head")) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.f("body");
                    c1467b.f7599s = true;
                    c1467b.d(o6);
                }
            } else if (o6.d()) {
                String str2 = ((L) o6).normalName;
                if (W4.b.c(str2, A.d)) {
                    c1467b.f("body");
                    c1467b.f7599s = true;
                    c1467b.d(o6);
                } else {
                    if (!str2.equals("template")) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.G(o6, c1504u);
                }
            } else {
                c1467b.f("body");
                c1467b.f7599s = true;
                c1467b.d(o6);
            }
        }
        return true;
    }
}
