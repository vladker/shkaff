package com.google.zxing.oned.rss.expanded;

import A3.AbstractC0157z;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX WARN: Code duplicated, block: B:53:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0082  */
    /* JADX WARN: Code duplicated, block: B:55:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0095  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    private void adjustOddEvenCounts(int i5) throws NotFoundException {
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int iSum = MathUtils.sum(getOddCounts());
        int iSum2 = MathUtils.sum(getEvenCounts());
        boolean z10 = true;
        if (iSum > 13) {
            z7 = true;
            z6 = false;
        } else if (iSum < 4) {
            z6 = true;
            z7 = false;
        } else {
            z6 = false;
            z7 = false;
        }
        if (iSum2 > 13) {
            z9 = true;
            z8 = false;
        } else if (iSum2 < 4) {
            z8 = true;
            z9 = false;
        } else {
            z8 = false;
            z9 = false;
        }
        int i6 = (iSum + iSum2) - i5;
        boolean z11 = (iSum & 1) == 1;
        boolean z12 = (iSum2 & 1) == 0;
        if (i6 != 1) {
            if (i6 == -1) {
                if (z11) {
                    if (z12) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    if (!z12) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z8 = true;
                }
            } else {
                if (i6 != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z11) {
                    if (!z12) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (iSum < iSum2) {
                        z9 = true;
                    } else {
                        z8 = true;
                        z7 = true;
                    }
                } else if (z12) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z10) {
                if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
            }
            if (z7) {
                AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
            }
            if (z8) {
                if (!z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
            }
            if (z9) {
                AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
            }
        }
        if (z11) {
            if (z12) {
                throw NotFoundException.getNotFoundInstance();
            }
            z7 = true;
        } else {
            if (!z12) {
                throw NotFoundException.getNotFoundInstance();
            }
            z9 = true;
        }
        z10 = z6;
        if (z10) {
            if (!z7) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z7) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z8) {
            if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z9) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i5 = 2;
        for (int i6 = 1; i6 < this.pairs.size(); i6++) {
            ExpandedPair expandedPair2 = this.pairs.get(i6);
            int checksumPortion2 = expandedPair2.getLeftChar().getChecksumPortion() + checksumPortion;
            int i7 = i5 + 1;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion = rightChar2.getChecksumPortion() + checksumPortion2;
                i5 += 2;
            } else {
                i5 = i7;
                checksumPortion = checksumPortion2;
            }
        }
        return ((i5 + (-4)) * 211) + (checksumPortion % 211) == leftChar.getValue();
    }

    private List<ExpandedPair> checkRows(boolean z6) {
        List<ExpandedPair> listCheckRows = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z6) {
            Collections.reverse(this.rows);
        }
        try {
            listCheckRows = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z6) {
            Collections.reverse(this.rows);
        }
        return listCheckRows;
    }

    public static Result constructResult(List<ExpandedPair> list) {
        String information = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = ((ExpandedPair) AbstractC0157z.f(1, list)).getFinderPattern().getResultPoints();
        return new Result(information, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i5) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i5 < 0) {
            i5 = list.isEmpty() ? 0 : ((ExpandedPair) AbstractC0157z.f(1, list)).getFinderPattern().getStartEnd()[1];
        }
        boolean z6 = list.size() % 2 != 0;
        if (this.startFromEven) {
            z6 = !z6;
        }
        boolean z7 = false;
        while (i5 < size) {
            boolean z8 = bitArray.get(i5);
            boolean z9 = !z8;
            if (z8) {
                z7 = z9;
                break;
            } else {
                i5++;
                z7 = z9;
            }
        }
        int i6 = 0;
        boolean z10 = z7;
        int i7 = i5;
        while (i5 < size) {
            if (bitArray.get(i5) ^ z10) {
                decodeFinderCounters[i6] = decodeFinderCounters[i6] + 1;
            } else {
                if (i6 == 3) {
                    if (z6) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i7;
                        iArr[1] = i5;
                        return;
                    }
                    if (z6) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i7 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i6--;
                } else {
                    i6++;
                }
                decodeFinderCounters[i6] = 1;
                z10 = !z10;
            }
            i5++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i5) {
        return bitArray.get(i5) ? bitArray.getNextSet(bitArray.getNextUnset(i5)) : bitArray.getNextUnset(bitArray.getNextSet(i5));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z6, boolean z7) {
        return (finderPattern.getValue() == 0 && z6 && z7) ? false : true;
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        for (ExpandedRow expandedRow : iterable2) {
            for (ExpandedPair expandedPair : iterable) {
                Iterator<ExpandedPair> it = expandedRow.getPairs().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (expandedPair.equals(it.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    if (list.get(i5).getFinderPattern().getValue() == iArr[i5]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i5, boolean z6) {
        int nextUnset;
        int i6;
        int i7;
        if (z6) {
            int i8 = this.startEnd[0] - 1;
            while (i8 >= 0 && !bitArray.get(i8)) {
                i8--;
            }
            int i9 = i8 + 1;
            int[] iArr = this.startEnd;
            i7 = iArr[0] - i9;
            nextUnset = iArr[1];
            i6 = i9;
        } else {
            int[] iArr2 = this.startEnd;
            int i10 = iArr2[0];
            nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i6 = i10;
            i7 = nextUnset - this.startEnd[1];
        }
        int i11 = nextUnset;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i7;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i6, i11}, i6, i11, i5);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        Iterator<ExpandedRow> it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow next = it.next();
            if (next.getPairs().size() != list.size()) {
                Iterator<ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                    ExpandedPair next2 = it2.next();
                    Iterator<ExpandedPair> it3 = list.iterator();
                    do {
                        if (!it3.hasNext()) {
                            break;
                        }
                    } while (!next2.equals(it3.next()));
                }
            }
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i5 = 0; i5 < length / 2; i5++) {
            int i6 = iArr[i5];
            int i7 = (length - i5) - 1;
            iArr[i5] = iArr[i7];
            iArr[i7] = i6;
        }
    }

    private void storeRow(int i5, boolean z6) {
        boolean zIsEquivalent = false;
        int i6 = 0;
        boolean zIsEquivalent2 = false;
        while (i6 < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i6);
            if (expandedRow.getRowNumber() > i5) {
                zIsEquivalent = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                zIsEquivalent2 = expandedRow.isEquivalent(this.pairs);
                i6++;
            }
        }
        if (zIsEquivalent || zIsEquivalent2 || isPartialRow(this.pairs, this.rows)) {
            return;
        }
        this.rows.add(i6, new ExpandedRow(this.pairs, i5, z6));
        removePartialRows(this.pairs, this.rows);
    }

    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z6, boolean z7) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z7) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i5 = 0;
            for (int length = dataCharacterCounters.length - 1; i5 < length; length--) {
                int i6 = dataCharacterCounters[i5];
                dataCharacterCounters[i5] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i6;
                i5++;
            }
        }
        float fSum = MathUtils.sum(dataCharacterCounters) / 17.0f;
        float f6 = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (Math.abs(fSum - f6) / f6 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i7 = 0; i7 < dataCharacterCounters.length; i7++) {
            float f7 = (dataCharacterCounters[i7] * 1.0f) / fSum;
            int i8 = (int) (0.5f + f7);
            if (i8 <= 0) {
                if (f7 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i8 = 1;
            } else if (i8 > 8) {
                if (f7 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i8 = 8;
            }
            int i9 = i7 / 2;
            if ((i7 & 1) == 0) {
                oddCounts[i9] = i8;
                oddRoundingErrors[i9] = f7 - i8;
            } else {
                evenCounts[i9] = i8;
                evenRoundingErrors[i9] = f7 - i8;
            }
        }
        adjustOddEvenCounts(17);
        int value = (((finderPattern.getValue() * 4) + (z6 ? 0 : 2)) + (!z7 ? 1 : 0)) - 1;
        int i10 = 0;
        int i11 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            if (isNotA1left(finderPattern, z6, z7)) {
                i10 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
            }
            i11 += oddCounts[length2];
        }
        int i12 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z6, z7)) {
                i12 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
            }
        }
        int i13 = i10 + i12;
        if ((i11 & 1) != 0 || i11 > 13 || i11 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = (13 - i11) / 2;
        int i15 = SYMBOL_WIDEST[i14];
        return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i15, true) * EVEN_TOTAL_SUBSET[i14]) + RSSUtils.getRSSvalue(evenCounts, 9 - i15, false) + GSUM[i14], i13);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map) {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i5, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i5, bitArray));
        }
    }

    public List<ExpandedPair> decodeRow2pairs(int i5, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i5));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                }
                if (checkChecksum()) {
                    return this.pairs;
                }
                boolean zIsEmpty = this.rows.isEmpty();
                storeRow(i5, false);
                if (!zIsEmpty) {
                    List<ExpandedPair> listCheckRows = checkRows(false);
                    if (listCheckRows != null) {
                        return listCheckRows;
                    }
                    List<ExpandedPair> listCheckRows2 = checkRows(true);
                    if (listCheckRows2 != null) {
                        return listCheckRows2;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i5) throws NotFoundException {
        FinderPattern foundFinderPattern;
        DataCharacter dataCharacterDecodeDataCharacter;
        boolean z6 = list.size() % 2 == 0;
        if (this.startFromEven) {
            z6 = !z6;
        }
        int nextSecondBar = -1;
        boolean z7 = true;
        do {
            findNextPair(bitArray, list, nextSecondBar);
            foundFinderPattern = parseFoundFinderPattern(bitArray, i5, z6);
            if (foundFinderPattern == null) {
                nextSecondBar = getNextSecondBar(bitArray, this.startEnd[0]);
            } else {
                z7 = false;
            }
        } while (z7);
        DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, z6, true);
        if (!list.isEmpty() && ((ExpandedPair) AbstractC0157z.f(1, list)).mustBeLast()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, z6, false);
        } catch (NotFoundException unused) {
            dataCharacterDecodeDataCharacter = null;
        }
        return new ExpandedPair(dataCharacterDecodeDataCharacter2, dataCharacterDecodeDataCharacter, foundFinderPattern, true);
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i5) throws NotFoundException {
        while (i5 < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i5);
            this.pairs.clear();
            Iterator<ExpandedRow> it = list.iterator();
            while (it.hasNext()) {
                this.pairs.addAll(it.next().getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i5 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i5++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
