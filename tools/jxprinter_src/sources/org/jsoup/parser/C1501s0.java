package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1501s0 extends h1 {
    public C1501s0() {
        super("BeforeAttributeName", 33);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        C1503t0 c1503t0 = h1.f7623M;
        if (cE == 0) {
            c1465a.z();
            q6.m(this);
            q6.f7568i.q();
            q6.c = c1503t0;
            return;
        }
        if (cE != ' ') {
            if (cE != '\"' && cE != '\'') {
                if (cE == '/') {
                    q6.c = h1.f7651q0;
                    return;
                }
                C1470c0 c1470c0 = h1.f7634a;
                if (cE == 65535) {
                    q6.l(this);
                    q6.c = c1470c0;
                    return;
                }
                if (cE == '\t' || cE == '\n' || cE == '\f' || cE == '\r') {
                    return;
                }
                switch (cE) {
                    case '<':
                        c1465a.z();
                        q6.m(this);
                        break;
                    case '=':
                        break;
                    case '>':
                        break;
                    default:
                        q6.f7568i.q();
                        c1465a.z();
                        q6.c = c1503t0;
                        return;
                }
                q6.k();
                q6.c = c1470c0;
                return;
            }
            q6.m(this);
            q6.f7568i.q();
            q6.f7568i.h(cE);
            q6.c = c1503t0;
        }
    }
}
