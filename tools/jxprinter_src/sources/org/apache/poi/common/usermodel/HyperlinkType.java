package org.apache.poi.common.usermodel;

import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum HyperlinkType {
    NONE(-1),
    URL(1),
    DOCUMENT(2),
    EMAIL(3),
    FILE(4);


    @Internal(since = "3.15 beta 3")
    @Deprecated
    private final int code;

    @Internal(since = "3.15 beta 3")
    @Deprecated
    HyperlinkType(int i5) {
        this.code = i5;
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    public int getCode() {
        return this.code;
    }
}
