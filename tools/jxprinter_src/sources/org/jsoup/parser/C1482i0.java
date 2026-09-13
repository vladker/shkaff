package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1482i0 extends h1 {
    public C1482i0() {
        super("ScriptDataEscapedLessthanSign", 24);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.t()) {
            q6.e();
            q6.f7567h.append(c1465a.m());
            q6.g("<");
            q6.f(c1465a.m());
            q6.a(h1.f7606C);
            return;
        }
        if (c1465a.r('/')) {
            q6.e();
            q6.a(h1.f7668z);
        } else {
            q6.f('<');
            q6.c = h1.f7660v;
        }
    }
}
