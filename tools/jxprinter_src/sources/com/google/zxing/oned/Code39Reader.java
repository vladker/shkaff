package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Code39Reader extends OneDReader {
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    private static final String CHECK_DIGIT_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, Videoio.CAP_PROP_XI_WB_KR, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[39];
    }

    public Code39Reader() {
        this(false);
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i5;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = charSequence.charAt(i6);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i6++;
                char cCharAt2 = charSequence.charAt(i6);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i5 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c = NameUtil.COLON;
                            }
                            sb.append(c);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i5 = cCharAt2 + Chars.SPACE;
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i5 = cCharAt2 - '&';
                    } else {
                        if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        }
                        i5 = cCharAt2 - 11;
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i5 = cCharAt2 - '@';
                }
                c = (char) i5;
                sb.append(c);
            } else {
                sb.append(cCharAt);
            }
            i6++;
        }
        return sb.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        boolean z6 = false;
        int i5 = 0;
        int i6 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z6) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                int i7 = length - 1;
                if (i5 != i7) {
                    i5++;
                } else {
                    if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i6 - ((nextSet - i6) / 2)), i6, false)) {
                        return new int[]{i6, nextSet};
                    }
                    i6 += iArr[0] + iArr[1];
                    int i8 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i8);
                    iArr[i8] = 0;
                    iArr[i7] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z6 = !z6;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i5) throws NotFoundException {
        int i6 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i6 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i6] == i5) {
                return ALPHABET_STRING.charAt(i6);
            }
            i6++;
        }
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i5 = 0;
        while (true) {
            int i6 = Integer.MAX_VALUE;
            for (int i7 : iArr) {
                if (i7 < i6 && i7 > i5) {
                    i6 = i7;
                }
            }
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = iArr[i11];
                if (i12 > i6) {
                    i9 |= 1 << ((length - 1) - i11);
                    i8++;
                    i10 += i12;
                }
            }
            if (i8 == 3) {
                for (int i13 = 0; i13 < length && i8 > 0; i13++) {
                    int i14 = iArr[i13];
                    if (i14 > i6) {
                        i8--;
                        if ((i14 << 1) >= i10) {
                            return -1;
                        }
                    }
                }
                return i9;
            }
            if (i8 <= 3) {
                return -1;
            }
            i5 = i6;
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException {
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        int[] iArrFindAsteriskPattern = findAsteriskPattern(bitArray, iArr);
        int nextSet = bitArray.getNextSet(iArrFindAsteriskPattern[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(narrowWidePattern);
            sb.append(cPatternToChar);
            int i6 = nextSet;
            for (int i7 : iArr) {
                i6 += i7;
            }
            int nextSet2 = bitArray.getNextSet(i6);
            if (cPatternToChar == '*') {
                sb.setLength(sb.length() - 1);
                int i8 = 0;
                for (int i9 : iArr) {
                    i8 += i9;
                }
                int i10 = (nextSet2 - nextSet) - i8;
                if (nextSet2 != size && (i10 << 1) < i8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.usingCheckDigit) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i11 = 0; i11 < length; i11++) {
                        iIndexOf += CHECK_DIGIT_STRING.indexOf(this.decodeRowResult.charAt(i11));
                    }
                    if (sb.charAt(length) != CHECK_DIGIT_STRING.charAt(iIndexOf % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f6 = i5;
                return new Result(this.extendedMode ? decodeExtended(sb) : sb.toString(), null, new ResultPoint[]{new ResultPoint((iArrFindAsteriskPattern[1] + iArrFindAsteriskPattern[0]) / 2.0f, f6), new ResultPoint((i8 / 2.0f) + nextSet, f6)}, BarcodeFormat.CODE_39);
            }
            nextSet = nextSet2;
        }
    }

    public Code39Reader(boolean z6) {
        this(z6, false);
    }

    public Code39Reader(boolean z6, boolean z7) {
        this.usingCheckDigit = z6;
        this.extendedMode = z7;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
}
