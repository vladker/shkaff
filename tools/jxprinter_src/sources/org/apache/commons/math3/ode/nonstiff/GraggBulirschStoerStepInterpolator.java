package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class GraggBulirschStoerStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = 20110928;
    private int currentDegree;
    private double[] errfac;
    private double[][] polynomials;
    private double[] y0Dot;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private double[] f6860y1;
    private double[] y1Dot;
    private double[][] yMidDots;

    public GraggBulirschStoerStepInterpolator() {
        this.y0Dot = null;
        this.f6860y1 = null;
        this.y1Dot = null;
        this.yMidDots = null;
        resetTables(-1);
    }

    private void resetTables(int i5) {
        if (i5 < 0) {
            this.polynomials = null;
            this.errfac = null;
            this.currentDegree = -1;
            return;
        }
        int i6 = i5 + 1;
        double[][] dArr = new double[i6][];
        double[][] dArr2 = this.polynomials;
        if (dArr2 != null) {
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
            for (int length = this.polynomials.length; length < i6; length++) {
                dArr[length] = new double[this.currentState.length];
            }
        } else {
            for (int i7 = 0; i7 < i6; i7++) {
                dArr[i7] = new double[this.currentState.length];
            }
        }
        this.polynomials = dArr;
        if (i5 > 4) {
            this.errfac = new double[i5 - 4];
            int i8 = 0;
            while (true) {
                double[] dArr3 = this.errfac;
                if (i8 >= dArr3.length) {
                    break;
                }
                int i9 = i8 + 5;
                dArr3[i8] = 1.0d / ((double) (i9 * i9));
                int i10 = i8 + 1;
                double dSqrt = FastMath.sqrt(((double) i10) / ((double) i9)) * 0.5d;
                int i11 = 0;
                while (i11 <= i8) {
                    double[] dArr4 = this.errfac;
                    i11++;
                    dArr4[i8] = (dSqrt / ((double) i11)) * dArr4[i8];
                }
                i8 = i10;
            }
        } else {
            this.errfac = null;
        }
        this.currentDegree = 0;
    }

    public void computeCoefficients(int i5, double d) {
        double[][] dArr = this.polynomials;
        if (dArr == null || dArr.length <= i5 + 4) {
            resetTables(i5 + 4);
        }
        this.currentDegree = i5 + 4;
        char c = 0;
        int i6 = 0;
        while (true) {
            double[] dArr2 = this.currentState;
            if (i6 >= dArr2.length) {
                return;
            }
            double d6 = this.y0Dot[i6] * d;
            double d7 = this.y1Dot[i6] * d;
            double[] dArr3 = this.f6860y1;
            double d8 = dArr3[i6];
            double d9 = dArr2[i6];
            double d10 = d8 - d9;
            double d11 = d10 - d7;
            double d12 = d6 - d10;
            double[][] dArr4 = this.polynomials;
            dArr4[c][i6] = d9;
            dArr4[1][i6] = d10;
            dArr4[2][i6] = d11;
            dArr4[3][i6] = d12;
            if (i5 < 0) {
                return;
            }
            double d13 = ((d11 + d12) * 0.125d) + ((dArr2[i6] + dArr3[i6]) * 0.5d);
            double[] dArr5 = dArr4[4];
            char c6 = c;
            double[][] dArr6 = this.yMidDots;
            dArr5[i6] = (dArr6[c6][i6] - d13) * 16.0d;
            if (i5 > 0) {
                double dA = a.a(d11, d12, 0.25d, d10);
                double[] dArr7 = dArr4[5];
                dArr7[i6] = (dArr6[1][i6] - dA) * 16.0d;
                if (i5 > 1) {
                    dArr4[6][i6] = ((dArr6[2][i6] - (d7 - d6)) + dArr5[i6]) * 16.0d;
                    if (i5 > 2) {
                        dArr4[7][i6] = a.B(dArr7[i6], 3.0d, dArr6[3][i6] - ((d12 - d11) * 6.0d), 16.0d);
                        for (int i7 = 4; i7 <= i5; i7++) {
                            double d14 = ((double) i7) * 0.5d * ((double) (i7 - 1));
                            double[][] dArr8 = this.polynomials;
                            dArr8[i7 + 4][i6] = (((d14 * dArr8[i7 + 2][i6]) + this.yMidDots[i7][i6]) - ((((2.0d * d14) * ((double) (i7 - 2))) * ((double) (i7 - 3))) * dArr8[i7][i6])) * 16.0d;
                        }
                    }
                }
            }
            i6++;
            c = c6;
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        int i5;
        int i6;
        int length = this.currentState.length;
        double d7 = 1.0d;
        double d8 = 1.0d - d;
        double d9 = d - 0.5d;
        double d10 = d * d8;
        double d11 = d10 * d10;
        double d12 = d10 * 2.0d * (1.0d - (d * 2.0d));
        double d13 = this.f6865h;
        double d14 = 1.0d / d13;
        double d15 = 3.0d * d;
        double d16 = ((2.0d - d15) * d) / d13;
        double d17 = (((d15 - 4.0d) * d) + 1.0d) / d13;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            double d18 = 0.0d;
            if (i8 >= length) {
                break;
            }
            double[][] dArr = this.polynomials;
            double d19 = dArr[i7][i8];
            double d20 = dArr[1][i8];
            double d21 = dArr[2][i8];
            int i9 = 3;
            double d22 = dArr[3][i8];
            double d23 = d7;
            this.interpolatedState[i8] = (((((d22 * d8) + (d21 * d)) * d8) + d20) * d) + d19;
            this.interpolatedDerivatives[i8] = (d22 * d17) + (d21 * d16) + (d20 * d14);
            int i10 = this.currentDegree;
            if (i10 > 3) {
                double d24 = dArr[i10][i8];
                int i11 = i10 - 1;
                while (i11 > i9) {
                    int i12 = i8;
                    double d25 = d23 / ((double) (i11 - 3));
                    double d26 = d9;
                    double d27 = d24;
                    double dB = a.B(d26, d18, d27, d25);
                    d9 = d26;
                    double dC = a.C(d27, d25, d9, this.polynomials[i11][i12]);
                    i11--;
                    d24 = dC;
                    i8 = i12;
                    d18 = dB;
                    i9 = 3;
                    i7 = 0;
                }
                i5 = i7;
                i6 = i8;
                double d28 = d24;
                double[] dArr2 = this.interpolatedState;
                dArr2[i6] = (d11 * d28) + dArr2[i6];
                double[] dArr3 = this.interpolatedDerivatives;
                dArr3[i6] = (((d12 * d28) + (d18 * d11)) / this.f6865h) + dArr3[i6];
            } else {
                i5 = i7;
                i6 = i8;
            }
            i8 = i6 + 1;
            i7 = i5;
            d7 = d23;
        }
        int i13 = i7;
        if (this.f6865h == 0.0d) {
            System.arraycopy(this.yMidDots[1], i13, this.interpolatedDerivatives, i13, length);
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new GraggBulirschStoerStepInterpolator(this);
    }

    public double estimateError(double[] dArr) {
        double d = 0.0d;
        if (this.currentDegree < 5) {
            return 0.0d;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double d6 = this.polynomials[this.currentDegree][i5] / dArr[i5];
            d += d6 * d6;
        }
        return FastMath.sqrt(d / ((double) dArr.length)) * this.errfac[this.currentDegree - 5];
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        double baseExternal = readBaseExternal(objectInput);
        double[] dArr = this.currentState;
        int length = dArr == null ? -1 : dArr.length;
        int i5 = objectInput.readInt();
        resetTables(i5);
        this.currentDegree = i5;
        for (int i6 = 0; i6 <= this.currentDegree; i6++) {
            for (int i7 = 0; i7 < length; i7++) {
                this.polynomials[i6][i7] = objectInput.readDouble();
            }
        }
        setInterpolatedTime(baseExternal);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        double[] dArr = this.currentState;
        int length = dArr == null ? -1 : dArr.length;
        writeBaseExternal(objectOutput);
        objectOutput.writeInt(this.currentDegree);
        for (int i5 = 0; i5 <= this.currentDegree; i5++) {
            for (int i6 = 0; i6 < length; i6++) {
                objectOutput.writeDouble(this.polynomials[i5][i6]);
            }
        }
    }

    public GraggBulirschStoerStepInterpolator(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[][] dArr5, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        super(dArr, z6, equationsMapper, equationsMapperArr);
        this.y0Dot = dArr2;
        this.f6860y1 = dArr3;
        this.y1Dot = dArr4;
        this.yMidDots = dArr5;
        resetTables(dArr5.length + 4);
    }

    public GraggBulirschStoerStepInterpolator(GraggBulirschStoerStepInterpolator graggBulirschStoerStepInterpolator) {
        super(graggBulirschStoerStepInterpolator);
        int length = this.currentState.length;
        this.y0Dot = null;
        this.f6860y1 = null;
        this.y1Dot = null;
        this.yMidDots = null;
        if (graggBulirschStoerStepInterpolator.polynomials == null) {
            this.polynomials = null;
            this.currentDegree = -1;
            return;
        }
        resetTables(graggBulirschStoerStepInterpolator.currentDegree);
        int i5 = 0;
        while (true) {
            double[][] dArr = this.polynomials;
            if (i5 < dArr.length) {
                double[] dArr2 = new double[length];
                dArr[i5] = dArr2;
                System.arraycopy(graggBulirschStoerStepInterpolator.polynomials[i5], 0, dArr2, 0, length);
                i5++;
            } else {
                this.currentDegree = graggBulirschStoerStepInterpolator.currentDegree;
                return;
            }
        }
    }
}
