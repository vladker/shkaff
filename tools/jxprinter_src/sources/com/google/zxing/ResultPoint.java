package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ResultPoint {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f3513x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f3514y;

    public ResultPoint(float f6, float f7) {
        this.f3513x = f6;
        this.f3514y = f7;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f6 = resultPoint2.f3513x;
        float f7 = resultPoint2.f3514y;
        return ((resultPoint.f3514y - f7) * (resultPoint3.f3513x - f6)) - ((resultPoint.f3513x - f6) * (resultPoint3.f3514y - f7));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f3513x, resultPoint.f3514y, resultPoint2.f3513x, resultPoint2.f3514y);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 < fDistance2 || fDistance3 < fDistance) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f3513x == resultPoint.f3513x && this.f3514y == resultPoint.f3514y) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.f3513x;
    }

    public final float getY() {
        return this.f3514y;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f3514y) + (Float.floatToIntBits(this.f3513x) * 31);
    }

    public final String toString() {
        return "(" + this.f3513x + ',' + this.f3514y + ')';
    }
}
