package org.jsoup.parser;

import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: renamed from: org.jsoup.parser.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1506v extends B {
    public C1506v() {
        super("InHeadNoscript", 4);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.b()) {
            c1467b.m(this);
            return true;
        }
        if (o6.e() && ((M) o6).normalName.equals("html")) {
            c1467b.f7672g = o6;
            return B.f7523g.c(o6, c1467b);
        }
        boolean zD = o6.d();
        C1504u c1504u = B.d;
        if (zD && ((L) o6).normalName.equals("noscript")) {
            c1467b.F();
            c1467b.f7592l = c1504u;
            return true;
        }
        if (B.a(o6) || o6.a() || (o6.e() && W4.b.c(((M) o6).normalName, A.f7500f))) {
            c1467b.f7672g = o6;
            return c1504u.c(o6, c1467b);
        }
        if (o6.d() && ((L) o6).normalName.equals(CompressorStreamFactory.BROTLI)) {
            c1467b.m(this);
            H h6 = new H();
            h6.b = o6.toString();
            c1467b.x(h6);
            return true;
        }
        if ((o6.e() && W4.b.c(((M) o6).normalName, A.f7495K)) || o6.d()) {
            c1467b.m(this);
            return false;
        }
        c1467b.m(this);
        H h7 = new H();
        h7.b = o6.toString();
        c1467b.x(h7);
        return true;
    }
}
