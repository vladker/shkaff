package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum e1 extends h1 {
    public e1() {
        super("PLAINTEXT", 6);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cM = c1465a.m();
        if (cM == 0) {
            q6.m(this);
            c1465a.a();
            q6.f((char) 65533);
        } else if (cM != 65535) {
            q6.g(c1465a.i((char) 0));
        } else {
            q6.h(new K());
        }
    }
}
