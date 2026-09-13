package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum g1 extends h1 {
    public g1() {
        super("EndTagOpen", 8);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        boolean zO = c1465a.o();
        C1470c0 c1470c0 = h1.f7634a;
        if (zO) {
            q6.l(this);
            q6.g("</");
            q6.c = c1470c0;
        } else if (c1465a.t()) {
            q6.d(false);
            q6.c = h1.f7639j;
        } else {
            if (c1465a.r('>')) {
                q6.m(this);
                q6.a(c1470c0);
                return;
            }
            q6.m(this);
            I i5 = q6.f7573n;
            i5.f();
            i5.d = true;
            i5.h('/');
            q6.c = h1.f7653r0;
        }
    }
}
