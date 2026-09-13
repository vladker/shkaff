package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum G0 extends h1 {
    public G0() {
        super("Comment", 46);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cM = c1465a.m();
        if (cM == 0) {
            q6.m(this);
            c1465a.a();
            q6.f7573n.h((char) 65533);
        } else if (cM == '-') {
            q6.a(h1.f7663w0);
        } else {
            if (cM != 65535) {
                q6.f7573n.i(c1465a.j('-', 0));
                return;
            }
            q6.l(this);
            q6.i();
            q6.c = h1.f7634a;
        }
    }
}
