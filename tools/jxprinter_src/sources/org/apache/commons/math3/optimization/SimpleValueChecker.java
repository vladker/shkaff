package org.apache.commons.math3.optimization;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SimpleValueChecker extends AbstractConvergenceChecker<PointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;
    private final int maxIterationCount;

    @Deprecated
    public SimpleValueChecker() {
        this.maxIterationCount = -1;
    }

    @Override // org.apache.commons.math3.optimization.AbstractConvergenceChecker, org.apache.commons.math3.optimization.ConvergenceChecker
    public boolean converged(int i5, PointValuePair pointValuePair, PointValuePair pointValuePair2) {
        int i6 = this.maxIterationCount;
        if (i6 != -1 && i5 >= i6) {
            return true;
        }
        double dDoubleValue = pointValuePair.getValue().doubleValue();
        double dDoubleValue2 = pointValuePair2.getValue().doubleValue();
        double dAbs = FastMath.abs(dDoubleValue - dDoubleValue2);
        return dAbs <= getRelativeThreshold() * FastMath.max(FastMath.abs(dDoubleValue), FastMath.abs(dDoubleValue2)) || dAbs <= getAbsoluteThreshold();
    }

    public SimpleValueChecker(double d, double d6) {
        super(d, d6);
        this.maxIterationCount = -1;
    }

    public SimpleValueChecker(double d, double d6, int i5) {
        super(d, d6);
        if (i5 > 0) {
            this.maxIterationCount = i5;
            return;
        }
        throw new NotStrictlyPositiveException(Integer.valueOf(i5));
    }
}
