package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ITFReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.78f;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int f3518N = 1;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private static final int f3519W = 3;
    private int narrowLineWidth = -1;
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 8, 10, 12, 14};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN_REVERSED = {1, 1, 3};
    static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    private static int decodeDigit(int[] iArr) throws NotFoundException {
        int length = PATTERNS.length;
        float f6 = 0.38f;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i6], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f6) {
                i5 = i6;
                f6 = fPatternMatchVariance;
            }
        }
        if (i5 >= 0) {
            return i5;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] decodeEnd(BitArray bitArray) {
        bitArray.reverse();
        try {
            int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), END_PATTERN_REVERSED);
            validateQuietZone(bitArray, iArrFindGuardPattern[0]);
            int i5 = iArrFindGuardPattern[0];
            iArrFindGuardPattern[0] = bitArray.getSize() - iArrFindGuardPattern[1];
            iArrFindGuardPattern[1] = bitArray.getSize() - i5;
            return iArrFindGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    private static void decodeMiddle(BitArray bitArray, int i5, int i6, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i5 < i6) {
            OneDReader.recordPattern(bitArray, i5, iArr);
            for (int i7 = 0; i7 < 5; i7++) {
                int i8 = i7 * 2;
                iArr2[i7] = iArr[i8];
                iArr3[i7] = iArr[i8 + 1];
            }
            sb.append((char) (decodeDigit(iArr2) + 48));
            sb.append((char) (decodeDigit(iArr3) + 48));
            for (int i9 = 0; i9 < 10; i9++) {
                i5 += iArr[i9];
            }
        }
    }

    private int[] decodeStart(BitArray bitArray) throws NotFoundException {
        int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        int i5 = iArrFindGuardPattern[1];
        int i6 = iArrFindGuardPattern[0];
        this.narrowLineWidth = (i5 - i6) / 4;
        validateQuietZone(bitArray, i6);
        return iArrFindGuardPattern;
    }

    private static int[] findGuardPattern(BitArray bitArray, int i5, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i6 = i5;
        boolean z6 = false;
        int i7 = 0;
        while (i5 < size) {
            if (bitArray.get(i5) ^ z6) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                int i8 = length - 1;
                if (i7 != i8) {
                    i7++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < 0.38f) {
                        return new int[]{i6, i5};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z6 = !z6;
            }
            i5++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void validateQuietZone(BitArray bitArray, int i5) throws NotFoundException {
        int i6 = this.narrowLineWidth * 10;
        if (i6 >= i5) {
            i6 = i5;
        }
        for (int i7 = i5 - 1; i6 > 0 && i7 >= 0 && !bitArray.get(i7); i7--) {
            i6--;
        }
        if (i6 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        boolean z6;
        int[] iArrDecodeStart = decodeStart(bitArray);
        int[] iArrDecodeEnd = decodeEnd(bitArray);
        StringBuilder sb = new StringBuilder(20);
        decodeMiddle(bitArray, iArrDecodeStart[1], iArrDecodeEnd[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= length2) {
                z6 = false;
                break;
            }
            int i8 = iArr[i6];
            if (length == i8) {
                z6 = true;
                break;
            }
            if (i8 > i7) {
                i7 = i8;
            }
            i6++;
        }
        if (!z6 && length > i7) {
            z6 = true;
        }
        if (!z6) {
            throw FormatException.getFormatInstance();
        }
        float f6 = i5;
        return new Result(string, null, new ResultPoint[]{new ResultPoint(iArrDecodeStart[1], f6), new ResultPoint(iArrDecodeEnd[0], f6)}, BarcodeFormat.ITF);
    }
}
