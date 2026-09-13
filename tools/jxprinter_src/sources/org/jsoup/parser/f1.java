package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum f1 extends h1 {
    public f1() {
        super("TagOpen", 7);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cM = c1465a.m();
        if (cM == '!') {
            q6.a(h1.f7655s0);
            return;
        }
        if (cM == '/') {
            q6.a(h1.f7638i);
            return;
        }
        if (cM == '?') {
            I i5 = q6.f7573n;
            i5.f();
            i5.d = true;
            q6.c = h1.f7653r0;
            return;
        }
        if (c1465a.t()) {
            q6.d(true);
            q6.c = h1.f7639j;
        } else {
            q6.m(this);
            q6.f('<');
            q6.c = h1.f7634a;
        }
    }
}
