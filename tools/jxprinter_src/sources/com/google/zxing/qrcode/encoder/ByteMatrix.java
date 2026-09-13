package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i5, int i6) {
        this.bytes = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i6, i5);
        this.width = i5;
        this.height = i6;
    }

    public void clear(byte b) {
        for (int i5 = 0; i5 < this.height; i5++) {
            for (int i6 = 0; i6 < this.width; i6++) {
                this.bytes[i5][i6] = b;
            }
        }
    }

    public byte get(int i5, int i6) {
        return this.bytes[i6][i5];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void set(int i5, int i6, byte b) {
        this.bytes[i6][i5] = b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i5 = 0; i5 < this.height; i5++) {
            for (int i6 = 0; i6 < this.width; i6++) {
                byte b = this.bytes[i5][i6];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i5, int i6, int i7) {
        this.bytes[i6][i5] = (byte) i7;
    }

    public void set(int i5, int i6, boolean z6) {
        this.bytes[i6][i5] = z6 ? (byte) 1 : (byte) 0;
    }
}
