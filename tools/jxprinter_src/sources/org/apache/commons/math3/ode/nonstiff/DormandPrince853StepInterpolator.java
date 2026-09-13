package org.apache.commons.math3.ode.nonstiff;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class DormandPrince853StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double B_01 = 0.054293734116568765d;
    private static final double B_06 = 4.450312892752409d;
    private static final double B_07 = 1.8915178993145003d;
    private static final double B_08 = -5.801203960010585d;
    private static final double B_09 = 0.3111643669578199d;
    private static final double B_10 = -0.1521609496625161d;
    private static final double B_11 = 0.20136540080403034d;
    private static final double B_12 = 0.04471061572777259d;
    private static final double C14 = 0.1d;
    private static final double C15 = 0.2d;
    private static final double C16 = 0.7777777777777778d;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static final double[][] f6856D = {new double[]{-8.428938276109013d, 0.5667149535193777d, -3.0689499459498917d, 2.38466765651207d, 2.1170345824450285d, -0.871391583777973d, 2.2404374302607883d, 0.6315787787694688d, -0.08899033645133331d, 18.148505520854727d, -9.194632392478356d, -4.436036387594894d}, new double[]{10.427508642579134d, 242.28349177525817d, 165.20045171727028d, -374.5467547226902d, -22.113666853125302d, 7.733432668472264d, -30.674084731089398d, -9.332130526430229d, 15.697238121770845d, -31.139403219565178d, -9.35292435884448d, 35.81684148639408d}, new double[]{19.985053242002433d, -387.0373087493518d, -189.17813819516758d, 527.8081592054236d, -11.573902539959631d, 6.8812326946963d, -1.0006050966910838d, 0.7777137798053443d, -2.778205752353508d, -60.19669523126412d, 84.32040550667716d, 11.99229113618279d}, new double[]{-25.69393346270375d, -154.18974869023643d, -231.5293791760455d, 357.6391179106141d, 93.4053241836243d, -37.45832313645163d, 104.0996495089623d, 29.8402934266605d, -43.53345659001114d, 96.32455395918828d, -39.17726167561544d, -149.72683625798564d}};
    private static final double K14_01 = 0.0018737681664791894d;
    private static final double K14_06 = -4.450312892752409d;
    private static final double K14_07 = -1.6380176890978755d;
    private static final double K14_08 = 5.554964922539782d;
    private static final double K14_09 = -0.4353557902216363d;
    private static final double K14_10 = 0.30545274794128174d;
    private static final double K14_11 = -0.19316434850839564d;
    private static final double K14_12 = -0.03714271806722689d;
    private static final double K14_13 = -0.008298d;
    private static final double K15_01 = -0.022459085953066622d;
    private static final double K15_06 = -4.422011983080043d;
    private static final double K15_07 = -1.8379759110070617d;
    private static final double K15_08 = 5.746280211439194d;
    private static final double K15_09 = -0.3111643669578199d;
    private static final double K15_10 = 0.1521609496625161d;
    private static final double K15_11 = -0.2014737481327276d;
    private static final double K15_12 = -0.04432804463693693d;
    private static final double K15_13 = -3.4046500868740456E-4d;
    private static final double K15_14 = 0.1413124436746325d;
    private static final double K16_01 = -0.4831900357003607d;
    private static final double K16_06 = -9.147934308113573d;
    private static final double K16_07 = 5.791903296748099d;
    private static final double K16_08 = 9.870193778407696d;
    private static final double K16_09 = 0.04556282049746119d;
    private static final double K16_10 = 0.1521609496625161d;
    private static final double K16_11 = -0.20136540080403034d;
    private static final double K16_12 = -0.04471061572777259d;
    private static final double K16_13 = -0.0013990241651590145d;
    private static final double K16_14 = 2.9475147891527724d;
    private static final double K16_15 = -9.15095847217987d;
    private static final long serialVersionUID = 20111120;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private double[][] f6857v;
    private boolean vectorsInitialized;
    private double[][] yDotKLast;

    public DormandPrince853StepInterpolator() {
        this.yDotKLast = null;
        this.f6857v = null;
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        char c;
        char c6;
        char c7 = 6;
        char c8 = 5;
        char c9 = 2;
        if (this.vectorsInitialized) {
            c = 4;
            c6 = 3;
        } else {
            if (this.f6857v == null) {
                this.f6857v = new double[7][];
                for (int i5 = 0; i5 < 7; i5++) {
                    this.f6857v[i5] = new double[this.interpolatedState.length];
                }
            }
            finalizeStep();
            for (int i6 = 0; i6 < this.interpolatedState.length; i6++) {
                double[][] dArr = this.yDotK;
                double d7 = dArr[0][i6];
                double d8 = dArr[5][i6];
                double d9 = dArr[6][i6];
                double d10 = dArr[7][i6];
                double d11 = dArr[8][i6];
                double d12 = dArr[9][i6];
                double d13 = dArr[10][i6];
                double d14 = dArr[11][i6];
                double[] dArr2 = dArr[12];
                double d15 = dArr2[i6];
                double[][] dArr3 = this.yDotKLast;
                double d16 = dArr3[0][i6];
                double d17 = dArr3[1][i6];
                double d18 = dArr3[2][i6];
                double[][] dArr4 = this.f6857v;
                double[] dArr5 = dArr4[0];
                double d19 = (B_12 * d14) + (B_11 * d13) + (B_10 * d12) + (B_09 * d11) + (B_08 * d10) + (B_07 * d9) + (B_06 * d8) + (B_01 * d7);
                dArr5[i6] = d19;
                double d20 = d7 - d19;
                dArr4[1][i6] = d20;
                dArr4[2][i6] = (dArr5[i6] - d20) - dArr2[i6];
                int i7 = 0;
                while (true) {
                    double[][] dArr6 = f6856D;
                    if (i7 < dArr6.length) {
                        double[] dArr7 = this.f6857v[i7 + 3];
                        double[] dArr8 = dArr6[i7];
                        dArr7[i6] = (dArr8[11] * d18) + (dArr8[10] * d17) + (dArr8[9] * d16) + (dArr8[8] * d15) + (dArr8[7] * d14) + (dArr8[6] * d13) + (dArr8[5] * d12) + (dArr8[4] * d11) + (dArr8[3] * d10) + (dArr8[2] * d9) + (dArr8[1] * d8) + (dArr8[0] * d7);
                        i7++;
                    }
                }
            }
            c = 4;
            c6 = 3;
            this.vectorsInitialized = true;
        }
        double d21 = 1.0d - d;
        double d22 = d * 2.0d;
        double d23 = d * d;
        double d24 = 1.0d - d22;
        double d25 = (2.0d - (d * 3.0d)) * d;
        double d26 = (((d22 - 3.0d) * d) + 1.0d) * d22;
        double d27 = ((((5.0d * d) - 8.0d) * d) + 3.0d) * d23;
        double d28 = (((((15.0d - (6.0d * d)) * d) - 12.0d) * d) + 3.0d) * d23;
        double d29 = (((((18.0d - (7.0d * d)) * d) - 15.0d) * d) + 4.0d) * d23 * d;
        if (this.previousState == null || d > 0.5d) {
            int i8 = 0;
            while (true) {
                double[] dArr9 = this.interpolatedState;
                if (i8 >= dArr9.length) {
                    return;
                }
                double d30 = this.currentState[i8];
                double[][] dArr10 = this.f6857v;
                double[] dArr11 = dArr10[0];
                double d31 = dArr11[i8];
                double[] dArr12 = dArr10[1];
                double d32 = dArr12[i8];
                double[] dArr13 = dArr10[2];
                double d33 = dArr13[i8];
                double[] dArr14 = dArr10[c6];
                double d34 = dArr14[i8];
                double[] dArr15 = dArr10[c];
                double d35 = dArr15[i8];
                double[] dArr16 = dArr10[5];
                double d36 = dArr16[i8];
                double[] dArr17 = dArr10[6];
                dArr9[i8] = d30 - ((d31 - (((((((((((dArr17[i8] * d) + d36) * d21) + d35) * d) + d34) * d21) + d33) * d) + d32) * d)) * d6);
                this.interpolatedDerivatives[i8] = (dArr17[i8] * d29) + (dArr16[i8] * d28) + (dArr15[i8] * d27) + (dArr14[i8] * d26) + (dArr13[i8] * d25) + (dArr12[i8] * d24) + dArr11[i8];
                i8++;
            }
        } else {
            int i9 = 0;
            while (true) {
                double[] dArr18 = this.interpolatedState;
                if (i9 >= dArr18.length) {
                    return;
                }
                double d37 = this.previousState[i9];
                char c10 = c7;
                char c11 = c8;
                double d38 = this.f6865h * d;
                char c12 = c9;
                double[][] dArr19 = this.f6857v;
                double[] dArr20 = dArr19[0];
                double d39 = dArr20[i9];
                double[] dArr21 = dArr19[1];
                double d40 = dArr21[i9];
                double[] dArr22 = dArr19[c12];
                double d41 = dArr22[i9];
                double[] dArr23 = dArr19[c6];
                double d42 = dArr23[i9];
                double[] dArr24 = dArr19[c];
                double d43 = dArr24[i9];
                double[] dArr25 = dArr19[c11];
                double d44 = dArr25[i9];
                double[] dArr26 = dArr19[c10];
                dArr18[i9] = (((((((((((((dArr26[i9] * d) + d44) * d21) + d43) * d) + d42) * d21) + d41) * d) + d40) * d21) + d39) * d38) + d37;
                this.interpolatedDerivatives[i9] = (dArr26[i9] * d29) + (dArr25[i9] * d28) + (dArr24[i9] * d27) + (dArr23[i9] * d26) + (dArr22[i9] * d25) + (dArr21[i9] * d24) + dArr20[i9];
                i9++;
                c7 = c10;
                c8 = c11;
                c9 = c12;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new DormandPrince853StepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void doFinalize() {
        char c;
        char c6;
        double[] dArr = this.currentState;
        if (dArr == null) {
            return;
        }
        double[] dArr2 = new double[dArr.length];
        double globalPreviousTime = getGlobalPreviousTime();
        int i5 = 0;
        while (true) {
            double[] dArr3 = this.currentState;
            c = '\f';
            c6 = 11;
            if (i5 >= dArr3.length) {
                break;
            }
            double[][] dArr4 = this.yDotK;
            dArr2[i5] = (this.f6865h * ((dArr4[12][i5] * K14_13) + (dArr4[11][i5] * K14_12) + (dArr4[10][i5] * K14_11) + (dArr4[9][i5] * K14_10) + (dArr4[8][i5] * K14_09) + (dArr4[7][i5] * K14_08) + (dArr4[6][i5] * K14_07) + (dArr4[5][i5] * K14_06) + (dArr4[0][i5] * K14_01))) + dArr3[i5];
            i5++;
        }
        this.integrator.computeDerivatives((this.f6865h * C14) + globalPreviousTime, dArr2, this.yDotKLast[0]);
        int i6 = 0;
        while (true) {
            double[] dArr5 = this.currentState;
            if (i6 >= dArr5.length) {
                break;
            }
            double[][] dArr6 = this.yDotK;
            dArr2[i6] = (this.f6865h * ((this.yDotKLast[0][i6] * K15_14) + (dArr6[c][i6] * K15_13) + (dArr6[c6][i6] * K15_12) + (dArr6[10][i6] * K15_11) + (dArr6[9][i6] * 0.1521609496625161d) + (dArr6[8][i6] * K15_09) + (dArr6[7][i6] * K15_08) + (dArr6[6][i6] * K15_07) + (dArr6[5][i6] * K15_06) + (dArr6[0][i6] * K15_01))) + dArr5[i6];
            i6++;
            c6 = c6;
            c = c;
        }
        char c7 = c;
        char c8 = c6;
        this.integrator.computeDerivatives((this.f6865h * C15) + globalPreviousTime, dArr2, this.yDotKLast[1]);
        int i7 = 0;
        while (true) {
            double[] dArr7 = this.currentState;
            if (i7 >= dArr7.length) {
                this.integrator.computeDerivatives((this.f6865h * C16) + globalPreviousTime, dArr2, this.yDotKLast[2]);
                return;
            }
            double[][] dArr8 = this.yDotK;
            double d = (dArr8[c7][i7] * K16_13) + (dArr8[c8][i7] * K16_12) + (dArr8[10][i7] * K16_11) + (dArr8[9][i7] * 0.1521609496625161d) + (dArr8[8][i7] * K16_09) + (dArr8[7][i7] * K16_08) + (dArr8[6][i7] * K16_07) + (dArr8[5][i7] * K16_06) + (dArr8[0][i7] * K16_01);
            double[][] dArr9 = this.yDotKLast;
            dArr2[i7] = (this.f6865h * ((dArr9[1][i7] * K16_15) + (dArr9[0][i7] * K16_14) + d)) + dArr7[i7];
            i7++;
            c8 = 11;
        }
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator, org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        this.yDotKLast = new double[3][];
        int i5 = objectInput.readInt();
        double[][] dArr = this.yDotKLast;
        dArr[0] = i5 < 0 ? null : new double[i5];
        dArr[1] = i5 < 0 ? null : new double[i5];
        dArr[2] = i5 >= 0 ? new double[i5] : null;
        for (int i6 = 0; i6 < i5; i6++) {
            this.yDotKLast[0][i6] = objectInput.readDouble();
            this.yDotKLast[1][i6] = objectInput.readDouble();
            this.yDotKLast[2][i6] = objectInput.readDouble();
        }
        super.readExternal(objectInput);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator
    public void reinitialize(AbstractIntegrator abstractIntegrator, double[] dArr, double[][] dArr2, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        super.reinitialize(abstractIntegrator, dArr, dArr2, z6, equationsMapper, equationsMapperArr);
        int length = this.currentState.length;
        this.yDotKLast = new double[3][];
        int i5 = 0;
        while (true) {
            double[][] dArr3 = this.yDotKLast;
            if (i5 >= dArr3.length) {
                break;
            }
            dArr3[i5] = new double[length];
            i5++;
        }
        this.f6857v = new double[7][];
        int i6 = 0;
        while (true) {
            double[][] dArr4 = this.f6857v;
            if (i6 >= dArr4.length) {
                this.vectorsInitialized = false;
                return;
            } else {
                dArr4[i6] = new double[length];
                i6++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void storeTime(double d) {
        super.storeTime(d);
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator, org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        try {
            finalizeStep();
            double[] dArr = this.currentState;
            int length = dArr == null ? -1 : dArr.length;
            objectOutput.writeInt(length);
            for (int i5 = 0; i5 < length; i5++) {
                objectOutput.writeDouble(this.yDotKLast[0][i5]);
                objectOutput.writeDouble(this.yDotKLast[1][i5]);
                objectOutput.writeDouble(this.yDotKLast[2][i5]);
            }
            super.writeExternal(objectOutput);
        } catch (MaxCountExceededException e) {
            IOException iOException = new IOException(e.getLocalizedMessage());
            iOException.initCause(e);
            throw iOException;
        }
    }

    public DormandPrince853StepInterpolator(DormandPrince853StepInterpolator dormandPrince853StepInterpolator) {
        super(dormandPrince853StepInterpolator);
        double[] dArr = dormandPrince853StepInterpolator.currentState;
        if (dArr == null) {
            this.yDotKLast = null;
            this.f6857v = null;
            this.vectorsInitialized = false;
            return;
        }
        int length = dArr.length;
        this.yDotKLast = new double[3][];
        int i5 = 0;
        while (true) {
            double[][] dArr2 = this.yDotKLast;
            if (i5 >= dArr2.length) {
                break;
            }
            double[] dArr3 = new double[length];
            dArr2[i5] = dArr3;
            System.arraycopy(dormandPrince853StepInterpolator.yDotKLast[i5], 0, dArr3, 0, length);
            i5++;
        }
        this.f6857v = new double[7][];
        int i6 = 0;
        while (true) {
            double[][] dArr4 = this.f6857v;
            if (i6 < dArr4.length) {
                double[] dArr5 = new double[length];
                dArr4[i6] = dArr5;
                System.arraycopy(dormandPrince853StepInterpolator.f6857v[i6], 0, dArr5, 0, length);
                i6++;
            } else {
                this.vectorsInitialized = dormandPrince853StepInterpolator.vectorsInitialized;
                return;
            }
        }
    }
}
