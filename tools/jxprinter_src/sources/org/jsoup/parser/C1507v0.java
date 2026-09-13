package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1507v0 extends h1 {
    public C1507v0() {
        super("BeforeAttributeValue", 36);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        C1515z0 c1515z0 = h1.f7647o0;
        if (cE == 0) {
            q6.m(this);
            q6.f7568i.j((char) 65533);
            q6.c = c1515z0;
            return;
        }
        if (cE != ' ') {
            if (cE == '\"') {
                q6.c = h1.f7641k0;
                return;
            }
            if (cE != '`') {
                C1470c0 c1470c0 = h1.f7634a;
                if (cE == 65535) {
                    q6.l(this);
                    q6.k();
                    q6.c = c1470c0;
                    return;
                }
                if (cE == '\t' || cE == '\n' || cE == '\f' || cE == '\r') {
                    return;
                }
                if (cE == '&') {
                    c1465a.z();
                    q6.c = c1515z0;
                    return;
                }
                if (cE == '\'') {
                    q6.c = h1.f7645n0;
                    return;
                }
                switch (cE) {
                    case '<':
                    case '=':
                        break;
                    case '>':
                        q6.m(this);
                        q6.k();
                        q6.c = c1470c0;
                        break;
                    default:
                        c1465a.z();
                        q6.c = c1515z0;
                        break;
                }
                return;
            }
            q6.m(this);
            q6.f7568i.j(cE);
            q6.c = c1515z0;
        }
    }
}
