package com.google.zxing;

import A3.AbstractC0157z;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, boolean z6) {
        super(i9, i10);
        if (i7 + i9 > i5 || i8 + i10 > i6) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.yuvData = bArr;
        this.dataWidth = i5;
        this.dataHeight = i6;
        this.left = i7;
        this.top = i8;
        if (z6) {
            reverseHorizontal(i9, i10);
        }
    }

    private void reverseHorizontal(int i5, int i6) {
        byte[] bArr = this.yuvData;
        int i7 = (this.top * this.dataWidth) + this.left;
        int i8 = 0;
        while (i8 < i6) {
            int i9 = (i5 / 2) + i7;
            int i10 = (i7 + i5) - 1;
            int i11 = i7;
            while (i11 < i9) {
                byte b = bArr[i11];
                bArr[i11] = bArr[i10];
                bArr[i10] = b;
                i11++;
                i10--;
            }
            i8++;
            i7 += this.dataWidth;
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i5, int i6, int i7, int i8) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + i5, this.top + i6, i7, i8, false);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i5 = this.dataWidth;
        if (width == i5 && height == this.dataHeight) {
            return this.yuvData;
        }
        int i6 = width * height;
        byte[] bArr = new byte[i6];
        int i7 = (this.top * i5) + this.left;
        if (width == i5) {
            System.arraycopy(this.yuvData, i7, bArr, 0, i6);
            return bArr;
        }
        for (int i8 = 0; i8 < height; i8++) {
            System.arraycopy(this.yuvData, i7, bArr, i8 * width, width);
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
        System.arraycopy(this.yuvData, ((i5 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[width * height];
        byte[] bArr = this.yuvData;
        int i5 = (this.top * this.dataWidth) + this.left;
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i6 * width;
            for (int i8 = 0; i8 < width; i8++) {
                iArr[i7 + i8] = ((bArr[(i8 << 1) + i5] & UnsignedBytes.MAX_VALUE) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i5 += this.dataWidth << 1;
        }
        return iArr;
    }
}
