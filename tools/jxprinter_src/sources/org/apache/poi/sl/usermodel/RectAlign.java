package org.apache.poi.sl.usermodel;

import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum RectAlign {
    TOP_LEFT("tl"),
    TOP("t"),
    TOP_RIGHT("tr"),
    LEFT("l"),
    CENTER("ctr"),
    RIGHT("r"),
    BOTTOM_LEFT("bl"),
    BOTTOM("b"),
    BOTTOM_RIGHT(CompressorStreamFactory.BROTLI);

    private final String dir;

    RectAlign(String str) {
        this.dir = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.dir;
    }
}
