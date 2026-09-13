package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.optimization.AbstractConvergenceChecker;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SimpleUnivariateValueChecker extends AbstractConvergenceChecker<UnivariatePointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;
    private final int maxIterationCount;

    @Deprecated
    public SimpleUnivariateValueChecker() {
        this.maxIterationCount = -1;
    }

    @Override // org.apache.commons.math3.optimization.AbstractConvergenceChecker, org.apache.commons.math3.optimization.ConvergenceChecker
    public boolean converged(int i5, UnivariatePointValuePair univariatePointValuePair, UnivariatePointValuePair univariatePointValuePair2) {
        int i6 = this.maxIterationCount;
        if (i6 != -1 && i5 >= i6) {
            return true;
        }
        double value = univariatePointValuePair.getValue();
        double value2 = univariatePointValuePair2.getValue();
        double dAbs = FastMath.abs(value - value2);
        return dAbs <= getRelativeThreshold() * FastMath.max(FastMath.abs(value), FastMath.abs(value2)) || dAbs <= getAbsoluteThreshold();
    }

    public SimpleUnivariateValueChecker(double d, double d6) {
        super(d, d6);
        this.maxIterationCount = -1;
    }

    public SimpleUnivariateValueChecker(double d, double d6, int i5) {
        super(d, d6);
        if (i5 > 0) {
            this.maxIterationCount = i5;
            return;
        }
        throw new NotStrictlyPositiveException(Integer.valueOf(i5));
    }
}
