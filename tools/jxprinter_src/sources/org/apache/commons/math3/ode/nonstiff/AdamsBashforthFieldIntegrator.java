package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdamsBashforthFieldIntegrator<T extends RealFieldElement<T>> extends AdamsFieldIntegrator<T> {
    private static final String METHOD_NAME = "Adams-Bashforth";

    public AdamsBashforthFieldIntegrator(Field<T> field, int i5, double d, double d6, double d7, double d8) {
        super(field, METHOD_NAME, i5, i5, d, d6, d7, d8);
    }

    private T errorEstimation(T[] tArr, T[] tArr2, T[] tArr3, FieldMatrix<T> fieldMatrix) {
        T zero = getField().getZero();
        int i5 = 0;
        while (true) {
            int i6 = this.mainSetDimension;
            if (i5 >= i6) {
                return (T) ((RealFieldElement) zero.divide(i6)).sqrt();
            }
            RealFieldElement realFieldElement = (RealFieldElement) tArr2[i5].abs();
            RealFieldElement realFieldElement2 = (RealFieldElement) (this.vecAbsoluteTolerance == null ? ((RealFieldElement) realFieldElement.multiply(this.scalRelativeTolerance)).add(this.scalAbsoluteTolerance) : ((RealFieldElement) realFieldElement.multiply(this.vecRelativeTolerance[i5])).add(this.vecAbsoluteTolerance[i5]));
            T zero2 = getField().getZero();
            int i7 = fieldMatrix.getRowDimension() % 2 == 0 ? -1 : 1;
            for (int rowDimension = fieldMatrix.getRowDimension() - 1; rowDimension >= 0; rowDimension--) {
                zero2 = (T) zero2.add(((RealFieldElement) fieldMatrix.getEntry(rowDimension, i5)).multiply(i7));
                i7 = -i7;
            }
            RealFieldElement realFieldElement3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr2[i5].subtract(tArr[i5])).add((RealFieldElement) zero2.subtract(tArr3[i5]))).divide(realFieldElement2);
            zero = (T) zero.add(realFieldElement3.multiply(realFieldElement3));
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.AdamsFieldIntegrator, org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> fieldExpandableODE, FieldODEState<T> fieldODEState, T t6) {
        sanityChecks(fieldODEState, t6);
        RealFieldElement time = fieldODEState.getTime();
        RealFieldElement[] realFieldElementArrMapState = fieldExpandableODE.getMapper().mapState(fieldODEState);
        setStepStart(initIntegration(fieldExpandableODE, time, realFieldElementArrMapState, t6));
        double d = 0.0d;
        boolean z6 = ((RealFieldElement) t6.subtract(fieldODEState.getTime())).getReal() > 0.0d;
        start(fieldExpandableODE, getStepStart(), t6);
        FieldODEStateAndDerivative<T> stepStart = getStepStart();
        FieldODEStateAndDerivative fieldODEStateAndDerivativeTaylor = AdamsFieldStepInterpolator.taylor(stepStart, (RealFieldElement) stepStart.getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
        setIsLastStep(false);
        while (true) {
            T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), realFieldElementArrMapState.length));
            RealFieldElement realFieldElementErrorEstimation = (RealFieldElement) getField().getZero().add(10.0d);
            FieldODEStateAndDerivative fieldODEStateAndDerivativeTaylor2 = fieldODEStateAndDerivativeTaylor;
            double d6 = d;
            Object state = null;
            Array2DRowFieldMatrix<T> array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1 = null;
            while (((RealFieldElement) realFieldElementErrorEstimation.subtract(1.0d)).getReal() >= d6) {
                state = fieldODEStateAndDerivativeTaylor2.getState();
                T[] tArrComputeDerivatives = computeDerivatives(fieldODEStateAndDerivativeTaylor2.getTime(), state);
                for (int i5 = 0; i5 < tArr.length; i5++) {
                    tArr[i5] = (RealFieldElement) getStepSize().multiply(tArrComputeDerivatives[i5]);
                }
                array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1 = updateHighOrderDerivativesPhase1(this.nordsieck);
                updateHighOrderDerivativesPhase2(this.scaled, tArr, array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1);
                realFieldElementErrorEstimation = errorEstimation(realFieldElementArrMapState, state, tArr, array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1);
                if (((RealFieldElement) realFieldElementErrorEstimation.subtract(1.0d)).getReal() >= d6) {
                    rescale(filterStep((RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(realFieldElementErrorEstimation)), z6, false));
                    fieldODEStateAndDerivativeTaylor2 = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
                }
            }
            setStepStart(acceptStep(new AdamsFieldStepInterpolator(getStepSize(), fieldODEStateAndDerivativeTaylor2, tArr, array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1, z6, getStepStart(), fieldODEStateAndDerivativeTaylor2, fieldExpandableODE.getMapper()), t6));
            this.scaled = tArr;
            this.nordsieck = array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1;
            if (isLastStep()) {
                fieldODEStateAndDerivativeTaylor = fieldODEStateAndDerivativeTaylor2;
            } else {
                System.arraycopy(state, 0, realFieldElementArrMapState, 0, realFieldElementArrMapState.length);
                if (resetOccurred()) {
                    start(fieldExpandableODE, getStepStart(), t6);
                }
                RealFieldElement realFieldElement = (RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(realFieldElementErrorEstimation));
                double real = ((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(realFieldElement)).subtract(t6)).getReal();
                T tFilterStep = filterStep(realFieldElement, z6, !z6 ? real > d6 : real < d6);
                double real2 = ((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(tFilterStep)).subtract(t6)).getReal();
                if (!z6 ? real2 <= d6 : real2 >= d6) {
                    tFilterStep = (T) t6.subtract(getStepStart().getTime());
                }
                rescale(tFilterStep);
                fieldODEStateAndDerivativeTaylor = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
            }
            if (isLastStep()) {
                FieldODEStateAndDerivative<T> stepStart2 = getStepStart();
                setStepStart(null);
                setStepSize(null);
                return stepStart2;
            }
            d = d6;
        }
    }

    public AdamsBashforthFieldIntegrator(Field<T> field, int i5, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, METHOD_NAME, i5, i5, d, d6, dArr, dArr2);
    }
}
