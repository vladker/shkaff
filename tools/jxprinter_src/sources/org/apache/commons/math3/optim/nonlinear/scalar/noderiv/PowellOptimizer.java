package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PowellOptimizer extends MultivariateOptimizer {
    private static final double MIN_RELATIVE_TOLERANCE = FastMath.ulp(1.0d) * 2.0d;
    private final double absoluteThreshold;
    private final LineSearch line;
    private final double relativeThreshold;

    public PowellOptimizer(double d, double d6, ConvergenceChecker<PointValuePair> convergenceChecker) {
        this(d, d6, FastMath.sqrt(d), FastMath.sqrt(d6), convergenceChecker);
    }

    private void checkParameters() {
        if (getLowerBound() != null || getUpperBound() != null) {
            throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
        }
    }

    private double[][] newPointAndDirection(double[] dArr, double[] dArr2, double d) {
        int length = dArr.length;
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            double d6 = dArr2[i5] * d;
            dArr4[i5] = d6;
            dArr3[i5] = dArr[i5] + d6;
        }
        return new double[][]{dArr3, dArr4};
    }

    public PowellOptimizer(double d, double d6, double d7, double d8, ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
        double d9 = MIN_RELATIVE_TOLERANCE;
        if (d < d9) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(d9), true);
        }
        if (d6 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d6));
        }
        this.relativeThreshold = d;
        this.absoluteThreshold = d6;
        this.line = new LineSearch(this, d7, d8, 1.0d);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x012a  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b8, code lost:
    
        r11 = r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v6 */
    @Override // org.apache.commons.math3.optim.BaseOptimizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.apache.commons.math3.optim.PointValuePair doOptimize() {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.optim.nonlinear.scalar.noderiv.PowellOptimizer.doOptimize():org.apache.commons.math3.optim.PointValuePair");
    }

    public PowellOptimizer(double d, double d6) {
        this(d, d6, null);
    }

    public PowellOptimizer(double d, double d6, double d7, double d8) {
        this(d, d6, d7, d8, null);
    }
}
