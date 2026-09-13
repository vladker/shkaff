package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            resultPointArr[iArr[i5]] = resultPointArr2[i5];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z6) {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> listDetect = detect(z6, blackMatrix);
        if (listDetect.isEmpty()) {
            blackMatrix = blackMatrix.m1021clone();
            blackMatrix.rotate180();
            listDetect = detect(z6, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, listDetect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i5, int i6, int i7, boolean z6, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i8 = 0;
        while (bitMatrix.get(i5, i6) && i5 > 0) {
            int i9 = i8 + 1;
            if (i8 >= 3) {
                break;
            }
            i5--;
            i8 = i9;
        }
        int length = iArr.length;
        boolean z7 = z6;
        int i10 = 0;
        int i11 = i5;
        while (i5 < i7) {
            if (bitMatrix.get(i5, i6) ^ z7) {
                iArr2[i10] = iArr2[i10] + 1;
            } else {
                int i12 = length - 1;
                if (i10 != i12) {
                    i10++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i11, i5};
                    }
                    i11 += iArr2[0] + iArr2[1];
                    int i13 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i12] = 0;
                    i10--;
                }
                iArr2[i10] = 1;
                z7 = !z7;
            }
            i5++;
        }
        if (i10 != length - 1 || patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i11, i5 - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i5, int i6, int i7, int i8, int[] iArr) {
        int i9;
        int i10;
        boolean z6;
        int[] iArr2;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr3 = iArr;
        int[] iArr4 = new int[iArr3.length];
        int i11 = i7;
        while (true) {
            if (i11 >= i5) {
                i10 = i11;
                z6 = false;
                break;
            }
            int[] iArrFindGuardPattern = findGuardPattern(bitMatrix, i8, i11, i6, false, iArr3, iArr4);
            if (iArrFindGuardPattern != null) {
                do {
                    i10 = i11;
                    iArr2 = iArrFindGuardPattern;
                    if (i10 <= 0) {
                        break;
                    }
                    i11 = i10 - 1;
                    iArrFindGuardPattern = findGuardPattern(bitMatrix, i8, i11, i6, false, iArr, iArr4);
                } while (iArrFindGuardPattern != null);
                float f6 = i10;
                resultPointArr[0] = new ResultPoint(iArr2[0], f6);
                resultPointArr[1] = new ResultPoint(iArr2[1], f6);
                z6 = true;
                break;
            }
            i11 += 5;
            iArr3 = iArr;
        }
        int i12 = i10 + 1;
        if (z6) {
            int[] iArr5 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i13 = i12;
            int i14 = 0;
            while (i13 < i5) {
                int[] iArrFindGuardPattern2 = findGuardPattern(bitMatrix, iArr5[0], i13, i6, false, iArr, iArr4);
                if (iArrFindGuardPattern2 != null && Math.abs(iArr5[0] - iArrFindGuardPattern2[0]) < 5 && Math.abs(iArr5[1] - iArrFindGuardPattern2[1]) < 5) {
                    iArr5 = iArrFindGuardPattern2;
                    i14 = 0;
                } else {
                    if (i14 > 25) {
                        break;
                    }
                    i14++;
                }
                i13++;
            }
            i12 = i13 - (i14 + 1);
            float f7 = i12;
            resultPointArr[2] = new ResultPoint(iArr5[0], f7);
            resultPointArr[3] = new ResultPoint(iArr5[1], f7);
        }
        if (i12 - i10 < 10) {
            for (i9 = 0; i9 < 4; i9++) {
                resultPointArr[i9] = null;
            }
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i5, int i6) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        int y6 = i5;
        int i7 = i6;
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, y6, i7, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint resultPoint = resultPointArr[4];
        if (resultPoint != null) {
            int x6 = (int) resultPoint.getX();
            y6 = (int) resultPointArr[4].getY();
            i7 = x6;
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, y6, i7, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f6) {
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            i5 += iArr[i7];
            i6 += iArr2[i7];
        }
        if (i5 < i6) {
            return Float.POSITIVE_INFINITY;
        }
        float f7 = i5;
        float f8 = f7 / i6;
        float f9 = f6 * f8;
        float f10 = 0.0f;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8];
            float f11 = iArr2[i8] * f8;
            float f12 = i9;
            float f13 = f12 > f11 ? f12 - f11 : f11 - f12;
            if (f13 > f9) {
                return Float.POSITIVE_INFINITY;
            }
            f10 += f13;
        }
        return f10 / f7;
    }

    private static List<ResultPoint[]> detect(boolean z6, BitMatrix bitMatrix) {
        int x6;
        float y6;
        ArrayList arrayList = new ArrayList();
        int iMax = 0;
        int i5 = 0;
        loop0: while (true) {
            int i6 = i5;
            while (iMax < bitMatrix.getHeight()) {
                ResultPoint[] resultPointArrFindVertices = findVertices(bitMatrix, iMax, i5);
                if (resultPointArrFindVertices[0] != null || resultPointArrFindVertices[3] != null) {
                    arrayList.add(resultPointArrFindVertices);
                    if (!z6) {
                        break loop0;
                    }
                    ResultPoint resultPoint = resultPointArrFindVertices[2];
                    if (resultPoint != null) {
                        x6 = (int) resultPoint.getX();
                        y6 = resultPointArrFindVertices[2].getY();
                    } else {
                        x6 = (int) resultPointArrFindVertices[4].getX();
                        y6 = resultPointArrFindVertices[4].getY();
                    }
                    iMax = (int) y6;
                    i5 = x6;
                    i6 = 1;
                } else {
                    if (i6 == 0) {
                        break;
                    }
                    int size = arrayList.size();
                    int i7 = 0;
                    while (i7 < size) {
                        Object obj = arrayList.get(i7);
                        i7++;
                        ResultPoint[] resultPointArr = (ResultPoint[]) obj;
                        ResultPoint resultPoint2 = resultPointArr[1];
                        if (resultPoint2 != null) {
                            iMax = (int) Math.max(iMax, resultPoint2.getY());
                        }
                        ResultPoint resultPoint3 = resultPointArr[3];
                        if (resultPoint3 != null) {
                            iMax = Math.max(iMax, (int) resultPoint3.getY());
                        }
                    }
                    iMax += 5;
                    i5 = 0;
                }
            }
            break loop0;
        }
        return arrayList;
    }
}
