package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.RealFieldUnivariateFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldBracketingNthOrderBrentSolver<T extends RealFieldElement<T>> implements BracketedRealFieldUnivariateSolver<T> {
    private static final int MAXIMAL_AGING = 2;
    private final T absoluteAccuracy;
    private IntegerSequence.Incrementor evaluations;
    private final Field<T> field;
    private final T functionValueAccuracy;
    private final int maximalOrder;
    private final T relativeAccuracy;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver$1, reason: invalid class name */
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

    public FieldBracketingNthOrderBrentSolver(T t6, T t7, T t8, int i5) {
        if (i5 < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
        }
        this.field = t6.getField();
        this.maximalOrder = i5;
        this.absoluteAccuracy = t7;
        this.relativeAccuracy = t6;
        this.functionValueAccuracy = t8;
        this.evaluations = IntegerSequence.Incrementor.create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T guessX(T t6, T[] tArr, T[] tArr2, int i5, int i6) {
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
                tArr[i7] = (RealFieldElement) ((RealFieldElement) tArr[i7].subtract(tArr[i7 - 1])).divide(tArr2[i7].subtract(tArr2[i7 - i10]));
                i7--;
            }
            i8 = i9;
        }
        T zero = this.field.getZero();
        while (i7 >= i5) {
            zero = (T) tArr[i7].add(zero.multiply(t6.subtract(tArr2[i7])));
            i7--;
        }
        return zero;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T getFunctionValueAccuracy() {
        return this.functionValueAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public int getMaximalOrder() {
        return this.maximalOrder;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T solve(int i5, RealFieldUnivariateFunction<T> realFieldUnivariateFunction, T t6, T t7, AllowedSolution allowedSolution) {
        return (T) solve(i5, realFieldUnivariateFunction, t6, t7, (RealFieldElement) ((RealFieldElement) t6.add(t7)).divide(2.0d), allowedSolution);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public T solve(int i5, RealFieldUnivariateFunction<T> realFieldUnivariateFunction, T t6, T t7, T t8, AllowedSolution allowedSolution) {
        int i6;
        int i7;
        RealFieldElement realFieldElement;
        RealFieldElement realFieldElement2;
        RealFieldElement[] realFieldElementArr;
        int i8;
        int i9;
        int i10;
        int i11;
        RealFieldElement realFieldElement3;
        RealFieldElement realFieldElement4;
        T tGuessX;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        FieldBracketingNthOrderBrentSolver<T> fieldBracketingNthOrderBrentSolver = this;
        MathUtils.checkNotNull(realFieldUnivariateFunction);
        fieldBracketingNthOrderBrentSolver.evaluations = fieldBracketingNthOrderBrentSolver.evaluations.withMaximalCount(i5).withStart(0);
        T zero = fieldBracketingNthOrderBrentSolver.field.getZero();
        RealFieldElement realFieldElement5 = (RealFieldElement) zero.add(Double.NaN);
        RealFieldElement[] realFieldElementArr2 = (RealFieldElement[]) MathArrays.buildArray(fieldBracketingNthOrderBrentSolver.field, fieldBracketingNthOrderBrentSolver.maximalOrder + 1);
        RealFieldElement[] realFieldElementArr3 = (RealFieldElement[]) MathArrays.buildArray(fieldBracketingNthOrderBrentSolver.field, fieldBracketingNthOrderBrentSolver.maximalOrder + 1);
        realFieldElementArr2[0] = t6;
        realFieldElementArr2[1] = t8;
        realFieldElementArr2[2] = t7;
        fieldBracketingNthOrderBrentSolver.evaluations.increment();
        RealFieldElement realFieldElementValue = realFieldUnivariateFunction.value(realFieldElementArr2[1]);
        realFieldElementArr3[1] = realFieldElementValue;
        if (Precision.equals(realFieldElementValue.getReal(), 0.0d, 1)) {
            return (T) realFieldElementArr2[1];
        }
        fieldBracketingNthOrderBrentSolver.evaluations.increment();
        RealFieldElement realFieldElementValue2 = realFieldUnivariateFunction.value(realFieldElementArr2[0]);
        realFieldElementArr3[0] = realFieldElementValue2;
        if (Precision.equals(realFieldElementValue2.getReal(), 0.0d, 1)) {
            return (T) realFieldElementArr2[0];
        }
        if (((RealFieldElement) realFieldElementArr3[0].multiply(realFieldElementArr3[1])).getReal() < 0.0d) {
            i6 = 1;
            i7 = 2;
        } else {
            fieldBracketingNthOrderBrentSolver.evaluations.increment();
            RealFieldElement realFieldElementValue3 = realFieldUnivariateFunction.value(realFieldElementArr2[2]);
            realFieldElementArr3[2] = realFieldElementValue3;
            if (Precision.equals(realFieldElementValue3.getReal(), 0.0d, 1)) {
                return (T) realFieldElementArr2[2];
            }
            if (((RealFieldElement) realFieldElementArr3[1].multiply(realFieldElementArr3[2])).getReal() >= 0.0d) {
                throw new NoBracketingException(realFieldElementArr2[0].getReal(), realFieldElementArr2[2].getReal(), realFieldElementArr3[0].getReal(), realFieldElementArr3[2].getReal());
            }
            i6 = 2;
            i7 = 3;
        }
        RealFieldElement[] realFieldElementArr4 = (RealFieldElement[]) MathArrays.buildArray(fieldBracketingNthOrderBrentSolver.field, realFieldElementArr2.length);
        int i17 = i6 - 1;
        RealFieldElement realFieldElement6 = realFieldElementArr2[i17];
        RealFieldElement realFieldElementValue4 = realFieldElementArr3[i17];
        RealFieldElement realFieldElement7 = (RealFieldElement) realFieldElement6.abs();
        RealFieldElement realFieldElement8 = (RealFieldElement) realFieldElementValue4.abs();
        RealFieldElement realFieldElement9 = realFieldElementArr2[i6];
        RealFieldElement realFieldElement10 = realFieldElementArr3[i6];
        RealFieldElement realFieldElement11 = (RealFieldElement) realFieldElement9.abs();
        double d = 0.0d;
        RealFieldElement realFieldElement12 = realFieldElement6;
        RealFieldElement realFieldElement13 = realFieldElement8;
        T t9 = (T) realFieldElement9;
        RealFieldElement realFieldElement14 = realFieldElement10;
        RealFieldElement realFieldElement15 = (RealFieldElement) realFieldElement10.abs();
        int i18 = 0;
        int i19 = 0;
        while (true) {
            RealFieldElement realFieldElement16 = ((RealFieldElement) realFieldElement7.subtract(realFieldElement11)).getReal() < d ? realFieldElement11 : realFieldElement7;
            RealFieldElement realFieldElement17 = ((RealFieldElement) realFieldElement13.subtract(realFieldElement15)).getReal() < d ? realFieldElement15 : realFieldElement13;
            RealFieldElement[] realFieldElementArr5 = realFieldElementArr3;
            RealFieldElement realFieldElement18 = realFieldElement11;
            if (((RealFieldElement) ((RealFieldElement) t9.subtract(realFieldElement12)).subtract((RealFieldElement) fieldBracketingNthOrderBrentSolver.absoluteAccuracy.add(fieldBracketingNthOrderBrentSolver.relativeAccuracy.multiply(realFieldElement16)))).getReal() <= d || ((RealFieldElement) realFieldElement17.subtract(fieldBracketingNthOrderBrentSolver.functionValueAccuracy)).getReal() < d) {
                break;
            }
            if (i18 >= 2) {
                realFieldElement = realFieldElement14;
                realFieldElement2 = (RealFieldElement) ((RealFieldElement) realFieldElement.divide(16.0d)).negate();
            } else {
                realFieldElement = realFieldElement14;
                realFieldElement2 = i19 >= 2 ? (RealFieldElement) ((RealFieldElement) realFieldElementValue4.divide(16.0d)).negate() : zero;
            }
            RealFieldElement realFieldElement19 = realFieldElementValue4;
            int i20 = i7;
            int i21 = 0;
            while (true) {
                System.arraycopy(realFieldElementArr2, i21, realFieldElementArr4, i21, i20 - i21);
                realFieldElementArr = realFieldElementArr4;
                int i22 = i21;
                realFieldElement14 = realFieldElement;
                i8 = i6;
                i9 = i18;
                i10 = i7;
                i11 = i19;
                realFieldElement3 = realFieldElement19;
                realFieldElementArr3 = realFieldElementArr5;
                realFieldElement4 = realFieldElement7;
                tGuessX = guessX(realFieldElement2, realFieldElementArr, realFieldElementArr3, i22, i20);
                if (((RealFieldElement) tGuessX.subtract(realFieldElement12)).getReal() <= d || ((RealFieldElement) tGuessX.subtract(t9)).getReal() >= d) {
                    if (i8 - i22 >= i20 - i8) {
                        i12 = i22 + 1;
                    } else {
                        i20--;
                        i12 = i22;
                    }
                    tGuessX = realFieldElement5;
                } else {
                    i12 = i22;
                }
                if (!Double.isNaN(tGuessX.getReal())) {
                    i13 = i12;
                    break;
                }
                i13 = i12;
                if (i20 - i12 <= 1) {
                    break;
                }
                realFieldElementArr4 = realFieldElementArr;
                realFieldElement7 = realFieldElement4;
                realFieldElement2 = realFieldElement2;
                i21 = i13;
                realFieldElementArr5 = realFieldElementArr3;
                realFieldElement19 = realFieldElement3;
                i19 = i11;
                i7 = i10;
                i18 = i9;
                i6 = i8;
                realFieldElement = realFieldElement14;
            }
            if (Double.isNaN(tGuessX.getReal())) {
                tGuessX = (T) realFieldElement12.add(((RealFieldElement) t9.subtract(realFieldElement12)).divide(2.0d));
                i15 = i8 - 1;
                i14 = i8;
            } else {
                i14 = i20;
                i15 = i13;
            }
            this.evaluations.increment();
            realFieldElementValue4 = realFieldUnivariateFunction.value(tGuessX);
            int i23 = i14;
            RealFieldElement realFieldElement20 = realFieldElement15;
            RealFieldElement realFieldElement21 = realFieldElement12;
            if (Precision.equals(realFieldElementValue4.getReal(), d, 1)) {
                return (T) tGuessX;
            }
            if (i10 > 2 && (i16 = i23 - i15) != i10) {
                System.arraycopy(realFieldElementArr2, i15, realFieldElementArr2, 0, i16);
                System.arraycopy(realFieldElementArr3, i15, realFieldElementArr3, 0, i16);
                i6 = i8 - i15;
            } else if (i10 == realFieldElementArr2.length) {
                i16 = i10 - 1;
                if (i8 >= (realFieldElementArr2.length + 1) / 2) {
                    System.arraycopy(realFieldElementArr2, 1, realFieldElementArr2, 0, i16);
                    System.arraycopy(realFieldElementArr3, 1, realFieldElementArr3, 0, i16);
                    i6 = i8 - 1;
                } else {
                    i6 = i8;
                }
            } else {
                i6 = i8;
                i16 = i10;
            }
            int i24 = i6 + 1;
            int i25 = i16 - i6;
            System.arraycopy(realFieldElementArr2, i6, realFieldElementArr2, i24, i25);
            realFieldElementArr2[i6] = tGuessX;
            System.arraycopy(realFieldElementArr3, i6, realFieldElementArr3, i24, i25);
            realFieldElementArr3[i6] = realFieldElementValue4;
            i7 = i16 + 1;
            if (((RealFieldElement) realFieldElementValue4.multiply(realFieldElement3)).getReal() <= 0.0d) {
                i18 = i9 + 1;
                realFieldElement15 = (RealFieldElement) realFieldElementValue4.abs();
                realFieldElement14 = realFieldElementValue4;
                realFieldElementValue4 = realFieldElement3;
                t9 = tGuessX;
                realFieldElement12 = realFieldElement21;
                i19 = 0;
            } else {
                i19 = i11 + 1;
                realFieldElement13 = (RealFieldElement) realFieldElementValue4.abs();
                realFieldElement12 = tGuessX;
                realFieldElement15 = realFieldElement20;
                i18 = 0;
                i6 = i24;
            }
            fieldBracketingNthOrderBrentSolver = this;
            realFieldElement7 = realFieldElement4;
            realFieldElement11 = realFieldElement18;
            realFieldElementArr4 = realFieldElementArr;
            d = 0.0d;
        }
        RealFieldElement realFieldElement22 = realFieldElementValue4;
        RealFieldElement realFieldElement23 = realFieldElement15;
        T t10 = (T) realFieldElement12;
        int i26 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$analysis$solvers$AllowedSolution[allowedSolution.ordinal()];
        if (i26 == 1) {
            return ((RealFieldElement) realFieldElement13.subtract(realFieldElement23)).getReal() < 0.0d ? t10 : t9;
        }
        if (i26 != 2) {
            if (i26 != 3) {
                if (i26 != 4) {
                    if (i26 != 5) {
                        throw new MathInternalError(null);
                    }
                    if (realFieldElement22.getReal() < 0.0d) {
                    }
                } else if (realFieldElement22.getReal() <= 0.0d) {
                }
            }
        }
    }
}
