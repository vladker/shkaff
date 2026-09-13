package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i5, int i6, int i7, int i8) {
        char c = 2;
        boolean z6 = true;
        int i9 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i6, i5);
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 << 3;
            int i12 = i8 - 8;
            if (i11 > i12) {
                i11 = i12;
            }
            int i13 = i9;
            while (i13 < i5) {
                int i14 = i13 << 3;
                int i15 = i7 - 8;
                if (i14 > i15) {
                    i14 = i15;
                }
                int i16 = (i11 * i7) + i14;
                char c6 = c;
                int i17 = i9;
                int i18 = i17;
                int i19 = i18;
                int i20 = 255;
                while (i17 < 8) {
                    boolean z7 = z6;
                    for (int i21 = i9; i21 < 8; i21++) {
                        int i22 = bArr[i16 + i21] & 255;
                        i18 += i22;
                        if (i22 < i20) {
                            i20 = i22;
                        }
                        if (i22 > i19) {
                            i19 = i22;
                        }
                    }
                    if (i19 - i20 > 24) {
                        while (true) {
                            i17++;
                            i16 += i7;
                            if (i17 < 8) {
                                for (int i23 = 0; i23 < 8; i23++) {
                                    i18 += bArr[i16 + i23] & 255;
                                }
                            }
                        }
                    }
                    i17++;
                    i16 += i7;
                    z6 = z7;
                    i9 = 0;
                }
                boolean z8 = z6;
                int i24 = i18 >> 6;
                if (i19 - i20 <= 24) {
                    i24 = i20 / 2;
                    if (i10 > 0 && i13 > 0) {
                        int[] iArr2 = iArr[i10 - 1];
                        int i25 = i13 - 1;
                        int i26 = (((iArr[i10][i25] * 2) + iArr2[i13]) + iArr2[i25]) / 4;
                        if (i20 < i26) {
                            i24 = i26;
                        }
                    }
                }
                iArr[i10][i13] = i24;
                i13++;
                c = c6;
                z6 = z8;
                i9 = 0;
            }
            i10++;
            i9 = 0;
        }
        return iArr;
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i5, int i6, int i7, int i8, int[][] iArr, BitMatrix bitMatrix) {
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i8 - 8;
            int i12 = i10 > i11 ? i11 : i10;
            for (int i13 = 0; i13 < i5; i13++) {
                int i14 = i13 << 3;
                int i15 = i7 - 8;
                int i16 = i14 > i15 ? i15 : i14;
                int iCap = cap(i13, 2, i5 - 3);
                int iCap2 = cap(i9, 2, i6 - 3);
                int i17 = 0;
                for (int i18 = -2; i18 <= 2; i18++) {
                    int[] iArr2 = iArr[iCap2 + i18];
                    i17 += iArr2[iCap - 2] + iArr2[iCap - 1] + iArr2[iCap] + iArr2[iCap + 1] + iArr2[iCap + 2];
                }
                thresholdBlock(bArr, i16, i12, i17 / 25, i7, bitMatrix);
            }
        }
    }

    private static int cap(int i5, int i6, int i7) {
        if (i5 < i6) {
            return i6;
        }
        return i5 > i7 ? i7 : i5;
    }

    private static void thresholdBlock(byte[] bArr, int i5, int i6, int i7, int i8, BitMatrix bitMatrix) {
        int i9 = (i6 * i8) + i5;
        int i10 = 0;
        while (i10 < 8) {
            for (int i11 = 0; i11 < 8; i11++) {
                if ((bArr[i9 + i11] & 255) <= i7) {
                    bitMatrix.set(i5 + i11, i6 + i10);
                }
            }
            i10++;
            i9 += i8;
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i5 = width >> 3;
            if ((width & 7) != 0) {
                i5++;
            }
            int i6 = i5;
            int i7 = height >> 3;
            if ((height & 7) != 0) {
                i7++;
            }
            int i8 = i7;
            int[][] iArrCalculateBlackPoints = calculateBlackPoints(matrix, i6, i8, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i6, i8, width, height, iArrCalculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }
}
