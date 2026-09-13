package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GraggBulirschStoerIntegrator extends AdaptiveStepsizeIntegrator {
    private static final String METHOD_NAME = "Gragg-Bulirsch-Stoer";
    private double[][] coeff;
    private int[] costPerStep;
    private double[] costPerTimeUnit;
    private int maxChecks;
    private int maxIter;
    private int maxOrder;
    private int mudif;
    private double[] optimalStep;
    private double orderControl1;
    private double orderControl2;
    private boolean performTest;
    private int[] sequence;
    private double stabilityReduction;
    private double stepControl1;
    private double stepControl2;
    private double stepControl3;
    private double stepControl4;
    private boolean useInterpolationError;

    public GraggBulirschStoerIntegrator(double d, double d6, double d7, double d8) {
        super(METHOD_NAME, d, d6, d7, d8);
        setStabilityCheck(true, -1, -1, -1.0d);
        setControlFactors(-1.0d, -1.0d, -1.0d, -1.0d);
        setOrderControl(-1, -1.0d, -1.0d);
        setInterpolationControl(true, -1);
    }

    private void extrapolate(int i5, int i6, double[][] dArr, double[] dArr2) {
        int i7 = 1;
        while (true) {
            if (i7 >= i6) {
                break;
            }
            for (int i8 = 0; i8 < dArr2.length; i8++) {
                int i9 = i6 - i7;
                double[] dArr3 = dArr[i9 - 1];
                double d = dArr[i9][i8];
                dArr3[i8] = a.a(d, dArr3[i8], this.coeff[i6 + i5][i7 - 1], d);
            }
            i7++;
        }
        for (int i10 = 0; i10 < dArr2.length; i10++) {
            double d6 = dArr[0][i10];
            dArr2[i10] = a.a(d6, dArr2[i10], this.coeff[i6 + i5][i6 - 1], d6);
        }
    }

    private void initializeArrays() {
        int i5 = this.maxOrder / 2;
        int[] iArr = this.sequence;
        if (iArr == null || iArr.length != i5) {
            this.sequence = new int[i5];
            this.costPerStep = new int[i5];
            this.coeff = new double[i5][];
            this.costPerTimeUnit = new double[i5];
            this.optimalStep = new double[i5];
        }
        for (int i6 = 0; i6 < i5; i6++) {
            this.sequence[i6] = (i6 * 4) + 2;
        }
        this.costPerStep[0] = this.sequence[0] + 1;
        for (int i7 = 1; i7 < i5; i7++) {
            int[] iArr2 = this.costPerStep;
            iArr2[i7] = iArr2[i7 - 1] + this.sequence[i7];
        }
        int i8 = 0;
        while (i8 < i5) {
            this.coeff[i8] = i8 > 0 ? new double[i8] : null;
            for (int i9 = 0; i9 < i8; i9++) {
                int[] iArr3 = this.sequence;
                double d = ((double) iArr3[i8]) / ((double) iArr3[(i8 - i9) - 1]);
                this.coeff[i8][i9] = 1.0d / ((d * d) - 1.0d);
            }
            i8++;
        }
    }

    private void rescale(double[] dArr, double[] dArr2, double[] dArr3) {
        int i5 = 0;
        if (this.vecAbsoluteTolerance == null) {
            while (i5 < dArr3.length) {
                double dMax = FastMath.max(FastMath.abs(dArr[i5]), FastMath.abs(dArr2[i5]));
                dArr3[i5] = (this.scalRelativeTolerance * dMax) + this.scalAbsoluteTolerance;
                i5++;
            }
            return;
        }
        while (i5 < dArr3.length) {
            double dMax2 = FastMath.max(FastMath.abs(dArr[i5]), FastMath.abs(dArr2[i5]));
            dArr3[i5] = (this.vecRelativeTolerance[i5] * dMax2) + this.vecAbsoluteTolerance[i5];
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean tryStep(double d, double[] dArr, double d6, int i5, double[] dArr2, double[][] dArr3, double[] dArr4, double[] dArr5, double[] dArr6) {
        GraggBulirschStoerIntegrator graggBulirschStoerIntegrator = this;
        int i6 = i5;
        double[] dArr7 = dArr5;
        int i7 = graggBulirschStoerIntegrator.sequence[i6];
        double d7 = d6 / ((double) i7);
        double d8 = 2.0d * d7;
        double d9 = d + d7;
        int i8 = 0;
        for (int i9 = 0; i9 < dArr.length; i9++) {
            dArr6[i9] = dArr[i9];
            dArr7[i9] = (dArr3[0][i9] * d7) + dArr[i9];
        }
        graggBulirschStoerIntegrator.computeDerivatives(d9, dArr7, dArr3[1]);
        int i10 = 1;
        while (i10 < i7) {
            if (i10 * 2 == i7) {
                System.arraycopy(dArr7, i8, dArr4, i8, dArr.length);
            }
            d9 += d7;
            boolean z6 = i8;
            for (int i11 = z6 ? 1 : 0; i11 < dArr.length; i11++) {
                double d10 = dArr7[i11];
                dArr7[i11] = (dArr3[i10][i11] * d8) + dArr6[i11];
                dArr6[i11] = d10;
            }
            int i12 = i10 + 1;
            graggBulirschStoerIntegrator.computeDerivatives(d9, dArr7, dArr3[i12]);
            if (graggBulirschStoerIntegrator.performTest && i10 <= graggBulirschStoerIntegrator.maxChecks && i6 < graggBulirschStoerIntegrator.maxIter) {
                double d11 = 0.0d;
                for (int i13 = z6 ? 1 : 0; i13 < dArr2.length; i13++) {
                    double d12 = dArr3[z6 ? 1 : 0][i13] / dArr2[i13];
                    d11 = (d12 * d12) + d11;
                }
                double d13 = 0.0d;
                for (int i14 = z6 ? 1 : 0; i14 < dArr2.length; i14++) {
                    double d14 = (dArr3[i12][i14] - dArr3[z6 ? 1 : 0][i14]) / dArr2[i14];
                    d13 = (d14 * d14) + d13;
                }
                if (d13 > FastMath.max(1.0E-15d, d11) * 4.0d) {
                    return z6;
                }
            }
            graggBulirschStoerIntegrator = this;
            i6 = i5;
            dArr7 = dArr5;
            i10 = i12;
            i7 = i7;
            i8 = z6 ? 1 : 0;
        }
        int i15 = i7;
        for (int i16 = i8 == true ? 1 : 0; i16 < dArr.length; i16++) {
            dArr5[i16] = a.B(d7, dArr3[i15][i16], dArr6[i16] + dArr5[i16], 0.5d);
        }
        return true;
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator, org.apache.commons.math3.ode.ODEIntegrator
    public void addEventHandler(EventHandler eventHandler, double d, double d6, int i5, UnivariateSolver univariateSolver) {
        super.addEventHandler(eventHandler, d, d6, i5, univariateSolver);
        initializeArrays();
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator, org.apache.commons.math3.ode.ODEIntegrator
    public void addStepHandler(StepHandler stepHandler) {
        super.addStepHandler(stepHandler);
        initializeArrays();
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0371  */
    /* JADX WARN: Code duplicated, block: B:182:0x0514  */
    /* JADX WARN: Code duplicated, block: B:184:0x053e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0542 A[PHI: r1 r25
  0x0542: PHI (r1v83 int) = (r1v64 int), (r1v42 int) binds: [B:194:0x0567, B:185:0x0540] A[DONT_GENERATE, DONT_INLINE]
  0x0542: PHI (r25v7 org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator) = 
  (r25v5 org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator)
  (r25v8 org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator)
 binds: [B:194:0x0567, B:185:0x0540] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:187:0x0545  */
    /* JADX WARN: Code duplicated, block: B:188:0x0549 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:189:0x054b  */
    /* JADX WARN: Code duplicated, block: B:191:0x055d  */
    /* JADX WARN: Code duplicated, block: B:192:0x055f  */
    /* JADX WARN: Code duplicated, block: B:194:0x0567  */
    /* JADX WARN: Code duplicated, block: B:195:0x0573  */
    /* JADX WARN: Code duplicated, block: B:196:0x0575  */
    /* JADX WARN: Code duplicated, block: B:198:0x057d  */
    /* JADX WARN: Code duplicated, block: B:200:0x0590  */
    /* JADX WARN: Code duplicated, block: B:201:0x0592  */
    /* JADX WARN: Code duplicated, block: B:205:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:206:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:208:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:209:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:211:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:212:0x05da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:213:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:215:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:216:0x0608  */
    /* JADX WARN: Code duplicated, block: B:221:0x062e  */
    /* JADX WARN: Code duplicated, block: B:224:0x0642  */
    /* JADX WARN: Code duplicated, block: B:226:0x0645  */
    /* JADX WARN: Code duplicated, block: B:227:0x064b  */
    /* JADX WARN: Code duplicated, block: B:232:0x0660 A[LOOP:3: B:26:0x013c->B:232:0x0660, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:236:0x0652 A[SYNTHETIC] */
    @Override // org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE expandableStatefulODE, double d) {
        int[] iArr;
        int i5;
        double[] dArr;
        double[] dArr2;
        double[] dArr3;
        double[] dArr4;
        boolean z6;
        double[] dArr5;
        double[] dArr6;
        double[] dArr7;
        double d6;
        double[] dArr8;
        double[] dArr9;
        GraggBulirschStoerStepInterpolator graggBulirschStoerStepInterpolator;
        double[][] dArr10;
        double dAbs;
        double[] dArr11;
        double[] dArr12;
        double d7;
        double[] dArr13;
        double dMin;
        boolean z7;
        GraggBulirschStoerStepInterpolator graggBulirschStoerStepInterpolator2;
        int iMin;
        int i6;
        int i7;
        int i8;
        double[] dArr14;
        int i9;
        int iMin2;
        double[] dArr15;
        int i10;
        int i11;
        double d8;
        double d9;
        double d10;
        int i12;
        double dFilterStep;
        double[] dArr16;
        int i13;
        int i14;
        sanityChecks(expandableStatefulODE, d);
        setEquations(expandableStatefulODE);
        int i15 = 0;
        int i16 = 1;
        boolean z8 = d > expandableStatefulODE.getTime();
        double[] completeState = expandableStatefulODE.getCompleteState();
        double[] dArr17 = (double[]) completeState.clone();
        double[] dArr18 = new double[dArr17.length];
        double[] dArr19 = new double[dArr17.length];
        double[] dArr20 = new double[dArr17.length];
        double[] dArr21 = new double[dArr17.length];
        int[] iArr2 = this.sequence;
        double[][] dArr22 = new double[iArr2.length - 1][];
        double[][] dArr23 = new double[iArr2.length - 1][];
        int i17 = 0;
        while (true) {
            iArr = this.sequence;
            if (i17 >= iArr.length - 1) {
                break;
            }
            dArr22[i17] = new double[dArr17.length];
            dArr23[i17] = new double[dArr17.length];
            i17++;
        }
        double[][][] dArr24 = new double[iArr.length][][];
        int i18 = 0;
        while (true) {
            int[] iArr3 = this.sequence;
            i5 = i16;
            if (i18 >= iArr3.length) {
                break;
            }
            double[][] dArr25 = new double[iArr3[i18] + 1][];
            dArr24[i18] = dArr25;
            dArr25[i15] = dArr18;
            int i19 = i15;
            while (i19 < this.sequence[i18]) {
                i19++;
                dArr24[i18][i19] = new double[completeState.length];
            }
            i18++;
            i16 = i5;
            i15 = 0;
        }
        if (dArr17 != completeState) {
            System.arraycopy(completeState, 0, dArr17, 0, completeState.length);
        }
        double[] dArr26 = new double[completeState.length];
        int length = (this.sequence.length * 2) + 1;
        boolean z9 = z8;
        int[] iArr4 = new int[2];
        iArr4[i5] = completeState.length;
        iArr4[0] = length;
        double[][] dArr27 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr4);
        double[] dArr28 = new double[this.mainSetDimension];
        rescale(dArr17, dArr17, dArr28);
        double[] dArr29 = this.vecRelativeTolerance;
        int i20 = 2;
        double[] dArr30 = dArr28;
        int iMax = FastMath.max(i5, FastMath.min(this.sequence.length - 2, (int) FastMath.floor(0.5d - (FastMath.log10(FastMath.max(1.0E-10d, dArr29 == null ? this.scalRelativeTolerance : dArr29[0])) * 0.6d))));
        double[] dArr31 = dArr21;
        boolean z10 = z9;
        GraggBulirschStoerStepInterpolator graggBulirschStoerStepInterpolator3 = new GraggBulirschStoerStepInterpolator(dArr17, dArr18, dArr19, dArr26, dArr27, z10, expandableStatefulODE.getPrimaryMapper(), expandableStatefulODE.getSecondaryMappers());
        double[] dArr32 = dArr19;
        double[] dArr33 = dArr26;
        double[] dArr34 = dArr17;
        double[] dArr35 = dArr18;
        graggBulirschStoerStepInterpolator3.storeTime(expandableStatefulODE.getTime());
        this.stepStart = expandableStatefulODE.getTime();
        double[][] dArr36 = dArr22;
        double[] dArr37 = completeState;
        GraggBulirschStoerStepInterpolator graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator3;
        initIntegration(expandableStatefulODE.getTime(), dArr37, d);
        this.costPerTimeUnit[0] = 0.0d;
        this.isLastStep = false;
        double d11 = Double.MAX_VALUE;
        int i21 = iMax;
        double dInitializeStep = 0.0d;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = true;
        boolean z14 = false;
        while (true) {
            if (z11) {
                graggBulirschStoerStepInterpolator4.shift();
                if (!z12) {
                    computeDerivatives(this.stepStart, dArr34, dArr35);
                }
                if (z13) {
                    boolean z15 = z10;
                    double[] dArr38 = dArr20;
                    double[] dArr39 = dArr31;
                    double[] dArr40 = dArr30;
                    dInitializeStep = initializeStep(z15, (i21 * 2) + 1, dArr40, this.stepStart, dArr34, dArr35, dArr38, dArr39);
                    double[] dArr41 = dArr34;
                    dArr2 = dArr40;
                    dArr = dArr41;
                    dArr3 = dArr39;
                    dArr4 = dArr38;
                    z10 = z15;
                } else {
                    dArr = dArr34;
                    dArr2 = dArr30;
                    dArr3 = dArr31;
                    dArr4 = dArr20;
                }
                z6 = false;
            } else {
                double[] dArr42 = dArr31;
                dArr37 = dArr37;
                dArr = dArr34;
                dArr2 = dArr30;
                dArr3 = dArr42;
                dArr36 = dArr36;
                dArr4 = dArr20;
                dArr33 = dArr33;
                z6 = z11;
            }
            this.stepSize = dInitializeStep;
            double[][] dArr43 = dArr36;
            if ((z10 && this.stepStart + dInitializeStep > d) || (!z10 && this.stepStart + dInitializeStep < d)) {
                this.stepSize = d - this.stepStart;
            }
            double d12 = this.stepStart + this.stepSize;
            this.isLastStep = !z10 ? d12 > d : d12 < d;
            int i22 = -1;
            int i23 = -1;
            double[] dArr44 = dArr37;
            double[] dArr45 = dArr33;
            double dMax = d11;
            boolean z16 = false;
            double dMin2 = dInitializeStep;
            int i24 = i21;
            boolean z17 = true;
            while (z17) {
                double[] dArr46 = dArr35;
                double[] dArr47 = dArr2;
                i23++;
                int i25 = i22;
                int i26 = i23;
                double d13 = this.stepStart;
                int i27 = i24;
                dArr35 = dArr46;
                double d14 = this.stepSize;
                boolean z18 = z10;
                double[][] dArr48 = dArr24[i23];
                double[] dArr49 = i23 == 0 ? dArr27[0] : dArr43[i26];
                if (i23 != 0) {
                    dArr32 = dArr23[i26];
                }
                z10 = z18;
                dArr43 = dArr43;
                boolean zTryStep = tryStep(d13, dArr, d14, i23, dArr47, dArr48, dArr49, dArr32, dArr4);
                dArr2 = dArr47;
                dArr = dArr;
                if (zTryStep) {
                    char c = 0;
                    if (i23 > 0) {
                        extrapolate(0, i23, dArr23, dArr32);
                        rescale(dArr, dArr32, dArr2);
                        int i28 = 0;
                        double d15 = 0.0d;
                        while (true) {
                            i14 = this.mainSetDimension;
                            if (i28 >= i14) {
                                break;
                            }
                            double dAbs2 = FastMath.abs(dArr32[i28] - dArr23[c][i28]) / dArr2[i28];
                            d15 += dAbs2 * dAbs2;
                            i28++;
                            c = 0;
                        }
                        double dSqrt = FastMath.sqrt(d15 / ((double) i14));
                        if (dSqrt > 1.0E15d || (i23 > 1 && dSqrt > dMax)) {
                            dMin2 = FastMath.abs(filterStep(this.stepSize * this.stabilityReduction, z10, false));
                            i24 = i27;
                            i22 = -1;
                            z17 = false;
                        } else {
                            dMax = FastMath.max(4.0d * dSqrt, 1.0d);
                            double d16 = 1.0d / ((double) ((i23 * 2) + 1));
                            double dPow = this.stepControl2 / FastMath.pow(dSqrt / this.stepControl1, d16);
                            double dPow2 = FastMath.pow(this.stepControl3, d16);
                            this.optimalStep[i23] = FastMath.abs(filterStep(this.stepSize * FastMath.max(dPow2 / this.stepControl4, FastMath.min(1.0d / dPow2, dPow)), z10, true));
                            double[] dArr50 = this.costPerTimeUnit;
                            double d17 = this.costPerStep[i23];
                            double[] dArr51 = this.optimalStep;
                            double d18 = d17 / dArr51[i23];
                            dArr50[i23] = d18;
                            int i29 = i23 - i27;
                            if (i29 == i25) {
                                if (i27 > 1 && !z14) {
                                    if (dSqrt > 1.0d) {
                                        int[] iArr5 = this.sequence;
                                        double d19 = ((double) iArr5[i27 + 1]) * ((double) iArr5[i27]);
                                        int i30 = iArr5[0];
                                        double d20 = d19 / ((double) (i30 * i30));
                                        if (dSqrt > d20 * d20) {
                                            int i31 = (i23 <= 1 || dArr50[i26] >= this.orderControl1 * d18) ? i23 : i26;
                                            dMin2 = dArr51[i31];
                                            i24 = i31;
                                            z17 = false;
                                            z16 = true;
                                        }
                                        i23 = i23;
                                        dArr = dArr;
                                        dArr2 = dArr2;
                                        dArr32 = dArr32;
                                        z10 = z10;
                                        dArr35 = dArr35;
                                        dArr43 = dArr43;
                                        i22 = -1;
                                    }
                                    i24 = i27;
                                    z17 = false;
                                    i23 = i23;
                                    dArr = dArr;
                                    dArr2 = dArr2;
                                    dArr32 = dArr32;
                                    z10 = z10;
                                    dArr35 = dArr35;
                                    dArr43 = dArr43;
                                    i22 = -1;
                                }
                                i24 = i27;
                                i23 = i23;
                                dArr = dArr;
                                dArr2 = dArr2;
                                dArr32 = dArr32;
                                z10 = z10;
                                dArr35 = dArr35;
                                dArr43 = dArr43;
                                i22 = -1;
                            } else if (i29 != 0) {
                                if (i29 != 1) {
                                    if ((!z13 && !this.isLastStep) || dSqrt > 1.0d) {
                                        i24 = i27;
                                    }
                                    i23 = i23;
                                    dArr = dArr;
                                    dArr2 = dArr2;
                                    dArr32 = dArr32;
                                    z10 = z10;
                                    dArr35 = dArr35;
                                    dArr43 = dArr43;
                                    i22 = -1;
                                } else {
                                    if (dSqrt > 1.0d) {
                                        int i32 = (i27 <= 1 || dArr50[i27 + (-1)] >= this.orderControl1 * dArr50[i27]) ? i27 : i27 - 1;
                                        dMin2 = dArr51[i32];
                                        i24 = i32;
                                        z16 = true;
                                    }
                                    z17 = false;
                                    i23 = i23;
                                    dArr = dArr;
                                    dArr2 = dArr2;
                                    dArr32 = dArr32;
                                    z10 = z10;
                                    dArr35 = dArr35;
                                    dArr43 = dArr43;
                                    i22 = -1;
                                }
                                i24 = i27;
                                z17 = false;
                                i23 = i23;
                                dArr = dArr;
                                dArr2 = dArr2;
                                dArr32 = dArr32;
                                z10 = z10;
                                dArr35 = dArr35;
                                dArr43 = dArr43;
                                i22 = -1;
                            } else {
                                if (dSqrt > 1.0d) {
                                    int[] iArr6 = this.sequence;
                                    double d21 = ((double) iArr6[i26 + 2]) / ((double) iArr6[0]);
                                    if (dSqrt > d21 * d21) {
                                        int i33 = (i27 <= 1 || dArr50[i27 + (-1)] >= this.orderControl1 * dArr50[i27]) ? i27 : i27 - 1;
                                        dMin2 = dArr51[i33];
                                        i24 = i33;
                                        z17 = false;
                                        z16 = true;
                                    } else {
                                        i24 = i27;
                                    }
                                    i23 = i23;
                                    dArr = dArr;
                                    dArr2 = dArr2;
                                    dArr32 = dArr32;
                                    z10 = z10;
                                    dArr35 = dArr35;
                                    dArr43 = dArr43;
                                    i22 = -1;
                                }
                                i24 = i27;
                                z17 = false;
                                i23 = i23;
                                dArr = dArr;
                                dArr2 = dArr2;
                                dArr32 = dArr32;
                                z10 = z10;
                                dArr35 = dArr35;
                                dArr43 = dArr43;
                                i22 = -1;
                            }
                        }
                    } else {
                        i23 = i23;
                        dArr = dArr;
                        dArr2 = dArr2;
                        i24 = i27;
                        dArr32 = dArr32;
                        z10 = z10;
                        i22 = i25;
                        dArr35 = dArr35;
                        dArr43 = dArr43;
                    }
                } else {
                    dMin2 = FastMath.abs(filterStep(this.stepSize * this.stabilityReduction, z10, false));
                    z17 = false;
                    i22 = i25;
                    i24 = i27;
                }
                z16 = true;
            }
            double[] dArr52 = dArr35;
            boolean z19 = z10;
            double[][] dArr53 = dArr43;
            double[] dArr54 = dArr32;
            int i34 = i23;
            double[] dArr55 = dArr;
            int i35 = i24;
            double[] dArr56 = dArr2;
            if (z16) {
                dArr5 = dArr45;
            } else {
                dArr5 = dArr45;
                computeDerivatives(this.stepStart + this.stepSize, dArr54, dArr5);
            }
            double maxStep = getMaxStep();
            if (z16) {
                dArr6 = dArr5;
                dArr7 = dArr44;
                d6 = maxStep;
                dArr8 = dArr4;
                dArr9 = dArr54;
                graggBulirschStoerStepInterpolator = graggBulirschStoerStepInterpolator4;
                dArr10 = dArr53;
            } else {
                for (int i36 = 1; i36 <= i34; i36++) {
                    extrapolate(0, i36, dArr53, dArr27[0]);
                }
                dArr10 = dArr53;
                int i37 = (i34 * 2) - this.mudif;
                int i38 = i37 + 3;
                int i39 = 0;
                while (i39 < i38) {
                    double d22 = maxStep;
                    int i40 = i39 / 2;
                    int i41 = i37;
                    double dPow3 = FastMath.pow(((double) this.sequence[i40]) * 0.5d, i39);
                    int length2 = dArr24[i40].length / 2;
                    double[] dArr57 = dArr44;
                    double[] dArr58 = dArr5;
                    for (int i42 = 0; i42 < dArr57.length; i42++) {
                        dArr27[i39 + 1][i42] = dPow3 * dArr24[i40][length2 + i39][i42];
                    }
                    int i43 = 1;
                    while (i43 <= i34 - i40) {
                        int i44 = i43 + i40;
                        double[] dArr59 = dArr4;
                        double[] dArr60 = dArr54;
                        double dPow4 = FastMath.pow(((double) this.sequence[i44]) * 0.5d, i39);
                        int length3 = dArr24[i44].length / 2;
                        int i45 = i39;
                        for (int i46 = 0; i46 < dArr57.length; i46++) {
                            dArr10[i43 - 1][i46] = dArr24[i44][length3 + i45][i46] * dPow4;
                        }
                        extrapolate(i40, i43, dArr10, dArr27[i45 + 1]);
                        i43++;
                        dArr54 = dArr60;
                        dArr4 = dArr59;
                        i39 = i45;
                    }
                    int i47 = i39;
                    double[] dArr61 = dArr4;
                    double[] dArr62 = dArr54;
                    int i48 = 0;
                    while (i48 < dArr57.length) {
                        double[] dArr63 = dArr27[i47 + 1];
                        int i49 = i48;
                        dArr63[i49] = dArr63[i48] * this.stepSize;
                        i48 = i49 + 1;
                    }
                    i39 = i47 + 1;
                    for (int i50 = i39 / 2; i50 <= i34; i50++) {
                        int length4 = dArr24[i50].length;
                        while (true) {
                            length4--;
                            if (length4 >= i39 * 2) {
                                for (int i51 = 0; i51 < dArr57.length; i51++) {
                                    double[][] dArr64 = dArr24[i50];
                                    double[] dArr65 = dArr64[length4];
                                    dArr65[i51] = dArr65[i51] - dArr64[length4 - 2][i51];
                                }
                            }
                        }
                    }
                    dArr44 = dArr57;
                    dArr5 = dArr58;
                    maxStep = d22;
                    i37 = i41;
                    dArr54 = dArr62;
                    dArr4 = dArr61;
                }
                double[] dArr66 = dArr44;
                dArr6 = dArr5;
                dArr7 = dArr66;
                d6 = maxStep;
                int i52 = i37;
                dArr8 = dArr4;
                dArr9 = dArr54;
                if (i38 >= 0) {
                    graggBulirschStoerStepInterpolator = graggBulirschStoerStepInterpolator4;
                    graggBulirschStoerStepInterpolator.computeCoefficients(i38, this.stepSize);
                    if (this.useInterpolationError) {
                        double dEstimateError = graggBulirschStoerStepInterpolator.estimateError(dArr56);
                        dAbs = FastMath.abs(this.stepSize / FastMath.max(FastMath.pow(dEstimateError, 1.0d / ((double) (i52 + 7))), 0.01d));
                        if (dEstimateError > 10.0d) {
                            dMin2 = dAbs;
                            z16 = true;
                        }
                    }
                    if (z16) {
                        graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator;
                        dArr11 = dArr6;
                        dArr12 = dArr9;
                        i21 = i35;
                        d7 = dAbs;
                        z11 = z6;
                        dArr13 = dArr52;
                    } else {
                        graggBulirschStoerStepInterpolator.storeTime(this.stepStart + this.stepSize);
                        graggBulirschStoerStepInterpolator2 = graggBulirschStoerStepInterpolator;
                        double d23 = dAbs;
                        dArr11 = dArr6;
                        double[] dArr67 = dArr9;
                        double dAcceptStep = acceptStep(graggBulirschStoerStepInterpolator2, dArr67, dArr11, d);
                        dArr12 = dArr67;
                        this.stepStart = dAcceptStep;
                        graggBulirschStoerStepInterpolator2.storeTime(dAcceptStep);
                        System.arraycopy(dArr12, 0, dArr55, 0, dArr7.length);
                        System.arraycopy(dArr11, 0, dArr52, 0, dArr7.length);
                        iMin = 1;
                        if (i34 == 1) {
                            graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator2;
                            if (z14) {
                                iMin2 = iMin;
                            } else {
                                iMin2 = i20;
                            }
                        } else if (i34 <= i35) {
                            double[] dArr68 = this.costPerTimeUnit;
                            i11 = i34 - 1;
                            d8 = dArr68[i11];
                            graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator2;
                            d9 = this.orderControl1;
                            d10 = dArr68[i34];
                            if (d8 < d9 * d10) {
                                iMin2 = i11;
                            } else if (d10 < this.orderControl2 * d8) {
                                iMin = FastMath.min(i34 + 1, this.sequence.length - 2);
                                iMin2 = iMin;
                            } else {
                                iMin2 = i34;
                            }
                        } else {
                            graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator2;
                            i6 = i34 - 1;
                            if (i34 > i20) {
                                dArr15 = this.costPerTimeUnit;
                                i10 = i34 - 2;
                                i7 = i6;
                                if (dArr15[i10] < this.orderControl1 * dArr15[i7]) {
                                    i8 = i10;
                                }
                                dArr14 = this.costPerTimeUnit;
                                i9 = i8;
                                if (dArr14[i34] < this.orderControl2 * dArr14[i9]) {
                                    i20 = 2;
                                    iMin2 = FastMath.min(i34, this.sequence.length - 2);
                                } else {
                                    i20 = 2;
                                    iMin2 = i9;
                                }
                            } else {
                                i7 = i6;
                            }
                            i8 = i7;
                            dArr14 = this.costPerTimeUnit;
                            i9 = i8;
                            if (dArr14[i34] < this.orderControl2 * dArr14[i9]) {
                                i20 = 2;
                                iMin2 = FastMath.min(i34, this.sequence.length - 2);
                            } else {
                                i20 = 2;
                                iMin2 = i9;
                            }
                        }
                        if (z14) {
                            int iMin3 = FastMath.min(iMin2, i34);
                            dMin2 = FastMath.min(FastMath.abs(this.stepSize), this.optimalStep[iMin3]);
                            i13 = iMin3;
                        } else {
                            if (iMin2 <= i34) {
                                dFilterStep = this.optimalStep[iMin2];
                                i12 = iMin2;
                            } else {
                                if (i34 < i35) {
                                    dArr16 = this.costPerTimeUnit;
                                    i12 = iMin2;
                                    if (dArr16[i34] < this.orderControl2 * dArr16[i34 - 1]) {
                                        double d24 = this.optimalStep[i34];
                                        int[] iArr7 = this.costPerStep;
                                        dFilterStep = filterStep((((double) iArr7[i12 + 1]) * d24) / ((double) iArr7[i34]), z19, false);
                                    }
                                } else {
                                    i12 = iMin2;
                                }
                                double d25 = this.optimalStep[i34];
                                int[] iArr8 = this.costPerStep;
                                dFilterStep = filterStep((((double) iArr8[i12]) * d25) / ((double) iArr8[i34]), z19, false);
                            }
                            dMin2 = dFilterStep;
                            i13 = i12;
                        }
                        dArr13 = dArr52;
                        d7 = d23;
                        z11 = true;
                        z12 = true;
                        i21 = i13;
                    }
                    dMin = FastMath.min(dMin2, d7);
                    if (!z19) {
                        dMin = -dMin;
                    }
                    if (z16) {
                        z7 = false;
                        this.isLastStep = false;
                        z14 = true;
                    } else {
                        z7 = false;
                        z14 = false;
                    }
                    if (this.isLastStep) {
                        expandableStatefulODE.setTime(this.stepStart);
                        expandableStatefulODE.setCompleteState(dArr55);
                        resetInternalState();
                        return;
                    }
                    double[] dArr69 = dArr3;
                    dArr30 = dArr56;
                    z10 = z19;
                    dArr31 = dArr69;
                    z13 = z7;
                    dArr36 = dArr10;
                    d11 = dMax;
                    dArr33 = dArr11;
                    dArr20 = dArr8;
                    dArr32 = dArr12;
                    dArr35 = dArr13;
                    dInitializeStep = dMin;
                    dArr37 = dArr7;
                    dArr34 = dArr55;
                } else {
                    graggBulirschStoerStepInterpolator = graggBulirschStoerStepInterpolator4;
                }
            }
            dAbs = d6;
            if (z16) {
                graggBulirschStoerStepInterpolator.storeTime(this.stepStart + this.stepSize);
                graggBulirschStoerStepInterpolator2 = graggBulirschStoerStepInterpolator;
                double d26 = dAbs;
                dArr11 = dArr6;
                double[] dArr610 = dArr9;
                double dAcceptStep2 = acceptStep(graggBulirschStoerStepInterpolator2, dArr610, dArr11, d);
                dArr12 = dArr610;
                this.stepStart = dAcceptStep2;
                graggBulirschStoerStepInterpolator2.storeTime(dAcceptStep2);
                System.arraycopy(dArr12, 0, dArr55, 0, dArr7.length);
                System.arraycopy(dArr11, 0, dArr52, 0, dArr7.length);
                iMin = 1;
                if (i34 == 1) {
                    graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator2;
                    if (z14) {
                        iMin2 = iMin;
                    } else {
                        iMin2 = i20;
                    }
                } else if (i34 <= i35) {
                    double[] dArr611 = this.costPerTimeUnit;
                    i11 = i34 - 1;
                    d8 = dArr611[i11];
                    graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator2;
                    d9 = this.orderControl1;
                    d10 = dArr611[i34];
                    if (d8 < d9 * d10) {
                        iMin2 = i11;
                    } else if (d10 < this.orderControl2 * d8) {
                        iMin = FastMath.min(i34 + 1, this.sequence.length - 2);
                        iMin2 = iMin;
                    } else {
                        iMin2 = i34;
                    }
                } else {
                    graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator2;
                    i6 = i34 - 1;
                    if (i34 > i20) {
                        dArr15 = this.costPerTimeUnit;
                        i10 = i34 - 2;
                        i7 = i6;
                        if (dArr15[i10] < this.orderControl1 * dArr15[i7]) {
                            i8 = i10;
                        }
                        dArr14 = this.costPerTimeUnit;
                        i9 = i8;
                        if (dArr14[i34] < this.orderControl2 * dArr14[i9]) {
                            i20 = 2;
                            iMin2 = FastMath.min(i34, this.sequence.length - 2);
                        } else {
                            i20 = 2;
                            iMin2 = i9;
                        }
                    } else {
                        i7 = i6;
                    }
                    i8 = i7;
                    dArr14 = this.costPerTimeUnit;
                    i9 = i8;
                    if (dArr14[i34] < this.orderControl2 * dArr14[i9]) {
                        i20 = 2;
                        iMin2 = FastMath.min(i34, this.sequence.length - 2);
                    } else {
                        i20 = 2;
                        iMin2 = i9;
                    }
                }
                if (z14) {
                    int iMin4 = FastMath.min(iMin2, i34);
                    dMin2 = FastMath.min(FastMath.abs(this.stepSize), this.optimalStep[iMin4]);
                    i13 = iMin4;
                } else {
                    if (iMin2 <= i34) {
                        dFilterStep = this.optimalStep[iMin2];
                        i12 = iMin2;
                    } else {
                        if (i34 < i35) {
                            dArr16 = this.costPerTimeUnit;
                            i12 = iMin2;
                            if (dArr16[i34] < this.orderControl2 * dArr16[i34 - 1]) {
                                double d27 = this.optimalStep[i34];
                                int[] iArr9 = this.costPerStep;
                                dFilterStep = filterStep((((double) iArr9[i12 + 1]) * d27) / ((double) iArr9[i34]), z19, false);
                            }
                        } else {
                            i12 = iMin2;
                        }
                        double d28 = this.optimalStep[i34];
                        int[] iArr10 = this.costPerStep;
                        dFilterStep = filterStep((((double) iArr10[i12]) * d28) / ((double) iArr10[i34]), z19, false);
                    }
                    dMin2 = dFilterStep;
                    i13 = i12;
                }
                dArr13 = dArr52;
                d7 = d26;
                z11 = true;
                z12 = true;
                i21 = i13;
            } else {
                graggBulirschStoerStepInterpolator4 = graggBulirschStoerStepInterpolator;
                dArr11 = dArr6;
                dArr12 = dArr9;
                i21 = i35;
                d7 = dAbs;
                z11 = z6;
                dArr13 = dArr52;
            }
            dMin = FastMath.min(dMin2, d7);
            if (!z19) {
                dMin = -dMin;
            }
            if (z16) {
                z7 = false;
                this.isLastStep = false;
                z14 = true;
            } else {
                z7 = false;
                z14 = false;
            }
            if (this.isLastStep) {
                expandableStatefulODE.setTime(this.stepStart);
                expandableStatefulODE.setCompleteState(dArr55);
                resetInternalState();
                return;
            }
            double[] dArr612 = dArr3;
            dArr30 = dArr56;
            z10 = z19;
            dArr31 = dArr612;
            z13 = z7;
            dArr36 = dArr10;
            d11 = dMax;
            dArr33 = dArr11;
            dArr20 = dArr8;
            dArr32 = dArr12;
            dArr35 = dArr13;
            dInitializeStep = dMin;
            dArr37 = dArr7;
            dArr34 = dArr55;
        }
    }

    public void setControlFactors(double d, double d6, double d7, double d8) {
        if (d < 1.0E-4d || d > 0.9999d) {
            this.stepControl1 = 0.65d;
        } else {
            this.stepControl1 = d;
        }
        if (d6 < 1.0E-4d || d6 > 0.9999d) {
            this.stepControl2 = 0.94d;
        } else {
            this.stepControl2 = d6;
        }
        if (d7 < 1.0E-4d || d7 > 0.9999d) {
            this.stepControl3 = 0.02d;
        } else {
            this.stepControl3 = d7;
        }
        if (d8 < 1.0001d || d8 > 999.9d) {
            this.stepControl4 = 4.0d;
        } else {
            this.stepControl4 = d8;
        }
    }

    public void setInterpolationControl(boolean z6, int i5) {
        this.useInterpolationError = z6;
        if (i5 <= 0 || i5 >= 7) {
            this.mudif = 4;
        } else {
            this.mudif = i5;
        }
    }

    public void setOrderControl(int i5, double d, double d6) {
        if (i5 <= 6 || i5 % 2 != 0) {
            this.maxOrder = 18;
        }
        if (d < 1.0E-4d || d > 0.9999d) {
            this.orderControl1 = 0.8d;
        } else {
            this.orderControl1 = d;
        }
        if (d6 < 1.0E-4d || d6 > 0.9999d) {
            this.orderControl2 = 0.9d;
        } else {
            this.orderControl2 = d6;
        }
        initializeArrays();
    }

    public void setStabilityCheck(boolean z6, int i5, int i6, double d) {
        this.performTest = z6;
        if (i5 <= 0) {
            i5 = 2;
        }
        this.maxIter = i5;
        if (i6 <= 0) {
            i6 = 1;
        }
        this.maxChecks = i6;
        if (d < 1.0E-4d || d > 0.9999d) {
            this.stabilityReduction = 0.5d;
        } else {
            this.stabilityReduction = d;
        }
    }

    public GraggBulirschStoerIntegrator(double d, double d6, double[] dArr, double[] dArr2) {
        super(METHOD_NAME, d, d6, dArr, dArr2);
        setStabilityCheck(true, -1, -1, -1.0d);
        setControlFactors(-1.0d, -1.0d, -1.0d, -1.0d);
        setOrderControl(-1, -1.0d, -1.0d);
        setInterpolationControl(true, -1);
    }
}
