package com.google.zxing.aztec.detector;

import A3.AbstractC0157z;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.util.IEEEDouble;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = {3808, Videoio.CAP_PROP_XI_GAMMAY, 2107, 1799};
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Point {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f3515x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final int f3516y;

        public Point(int i5, int i6) {
            this.f3515x = i5;
            this.f3516y = i6;
        }

        public int getX() {
            return this.f3515x;
        }

        public int getY() {
            return this.f3516y;
        }

        public ResultPoint toResultPoint() {
            return new ResultPoint(getX(), getY());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f3515x);
            sb.append(Chars.SPACE);
            return AbstractC0157z.p(sb, this.f3516y, '>');
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private static float distance(Point point, Point point2) {
        return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    private static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, float f6, float f7) {
        float f8 = f7 / (f6 * 2.0f);
        float x6 = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y6 = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x7 = (resultPointArr[2].getX() + resultPointArr[0].getX()) / 2.0f;
        float y7 = (resultPointArr[2].getY() + resultPointArr[0].getY()) / 2.0f;
        float f9 = x6 * f8;
        float f10 = y6 * f8;
        ResultPoint resultPoint = new ResultPoint(x7 + f9, y7 + f10);
        ResultPoint resultPoint2 = new ResultPoint(x7 - f9, y7 - f10);
        float x8 = resultPointArr[1].getX() - resultPointArr[3].getX();
        float y8 = resultPointArr[1].getY() - resultPointArr[3].getY();
        float x9 = (resultPointArr[3].getX() + resultPointArr[1].getX()) / 2.0f;
        float y9 = (resultPointArr[3].getY() + resultPointArr[1].getY()) / 2.0f;
        float f11 = x8 * f8;
        float f12 = f8 * y8;
        return new ResultPoint[]{resultPoint, new ResultPoint(x9 + f11, y9 + f12), resultPoint2, new ResultPoint(x9 - f11, y9 - f12)};
    }

    private void extractParameters(ResultPoint[] resultPointArr) throws NotFoundException {
        long j6;
        long j7;
        if (!isValid(resultPointArr[0]) || !isValid(resultPointArr[1]) || !isValid(resultPointArr[2]) || !isValid(resultPointArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = this.nbCenterLayers * 2;
        int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i5), sampleLine(resultPointArr[1], resultPointArr[2], i5), sampleLine(resultPointArr[2], resultPointArr[3], i5), sampleLine(resultPointArr[3], resultPointArr[0], i5)};
        this.shift = getRotation(iArr, i5);
        long j8 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = iArr[(this.shift + i6) % 4];
            if (this.compact) {
                j6 = j8 << 7;
                j7 = (i7 >> 1) & 127;
            } else {
                j6 = j8 << 10;
                j7 = ((i7 >> 2) & 992) + ((i7 >> 1) & 31);
            }
            j8 = j6 + j7;
        }
        int correctedParameterData = getCorrectedParameterData(j8, this.compact);
        if (this.compact) {
            this.nbLayers = (correctedParameterData >> 6) + 1;
            this.nbDataBlocks = (correctedParameterData & 63) + 1;
        } else {
            this.nbLayers = (correctedParameterData >> 11) + 1;
            this.nbDataBlocks = (correctedParameterData & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) + 1;
        }
    }

    private ResultPoint[] getBullsEyeCorners(Point point) throws NotFoundException {
        this.nbCenterLayers = 1;
        Point point2 = point;
        Point point3 = point2;
        Point point4 = point3;
        boolean z6 = true;
        while (this.nbCenterLayers < 9) {
            Point firstDifferent = getFirstDifferent(point, z6, 1, -1);
            Point firstDifferent2 = getFirstDifferent(point2, z6, 1, 1);
            Point firstDifferent3 = getFirstDifferent(point3, z6, -1, 1);
            Point firstDifferent4 = getFirstDifferent(point4, z6, -1, -1);
            if (this.nbCenterLayers > 2) {
                double dDistance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(point4, point) * (this.nbCenterLayers + 2));
                if (dDistance < 0.75d || dDistance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z6 = !z6;
            this.nbCenterLayers++;
            point4 = firstDifferent4;
            point = firstDifferent;
            point2 = firstDifferent2;
            point3 = firstDifferent3;
        }
        int i5 = this.nbCenterLayers;
        if (i5 != 5 && i5 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.compact = i5 == 5;
        ResultPoint[] resultPointArr = {new ResultPoint(point.getX() + 0.5f, point.getY() - 0.5f), new ResultPoint(point2.getX() + 0.5f, point2.getY() + 0.5f), new ResultPoint(point3.getX() - 0.5f, point3.getY() + 0.5f), new ResultPoint(point4.getX() - 0.5f, point4.getY() - 0.5f)};
        int i6 = this.nbCenterLayers;
        return expandSquare(resultPointArr, (i6 * 2) - 3, i6 * 2);
    }

    private int getColor(Point point, Point point2) {
        float fDistance = distance(point, point2);
        float x6 = (point2.getX() - point.getX()) / fDistance;
        float y6 = (point2.getY() - point.getY()) / fDistance;
        float x7 = point.getX();
        float y7 = point.getY();
        boolean z6 = this.image.get(point.getX(), point.getY());
        int iCeil = (int) Math.ceil(fDistance);
        int i5 = 0;
        for (int i6 = 0; i6 < iCeil; i6++) {
            x7 += x6;
            y7 += y6;
            if (this.image.get(MathUtils.round(x7), MathUtils.round(y7)) != z6) {
                i5++;
            }
        }
        float f6 = i5 / fDistance;
        if (f6 <= 0.1f || f6 >= 0.9f) {
            return (f6 <= 0.1f) == z6 ? 1 : -1;
        }
        return 0;
    }

    private static int getCorrectedParameterData(long j6, boolean z6) throws NotFoundException {
        int i5;
        int i6;
        if (z6) {
            i5 = 7;
            i6 = 2;
        } else {
            i5 = 10;
            i6 = 4;
        }
        int i7 = i5 - i6;
        int[] iArr = new int[i5];
        for (int i8 = i5 - 1; i8 >= 0; i8--) {
            iArr[i8] = ((int) j6) & 15;
            j6 >>= 4;
        }
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i7);
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 = (i9 << 4) + iArr[i10];
            }
            return i9;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int getDimension() {
        if (this.compact) {
            return (this.nbLayers * 4) + 11;
        }
        int i5 = this.nbLayers;
        if (i5 <= 4) {
            return (i5 * 4) + 15;
        }
        return ((((i5 - 4) / 8) + 1) * 2) + (i5 * 4) + 15;
    }

    private Point getFirstDifferent(Point point, boolean z6, int i5, int i6) {
        int x6 = point.getX() + i5;
        int y6 = point.getY();
        while (true) {
            y6 += i6;
            if (!isValid(x6, y6) || this.image.get(x6, y6) != z6) {
                break;
            }
            x6 += i5;
        }
        int i7 = x6 - i5;
        int i8 = y6 - i6;
        while (isValid(i7, i8) && this.image.get(i7, i8) == z6) {
            i7 += i5;
        }
        int i9 = i7 - i5;
        while (isValid(i9, i8) && this.image.get(i9, i8) == z6) {
            i8 += i6;
        }
        return new Point(i9, i8 - i6);
    }

    private Point getMatrixCenter() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        try {
            ResultPoint[] resultPointArrDetect = new WhiteRectangleDetector(this.image).detect();
            resultPoint3 = resultPointArrDetect[0];
            resultPoint4 = resultPointArrDetect[1];
            resultPoint2 = resultPointArrDetect[2];
            resultPoint = resultPointArrDetect[3];
        } catch (NotFoundException unused) {
            int width = this.image.getWidth() / 2;
            int height = this.image.getHeight() / 2;
            int i5 = width + 7;
            int i6 = height - 7;
            ResultPoint resultPoint9 = getFirstDifferent(new Point(i5, i6), false, 1, -1).toResultPoint();
            int i7 = height + 7;
            ResultPoint resultPoint10 = getFirstDifferent(new Point(i5, i7), false, 1, 1).toResultPoint();
            int i8 = width - 7;
            ResultPoint resultPoint11 = getFirstDifferent(new Point(i8, i7), false, -1, 1).toResultPoint();
            resultPoint = getFirstDifferent(new Point(i8, i6), false, -1, -1).toResultPoint();
            resultPoint2 = resultPoint11;
            resultPoint3 = resultPoint9;
            resultPoint4 = resultPoint10;
        }
        int iRound = MathUtils.round((resultPoint2.getX() + (resultPoint4.getX() + (resultPoint.getX() + resultPoint3.getX()))) / 4.0f);
        int iRound2 = MathUtils.round((resultPoint2.getY() + (resultPoint4.getY() + (resultPoint.getY() + resultPoint3.getY()))) / 4.0f);
        try {
            ResultPoint[] resultPointArrDetect2 = new WhiteRectangleDetector(this.image, 15, iRound, iRound2).detect();
            resultPoint5 = resultPointArrDetect2[0];
            resultPoint6 = resultPointArrDetect2[1];
            resultPoint7 = resultPointArrDetect2[2];
            resultPoint8 = resultPointArrDetect2[3];
        } catch (NotFoundException unused2) {
            int i9 = iRound + 7;
            int i10 = iRound2 - 7;
            resultPoint5 = getFirstDifferent(new Point(i9, i10), false, 1, -1).toResultPoint();
            int i11 = iRound2 + 7;
            resultPoint6 = getFirstDifferent(new Point(i9, i11), false, 1, 1).toResultPoint();
            int i12 = iRound - 7;
            resultPoint7 = getFirstDifferent(new Point(i12, i11), false, -1, 1).toResultPoint();
            resultPoint8 = getFirstDifferent(new Point(i12, i10), false, -1, -1).toResultPoint();
        }
        return new Point(MathUtils.round((resultPoint7.getX() + (resultPoint6.getX() + (resultPoint8.getX() + resultPoint5.getX()))) / 4.0f), MathUtils.round((resultPoint7.getY() + (resultPoint6.getY() + (resultPoint8.getY() + resultPoint5.getY()))) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension());
    }

    private static int getRotation(int[] iArr, int i5) throws NotFoundException {
        int i6 = 0;
        for (int i7 : iArr) {
            i6 = (i6 << 3) + ((i7 >> (i5 - 2)) << 1) + (i7 & 1);
        }
        int i8 = ((i6 & 1) << 11) + (i6 >> 1);
        for (int i9 = 0; i9 < 4; i9++) {
            if (Integer.bitCount(EXPECTED_CORNER_BITS[i9] ^ i8) <= 2) {
                return i9;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean isValid(int i5, int i6) {
        return i5 >= 0 && i5 < this.image.getWidth() && i6 > 0 && i6 < this.image.getHeight();
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        Point point5 = new Point(point.getX() - 3, point.getY() + 3);
        Point point6 = new Point(point2.getX() - 3, point2.getY() - 3);
        Point point7 = new Point(point3.getX() + 3, point3.getY() - 3);
        Point point8 = new Point(point4.getX() + 3, point4.getY() + 3);
        int color = getColor(point8, point5);
        return color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        GridSampler gridSampler = GridSampler.getInstance();
        int dimension = getDimension();
        float f6 = dimension / 2.0f;
        int i5 = this.nbCenterLayers;
        float f7 = f6 - i5;
        float f8 = f6 + i5;
        return gridSampler.sampleGrid(bitMatrix, dimension, dimension, f7, f7, f8, f7, f8, f8, f7, f8, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i5) {
        float fDistance = distance(resultPoint, resultPoint2);
        float f6 = fDistance / i5;
        float x6 = resultPoint.getX();
        float y6 = resultPoint.getY();
        float x7 = ((resultPoint2.getX() - resultPoint.getX()) * f6) / fDistance;
        float y7 = ((resultPoint2.getY() - resultPoint.getY()) * f6) / fDistance;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            float f7 = i7;
            if (this.image.get(MathUtils.round((f7 * x7) + x6), MathUtils.round((f7 * y7) + y6))) {
                i6 |= 1 << ((i5 - i7) - 1);
            }
        }
        return i6;
    }

    public AztecDetectorResult detect() {
        return detect(false);
    }

    private static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private boolean isValid(ResultPoint resultPoint) {
        return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    public AztecDetectorResult detect(boolean z6) throws NotFoundException {
        ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z6) {
            ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        BitMatrix bitMatrix = this.image;
        int i5 = this.shift;
        return new AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i5 % 4], bullsEyeCorners[(i5 + 1) % 4], bullsEyeCorners[(i5 + 2) % 4], bullsEyeCorners[(i5 + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }
}
