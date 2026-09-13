package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum B0 extends h1 {
    public B0() {
        super("SelfClosingStartTag", 41);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        C1470c0 c1470c0 = h1.f7634a;
        if (cE == '>') {
            q6.f7568i.f7559g = true;
            q6.k();
            q6.c = c1470c0;
        } else if (cE == 65535) {
            q6.l(this);
            q6.c = c1470c0;
        } else {
            c1465a.z();
            q6.m(this);
            q6.c = h1.f7620K;
        }
    }
}
