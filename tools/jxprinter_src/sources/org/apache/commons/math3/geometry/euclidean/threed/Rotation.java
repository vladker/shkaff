package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Rotation implements Serializable {
    public static final Rotation IDENTITY = new Rotation(1.0d, 0.0d, 0.0d, 0.0d, false);
    private static final long serialVersionUID = -2153622329907944313L;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final double f6787q0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private final double f6788q1;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    private final double f6789q2;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    private final double f6790q3;

    public Rotation(double d, double d6, double d7, double d8, boolean z6) {
        if (z6) {
            double dSqrt = 1.0d / FastMath.sqrt((d8 * d8) + ((d7 * d7) + ((d6 * d6) + (d * d))));
            d *= dSqrt;
            d6 *= dSqrt;
            d7 *= dSqrt;
            d8 *= dSqrt;
        }
        this.f6787q0 = d;
        this.f6788q1 = d6;
        this.f6789q2 = d7;
        this.f6790q3 = d8;
    }

    private Rotation composeInternal(Rotation rotation) {
        double d = rotation.f6787q0;
        double d6 = this.f6787q0;
        double d7 = rotation.f6788q1;
        double d8 = this.f6788q1;
        double d9 = rotation.f6789q2;
        double d10 = this.f6789q2;
        double d11 = rotation.f6790q3;
        double d12 = this.f6790q3;
        return new Rotation((d * d6) - ((d11 * d12) + ((d9 * d10) + (d7 * d8))), ((d9 * d12) - (d11 * d10)) + (d * d8) + (d7 * d6), ((d11 * d8) - (d7 * d12)) + (d * d10) + (d9 * d6), ((d7 * d10) - (d9 * d8)) + (d12 * d) + (d11 * d6), false);
    }

    private Rotation composeInverseInternal(Rotation rotation) {
        double d = rotation.f6787q0;
        double d6 = this.f6787q0;
        double d7 = rotation.f6788q1;
        double d8 = this.f6788q1;
        double d9 = rotation.f6789q2;
        double d10 = this.f6789q2;
        double d11 = (d9 * d10) + (d7 * d8);
        double d12 = rotation.f6790q3;
        double d13 = this.f6790q3;
        return new Rotation(((-d) * d6) - ((d12 * d13) + d11), ((d9 * d13) - (d12 * d10)) + (d * d8) + ((-d7) * d6), ((d12 * d8) - (d7 * d13)) + (d * d10) + ((-d9) * d6), ((d7 * d10) - (d9 * d8)) + (d13 * d) + ((-d12) * d6), false);
    }

    public static double distance(Rotation rotation, Rotation rotation2) {
        return rotation.composeInverseInternal(rotation2).getAngle();
    }

    private static double[] mat2quat(double[][] dArr) {
        double[] dArr2 = new double[4];
        double d = dArr[0][0];
        double d6 = dArr[1][1];
        double d7 = dArr[2][2];
        double d8 = d + d6 + d7;
        if (d8 > -0.19d) {
            double dSqrt = FastMath.sqrt(d8 + 1.0d) * 0.5d;
            dArr2[0] = dSqrt;
            double d9 = 0.25d / dSqrt;
            double[] dArr3 = dArr[1];
            double d10 = dArr3[2];
            double[] dArr4 = dArr[2];
            dArr2[1] = (d10 - dArr4[1]) * d9;
            double d11 = dArr4[0];
            double[] dArr5 = dArr[0];
            dArr2[2] = (d11 - dArr5[2]) * d9;
            dArr2[3] = (dArr5[1] - dArr3[0]) * d9;
            return dArr2;
        }
        double d12 = (d - d6) - d7;
        if (d12 > -0.19d) {
            double dSqrt2 = FastMath.sqrt(d12 + 1.0d) * 0.5d;
            dArr2[1] = dSqrt2;
            double d13 = 0.25d / dSqrt2;
            double[] dArr6 = dArr[1];
            double d14 = dArr6[2];
            double[] dArr7 = dArr[2];
            dArr2[0] = (d14 - dArr7[1]) * d13;
            double[] dArr8 = dArr[0];
            dArr2[2] = (dArr8[1] + dArr6[0]) * d13;
            dArr2[3] = (dArr8[2] + dArr7[0]) * d13;
            return dArr2;
        }
        double d15 = (d6 - d) - d7;
        if (d15 > -0.19d) {
            double dSqrt3 = FastMath.sqrt(d15 + 1.0d) * 0.5d;
            dArr2[2] = dSqrt3;
            double d16 = 0.25d / dSqrt3;
            double[] dArr9 = dArr[2];
            double d17 = dArr9[0];
            double[] dArr10 = dArr[0];
            dArr2[0] = (d17 - dArr10[2]) * d16;
            double d18 = dArr10[1];
            double[] dArr11 = dArr[1];
            dArr2[1] = (d18 + dArr11[0]) * d16;
            dArr2[3] = (dArr9[1] + dArr11[2]) * d16;
            return dArr2;
        }
        double dSqrt4 = FastMath.sqrt(((d7 - d) - d6) + 1.0d) * 0.5d;
        dArr2[3] = dSqrt4;
        double d19 = 0.25d / dSqrt4;
        double[] dArr12 = dArr[0];
        double d20 = dArr12[1];
        double[] dArr13 = dArr[1];
        dArr2[0] = (d20 - dArr13[0]) * d19;
        double d21 = dArr12[2];
        double[] dArr14 = dArr[2];
        dArr2[1] = (d21 + dArr14[0]) * d19;
        dArr2[2] = (dArr14[1] + dArr13[2]) * d19;
        return dArr2;
    }

    private double[][] orthogonalizeMatrix(double[][] dArr, double d) {
        double[] dArr2 = dArr[0];
        double[] dArr3 = dArr[1];
        char c = 2;
        double[] dArr4 = dArr[2];
        double d6 = dArr2[0];
        double d7 = dArr2[1];
        double d8 = dArr2[2];
        double d9 = dArr3[0];
        double d10 = dArr3[1];
        double d11 = dArr3[2];
        double d12 = dArr4[0];
        double d13 = dArr4[1];
        double d14 = dArr4[2];
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 3, 3);
        double[] dArr6 = dArr5[0];
        double[] dArr7 = dArr5[1];
        double[] dArr8 = dArr5[2];
        double d15 = 0.0d;
        int i5 = 0;
        while (true) {
            char c6 = c;
            int i6 = i5 + 1;
            double[][] dArr9 = dArr5;
            if (i6 >= 11) {
                throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, Integer.valueOf(i5));
            }
            double d16 = dArr2[0];
            double d17 = dArr3[0];
            double d18 = dArr4[0];
            double d19 = (d18 * d12) + (d17 * d9) + (d16 * d6);
            double d20 = dArr2[1];
            double d21 = dArr3[1];
            double d22 = dArr4[1];
            double d23 = (d22 * d12) + (d21 * d9) + (d20 * d6);
            double d24 = dArr2[c6];
            double d25 = dArr3[c6];
            double d26 = dArr4[c6];
            double d27 = (d26 * d12) + (d25 * d9) + (d24 * d6);
            double d28 = (d18 * d13) + (d17 * d10) + (d16 * d7);
            double d29 = (d22 * d13) + (d21 * d10) + (d20 * d7);
            double d30 = (d26 * d13) + (d25 * d10) + (d24 * d7);
            double d31 = (d18 * d14) + (d17 * d11) + (d16 * d8);
            double d32 = (d22 * d14) + (d21 * d11) + (d20 * d8);
            double d33 = (d26 * d14) + (d25 * d11) + (d24 * d8);
            dArr6[0] = d6 - ((((d8 * d27) + ((d7 * d23) + (d6 * d19))) - d16) * 0.5d);
            dArr6[1] = d7 - ((((d8 * d30) + ((d7 * d29) + (d6 * d28))) - d20) * 0.5d);
            dArr6[c6] = d8 - ((((d8 * d33) + ((d7 * d32) + (d6 * d31))) - d24) * 0.5d);
            dArr7[0] = d9 - ((((d11 * d27) + ((d10 * d23) + (d9 * d19))) - dArr3[0]) * 0.5d);
            dArr7[1] = d10 - ((((d11 * d30) + ((d10 * d29) + (d9 * d28))) - dArr3[1]) * 0.5d);
            dArr7[c6] = d11 - ((((d11 * d33) + ((d10 * d32) + (d9 * d31))) - dArr3[c6]) * 0.5d);
            double d34 = d12 - ((((d27 * d14) + ((d23 * d13) + (d19 * d12))) - dArr4[0]) * 0.5d);
            dArr8[0] = d34;
            double d35 = d13 - ((((d30 * d14) + ((d29 * d13) + (d28 * d12))) - dArr4[1]) * 0.5d);
            dArr8[1] = d35;
            double d36 = d14 - ((((d33 * d14) + ((d13 * d32) + (d12 * d31))) - dArr4[c6]) * 0.5d);
            dArr8[c6] = d36;
            double d37 = dArr6[0] - dArr2[0];
            double d38 = dArr6[1] - dArr2[1];
            double d39 = dArr6[c6] - dArr2[c6];
            double d40 = dArr7[0] - dArr3[0];
            double d41 = dArr7[1] - dArr3[1];
            double d42 = dArr7[c6] - dArr3[c6];
            double d43 = d34 - dArr4[0];
            double d44 = d35 - dArr4[1];
            double d45 = d36 - dArr4[c6];
            double d46 = d41 * d41;
            double d47 = d42 * d42;
            double d48 = d43 * d43;
            double d49 = d44 * d44;
            double d50 = d45 * d45;
            double d51 = d50 + d49 + d48 + d47 + d46 + (d40 * d40) + (d39 * d39) + (d38 * d38) + (d37 * d37);
            if (FastMath.abs(d51 - d15) <= d) {
                return dArr9;
            }
            double d52 = dArr6[0];
            double d53 = dArr6[1];
            double d54 = dArr6[c6];
            double d55 = dArr7[0];
            double d56 = dArr7[1];
            d15 = d51;
            d6 = d52;
            d7 = d53;
            d8 = d54;
            d9 = d55;
            d10 = d56;
            d11 = dArr7[c6];
            d12 = dArr8[0];
            d13 = dArr8[1];
            d14 = dArr8[c6];
            dArr5 = dArr9;
            i5 = i6;
            c = c6;
        }
    }

    public Vector3D applyInverseTo(Vector3D vector3D) {
        double x6 = vector3D.getX();
        double y6 = vector3D.getY();
        double z6 = vector3D.getZ();
        double d = (this.f6790q3 * z6) + (this.f6789q2 * y6) + (this.f6788q1 * x6);
        double d6 = -this.f6787q0;
        double d7 = x6 * d6;
        double d8 = this.f6789q2;
        double d9 = this.f6790q3;
        double d10 = (d7 - ((d8 * z6) - (d9 * y6))) * d6;
        double d11 = this.f6788q1;
        return new Vector3D((((d * d11) + d10) * 2.0d) - x6, (((d * d8) + (((y6 * d6) - ((d9 * x6) - (d11 * z6))) * d6)) * 2.0d) - y6, (((d * d9) + (((z6 * d6) - ((d11 * y6) - (d8 * x6))) * d6)) * 2.0d) - z6);
    }

    public Vector3D applyTo(Vector3D vector3D) {
        double x6 = vector3D.getX();
        double y6 = vector3D.getY();
        double z6 = vector3D.getZ();
        double d = (this.f6790q3 * z6) + (this.f6789q2 * y6) + (this.f6788q1 * x6);
        double d6 = this.f6787q0;
        double d7 = x6 * d6;
        double d8 = this.f6789q2;
        double d9 = this.f6790q3;
        double d10 = (d7 - ((d8 * z6) - (d9 * y6))) * d6;
        double d11 = this.f6788q1;
        return new Vector3D((((d * d11) + d10) * 2.0d) - x6, (((d * d8) + (((y6 * d6) - ((d9 * x6) - (d11 * z6))) * d6)) * 2.0d) - y6, (((d * d9) + (((z6 * d6) - ((d11 * y6) - (d8 * x6))) * d6)) * 2.0d) - z6);
    }

    public Rotation compose(Rotation rotation, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? composeInternal(rotation) : rotation.composeInternal(this);
    }

    public Rotation composeInverse(Rotation rotation, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? composeInverseInternal(rotation) : rotation.composeInternal(revert());
    }

    public double getAngle() {
        double dAsin;
        double d = this.f6787q0;
        if (d < -0.1d || d > 0.1d) {
            double d6 = this.f6788q1;
            double d7 = this.f6789q2;
            double d8 = (d7 * d7) + (d6 * d6);
            double d9 = this.f6790q3;
            dAsin = FastMath.asin(FastMath.sqrt((d9 * d9) + d8));
        } else {
            dAsin = d < 0.0d ? FastMath.acos(-d) : FastMath.acos(d);
        }
        return dAsin * 2.0d;
    }

    @Deprecated
    public double[] getAngles(RotationOrder rotationOrder) {
        return getAngles(rotationOrder, RotationConvention.VECTOR_OPERATOR);
    }

    @Deprecated
    public Vector3D getAxis() {
        return getAxis(RotationConvention.VECTOR_OPERATOR);
    }

    public double[][] getMatrix() {
        double d = this.f6787q0;
        double d6 = d * d;
        double d7 = this.f6788q1;
        double d8 = d * d7;
        double d9 = this.f6789q2;
        double d10 = d * d9;
        double d11 = this.f6790q3;
        double d12 = d * d11;
        double d13 = d7 * d7;
        double d14 = d7 * d9;
        double d15 = d7 * d11;
        double d16 = d9 * d9;
        double d17 = d9 * d11;
        double[][] dArr = {new double[3], new double[3], new double[3]};
        double[] dArr2 = dArr[0];
        dArr2[0] = ((d13 + d6) * 2.0d) - 1.0d;
        double[] dArr3 = dArr[1];
        dArr3[0] = (d14 - d12) * 2.0d;
        double[] dArr4 = dArr[2];
        dArr4[0] = (d15 + d10) * 2.0d;
        dArr2[1] = (d14 + d12) * 2.0d;
        dArr3[1] = ((d6 + d16) * 2.0d) - 1.0d;
        dArr4[1] = (d17 - d8) * 2.0d;
        dArr2[2] = (d15 - d10) * 2.0d;
        dArr3[2] = (d17 + d8) * 2.0d;
        dArr4[2] = ((d6 + (d11 * d11)) * 2.0d) - 1.0d;
        return dArr;
    }

    public double getQ0() {
        return this.f6787q0;
    }

    public double getQ1() {
        return this.f6788q1;
    }

    public double getQ2() {
        return this.f6789q2;
    }

    public double getQ3() {
        return this.f6790q3;
    }

    public Rotation revert() {
        return new Rotation(-this.f6787q0, this.f6788q1, this.f6789q2, this.f6790q3, false);
    }

    public double[] getAngles(RotationOrder rotationOrder, RotationConvention rotationConvention) {
        if (rotationConvention == RotationConvention.VECTOR_OPERATOR) {
            if (rotationOrder == RotationOrder.XYZ) {
                Vector3D vector3DApplyTo = applyTo(Vector3D.PLUS_K);
                Vector3D vector3DApplyInverseTo = applyInverseTo(Vector3D.PLUS_I);
                if (vector3DApplyInverseTo.getZ() < -0.9999999999d || vector3DApplyInverseTo.getZ() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{FastMath.atan2(-vector3DApplyTo.getY(), vector3DApplyTo.getZ()), FastMath.asin(vector3DApplyInverseTo.getZ()), FastMath.atan2(-vector3DApplyInverseTo.getY(), vector3DApplyInverseTo.getX())};
            }
            if (rotationOrder == RotationOrder.XZY) {
                Vector3D vector3DApplyTo2 = applyTo(Vector3D.PLUS_J);
                Vector3D vector3DApplyInverseTo2 = applyInverseTo(Vector3D.PLUS_I);
                if (vector3DApplyInverseTo2.getY() < -0.9999999999d || vector3DApplyInverseTo2.getY() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo2.getZ(), vector3DApplyTo2.getY()), -FastMath.asin(vector3DApplyInverseTo2.getY()), FastMath.atan2(vector3DApplyInverseTo2.getZ(), vector3DApplyInverseTo2.getX())};
            }
            if (rotationOrder == RotationOrder.YXZ) {
                Vector3D vector3DApplyTo3 = applyTo(Vector3D.PLUS_K);
                Vector3D vector3DApplyInverseTo3 = applyInverseTo(Vector3D.PLUS_J);
                if (vector3DApplyInverseTo3.getZ() < -0.9999999999d || vector3DApplyInverseTo3.getZ() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo3.getX(), vector3DApplyTo3.getZ()), -FastMath.asin(vector3DApplyInverseTo3.getZ()), FastMath.atan2(vector3DApplyInverseTo3.getX(), vector3DApplyInverseTo3.getY())};
            }
            if (rotationOrder == RotationOrder.YZX) {
                Vector3D vector3DApplyTo4 = applyTo(Vector3D.PLUS_I);
                Vector3D vector3DApplyInverseTo4 = applyInverseTo(Vector3D.PLUS_J);
                if (vector3DApplyInverseTo4.getX() < -0.9999999999d || vector3DApplyInverseTo4.getX() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{FastMath.atan2(-vector3DApplyTo4.getZ(), vector3DApplyTo4.getX()), FastMath.asin(vector3DApplyInverseTo4.getX()), FastMath.atan2(-vector3DApplyInverseTo4.getZ(), vector3DApplyInverseTo4.getY())};
            }
            if (rotationOrder == RotationOrder.ZXY) {
                Vector3D vector3DApplyTo5 = applyTo(Vector3D.PLUS_J);
                Vector3D vector3DApplyInverseTo5 = applyInverseTo(Vector3D.PLUS_K);
                if (vector3DApplyInverseTo5.getY() < -0.9999999999d || vector3DApplyInverseTo5.getY() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{FastMath.atan2(-vector3DApplyTo5.getX(), vector3DApplyTo5.getY()), FastMath.asin(vector3DApplyInverseTo5.getY()), FastMath.atan2(-vector3DApplyInverseTo5.getX(), vector3DApplyInverseTo5.getZ())};
            }
            if (rotationOrder == RotationOrder.ZYX) {
                Vector3D vector3DApplyTo6 = applyTo(Vector3D.PLUS_I);
                Vector3D vector3DApplyInverseTo6 = applyInverseTo(Vector3D.PLUS_K);
                if (vector3DApplyInverseTo6.getX() < -0.9999999999d || vector3DApplyInverseTo6.getX() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo6.getY(), vector3DApplyTo6.getX()), -FastMath.asin(vector3DApplyInverseTo6.getX()), FastMath.atan2(vector3DApplyInverseTo6.getY(), vector3DApplyInverseTo6.getZ())};
            }
            if (rotationOrder == RotationOrder.XYX) {
                Vector3D vector3D = Vector3D.PLUS_I;
                Vector3D vector3DApplyTo7 = applyTo(vector3D);
                Vector3D vector3DApplyInverseTo7 = applyInverseTo(vector3D);
                if (vector3DApplyInverseTo7.getX() < -0.9999999999d || vector3DApplyInverseTo7.getX() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo7.getY(), -vector3DApplyTo7.getZ()), FastMath.acos(vector3DApplyInverseTo7.getX()), FastMath.atan2(vector3DApplyInverseTo7.getY(), vector3DApplyInverseTo7.getZ())};
            }
            if (rotationOrder == RotationOrder.XZX) {
                Vector3D vector3D2 = Vector3D.PLUS_I;
                Vector3D vector3DApplyTo8 = applyTo(vector3D2);
                Vector3D vector3DApplyInverseTo8 = applyInverseTo(vector3D2);
                if (vector3DApplyInverseTo8.getX() < -0.9999999999d || vector3DApplyInverseTo8.getX() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo8.getZ(), vector3DApplyTo8.getY()), FastMath.acos(vector3DApplyInverseTo8.getX()), FastMath.atan2(vector3DApplyInverseTo8.getZ(), -vector3DApplyInverseTo8.getY())};
            }
            if (rotationOrder == RotationOrder.YXY) {
                Vector3D vector3D3 = Vector3D.PLUS_J;
                Vector3D vector3DApplyTo9 = applyTo(vector3D3);
                Vector3D vector3DApplyInverseTo9 = applyInverseTo(vector3D3);
                if (vector3DApplyInverseTo9.getY() < -0.9999999999d || vector3DApplyInverseTo9.getY() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo9.getX(), vector3DApplyTo9.getZ()), FastMath.acos(vector3DApplyInverseTo9.getY()), FastMath.atan2(vector3DApplyInverseTo9.getX(), -vector3DApplyInverseTo9.getZ())};
            }
            if (rotationOrder == RotationOrder.YZY) {
                Vector3D vector3D4 = Vector3D.PLUS_J;
                Vector3D vector3DApplyTo10 = applyTo(vector3D4);
                Vector3D vector3DApplyInverseTo10 = applyInverseTo(vector3D4);
                if (vector3DApplyInverseTo10.getY() < -0.9999999999d || vector3DApplyInverseTo10.getY() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo10.getZ(), -vector3DApplyTo10.getX()), FastMath.acos(vector3DApplyInverseTo10.getY()), FastMath.atan2(vector3DApplyInverseTo10.getZ(), vector3DApplyInverseTo10.getX())};
            }
            if (rotationOrder == RotationOrder.ZXZ) {
                Vector3D vector3D5 = Vector3D.PLUS_K;
                Vector3D vector3DApplyTo11 = applyTo(vector3D5);
                Vector3D vector3DApplyInverseTo11 = applyInverseTo(vector3D5);
                if (vector3DApplyInverseTo11.getZ() < -0.9999999999d || vector3DApplyInverseTo11.getZ() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return new double[]{FastMath.atan2(vector3DApplyTo11.getX(), -vector3DApplyTo11.getY()), FastMath.acos(vector3DApplyInverseTo11.getZ()), FastMath.atan2(vector3DApplyInverseTo11.getX(), vector3DApplyInverseTo11.getY())};
            }
            Vector3D vector3D6 = Vector3D.PLUS_K;
            Vector3D vector3DApplyTo12 = applyTo(vector3D6);
            Vector3D vector3DApplyInverseTo12 = applyInverseTo(vector3D6);
            if (vector3DApplyInverseTo12.getZ() < -0.9999999999d || vector3DApplyInverseTo12.getZ() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return new double[]{FastMath.atan2(vector3DApplyTo12.getY(), vector3DApplyTo12.getX()), FastMath.acos(vector3DApplyInverseTo12.getZ()), FastMath.atan2(vector3DApplyInverseTo12.getY(), -vector3DApplyInverseTo12.getX())};
        }
        if (rotationOrder == RotationOrder.XYZ) {
            Vector3D vector3DApplyTo13 = applyTo(Vector3D.PLUS_I);
            Vector3D vector3DApplyInverseTo13 = applyInverseTo(Vector3D.PLUS_K);
            if (vector3DApplyInverseTo13.getX() < -0.9999999999d || vector3DApplyInverseTo13.getX() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return new double[]{FastMath.atan2(-vector3DApplyInverseTo13.getY(), vector3DApplyInverseTo13.getZ()), FastMath.asin(vector3DApplyInverseTo13.getX()), FastMath.atan2(-vector3DApplyTo13.getY(), vector3DApplyTo13.getX())};
        }
        if (rotationOrder == RotationOrder.XZY) {
            Vector3D vector3DApplyTo14 = applyTo(Vector3D.PLUS_I);
            Vector3D vector3DApplyInverseTo14 = applyInverseTo(Vector3D.PLUS_J);
            if (vector3DApplyInverseTo14.getX() < -0.9999999999d || vector3DApplyInverseTo14.getX() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo14.getZ(), vector3DApplyInverseTo14.getY()), -FastMath.asin(vector3DApplyInverseTo14.getX()), FastMath.atan2(vector3DApplyTo14.getZ(), vector3DApplyTo14.getX())};
        }
        if (rotationOrder == RotationOrder.YXZ) {
            Vector3D vector3DApplyTo15 = applyTo(Vector3D.PLUS_J);
            Vector3D vector3DApplyInverseTo15 = applyInverseTo(Vector3D.PLUS_K);
            if (vector3DApplyInverseTo15.getY() < -0.9999999999d || vector3DApplyInverseTo15.getY() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo15.getX(), vector3DApplyInverseTo15.getZ()), -FastMath.asin(vector3DApplyInverseTo15.getY()), FastMath.atan2(vector3DApplyTo15.getX(), vector3DApplyTo15.getY())};
        }
        if (rotationOrder == RotationOrder.YZX) {
            Vector3D vector3DApplyTo16 = applyTo(Vector3D.PLUS_J);
            Vector3D vector3DApplyInverseTo16 = applyInverseTo(Vector3D.PLUS_I);
            if (vector3DApplyInverseTo16.getY() < -0.9999999999d || vector3DApplyInverseTo16.getY() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return new double[]{FastMath.atan2(-vector3DApplyInverseTo16.getZ(), vector3DApplyInverseTo16.getX()), FastMath.asin(vector3DApplyInverseTo16.getY()), FastMath.atan2(-vector3DApplyTo16.getZ(), vector3DApplyTo16.getY())};
        }
        if (rotationOrder == RotationOrder.ZXY) {
            Vector3D vector3DApplyTo17 = applyTo(Vector3D.PLUS_K);
            Vector3D vector3DApplyInverseTo17 = applyInverseTo(Vector3D.PLUS_J);
            if (vector3DApplyInverseTo17.getZ() < -0.9999999999d || vector3DApplyInverseTo17.getZ() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return new double[]{FastMath.atan2(-vector3DApplyInverseTo17.getX(), vector3DApplyInverseTo17.getY()), FastMath.asin(vector3DApplyInverseTo17.getZ()), FastMath.atan2(-vector3DApplyTo17.getX(), vector3DApplyTo17.getZ())};
        }
        if (rotationOrder == RotationOrder.ZYX) {
            Vector3D vector3DApplyTo18 = applyTo(Vector3D.PLUS_K);
            Vector3D vector3DApplyInverseTo18 = applyInverseTo(Vector3D.PLUS_I);
            if (vector3DApplyInverseTo18.getZ() < -0.9999999999d || vector3DApplyInverseTo18.getZ() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo18.getY(), vector3DApplyInverseTo18.getX()), -FastMath.asin(vector3DApplyInverseTo18.getZ()), FastMath.atan2(vector3DApplyTo18.getY(), vector3DApplyTo18.getZ())};
        }
        if (rotationOrder == RotationOrder.XYX) {
            Vector3D vector3D7 = Vector3D.PLUS_I;
            Vector3D vector3DApplyTo19 = applyTo(vector3D7);
            Vector3D vector3DApplyInverseTo19 = applyInverseTo(vector3D7);
            if (vector3DApplyInverseTo19.getX() < -0.9999999999d || vector3DApplyInverseTo19.getX() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo19.getY(), -vector3DApplyInverseTo19.getZ()), FastMath.acos(vector3DApplyInverseTo19.getX()), FastMath.atan2(vector3DApplyTo19.getY(), vector3DApplyTo19.getZ())};
        }
        if (rotationOrder == RotationOrder.XZX) {
            Vector3D vector3D8 = Vector3D.PLUS_I;
            Vector3D vector3DApplyTo20 = applyTo(vector3D8);
            Vector3D vector3DApplyInverseTo20 = applyInverseTo(vector3D8);
            if (vector3DApplyInverseTo20.getX() < -0.9999999999d || vector3DApplyInverseTo20.getX() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo20.getZ(), vector3DApplyInverseTo20.getY()), FastMath.acos(vector3DApplyInverseTo20.getX()), FastMath.atan2(vector3DApplyTo20.getZ(), -vector3DApplyTo20.getY())};
        }
        if (rotationOrder == RotationOrder.YXY) {
            Vector3D vector3D9 = Vector3D.PLUS_J;
            Vector3D vector3DApplyTo21 = applyTo(vector3D9);
            Vector3D vector3DApplyInverseTo21 = applyInverseTo(vector3D9);
            if (vector3DApplyInverseTo21.getY() < -0.9999999999d || vector3DApplyInverseTo21.getY() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo21.getX(), vector3DApplyInverseTo21.getZ()), FastMath.acos(vector3DApplyInverseTo21.getY()), FastMath.atan2(vector3DApplyTo21.getX(), -vector3DApplyTo21.getZ())};
        }
        if (rotationOrder == RotationOrder.YZY) {
            Vector3D vector3D10 = Vector3D.PLUS_J;
            Vector3D vector3DApplyTo22 = applyTo(vector3D10);
            Vector3D vector3DApplyInverseTo22 = applyInverseTo(vector3D10);
            if (vector3DApplyInverseTo22.getY() < -0.9999999999d || vector3DApplyInverseTo22.getY() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo22.getZ(), -vector3DApplyInverseTo22.getX()), FastMath.acos(vector3DApplyInverseTo22.getY()), FastMath.atan2(vector3DApplyTo22.getZ(), vector3DApplyTo22.getX())};
        }
        if (rotationOrder == RotationOrder.ZXZ) {
            Vector3D vector3D11 = Vector3D.PLUS_K;
            Vector3D vector3DApplyTo23 = applyTo(vector3D11);
            Vector3D vector3DApplyInverseTo23 = applyInverseTo(vector3D11);
            if (vector3DApplyInverseTo23.getZ() < -0.9999999999d || vector3DApplyInverseTo23.getZ() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return new double[]{FastMath.atan2(vector3DApplyInverseTo23.getX(), -vector3DApplyInverseTo23.getY()), FastMath.acos(vector3DApplyInverseTo23.getZ()), FastMath.atan2(vector3DApplyTo23.getX(), vector3DApplyTo23.getY())};
        }
        Vector3D vector3D12 = Vector3D.PLUS_K;
        Vector3D vector3DApplyTo24 = applyTo(vector3D12);
        Vector3D vector3DApplyInverseTo24 = applyInverseTo(vector3D12);
        if (vector3DApplyInverseTo24.getZ() < -0.9999999999d || vector3DApplyInverseTo24.getZ() > 0.9999999999d) {
            throw new CardanEulerSingularityException(false);
        }
        return new double[]{FastMath.atan2(vector3DApplyInverseTo24.getY(), vector3DApplyInverseTo24.getX()), FastMath.acos(vector3DApplyInverseTo24.getZ()), FastMath.atan2(vector3DApplyTo24.getY(), -vector3DApplyTo24.getX())};
    }

    public Vector3D getAxis(RotationConvention rotationConvention) {
        double d = this.f6788q1;
        double d6 = this.f6789q2;
        double d7 = (d6 * d6) + (d * d);
        double d8 = this.f6790q3;
        double d9 = (d8 * d8) + d7;
        if (d9 == 0.0d) {
            return rotationConvention == RotationConvention.VECTOR_OPERATOR ? Vector3D.PLUS_I : Vector3D.MINUS_I;
        }
        double d10 = rotationConvention == RotationConvention.VECTOR_OPERATOR ? 1.0d : -1.0d;
        if (this.f6787q0 < 0.0d) {
            double dSqrt = d10 / FastMath.sqrt(d9);
            return new Vector3D(this.f6788q1 * dSqrt, this.f6789q2 * dSqrt, this.f6790q3 * dSqrt);
        }
        double dSqrt2 = (-d10) / FastMath.sqrt(d9);
        return new Vector3D(this.f6788q1 * dSqrt2, this.f6789q2 * dSqrt2, this.f6790q3 * dSqrt2);
    }

    public void applyTo(double[] dArr, double[] dArr2) {
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = this.f6788q1;
        double d9 = this.f6789q2;
        double d10 = this.f6790q3;
        double d11 = (d10 * d7) + (d9 * d6) + (d8 * d);
        double d12 = this.f6787q0;
        dArr2[0] = (((d11 * d8) + (((d * d12) - ((d9 * d7) - (d10 * d6))) * d12)) * 2.0d) - d;
        dArr2[1] = (((d11 * d9) + (((d6 * d12) - ((d10 * d) - (d8 * d7))) * d12)) * 2.0d) - d6;
        dArr2[2] = (((d11 * d10) + (((d7 * d12) - ((d8 * d6) - (d9 * d))) * d12)) * 2.0d) - d7;
    }

    @Deprecated
    public Rotation(Vector3D vector3D, double d) {
        this(vector3D, d, RotationConvention.VECTOR_OPERATOR);
    }

    public void applyInverseTo(double[] dArr, double[] dArr2) {
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = this.f6788q1;
        double d9 = this.f6789q2;
        double d10 = this.f6790q3;
        double d11 = (d10 * d7) + (d9 * d6) + (d8 * d);
        double d12 = -this.f6787q0;
        dArr2[0] = (((d11 * d8) + (((d * d12) - ((d9 * d7) - (d10 * d6))) * d12)) * 2.0d) - d;
        dArr2[1] = (((d11 * d9) + (((d6 * d12) - ((d10 * d) - (d8 * d7))) * d12)) * 2.0d) - d6;
        dArr2[2] = (((d11 * d10) + (((d7 * d12) - ((d8 * d6) - (d9 * d))) * d12)) * 2.0d) - d7;
    }

    public Rotation(Vector3D vector3D, double d, RotationConvention rotationConvention) {
        double norm = vector3D.getNorm();
        if (norm != 0.0d) {
            double d6 = d * (rotationConvention == RotationConvention.VECTOR_OPERATOR ? -0.5d : 0.5d);
            double dSin = FastMath.sin(d6) / norm;
            this.f6787q0 = FastMath.cos(d6);
            this.f6788q1 = vector3D.getX() * dSin;
            this.f6789q2 = vector3D.getY() * dSin;
            this.f6790q3 = vector3D.getZ() * dSin;
            return;
        }
        throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
    }

    public Rotation applyTo(Rotation rotation) {
        return compose(rotation, RotationConvention.VECTOR_OPERATOR);
    }

    public Rotation applyInverseTo(Rotation rotation) {
        return composeInverse(rotation, RotationConvention.VECTOR_OPERATOR);
    }

    public Rotation(double[][] dArr, double d) {
        if (dArr.length == 3 && dArr[0].length == 3 && dArr[1].length == 3 && dArr[2].length == 3) {
            double[][] dArrOrthogonalizeMatrix = orthogonalizeMatrix(dArr, d);
            double[] dArr2 = dArrOrthogonalizeMatrix[0];
            double d6 = dArr2[0];
            double[] dArr3 = dArrOrthogonalizeMatrix[1];
            double d7 = dArr3[1];
            double[] dArr4 = dArrOrthogonalizeMatrix[2];
            double d8 = dArr4[2];
            double d9 = dArr4[1];
            double d10 = dArr3[2];
            double d11 = ((d7 * d8) - (d9 * d10)) * d6;
            double d12 = dArr3[0];
            double d13 = dArr2[1];
            double d14 = dArr2[2];
            double d15 = (((d13 * d10) - (d7 * d14)) * dArr4[0]) + (d11 - (((d8 * d13) - (d9 * d14)) * d12));
            if (d15 >= 0.0d) {
                double[] dArrMat2quat = mat2quat(dArrOrthogonalizeMatrix);
                this.f6787q0 = dArrMat2quat[0];
                this.f6788q1 = dArrMat2quat[1];
                this.f6789q2 = dArrMat2quat[2];
                this.f6790q3 = dArrMat2quat[3];
                return;
            }
            throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, Double.valueOf(d15));
        }
        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, Integer.valueOf(dArr.length), Integer.valueOf(dArr[0].length));
    }

    public Rotation(Vector3D vector3D, Vector3D vector3D2, Vector3D vector3D3, Vector3D vector3D4) {
        Vector3D vector3DNormalize = vector3D.crossProduct(vector3D2).normalize();
        Vector3D vector3DNormalize2 = vector3DNormalize.crossProduct(vector3D).normalize();
        Vector3D vector3DNormalize3 = vector3D.normalize();
        Vector3D vector3DNormalize4 = vector3D3.crossProduct(vector3D4).normalize();
        Vector3D vector3DNormalize5 = vector3DNormalize4.crossProduct(vector3D3).normalize();
        Vector3D vector3DNormalize6 = vector3D3.normalize();
        double[] dArrMat2quat = mat2quat(new double[][]{new double[]{MathArrays.linearCombination(vector3DNormalize3.getX(), vector3DNormalize6.getX(), vector3DNormalize2.getX(), vector3DNormalize5.getX(), vector3DNormalize.getX(), vector3DNormalize4.getX()), MathArrays.linearCombination(vector3DNormalize3.getY(), vector3DNormalize6.getX(), vector3DNormalize2.getY(), vector3DNormalize5.getX(), vector3DNormalize.getY(), vector3DNormalize4.getX()), MathArrays.linearCombination(vector3DNormalize3.getZ(), vector3DNormalize6.getX(), vector3DNormalize2.getZ(), vector3DNormalize5.getX(), vector3DNormalize.getZ(), vector3DNormalize4.getX())}, new double[]{MathArrays.linearCombination(vector3DNormalize3.getX(), vector3DNormalize6.getY(), vector3DNormalize2.getX(), vector3DNormalize5.getY(), vector3DNormalize.getX(), vector3DNormalize4.getY()), MathArrays.linearCombination(vector3DNormalize3.getY(), vector3DNormalize6.getY(), vector3DNormalize2.getY(), vector3DNormalize5.getY(), vector3DNormalize.getY(), vector3DNormalize4.getY()), MathArrays.linearCombination(vector3DNormalize3.getZ(), vector3DNormalize6.getY(), vector3DNormalize2.getZ(), vector3DNormalize5.getY(), vector3DNormalize.getZ(), vector3DNormalize4.getY())}, new double[]{MathArrays.linearCombination(vector3DNormalize3.getX(), vector3DNormalize6.getZ(), vector3DNormalize2.getX(), vector3DNormalize5.getZ(), vector3DNormalize.getX(), vector3DNormalize4.getZ()), MathArrays.linearCombination(vector3DNormalize3.getY(), vector3DNormalize6.getZ(), vector3DNormalize2.getY(), vector3DNormalize5.getZ(), vector3DNormalize.getY(), vector3DNormalize4.getZ()), MathArrays.linearCombination(vector3DNormalize3.getZ(), vector3DNormalize6.getZ(), vector3DNormalize2.getZ(), vector3DNormalize5.getZ(), vector3DNormalize.getZ(), vector3DNormalize4.getZ())}});
        this.f6787q0 = dArrMat2quat[0];
        this.f6788q1 = dArrMat2quat[1];
        this.f6789q2 = dArrMat2quat[2];
        this.f6790q3 = dArrMat2quat[3];
    }

    public Rotation(Vector3D vector3D, Vector3D vector3D2) {
        double norm = vector3D2.getNorm() * vector3D.getNorm();
        if (norm != 0.0d) {
            double dDotProduct = vector3D.dotProduct(vector3D2);
            if (dDotProduct < (-0.999999999999998d) * norm) {
                Vector3D vector3DOrthogonal = vector3D.orthogonal();
                this.f6787q0 = 0.0d;
                this.f6788q1 = -vector3DOrthogonal.getX();
                this.f6789q2 = -vector3DOrthogonal.getY();
                this.f6790q3 = -vector3DOrthogonal.getZ();
                return;
            }
            double dSqrt = FastMath.sqrt(((dDotProduct / norm) + 1.0d) * 0.5d);
            this.f6787q0 = dSqrt;
            double d = 1.0d / ((dSqrt * 2.0d) * norm);
            Vector3D vector3DCrossProduct = vector3D2.crossProduct(vector3D);
            this.f6788q1 = vector3DCrossProduct.getX() * d;
            this.f6789q2 = vector3DCrossProduct.getY() * d;
            this.f6790q3 = vector3DCrossProduct.getZ() * d;
            return;
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    @Deprecated
    public Rotation(RotationOrder rotationOrder, double d, double d6, double d7) {
        this(rotationOrder, RotationConvention.VECTOR_OPERATOR, d, d6, d7);
    }

    public Rotation(RotationOrder rotationOrder, RotationConvention rotationConvention, double d, double d6, double d7) {
        Rotation rotationCompose = new Rotation(rotationOrder.getA1(), d, rotationConvention).compose(new Rotation(rotationOrder.getA2(), d6, rotationConvention).compose(new Rotation(rotationOrder.getA3(), d7, rotationConvention), rotationConvention), rotationConvention);
        this.f6787q0 = rotationCompose.f6787q0;
        this.f6788q1 = rotationCompose.f6788q1;
        this.f6789q2 = rotationCompose.f6789q2;
        this.f6790q3 = rotationCompose.f6790q3;
    }
}
