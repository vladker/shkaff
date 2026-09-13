package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1475f extends B {
    public C1475f() {
        super("InTableBody", 12);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        int iB = p050j.n.b(o6.f7560a);
        C1514z c1514z = B.f7525i;
        if (iB == 1) {
            M m6 = (M) o6;
            String str = m6.normalName;
            if (str.equals("tr")) {
                c1467b.k("tbody", "tfoot", "thead", "template");
                c1467b.w(m6);
                c1467b.f7592l = B.f7530n;
                return true;
            }
            if (W4.b.c(str, A.f7518x)) {
                c1467b.m(this);
                c1467b.f("tr");
                return c1467b.d(m6);
            }
            if (W4.b.c(str, A.f7488D)) {
                return d(o6, c1467b);
            }
            c1467b.f7672g = o6;
            return c1514z.c(o6, c1467b);
        }
        if (iB != 2) {
            c1467b.f7672g = o6;
            return c1514z.c(o6, c1467b);
        }
        String str2 = ((L) o6).normalName;
        if (W4.b.c(str2, A.f7494J)) {
            if (!c1467b.v(str2)) {
                c1467b.m(this);
                return false;
            }
            c1467b.k("tbody", "tfoot", "thead", "template");
            c1467b.F();
            c1467b.f7592l = c1514z;
            return true;
        }
        if (str2.equals("table")) {
            return d(o6, c1467b);
        }
        if (W4.b.c(str2, A.f7489E)) {
            c1467b.m(this);
            return false;
        }
        c1467b.f7672g = o6;
        return c1514z.c(o6, c1467b);
    }

    public final boolean d(O o6, C1467b c1467b) {
        if (!c1467b.v("tbody") && !c1467b.v("thead") && !c1467b.s("tfoot")) {
            c1467b.m(this);
            return false;
        }
        c1467b.k("tbody", "tfoot", "thead", "template");
        c1467b.e(c1467b.a().c.b);
        return c1467b.d(o6);
    }
}
