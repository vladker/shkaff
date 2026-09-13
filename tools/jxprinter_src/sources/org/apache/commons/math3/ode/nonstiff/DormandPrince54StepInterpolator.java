package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class DormandPrince54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double A70 = 0.09114583333333333d;
    private static final double A72 = 0.44923629829290207d;
    private static final double A73 = 0.6510416666666666d;
    private static final double A74 = -0.322376179245283d;
    private static final double A75 = 0.13095238095238096d;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    private static final double f6847D0 = -1.1270175653862835d;

    /* JADX INFO: renamed from: D2, reason: collision with root package name */
    private static final double f6848D2 = 2.675424484351598d;

    /* JADX INFO: renamed from: D3, reason: collision with root package name */
    private static final double f6849D3 = -5.685526961588504d;

    /* JADX INFO: renamed from: D4, reason: collision with root package name */
    private static final double f6850D4 = 3.5219323679207912d;

    /* JADX INFO: renamed from: D5, reason: collision with root package name */
    private static final double f6851D5 = -1.7672812570757455d;
    private static final double D6 = 2.382468931778144d;
    private static final long serialVersionUID = 20111120;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private double[] f6852v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    private double[] f6853v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    private double[] f6854v3;

    /* JADX INFO: renamed from: v4, reason: collision with root package name */
    private double[] f6855v4;
    private boolean vectorsInitialized;

    public DormandPrince54StepInterpolator() {
        this.f6852v1 = null;
        this.f6853v2 = null;
        this.f6854v3 = null;
        this.f6855v4 = null;
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        int i5 = 0;
        if (!this.vectorsInitialized) {
            if (this.f6852v1 == null) {
                double[] dArr = this.interpolatedState;
                this.f6852v1 = new double[dArr.length];
                this.f6853v2 = new double[dArr.length];
                this.f6854v3 = new double[dArr.length];
                this.f6855v4 = new double[dArr.length];
            }
            for (int i6 = 0; i6 < this.interpolatedState.length; i6++) {
                double[][] dArr2 = this.yDotK;
                double d7 = dArr2[0][i6];
                double d8 = dArr2[2][i6];
                double d9 = dArr2[3][i6];
                double d10 = dArr2[4][i6];
                double d11 = dArr2[5][i6];
                double d12 = dArr2[6][i6];
                double[] dArr3 = this.f6852v1;
                double d13 = (A75 * d11) + (A74 * d10) + (A73 * d9) + (A72 * d8) + (A70 * d7);
                dArr3[i6] = d13;
                double d14 = d7 - d13;
                this.f6853v2[i6] = d14;
                this.f6854v3[i6] = (dArr3[i6] - d14) - d12;
                this.f6855v4[i6] = (d12 * D6) + (d11 * f6851D5) + (d10 * f6850D4) + (d9 * f6849D3) + (d8 * f6848D2) + (d7 * f6847D0);
            }
            this.vectorsInitialized = true;
        }
        double d15 = 1.0d - d;
        double d16 = d * 2.0d;
        double d17 = 1.0d - d16;
        double d18 = (2.0d - (d * 3.0d)) * d;
        double d19 = (((d16 - 3.0d) * d) + 1.0d) * d16;
        if (this.previousState == null || d > 0.5d) {
            while (true) {
                double[] dArr4 = this.interpolatedState;
                if (i5 >= dArr4.length) {
                    return;
                }
                double d20 = this.currentState[i5];
                double[] dArr5 = this.f6852v1;
                double d21 = dArr5[i5];
                double[] dArr6 = this.f6853v2;
                double d22 = dArr6[i5];
                double[] dArr7 = this.f6854v3;
                double d23 = dArr7[i5];
                double[] dArr8 = this.f6855v4;
                dArr4[i5] = d20 - ((d21 - (((((dArr8[i5] * d15) + d23) * d) + d22) * d)) * d6);
                this.interpolatedDerivatives[i5] = (dArr8[i5] * d19) + (dArr7[i5] * d18) + (dArr6[i5] * d17) + dArr5[i5];
                i5++;
            }
        } else {
            while (true) {
                double[] dArr9 = this.interpolatedState;
                if (i5 >= dArr9.length) {
                    return;
                }
                double d24 = this.previousState[i5];
                double d25 = this.f6865h * d;
                double[] dArr10 = this.f6852v1;
                double d26 = dArr10[i5];
                double[] dArr11 = this.f6853v2;
                double d27 = dArr11[i5];
                double[] dArr12 = this.f6854v3;
                double d28 = dArr12[i5];
                double[] dArr13 = this.f6855v4;
                dArr9[i5] = (((((((dArr13[i5] * d15) + d28) * d) + d27) * d15) + d26) * d25) + d24;
                this.interpolatedDerivatives[i5] = (dArr13[i5] * d19) + (dArr12[i5] * d18) + (dArr11[i5] * d17) + dArr10[i5];
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new DormandPrince54StepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator
    public void reinitialize(AbstractIntegrator abstractIntegrator, double[] dArr, double[][] dArr2, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        super.reinitialize(abstractIntegrator, dArr, dArr2, z6, equationsMapper, equationsMapperArr);
        this.f6852v1 = null;
        this.f6853v2 = null;
        this.f6854v3 = null;
        this.f6855v4 = null;
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void storeTime(double d) {
        super.storeTime(d);
        this.vectorsInitialized = false;
    }

    public DormandPrince54StepInterpolator(DormandPrince54StepInterpolator dormandPrince54StepInterpolator) {
        super(dormandPrince54StepInterpolator);
        double[] dArr = dormandPrince54StepInterpolator.f6852v1;
        if (dArr == null) {
            this.f6852v1 = null;
            this.f6853v2 = null;
            this.f6854v3 = null;
            this.f6855v4 = null;
            this.vectorsInitialized = false;
            return;
        }
        this.f6852v1 = (double[]) dArr.clone();
        this.f6853v2 = (double[]) dormandPrince54StepInterpolator.f6853v2.clone();
        this.f6854v3 = (double[]) dormandPrince54StepInterpolator.f6854v3.clone();
        this.f6855v4 = (double[]) dormandPrince54StepInterpolator.f6855v4.clone();
        this.vectorsInitialized = dormandPrince54StepInterpolator.vectorsInitialized;
    }
}
