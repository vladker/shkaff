package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays)) {
            return fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        return Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f6) throws NotFoundException {
        int iRound = (MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f6) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f6)) / 2;
        int i5 = iRound + 7;
        int i6 = i5 & 3;
        if (i6 == 0) {
            return iRound + 8;
        }
        if (i6 == 2) {
            return iRound + 6;
        }
        if (i6 != 3) {
            return i5;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i5) {
        float x6;
        float y6;
        float f6;
        float f7 = i5 - 3.5f;
        if (resultPoint4 != null) {
            x6 = resultPoint4.getX();
            y6 = resultPoint4.getY();
            f6 = f7 - 3.0f;
        } else {
            x6 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y6 = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f6 = f7;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f7, 3.5f, f6, f6, 3.5f, f7, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x6, y6, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i5) {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i5, i5, perspectiveTransform);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:44:0x008b A[RETURN] */
    private float sizeOfBlackWhiteBlackRun(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = 1;
        boolean z6 = Math.abs(i8 - i6) > Math.abs(i7 - i5);
        if (z6) {
            i10 = i5;
            i9 = i6;
            i12 = i7;
            i11 = i8;
        } else {
            i9 = i5;
            i10 = i6;
            i11 = i7;
            i12 = i8;
        }
        int iAbs = Math.abs(i11 - i9);
        int iAbs2 = Math.abs(i12 - i10);
        int i15 = 2;
        int i16 = (-iAbs) / 2;
        int i17 = i9 < i11 ? 1 : -1;
        int i18 = i10 < i12 ? 1 : -1;
        int i19 = i11 + i17;
        int i20 = i9;
        int i21 = i10;
        int i22 = 0;
        while (i20 != i19) {
            boolean z7 = z6;
            if ((i22 == i14 ? i14 : 0) == this.image.get(z6 ? i21 : i20, z6 ? i20 : i21)) {
                if (i22 == 2) {
                    return MathUtils.distance(i20, i21, i9, i10);
                }
                i22++;
            }
            i16 += iAbs2;
            if (i16 > 0) {
                if (i21 == i12) {
                    i13 = 2;
                    if (i22 == i13) {
                        return MathUtils.distance(i19, i12, i9, i10);
                    }
                    return Float.NaN;
                }
                i21 += i18;
                i16 -= iAbs;
            }
            i20 += i17;
            iAbs = iAbs;
            z6 = z7;
            i14 = 1;
            i15 = 2;
        }
        i13 = i15;
        if (i22 == i13) {
            return MathUtils.distance(i19, i12, i9, i10);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i5, int i6, int i7, int i8) {
        float width;
        float height;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i5, i6, i7, i8);
        int width2 = i5 - (i7 - i5);
        int height2 = 0;
        if (width2 < 0) {
            width = i5 / (i5 - width2);
            width2 = 0;
        } else if (width2 >= this.image.getWidth()) {
            width = ((this.image.getWidth() - 1) - i5) / (width2 - i5);
            width2 = this.image.getWidth() - 1;
        } else {
            width = 1.0f;
        }
        float f6 = i6;
        int i9 = (int) (f6 - ((i8 - i6) * width));
        if (i9 < 0) {
            height = f6 / (i6 - i9);
        } else if (i9 >= this.image.getHeight()) {
            height = ((this.image.getHeight() - 1) - i6) / (i9 - i6);
            height2 = this.image.getHeight() - 1;
        } else {
            height2 = i9;
            height = 1.0f;
        }
        return (fSizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i5, i6, (int) (((width2 - i5) * height) + i5), height2)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() {
        return detect(null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f6, int i5, int i6, float f7) throws NotFoundException {
        int i7 = (int) (f7 * f6);
        int iMax = Math.max(0, i5 - i7);
        int iMin = Math.min(this.image.getWidth() - 1, i5 + i7) - iMax;
        float f8 = 3.0f * f6;
        if (iMin < f8) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i6 - i7);
        int iMin2 = Math.min(this.image.getHeight() - 1, i6 + i7) - iMax2;
        if (iMin2 >= f8) {
            return new AlignmentPatternFinder(this.image, iMax, iMax2, iMin, iMin2, f6, this.resultPointCallback).find();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        AlignmentPattern alignmentPatternFindAlignmentInRegion;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float fCalculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (fCalculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(topLeft, topRight, bottomLeft, fCalculateModuleSize);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(iComputeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length <= 0) {
            alignmentPatternFindAlignmentInRegion = null;
            break;
        }
        float x6 = bottomLeft.getX() + (topRight.getX() - topLeft.getX());
        float y6 = bottomLeft.getY() + (topRight.getY() - topLeft.getY());
        float f6 = 1.0f - (3.0f / dimensionForVersion);
        int x7 = (int) (((x6 - topLeft.getX()) * f6) + topLeft.getX());
        int y7 = (int) (((y6 - topLeft.getY()) * f6) + topLeft.getY());
        int i5 = 4;
        while (true) {
            if (i5 > 16) {
                alignmentPatternFindAlignmentInRegion = null;
                break;
            }
            try {
                alignmentPatternFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, x7, y7, i5);
                break;
            } catch (NotFoundException unused) {
                i5 <<= 1;
            }
        }
        return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPatternFindAlignmentInRegion, iComputeDimension), iComputeDimension), alignmentPatternFindAlignmentInRegion == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternFindAlignmentInRegion});
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback).find(map));
    }
}
