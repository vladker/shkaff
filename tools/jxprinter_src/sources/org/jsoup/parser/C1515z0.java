package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1515z0 extends h1 {
    public C1515z0() {
        super("AttributeValue_unquoted", 39);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        String strK = c1465a.k(h1.f7630R0);
        if (strK.length() > 0) {
            q6.f7568i.k(strK);
        }
        char cE = c1465a.e();
        if (cE == 0) {
            q6.m(this);
            q6.f7568i.j((char) 65533);
            return;
        }
        if (cE != ' ') {
            if (cE != '\"' && cE != '`') {
                C1470c0 c1470c0 = h1.f7634a;
                if (cE == 65535) {
                    q6.l(this);
                    q6.c = c1470c0;
                    return;
                }
                if (cE != '\t' && cE != '\n' && cE != '\f' && cE != '\r') {
                    if (cE == '&') {
                        int[] iArrConsumeCharacterReference = q6.consumeCharacterReference('>', true);
                        if (iArrConsumeCharacterReference != null) {
                            q6.f7568i.l(iArrConsumeCharacterReference);
                            return;
                        } else {
                            q6.f7568i.j('&');
                            return;
                        }
                    }
                    if (cE != '\'') {
                        switch (cE) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                q6.k();
                                q6.c = c1470c0;
                                break;
                            default:
                                q6.f7568i.j(cE);
                                break;
                        }
                        return;
                    }
                }
            }
            q6.m(this);
            q6.f7568i.j(cE);
            return;
        }
        q6.c = h1.f7620K;
    }
}
