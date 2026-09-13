package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdamsBashforthIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Bashforth";

    public AdamsBashforthIntegrator(int i5, double d, double d6, double d7, double d8) {
        super(METHOD_NAME, i5, i5, d, d6, d7, d8);
    }

    private double errorEstimation(double[] dArr, double[] dArr2, double[] dArr3, RealMatrix realMatrix) {
        int i5 = 0;
        double d = 0.0d;
        while (true) {
            int i6 = this.mainSetDimension;
            if (i5 >= i6) {
                return FastMath.sqrt(d / ((double) i6));
            }
            double dAbs = FastMath.abs(dArr2[i5]);
            double[] dArr4 = this.vecAbsoluteTolerance;
            double d6 = dArr4 == null ? (this.scalRelativeTolerance * dAbs) + this.scalAbsoluteTolerance : (this.vecRelativeTolerance[i5] * dAbs) + dArr4[i5];
            int i7 = realMatrix.getRowDimension() % 2 == 0 ? -1 : 1;
            double entry = 0.0d;
            for (int rowDimension = realMatrix.getRowDimension() - 1; rowDimension >= 0; rowDimension--) {
                entry = (realMatrix.getEntry(rowDimension, i5) * ((double) i7)) + entry;
                i7 = -i7;
            }
            double d7 = ((dArr2[i5] - dArr[i5]) + (entry - dArr3[i5])) / d6;
            d += d7 * d7;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdamsIntegrator, org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE expandableStatefulODE, double d) {
        double d6;
        boolean z6;
        sanityChecks(expandableStatefulODE, d);
        setEquations(expandableStatefulODE);
        boolean z7 = false;
        boolean z8 = d > expandableStatefulODE.getTime();
        double[] completeState = expandableStatefulODE.getCompleteState();
        double[] dArr = new double[completeState.length];
        NordsieckStepInterpolator nordsieckStepInterpolator = new NordsieckStepInterpolator();
        nordsieckStepInterpolator.reinitialize(completeState, z8, expandableStatefulODE.getPrimaryMapper(), expandableStatefulODE.getSecondaryMappers());
        initIntegration(expandableStatefulODE.getTime(), completeState, d);
        start(expandableStatefulODE.getTime(), completeState, d);
        nordsieckStepInterpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
        nordsieckStepInterpolator.storeTime(this.stepStart);
        double dFilterStep = this.stepSize;
        nordsieckStepInterpolator.rescale(dFilterStep);
        this.isLastStep = false;
        while (true) {
            nordsieckStepInterpolator.shift();
            double[] dArr2 = new double[completeState.length];
            int length = completeState.length;
            double[] dArr3 = new double[length];
            double d7 = 10.0d;
            double d8 = dFilterStep;
            Array2DRowRealMatrix array2DRowRealMatrix = null;
            while (true) {
                d6 = d7;
                if (d6 < 1.0d) {
                    break;
                }
                double d9 = this.stepStart + d8;
                nordsieckStepInterpolator.storeTime(d9);
                ExpandableStatefulODE expandable = getExpandable();
                expandable.getPrimaryMapper().insertEquationData(nordsieckStepInterpolator.getInterpolatedState(), dArr2);
                EquationsMapper[] secondaryMappers = expandable.getSecondaryMappers();
                int i5 = 0;
                int i6 = 0;
                for (int length2 = secondaryMappers.length; i6 < length2; length2 = length2) {
                    secondaryMappers[i6].insertEquationData(nordsieckStepInterpolator.getInterpolatedSecondaryState(i5), dArr2);
                    i5++;
                    i6++;
                }
                computeDerivatives(d9, dArr2, dArr);
                for (int i7 = 0; i7 < length; i7++) {
                    dArr3[i7] = dArr[i7] * d8;
                }
                Array2DRowRealMatrix array2DRowRealMatrixUpdateHighOrderDerivativesPhase1 = updateHighOrderDerivativesPhase1(this.nordsieck);
                updateHighOrderDerivativesPhase2(this.scaled, dArr3, array2DRowRealMatrixUpdateHighOrderDerivativesPhase1);
                double dErrorEstimation = errorEstimation(completeState, dArr2, dArr3, array2DRowRealMatrixUpdateHighOrderDerivativesPhase1);
                if (dErrorEstimation >= 1.0d) {
                    z6 = false;
                    double dFilterStep2 = filterStep(computeStepGrowShrinkFactor(dErrorEstimation) * d8, z8, false);
                    nordsieckStepInterpolator.rescale(dFilterStep2);
                    d8 = dFilterStep2;
                } else {
                    z6 = false;
                }
                array2DRowRealMatrix = array2DRowRealMatrixUpdateHighOrderDerivativesPhase1;
                d7 = dErrorEstimation;
                z7 = z6;
            }
            this.stepSize = d8;
            double d10 = this.stepStart + d8;
            nordsieckStepInterpolator.reinitialize(d10, d8, dArr3, array2DRowRealMatrix);
            double d11 = d8;
            nordsieckStepInterpolator.storeTime(d10);
            System.arraycopy(dArr2, 0, completeState, 0, completeState.length);
            boolean z9 = z8;
            double[] dArr4 = completeState;
            double[] dArr5 = dArr;
            NordsieckStepInterpolator nordsieckStepInterpolator2 = nordsieckStepInterpolator;
            double dAcceptStep = acceptStep(nordsieckStepInterpolator2, dArr4, dArr5, d);
            completeState = dArr4;
            this.stepStart = dAcceptStep;
            this.scaled = dArr3;
            this.nordsieck = array2DRowRealMatrix;
            nordsieckStepInterpolator = nordsieckStepInterpolator2;
            nordsieckStepInterpolator.reinitialize(d10, this.stepSize, dArr3, array2DRowRealMatrix);
            if (this.isLastStep) {
                z9 = z9;
                dFilterStep = d11;
            } else {
                nordsieckStepInterpolator.storeTime(this.stepStart);
                if (this.resetOccurred) {
                    start(this.stepStart, completeState, d);
                    nordsieckStepInterpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
                }
                double dComputeStepGrowShrinkFactor = this.stepSize * computeStepGrowShrinkFactor(d6);
                double d12 = this.stepStart + dComputeStepGrowShrinkFactor;
                dFilterStep = filterStep(dComputeStepGrowShrinkFactor, z9, !z9 ? d12 > d : d12 < d);
                double d13 = this.stepStart;
                double d14 = d13 + dFilterStep;
                if (z9 == 0 ? d14 <= d : d14 >= d) {
                    dFilterStep = d - d13;
                }
                nordsieckStepInterpolator.rescale(dFilterStep);
            }
            if (this.isLastStep) {
                expandableStatefulODE.setTime(this.stepStart);
                expandableStatefulODE.setCompleteState(completeState);
                resetInternalState();
                return;
            } else {
                z8 = z9;
                dArr = dArr5;
                z7 = false;
            }
        }
    }

    public AdamsBashforthIntegrator(int i5, double d, double d6, double[] dArr, double[] dArr2) {
        super(METHOD_NAME, i5, i5, d, d6, dArr, dArr2);
    }
}
