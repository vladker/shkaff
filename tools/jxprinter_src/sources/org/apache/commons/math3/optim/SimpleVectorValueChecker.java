package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleVectorValueChecker extends AbstractConvergenceChecker<PointVectorValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;
    private final int maxIterationCount;

    public SimpleVectorValueChecker(double d, double d6) {
        super(d, d6);
        this.maxIterationCount = -1;
    }

    @Override // org.apache.commons.math3.optim.AbstractConvergenceChecker, org.apache.commons.math3.optim.ConvergenceChecker
    public boolean converged(int i5, PointVectorValuePair pointVectorValuePair, PointVectorValuePair pointVectorValuePair2) {
        int i6 = this.maxIterationCount;
        if (i6 != -1 && i5 >= i6) {
            return true;
        }
        double[] valueRef = pointVectorValuePair.getValueRef();
        double[] valueRef2 = pointVectorValuePair2.getValueRef();
        for (int i7 = 0; i7 < valueRef.length; i7++) {
            double d = valueRef[i7];
            double d6 = valueRef2[i7];
            double dAbs = FastMath.abs(d - d6);
            if (dAbs > getRelativeThreshold() * FastMath.max(FastMath.abs(d), FastMath.abs(d6)) && dAbs > getAbsoluteThreshold()) {
                return false;
            }
        }
        return true;
    }

    public SimpleVectorValueChecker(double d, double d6, int i5) {
        super(d, d6);
        if (i5 > 0) {
            this.maxIterationCount = i5;
            return;
        }
        throw new NotStrictlyPositiveException(Integer.valueOf(i5));
    }
}
