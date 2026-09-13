package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1481i extends B {
    public C1481i() {
        super("InSelect", 15);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        int iB = p050j.n.b(o6.f7560a);
        if (iB == 0) {
            c1467b.m(this);
            return false;
        }
        C1504u c1504u = B.d;
        if (iB == 1) {
            M m6 = (M) o6;
            String str = m6.normalName;
            if (str.equals("html")) {
                c1467b.f7672g = m6;
                return B.f7523g.c(m6, c1467b);
            }
            if (str.equals("option")) {
                if (c1467b.b("option")) {
                    c1467b.e("option");
                }
                c1467b.w(m6);
                return true;
            }
            if (str.equals("optgroup")) {
                if (c1467b.b("option")) {
                    c1467b.e("option");
                }
                if (c1467b.b("optgroup")) {
                    c1467b.e("optgroup");
                }
                c1467b.w(m6);
                return true;
            }
            if (str.equals("select")) {
                c1467b.m(this);
                return c1467b.e("select");
            }
            if (W4.b.c(str, A.f7492H)) {
                c1467b.m(this);
                if (!c1467b.t("select")) {
                    return false;
                }
                c1467b.e("select");
                return c1467b.d(m6);
            }
            if (str.equals("script") || str.equals("template")) {
                c1467b.f7672g = o6;
                return c1504u.c(o6, c1467b);
            }
            c1467b.m(this);
            return false;
        }
        if (iB != 2) {
            if (iB == 3) {
                c1467b.y((I) o6);
                return true;
            }
            if (iB != 4) {
                if (iB != 5) {
                    c1467b.m(this);
                    return false;
                }
                if (!c1467b.b("html")) {
                    c1467b.m(this);
                }
                return true;
            }
            H h6 = (H) o6;
            if (h6.b.equals(B.f7540x)) {
                c1467b.m(this);
                return false;
            }
            c1467b.x(h6);
            return true;
        }
        String str2 = ((L) o6).normalName;
        str2.getClass();
        switch (str2) {
            case "template":
                c1467b.f7672g = o6;
                return c1504u.c(o6, c1467b);
            case "option":
                if (c1467b.b("option")) {
                    c1467b.F();
                    return true;
                }
                c1467b.m(this);
                return true;
            case "select":
                if (!c1467b.t(str2)) {
                    c1467b.m(this);
                    return false;
                }
                c1467b.popStackToClose(str2);
                c1467b.L();
                return true;
            case "optgroup":
                if (c1467b.b("option") && c1467b.aboveOnStack(c1467b.a()) != null && c1467b.aboveOnStack(c1467b.a()).c.b.equals("optgroup")) {
                    c1467b.e("option");
                }
                if (c1467b.b("optgroup")) {
                    c1467b.F();
                    return true;
                }
                c1467b.m(this);
                return true;
            default:
                c1467b.m(this);
                return false;
        }
    }
}
