package org.apache.poi.wp.usermodel;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum HeaderFooterType {
    DEFAULT(2),
    EVEN(1),
    FIRST(3);

    private final int code;

    HeaderFooterType(int i5) {
        this.code = i5;
    }

    public static HeaderFooterType forInt(int i5) {
        for (HeaderFooterType headerFooterType : values()) {
            if (headerFooterType.code == i5) {
                return headerFooterType;
            }
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid HeaderFooterType code: "));
    }

    public int toInt() {
        return this.code;
    }
}
