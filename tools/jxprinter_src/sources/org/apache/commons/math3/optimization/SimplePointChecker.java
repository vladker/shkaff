package org.apache.commons.math3.optimization;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SimplePointChecker<PAIR extends Pair<double[], ? extends Object>> extends AbstractConvergenceChecker<PAIR> {
    private static final int ITERATION_CHECK_DISABLED = -1;
    private final int maxIterationCount;

    @Deprecated
    public SimplePointChecker() {
        this.maxIterationCount = -1;
    }

    @Override // org.apache.commons.math3.optimization.AbstractConvergenceChecker, org.apache.commons.math3.optimization.ConvergenceChecker
    public boolean converged(int i5, PAIR pair, PAIR pair2) {
        int i6 = this.maxIterationCount;
        if (i6 != -1 && i5 >= i6) {
            return true;
        }
        double[] dArr = (double[]) pair.getKey();
        double[] dArr2 = (double[]) pair2.getKey();
        for (int i7 = 0; i7 < dArr.length; i7++) {
            double d = dArr[i7];
            double d6 = dArr2[i7];
            double dAbs = FastMath.abs(d - d6);
            if (dAbs > getRelativeThreshold() * FastMath.max(FastMath.abs(d), FastMath.abs(d6)) && dAbs > getAbsoluteThreshold()) {
                return false;
            }
        }
        return true;
    }

    public SimplePointChecker(double d, double d6) {
        super(d, d6);
        this.maxIterationCount = -1;
    }

    public SimplePointChecker(double d, double d6, int i5) {
        super(d, d6);
        if (i5 > 0) {
            this.maxIterationCount = i5;
            return;
        }
        throw new NotStrictlyPositiveException(Integer.valueOf(i5));
    }
}
