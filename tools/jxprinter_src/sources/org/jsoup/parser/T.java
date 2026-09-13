package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum T extends h1 {
    public T() {
        super("RcdataLessthanSign", 10);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.r('/')) {
            q6.e();
            q6.a(h1.f7642l);
            return;
        }
        if (!c1465a.t() || q6.f7574o == null || c1465a.l(q6.b())) {
            q6.g("<");
            q6.c = h1.c;
            return;
        }
        N nD = q6.d(false);
        nD.p(q6.f7574o);
        q6.f7568i = nD;
        q6.k();
        q6.c = h1.f7637h;
    }
}
