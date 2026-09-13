package org.apache.commons.math3.geometry.euclidean.twod;

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
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Vector2D implements Vector<Euclidean2D> {
    private static final long serialVersionUID = 266938651998679754L;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double f6802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double f6803y;
    public static final Vector2D ZERO = new Vector2D(0.0d, 0.0d);
    public static final Vector2D NaN = new Vector2D(Double.NaN, Double.NaN);
    public static final Vector2D POSITIVE_INFINITY = new Vector2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final Vector2D NEGATIVE_INFINITY = new Vector2D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

    public Vector2D(double d, double d6) {
        this.f6802x = d;
        this.f6803y = d6;
    }

    public static double angle(Vector2D vector2D, Vector2D vector2D2) {
        double norm = vector2D2.getNorm() * vector2D.getNorm();
        if (norm == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        double dDotProduct = vector2D.dotProduct(vector2D2);
        double d = 0.9999d * norm;
        if (dDotProduct >= (-d) && dDotProduct <= d) {
            return FastMath.acos(dDotProduct / norm);
        }
        double dAbs = FastMath.abs(MathArrays.linearCombination(vector2D.f6802x, vector2D2.f6803y, -vector2D.f6803y, vector2D2.f6802x));
        return dDotProduct >= 0.0d ? FastMath.asin(dAbs / norm) : 3.141592653589793d - FastMath.asin(dAbs / norm);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector add(double d, Vector vector) {
        return add(d, (Vector<Euclidean2D>) vector);
    }

    public double crossProduct(Vector2D vector2D, Vector2D vector2D2) {
        return MathArrays.linearCombination(vector2D2.getX() - vector2D.getX(), getY() - vector2D.getY(), -(getX() - vector2D.getX()), vector2D2.getY() - vector2D.getY());
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance(Vector<Euclidean2D> vector) {
        return distance((Point<Euclidean2D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance1(Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return FastMath.abs(vector2D.f6803y - this.f6803y) + FastMath.abs(vector2D.f6802x - this.f6802x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceInf(Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return FastMath.max(FastMath.abs(vector2D.f6802x - this.f6802x), FastMath.abs(vector2D.f6803y - this.f6803y));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceSq(Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        double d = vector2D.f6802x - this.f6802x;
        double d6 = vector2D.f6803y - this.f6803y;
        return (d6 * d6) + (d * d);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double dotProduct(Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return MathArrays.linearCombination(this.f6802x, vector2D.f6802x, this.f6803y, vector2D.f6803y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vector2D) {
            Vector2D vector2D = (Vector2D) obj;
            if (vector2D.isNaN()) {
                return isNaN();
            }
            if (this.f6802x == vector2D.f6802x && this.f6803y == vector2D.f6803y) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm() {
        double d = this.f6802x;
        double d6 = this.f6803y;
        return FastMath.sqrt((d6 * d6) + (d * d));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm1() {
        return FastMath.abs(this.f6803y) + FastMath.abs(this.f6802x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormInf() {
        return FastMath.max(FastMath.abs(this.f6802x), FastMath.abs(this.f6803y));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormSq() {
        double d = this.f6802x;
        double d6 = this.f6803y;
        return (d6 * d6) + (d * d);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Euclidean2D.getInstance();
    }

    public double getX() {
        return this.f6802x;
    }

    public double getY() {
        return this.f6803y;
    }

    public int hashCode() {
        if (isNaN()) {
            return Videoio.CAP_PROP_XI_LUT_INDEX;
        }
        return (MathUtils.hash(this.f6803y) + (MathUtils.hash(this.f6802x) * 76)) * 122;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public boolean isInfinite() {
        if (isNaN()) {
            return false;
        }
        return Double.isInfinite(this.f6802x) || Double.isInfinite(this.f6803y);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        return Double.isNaN(this.f6802x) || Double.isNaN(this.f6803y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector subtract(double d, Vector vector) {
        return subtract(d, (Vector<Euclidean2D>) vector);
    }

    public double[] toArray() {
        return new double[]{this.f6802x, this.f6803y};
    }

    public String toString() {
        return Vector2DFormat.getInstance().format(this);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector add(Vector vector) {
        return add((Vector<Euclidean2D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Euclidean2D> point) {
        Vector2D vector2D = (Vector2D) point;
        double d = vector2D.f6802x - this.f6802x;
        double d6 = vector2D.f6803y - this.f6803y;
        return FastMath.sqrt((d6 * d6) + (d * d));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D getZero() {
        return ZERO;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D negate() {
        return new Vector2D(-this.f6802x, -this.f6803y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D normalize() {
        double norm = getNorm();
        if (norm != 0.0d) {
            return scalarMultiply(1.0d / norm);
        }
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D scalarMultiply(double d) {
        return new Vector2D(this.f6802x * d, d * this.f6803y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector subtract(Vector vector) {
        return subtract((Vector<Euclidean2D>) vector);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public String toString(NumberFormat numberFormat) {
        return new Vector2DFormat(numberFormat).format(this);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D add(Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return new Vector2D(vector2D.getX() + this.f6802x, vector2D.getY() + this.f6803y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D subtract(Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return new Vector2D(this.f6802x - vector2D.f6802x, this.f6803y - vector2D.f6803y);
    }

    public Vector2D(double[] dArr) {
        if (dArr.length == 2) {
            this.f6802x = dArr[0];
            this.f6803y = dArr[1];
            return;
        }
        throw new DimensionMismatchException(dArr.length, 2);
    }

    public static double distanceSq(Vector2D vector2D, Vector2D vector2D2) {
        return vector2D.distanceSq(vector2D2);
    }

    public static double distanceInf(Vector2D vector2D, Vector2D vector2D2) {
        return vector2D.distanceInf(vector2D2);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D add(double d, Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return new Vector2D((vector2D.getX() * d) + this.f6802x, (vector2D.getY() * d) + this.f6803y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D subtract(double d, Vector<Euclidean2D> vector) {
        Vector2D vector2D = (Vector2D) vector;
        return new Vector2D(this.f6802x - (vector2D.getX() * d), this.f6803y - (vector2D.getY() * d));
    }

    public static double distance(Vector2D vector2D, Vector2D vector2D2) {
        return vector2D.distance((Vector<Euclidean2D>) vector2D2);
    }

    public Vector2D(double d, Vector2D vector2D) {
        this.f6802x = vector2D.f6802x * d;
        this.f6803y = d * vector2D.f6803y;
    }

    public Vector2D(double d, Vector2D vector2D, double d6, Vector2D vector2D2) {
        this.f6802x = (vector2D2.f6802x * d6) + (vector2D.f6802x * d);
        this.f6803y = (d6 * vector2D2.f6803y) + (d * vector2D.f6803y);
    }

    public Vector2D(double d, Vector2D vector2D, double d6, Vector2D vector2D2, double d7, Vector2D vector2D3) {
        this.f6802x = (vector2D3.f6802x * d7) + (vector2D2.f6802x * d6) + (vector2D.f6802x * d);
        this.f6803y = (d7 * vector2D3.f6803y) + (d6 * vector2D2.f6803y) + (d * vector2D.f6803y);
    }

    public Vector2D(double d, Vector2D vector2D, double d6, Vector2D vector2D2, double d7, Vector2D vector2D3, double d8, Vector2D vector2D4) {
        this.f6802x = (vector2D4.f6802x * d8) + (vector2D3.f6802x * d7) + (vector2D2.f6802x * d6) + (vector2D.f6802x * d);
        this.f6803y = (vector2D4.f6803y * d8) + (vector2D3.f6803y * d7) + (d6 * vector2D2.f6803y) + (d * vector2D.f6803y);
    }
}
