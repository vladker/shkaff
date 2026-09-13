package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum N0 extends h1 {
    public N0() {
        super("DoctypeName", 52);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.u()) {
            q6.f7572m.b.append(c1465a.h());
            return;
        }
        char cE = c1465a.e();
        if (cE == 0) {
            q6.m(this);
            q6.f7572m.b.append((char) 65533);
            return;
        }
        if (cE != ' ') {
            C1470c0 c1470c0 = h1.f7634a;
            if (cE == '>') {
                q6.j();
                q6.c = c1470c0;
                return;
            }
            if (cE == 65535) {
                q6.l(this);
                q6.f7572m.f7557f = true;
                q6.j();
                q6.c = c1470c0;
                return;
            }
            if (cE != '\t' && cE != '\n' && cE != '\f' && cE != '\r') {
                q6.f7572m.b.append(cE);
                return;
            }
        }
        q6.c = h1.f7607C0;
    }
}
