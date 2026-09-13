package org.apache.commons.math3.analysis.solvers;

import androidx.collection.a;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BracketingNthOrderBrentSolver extends AbstractUnivariateSolver implements BracketedUnivariateSolver<UnivariateFunction> {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private static final int DEFAULT_MAXIMAL_ORDER = 5;
    private static final int MAXIMAL_AGING = 2;
    private static final double REDUCTION_FACTOR = 0.0625d;
    private AllowedSolution allowed;
    private final int maximalOrder;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution;

        static {
            int[] iArr = new int[AllowedSolution.values().length];
            $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution = iArr;
            try {
                iArr[AllowedSolution.ANY_SIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.LEFT_SIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.RIGHT_SIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.BELOW_SIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[AllowedSolution.ABOVE_SIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BracketingNthOrderBrentSolver() {
        this(1.0E-6d, 5);
    }

    private double guessX(double d, double[] dArr, double[] dArr2, int i5, int i6) {
        int i7;
        int i8 = i5;
        while (true) {
            i7 = i6 - 1;
            if (i8 >= i7) {
                break;
            }
            int i9 = i8 + 1;
            int i10 = i9 - i5;
            while (i7 > i8) {
                dArr[i7] = (dArr[i7] - dArr[i7 - 1]) / (dArr2[i7] - dArr2[i7 - i10]);
                i7--;
            }
            i8 = i9;
        }
        double dA = 0.0d;
        while (i7 >= i5) {
            dA = a.a(d, dArr2[i7], dA, dArr[i7]);
            i7--;
        }
        return dA;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0131  */
    /* JADX WARN: Code duplicated, block: B:44:0x0139  */
    /* JADX WARN: Code duplicated, block: B:45:0x013c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0164  */
    /* JADX WARN: Code duplicated, block: B:57:0x016d  */
    /* JADX WARN: Code duplicated, block: B:61:0x017f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0192  */
    /* JADX WARN: Code duplicated, block: B:68:0x0195  */
    /* JADX WARN: Code duplicated, block: B:70:0x019f  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ac A[PHI: r15
  0x01ac: PHI (r15v7 int) = (r15v6 int), (r15v8 int) binds: [B:67:0x0193, B:71:0x01ab] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d6  */
    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        int i5;
        int i6;
        double d;
        int i7;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        int i8;
        int i9;
        double[] dArr;
        double[] dArr2;
        int i10;
        int i11;
        int i12;
        double dGuessX;
        double d12;
        double d13;
        double dComputeObjectiveValue;
        double d14;
        int i13;
        int i14;
        double dAbs;
        int i15;
        int i16;
        BracketingNthOrderBrentSolver bracketingNthOrderBrentSolver = this;
        int i17 = bracketingNthOrderBrentSolver.maximalOrder;
        int i18 = i17 + 1;
        double[] dArr3 = new double[i18];
        double[] dArr4 = new double[i17 + 1];
        int i19 = 0;
        dArr3[0] = bracketingNthOrderBrentSolver.getMin();
        dArr3[1] = bracketingNthOrderBrentSolver.getStartValue();
        double max = bracketingNthOrderBrentSolver.getMax();
        dArr3[2] = max;
        bracketingNthOrderBrentSolver.verifySequence(dArr3[0], dArr3[1], max);
        double dComputeObjectiveValue2 = bracketingNthOrderBrentSolver.computeObjectiveValue(dArr3[1]);
        dArr4[1] = dComputeObjectiveValue2;
        if (Precision.equals(dComputeObjectiveValue2, 0.0d, 1)) {
            return dArr3[1];
        }
        double dComputeObjectiveValue3 = bracketingNthOrderBrentSolver.computeObjectiveValue(dArr3[0]);
        dArr4[0] = dComputeObjectiveValue3;
        if (Precision.equals(dComputeObjectiveValue3, 0.0d, 1)) {
            return dArr3[0];
        }
        if (dArr4[0] * dArr4[1] < 0.0d) {
            i5 = 1;
            i6 = 2;
        } else {
            double dComputeObjectiveValue4 = bracketingNthOrderBrentSolver.computeObjectiveValue(dArr3[2]);
            dArr4[2] = dComputeObjectiveValue4;
            if (Precision.equals(dComputeObjectiveValue4, 0.0d, 1)) {
                return dArr3[2];
            }
            if (dArr4[1] * dArr4[2] >= 0.0d) {
                throw new NoBracketingException(dArr3[0], dArr3[2], dArr4[0], dArr4[2]);
            }
            i5 = 2;
            i6 = 3;
        }
        double[] dArr5 = new double[i18];
        int i20 = i5 - 1;
        double d15 = dArr3[i20];
        double d16 = dArr4[i20];
        double dAbs2 = FastMath.abs(d16);
        double d17 = dArr3[i5];
        double d18 = dArr4[i5];
        double d19 = d16;
        double d20 = dAbs2;
        double d21 = d15;
        int i21 = 1;
        double dAbs3 = FastMath.abs(d18);
        int i22 = 0;
        while (true) {
            int i23 = i6;
            d = dAbs3;
            double d22 = d17 - d21;
            if (d22 <= (FastMath.max(FastMath.abs(d21), FastMath.abs(d17)) * bracketingNthOrderBrentSolver.getRelativeAccuracy()) + bracketingNthOrderBrentSolver.getAbsoluteAccuracy()) {
                break;
            }
            if (FastMath.max(d20, d) < bracketingNthOrderBrentSolver.getFunctionValueAccuracy()) {
                d = d;
                break;
            }
            if (i19 >= 2) {
                i7 = i5;
                d7 = (i21 << (i19 - 2)) - 1;
                d8 = i19 - 1;
                d9 = d7 * d19;
                d10 = REDUCTION_FACTOR * d8 * d18;
            } else {
                i7 = i5;
                if (i22 >= 2) {
                    d7 = i22 - 1;
                    d8 = (i21 << (i22 - 2)) - 1;
                    d9 = d8 * d18;
                    d10 = REDUCTION_FACTOR * d7 * d19;
                } else {
                    d6 = 0.0d;
                }
                d11 = d20;
                i8 = i23;
                i9 = 0;
                while (true) {
                    System.arraycopy(dArr3, i9, dArr5, i9, i8 - i9);
                    bracketingNthOrderBrentSolver = this;
                    dArr = dArr5;
                    dArr2 = dArr4;
                    i10 = i7;
                    i11 = i23;
                    i12 = i17;
                    dGuessX = bracketingNthOrderBrentSolver.guessX(d6, dArr, dArr2, i9, i8);
                    if (dGuessX > d21 || dGuessX >= d17) {
                        if (i10 - i9 >= i8 - i10) {
                            i9++;
                        } else {
                            i8--;
                        }
                        d12 = Double.NaN;
                    } else {
                        d12 = dGuessX;
                    }
                    if (Double.isNaN(d12) || i8 - i9 <= (i16 = i21)) {
                        break;
                        break;
                    }
                    i21 = i16;
                    i23 = i11;
                    i17 = i12;
                    d6 = d6;
                    i7 = i10;
                    dArr4 = dArr2;
                    dArr5 = dArr;
                }
                if (Double.isNaN(d12)) {
                    d13 = (d22 * 0.5d) + d21;
                    i9 = i10 - 1;
                    i8 = i10;
                } else {
                    d13 = d12;
                }
                dComputeObjectiveValue = bracketingNthOrderBrentSolver.computeObjectiveValue(d13);
                d14 = d13;
                if (Precision.equals(dComputeObjectiveValue, 0.0d, 1)) {
                    return d14;
                }
                if (i11 <= 2 && (i15 = i8 - i9) != i11) {
                    System.arraycopy(dArr3, i9, dArr3, 0, i15);
                    System.arraycopy(dArr2, i9, dArr2, 0, i15);
                    i11 = i15;
                    i5 = i10 - i9;
                } else if (i11 == i18) {
                    i13 = i11 - 1;
                    if (i10 >= (i12 + 2) / 2) {
                        System.arraycopy(dArr3, 1, dArr3, 0, i13);
                        System.arraycopy(dArr2, 1, dArr2, 0, i13);
                        i11 = i13;
                        i5 = i10 - 1;
                    } else {
                        i11 = i13;
                        i5 = i10;
                    }
                } else {
                    i5 = i10;
                }
                i14 = i5 + 1;
                int i24 = i11 - i5;
                System.arraycopy(dArr3, i5, dArr3, i14, i24);
                dArr3[i5] = d14;
                System.arraycopy(dArr2, i5, dArr2, i14, i24);
                dArr2[i5] = dComputeObjectiveValue;
                int i25 = i11 + 1;
                if (dComputeObjectiveValue * d19 <= 0.0d) {
                    i19++;
                    d18 = dComputeObjectiveValue;
                    d17 = d14;
                    i22 = 0;
                    dAbs3 = FastMath.abs(dComputeObjectiveValue);
                    dAbs = d11;
                } else {
                    dAbs = FastMath.abs(dComputeObjectiveValue);
                    i22++;
                    i5 = i14;
                    d19 = dComputeObjectiveValue;
                    dAbs3 = d;
                    d21 = d14;
                    i19 = 0;
                }
                dArr4 = dArr2;
                i21 = 1;
                dArr5 = dArr;
                i6 = i25;
                d20 = dAbs;
                i17 = i12;
            }
            d6 = (d9 - d10) / (d7 + d8);
            d11 = d20;
            i8 = i23;
            i9 = 0;
            while (true) {
                System.arraycopy(dArr3, i9, dArr5, i9, i8 - i9);
                bracketingNthOrderBrentSolver = this;
                dArr = dArr5;
                dArr2 = dArr4;
                i10 = i7;
                i11 = i23;
                i12 = i17;
                dGuessX = bracketingNthOrderBrentSolver.guessX(d6, dArr, dArr2, i9, i8);
                if (dGuessX > d21) {
                    if (i10 - i9 >= i8 - i10) {
                        i9++;
                    } else {
                        i8--;
                    }
                    d12 = Double.NaN;
                } else {
                    if (i10 - i9 >= i8 - i10) {
                        i9++;
                    } else {
                        i8--;
                    }
                    d12 = Double.NaN;
                }
                if (Double.isNaN(d12)) {
                    break;
                }
                i21 = i16;
                i23 = i11;
                i17 = i12;
                d6 = d6;
                i7 = i10;
                dArr4 = dArr2;
                dArr5 = dArr;
            }
            if (Double.isNaN(d12)) {
                d13 = (d22 * 0.5d) + d21;
                i9 = i10 - 1;
                i8 = i10;
            } else {
                d13 = d12;
            }
            dComputeObjectiveValue = bracketingNthOrderBrentSolver.computeObjectiveValue(d13);
            d14 = d13;
            if (Precision.equals(dComputeObjectiveValue, 0.0d, 1)) {
                return d14;
            }
            if (i11 <= 2) {
                if (i11 == i18) {
                    i13 = i11 - 1;
                    if (i10 >= (i12 + 2) / 2) {
                        System.arraycopy(dArr3, 1, dArr3, 0, i13);
                        System.arraycopy(dArr2, 1, dArr2, 0, i13);
                        i11 = i13;
                        i5 = i10 - 1;
                    } else {
                        i11 = i13;
                        i5 = i10;
                    }
                } else {
                    i5 = i10;
                }
            } else if (i11 == i18) {
                i13 = i11 - 1;
                if (i10 >= (i12 + 2) / 2) {
                    System.arraycopy(dArr3, 1, dArr3, 0, i13);
                    System.arraycopy(dArr2, 1, dArr2, 0, i13);
                    i11 = i13;
                    i5 = i10 - 1;
                } else {
                    i11 = i13;
                    i5 = i10;
                }
            } else {
                i5 = i10;
            }
            i14 = i5 + 1;
            int i26 = i11 - i5;
            System.arraycopy(dArr3, i5, dArr3, i14, i26);
            dArr3[i5] = d14;
            System.arraycopy(dArr2, i5, dArr2, i14, i26);
            dArr2[i5] = dComputeObjectiveValue;
            int i27 = i11 + 1;
            if (dComputeObjectiveValue * d19 <= 0.0d) {
                i19++;
                d18 = dComputeObjectiveValue;
                d17 = d14;
                i22 = 0;
                dAbs3 = FastMath.abs(dComputeObjectiveValue);
                dAbs = d11;
            } else {
                dAbs = FastMath.abs(dComputeObjectiveValue);
                i22++;
                i5 = i14;
                d19 = dComputeObjectiveValue;
                dAbs3 = d;
                d21 = d14;
                i19 = 0;
            }
            dArr4 = dArr2;
            i21 = 1;
            dArr5 = dArr;
            i6 = i27;
            d20 = dAbs;
            i17 = i12;
        }
        double d23 = d20;
        int i28 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[bracketingNthOrderBrentSolver.allowed.ordinal()];
        if (i28 == 1) {
            return d23 < d ? d21 : d17;
        }
        if (i28 != 2) {
            if (i28 != 3) {
                if (i28 != 4) {
                    if (i28 != 5) {
                        throw new MathInternalError();
                    }
                    if (d19 < 0.0d) {
                    }
                } else if (d19 <= 0.0d) {
                }
            }
        }
    }

    public int getMaximalOrder() {
        return this.maximalOrder;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver
    public double solve(int i5, UnivariateFunction univariateFunction, double d, double d6, AllowedSolution allowedSolution) {
        this.allowed = allowedSolution;
        return super.solve(i5, univariateFunction, d, d6);
    }

    public BracketingNthOrderBrentSolver(double d, int i5) {
        super(d);
        if (i5 < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
        }
        this.maximalOrder = i5;
        this.allowed = AllowedSolution.ANY_SIDE;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver
    public double solve(int i5, UnivariateFunction univariateFunction, double d, double d6, double d7, AllowedSolution allowedSolution) {
        this.allowed = allowedSolution;
        return super.solve(i5, univariateFunction, d, d6, d7);
    }

    public BracketingNthOrderBrentSolver(double d, double d6, int i5) {
        super(d, d6);
        if (i5 >= 2) {
            this.maximalOrder = i5;
            this.allowed = AllowedSolution.ANY_SIDE;
            return;
        }
        throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
    }

    public BracketingNthOrderBrentSolver(double d, double d6, double d7, int i5) {
        super(d, d6, d7);
        if (i5 >= 2) {
            this.maximalOrder = i5;
            this.allowed = AllowedSolution.ANY_SIDE;
            return;
        }
        throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
    }
}
