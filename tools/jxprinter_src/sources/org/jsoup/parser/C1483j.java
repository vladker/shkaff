package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1483j extends B {
    public C1483j() {
        super("InSelectInTable", 16);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        boolean zE = o6.e();
        String[] strArr = A.f7493I;
        if (zE && W4.b.c(((M) o6).normalName, strArr)) {
            c1467b.m(this);
            c1467b.popStackToClose("select");
            c1467b.L();
            return c1467b.d(o6);
        }
        if (o6.d()) {
            L l6 = (L) o6;
            if (W4.b.c(l6.normalName, strArr)) {
                c1467b.m(this);
                if (!c1467b.v(l6.normalName)) {
                    return false;
                }
                c1467b.popStackToClose("select");
                c1467b.L();
                return c1467b.d(o6);
            }
        }
        c1467b.f7672g = o6;
        return B.f7532p.c(o6, c1467b);
    }
}
