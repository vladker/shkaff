package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum V extends h1 {
    public V() {
        super("RCDATAEndTagName", 12);
    }

    public static void e(Q q6, C1465a c1465a) {
        q6.g("</");
        StringBuilder sb = q6.f7567h;
        StringBuilder sb2 = q6.f7566g;
        if (q6.f7565f == null) {
            q6.f7565f = sb.toString();
        } else {
            if (sb2.length() == 0) {
                sb2.append(q6.f7565f);
            }
            sb2.append((CharSequence) sb);
        }
        c1465a.z();
        q6.c = h1.c;
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.t()) {
            String strH = c1465a.h();
            q6.f7568i.m(strH);
            q6.f7567h.append(strH);
            return;
        }
        char cE = c1465a.e();
        if (cE == '\t' || cE == '\n' || cE == '\f' || cE == '\r' || cE == ' ') {
            if (q6.n()) {
                q6.c = h1.f7620K;
                return;
            } else {
                e(q6, c1465a);
                return;
            }
        }
        if (cE == '/') {
            if (q6.n()) {
                q6.c = h1.f7651q0;
                return;
            } else {
                e(q6, c1465a);
                return;
            }
        }
        if (cE != '>') {
            e(q6, c1465a);
        } else if (!q6.n()) {
            e(q6, c1465a);
        } else {
            q6.k();
            q6.c = h1.f7634a;
        }
    }
}
