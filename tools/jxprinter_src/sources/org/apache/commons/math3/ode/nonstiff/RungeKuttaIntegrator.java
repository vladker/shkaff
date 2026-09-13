package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RungeKuttaIntegrator extends AbstractIntegrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[][] f6864a;
    private final double[] b;
    private final double[] c;
    private final RungeKuttaStepInterpolator prototype;
    private final double step;

    public RungeKuttaIntegrator(String str, double[] dArr, double[][] dArr2, double[] dArr3, RungeKuttaStepInterpolator rungeKuttaStepInterpolator, double d) {
        super(str);
        this.c = dArr;
        this.f6864a = dArr2;
        this.b = dArr3;
        this.prototype = rungeKuttaStepInterpolator;
        this.step = FastMath.abs(d);
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE expandableStatefulODE, double d) {
        sanityChecks(expandableStatefulODE, d);
        setEquations(expandableStatefulODE);
        boolean z6 = d > expandableStatefulODE.getTime();
        double[] completeState = expandableStatefulODE.getCompleteState();
        double[] dArr = (double[]) completeState.clone();
        int length = this.c.length;
        int i5 = length + 1;
        double[][] dArr2 = new double[i5][];
        for (int i6 = 0; i6 < i5; i6++) {
            dArr2[i6] = new double[completeState.length];
        }
        double[] dArr3 = (double[]) completeState.clone();
        double[] dArr4 = new double[completeState.length];
        RungeKuttaStepInterpolator rungeKuttaStepInterpolator = (RungeKuttaStepInterpolator) this.prototype.copy();
        rungeKuttaStepInterpolator.reinitialize(this, dArr3, dArr2, z6, expandableStatefulODE.getPrimaryMapper(), expandableStatefulODE.getSecondaryMappers());
        boolean z7 = z6;
        rungeKuttaStepInterpolator.storeTime(expandableStatefulODE.getTime());
        double time = expandableStatefulODE.getTime();
        this.stepStart = time;
        if (z7) {
            double d6 = this.step;
            if (time + d6 >= d) {
                this.stepSize = d - time;
            } else {
                this.stepSize = d6;
            }
        } else {
            double d7 = this.step;
            if (time - d7 <= d) {
                this.stepSize = d - time;
            } else {
                this.stepSize = -d7;
            }
        }
        double[] dArr5 = dArr3;
        RungeKuttaStepInterpolator rungeKuttaStepInterpolator2 = rungeKuttaStepInterpolator;
        initIntegration(expandableStatefulODE.getTime(), completeState, d);
        RungeKuttaIntegrator rungeKuttaIntegrator = this;
        int i7 = 0;
        rungeKuttaIntegrator.isLastStep = false;
        while (true) {
            rungeKuttaStepInterpolator2.shift();
            rungeKuttaIntegrator.computeDerivatives(rungeKuttaIntegrator.stepStart, dArr, dArr2[i7]);
            int i8 = 1;
            while (i8 < i5) {
                int i9 = i7;
                while (i9 < completeState.length) {
                    int i10 = i8 - 1;
                    double d8 = rungeKuttaIntegrator.f6864a[i10][i7] * dArr2[i7][i9];
                    for (int i11 = 1; i11 < i8; i11++) {
                        d8 = (rungeKuttaIntegrator.f6864a[i10][i11] * dArr2[i11][i9]) + d8;
                    }
                    int i12 = i9;
                    dArr5[i12] = (rungeKuttaIntegrator.stepSize * d8) + dArr[i9];
                    i9 = i12 + 1;
                    i8 = i8;
                    i7 = 0;
                }
                int i13 = i8;
                rungeKuttaIntegrator.computeDerivatives((rungeKuttaIntegrator.c[i13 - 1] * rungeKuttaIntegrator.stepSize) + rungeKuttaIntegrator.stepStart, dArr5, dArr2[i13]);
                i8 = i13 + 1;
                i7 = 0;
            }
            for (int i14 = 0; i14 < completeState.length; i14++) {
                double d9 = rungeKuttaIntegrator.b[0] * dArr2[0][i14];
                for (int i15 = 1; i15 < i5; i15++) {
                    d9 = (rungeKuttaIntegrator.b[i15] * dArr2[i15][i14]) + d9;
                }
                dArr5[i14] = (rungeKuttaIntegrator.stepSize * d9) + dArr[i14];
            }
            rungeKuttaStepInterpolator2.storeTime(rungeKuttaIntegrator.stepStart + rungeKuttaIntegrator.stepSize);
            System.arraycopy(dArr5, 0, dArr, 0, completeState.length);
            System.arraycopy(dArr2[length], 0, dArr4, 0, completeState.length);
            RungeKuttaIntegrator rungeKuttaIntegrator2 = rungeKuttaIntegrator;
            RungeKuttaStepInterpolator rungeKuttaStepInterpolator3 = rungeKuttaStepInterpolator2;
            double[] dArr6 = dArr;
            double[] dArr7 = dArr4;
            double[] dArr8 = dArr5;
            double dAcceptStep = rungeKuttaIntegrator2.acceptStep(rungeKuttaStepInterpolator3, dArr6, dArr7, d);
            rungeKuttaIntegrator2.stepStart = dAcceptStep;
            if (!rungeKuttaIntegrator2.isLastStep) {
                rungeKuttaStepInterpolator3.storeTime(dAcceptStep);
                double d10 = rungeKuttaIntegrator2.stepStart;
                double d11 = rungeKuttaIntegrator2.stepSize + d10;
                if (!z7 ? d11 <= d : d11 >= d) {
                    rungeKuttaIntegrator2.stepSize = d - d10;
                }
            }
            if (rungeKuttaIntegrator2.isLastStep) {
                expandableStatefulODE.setTime(rungeKuttaIntegrator2.stepStart);
                expandableStatefulODE.setCompleteState(dArr6);
                rungeKuttaIntegrator2.stepStart = Double.NaN;
                rungeKuttaIntegrator2.stepSize = Double.NaN;
                return;
            }
            rungeKuttaStepInterpolator2 = rungeKuttaStepInterpolator3;
            dArr4 = dArr7;
            dArr5 = dArr8;
            rungeKuttaIntegrator = rungeKuttaIntegrator2;
            dArr = dArr6;
            i7 = 0;
        }
    }

    public double[] singleStep(FirstOrderDifferentialEquations firstOrderDifferentialEquations, double d, double[] dArr, double d6) {
        double[] dArr2 = (double[]) dArr.clone();
        int i5 = 1;
        int length = this.c.length + 1;
        double[][] dArr3 = new double[length][];
        for (int i6 = 0; i6 < length; i6++) {
            dArr3[i6] = new double[dArr.length];
        }
        double[] dArr4 = (double[]) dArr.clone();
        double d7 = d6 - d;
        firstOrderDifferentialEquations.computeDerivatives(d, dArr2, dArr3[0]);
        int i7 = 1;
        while (i7 < length) {
            int i8 = 0;
            while (i8 < dArr.length) {
                int i9 = i7 - 1;
                double d8 = this.f6864a[i9][0] * dArr3[0][i8];
                for (int i10 = i5; i10 < i7; i10++) {
                    d8 = (this.f6864a[i9][i10] * dArr3[i10][i8]) + d8;
                }
                dArr4[i8] = (d8 * d7) + dArr2[i8];
                i8++;
                i5 = 1;
            }
            firstOrderDifferentialEquations.computeDerivatives((this.c[i7 - 1] * d7) + d, dArr4, dArr3[i7]);
            i7++;
            i5 = 1;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            double d9 = this.b[0] * dArr3[0][i11];
            for (int i12 = 1; i12 < length; i12++) {
                d9 += this.b[i12] * dArr3[i12][i11];
            }
            dArr2[i11] = (d9 * d7) + dArr2[i11];
        }
        return dArr2;
    }
}
