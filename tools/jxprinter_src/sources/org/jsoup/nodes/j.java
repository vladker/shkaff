package org.jsoup.nodes;

import java.io.IOException;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends r {
    public j(String str, String str2, String str3) {
        V4.h.notNull(str);
        V4.h.notNull(str2);
        V4.h.notNull(str3);
        g("name", str);
        g("publicId", str2);
        g("systemId", str3);
        if (B("publicId")) {
            g("pubSysKey", "PUBLIC");
        } else if (B("systemId")) {
            g("pubSysKey", "SYSTEM");
        }
    }

    public final boolean B(String str) {
        return !W4.b.d(f(str));
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        if (hVar.f7470f != g.f7468a || B("publicId") || B("systemId")) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (B("name")) {
            appendable.append(" ").append(f("name"));
        }
        if (B("pubSysKey")) {
            appendable.append(" ").append(f("pubSysKey"));
        }
        if (B("publicId")) {
            appendable.append(" \"").append(f("publicId")).append(Chars.DQUOTE);
        }
        if (B("systemId")) {
            appendable.append(" \"").append(f("systemId")).append(Chars.DQUOTE);
        }
        appendable.append('>');
    }

    @Override // org.jsoup.nodes.s
    public final String r() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.s
    public final void outerHtmlTail(Appendable appendable, int i5, h hVar) {
    }
}
