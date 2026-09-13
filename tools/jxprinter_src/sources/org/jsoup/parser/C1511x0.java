package org.jsoup.parser;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: org.jsoup.parser.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1511x0 extends h1 {
    public C1511x0() {
        super("AttributeValue_singleQuoted", 38);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        String strF = c1465a.f(true);
        if (strF.length() > 0) {
            q6.f7568i.k(strF);
        } else {
            q6.f7568i.f7558f = true;
        }
        char cE = c1465a.e();
        if (cE == 0) {
            q6.m(this);
            q6.f7568i.j((char) 65533);
            return;
        }
        if (cE == 65535) {
            q6.l(this);
            q6.c = h1.f7634a;
            return;
        }
        if (cE != '&') {
            if (cE != '\'') {
                q6.f7568i.j(cE);
                return;
            } else {
                q6.c = h1.f7649p0;
                return;
            }
        }
        int[] iArrConsumeCharacterReference = q6.consumeCharacterReference(Character.valueOf(Chars.QUOTE), true);
        if (iArrConsumeCharacterReference != null) {
            q6.f7568i.l(iArrConsumeCharacterReference);
        } else {
            q6.f7568i.j('&');
        }
    }
}
