package org.jsoup.parser;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: org.jsoup.parser.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1509w0 extends h1 {
    public C1509w0() {
        super("AttributeValue_doubleQuoted", 37);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        String strF = c1465a.f(false);
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
        if (cE == '\"') {
            q6.c = h1.f7649p0;
            return;
        }
        if (cE != '&') {
            if (cE != 65535) {
                q6.f7568i.j(cE);
                return;
            } else {
                q6.l(this);
                q6.c = h1.f7634a;
                return;
            }
        }
        int[] iArrConsumeCharacterReference = q6.consumeCharacterReference(Character.valueOf(Chars.DQUOTE), true);
        if (iArrConsumeCharacterReference != null) {
            q6.f7568i.l(iArrConsumeCharacterReference);
        } else {
            q6.f7568i.j('&');
        }
    }
}
