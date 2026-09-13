package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class AlignmentPatternFinder {
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final int[] crossCheckStateCount = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i5, int i6, int i7, int i8, float f6, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i5;
        this.startY = i6;
        this.width = i7;
        this.height = i8;
        this.moduleSize = f6;
        this.resultPointCallback = resultPointCallback;
    }

    private static float centerFromEnd(int[] iArr, int i5) {
        return (i5 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float crossCheckVertical(int i5, int i6, int i7, int i8) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i9 = i5;
        while (i9 >= 0 && bitMatrix.get(i6, i9)) {
            int i10 = iArr[1];
            if (i10 > i7) {
                break;
            }
            iArr[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && iArr[1] <= i7) {
            while (i9 >= 0 && !bitMatrix.get(i6, i9)) {
                int i11 = iArr[0];
                if (i11 > i7) {
                    break;
                }
                iArr[0] = i11 + 1;
                i9--;
            }
            if (iArr[0] > i7) {
                return Float.NaN;
            }
            int i12 = i5 + 1;
            while (i12 < height && bitMatrix.get(i6, i12)) {
                int i13 = iArr[1];
                if (i13 > i7) {
                    break;
                }
                iArr[1] = i13 + 1;
                i12++;
            }
            if (i12 != height && iArr[1] <= i7) {
                while (i12 < height && !bitMatrix.get(i6, i12)) {
                    int i14 = iArr[2];
                    if (i14 > i7) {
                        break;
                    }
                    iArr[2] = i14 + 1;
                    i12++;
                }
                int i15 = iArr[2];
                if (i15 <= i7 && Math.abs(((iArr[0] + iArr[1]) + i15) - i8) * 5 < i8 * 2 && foundPatternCross(iArr)) {
                    return centerFromEnd(iArr, i12);
                }
            }
        }
        return Float.NaN;
    }

    private boolean foundPatternCross(int[] iArr) {
        float f6 = this.moduleSize;
        float f7 = f6 / 2.0f;
        for (int i5 = 0; i5 < 3; i5++) {
            if (Math.abs(f6 - iArr[i5]) >= f7) {
                return false;
            }
        }
        return true;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i5, int i6) {
        int i7 = iArr[0] + iArr[1] + iArr[2];
        float fCenterFromEnd = centerFromEnd(iArr, i6);
        float fCrossCheckVertical = crossCheckVertical(i5, (int) fCenterFromEnd, iArr[1] * 2, i7);
        if (Float.isNaN(fCrossCheckVertical)) {
            return null;
        }
        float f6 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.possibleCenters) {
            if (alignmentPattern.aboutEquals(f6, fCrossCheckVertical, fCenterFromEnd)) {
                return alignmentPattern.combineEstimate(fCrossCheckVertical, fCenterFromEnd, f6);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(fCenterFromEnd, fCrossCheckVertical, f6);
        this.possibleCenters.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
        return null;
    }

    public AlignmentPattern find() throws NotFoundException {
        AlignmentPattern alignmentPatternHandlePossibleCenter;
        AlignmentPattern alignmentPatternHandlePossibleCenter2;
        int i5 = this.startX;
        int i6 = this.height;
        int i7 = this.width + i5;
        int i8 = (i6 / 2) + this.startY;
        int[] iArr = new int[3];
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = ((i9 & 1) == 0 ? (i9 + 1) / 2 : -((i9 + 1) / 2)) + i8;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i11 = i5;
            while (i11 < i7 && !this.image.get(i11, i10)) {
                i11++;
            }
            int i12 = 0;
            while (i11 < i7) {
                if (!this.image.get(i11, i10)) {
                    if (i12 == 1) {
                        i12++;
                    }
                    iArr[i12] = iArr[i12] + 1;
                } else if (i12 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i12 != 2) {
                    i12++;
                    iArr[i12] = iArr[i12] + 1;
                } else {
                    if (foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter2 = handlePossibleCenter(iArr, i10, i11)) != null) {
                        return alignmentPatternHandlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i12 = 1;
                }
                i11++;
            }
            if (foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter = handlePossibleCenter(iArr, i10, i7)) != null) {
                return alignmentPatternHandlePossibleCenter;
            }
        }
        if (this.possibleCenters.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return this.possibleCenters.get(0);
    }
}
