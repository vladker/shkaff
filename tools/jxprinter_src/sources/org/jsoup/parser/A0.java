package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum A0 extends h1 {
    public A0() {
        super("AfterAttributeValue_quoted", 40);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        C1501s0 c1501s0 = h1.f7620K;
        if (cE == '\t' || cE == '\n' || cE == '\f' || cE == '\r' || cE == ' ') {
            q6.c = c1501s0;
            return;
        }
        if (cE == '/') {
            q6.c = h1.f7651q0;
            return;
        }
        C1470c0 c1470c0 = h1.f7634a;
        if (cE == '>') {
            q6.k();
            q6.c = c1470c0;
        } else if (cE == 65535) {
            q6.l(this);
            q6.c = c1470c0;
        } else {
            c1465a.z();
            q6.m(this);
            q6.c = c1501s0;
        }
    }
}
