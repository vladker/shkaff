package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1471d extends B {
    public C1471d() {
        super("InCaption", 10);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.d()) {
            L l6 = (L) o6;
            if (l6.normalName.equals("caption")) {
                if (!c1467b.v(l6.normalName)) {
                    c1467b.m(this);
                    return false;
                }
                c1467b.o(false);
                if (!c1467b.b("caption")) {
                    c1467b.m(this);
                }
                c1467b.popStackToClose("caption");
                c1467b.j();
                c1467b.f7592l = B.f7525i;
                return true;
            }
        }
        if ((o6.e() && W4.b.c(((M) o6).normalName, A.f7485A)) || (o6.d() && ((L) o6).normalName.equals("table"))) {
            c1467b.m(this);
            if (c1467b.e("caption")) {
                return c1467b.d(o6);
            }
            return true;
        }
        if (o6.d() && W4.b.c(((L) o6).normalName, A.f7496L)) {
            c1467b.m(this);
            return false;
        }
        c1467b.f7672g = o6;
        return B.f7523g.c(o6, c1467b);
    }
}
