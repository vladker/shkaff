package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1479h extends B {
    public C1479h() {
        super("InCell", 14);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        boolean zD = o6.d();
        C1510x c1510x = B.f7523g;
        if (!zD) {
            if (!o6.e() || !W4.b.c(((M) o6).normalName, A.f7485A)) {
                c1467b.f7672g = o6;
                return c1510x.c(o6, c1467b);
            }
            if (!c1467b.v("td") && !c1467b.v("th")) {
                c1467b.m(this);
                return false;
            }
            if (c1467b.v("td")) {
                c1467b.e("td");
            } else {
                c1467b.e("th");
            }
            return c1467b.d(o6);
        }
        String str = ((L) o6).normalName;
        if (W4.b.c(str, A.f7518x)) {
            boolean zV = c1467b.v(str);
            C1477g c1477g = B.f7530n;
            if (!zV) {
                c1467b.m(this);
                c1467b.f7592l = c1477g;
                return false;
            }
            c1467b.o(false);
            if (!c1467b.b(str)) {
                c1467b.m(this);
            }
            c1467b.popStackToClose(str);
            c1467b.j();
            c1467b.f7592l = c1477g;
            return true;
        }
        if (W4.b.c(str, A.f7519y)) {
            c1467b.m(this);
            return false;
        }
        if (!W4.b.c(str, A.f7520z)) {
            c1467b.f7672g = o6;
            return c1510x.c(o6, c1467b);
        }
        if (!c1467b.v(str)) {
            c1467b.m(this);
            return false;
        }
        if (c1467b.v("td")) {
            c1467b.e("td");
        } else {
            c1467b.e("th");
        }
        return c1467b.d(o6);
    }
}
