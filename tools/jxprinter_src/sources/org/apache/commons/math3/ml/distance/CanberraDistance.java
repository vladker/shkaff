package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CanberraDistance implements DistanceMeasure {
    private static final long serialVersionUID = -6972277381587032228L;

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] dArr, double[] dArr2) {
        MathArrays.checkEqualLength(dArr, dArr2);
        double d = 0.0d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double dAbs = FastMath.abs(dArr[i5] - dArr2[i5]);
            double dAbs2 = FastMath.abs(dArr2[i5]) + FastMath.abs(dArr[i5]);
            d += (dAbs == 0.0d && dAbs2 == 0.0d) ? 0.0d : dAbs / dAbs2;
        }
        return d;
    }
}
