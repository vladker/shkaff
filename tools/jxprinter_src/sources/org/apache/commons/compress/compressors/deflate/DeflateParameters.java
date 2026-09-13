package org.apache.commons.compress.compressors.deflate;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DeflateParameters {
    private boolean zlibHeader = true;
    private int compressionLevel = -1;

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i5) {
        if (i5 < -1 || i5 > 9) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid Deflate compression level: "));
        }
        this.compressionLevel = i5;
    }

    public void setWithZlibHeader(boolean z6) {
        this.zlibHeader = z6;
    }

    public boolean withZlibHeader() {
        return this.zlibHeader;
    }
}
