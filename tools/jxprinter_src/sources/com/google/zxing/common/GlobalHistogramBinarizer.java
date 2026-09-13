package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8];
            if (i9 > i5) {
                i7 = i8;
                i5 = i9;
            }
            if (i9 > i6) {
                i6 = i9;
            }
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = i12 - i7;
            int i14 = iArr[i12] * i13 * i13;
            if (i14 > i11) {
                i10 = i12;
                i11 = i14;
            }
        }
        if (i7 <= i10) {
            int i15 = i7;
            i7 = i10;
            i10 = i15;
        }
        if (i7 - i10 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i16 = i7 - 1;
        int i17 = -1;
        int i18 = i16;
        while (i16 > i10) {
            int i19 = i16 - i10;
            int i20 = (i6 - iArr[i16]) * (i7 - i16) * i19 * i19;
            if (i20 > i17) {
                i18 = i16;
                i17 = i20;
            }
            i16--;
        }
        return i18 << 3;
    }

    private void initArrays(int i5) {
        if (this.luminances.length < i5) {
            this.luminances = new byte[i5];
        }
        for (int i6 = 0; i6 < 32; i6++) {
            this.buckets[i6] = 0;
        }
    }

    @Override // com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i5 = 1; i5 < 5; i5++) {
            byte[] row = luminanceSource.getRow((height * i5) / 5, this.luminances);
            int i6 = (width << 2) / 5;
            for (int i7 = width / 5; i7 < i6; i7++) {
                int i8 = (row[i7] & UnsignedBytes.MAX_VALUE) >> 3;
                iArr[i8] = iArr[i8] + 1;
            }
        }
        int iEstimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i9 = 0; i9 < height; i9++) {
            int i10 = i9 * width;
            for (int i11 = 0; i11 < width; i11++) {
                if ((matrix[i10 + i11] & UnsignedBytes.MAX_VALUE) < iEstimateBlackPoint) {
                    bitMatrix.set(i11, i9);
                }
            }
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Binarizer
    public BitArray getBlackRow(int i5, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i5, this.luminances);
        int[] iArr = this.buckets;
        for (int i6 = 0; i6 < width; i6++) {
            int i7 = (row[i6] & UnsignedBytes.MAX_VALUE) >> 3;
            iArr[i7] = iArr[i7] + 1;
        }
        int iEstimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i8 = 0; i8 < width; i8++) {
                if ((row[i8] & UnsignedBytes.MAX_VALUE) < iEstimateBlackPoint) {
                    bitArray.set(i8);
                }
            }
        } else {
            int i9 = row[0] & UnsignedBytes.MAX_VALUE;
            int i10 = row[1] & UnsignedBytes.MAX_VALUE;
            int i11 = 1;
            while (i11 < width - 1) {
                int i12 = i11 + 1;
                int i13 = row[i12] & UnsignedBytes.MAX_VALUE;
                if ((((i10 << 2) - i9) - i13) / 2 < iEstimateBlackPoint) {
                    bitArray.set(i11);
                }
                i9 = i10;
                i11 = i12;
                i10 = i13;
            }
        }
        return bitArray;
    }
}
