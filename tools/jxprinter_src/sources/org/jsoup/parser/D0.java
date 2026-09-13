package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum D0 extends h1 {
    public D0() {
        super("MarkupDeclarationOpen", 43);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.p("--")) {
            q6.f7573n.f();
            q6.c = h1.f7657t0;
            return;
        }
        if (c1465a.q("DOCTYPE")) {
            q6.c = h1.f7669z0;
            return;
        }
        if (c1465a.p("[CDATA[")) {
            q6.e();
            q6.c = h1.f7627P0;
            return;
        }
        q6.m(this);
        I i5 = q6.f7573n;
        i5.f();
        i5.d = true;
        q6.c = h1.f7653r0;
    }
}
