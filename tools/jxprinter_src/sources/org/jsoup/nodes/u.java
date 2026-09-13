package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class u extends r {
    public u(String str) {
        this.c = str;
    }

    public static boolean C(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    @Override // org.jsoup.nodes.s
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public u l() {
        return (u) super.l();
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        boolean z6 = hVar.d;
        if (z6 && this.f7484a == 0) {
            s sVar = this.parentNode;
            if ((sVar instanceof m) && ((m) sVar).c.d && !W4.b.d(z())) {
                indent(appendable, i5, hVar);
            }
        }
        p.escape(appendable, z(), hVar, false, z6 && !m.preserveWhitespace(this.parentNode), z6 && (this.parentNode instanceof i));
    }

    @Override // org.jsoup.nodes.s
    public String r() {
        return "#text";
    }

    @Override // org.jsoup.nodes.s
    public final String toString() {
        return s();
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlTail(Appendable appendable, int i5, h hVar) {
    }
}
