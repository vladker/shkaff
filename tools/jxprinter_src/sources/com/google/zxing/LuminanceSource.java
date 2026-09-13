package com.google.zxing;

import com.google.common.primitives.UnsignedBytes;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public LuminanceSource(int i5, int i6) {
        this.width = i5;
        this.height = i6;
    }

    public LuminanceSource crop(int i5, int i6, int i7, int i8) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i5, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        char c;
        int i5 = this.width;
        byte[] row = new byte[i5];
        StringBuilder sb = new StringBuilder((i5 + 1) * this.height);
        for (int i6 = 0; i6 < this.height; i6++) {
            row = getRow(i6, row);
            for (int i7 = 0; i7 < this.width; i7++) {
                int i8 = row[i7] & UnsignedBytes.MAX_VALUE;
                if (i8 < 64) {
                    c = '#';
                } else if (i8 < 128) {
                    c = '+';
                } else {
                    c = i8 < 192 ? '.' : Chars.SPACE;
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
