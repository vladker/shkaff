package org.apache.poi.ss.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PageMargin {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3),
    HEADER(4),
    FOOTER(5);

    private static final Map<Short, PageMargin> PAGE_MARGIN_BY_LEGACY_API_VALUE = new HashMap();
    private final short legacyApiValue;

    static {
        for (PageMargin pageMargin : values()) {
            PAGE_MARGIN_BY_LEGACY_API_VALUE.put(Short.valueOf(pageMargin.legacyApiValue), pageMargin);
        }
    }

    PageMargin(short s6) {
        this.legacyApiValue = s6;
    }

    public static PageMargin getByShortValue(short s6) {
        return PAGE_MARGIN_BY_LEGACY_API_VALUE.get(Short.valueOf(s6));
    }

    public short getLegacyApiValue() {
        return this.legacyApiValue;
    }
}
