package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends u {
    @Override // org.jsoup.nodes.u
    /* JADX INFO: renamed from: B */
    public final u l() {
        return (d) super.l();
    }

    @Override // org.jsoup.nodes.u, org.jsoup.nodes.s
    /* JADX INFO: renamed from: clone */
    public Object l() {
        return (d) super.l();
    }

    @Override // org.jsoup.nodes.u, org.jsoup.nodes.s
    public final s l() {
        return (d) super.l();
    }

    @Override // org.jsoup.nodes.u, org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        appendable.append("<![CDATA[").append(z());
    }

    @Override // org.jsoup.nodes.u, org.jsoup.nodes.s
    public final void outerHtmlTail(Appendable appendable, int i5, h hVar) {
        try {
            appendable.append("]]>");
        } catch (IOException e) {
            throw new U4.j(e);
        }
    }

    @Override // org.jsoup.nodes.u, org.jsoup.nodes.s
    public final String r() {
        return "#cdata";
    }
}
