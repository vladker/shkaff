package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1476f0 extends h1 {
    public C1476f0() {
        super("ScriptDataEscaped", 21);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.o()) {
            q6.l(this);
            q6.c = h1.f7634a;
            return;
        }
        char cM = c1465a.m();
        if (cM == 0) {
            q6.m(this);
            c1465a.a();
            q6.f((char) 65533);
        } else if (cM == '-') {
            q6.f('-');
            q6.a(h1.f7662w);
        } else if (cM != '<') {
            q6.g(c1465a.j('-', '<', 0));
        } else {
            q6.a(h1.f7666y);
        }
    }
}
