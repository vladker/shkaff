package com.google.zxing.oned;

import com.google.common.base.Ascii;
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
public final class Code93Reader extends OneDReader {
    private static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private final int[] counters = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, Videoio.CAP_PROP_XI_AG_MAX_LIMIT, Videoio.CAP_PROP_XI_TRG_SOURCE, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, Videoio.CAP_PROP_XI_SHUTTER_TYPE, Videoio.CAP_PROP_XI_DECIMATION_PATTERN, Videoio.CAP_PROP_XI_BINNING_VERTICAL, 422, Videoio.CAP_PROP_XI_GPI_SELECTOR, Videoio.CAP_PROP_XI_GPO_MODE, 364, 358, 310, 314, 302, Videoio.CAP_PROP_XI_CHIP_TEMP, Videoio.CAP_PROP_XI_COOLING, 458, 366, 374, Videoio.CAP_PROP_XI_BINNING_PATTERN, 294, Videoio.CAP_PROP_XI_IMAGE_IS_COLOR, Videoio.CAP_PROP_XI_CMS, 306, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i5, int i6) throws ChecksumException {
        int iIndexOf = 0;
        int i7 = 1;
        for (int i8 = i5 - 1; i8 >= 0; i8--) {
            iIndexOf += ALPHABET_STRING.indexOf(charSequence.charAt(i8)) * i7;
            i7++;
            if (i7 > i6) {
                i7 = 1;
            }
        }
        if (charSequence.charAt(i5) != ALPHABET[iIndexOf % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i5;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = charSequence.charAt(i6);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i6 >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                i6++;
                char cCharAt2 = charSequence.charAt(i6);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i5 = cCharAt2 - '@';
                        c = (char) i5;
                        sb.append(c);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i5 = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i5 = cCharAt2 - 11;
                        } else if (cCharAt2 < 'K' || cCharAt2 > 'O') {
                            if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                                i5 = cCharAt2 + '+';
                            } else {
                                if (cCharAt2 < 'T' || cCharAt2 > 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c = Ascii.MAX;
                            }
                            sb.append(c);
                        } else {
                            i5 = cCharAt2 + 16;
                        }
                        c = (char) i5;
                        sb.append(c);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i5 = cCharAt2 - ' ';
                            c = (char) i5;
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c = NameUtil.COLON;
                        }
                        sb.append(c);
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i5 = cCharAt2 + Chars.SPACE;
                        c = (char) i5;
                        sb.append(c);
                        break;
                    default:
                        c = 0;
                        sb.append(c);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i6++;
        }
        return sb.toString();
    }

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
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
                    if (toPattern(iArr) == ASTERISK_ENCODING) {
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
                return ALPHABET[i6];
            }
            i6++;
        }
    }

    private static int toPattern(int[] iArr) {
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        int length = iArr.length;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int iRound = Math.round((iArr[i8] * 9.0f) / i5);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i8 & 1) == 0) {
                for (int i9 = 0; i9 < iRound; i9++) {
                    i7 = (i7 << 1) | 1;
                }
            } else {
                i7 <<= iRound;
            }
        }
        return i7;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException {
        int[] iArrFindAsteriskPattern = findAsteriskPattern(bitArray);
        int nextSet = bitArray.getNextSet(iArrFindAsteriskPattern[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(pattern);
            sb.append(cPatternToChar);
            int i6 = nextSet;
            for (int i7 : iArr) {
                i6 += i7;
            }
            int nextSet2 = bitArray.getNextSet(i6);
            if (cPatternToChar == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i8 = 0;
                for (int i9 : iArr) {
                    i8 += i9;
                }
                if (nextSet2 == size || !bitArray.get(nextSet2)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                checkChecksums(sb);
                sb.setLength(sb.length() - 2);
                float f6 = i5;
                return new Result(decodeExtended(sb), null, new ResultPoint[]{new ResultPoint((iArrFindAsteriskPattern[1] + iArrFindAsteriskPattern[0]) / 2.0f, f6), new ResultPoint((i8 / 2.0f) + nextSet, f6)}, BarcodeFormat.CODE_93);
            }
            nextSet = nextSet2;
        }
    }
}
