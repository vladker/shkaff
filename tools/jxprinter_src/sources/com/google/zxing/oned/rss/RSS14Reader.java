package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RSS14Reader extends AbstractRSSReader {
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        if (pair == null) {
            return;
        }
        for (Pair pair2 : collection) {
            if (pair2.getValue() == pair.getValue()) {
                pair2.incrementCount();
                return;
            }
        }
        collection.add(pair);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025 A[PHI: r6 r7
  0x0025: PHI (r6v7 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:23:0x0041, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
  0x0025: PHI (r7v11 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:23:0x0041, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[PHI: r6 r7
  0x002a: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x002d A[PHI: r6 r7
  0x002d: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x009c  */
    /* JADX WARN: Code duplicated, block: B:69:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00af  */
    /* JADX WARN: Code duplicated, block: B:74:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00be  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    private void adjustOddEvenCounts(boolean z6, int i5) throws NotFoundException {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int iSum = MathUtils.sum(getOddCounts());
        int iSum2 = MathUtils.sum(getEvenCounts());
        boolean z11 = true;
        if (z6) {
            if (iSum > 12) {
                z8 = true;
                z7 = false;
            } else if (iSum < 4) {
                z7 = true;
                z8 = false;
            } else {
                z7 = false;
                z8 = false;
            }
            if (iSum2 > 12) {
                z10 = true;
                z9 = false;
            } else if (iSum2 < 4) {
                z9 = true;
                z10 = false;
            } else {
                z9 = false;
                z10 = false;
            }
        } else {
            if (iSum > 11) {
                z8 = true;
                z7 = false;
            } else if (iSum < 5) {
                z7 = true;
                z8 = false;
            } else {
                z7 = false;
                z8 = false;
            }
            if (iSum2 > 10) {
                z10 = true;
                z9 = false;
            } else if (iSum2 < 4) {
                z9 = true;
                z10 = false;
            } else {
                z9 = false;
                z10 = false;
            }
        }
        int i6 = (iSum + iSum2) - i5;
        boolean z12 = (iSum & 1) == z6;
        boolean z13 = (iSum2 & 1) == 1;
        if (i6 != 1) {
            if (i6 == -1) {
                if (z12) {
                    if (z13) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    if (!z13) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z9 = true;
                }
            } else {
                if (i6 != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z12) {
                    if (!z13) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (iSum < iSum2) {
                        z10 = true;
                    } else {
                        z9 = true;
                        z8 = true;
                    }
                } else if (z13) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z11) {
                if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
            }
            if (z8) {
                AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
            }
            if (z9) {
                if (!z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
            }
            if (z10) {
                AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
            }
        }
        if (z12) {
            if (z13) {
                throw NotFoundException.getNotFoundInstance();
            }
            z8 = true;
        } else {
            if (!z13) {
                throw NotFoundException.getNotFoundInstance();
            }
            z10 = true;
        }
        z11 = z7;
        if (z11) {
            if (!z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z8) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z9) {
            if (!z10) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z10) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = ((pair2.getChecksumPortion() * 16) + pair.getChecksumPortion()) % 79;
        int value = pair2.getFinderPattern().getValue() + (pair.getFinderPattern().getValue() * 9);
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String strValueOf = String.valueOf((((long) pair.getValue()) * 4537077) + ((long) pair2.getValue()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i5 = 0;
        for (int i6 = 0; i6 < 13; i6++) {
            int iCharAt = sb.charAt(i6) - '0';
            if ((i6 & 1) == 0) {
                iCharAt *= 3;
            }
            i5 += iCharAt;
        }
        int i7 = 10 - (i5 % 10);
        if (i7 == 10) {
            i7 = 0;
        }
        sb.append(i7);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(String.valueOf(sb.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z6) throws NotFoundException {
        char c;
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        char c6 = 2;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z6) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i5 = 0;
            for (int length = dataCharacterCounters.length - 1; i5 < length; length--) {
                int i6 = dataCharacterCounters[i5];
                dataCharacterCounters[i5] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i6;
                i5++;
            }
        }
        int i7 = z6 ? 16 : 15;
        float fSum = MathUtils.sum(dataCharacterCounters) / i7;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        int i8 = 0;
        while (i8 < dataCharacterCounters.length) {
            float f6 = dataCharacterCounters[i8] / fSum;
            int i9 = (int) (0.5f + f6);
            if (i9 <= 0) {
                i9 = 1;
                c = c6;
            } else {
                c = c6;
                if (i9 > 8) {
                    i9 = 8;
                }
            }
            int i10 = i8 / 2;
            if ((i8 & 1) == 0) {
                oddCounts[i10] = i9;
                oddRoundingErrors[i10] = f6 - i9;
            } else {
                evenCounts[i10] = i9;
                evenRoundingErrors[i10] = f6 - i9;
            }
            i8++;
            c6 = c;
        }
        adjustOddEvenCounts(z6, i7);
        int i11 = 0;
        int i12 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            int i13 = oddCounts[length2];
            i11 = (i11 * 9) + i13;
            i12 += i13;
        }
        int i14 = 0;
        int i15 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            int i16 = evenCounts[length3];
            i14 = (i14 * 9) + i16;
            i15 += i16;
        }
        int i17 = (i14 * 3) + i11;
        if (!z6) {
            if ((i15 & 1) != 0 || i15 > 10 || i15 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i18 = (10 - i15) / 2;
            int i19 = INSIDE_ODD_WIDEST[i18];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i19, false) * INSIDE_ODD_TOTAL_SUBSET[i18]) + RSSUtils.getRSSvalue(oddCounts, i19, true) + INSIDE_GSUM[i18], i17);
        }
        if ((i12 & 1) != 0 || i12 > 12 || i12 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i20 = (12 - i12) / 2;
        int i21 = OUTSIDE_ODD_WIDEST[i20];
        return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i21, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i20]) + RSSUtils.getRSSvalue(evenCounts, 9 - i21, true) + OUTSIDE_GSUM[i20], i17);
    }

    private Pair decodePair(BitArray bitArray, boolean z6, int i5, Map<DecodeHintType, ?> map) {
        try {
            int[] iArrFindFinderPattern = findFinderPattern(bitArray, 0, z6);
            FinderPattern foundFinderPattern = parseFoundFinderPattern(bitArray, i5, z6, iArrFindFinderPattern);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float size = (iArrFindFinderPattern[0] + iArrFindFinderPattern[1]) / 2.0f;
                if (z6) {
                    size = (bitArray.getSize() - 1) - size;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(size, i5));
            }
            DataCharacter dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, true);
            DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, false);
            return new Pair((dataCharacterDecodeDataCharacter.getValue() * 1597) + dataCharacterDecodeDataCharacter2.getValue(), (dataCharacterDecodeDataCharacter2.getChecksumPortion() * 4) + dataCharacterDecodeDataCharacter.getChecksumPortion(), foundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] findFinderPattern(BitArray bitArray, int i5, boolean z6) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        boolean z7 = false;
        while (i5 < size) {
            z7 = !bitArray.get(i5);
            if (z6 == z7) {
                break;
            }
            i5++;
        }
        int i6 = i5;
        int i7 = 0;
        while (i5 < size) {
            if (bitArray.get(i5) ^ z7) {
                decodeFinderCounters[i7] = decodeFinderCounters[i7] + 1;
            } else {
                if (i7 != 3) {
                    i7++;
                } else {
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i6, i5};
                    }
                    i6 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i7--;
                }
                decodeFinderCounters[i7] = 1;
                z7 = !z7;
            }
            i5++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i5, boolean z6, int[] iArr) throws NotFoundException {
        int i6;
        boolean z7 = bitArray.get(iArr[0]);
        int i7 = iArr[0] - 1;
        while (i7 >= 0 && (bitArray.get(i7) ^ z7)) {
            i7--;
        }
        int i8 = i7 + 1;
        int i9 = iArr[0] - i8;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i9;
        int finderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int size = iArr[1];
        if (z6) {
            int size2 = (bitArray.getSize() - 1) - i8;
            size = (bitArray.getSize() - 1) - size;
            i6 = size2;
        } else {
            i6 = i8;
        }
        return new FinderPattern(finderValue, new int[]{i8, iArr[1]}, i6, size, i5);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i5, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i5, map));
        bitArray.reverse();
        for (Pair pair : this.possibleLeftPairs) {
            if (pair.getCount() > 1) {
                for (Pair pair2 : this.possibleRightPairs) {
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}
