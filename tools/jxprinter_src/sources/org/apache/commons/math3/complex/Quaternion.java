package org.apache.commons.math3.complex;

import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Quaternion implements Serializable {
    private static final long serialVersionUID = 20092012;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final double f6758q0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private final double f6759q1;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    private final double f6760q2;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    private final double f6761q3;
    public static final Quaternion IDENTITY = new Quaternion(1.0d, 0.0d, 0.0d, 0.0d);
    public static final Quaternion ZERO = new Quaternion(0.0d, 0.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final Quaternion f6755I = new Quaternion(0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Quaternion f6756J = new Quaternion(0.0d, 0.0d, 1.0d, 0.0d);

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final Quaternion f6757K = new Quaternion(0.0d, 0.0d, 0.0d, 1.0d);

    public Quaternion(double d, double d6, double d7, double d8) {
        this.f6758q0 = d;
        this.f6759q1 = d6;
        this.f6760q2 = d7;
        this.f6761q3 = d8;
    }

    public static Quaternion add(Quaternion quaternion, Quaternion quaternion2) {
        return new Quaternion(quaternion.getQ0() + quaternion2.getQ0(), quaternion.getQ1() + quaternion2.getQ1(), quaternion.getQ2() + quaternion2.getQ2(), quaternion.getQ3() + quaternion2.getQ3());
    }

    public static double dotProduct(Quaternion quaternion, Quaternion quaternion2) {
        return (quaternion2.getQ3() * quaternion.getQ3()) + (quaternion2.getQ2() * quaternion.getQ2()) + (quaternion2.getQ1() * quaternion.getQ1()) + (quaternion2.getQ0() * quaternion.getQ0());
    }

    public static Quaternion multiply(Quaternion quaternion, Quaternion quaternion2) {
        double q6 = quaternion.getQ0();
        double q7 = quaternion.getQ1();
        double q8 = quaternion.getQ2();
        double q9 = quaternion.getQ3();
        double q10 = quaternion2.getQ0();
        double q11 = quaternion2.getQ1();
        double q12 = quaternion2.getQ2();
        double q13 = quaternion2.getQ3();
        return new Quaternion((((q6 * q10) - (q7 * q11)) - (q8 * q12)) - (q9 * q13), ((q8 * q13) + ((q7 * q10) + (q6 * q11))) - (q9 * q12), (q9 * q11) + (q8 * q10) + ((q6 * q12) - (q7 * q13)), (q9 * q10) + (((q7 * q12) + (q6 * q13)) - (q8 * q11)));
    }

    public static Quaternion subtract(Quaternion quaternion, Quaternion quaternion2) {
        return new Quaternion(quaternion.getQ0() - quaternion2.getQ0(), quaternion.getQ1() - quaternion2.getQ1(), quaternion.getQ2() - quaternion2.getQ2(), quaternion.getQ3() - quaternion2.getQ3());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Quaternion) {
            Quaternion quaternion = (Quaternion) obj;
            if (this.f6758q0 == quaternion.getQ0() && this.f6759q1 == quaternion.getQ1() && this.f6760q2 == quaternion.getQ2() && this.f6761q3 == quaternion.getQ3()) {
                return true;
            }
        }
        return false;
    }

    public Quaternion getConjugate() {
        return new Quaternion(this.f6758q0, -this.f6759q1, -this.f6760q2, -this.f6761q3);
    }

    public Quaternion getInverse() {
        double d = this.f6758q0;
        double d6 = this.f6759q1;
        double d7 = this.f6760q2;
        double d8 = (d7 * d7) + (d6 * d6) + (d * d);
        double d9 = this.f6761q3;
        double d10 = (d9 * d9) + d8;
        if (d10 >= Precision.SAFE_MIN) {
            return new Quaternion(d / d10, (-d6) / d10, (-d7) / d10, (-d9) / d10);
        }
        throw new ZeroException(LocalizedFormats.NORM, Double.valueOf(d10));
    }

    public double getNorm() {
        double d = this.f6758q0;
        double d6 = this.f6759q1;
        double d7 = (d6 * d6) + (d * d);
        double d8 = this.f6760q2;
        double d9 = (d8 * d8) + d7;
        double d10 = this.f6761q3;
        return FastMath.sqrt((d10 * d10) + d9);
    }

    public Quaternion getPositivePolarForm() {
        if (getQ0() >= 0.0d) {
            return normalize();
        }
        Quaternion quaternionNormalize = normalize();
        return new Quaternion(-quaternionNormalize.getQ0(), -quaternionNormalize.getQ1(), -quaternionNormalize.getQ2(), -quaternionNormalize.getQ3());
    }

    public double getQ0() {
        return this.f6758q0;
    }

    public double getQ1() {
        return this.f6759q1;
    }

    public double getQ2() {
        return this.f6760q2;
    }

    public double getQ3() {
        return this.f6761q3;
    }

    public double getScalarPart() {
        return getQ0();
    }

    public double[] getVectorPart() {
        return new double[]{getQ1(), getQ2(), getQ3()};
    }

    public int hashCode() {
        double[] dArr = {this.f6758q0, this.f6759q1, this.f6760q2, this.f6761q3};
        int iHash = 17;
        for (int i5 = 0; i5 < 4; i5++) {
            iHash = (iHash * 31) + MathUtils.hash(dArr[i5]);
        }
        return iHash;
    }

    public boolean isPureQuaternion(double d) {
        return FastMath.abs(getQ0()) <= d;
    }

    public boolean isUnitQuaternion(double d) {
        return Precision.equals(getNorm(), 1.0d, d);
    }

    public Quaternion normalize() {
        double norm = getNorm();
        if (norm >= Precision.SAFE_MIN) {
            return new Quaternion(this.f6758q0 / norm, this.f6759q1 / norm, this.f6760q2 / norm, this.f6761q3 / norm);
        }
        throw new ZeroException(LocalizedFormats.NORM, Double.valueOf(norm));
    }

    public String toString() {
        return "[" + this.f6758q0 + " " + this.f6759q1 + " " + this.f6760q2 + " " + this.f6761q3 + "]";
    }

    public Quaternion add(Quaternion quaternion) {
        return add(this, quaternion);
    }

    public double dotProduct(Quaternion quaternion) {
        return dotProduct(this, quaternion);
    }

    public Quaternion subtract(Quaternion quaternion) {
        return subtract(this, quaternion);
    }

    public boolean equals(Quaternion quaternion, double d) {
        return Precision.equals(this.f6758q0, quaternion.getQ0(), d) && Precision.equals(this.f6759q1, quaternion.getQ1(), d) && Precision.equals(this.f6760q2, quaternion.getQ2(), d) && Precision.equals(this.f6761q3, quaternion.getQ3(), d);
    }

    public Quaternion(double d, double[] dArr) {
        if (dArr.length == 3) {
            this.f6758q0 = d;
            this.f6759q1 = dArr[0];
            this.f6760q2 = dArr[1];
            this.f6761q3 = dArr[2];
            return;
        }
        throw new DimensionMismatchException(dArr.length, 3);
    }

    public Quaternion multiply(Quaternion quaternion) {
        return multiply(this, quaternion);
    }

    public Quaternion multiply(double d) {
        return new Quaternion(this.f6758q0 * d, this.f6759q1 * d, this.f6760q2 * d, this.f6761q3 * d);
    }

    public Quaternion(double[] dArr) {
        this(0.0d, dArr);
    }
}
