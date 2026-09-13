package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1493o extends B {
    public C1493o() {
        super("AfterFrameset", 20);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (B.a(o6)) {
            c1467b.x((H) o6);
            return true;
        }
        if (o6.a()) {
            c1467b.y((I) o6);
            return true;
        }
        if (o6.b()) {
            c1467b.m(this);
            return false;
        }
        if (o6.e() && ((M) o6).normalName.equals("html")) {
            c1467b.f7672g = o6;
            return B.f7523g.c(o6, c1467b);
        }
        if (o6.d() && ((L) o6).normalName.equals("html")) {
            c1467b.f7592l = B.f7539w;
            return true;
        }
        if (o6.e() && ((M) o6).normalName.equals("noframes")) {
            c1467b.f7672g = o6;
            return B.d.c(o6, c1467b);
        }
        if (o6.c()) {
            return true;
        }
        c1467b.m(this);
        return false;
    }
}
