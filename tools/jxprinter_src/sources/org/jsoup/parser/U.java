package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum U extends h1 {
    public U() {
        super("RCDATAEndTagOpen", 11);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (!c1465a.t()) {
            q6.g("</");
            q6.c = h1.c;
            return;
        }
        q6.d(false);
        N n6 = q6.f7568i;
        char cM = c1465a.m();
        n6.getClass();
        n6.m(String.valueOf(cM));
        q6.f7567h.append(c1465a.m());
        q6.a(h1.f7643m);
    }
}
