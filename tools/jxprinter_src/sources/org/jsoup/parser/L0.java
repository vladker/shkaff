package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum L0 extends h1 {
    public L0() {
        super("Doctype", 50);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        M0 m6 = h1.f7604A0;
        if (cE == '\t' || cE == '\n' || cE == '\f' || cE == '\r' || cE == ' ') {
            q6.c = m6;
            return;
        }
        if (cE != '>') {
            if (cE != 65535) {
                q6.m(this);
                q6.c = m6;
                return;
            }
            q6.l(this);
        }
        q6.m(this);
        J j6 = q6.f7572m;
        j6.f();
        j6.f7557f = true;
        q6.j();
        q6.c = h1.f7634a;
    }
}
