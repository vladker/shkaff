package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum S extends h1 {
    public S() {
        super("TagName", 9);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char c;
        c1465a.b();
        int i5 = c1465a.e;
        int i6 = c1465a.c;
        char[] cArr = c1465a.f7577a;
        int i7 = i5;
        while (i7 < i6 && (c = cArr[i7]) != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ' && c != '/' && c != '<' && c != '>') {
            i7++;
        }
        c1465a.e = i7;
        q6.f7568i.m(i7 > i5 ? C1465a.c(c1465a.f7577a, c1465a.f7580h, i5, i7 - i5) : "");
        char cE = c1465a.e();
        if (cE == 0) {
            q6.f7568i.m(h1.f7631S0);
            return;
        }
        if (cE != ' ') {
            if (cE == '/') {
                q6.c = h1.f7651q0;
                return;
            }
            C1470c0 c1470c0 = h1.f7634a;
            if (cE == '<') {
                c1465a.z();
                q6.m(this);
            } else if (cE != '>') {
                if (cE == 65535) {
                    q6.l(this);
                    q6.c = c1470c0;
                    return;
                } else if (cE != '\t' && cE != '\n' && cE != '\f' && cE != '\r') {
                    N n6 = q6.f7568i;
                    n6.getClass();
                    n6.m(String.valueOf(cE));
                    return;
                }
            }
            q6.k();
            q6.c = c1470c0;
            return;
        }
        q6.c = h1.f7620K;
    }
}
