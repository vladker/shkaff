package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1478g0 extends h1 {
    public C1478g0() {
        super("ScriptDataEscapedDash", 22);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.o()) {
            q6.l(this);
            q6.c = h1.f7634a;
            return;
        }
        char cE = c1465a.e();
        C1476f0 c1476f0 = h1.f7660v;
        if (cE == 0) {
            q6.m(this);
            q6.f((char) 65533);
            q6.c = c1476f0;
        } else if (cE == '-') {
            q6.f(cE);
            q6.c = h1.f7664x;
        } else if (cE == '<') {
            q6.c = h1.f7666y;
        } else {
            q6.f(cE);
            q6.c = c1476f0;
        }
    }
}
