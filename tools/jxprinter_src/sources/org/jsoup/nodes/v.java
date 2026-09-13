package org.jsoup.nodes;

import java.io.IOException;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends r {
    public final boolean d;

    public v(String str, boolean z6) {
        V4.h.notNull(str);
        this.c = str;
        this.d = z6;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005b  */
    private void getWholeDeclaration(Appendable appendable, h hVar) throws IOException {
        Appendable appendable2;
        h hVar2;
        c cVarH = h();
        cVarH.getClass();
        int i5 = 0;
        while (true) {
            if (i5 < cVarH.f7467a && c.l(cVarH.b[i5])) {
                i5++;
            } else {
                if (i5 >= cVarH.f7467a) {
                    return;
                }
                a aVar = new a(cVarH.b[i5], cVarH.c[i5], cVarH);
                i5++;
                String strA = aVar.a();
                String str = aVar.f7465a;
                if (str.equals("#declaration")) {
                    appendable2 = appendable;
                    hVar2 = hVar;
                } else {
                    appendable.append(Chars.SPACE);
                    appendable.append(str);
                    if (strA.isEmpty()) {
                        appendable2 = appendable;
                        hVar2 = hVar;
                    } else {
                        appendable.append("=\"");
                        appendable2 = appendable;
                        hVar2 = hVar;
                        p.escape(appendable2, strA, hVar2, true, false, false);
                        appendable2.append(Chars.DQUOTE);
                    }
                }
                appendable = appendable2;
                hVar = hVar2;
            }
        }
    }

    @Override // org.jsoup.nodes.s
    /* JADX INFO: renamed from: clone */
    public Object l() {
        return (v) super.l();
    }

    @Override // org.jsoup.nodes.s
    public final s l() {
        return (v) super.l();
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        Appendable appendableAppend = appendable.append("<");
        boolean z6 = this.d;
        appendableAppend.append(z6 ? "!" : "?").append(z());
        getWholeDeclaration(appendable, hVar);
        appendable.append(z6 ? "!" : "?").append(">");
    }

    @Override // org.jsoup.nodes.s
    public final String r() {
        return "#declaration";
    }

    @Override // org.jsoup.nodes.s
    public final String toString() {
        return s();
    }

    @Override // org.jsoup.nodes.s
    public final void outerHtmlTail(Appendable appendable, int i5, h hVar) {
    }
}
