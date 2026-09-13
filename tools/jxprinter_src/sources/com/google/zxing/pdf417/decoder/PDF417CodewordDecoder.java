package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = (float[][]) Array.newInstance((Class<?>) Float.TYPE, PDF417Common.SYMBOL_TABLE.length, 8);

    static {
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = PDF417Common.SYMBOL_TABLE;
            if (i6 >= iArr.length) {
                return;
            }
            int i7 = iArr[i6];
            int i8 = i7 & 1;
            int i9 = 0;
            while (i9 < 8) {
                float f6 = 0.0f;
                while (true) {
                    i5 = i7 & 1;
                    if (i5 == i8) {
                        f6 += 1.0f;
                        i7 >>= 1;
                    }
                }
                RATIOS_TABLE[i6][7 - i9] = f6 / 17.0f;
                i9++;
                i8 = i5;
            }
            i6++;
        }
    }

    private PDF417CodewordDecoder() {
    }

    private static int getBitValue(int[] iArr) {
        long j6 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            for (int i6 = 0; i6 < iArr[i5]; i6++) {
                int i7 = 1;
                long j7 = j6 << 1;
                if (i5 % 2 != 0) {
                    i7 = 0;
                }
                j6 = j7 | ((long) i7);
            }
        }
        return (int) j6;
    }

    private static int getClosestDecodedValue(int[] iArr) {
        int iSum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        for (int i5 = 0; i5 < 8; i5++) {
            fArr[i5] = iArr[i5] / iSum;
        }
        float f6 = Float.MAX_VALUE;
        int i6 = -1;
        int i7 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i7 >= fArr2.length) {
                return i6;
            }
            float[] fArr3 = fArr2[i7];
            float f7 = 0.0f;
            for (int i8 = 0; i8 < 8; i8++) {
                float f8 = fArr3[i8] - fArr[i8];
                f7 += f8 * f8;
                if (f7 >= f6) {
                    break;
                }
            }
            if (f7 < f6) {
                i6 = PDF417Common.SYMBOL_TABLE[i7];
                f6 = f7;
            }
            i7++;
        }
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    public static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        return decodedCodewordValue != -1 ? decodedCodewordValue : getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float fSum = MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < 17; i7++) {
            float f6 = ((i7 * fSum) / 17.0f) + (fSum / 34.0f);
            int i8 = iArr[i6];
            if (i5 + i8 <= f6) {
                i5 += i8;
                i6++;
            }
            iArr2[i6] = iArr2[i6] + 1;
        }
        return iArr2;
    }
}
