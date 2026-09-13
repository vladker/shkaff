package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1496p0 extends h1 {
    public C1496p0() {
        super("ScriptDataDoubleEscapedDashDash", 30);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        C1490m0 c1490m0 = h1.f7608D;
        if (cE == 0) {
            q6.m(this);
            q6.f((char) 65533);
            q6.c = c1490m0;
            return;
        }
        if (cE == '-') {
            q6.f(cE);
            return;
        }
        if (cE == '<') {
            q6.f(cE);
            q6.c = h1.f7616I;
        } else if (cE == '>') {
            q6.f(cE);
            q6.c = h1.f7635f;
        } else if (cE != 65535) {
            q6.f(cE);
            q6.c = c1490m0;
        } else {
            q6.l(this);
            q6.c = h1.f7634a;
        }
    }
}
