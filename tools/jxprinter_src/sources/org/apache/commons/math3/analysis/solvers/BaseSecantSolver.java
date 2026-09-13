package org.apache.commons.math3.analysis.solvers;

import androidx.collection.a;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseSecantSolver extends AbstractUnivariateSolver implements BracketedUnivariateSolver<UnivariateFunction> {
    protected static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private AllowedSolution allowed;
    private final Method method;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.BaseSecantSolver$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method;

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
            int[] iArr2 = new int[Method.values().length];
            $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method = iArr2;
            try {
                iArr2[Method.ILLINOIS.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method[Method.PEGASUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method[Method.REGULA_FALSI.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Method {
        REGULA_FALSI,
        ILLINOIS,
        PEGASUS
    }

    public BaseSecantSolver(double d, Method method) {
        super(d);
        this.allowed = AllowedSolution.ANY_SIDE;
        this.method = method;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e7 A[DONT_INVERT, EDGE_INSN: B:62:0x00e7->B:74:0x00fc BREAK  A[LOOP:0: B:9:0x002f->B:75:0x00fd]] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f5 A[DONT_INVERT, EDGE_INSN: B:69:0x00f5->B:74:0x00fc BREAK  A[LOOP:0: B:9:0x002f->B:75:0x00fd]] */
    /* JADX WARN: Code duplicated, block: B:71:0x00f8 A[DONT_INVERT, EDGE_INSN: B:71:0x00f8->B:74:0x00fc BREAK  A[LOOP:0: B:9:0x002f->B:75:0x00fd]] */
    /* JADX WARN: Code duplicated, block: B:73:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x00fd A[LOOP:0: B:9:0x002f->B:75:0x00fd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x00cf A[SYNTHETIC] */
    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public final double doSolve() {
        double d;
        double d6;
        int i5;
        double min = getMin();
        double max = getMax();
        double dComputeObjectiveValue = computeObjectiveValue(min);
        double dComputeObjectiveValue2 = computeObjectiveValue(max);
        double d7 = 0.0d;
        if (dComputeObjectiveValue == 0.0d) {
            return min;
        }
        if (dComputeObjectiveValue2 == 0.0d) {
            return max;
        }
        verifyBracketing(min, max);
        double functionValueAccuracy = getFunctionValueAccuracy();
        double absoluteAccuracy = getAbsoluteAccuracy();
        double relativeAccuracy = getRelativeAccuracy();
        boolean z6 = false;
        while (true) {
            double d8 = d7;
            d = max - (((max - min) * dComputeObjectiveValue2) / (dComputeObjectiveValue2 - dComputeObjectiveValue));
            double dComputeObjectiveValue3 = computeObjectiveValue(d);
            if (dComputeObjectiveValue3 == d8) {
                break;
            }
            double d9 = min;
            if (dComputeObjectiveValue2 * dComputeObjectiveValue3 < d8) {
                min = max;
                z6 = !z6;
                dComputeObjectiveValue = dComputeObjectiveValue2;
            } else {
                int i6 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$BaseSecantSolver$Method[this.method.ordinal()];
                if (i6 == 1) {
                    dComputeObjectiveValue *= 0.5d;
                } else if (i6 == 2) {
                    dComputeObjectiveValue = (dComputeObjectiveValue2 / (dComputeObjectiveValue2 + dComputeObjectiveValue3)) * dComputeObjectiveValue;
                } else {
                    if (i6 != 3) {
                        throw new MathInternalError();
                    }
                    if (d == max) {
                        throw new ConvergenceException();
                    }
                }
                min = d9;
            }
            if (FastMath.abs(dComputeObjectiveValue3) > functionValueAccuracy) {
                d6 = dComputeObjectiveValue;
                if (FastMath.abs(d - min) < FastMath.max(FastMath.abs(d) * relativeAccuracy, absoluteAccuracy)) {
                    i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
                    if (i5 == 1) {
                        break;
                    }
                    if (i5 == 2) {
                        if (z6) {
                            break;
                        }
                        return min;
                    }
                    if (i5 != 3) {
                        if (i5 == 4) {
                            if (dComputeObjectiveValue3 <= d8) {
                                break;
                            }
                            return min;
                        }
                        if (i5 != 5) {
                            throw new MathInternalError();
                        }
                        if (dComputeObjectiveValue3 >= d8) {
                            break;
                        }
                        return min;
                    }
                    if (z6) {
                        return min;
                    }
                } else {
                    max = d;
                    dComputeObjectiveValue2 = dComputeObjectiveValue3;
                    d7 = d8;
                    dComputeObjectiveValue = d6;
                }
            } else {
                int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
                if (i7 == 1) {
                    break;
                }
                if (i7 != 2) {
                    if (i7 != 3) {
                        if (i7 != 4) {
                            if (i7 != 5) {
                                throw new MathInternalError();
                            }
                            if (dComputeObjectiveValue3 >= d8) {
                                break;
                            }
                            d6 = dComputeObjectiveValue;
                            if (FastMath.abs(d - min) < FastMath.max(FastMath.abs(d) * relativeAccuracy, absoluteAccuracy)) {
                                i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
                                if (i5 == 1) {
                                    break;
                                }
                                if (i5 == 2) {
                                    if (z6) {
                                        break;
                                    }
                                    return min;
                                }
                                if (i5 != 3) {
                                    if (i5 == 4) {
                                        if (dComputeObjectiveValue3 <= d8) {
                                            break;
                                        }
                                        return min;
                                    }
                                    if (i5 != 5) {
                                        throw new MathInternalError();
                                    }
                                    if (dComputeObjectiveValue3 >= d8) {
                                        break;
                                    }
                                    return min;
                                }
                                if (z6) {
                                    return min;
                                }
                            } else {
                                max = d;
                                dComputeObjectiveValue2 = dComputeObjectiveValue3;
                                d7 = d8;
                                dComputeObjectiveValue = d6;
                            }
                        } else {
                            if (dComputeObjectiveValue3 <= d8) {
                                break;
                            }
                            d6 = dComputeObjectiveValue;
                            if (FastMath.abs(d - min) < FastMath.max(FastMath.abs(d) * relativeAccuracy, absoluteAccuracy)) {
                                i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
                                if (i5 == 1) {
                                    break;
                                }
                                if (i5 == 2) {
                                    if (z6) {
                                        break;
                                    }
                                    return min;
                                }
                                if (i5 != 3) {
                                    if (i5 == 4) {
                                        if (dComputeObjectiveValue3 <= d8) {
                                            break;
                                        }
                                        return min;
                                    }
                                    if (i5 != 5) {
                                        throw new MathInternalError();
                                    }
                                    if (dComputeObjectiveValue3 >= d8) {
                                        break;
                                    }
                                    return min;
                                }
                                if (z6) {
                                    return min;
                                }
                            } else {
                                max = d;
                                dComputeObjectiveValue2 = dComputeObjectiveValue3;
                                d7 = d8;
                                dComputeObjectiveValue = d6;
                            }
                        }
                    } else {
                        if (!z6) {
                            break;
                        }
                        d6 = dComputeObjectiveValue;
                        if (FastMath.abs(d - min) < FastMath.max(FastMath.abs(d) * relativeAccuracy, absoluteAccuracy)) {
                            i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
                            if (i5 == 1) {
                                break;
                            }
                            if (i5 == 2) {
                                if (z6) {
                                    break;
                                }
                                return min;
                            }
                            if (i5 != 3) {
                                if (i5 == 4) {
                                    if (dComputeObjectiveValue3 <= d8) {
                                        break;
                                    }
                                    return min;
                                }
                                if (i5 != 5) {
                                    throw new MathInternalError();
                                }
                                if (dComputeObjectiveValue3 >= d8) {
                                    break;
                                }
                                return min;
                            }
                            if (z6) {
                                return min;
                            }
                        } else {
                            max = d;
                            dComputeObjectiveValue2 = dComputeObjectiveValue3;
                            d7 = d8;
                            dComputeObjectiveValue = d6;
                        }
                    }
                } else {
                    if (z6) {
                        break;
                    }
                    d6 = dComputeObjectiveValue;
                    if (FastMath.abs(d - min) < FastMath.max(FastMath.abs(d) * relativeAccuracy, absoluteAccuracy)) {
                        i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[this.allowed.ordinal()];
                        if (i5 == 1) {
                            break;
                        }
                        if (i5 == 2) {
                            if (z6) {
                                break;
                            }
                            return min;
                        }
                        if (i5 != 3) {
                            if (i5 == 4) {
                                if (dComputeObjectiveValue3 <= d8) {
                                    break;
                                }
                                return min;
                            }
                            if (i5 != 5) {
                                throw new MathInternalError();
                            }
                            if (dComputeObjectiveValue3 >= d8) {
                                break;
                            }
                            return min;
                        }
                        if (z6) {
                            return min;
                        }
                    } else {
                        max = d;
                        dComputeObjectiveValue2 = dComputeObjectiveValue3;
                        d7 = d8;
                        dComputeObjectiveValue = d6;
                    }
                }
            }
        }
        return d;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver
    public double solve(int i5, UnivariateFunction univariateFunction, double d, double d6, AllowedSolution allowedSolution) {
        return solve(i5, univariateFunction, d, d6, a.a(d6, d, 0.5d, d), allowedSolution);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver
    public double solve(int i5, UnivariateFunction univariateFunction, double d, double d6, double d7, AllowedSolution allowedSolution) {
        this.allowed = allowedSolution;
        return super.solve(i5, univariateFunction, d, d6, d7);
    }

    public BaseSecantSolver(double d, double d6, Method method) {
        super(d, d6);
        this.allowed = AllowedSolution.ANY_SIDE;
        this.method = method;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver, org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int i5, UnivariateFunction univariateFunction, double d, double d6, double d7) {
        return solve(i5, univariateFunction, d, d6, d7, AllowedSolution.ANY_SIDE);
    }

    public BaseSecantSolver(double d, double d6, double d7, Method method) {
        super(d, d6, d7);
        this.allowed = AllowedSolution.ANY_SIDE;
        this.method = method;
    }
}
