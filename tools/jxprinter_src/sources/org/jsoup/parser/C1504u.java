package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1504u extends B {
    public C1504u() {
        super("InHead", 3);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (B.a(o6)) {
            c1467b.x((H) o6);
            return true;
        }
        int iB = p050j.n.b(o6.f7560a);
        if (iB == 0) {
            c1467b.m(this);
            return false;
        }
        if (iB != 1) {
            if (iB != 2) {
                if (iB != 3) {
                    c1467b.e("head");
                    return c1467b.d(o6);
                }
                c1467b.y((I) o6);
                return true;
            }
            String str = ((L) o6).normalName;
            if (str.equals("head")) {
                c1467b.F();
                c1467b.f7592l = B.f7522f;
                return true;
            }
            if (W4.b.c(str, A.c)) {
                c1467b.e("head");
                return c1467b.d(o6);
            }
            if (!str.equals("template")) {
                c1467b.m(this);
                return false;
            }
            if (!c1467b.D(str)) {
                c1467b.m(this);
                return true;
            }
            c1467b.o(true);
            if (!str.equals(c1467b.a().c.b)) {
                c1467b.m(this);
            }
            c1467b.popStackToClose(str);
            c1467b.j();
            c1467b.popTemplateMode();
            c1467b.L();
            return true;
        }
        M m6 = (M) o6;
        String str2 = m6.normalName;
        if (str2.equals("html")) {
            return B.f7523g.c(o6, c1467b);
        }
        if (W4.b.c(str2, A.f7499a)) {
            org.jsoup.nodes.m mVarZ = c1467b.z(m6);
            if (str2.equals("base") && mVarZ.o("href") && !c1467b.f7594n) {
                String strA = mVarZ.a("href");
                if (strA.length() != 0) {
                    c1467b.f7671f = strA;
                    c1467b.f7594n = true;
                    org.jsoup.nodes.i iVar = c1467b.d;
                    iVar.getClass();
                    V4.h.notNull(strA);
                    iVar.G(strA);
                }
            }
            return true;
        }
        if (str2.equals("meta")) {
            c1467b.z(m6);
            return true;
        }
        boolean zEquals = str2.equals("title");
        C1512y c1512y = B.f7524h;
        if (zEquals) {
            c1467b.c.c = h1.c;
            c1467b.f7593m = c1467b.f7592l;
            c1467b.f7592l = c1512y;
            c1467b.w(m6);
            return true;
        }
        if (W4.b.c(str2, A.b)) {
            B.b(m6, c1467b);
            return true;
        }
        if (str2.equals("noscript")) {
            c1467b.w(m6);
            c1467b.f7592l = B.e;
            return true;
        }
        if (str2.equals("script")) {
            c1467b.c.c = h1.f7635f;
            c1467b.f7593m = c1467b.f7592l;
            c1467b.f7592l = c1512y;
            c1467b.w(m6);
            return true;
        }
        if (str2.equals("head")) {
            c1467b.m(this);
            return false;
        }
        if (!str2.equals("template")) {
            c1467b.e("head");
            return c1467b.d(o6);
        }
        c1467b.w(m6);
        c1467b.f7595o.add(null);
        c1467b.f7599s = false;
        C1485k c1485k = B.f7534r;
        c1467b.f7592l = c1485k;
        c1467b.H(c1485k);
        return true;
    }
}
