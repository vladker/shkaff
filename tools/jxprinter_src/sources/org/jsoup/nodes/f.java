package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.parser.C;
import org.jsoup.parser.C1465a;
import org.jsoup.parser.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends r {
    public f(String str) {
        this.c = str;
    }

    @Deprecated
    public static f createFromEncoded(String str, String str2) {
        char[] cArr = p.f7482a;
        Q q6 = new Q(new C1465a(str), new C(0, 0));
        StringBuilder sbB = W4.b.b();
        while (true) {
            C1465a c1465a = q6.f7564a;
            if (c1465a.o()) {
                return new f(W4.b.g(sbB));
            }
            sbB.append(c1465a.i('&'));
            if (c1465a.r('&')) {
                c1465a.e();
                int[] iArrConsumeCharacterReference = q6.consumeCharacterReference(null, false);
                if (iArrConsumeCharacterReference == null || iArrConsumeCharacterReference.length == 0) {
                    sbB.append('&');
                } else {
                    sbB.appendCodePoint(iArrConsumeCharacterReference[0]);
                    if (iArrConsumeCharacterReference.length == 2) {
                        sbB.appendCodePoint(iArrConsumeCharacterReference[1]);
                    }
                }
            }
        }
    }

    @Override // org.jsoup.nodes.s
    /* JADX INFO: renamed from: clone */
    public Object l() {
        return (f) super.l();
    }

    @Override // org.jsoup.nodes.s
    public final s l() {
        return (f) super.l();
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        appendable.append(z());
    }

    @Override // org.jsoup.nodes.s
    public final String r() {
        return "#data";
    }

    @Override // org.jsoup.nodes.s
    public final String toString() {
        return s();
    }

    @Override // org.jsoup.nodes.s
    public final void outerHtmlTail(Appendable appendable, int i5, h hVar) {
    }
}
