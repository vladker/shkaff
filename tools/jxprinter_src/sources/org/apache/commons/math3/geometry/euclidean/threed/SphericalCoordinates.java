package org.apache.commons.math3.geometry.euclidean.threed;

import androidx.collection.a;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SphericalCoordinates implements Serializable {
    private static final long serialVersionUID = 20130206;
    private double[][] jacobian;
    private final double phi;
    private double[][] phiHessian;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final double f6794r;
    private double[][] rHessian;
    private final double theta;
    private double[][] thetaHessian;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Vector3D f6795v;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20130206;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final double f6796x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final double f6797y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final double f6798z;

        public DataTransferObject(double d, double d6, double d7) {
            this.f6796x = d;
            this.f6797y = d6;
            this.f6798z = d7;
        }

        private Object readResolve() {
            return new SphericalCoordinates(new Vector3D(this.f6796x, this.f6797y, this.f6798z));
        }
    }

    public SphericalCoordinates(Vector3D vector3D) {
        this.f6795v = vector3D;
        double norm = vector3D.getNorm();
        this.f6794r = norm;
        this.theta = vector3D.getAlpha();
        this.phi = FastMath.acos(vector3D.getZ() / norm);
    }

    private void computeHessians() {
        if (this.rHessian == null) {
            double x6 = this.f6795v.getX();
            double y6 = this.f6795v.getY();
            double z6 = this.f6795v.getZ();
            double d = x6 * x6;
            double d6 = y6 * y6;
            double d7 = z6 * z6;
            double d8 = d + d6;
            double dSqrt = FastMath.sqrt(d8);
            double d9 = d8 + d7;
            double d10 = this.f6794r;
            double d11 = x6 / d8;
            double d12 = y6 / d8;
            double d13 = (x6 / d10) / d9;
            double d14 = (y6 / d10) / d9;
            double d15 = (z6 / d10) / d9;
            Class cls = Double.TYPE;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, 3, 3);
            this.rHessian = dArr;
            double[] dArr2 = dArr[0];
            double d16 = y6 * d14;
            double d17 = z6 * d15;
            dArr2[0] = d16 + d17;
            double[] dArr3 = dArr[1];
            double d18 = -x6;
            dArr3[0] = d14 * d18;
            double[] dArr4 = dArr[2];
            double d19 = (-z6) * d13;
            dArr4[0] = d19;
            double d20 = d13 * x6;
            dArr3[1] = d20 + d17;
            dArr4[1] = (-y6) * d15;
            dArr4[2] = d20 + d16;
            dArr2[1] = dArr3[0];
            dArr2[2] = d19;
            dArr3[2] = dArr4[1];
            double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, 2, 2);
            this.thetaHessian = dArr5;
            double[] dArr6 = dArr5[0];
            dArr6[0] = d11 * 2.0d * d12;
            double[] dArr7 = dArr5[1];
            double d21 = (d12 * d12) - (d11 * d11);
            dArr7[0] = d21;
            dArr7[1] = d11 * (-2.0d) * d12;
            dArr6[1] = d21;
            double d22 = dSqrt * d9;
            double d23 = dSqrt * d22;
            double d24 = d22 * d9;
            double d25 = d24 * d8;
            double d26 = (3.0d * d8) + d7;
            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) cls, 3, 3);
            this.phiHessian = dArr8;
            double[] dArr9 = dArr8[0];
            dArr9[0] = ((d23 - (d * d26)) * z6) / d25;
            double[] dArr10 = dArr8[1];
            dArr10[0] = (((d18 * y6) * z6) * d26) / d25;
            double[] dArr11 = dArr8[2];
            double d27 = d8 - d7;
            double d28 = (x6 * d27) / d24;
            dArr11[0] = d28;
            dArr10[1] = ((d23 - (d6 * d26)) * z6) / d25;
            dArr11[1] = (y6 * d27) / d24;
            dArr11[2] = ((dSqrt * 2.0d) * d15) / this.f6794r;
            dArr9[1] = dArr10[0];
            dArr9[2] = d28;
            dArr10[2] = dArr11[1];
        }
    }

    private void computeJacobian() {
        if (this.jacobian == null) {
            double x6 = this.f6795v.getX();
            double y6 = this.f6795v.getY();
            double z6 = this.f6795v.getZ();
            double d = (y6 * y6) + (x6 * x6);
            double dSqrt = FastMath.sqrt(d);
            double d6 = (z6 * z6) + d;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 3, 3);
            this.jacobian = dArr;
            double[] dArr2 = dArr[0];
            double d7 = this.f6794r;
            dArr2[0] = x6 / d7;
            dArr2[1] = y6 / d7;
            dArr2[2] = z6 / d7;
            double[] dArr3 = dArr[1];
            dArr3[0] = (-y6) / d;
            dArr3[1] = x6 / d;
            double[] dArr4 = dArr[2];
            double d8 = dSqrt * d6;
            dArr4[0] = (x6 * z6) / d8;
            dArr4[1] = (y6 * z6) / d8;
            dArr4[2] = (-dSqrt) / d6;
        }
    }

    private Object writeReplace() {
        return new DataTransferObject(this.f6795v.getX(), this.f6795v.getY(), this.f6795v.getZ());
    }

    public Vector3D getCartesian() {
        return this.f6795v;
    }

    public double getPhi() {
        return this.phi;
    }

    public double getR() {
        return this.f6794r;
    }

    public double getTheta() {
        return this.theta;
    }

    public double[] toCartesianGradient(double[] dArr) {
        computeJacobian();
        double d = dArr[0];
        double[][] dArr2 = this.jacobian;
        double[] dArr3 = dArr2[0];
        double d6 = dArr3[0] * d;
        double d7 = dArr[1];
        double[] dArr4 = dArr2[1];
        double d8 = (dArr4[0] * d7) + d6;
        double d9 = dArr[2];
        double[] dArr5 = dArr2[2];
        return new double[]{(dArr5[0] * d9) + d8, (dArr5[1] * d9) + (d7 * dArr4[1]) + (dArr3[1] * d), (d9 * dArr5[2]) + (d * dArr3[2])};
    }

    public double[][] toCartesianHessian(double[][] dArr, double[] dArr2) {
        computeJacobian();
        computeHessians();
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, 3, 3);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, 3, 3);
        double[] dArr5 = dArr3[0];
        double[] dArr6 = dArr[0];
        double d = dArr6[0];
        double[][] dArr7 = this.jacobian;
        double[] dArr8 = dArr7[0];
        double d6 = d * dArr8[0];
        double[] dArr9 = dArr[1];
        double d7 = dArr9[0];
        double[] dArr10 = dArr7[1];
        double d8 = (d7 * dArr10[0]) + d6;
        double[] dArr11 = dArr[2];
        double d9 = dArr11[0];
        double[] dArr12 = dArr7[2];
        dArr5[0] = (d9 * dArr12[0]) + d8;
        double d10 = dArr6[0];
        double d11 = dArr8[1] * d10;
        double d12 = dArr9[0];
        double d13 = (dArr10[1] * d12) + d11;
        double d14 = dArr11[0];
        dArr5[1] = (dArr12[1] * d14) + d13;
        dArr5[2] = (d14 * dArr12[2]) + (d10 * dArr8[2]);
        double[] dArr13 = dArr3[1];
        double d15 = d12 * dArr8[0];
        double d16 = dArr9[1];
        double d17 = (dArr10[0] * d16) + d15;
        double d18 = dArr11[1];
        dArr13[0] = (dArr12[0] * d18) + d17;
        dArr13[1] = (d18 * dArr12[1]) + (d16 * dArr10[1]) + (dArr9[0] * dArr8[1]);
        double[] dArr14 = dArr3[2];
        double d19 = dArr11[0] * dArr8[0];
        double d20 = dArr11[1];
        double d21 = (dArr10[0] * d20) + d19;
        double d22 = dArr11[2];
        double d23 = (dArr12[0] * d22) + d21;
        dArr14[0] = d23;
        double d24 = dArr11[0];
        double d25 = (dArr12[1] * d22) + (d20 * dArr10[1]) + (dArr8[1] * d24);
        dArr14[1] = d25;
        double d26 = (d22 * dArr12[2]) + (d24 * dArr8[2]);
        dArr14[2] = d26;
        double[] dArr15 = dArr4[0];
        dArr15[0] = (dArr12[0] * d23) + (dArr10[0] * dArr13[0]) + (dArr8[0] * dArr5[0]);
        double[] dArr16 = dArr4[1];
        double d27 = dArr8[1];
        double d28 = dArr5[0] * d27;
        double d29 = dArr10[1];
        double d30 = (dArr13[0] * d29) + d28;
        double d31 = dArr12[1];
        dArr16[0] = (dArr14[0] * d31) + d30;
        double[] dArr17 = dArr4[2];
        double d32 = dArr8[2];
        double d33 = dArr5[0] * d32;
        double d34 = dArr12[2];
        dArr17[0] = (dArr14[0] * d34) + d33;
        dArr16[1] = (d31 * d25) + (d29 * dArr13[1]) + (d27 * dArr5[1]);
        dArr17[1] = (dArr14[1] * d34) + (dArr5[1] * d32);
        double d35 = (d34 * d26) + (d32 * dArr5[2]);
        dArr17[2] = d35;
        double d36 = dArr15[0];
        double d37 = dArr2[0];
        double[][] dArr18 = this.rHessian;
        double d38 = d37 * dArr18[0][0];
        double d39 = dArr2[1];
        double[][] dArr19 = this.thetaHessian;
        double d40 = (dArr19[0][0] * d39) + d38;
        double d41 = dArr2[2];
        double[][] dArr20 = this.phiHessian;
        dArr15[0] = a.A(d41, dArr20[0][0], d40, d36);
        double d42 = dArr16[0];
        double d43 = dArr2[0];
        double[] dArr21 = dArr18[1];
        double d44 = d43 * dArr21[0];
        double[] dArr22 = dArr19[1];
        double d45 = (dArr22[0] * d39) + d44;
        double[] dArr23 = dArr20[1];
        dArr16[0] = a.A(d41, dArr23[0], d45, d42);
        double d46 = dArr17[0];
        double d47 = dArr2[0];
        double[] dArr24 = dArr18[2];
        double d48 = d47 * dArr24[0];
        double[] dArr25 = dArr20[2];
        double dA = a.A(d41, dArr25[0], d48, d46);
        dArr17[0] = dA;
        double d49 = dArr16[1];
        double d50 = dArr2[0];
        dArr16[1] = a.A(d41, dArr23[1], (d39 * dArr22[1]) + (dArr21[1] * d50), d49);
        dArr17[1] = a.A(d41, dArr25[1], d50 * dArr24[1], dArr17[1]);
        dArr17[2] = a.A(d41, dArr25[2], d50 * dArr24[2], d35);
        dArr15[1] = dArr16[0];
        dArr15[2] = dA;
        dArr16[2] = dArr17[1];
        return dArr4;
    }

    public SphericalCoordinates(double d, double d6, double d7) {
        double dCos = FastMath.cos(d6);
        double dSin = FastMath.sin(d6);
        double dCos2 = FastMath.cos(d7);
        double dSin2 = FastMath.sin(d7);
        this.f6794r = d;
        this.theta = d6;
        this.phi = d7;
        this.f6795v = new Vector3D(dCos * d * dSin2, d * dSin * dSin2, d * dCos2);
    }
}
