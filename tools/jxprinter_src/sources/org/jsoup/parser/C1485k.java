package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1485k extends B {
    public C1485k() {
        super("InTemplate", 17);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        int iB = p050j.n.b(o6.f7560a);
        C1510x c1510x = B.f7523g;
        if (iB != 0) {
            C1504u c1504u = B.d;
            if (iB == 1) {
                String str = ((M) o6).normalName;
                if (W4.b.c(str, A.f7497M)) {
                    c1467b.G(o6, c1504u);
                    return true;
                }
                if (W4.b.c(str, A.f7498N)) {
                    c1467b.popTemplateMode();
                    C1514z c1514z = B.f7525i;
                    c1467b.H(c1514z);
                    c1467b.f7592l = c1514z;
                    return c1467b.d(o6);
                }
                if (str.equals("col")) {
                    c1467b.popTemplateMode();
                    C1473e c1473e = B.f7528l;
                    c1467b.H(c1473e);
                    c1467b.f7592l = c1473e;
                    return c1467b.d(o6);
                }
                if (str.equals("tr")) {
                    c1467b.popTemplateMode();
                    C1475f c1475f = B.f7529m;
                    c1467b.H(c1475f);
                    c1467b.f7592l = c1475f;
                    return c1467b.d(o6);
                }
                if (!str.equals("td") && !str.equals("th")) {
                    c1467b.popTemplateMode();
                    c1467b.H(c1510x);
                    c1467b.f7592l = c1510x;
                    return c1467b.d(o6);
                }
                c1467b.popTemplateMode();
                C1477g c1477g = B.f7530n;
                c1467b.H(c1477g);
                c1467b.f7592l = c1477g;
                return c1467b.d(o6);
            }
            if (iB == 2) {
                if (((L) o6).normalName.equals("template")) {
                    c1467b.G(o6, c1504u);
                    return true;
                }
                c1467b.m(this);
                return false;
            }
            if (iB != 3 && iB != 4) {
                if (iB == 5 && c1467b.D("template")) {
                    c1467b.m(this);
                    c1467b.popStackToClose("template");
                    c1467b.j();
                    c1467b.popTemplateMode();
                    c1467b.L();
                    if (c1467b.f7592l != B.f7534r && c1467b.f7596p.size() < 12) {
                        return c1467b.d(o6);
                    }
                }
                return true;
            }
        }
        c1467b.G(o6, c1510x);
        return true;
    }
}
