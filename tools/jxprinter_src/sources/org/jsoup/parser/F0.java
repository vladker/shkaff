package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum F0 extends h1 {
    public F0() {
        super("CommentStartDash", 45);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        G0 g1 = h1.f7661v0;
        if (cE == 0) {
            q6.m(this);
            q6.f7573n.h((char) 65533);
            q6.c = g1;
            return;
        }
        if (cE == '-') {
            q6.c = h1.f7659u0;
            return;
        }
        C1470c0 c1470c0 = h1.f7634a;
        if (cE == '>') {
            q6.m(this);
            q6.i();
            q6.c = c1470c0;
        } else if (cE != 65535) {
            q6.f7573n.h(cE);
            q6.c = g1;
        } else {
            q6.l(this);
            q6.i();
            q6.c = c1470c0;
        }
    }
}
