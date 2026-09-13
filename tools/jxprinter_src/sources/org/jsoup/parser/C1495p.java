package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1495p extends B {
    public C1495p() {
        super("AfterAfterBody", 21);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.a()) {
            c1467b.y((I) o6);
            return true;
        }
        boolean zB = o6.b();
        C1510x c1510x = B.f7523g;
        if (zB || (o6.e() && ((M) o6).normalName.equals("html"))) {
            c1467b.f7672g = o6;
            return c1510x.c(o6, c1467b);
        }
        if (!B.a(o6)) {
            if (o6.c()) {
                return true;
            }
            c1467b.m(this);
            c1467b.f7592l = c1510x;
            return c1467b.d(o6);
        }
        org.jsoup.nodes.m mVarPopStackToClose = c1467b.popStackToClose("html");
        c1467b.x((H) o6);
        if (mVarPopStackToClose == null) {
            return true;
        }
        c1467b.e.add(mVarPopStackToClose);
        org.jsoup.nodes.m mVarSelectFirst = mVarPopStackToClose.selectFirst("body");
        if (mVarSelectFirst == null) {
            return true;
        }
        c1467b.e.add(mVarSelectFirst);
        return true;
    }
}
