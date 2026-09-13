package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f6) {
            this.average = f6;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float fAbs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float fAbs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (fAbs < fAbs2) {
                return 1;
            }
            return fAbs == fAbs2 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f6) {
            this.average = f6;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float fAbs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float fAbs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    private static float centerFromEnd(int[] iArr, int i5) {
        return ((i5 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean crossCheckDiagonal(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i16 = 0;
        while (i5 >= i16 && i6 >= i16 && this.image.get(i6 - i16, i5 - i16)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i16++;
        }
        if (i5 >= i16 && i6 >= i16) {
            while (i5 >= i16 && i6 >= i16 && !this.image.get(i6 - i16, i5 - i16)) {
                int i17 = crossCheckStateCount[1];
                if (i17 > i7) {
                    break;
                }
                crossCheckStateCount[1] = i17 + 1;
                i16++;
            }
            if (i5 >= i16 && i6 >= i16 && crossCheckStateCount[1] <= i7) {
                while (i5 >= i16 && i6 >= i16 && this.image.get(i6 - i16, i5 - i16)) {
                    int i18 = crossCheckStateCount[0];
                    if (i18 > i7) {
                        break;
                    }
                    crossCheckStateCount[0] = i18 + 1;
                    i16++;
                }
                if (crossCheckStateCount[0] > i7) {
                    return false;
                }
                int height = this.image.getHeight();
                int width = this.image.getWidth();
                int i19 = 1;
                while (true) {
                    i9 = i5 + i19;
                    if (i9 >= height || (i15 = i6 + i19) >= width || !this.image.get(i15, i9)) {
                        break;
                    }
                    crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                    i19++;
                }
                if (i9 < height && i6 + i19 < width) {
                    while (true) {
                        i10 = i5 + i19;
                        if (i10 >= height || (i13 = i6 + i19) >= width || this.image.get(i13, i10) || (i14 = crossCheckStateCount[3]) >= i7) {
                            break;
                        }
                        crossCheckStateCount[3] = i14 + 1;
                        i19++;
                    }
                    if (i10 < height && i6 + i19 < width && crossCheckStateCount[3] < i7) {
                        while (true) {
                            int i20 = i5 + i19;
                            if (i20 >= height || (i11 = i6 + i19) >= width || !this.image.get(i11, i20) || (i12 = crossCheckStateCount[4]) >= i7) {
                                break;
                            }
                            crossCheckStateCount[4] = i12 + 1;
                            i19++;
                        }
                        int i21 = crossCheckStateCount[4];
                        if (i21 < i7 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i21) - i8) < i8 * 2 && foundPatternCross(crossCheckStateCount)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private float crossCheckHorizontal(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i12 = i5;
        while (i12 >= 0 && bitMatrix.get(i12, i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i12--;
        }
        if (i12 < 0) {
            return Float.NaN;
        }
        while (i12 >= 0 && !bitMatrix.get(i12, i6)) {
            int i13 = crossCheckStateCount[1];
            if (i13 > i7) {
                break;
            }
            crossCheckStateCount[1] = i13 + 1;
            i12--;
        }
        if (i12 >= 0 && crossCheckStateCount[1] <= i7) {
            while (i12 >= 0 && bitMatrix.get(i12, i6) && (i11 = crossCheckStateCount[0]) <= i7) {
                crossCheckStateCount[0] = i11 + 1;
                i12--;
            }
            if (crossCheckStateCount[0] > i7) {
                return Float.NaN;
            }
            int i14 = i5 + 1;
            while (i14 < width && bitMatrix.get(i14, i6)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i14++;
            }
            if (i14 == width) {
                return Float.NaN;
            }
            while (i14 < width && !bitMatrix.get(i14, i6) && (i10 = crossCheckStateCount[3]) < i7) {
                crossCheckStateCount[3] = i10 + 1;
                i14++;
            }
            if (i14 != width && crossCheckStateCount[3] < i7) {
                while (i14 < width && bitMatrix.get(i14, i6) && (i9 = crossCheckStateCount[4]) < i7) {
                    crossCheckStateCount[4] = i9 + 1;
                    i14++;
                }
                int i15 = crossCheckStateCount[4];
                if (i15 < i7 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i15) - i8) * 5 < i8 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i14);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckVertical(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i12 = i5;
        while (i12 >= 0 && bitMatrix.get(i6, i12)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i12--;
        }
        if (i12 < 0) {
            return Float.NaN;
        }
        while (i12 >= 0 && !bitMatrix.get(i6, i12)) {
            int i13 = crossCheckStateCount[1];
            if (i13 > i7) {
                break;
            }
            crossCheckStateCount[1] = i13 + 1;
            i12--;
        }
        if (i12 >= 0 && crossCheckStateCount[1] <= i7) {
            while (i12 >= 0 && bitMatrix.get(i6, i12) && (i11 = crossCheckStateCount[0]) <= i7) {
                crossCheckStateCount[0] = i11 + 1;
                i12--;
            }
            if (crossCheckStateCount[0] > i7) {
                return Float.NaN;
            }
            int i14 = i5 + 1;
            while (i14 < height && bitMatrix.get(i6, i14)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i14++;
            }
            if (i14 == height) {
                return Float.NaN;
            }
            while (i14 < height && !bitMatrix.get(i6, i14) && (i10 = crossCheckStateCount[3]) < i7) {
                crossCheckStateCount[3] = i10 + 1;
                i14++;
            }
            if (i14 != height && crossCheckStateCount[3] < i7) {
                while (i14 < height && bitMatrix.get(i6, i14) && (i9 = crossCheckStateCount[4]) < i7) {
                    crossCheckStateCount[4] = i9 + 1;
                    i14++;
                }
                int i15 = crossCheckStateCount[4];
                if (i15 < i7 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i15) - i8) * 5 < i8 * 2 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i14);
                }
            }
        }
        return Float.NaN;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i5 = 0;
        for (int i6 = 0; i6 < 5; i6++) {
            int i7 = iArr[i6];
            if (i7 == 0) {
                return false;
            }
            i5 += i7;
        }
        if (i5 < 7) {
            return false;
        }
        float f6 = i5 / 7.0f;
        float f7 = f6 / 2.0f;
        return Math.abs(f6 - ((float) iArr[0])) < f7 && Math.abs(f6 - ((float) iArr[1])) < f7 && Math.abs((f6 * 3.0f) - ((float) iArr[2])) < 3.0f * f7 && Math.abs(f6 - ((float) iArr[3])) < f7 && Math.abs(f6 - ((float) iArr[4])) < f7;
    }

    private int[] getCrossCheckStateCount() {
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        int i5 = 0;
        float estimatedModuleSize = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i5++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i5 < 3) {
            return false;
        }
        float f6 = estimatedModuleSize / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().getEstimatedModuleSize() - f6);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float estimatedModuleSize = 0.0f;
        if (size > 3) {
            Iterator<FinderPattern> it = this.possibleCenters.iterator();
            float f6 = 0.0f;
            float f7 = 0.0f;
            while (it.hasNext()) {
                float estimatedModuleSize2 = it.next().getEstimatedModuleSize();
                f6 += estimatedModuleSize2;
                f7 += estimatedModuleSize2 * estimatedModuleSize2;
            }
            float f8 = size;
            float f9 = f6 / f8;
            float fSqrt = (float) Math.sqrt((f7 / f8) - (f9 * f9));
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f9));
            float fMax = Math.max(0.2f * f9, fSqrt);
            int i5 = 0;
            while (i5 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(this.possibleCenters.get(i5).getEstimatedModuleSize() - f9) > fMax) {
                    this.possibleCenters.remove(i5);
                    i5--;
                }
                i5++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            Iterator<FinderPattern> it2 = this.possibleCenters.iterator();
            while (it2.hasNext()) {
                estimatedModuleSize += it2.next().getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(estimatedModuleSize / this.possibleCenters.size()));
            List<FinderPattern> list = this.possibleCenters;
            list.subList(3, list.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z6 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z7 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i5 = (height * 3) / 228;
        if (i5 < 3 || z6) {
            i5 = 3;
        }
        int[] iArr = new int[5];
        int i6 = i5 - 1;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i6 < height && !zHaveMultiplyConfirmedCenters) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i7 = 0;
            int i8 = 0;
            while (i7 < width) {
                if (this.image.get(i7, i6)) {
                    if ((i8 & 1) == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if ((i8 & 1) != 0) {
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 != 4) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i6, i7, z7)) {
                    if (this.hasSkipped) {
                        zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                    } else {
                        int iFindRowSkip = findRowSkip();
                        int i9 = iArr[2];
                        if (iFindRowSkip > i9) {
                            i6 += (iFindRowSkip - i9) - 2;
                            i7 = width - 1;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i8 = 0;
                    i5 = 2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i8 = 3;
                }
                i7++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i6, width, z7)) {
                i5 = iArr[0];
                if (this.hasSkipped) {
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                }
            }
            i6 += i5;
        }
        FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    public final boolean handlePossibleCenter(int[] iArr, int i5, int i6, boolean z6) {
        int i7 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iCenterFromEnd = (int) centerFromEnd(iArr, i6);
        float fCrossCheckVertical = crossCheckVertical(i5, iCenterFromEnd, iArr[2], i7);
        if (!Float.isNaN(fCrossCheckVertical)) {
            int i8 = (int) fCrossCheckVertical;
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, i8, iArr[2], i7);
            if (!Float.isNaN(fCrossCheckHorizontal) && (!z6 || crossCheckDiagonal(i8, (int) fCrossCheckHorizontal, iArr[2], i7))) {
                float f6 = i7 / 7.0f;
                for (int i9 = 0; i9 < this.possibleCenters.size(); i9++) {
                    FinderPattern finderPattern = this.possibleCenters.get(i9);
                    if (finderPattern.aboutEquals(f6, fCrossCheckVertical, fCrossCheckHorizontal)) {
                        this.possibleCenters.set(i9, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, f6));
                        return true;
                    }
                }
                FinderPattern finderPattern2 = new FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, f6);
                this.possibleCenters.add(finderPattern2);
                ResultPointCallback resultPointCallback = this.resultPointCallback;
                if (resultPointCallback != null) {
                    resultPointCallback.foundPossibleResultPoint(finderPattern2);
                }
                return true;
            }
        }
        return false;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }
}
