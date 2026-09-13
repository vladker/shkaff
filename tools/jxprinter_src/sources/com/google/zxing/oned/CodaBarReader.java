package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CodaBarReader extends OneDReader {
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] STARTEND_ENCODING = {'A', 'B', 'C', 'D'};
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private int[] counters = new int[80];
    private int counterLength = 0;

    public static boolean arrayContains(char[] cArr, char c) {
        if (cArr != null) {
            for (char c6 : cArr) {
                if (c6 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private void counterAppend(int i5) {
        int[] iArr = this.counters;
        int i6 = this.counterLength;
        iArr[i6] = i5;
        int i7 = i6 + 1;
        this.counterLength = i7;
        if (i7 >= iArr.length) {
            int[] iArr2 = new int[i7 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            this.counters = iArr2;
        }
    }

    private int findStartPattern() throws NotFoundException {
        for (int i5 = 1; i5 < this.counterLength; i5 += 2) {
            int narrowWidePattern = toNarrowWidePattern(i5);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i6 = 0;
                for (int i7 = i5; i7 < i5 + 7; i7++) {
                    i6 += this.counters[i7];
                }
                if (i5 == 1 || this.counters[i5 - 1] >= i6 / 2) {
                    return i5;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        int i5 = 0;
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z6 = true;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) ^ z6) {
                i5++;
            } else {
                counterAppend(i5);
                z6 = !z6;
                i5 = 1;
            }
            nextUnset++;
        }
        counterAppend(i5);
    }

    private int toNarrowWidePattern(int i5) {
        int i6 = i5 + 7;
        if (i6 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        int i9 = Integer.MAX_VALUE;
        int i10 = 0;
        for (int i11 = i5; i11 < i6; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i9) {
                i9 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i9 + i10) / 2;
        int i14 = 0;
        for (int i15 = i5 + 1; i15 < i6; i15 += 2) {
            int i16 = iArr[i15];
            if (i16 < i7) {
                i7 = i16;
            }
            if (i16 > i14) {
                i14 = i16;
            }
        }
        int i17 = (i7 + i14) / 2;
        int i18 = 128;
        int i19 = 0;
        for (int i20 = 0; i20 < 7; i20++) {
            i18 >>= 1;
            if (iArr[i5 + i20] > ((i20 & 1) == 0 ? i13 : i17)) {
                i19 |= i18;
            }
        }
        while (true) {
            int[] iArr2 = CHARACTER_ENCODINGS;
            if (i8 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i8] == i19) {
                return i8;
            }
            i8++;
        }
    }

    private void validatePattern(int i5) throws NotFoundException {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.decodeRowResult.length() - 1;
        int i6 = i5;
        int i7 = 0;
        while (true) {
            int i8 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i7)];
            for (int i9 = 6; i9 >= 0; i9--) {
                int i10 = (i9 & 1) + ((i8 & 1) << 1);
                iArr[i10] = iArr[i10] + this.counters[i6 + i9];
                iArr2[i10] = iArr2[i10] + 1;
                i8 >>= 1;
            }
            if (i7 >= length) {
                break;
            }
            i6 += 8;
            i7++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i11 = 0; i11 < 2; i11++) {
            fArr2[i11] = 0.0f;
            int i12 = i11 + 2;
            float f6 = iArr[i11] / iArr2[i11];
            int i13 = iArr[i12];
            int i14 = iArr2[i12];
            float f7 = ((i13 / i14) + f6) / MAX_ACCEPTABLE;
            fArr2[i12] = f7;
            fArr[i11] = f7;
            fArr[i12] = ((i13 * MAX_ACCEPTABLE) + PADDING) / i14;
        }
        int i15 = i5;
        int i16 = 0;
        loop3: while (true) {
            int i17 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i16)];
            for (int i18 = 6; i18 >= 0; i18--) {
                int i19 = (i18 & 1) + ((i17 & 1) << 1);
                float f8 = this.counters[i15 + i18];
                if (f8 < fArr2[i19] || f8 > fArr[i19]) {
                    break loop3;
                }
                i17 >>= 1;
            }
            if (i16 >= length) {
                return;
            }
            i15 += 8;
            i16++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i6;
        Arrays.fill(this.counters, 0);
        setCounters(bitArray);
        int iFindStartPattern = findStartPattern();
        this.decodeRowResult.setLength(0);
        int i7 = iFindStartPattern;
        while (true) {
            int narrowWidePattern = toNarrowWidePattern(i7);
            if (narrowWidePattern == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.decodeRowResult.append((char) narrowWidePattern);
            i6 = i7 + 8;
            if ((this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) || i6 >= this.counterLength) {
                break;
            }
            i7 = i6;
        }
        int i8 = i7 + 7;
        int i9 = this.counters[i8];
        int i10 = 0;
        for (int i11 = -8; i11 < -1; i11++) {
            i10 += this.counters[i6 + i11];
        }
        if (i6 < this.counterLength && i9 < i10 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        validatePattern(iFindStartPattern);
        for (int i12 = 0; i12 < this.decodeRowResult.length(); i12++) {
            StringBuilder sb = this.decodeRowResult;
            sb.setCharAt(i12, ALPHABET[sb.charAt(i12)]);
        }
        char cCharAt = this.decodeRowResult.charAt(0);
        char[] cArr = STARTEND_ENCODING;
        if (!arrayContains(cArr, cCharAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = this.decodeRowResult;
        if (!arrayContains(cArr, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.decodeRowResult.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.decodeRowResult;
            sb3.deleteCharAt(sb3.length() - 1);
            this.decodeRowResult.deleteCharAt(0);
        }
        int i13 = 0;
        for (int i14 = 0; i14 < iFindStartPattern; i14++) {
            i13 += this.counters[i14];
        }
        float f6 = i13;
        while (iFindStartPattern < i8) {
            i13 += this.counters[iFindStartPattern];
            iFindStartPattern++;
        }
        float f7 = i5;
        return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f6, f7), new ResultPoint(i13, f7)}, BarcodeFormat.CODABAR);
    }
}
