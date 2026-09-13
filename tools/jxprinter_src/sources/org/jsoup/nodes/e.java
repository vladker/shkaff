package org.jsoup.nodes;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.StringReader;
import org.jsoup.parser.D;
import org.jsoup.parser.E;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends r {
    public e(String str) {
        this.c = str;
    }

    public v asXmlDeclaration() {
        String strZ = z();
        String strG = androidx.collection.a.g(1, 1, strZ);
        if (strG.length() > 1 && (strG.startsWith("!") || strG.startsWith("?"))) {
            return null;
        }
        String strO = AbstractC0157z.o("<", strG, ">");
        E eA = E.a();
        eA.c = D.d;
        i iVar = eA.f7544a.parse(new StringReader(strO), i(), eA);
        if (iVar.T().D().size() <= 0) {
            return null;
        }
        m mVar = (m) iVar.T().C().get(0);
        v vVar = new v(AbstractC1282k.e(iVar).c.b(mVar.c.f7552a), strZ.startsWith("!"));
        vVar.h().a(mVar.h());
        return vVar;
    }

    @Override // org.jsoup.nodes.s
    /* JADX INFO: renamed from: clone */
    public Object l() {
        return (e) super.l();
    }

    @Override // org.jsoup.nodes.s
    public final s l() {
        return (e) super.l();
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        if (hVar.d && this.f7484a == 0) {
            s sVar = this.parentNode;
            if ((sVar instanceof m) && ((m) sVar).c.d) {
                indent(appendable, i5, hVar);
            }
        }
        appendable.append("<!--").append(z()).append("-->");
    }

    @Override // org.jsoup.nodes.s
    public final String r() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.s
    public final String toString() {
        return s();
    }

    @Override // org.jsoup.nodes.s
    public final void outerHtmlTail(Appendable appendable, int i5, h hVar) {
    }
}
