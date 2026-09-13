package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Vector3D implements Serializable, Vector<Euclidean3D> {
    private static final long serialVersionUID = 1313493323784566947L;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double f6799x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double f6800y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final double f6801z;
    public static final Vector3D ZERO = new Vector3D(0.0d, 0.0d, 0.0d);
    public static final Vector3D PLUS_I = new Vector3D(1.0d, 0.0d, 0.0d);
    public static final Vector3D MINUS_I = new Vector3D(-1.0d, 0.0d, 0.0d);
    public static final Vector3D PLUS_J = new Vector3D(0.0d, 1.0d, 0.0d);
    public static final Vector3D MINUS_J = new Vector3D(0.0d, -1.0d, 0.0d);
    public static final Vector3D PLUS_K = new Vector3D(0.0d, 0.0d, 1.0d);
    public static final Vector3D MINUS_K = new Vector3D(0.0d, 0.0d, -1.0d);
    public static final Vector3D NaN = new Vector3D(Double.NaN, Double.NaN, Double.NaN);
    public static final Vector3D POSITIVE_INFINITY = new Vector3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final Vector3D NEGATIVE_INFINITY = new Vector3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

    public Vector3D(double d, double d6, double d7) {
        this.f6799x = d;
        this.f6800y = d6;
        this.f6801z = d7;
    }

    public static double angle(Vector3D vector3D, Vector3D vector3D2) {
        double norm = vector3D2.getNorm() * vector3D.getNorm();
        if (norm == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        double dDotProduct = vector3D.dotProduct(vector3D2);
        double d = 0.9999d * norm;
        if (dDotProduct >= (-d) && dDotProduct <= d) {
            return FastMath.acos(dDotProduct / norm);
        }
        Vector3D vector3DCrossProduct = crossProduct(vector3D, vector3D2);
        return dDotProduct >= 0.0d ? FastMath.asin(vector3DCrossProduct.getNorm() / norm) : 3.141592653589793d - FastMath.asin(vector3DCrossProduct.getNorm() / norm);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector add(double d, Vector vector) {
        return add(d, (Vector<Euclidean3D>) vector);
    }

    public Vector3D crossProduct(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        return new Vector3D(MathArrays.linearCombination(this.f6800y, vector3D.f6801z, -this.f6801z, vector3D.f6800y), MathArrays.linearCombination(this.f6801z, vector3D.f6799x, -this.f6799x, vector3D.f6801z), MathArrays.linearCombination(this.f6799x, vector3D.f6800y, -this.f6800y, vector3D.f6799x));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance(Vector<Euclidean3D> vector) {
        return distance((Point<Euclidean3D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance1(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        return FastMath.abs(vector3D.f6799x - this.f6799x) + FastMath.abs(vector3D.f6800y - this.f6800y) + FastMath.abs(vector3D.f6801z - this.f6801z);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceInf(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        double dAbs = FastMath.abs(vector3D.f6799x - this.f6799x);
        double dAbs2 = FastMath.abs(vector3D.f6800y - this.f6800y);
        return FastMath.max(FastMath.max(dAbs, dAbs2), FastMath.abs(vector3D.f6801z - this.f6801z));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceSq(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        double d = vector3D.f6799x - this.f6799x;
        double d6 = vector3D.f6800y - this.f6800y;
        double d7 = vector3D.f6801z - this.f6801z;
        return (d7 * d7) + (d6 * d6) + (d * d);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double dotProduct(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        return MathArrays.linearCombination(this.f6799x, vector3D.f6799x, this.f6800y, vector3D.f6800y, this.f6801z, vector3D.f6801z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) obj;
            if (vector3D.isNaN()) {
                return isNaN();
            }
            if (this.f6799x == vector3D.f6799x && this.f6800y == vector3D.f6800y && this.f6801z == vector3D.f6801z) {
                return true;
            }
        }
        return false;
    }

    public double getAlpha() {
        return FastMath.atan2(this.f6800y, this.f6799x);
    }

    public double getDelta() {
        return FastMath.asin(this.f6801z / getNorm());
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm() {
        double d = this.f6799x;
        double d6 = this.f6800y;
        double d7 = (d6 * d6) + (d * d);
        double d8 = this.f6801z;
        return FastMath.sqrt((d8 * d8) + d7);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm1() {
        return FastMath.abs(this.f6801z) + FastMath.abs(this.f6800y) + FastMath.abs(this.f6799x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormInf() {
        return FastMath.max(FastMath.max(FastMath.abs(this.f6799x), FastMath.abs(this.f6800y)), FastMath.abs(this.f6801z));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormSq() {
        double d = this.f6799x;
        double d6 = this.f6800y;
        double d7 = (d6 * d6) + (d * d);
        double d8 = this.f6801z;
        return (d8 * d8) + d7;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Euclidean3D.getInstance();
    }

    public double getX() {
        return this.f6799x;
    }

    public double getY() {
        return this.f6800y;
    }

    public double getZ() {
        return this.f6801z;
    }

    public int hashCode() {
        if (isNaN()) {
            return 642;
        }
        return (MathUtils.hash(this.f6801z) + (MathUtils.hash(this.f6800y) * 3) + (MathUtils.hash(this.f6799x) * 164)) * 643;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public boolean isInfinite() {
        if (isNaN()) {
            return false;
        }
        return Double.isInfinite(this.f6799x) || Double.isInfinite(this.f6800y) || Double.isInfinite(this.f6801z);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        return Double.isNaN(this.f6799x) || Double.isNaN(this.f6800y) || Double.isNaN(this.f6801z);
    }

    public Vector3D orthogonal() {
        double norm = getNorm() * 0.6d;
        if (norm == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        if (FastMath.abs(this.f6799x) <= norm) {
            double d = this.f6800y;
            double d6 = this.f6801z;
            double dSqrt = 1.0d / FastMath.sqrt((d6 * d6) + (d * d));
            return new Vector3D(0.0d, dSqrt * this.f6801z, (-dSqrt) * this.f6800y);
        }
        if (FastMath.abs(this.f6800y) <= norm) {
            double d7 = this.f6799x;
            double d8 = this.f6801z;
            double dSqrt2 = 1.0d / FastMath.sqrt((d8 * d8) + (d7 * d7));
            return new Vector3D((-dSqrt2) * this.f6801z, 0.0d, dSqrt2 * this.f6799x);
        }
        double d9 = this.f6799x;
        double d10 = this.f6800y;
        double dSqrt3 = 1.0d / FastMath.sqrt((d10 * d10) + (d9 * d9));
        return new Vector3D(dSqrt3 * this.f6800y, (-dSqrt3) * this.f6799x, 0.0d);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector subtract(double d, Vector vector) {
        return subtract(d, (Vector<Euclidean3D>) vector);
    }

    public double[] toArray() {
        return new double[]{this.f6799x, this.f6800y, this.f6801z};
    }

    public String toString() {
        return Vector3DFormat.getInstance().format(this);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector add(Vector vector) {
        return add((Vector<Euclidean3D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Euclidean3D> point) {
        Vector3D vector3D = (Vector3D) point;
        double d = vector3D.f6799x - this.f6799x;
        double d6 = vector3D.f6800y - this.f6800y;
        double d7 = vector3D.f6801z - this.f6801z;
        return FastMath.sqrt((d7 * d7) + (d6 * d6) + (d * d));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D getZero() {
        return ZERO;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D negate() {
        return new Vector3D(-this.f6799x, -this.f6800y, -this.f6801z);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D normalize() {
        double norm = getNorm();
        if (norm != 0.0d) {
            return scalarMultiply(1.0d / norm);
        }
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D scalarMultiply(double d) {
        return new Vector3D(this.f6799x * d, this.f6800y * d, this.f6801z * d);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector subtract(Vector vector) {
        return subtract((Vector<Euclidean3D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public String toString(NumberFormat numberFormat) {
        return new Vector3DFormat(numberFormat).format(this);
    }

    public static Vector3D crossProduct(Vector3D vector3D, Vector3D vector3D2) {
        return vector3D.crossProduct(vector3D2);
    }

    public static double dotProduct(Vector3D vector3D, Vector3D vector3D2) {
        return vector3D.dotProduct(vector3D2);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D add(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        return new Vector3D(this.f6799x + vector3D.f6799x, this.f6800y + vector3D.f6800y, this.f6801z + vector3D.f6801z);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D subtract(Vector<Euclidean3D> vector) {
        Vector3D vector3D = (Vector3D) vector;
        return new Vector3D(this.f6799x - vector3D.f6799x, this.f6800y - vector3D.f6800y, this.f6801z - vector3D.f6801z);
    }

    public Vector3D(double[] dArr) {
        if (dArr.length == 3) {
            this.f6799x = dArr[0];
            this.f6800y = dArr[1];
            this.f6801z = dArr[2];
            return;
        }
        throw new DimensionMismatchException(dArr.length, 3);
    }

    public static double distance1(Vector3D vector3D, Vector3D vector3D2) {
        return vector3D.distance1(vector3D2);
    }

    public static double distanceSq(Vector3D vector3D, Vector3D vector3D2) {
        return vector3D.distanceSq(vector3D2);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D add(double d, Vector<Euclidean3D> vector) {
        return new Vector3D(1.0d, this, d, (Vector3D) vector);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D subtract(double d, Vector<Euclidean3D> vector) {
        return new Vector3D(1.0d, this, -d, (Vector3D) vector);
    }

    public static double distanceInf(Vector3D vector3D, Vector3D vector3D2) {
        return vector3D.distanceInf(vector3D2);
    }

    public static double distance(Vector3D vector3D, Vector3D vector3D2) {
        return vector3D.distance((Vector<Euclidean3D>) vector3D2);
    }

    public Vector3D(double d, double d6) {
        double dCos = FastMath.cos(d6);
        this.f6799x = FastMath.cos(d) * dCos;
        this.f6800y = FastMath.sin(d) * dCos;
        this.f6801z = FastMath.sin(d6);
    }

    public Vector3D(double d, Vector3D vector3D) {
        this.f6799x = vector3D.f6799x * d;
        this.f6800y = vector3D.f6800y * d;
        this.f6801z = d * vector3D.f6801z;
    }

    public Vector3D(double d, Vector3D vector3D, double d6, Vector3D vector3D2) {
        this.f6799x = MathArrays.linearCombination(d, vector3D.f6799x, d6, vector3D2.f6799x);
        this.f6800y = MathArrays.linearCombination(d, vector3D.f6800y, d6, vector3D2.f6800y);
        this.f6801z = MathArrays.linearCombination(d, vector3D.f6801z, d6, vector3D2.f6801z);
    }

    public Vector3D(double d, Vector3D vector3D, double d6, Vector3D vector3D2, double d7, Vector3D vector3D3) {
        this.f6799x = MathArrays.linearCombination(d, vector3D.f6799x, d6, vector3D2.f6799x, d7, vector3D3.f6799x);
        this.f6800y = MathArrays.linearCombination(d, vector3D.f6800y, d6, vector3D2.f6800y, d7, vector3D3.f6800y);
        this.f6801z = MathArrays.linearCombination(d, vector3D.f6801z, d6, vector3D2.f6801z, d7, vector3D3.f6801z);
    }

    public Vector3D(double d, Vector3D vector3D, double d6, Vector3D vector3D2, double d7, Vector3D vector3D3, double d8, Vector3D vector3D4) {
        this.f6799x = MathArrays.linearCombination(d, vector3D.f6799x, d6, vector3D2.f6799x, d7, vector3D3.f6799x, d8, vector3D4.f6799x);
        this.f6800y = MathArrays.linearCombination(d, vector3D.f6800y, d6, vector3D2.f6800y, d7, vector3D3.f6800y, d8, vector3D4.f6800y);
        this.f6801z = MathArrays.linearCombination(d, vector3D.f6801z, d6, vector3D2.f6801z, d7, vector3D3.f6801z, d8, vector3D4.f6801z);
    }
}
