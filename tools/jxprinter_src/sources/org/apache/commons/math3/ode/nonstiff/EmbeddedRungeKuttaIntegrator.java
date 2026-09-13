package org.apache.commons.math3.ode.nonstiff;

import java.lang.reflect.Array;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EmbeddedRungeKuttaIntegrator extends AdaptiveStepsizeIntegrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[][] f6859a;
    private final double[] b;
    private final double[] c;
    private final double exp;
    private final boolean fsal;
    private double maxGrowth;
    private double minReduction;
    private final RungeKuttaStepInterpolator prototype;
    private double safety;

    public EmbeddedRungeKuttaIntegrator(String str, boolean z6, double[] dArr, double[][] dArr2, double[] dArr3, RungeKuttaStepInterpolator rungeKuttaStepInterpolator, double d, double d6, double d7, double d8) {
        super(str, d, d6, d7, d8);
        this.fsal = z6;
        this.c = dArr;
        this.f6859a = dArr2;
        this.b = dArr3;
        this.prototype = rungeKuttaStepInterpolator;
        this.exp = (-1.0d) / ((double) getOrder());
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(10.0d);
    }

    public abstract double estimateError(double[][] dArr, double[] dArr2, double[] dArr3, double d);

    public double getMaxGrowth() {
        return this.maxGrowth;
    }

    public double getMinReduction() {
        return this.minReduction;
    }

    public abstract int getOrder();

    public double getSafety() {
        return this.safety;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE expandableStatefulODE, double d) {
        int i5;
        double[] dArr;
        double dFilterStep;
        double[] dArr2;
        int i6;
        int i7;
        double[] dArr3;
        double dInitializeStep;
        boolean z6;
        double[] dArr4;
        double[] dArr5;
        double[] dArr6;
        sanityChecks(expandableStatefulODE, d);
        setEquations(expandableStatefulODE);
        int i8 = 1;
        int i9 = 0;
        boolean z7 = d > expandableStatefulODE.getTime();
        double[] completeState = expandableStatefulODE.getCompleteState();
        double[] dArr7 = (double[]) completeState.clone();
        int length = this.c.length;
        int i10 = length + 1;
        double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i10, dArr7.length);
        double[] dArr9 = (double[]) completeState.clone();
        double[] dArr10 = new double[dArr7.length];
        RungeKuttaStepInterpolator rungeKuttaStepInterpolator = (RungeKuttaStepInterpolator) this.prototype.copy();
        boolean z8 = z7;
        rungeKuttaStepInterpolator.reinitialize(this, dArr9, dArr8, z8, expandableStatefulODE.getPrimaryMapper(), expandableStatefulODE.getSecondaryMappers());
        double[] dArr11 = dArr9;
        boolean z9 = z8;
        rungeKuttaStepInterpolator.storeTime(expandableStatefulODE.getTime());
        this.stepStart = expandableStatefulODE.getTime();
        double[] dArr12 = completeState;
        AbstractStepInterpolator abstractStepInterpolator = rungeKuttaStepInterpolator;
        initIntegration(expandableStatefulODE.getTime(), dArr12, d);
        this.isLastStep = false;
        double d6 = 0.0d;
        boolean z10 = true;
        while (true) {
            abstractStepInterpolator.shift();
            double dFilterStep2 = d6;
            double dEstimateError = 10.0d;
            boolean z11 = z10;
            while (dEstimateError >= 1.0d) {
                if (z11 || !this.fsal) {
                    computeDerivatives(this.stepStart, dArr7, dArr8[i9 == true ? 1 : 0]);
                }
                if (z11) {
                    int i11 = this.mainSetDimension;
                    double[] dArr13 = dArr12;
                    double[] dArr14 = new double[i11];
                    if (this.vecAbsoluteTolerance == null) {
                        int i12 = i9 == true ? 1 : 0;
                        while (i12 < i11) {
                            double[] dArr15 = dArr14;
                            dArr15[i12] = (FastMath.abs(dArr7[i12]) * this.scalRelativeTolerance) + this.scalAbsoluteTolerance;
                            i12++;
                            dArr13 = dArr13;
                            dArr14 = dArr15;
                            i8 = i8;
                            i9 = i9 == true ? 1 : 0;
                        }
                        dArr5 = dArr13;
                        dArr6 = dArr14;
                        i6 = i8;
                        i7 = i9;
                    } else {
                        dArr5 = dArr13;
                        dArr6 = dArr14;
                        i6 = i8;
                        i7 = i9 == true ? 1 : 0;
                        for (int i13 = i7 == true ? 1 : 0; i13 < i11; i13++) {
                            dArr6[i13] = (FastMath.abs(dArr7[i13]) * this.vecRelativeTolerance[i13]) + this.vecAbsoluteTolerance[i13];
                        }
                    }
                    boolean z12 = z9;
                    double[] dArr16 = dArr7;
                    dArr11 = dArr11;
                    abstractStepInterpolator = abstractStepInterpolator;
                    dArr3 = dArr5;
                    dInitializeStep = initializeStep(z12, getOrder(), dArr6, this.stepStart, dArr16, dArr8[i7 == true ? 1 : 0], dArr11, dArr8[i6]);
                    dArr2 = dArr16;
                    z9 = z12;
                    z6 = i7 == true ? 1 : 0;
                } else {
                    dArr2 = dArr7;
                    dArr11 = dArr11;
                    i6 = i8;
                    i7 = i9 == true ? 1 : 0;
                    dArr3 = dArr12;
                    abstractStepInterpolator = abstractStepInterpolator;
                    dInitializeStep = dFilterStep2;
                    z6 = z11;
                }
                this.stepSize = dInitializeStep;
                if (z9) {
                    dArr4 = dArr2;
                    double d7 = this.stepStart;
                    if (d7 + dInitializeStep >= d) {
                        this.stepSize = d - d7;
                    }
                } else {
                    dArr4 = dArr2;
                    double d8 = this.stepStart;
                    if (d8 + dInitializeStep <= d) {
                        this.stepSize = d - d8;
                    }
                }
                int i14 = i6;
                while (i14 < i10) {
                    int i15 = i7;
                    while (i15 < dArr3.length) {
                        int i16 = i14 - 1;
                        double d9 = this.f6859a[i16][i7] * dArr8[i7][i15];
                        int i17 = i6;
                        while (i17 < i14) {
                            d9 = (this.f6859a[i16][i17] * dArr8[i17][i15]) + d9;
                            i17++;
                            i14 = i14;
                        }
                        int i18 = i15;
                        dArr11[i18 == true ? 1 : 0] = (this.stepSize * d9) + dArr4[i15];
                        i15 = (i18 == true ? 1 : 0) + 1;
                        i14 = i14;
                    }
                    int i19 = i14;
                    computeDerivatives((this.c[i19 - 1] * this.stepSize) + this.stepStart, dArr11, dArr8[i19]);
                    i14 = i19 + 1;
                }
                int i20 = i7;
                while (i20 < dArr3.length) {
                    double d10 = this.b[i7] * dArr8[i7][i20];
                    for (int i21 = i6; i21 < i10; i21++) {
                        d10 = (this.b[i21] * dArr8[i21][i20]) + d10;
                    }
                    int i22 = i20;
                    dArr11[i22 == true ? 1 : 0] = (this.stepSize * d10) + dArr4[i20];
                    i20 = (i22 == true ? 1 : 0) + 1;
                }
                dFilterStep2 = dInitializeStep;
                double[] dArr17 = dArr4;
                dEstimateError = estimateError(dArr8, dArr17, dArr11, this.stepSize);
                if (dEstimateError >= 1.0d) {
                    int i23 = length;
                    boolean z13 = i7;
                    dFilterStep2 = filterStep(this.stepSize * FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, FastMath.pow(dEstimateError, this.exp) * this.safety)), z9, z13);
                    length = i23;
                    i9 = z13 ? 1 : 0;
                    i10 = i10;
                } else {
                    i9 = i7;
                }
                dArr7 = dArr17;
                dArr12 = dArr3;
                i8 = i6;
                z11 = z6;
            }
            boolean z14 = i9 == true ? 1 : 0;
            AbstractStepInterpolator abstractStepInterpolator2 = abstractStepInterpolator;
            int i24 = length;
            int i25 = i8;
            int i26 = i10;
            double[] dArr18 = dArr12;
            double[] dArr19 = dArr7;
            double[] dArr20 = dArr11;
            abstractStepInterpolator2.storeTime(this.stepStart + this.stepSize);
            System.arraycopy(dArr20, z14 ? 1 : 0, dArr19, z14 ? 1 : 0, dArr18.length);
            System.arraycopy(dArr8[i24], z14 ? 1 : 0, dArr10, z14 ? 1 : 0, dArr18.length);
            double d11 = dEstimateError;
            double[] dArr21 = dArr10;
            this.stepStart = acceptStep(abstractStepInterpolator2, dArr19, dArr21, d);
            System.arraycopy(dArr19, z14 ? 1 : 0, dArr20, z14 ? 1 : 0, dArr19.length);
            if (this.isLastStep) {
                i5 = i24;
                dArr = dArr20;
                dFilterStep = dFilterStep2;
            } else {
                abstractStepInterpolator2.storeTime(this.stepStart);
                if (this.fsal) {
                    System.arraycopy(dArr21, z14 ? 1 : 0, dArr8[z14 ? 1 : 0], z14 ? 1 : 0, dArr18.length);
                }
                i5 = i24;
                dArr = dArr20;
                double dMin = this.stepSize * FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, FastMath.pow(d11, this.exp) * this.safety));
                double d12 = this.stepStart + dMin;
                dFilterStep = filterStep(dMin, z9, (!z9 ? d12 <= d : d12 >= d) ? 0 : i25);
                double d13 = this.stepStart;
                double d14 = d13 + dFilterStep;
                if (!z9 ? d14 <= d : d14 >= d) {
                    dFilterStep = d - d13;
                }
            }
            if (this.isLastStep) {
                expandableStatefulODE.setTime(this.stepStart);
                expandableStatefulODE.setCompleteState(dArr19);
                resetInternalState();
                return;
            }
            abstractStepInterpolator = abstractStepInterpolator2;
            dArr7 = dArr19;
            d6 = dFilterStep;
            dArr11 = dArr;
            length = i5;
            z10 = z11 ? 1 : 0;
            i10 = i26;
            i9 = 0;
            dArr10 = dArr21;
            dArr12 = dArr18;
            i8 = i25;
        }
    }

    public void setMaxGrowth(double d) {
        this.maxGrowth = d;
    }

    public void setMinReduction(double d) {
        this.minReduction = d;
    }

    public void setSafety(double d) {
        this.safety = d;
    }

    public EmbeddedRungeKuttaIntegrator(String str, boolean z6, double[] dArr, double[][] dArr2, double[] dArr3, RungeKuttaStepInterpolator rungeKuttaStepInterpolator, double d, double d6, double[] dArr4, double[] dArr5) {
        super(str, d, d6, dArr4, dArr5);
        this.fsal = z6;
        this.c = dArr;
        this.f6859a = dArr2;
        this.b = dArr3;
        this.prototype = rungeKuttaStepInterpolator;
        this.exp = (-1.0d) / ((double) getOrder());
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(10.0d);
    }
}
