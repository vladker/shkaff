package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EarthMoversDistance implements DistanceMeasure {
    private static final long serialVersionUID = -5406732779747414922L;

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] dArr, double[] dArr2) {
        MathArrays.checkEqualLength(dArr, dArr2);
        double dAbs = 0.0d;
        double d = 0.0d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            d = (dArr[i5] + d) - dArr2[i5];
            dAbs += FastMath.abs(d);
        }
        return dAbs;
    }
}
