package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BrentOptimizer extends BaseAbstractUnivariateOptimizer {
    private static final double GOLDEN_SECTION = (3.0d - FastMath.sqrt(5.0d)) * 0.5d;
    private static final double MIN_RELATIVE_TOLERANCE = FastMath.ulp(1.0d) * 2.0d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

    public BrentOptimizer(double d, double d6, ConvergenceChecker<UnivariatePointValuePair> convergenceChecker) {
        super(convergenceChecker);
        double d7 = MIN_RELATIVE_TOLERANCE;
        if (d < d7) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(d7), true);
        }
        if (d6 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d6));
        }
        this.relativeThreshold = d;
        this.absoluteThreshold = d6;
    }

    private UnivariatePointValuePair best(UnivariatePointValuePair univariatePointValuePair, UnivariatePointValuePair univariatePointValuePair2, boolean z6) {
        if (univariatePointValuePair == null) {
            return univariatePointValuePair2;
        }
        return (univariatePointValuePair2 != null && (!z6 ? univariatePointValuePair.getValue() >= univariatePointValuePair2.getValue() : univariatePointValuePair.getValue() <= univariatePointValuePair2.getValue())) ? univariatePointValuePair2 : univariatePointValuePair;
    }

    @Override // org.apache.commons.math3.optimization.univariate.BaseAbstractUnivariateOptimizer
    public UnivariatePointValuePair doOptimize() {
        double d;
        double d6;
        double d7;
        boolean z6;
        BrentOptimizer brentOptimizer = this;
        int i5 = 0;
        boolean z7 = brentOptimizer.getGoalType() == GoalType.MINIMIZE;
        double min = brentOptimizer.getMin();
        double startValue = brentOptimizer.getStartValue();
        double max = brentOptimizer.getMax();
        ConvergenceChecker<UnivariatePointValuePair> convergenceChecker = brentOptimizer.getConvergenceChecker();
        if (min >= max) {
            max = min;
            min = max;
        }
        double dComputeObjectiveValue = brentOptimizer.computeObjectiveValue(startValue);
        if (!z7) {
            dComputeObjectiveValue = -dComputeObjectiveValue;
        }
        UnivariatePointValuePair univariatePointValuePair = new UnivariatePointValuePair(startValue, z7 ? dComputeObjectiveValue : -dComputeObjectiveValue);
        double d8 = dComputeObjectiveValue;
        double d9 = d8;
        double d10 = d9;
        UnivariatePointValuePair univariatePointValuePair2 = univariatePointValuePair;
        UnivariatePointValuePair univariatePointValuePair3 = null;
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = startValue;
        double d14 = max;
        double d15 = d13;
        while (true) {
            double d16 = (min + d14) * 0.5d;
            double d17 = min;
            double dAbs = (FastMath.abs(startValue) * brentOptimizer.relativeThreshold) + brentOptimizer.absoluteThreshold;
            double d18 = dAbs * 2.0d;
            if (FastMath.abs(startValue - d16) <= d18 - ((d14 - d17) * 0.5d)) {
                return brentOptimizer.best(univariatePointValuePair, brentOptimizer.best(univariatePointValuePair3, univariatePointValuePair2, z7), z7);
            }
            if (FastMath.abs(d11) > dAbs) {
                double d19 = startValue - d15;
                double d20 = (d8 - d9) * d19;
                double d21 = startValue - d13;
                double d22 = (d8 - d10) * d21;
                d6 = d14;
                double d23 = (d21 * d22) - (d19 * d20);
                d = d13;
                double d24 = (d22 - d20) * 2.0d;
                if (d24 > 0.0d) {
                    d23 = -d23;
                } else {
                    d24 = -d24;
                }
                double d25 = d17 - startValue;
                if (d23 <= d24 * d25 || d23 >= (d6 - startValue) * d24 || FastMath.abs(d23) >= FastMath.abs(0.5d * d24 * d11)) {
                    if (startValue < d16) {
                        d25 = d6 - startValue;
                    }
                    d12 = GOLDEN_SECTION * d25;
                    d11 = d25;
                } else {
                    double d26 = d23 / d24;
                    double d27 = startValue + d26;
                    if (d27 - d17 >= d18 && d6 - d27 >= d18) {
                        d11 = d12;
                        d12 = d26;
                    } else if (startValue <= d16) {
                        d11 = d12;
                        d12 = dAbs;
                    } else {
                        d11 = d12;
                        d12 = -dAbs;
                    }
                }
            } else {
                d = d13;
                d6 = d14;
                double d28 = startValue < d16 ? d6 - startValue : d17 - startValue;
                d12 = GOLDEN_SECTION * d28;
                d11 = d28;
            }
            if (FastMath.abs(d12) < dAbs) {
                d7 = d12 >= 0.0d ? dAbs + startValue : startValue - dAbs;
            } else {
                d7 = startValue + d12;
            }
            double dComputeObjectiveValue2 = brentOptimizer.computeObjectiveValue(d7);
            if (!z7) {
                dComputeObjectiveValue2 = -dComputeObjectiveValue2;
            }
            double d29 = startValue;
            UnivariatePointValuePair univariatePointValuePair4 = new UnivariatePointValuePair(d7, z7 ? dComputeObjectiveValue2 : -dComputeObjectiveValue2);
            univariatePointValuePair = brentOptimizer.best(univariatePointValuePair, brentOptimizer.best(univariatePointValuePair2, univariatePointValuePair4, z7), z7);
            if (convergenceChecker != null && convergenceChecker.converged(i5, univariatePointValuePair2, univariatePointValuePair4)) {
                return univariatePointValuePair;
            }
            if (dComputeObjectiveValue2 <= d8) {
                if (d7 < d29) {
                    d6 = d29;
                } else {
                    d17 = d29;
                }
                startValue = d7;
                d9 = d10;
                min = d17;
                d10 = d8;
                d8 = dComputeObjectiveValue2;
                d13 = d15;
                d15 = d29;
                z6 = z7;
            } else {
                if (d7 < d29) {
                    d17 = d7;
                } else {
                    d6 = d7;
                }
                if (dComputeObjectiveValue2 > d10) {
                    startValue = d29;
                    if (!Precision.equals(d15, startValue)) {
                        if (dComputeObjectiveValue2 > d9) {
                            z6 = z7;
                            double d30 = d;
                            if (!Precision.equals(d30, startValue) && !Precision.equals(d30, d15)) {
                                d13 = d30;
                            }
                        } else {
                            z6 = z7;
                        }
                        d9 = dComputeObjectiveValue2;
                        d13 = d7;
                    }
                    min = d17;
                } else {
                    startValue = d29;
                }
                z6 = z7;
                d9 = d10;
                d10 = dComputeObjectiveValue2;
                d13 = d15;
                d15 = d7;
                min = d17;
            }
            i5++;
            univariatePointValuePair3 = univariatePointValuePair2;
            univariatePointValuePair2 = univariatePointValuePair4;
            brentOptimizer = this;
            z7 = z6;
            d14 = d6;
        }
    }

    public BrentOptimizer(double d, double d6) {
        this(d, d6, null);
    }
}
