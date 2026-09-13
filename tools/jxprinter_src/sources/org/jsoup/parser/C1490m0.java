package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1490m0 extends h1 {
    public C1490m0() {
        super("ScriptDataDoubleEscaped", 28);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cM = c1465a.m();
        if (cM == 0) {
            q6.m(this);
            c1465a.a();
            q6.f((char) 65533);
        } else if (cM == '-') {
            q6.f(cM);
            q6.a(h1.f7612G);
        } else if (cM == '<') {
            q6.f(cM);
            q6.a(h1.f7616I);
        } else if (cM != 65535) {
            q6.g(c1465a.j('-', '<', 0));
        } else {
            q6.l(this);
            q6.c = h1.f7634a;
        }
    }
}
