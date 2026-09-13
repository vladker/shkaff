package org.jsoup.parser;

import java.util.ArrayList;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: renamed from: org.jsoup.parser.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1514z extends B {
    public C1514z() {
        super("InTable", 8);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.f7560a == 5 && W4.b.c(c1467b.a().c.b, A.f7487C)) {
            c1467b.f7597q = new ArrayList();
            c1467b.f7593m = c1467b.f7592l;
            c1467b.f7592l = B.f7526j;
            return c1467b.d(o6);
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
        C1504u c1504u = B.d;
        if (!zE) {
            if (!o6.d()) {
                if (!o6.c()) {
                    d(o6, c1467b);
                    return true;
                }
                if (c1467b.b("html")) {
                    c1467b.m(this);
                }
                return true;
            }
            String str = ((L) o6).normalName;
            if (str.equals("table")) {
                if (!c1467b.v(str)) {
                    c1467b.m(this);
                    return false;
                }
                c1467b.popStackToClose("table");
                c1467b.L();
                return true;
            }
            if (W4.b.c(str, A.f7486B)) {
                c1467b.m(this);
                return false;
            }
            if (str.equals("template")) {
                c1467b.G(o6, c1504u);
                return true;
            }
            d(o6, c1467b);
            return true;
        }
        M m6 = (M) o6;
        String str2 = m6.normalName;
        if (str2.equals("caption")) {
            c1467b.l();
            c1467b.f7595o.add(null);
            c1467b.w(m6);
            c1467b.f7592l = B.f7527k;
            return true;
        }
        if (str2.equals("colgroup")) {
            c1467b.l();
            c1467b.w(m6);
            c1467b.f7592l = B.f7528l;
            return true;
        }
        if (str2.equals("col")) {
            c1467b.l();
            c1467b.f("colgroup");
            return c1467b.d(o6);
        }
        if (W4.b.c(str2, A.f7515u)) {
            c1467b.l();
            c1467b.w(m6);
            c1467b.f7592l = B.f7529m;
            return true;
        }
        if (W4.b.c(str2, A.f7516v)) {
            c1467b.l();
            c1467b.f("tbody");
            return c1467b.d(o6);
        }
        if (str2.equals("table")) {
            c1467b.m(this);
            if (c1467b.v(str2)) {
                c1467b.popStackToClose(str2);
                c1467b.L();
                if (c1467b.f7592l != B.f7525i) {
                    return c1467b.d(o6);
                }
                c1467b.w(m6);
                return true;
            }
        } else {
            if (W4.b.c(str2, A.f7517w)) {
                c1467b.f7672g = o6;
                return c1504u.c(o6, c1467b);
            }
            if (str2.equals("input")) {
                if (m6.n() && m6.attributes.h("type").equalsIgnoreCase(CellUtil.HIDDEN)) {
                    c1467b.z(m6);
                    return true;
                }
                d(o6, c1467b);
                return true;
            }
            if (!str2.equals("form")) {
                d(o6, c1467b);
                return true;
            }
            c1467b.m(this);
            if (c1467b.getFormElement() == null && !c1467b.D("template")) {
                c1467b.A(m6, false, false);
                return true;
            }
        }
        return false;
    }

    public final void d(O o6, C1467b c1467b) {
        c1467b.m(this);
        c1467b.f7600t = true;
        c1467b.G(o6, B.f7523g);
        c1467b.f7600t = false;
    }
}
