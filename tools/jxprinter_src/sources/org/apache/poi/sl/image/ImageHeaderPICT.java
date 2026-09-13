package org.apache.poi.sl.image;

import com.google.common.primitives.UnsignedBytes;
import java.awt.Dimension;
import java.awt.Rectangle;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ImageHeaderPICT {
    public static final double DEFAULT_RESOLUTION = 72.0d;
    public static final int PICT_HEADER_OFFSET = 512;
    private static final byte[] V2_HEADER = {0, 17, 2, -1, 12, 0, -1, -2, 0, 0};
    private final Rectangle bounds;
    private final double hRes;
    private final double vRes;

    public ImageHeaderPICT(byte[] bArr, int i5) {
        int unsignedShort = readUnsignedShort(bArr, i5 + 2);
        int unsignedShort2 = readUnsignedShort(bArr, i5 + 4);
        int unsignedShort3 = readUnsignedShort(bArr, i5 + 6);
        int unsignedShort4 = readUnsignedShort(bArr, i5 + 8);
        int i6 = i5 + 10;
        byte[] bArr2 = V2_HEADER;
        int length = bArr2.length;
        boolean z6 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                z6 = true;
                break;
            }
            int i8 = i6 + 1;
            if (bArr2[i7] != bArr[i6]) {
                i6 = i8;
                break;
            } else {
                i7++;
                i6 = i8;
            }
        }
        if (z6) {
            this.hRes = readFixedPoint(bArr, i6);
            this.vRes = readFixedPoint(bArr, i6 + 4);
        } else {
            this.hRes = 72.0d;
            this.vRes = 72.0d;
        }
        this.bounds = new Rectangle(unsignedShort2, unsignedShort, unsignedShort4 - unsignedShort2, unsignedShort3 - unsignedShort);
    }

    private static double readFixedPoint(byte[] bArr, int i5) {
        return ((double) ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) | ((((bArr[i5] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 16)) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 8)))) / 65536.0d;
    }

    private static int readUnsignedShort(byte[] bArr, int i5) {
        return (bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) | ((bArr[i5] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public Dimension getSize() {
        return new Dimension((int) Math.round((((double) this.bounds.width) * 72.0d) / this.hRes), (int) Math.round((((double) this.bounds.height) * 72.0d) / this.vRes));
    }
}
