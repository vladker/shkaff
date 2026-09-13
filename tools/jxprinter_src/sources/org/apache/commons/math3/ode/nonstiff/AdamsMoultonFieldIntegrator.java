package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrixPreservingVisitor;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdamsMoultonFieldIntegrator<T extends RealFieldElement<T>> extends AdamsFieldIntegrator<T> {
    private static final String METHOD_NAME = "Adams-Moulton";

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Corrector implements FieldMatrixPreservingVisitor<T> {
        private final T[] after;
        private final T[] before;
        private final T[] previous;
        private final T[] scaled;

        public Corrector(T[] tArr, T[] tArr2, T[] tArr3) {
            this.previous = tArr;
            this.scaled = tArr2;
            this.after = tArr3;
            this.before = (T[]) ((RealFieldElement[]) tArr3.clone());
        }

        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
            Arrays.fill(this.after, AdamsMoultonFieldIntegrator.this.getField().getZero());
        }

        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public T end() {
            RealFieldElement realFieldElement = (RealFieldElement) AdamsMoultonFieldIntegrator.this.getField().getZero();
            int i5 = 0;
            while (true) {
                FieldElement[] fieldElementArr = this.after;
                if (i5 >= fieldElementArr.length) {
                    return (T) ((RealFieldElement) realFieldElement.divide(AdamsMoultonFieldIntegrator.this.mainSetDimension)).sqrt();
                }
                fieldElementArr[i5] = (RealFieldElement) fieldElementArr[i5].add(this.previous[i5].add(this.scaled[i5]));
                if (i5 < AdamsMoultonFieldIntegrator.this.mainSetDimension) {
                    RealFieldElement realFieldElementMax = MathUtils.max((RealFieldElement) this.previous[i5].abs(), (RealFieldElement) this.after[i5].abs());
                    AdamsMoultonFieldIntegrator adamsMoultonFieldIntegrator = AdamsMoultonFieldIntegrator.this;
                    RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) this.after[i5].subtract(this.before[i5])).divide((RealFieldElement) (adamsMoultonFieldIntegrator.vecAbsoluteTolerance == null ? ((RealFieldElement) realFieldElementMax.multiply(adamsMoultonFieldIntegrator.scalRelativeTolerance)).add(AdamsMoultonFieldIntegrator.this.scalAbsoluteTolerance) : ((RealFieldElement) realFieldElementMax.multiply(adamsMoultonFieldIntegrator.vecRelativeTolerance[i5])).add(AdamsMoultonFieldIntegrator.this.vecAbsoluteTolerance[i5])));
                    realFieldElement = (RealFieldElement) realFieldElement.add(realFieldElement2.multiply(realFieldElement2));
                }
                i5++;
            }
        }

        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void visit(int i5, int i6, T t6) {
            if ((i5 & 1) == 0) {
                FieldElement[] fieldElementArr = this.after;
                fieldElementArr[i6] = (RealFieldElement) fieldElementArr[i6].subtract(t6);
            } else {
                FieldElement[] fieldElementArr2 = this.after;
                fieldElementArr2[i6] = (RealFieldElement) fieldElementArr2[i6].add(t6);
            }
        }
    }

    public AdamsMoultonFieldIntegrator(Field<T> field, int i5, double d, double d6, double d7, double d8) {
        super(field, METHOD_NAME, i5, i5 + 1, d, d6, d7, d8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4, types: [org.apache.commons.math3.RealFieldElement[]] */
    /* JADX WARN: Type inference failed for: r2v10, types: [org.apache.commons.math3.RealFieldElement] */
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
            RealFieldElement[] realFieldElementArr = (RealFieldElement[]) MathArrays.buildArray(getField(), realFieldElementArrMapState.length);
            T tWalkInOptimizedOrder = (T) getField().getZero().add(10.0d);
            double d6 = d;
            RealFieldElement[] state = 0;
            Array2DRowFieldMatrix<T> array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1 = null;
            while (((RealFieldElement) tWalkInOptimizedOrder.subtract(1.0d)).getReal() >= d6) {
                state = fieldODEStateAndDerivativeTaylor.getState();
                T[] tArrComputeDerivatives = computeDerivatives(fieldODEStateAndDerivativeTaylor.getTime(), state);
                for (int i5 = 0; i5 < realFieldElementArr.length; i5++) {
                    realFieldElementArr[i5] = (RealFieldElement) getStepSize().multiply(tArrComputeDerivatives[i5]);
                }
                array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1 = updateHighOrderDerivativesPhase1(this.nordsieck);
                updateHighOrderDerivativesPhase2(this.scaled, realFieldElementArr, array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1);
                tWalkInOptimizedOrder = array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1.walkInOptimizedOrder(new Corrector(realFieldElementArrMapState, realFieldElementArr, state));
                if (((RealFieldElement) tWalkInOptimizedOrder.subtract(1.0d)).getReal() >= d6) {
                    rescale(filterStep((RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(tWalkInOptimizedOrder)), z6, false));
                    fieldODEStateAndDerivativeTaylor = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
                }
            }
            T[] tArrComputeDerivatives2 = computeDerivatives(fieldODEStateAndDerivativeTaylor.getTime(), state);
            T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), realFieldElementArrMapState.length));
            for (int i6 = 0; i6 < tArr.length; i6++) {
                tArr[i6] = (RealFieldElement) getStepSize().multiply(tArrComputeDerivatives2[i6]);
            }
            updateHighOrderDerivativesPhase2(realFieldElementArr, tArr, array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1);
            FieldODEStateAndDerivative fieldODEStateAndDerivative = new FieldODEStateAndDerivative(fieldODEStateAndDerivativeTaylor.getTime(), state, tArrComputeDerivatives2);
            T t7 = tWalkInOptimizedOrder;
            Object[] objArr = state;
            setStepStart(acceptStep(new AdamsFieldStepInterpolator(getStepSize(), fieldODEStateAndDerivative, tArr, array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1, z6, getStepStart(), fieldODEStateAndDerivative, fieldExpandableODE.getMapper()), t6));
            this.scaled = tArr;
            this.nordsieck = array2DRowFieldMatrixUpdateHighOrderDerivativesPhase1;
            if (isLastStep()) {
                fieldODEStateAndDerivativeTaylor = fieldODEStateAndDerivative;
            } else {
                System.arraycopy(objArr, 0, realFieldElementArrMapState, 0, realFieldElementArrMapState.length);
                if (resetOccurred()) {
                    start(fieldExpandableODE, getStepStart(), t6);
                }
                RealFieldElement realFieldElement = (RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(t7));
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

    public AdamsMoultonFieldIntegrator(Field<T> field, int i5, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, METHOD_NAME, i5, i5 + 1, d, d6, dArr, dArr2);
    }
}
