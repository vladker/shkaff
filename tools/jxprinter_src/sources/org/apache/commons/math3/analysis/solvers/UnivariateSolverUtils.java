package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnivariateSolverUtils {
    private UnivariateSolverUtils() {
    }

    public static double[] bracket(UnivariateFunction univariateFunction, double d, double d6, double d7) {
        return bracket(univariateFunction, d, d6, d7, 1.0d, 1.0d, Integer.MAX_VALUE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    public static double forceSide(int i5, UnivariateFunction univariateFunction, BracketedUnivariateSolver<UnivariateFunction> bracketedUnivariateSolver, double d, double d6, double d7, AllowedSolution allowedSolution) {
        AllowedSolution allowedSolution2 = allowedSolution;
        if (allowedSolution2 == AllowedSolution.ANY_SIDE) {
            return d;
        }
        double dMax = FastMath.max(bracketedUnivariateSolver.getAbsoluteAccuracy(), FastMath.abs(bracketedUnivariateSolver.getRelativeAccuracy() * d));
        double dMax2 = FastMath.max(d6, d - dMax);
        double dValue = univariateFunction.value(dMax2);
        double dMin = FastMath.min(d7, d + dMax);
        int i6 = i5 - 2;
        double d8 = dMax2;
        double dValue2 = dValue;
        double d9 = dMin;
        double dValue3 = univariateFunction.value(dMin);
        while (i6 > 0) {
            if ((dValue2 >= 0.0d && dValue3 <= 0.0d) || (dValue2 <= 0.0d && dValue3 >= 0.0d)) {
                return bracketedUnivariateSolver.solve(i6, univariateFunction, d8, d9, d, allowedSolution2);
            }
            boolean z6 = false;
            boolean z7 = true;
            if (dValue2 < dValue3) {
                if (dValue2 >= 0.0d) {
                    z7 = false;
                    z6 = true;
                }
            } else if (dValue2 <= dValue3) {
                z6 = true;
            } else if (dValue2 <= 0.0d) {
                z7 = false;
                z6 = true;
            }
            if (z6) {
                double dMax3 = FastMath.max(d6, d8 - dMax);
                i6--;
                d8 = dMax3;
                dValue2 = univariateFunction.value(dMax3);
            }
            if (z7) {
                double dMin2 = FastMath.min(d7, d9 + dMax);
                i6--;
                d9 = dMin2;
                dValue3 = univariateFunction.value(dMin2);
            }
            allowedSolution2 = allowedSolution;
        }
        throw new NoBracketingException(LocalizedFormats.FAILED_BRACKETING, d8, d9, dValue2, dValue3, Integer.valueOf(i5 - i6), Integer.valueOf(i5), Double.valueOf(d), Double.valueOf(d6), Double.valueOf(d7));
    }

    public static boolean isBracketing(UnivariateFunction univariateFunction, double d, double d6) {
        if (univariateFunction == null) {
            throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
        }
        double dValue = univariateFunction.value(d);
        double dValue2 = univariateFunction.value(d6);
        if (dValue < 0.0d || dValue2 > 0.0d) {
            return dValue <= 0.0d && dValue2 >= 0.0d;
        }
        return true;
    }

    public static boolean isSequence(double d, double d6, double d7) {
        return d < d6 && d6 < d7;
    }

    public static double midpoint(double d, double d6) {
        return (d + d6) * 0.5d;
    }

    public static double solve(UnivariateFunction univariateFunction, double d, double d6) {
        if (univariateFunction != null) {
            return new BrentSolver().solve(Integer.MAX_VALUE, univariateFunction, d, d6);
        }
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static void verifyBracketing(UnivariateFunction univariateFunction, double d, double d6) {
        if (univariateFunction == null) {
            throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
        }
        verifyInterval(d, d6);
        if (!isBracketing(univariateFunction, d, d6)) {
            throw new NoBracketingException(d, d6, univariateFunction.value(d), univariateFunction.value(d6));
        }
    }

    public static void verifyInterval(double d, double d6) {
        if (d >= d6) {
            throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(d), Double.valueOf(d6), false);
        }
    }

    public static void verifySequence(double d, double d6, double d7) {
        verifyInterval(d, d6);
        verifyInterval(d6, d7);
    }

    public static double[] bracket(UnivariateFunction univariateFunction, double d, double d6, double d7, int i5) {
        return bracket(univariateFunction, d, d6, d7, 1.0d, 1.0d, i5);
    }

    public static double[] bracket(UnivariateFunction univariateFunction, double d, double d6, double d7, double d8, double d9, int i5) {
        if (univariateFunction == null) {
            throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
        }
        double d10 = 0.0d;
        if (d8 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d8));
        }
        if (i5 > 0) {
            double d11 = d6;
            verifySequence(d11, d, d7);
            double d12 = Double.NaN;
            double d13 = d;
            double d14 = d13;
            double d15 = Double.NaN;
            double d16 = 0.0d;
            int i6 = 0;
            while (i6 < i5 && (d13 > d11 || d14 < d7)) {
                d16 = (d16 * d9) + d8;
                double d17 = d10;
                double dMax = FastMath.max(d - d16, d11);
                double dMin = FastMath.min(d + d16, d7);
                double dValue = univariateFunction.value(dMax);
                double dValue2 = univariateFunction.value(dMin);
                if (i6 == 0) {
                    if (dValue * dValue2 <= d17) {
                        return new double[]{dMax, dMin};
                    }
                } else {
                    if (d12 * dValue <= d17) {
                        return new double[]{dMax, d13};
                    }
                    if (d15 * dValue2 <= d17) {
                        return new double[]{d14, dMin};
                    }
                }
                i6++;
                d14 = dMin;
                d13 = dMax;
                d10 = d17;
                d12 = dValue;
                d15 = dValue2;
                d11 = d6;
            }
            throw new NoBracketingException(d13, d14, d12, d15);
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.INVALID_MAX_ITERATIONS, Integer.valueOf(i5));
    }

    public static double solve(UnivariateFunction univariateFunction, double d, double d6, double d7) {
        if (univariateFunction != null) {
            return new BrentSolver(d7).solve(Integer.MAX_VALUE, univariateFunction, d, d6);
        }
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }
}
