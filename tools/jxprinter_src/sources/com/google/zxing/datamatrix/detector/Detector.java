package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        public ResultPoint getFrom() {
            return this.from;
        }

        public ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + PackagingURIHelper.FORWARD_SLASH_STRING + this.to + '/' + this.transitions;
        }

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i5) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i5) {
        float f6 = i5;
        float fDistance = distance(resultPoint, resultPoint2) / f6;
        float fDistance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / fDistance2) * fDistance) + resultPoint4.getX(), (fDistance * ((resultPoint4.getY() - resultPoint3.getY()) / fDistance2)) + resultPoint4.getY());
        float fDistance3 = distance(resultPoint, resultPoint3) / f6;
        float fDistance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / fDistance4) * fDistance3) + resultPoint4.getX(), (fDistance3 * ((resultPoint4.getY() - resultPoint2.getY()) / fDistance4)) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            if (!isValid(resultPoint6) || Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                return resultPoint5;
            }
        } else if (!isValid(resultPoint6)) {
            return null;
        }
        return resultPoint6;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i5, int i6) {
        float fDistance = distance(resultPoint, resultPoint2) / i5;
        float fDistance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / fDistance2) * fDistance) + resultPoint4.getX(), (fDistance * ((resultPoint4.getY() - resultPoint3.getY()) / fDistance2)) + resultPoint4.getY());
        float fDistance3 = distance(resultPoint, resultPoint3) / i6;
        float fDistance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / fDistance4) * fDistance3) + resultPoint4.getX(), (fDistance3 * ((resultPoint4.getY() - resultPoint2.getY()) / fDistance4)) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            if (isValid(resultPoint6)) {
                if (Math.abs(i6 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) + Math.abs(i5 - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) <= Math.abs(i6 - transitionsBetween(resultPoint2, resultPoint6).getTransitions()) + Math.abs(i5 - transitionsBetween(resultPoint3, resultPoint6).getTransitions())) {
                }
            }
            return resultPoint5;
        }
        if (!isValid(resultPoint6)) {
            return null;
        }
        return resultPoint6;
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i5, int i6) {
        float f6 = i5 - 0.5f;
        float f7 = i6 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i5, i6, 0.5f, 0.5f, f6, 0.5f, f6, f7, 0.5f, f7, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x6 = (int) resultPoint.getX();
        int y6 = (int) resultPoint.getY();
        int x7 = (int) resultPoint2.getX();
        int y7 = (int) resultPoint2.getY();
        int i5 = 0;
        boolean z6 = Math.abs(y7 - y6) > Math.abs(x7 - x6);
        if (z6) {
            y6 = x6;
            x6 = y6;
            y7 = x7;
            x7 = y7;
        }
        int iAbs = Math.abs(x7 - x6);
        int iAbs2 = Math.abs(y7 - y6);
        int i6 = (-iAbs) / 2;
        int i7 = y6 < y7 ? 1 : -1;
        int i8 = x6 >= x7 ? -1 : 1;
        boolean z7 = this.image.get(z6 ? y6 : x6, z6 ? x6 : y6);
        while (x6 != x7) {
            boolean z8 = this.image.get(z6 ? y6 : x6, z6 ? x6 : y6);
            if (z8 != z7) {
                i5++;
                z7 = z8;
            }
            i6 += iAbs2;
            if (i6 > 0) {
                if (y6 == y7) {
                    break;
                }
                y6 += i7;
                i6 -= iAbs;
            }
            x6 += i8;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DetectorResult detect() throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        BitMatrix bitMatrixSampleGrid;
        ResultPoint[] resultPointArrDetect = this.rectangleDetector.detect();
        ResultPoint resultPoint3 = resultPointArrDetect[0];
        ResultPoint resultPoint4 = resultPointArrDetect[1];
        ResultPoint resultPoint5 = resultPointArrDetect[2];
        ResultPoint resultPoint6 = resultPointArrDetect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
        arrayList.add(transitionsBetween(resultPoint5, resultPoint6));
        ResultPoint resultPoint7 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap map = new HashMap();
        increment(map, resultPointsAndTransitions.getFrom());
        increment(map, resultPointsAndTransitions.getTo());
        increment(map, resultPointsAndTransitions2.getFrom());
        increment(map, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint8 = null;
        ResultPoint resultPoint9 = null;
        for (Map.Entry entry : map.entrySet()) {
            ResultPoint resultPoint10 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint8 = resultPoint10;
            } else if (resultPoint7 == null) {
                resultPoint7 = resultPoint10;
            } else {
                resultPoint9 = resultPoint10;
            }
        }
        if (resultPoint7 == null || resultPoint8 == null || resultPoint9 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {resultPoint7, resultPoint8, resultPoint9};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint11 = resultPointArr[0];
        ResultPoint resultPoint12 = resultPointArr[1];
        ResultPoint resultPoint13 = resultPointArr[2];
        if (!map.containsKey(resultPoint3)) {
            resultPoint4 = resultPoint3;
        } else if (map.containsKey(resultPoint4)) {
            resultPoint4 = !map.containsKey(resultPoint5) ? resultPoint5 : resultPoint6;
        }
        int transitions = transitionsBetween(resultPoint13, resultPoint4).getTransitions();
        int transitions2 = transitionsBetween(resultPoint11, resultPoint4).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i5 = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i6 = transitions2 + 2;
        if (i5 * 4 >= i6 * 7 || i6 * 4 >= i5 * 7) {
            resultPoint = resultPoint13;
            ResultPoint resultPointCorrectTopRightRectangular = correctTopRightRectangular(resultPoint12, resultPoint11, resultPoint, resultPoint4, i5, i6);
            resultPoint11 = resultPoint11;
            if (resultPointCorrectTopRightRectangular != null) {
                resultPoint4 = resultPointCorrectTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint, resultPoint4).getTransitions();
            int transitions4 = transitionsBetween(resultPoint11, resultPoint4).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i7 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            resultPoint2 = resultPoint12;
            bitMatrixSampleGrid = sampleGrid(this.image, resultPoint, resultPoint2, resultPoint11, resultPoint4, i7, transitions4);
        } else {
            resultPoint = resultPoint13;
            ResultPoint resultPointCorrectTopRight = correctTopRight(resultPoint12, resultPoint11, resultPoint, resultPoint4, Math.min(i6, i5));
            if (resultPointCorrectTopRight != null) {
                resultPoint4 = resultPointCorrectTopRight;
            }
            int iMax = Math.max(transitionsBetween(resultPoint, resultPoint4).getTransitions(), transitionsBetween(resultPoint11, resultPoint4).getTransitions());
            int i8 = iMax + 1;
            if ((i8 & 1) == 1) {
                i8 = iMax + 2;
            }
            int i9 = i8;
            resultPoint2 = resultPoint12;
            bitMatrixSampleGrid = sampleGrid(this.image, resultPoint, resultPoint2, resultPoint11, resultPoint4, i9, i9);
        }
        return new DetectorResult(bitMatrixSampleGrid, new ResultPoint[]{resultPoint, resultPoint2, resultPoint11, resultPoint4});
    }
}
