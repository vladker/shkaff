package org.apache.poi.sl.image;

import java.util.Arrays;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageHeaderPNG {
    private static final int MAGIC_OFFSET = 16;
    private final byte[] data;

    public ImageHeaderPNG(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] extractPNG() {
        byte[] bArr = this.data;
        if (bArr.length >= 16) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 16, bArr.length);
            if (FileMagic.valueOf(bArrCopyOfRange) == FileMagic.PNG) {
                return bArrCopyOfRange;
            }
        }
        return this.data;
    }
}
