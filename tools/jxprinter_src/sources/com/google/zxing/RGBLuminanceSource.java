package com.google.zxing;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    public RGBLuminanceSource(int i5, int i6, int[] iArr) {
        super(i5, i6);
        this.dataWidth = i5;
        this.dataHeight = i6;
        this.left = 0;
        this.top = 0;
        int i7 = i5 * i6;
        this.luminances = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = iArr[i8];
            this.luminances[i8] = (byte) (((((i9 >> 16) & 255) + ((i9 >> 7) & 510)) + (i9 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i5, int i6, int i7, int i8) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i5, this.top + i6, i7, i8);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i5 = this.dataWidth;
        if (width == i5 && height == this.dataHeight) {
            return this.luminances;
        }
        int i6 = width * height;
        byte[] bArr = new byte[i6];
        int i7 = (this.top * i5) + this.left;
        if (width == i5) {
            System.arraycopy(this.luminances, i7, bArr, 0, i6);
            return bArr;
        }
        for (int i8 = 0; i8 < height; i8++) {
            System.arraycopy(this.luminances, i7, bArr, i8 * width, width);
            i7 += this.dataWidth;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i5, byte[] bArr) {
        if (i5 < 0 || i5 >= getHeight()) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Requested row is outside the image: "));
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, ((i5 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    private RGBLuminanceSource(byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10) {
        super(i9, i10);
        if (i9 + i7 <= i5 && i10 + i8 <= i6) {
            this.luminances = bArr;
            this.dataWidth = i5;
            this.dataHeight = i6;
            this.left = i7;
            this.top = i8;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
