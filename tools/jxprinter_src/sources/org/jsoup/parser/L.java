package org.jsoup.parser;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class L extends N {
    public L() {
        this.f7560a = 3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("</");
        String str = this.tagName;
        if (str == null) {
            str = "[unset]";
        }
        return AbstractC0157z.s(sb, str, ">");
    }
}
