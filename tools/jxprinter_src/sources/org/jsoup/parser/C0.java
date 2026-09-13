package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C0 extends h1 {
    public C0() {
        super("BogusComment", 42);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        q6.f7573n.i(c1465a.i('>'));
        char cM = c1465a.m();
        if (cM == '>' || cM == 65535) {
            c1465a.e();
            q6.i();
            q6.c = h1.f7634a;
        }
    }
}
