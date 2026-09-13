package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrixPreservingVisitor;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdamsMoultonIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Moulton";

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Corrector implements RealMatrixPreservingVisitor {
        private final double[] after;
        private final double[] before;
        private final double[] previous;
        private final double[] scaled;

        public Corrector(double[] dArr, double[] dArr2, double[] dArr3) {
            this.previous = dArr;
            this.scaled = dArr2;
            this.after = dArr3;
            this.before = (double[]) dArr3.clone();
        }

        @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public double end() {
            double d;
            double d6 = 0.0d;
            int i5 = 0;
            while (true) {
                double[] dArr = this.after;
                if (i5 >= dArr.length) {
                    return FastMath.sqrt(d6 / ((double) AdamsMoultonIntegrator.this.mainSetDimension));
                }
                double d7 = dArr[i5];
                double[] dArr2 = this.previous;
                dArr[i5] = dArr2[i5] + this.scaled[i5] + d7;
                if (i5 < AdamsMoultonIntegrator.this.mainSetDimension) {
                    double dMax = FastMath.max(FastMath.abs(dArr2[i5]), FastMath.abs(this.after[i5]));
                    AdamsMoultonIntegrator adamsMoultonIntegrator = AdamsMoultonIntegrator.this;
                    double[] dArr3 = adamsMoultonIntegrator.vecAbsoluteTolerance;
                    if (dArr3 == null) {
                        d = (adamsMoultonIntegrator.scalRelativeTolerance * dMax) + adamsMoultonIntegrator.scalAbsoluteTolerance;
                    } else {
                        d = (adamsMoultonIntegrator.vecRelativeTolerance[i5] * dMax) + dArr3[i5];
                    }
                    double d8 = (this.after[i5] - this.before[i5]) / d;
                    d6 = (d8 * d8) + d6;
                }
                i5++;
            }
        }

        @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
            Arrays.fill(this.after, 0.0d);
        }

        @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public void visit(int i5, int i6, double d) {
            if ((i5 & 1) == 0) {
                double[] dArr = this.after;
                dArr[i6] = dArr[i6] - d;
            } else {
                double[] dArr2 = this.after;
                dArr2[i6] = dArr2[i6] + d;
            }
        }
    }

    public AdamsMoultonIntegrator(int i5, double d, double d6, double d7, double d8) {
        super(METHOD_NAME, i5, i5 + 1, d, d6, d7, d8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdamsIntegrator, org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE expandableStatefulODE, double d) {
        boolean z6;
        sanityChecks(expandableStatefulODE, d);
        setEquations(expandableStatefulODE);
        boolean z7 = d > expandableStatefulODE.getTime();
        double[] completeState = expandableStatefulODE.getCompleteState();
        double[] dArr = (double[]) completeState.clone();
        double[] dArr2 = new double[dArr.length];
        double[] dArr3 = new double[dArr.length];
        double[] dArr4 = new double[dArr.length];
        NordsieckStepInterpolator nordsieckStepInterpolator = new NordsieckStepInterpolator();
        nordsieckStepInterpolator.reinitialize(dArr, z7, expandableStatefulODE.getPrimaryMapper(), expandableStatefulODE.getSecondaryMappers());
        initIntegration(expandableStatefulODE.getTime(), completeState, d);
        double[] dArr5 = dArr;
        start(expandableStatefulODE.getTime(), dArr5, d);
        nordsieckStepInterpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
        nordsieckStepInterpolator.storeTime(this.stepStart);
        double dFilterStep = this.stepSize;
        nordsieckStepInterpolator.rescale(dFilterStep);
        this.isLastStep = false;
        Array2DRowRealMatrix array2DRowRealMatrixUpdateHighOrderDerivativesPhase1 = null;
        while (true) {
            boolean z8 = z7;
            double dWalkInOptimizedOrder = 10.0d;
            while (dWalkInOptimizedOrder >= 1.0d) {
                this.stepSize = dFilterStep;
                double d6 = this.stepStart + dFilterStep;
                nordsieckStepInterpolator.setInterpolatedTime(d6);
                ExpandableStatefulODE expandable = getExpandable();
                expandable.getPrimaryMapper().insertEquationData(nordsieckStepInterpolator.getInterpolatedState(), dArr3);
                EquationsMapper[] secondaryMappers = expandable.getSecondaryMappers();
                int length = secondaryMappers.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    secondaryMappers[i5].insertEquationData(nordsieckStepInterpolator.getInterpolatedSecondaryState(i6), dArr3);
                    i6++;
                    i5++;
                    dFilterStep = dFilterStep;
                }
                double d7 = dFilterStep;
                computeDerivatives(d6, dArr3, dArr2);
                for (int i7 = 0; i7 < completeState.length; i7++) {
                    dArr4[i7] = this.stepSize * dArr2[i7];
                }
                array2DRowRealMatrixUpdateHighOrderDerivativesPhase1 = updateHighOrderDerivativesPhase1(this.nordsieck);
                updateHighOrderDerivativesPhase2(this.scaled, dArr4, array2DRowRealMatrixUpdateHighOrderDerivativesPhase1);
                dWalkInOptimizedOrder = array2DRowRealMatrixUpdateHighOrderDerivativesPhase1.walkInOptimizedOrder(new Corrector(dArr5, dArr4, dArr3));
                if (dWalkInOptimizedOrder >= 1.0d) {
                    z6 = z8;
                    dFilterStep = filterStep(this.stepSize * computeStepGrowShrinkFactor(dWalkInOptimizedOrder), z6, false);
                    nordsieckStepInterpolator.rescale(dFilterStep);
                } else {
                    z6 = z8;
                    dFilterStep = d7;
                }
                z8 = z6;
            }
            double d8 = dFilterStep;
            boolean z9 = z8;
            double d9 = this.stepSize + this.stepStart;
            computeDerivatives(d9, dArr3, dArr2);
            double[] dArr6 = new double[completeState.length];
            for (int i8 = 0; i8 < completeState.length; i8++) {
                dArr6[i8] = this.stepSize * dArr2[i8];
            }
            updateHighOrderDerivativesPhase2(dArr4, dArr6, array2DRowRealMatrixUpdateHighOrderDerivativesPhase1);
            System.arraycopy(dArr3, 0, dArr5, 0, dArr5.length);
            Array2DRowRealMatrix array2DRowRealMatrix = array2DRowRealMatrixUpdateHighOrderDerivativesPhase1;
            nordsieckStepInterpolator.reinitialize(d9, this.stepSize, dArr6, array2DRowRealMatrix);
            double[] dArr7 = dArr2;
            double[] dArr8 = dArr5;
            NordsieckStepInterpolator nordsieckStepInterpolator2 = nordsieckStepInterpolator;
            array2DRowRealMatrixUpdateHighOrderDerivativesPhase1 = array2DRowRealMatrix;
            nordsieckStepInterpolator2.storeTime(this.stepStart);
            nordsieckStepInterpolator2.shift();
            nordsieckStepInterpolator2.storeTime(d9);
            double[] dArr9 = dArr3;
            double dAcceptStep = acceptStep(nordsieckStepInterpolator2, dArr8, dArr7, d);
            dArr5 = dArr8;
            this.stepStart = dAcceptStep;
            this.scaled = dArr6;
            this.nordsieck = array2DRowRealMatrixUpdateHighOrderDerivativesPhase1;
            if (this.isLastStep) {
                array2DRowRealMatrixUpdateHighOrderDerivativesPhase1 = array2DRowRealMatrixUpdateHighOrderDerivativesPhase1;
                nordsieckStepInterpolator = nordsieckStepInterpolator2;
                dFilterStep = d8;
            } else {
                nordsieckStepInterpolator2.storeTime(dAcceptStep);
                if (this.resetOccurred) {
                    start(this.stepStart, dArr5, d);
                    nordsieckStepInterpolator = nordsieckStepInterpolator2;
                    nordsieckStepInterpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
                } else {
                    nordsieckStepInterpolator = nordsieckStepInterpolator2;
                }
                double dComputeStepGrowShrinkFactor = this.stepSize * computeStepGrowShrinkFactor(dWalkInOptimizedOrder);
                double d10 = this.stepStart + dComputeStepGrowShrinkFactor;
                dFilterStep = filterStep(dComputeStepGrowShrinkFactor, z9, !z9 ? d10 > d : d10 < d);
                double d11 = this.stepStart;
                double d12 = d11 + dFilterStep;
                if (!z9 ? d12 <= d : d12 >= d) {
                    dFilterStep = d - d11;
                }
                nordsieckStepInterpolator.rescale(dFilterStep);
            }
            if (this.isLastStep) {
                expandableStatefulODE.setTime(this.stepStart);
                expandableStatefulODE.setCompleteState(dArr5);
                resetInternalState();
                return;
            } else {
                z7 = z9;
                dArr3 = dArr9;
                dArr2 = dArr7;
            }
        }
    }

    public AdamsMoultonIntegrator(int i5, double d, double d6, double[] dArr, double[] dArr2) {
        super(METHOD_NAME, i5, i5 + 1, d, d6, dArr, dArr2);
    }
}
