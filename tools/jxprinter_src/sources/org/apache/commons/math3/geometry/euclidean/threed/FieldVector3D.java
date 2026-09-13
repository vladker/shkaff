package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldVector3D<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final T f6778x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final T f6779y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final T f6780z;

    public FieldVector3D(T t6, T t7, T t8) {
        this.f6778x = t6;
        this.f6779y = t7;
        this.f6780z = t8;
    }

    public static <T extends RealFieldElement<T>> T angle(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        RealFieldElement realFieldElement = (RealFieldElement) fieldVector3D.getNorm().multiply(fieldVector3D2.getNorm());
        if (realFieldElement.getReal() == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        RealFieldElement realFieldElementDotProduct = dotProduct(fieldVector3D, fieldVector3D2);
        double real = realFieldElement.getReal() * 0.9999d;
        if (realFieldElementDotProduct.getReal() >= (-real) && realFieldElementDotProduct.getReal() <= real) {
            return (T) ((RealFieldElement) realFieldElementDotProduct.divide(realFieldElement)).acos();
        }
        FieldVector3D fieldVector3DCrossProduct = crossProduct(fieldVector3D, fieldVector3D2);
        return realFieldElementDotProduct.getReal() >= 0.0d ? (T) ((RealFieldElement) fieldVector3DCrossProduct.getNorm().divide(realFieldElement)).asin() : (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DCrossProduct.getNorm().divide(realFieldElement)).asin()).subtract(3.141592653589793d)).negate();
    }

    public FieldVector3D<T> add(FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.add(fieldVector3D.f6778x), (RealFieldElement) this.f6779y.add(fieldVector3D.f6779y), (RealFieldElement) this.f6780z.add(fieldVector3D.f6780z));
    }

    public FieldVector3D<T> crossProduct(FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.linearCombination(this.f6779y, fieldVector3D.f6780z, this.f6780z.negate(), fieldVector3D.f6779y), (RealFieldElement) this.f6779y.linearCombination(this.f6780z, fieldVector3D.f6778x, this.f6778x.negate(), fieldVector3D.f6780z), (RealFieldElement) this.f6780z.linearCombination(this.f6778x, fieldVector3D.f6779y, this.f6779y.negate(), fieldVector3D.f6778x));
    }

    public T distance(FieldVector3D<T> fieldVector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) fieldVector3D.f6778x.subtract(this.f6778x);
        RealFieldElement realFieldElement2 = (RealFieldElement) fieldVector3D.f6779y.subtract(this.f6779y);
        RealFieldElement realFieldElement3 = (RealFieldElement) fieldVector3D.f6780z.subtract(this.f6780z);
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(realFieldElement)).add(realFieldElement2.multiply(realFieldElement2))).add(realFieldElement3.multiply(realFieldElement3))).sqrt();
    }

    public T distance1(FieldVector3D<T> fieldVector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) fieldVector3D.f6778x.subtract(this.f6778x)).abs();
        RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) fieldVector3D.f6779y.subtract(this.f6779y)).abs();
        return (T) ((RealFieldElement) realFieldElement.add(realFieldElement2)).add((RealFieldElement) ((RealFieldElement) fieldVector3D.f6780z.subtract(this.f6780z)).abs());
    }

    public T distanceInf(FieldVector3D<T> fieldVector3D) {
        T t6 = (T) ((RealFieldElement) fieldVector3D.f6778x.subtract(this.f6778x)).abs();
        T t7 = (T) ((RealFieldElement) fieldVector3D.f6779y.subtract(this.f6779y)).abs();
        T t8 = (T) ((RealFieldElement) fieldVector3D.f6780z.subtract(this.f6780z)).abs();
        if (t6.getReal() <= t7.getReal()) {
            return t7.getReal() <= t8.getReal() ? t8 : t7;
        }
        return t6.getReal() <= t8.getReal() ? t8 : t6;
    }

    public T distanceSq(FieldVector3D<T> fieldVector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) fieldVector3D.f6778x.subtract(this.f6778x);
        RealFieldElement realFieldElement2 = (RealFieldElement) fieldVector3D.f6779y.subtract(this.f6779y);
        RealFieldElement realFieldElement3 = (RealFieldElement) fieldVector3D.f6780z.subtract(this.f6780z);
        return (T) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(realFieldElement)).add(realFieldElement2.multiply(realFieldElement2))).add(realFieldElement3.multiply(realFieldElement3));
    }

    public T dotProduct(FieldVector3D<T> fieldVector3D) {
        T t6 = this.f6778x;
        return (T) t6.linearCombination(t6, fieldVector3D.f6778x, this.f6779y, fieldVector3D.f6779y, this.f6780z, fieldVector3D.f6780z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldVector3D) {
            FieldVector3D fieldVector3D = (FieldVector3D) obj;
            if (fieldVector3D.isNaN()) {
                return isNaN();
            }
            if (this.f6778x.equals(fieldVector3D.f6778x) && this.f6779y.equals(fieldVector3D.f6779y) && this.f6780z.equals(fieldVector3D.f6780z)) {
                return true;
            }
        }
        return false;
    }

    public T getAlpha() {
        return (T) this.f6779y.atan2(this.f6778x);
    }

    public T getDelta() {
        return (T) ((RealFieldElement) this.f6780z.divide(getNorm())).asin();
    }

    public T getNorm() {
        T t6 = this.f6778x;
        RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(t6);
        T t7 = this.f6779y;
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.add(t7.multiply(t7));
        T t8 = this.f6780z;
        return (T) ((RealFieldElement) realFieldElement2.add(t8.multiply(t8))).sqrt();
    }

    public T getNorm1() {
        return (T) ((RealFieldElement) ((RealFieldElement) this.f6778x.abs()).add(this.f6779y.abs())).add(this.f6780z.abs());
    }

    public T getNormInf() {
        T t6 = (T) this.f6778x.abs();
        T t7 = (T) this.f6779y.abs();
        T t8 = (T) this.f6780z.abs();
        if (t6.getReal() <= t7.getReal()) {
            return t7.getReal() <= t8.getReal() ? t8 : t7;
        }
        return t6.getReal() <= t8.getReal() ? t8 : t6;
    }

    public T getNormSq() {
        T t6 = this.f6778x;
        RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(t6);
        T t7 = this.f6779y;
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.add(t7.multiply(t7));
        T t8 = this.f6780z;
        return (T) realFieldElement2.add(t8.multiply(t8));
    }

    public T getX() {
        return this.f6778x;
    }

    public T getY() {
        return this.f6779y;
    }

    public T getZ() {
        return this.f6780z;
    }

    public int hashCode() {
        if (isNaN()) {
            return Videoio.CAP_PROP_XI_GPO_SELECTOR;
        }
        return (this.f6780z.hashCode() + (this.f6779y.hashCode() * 83) + (this.f6778x.hashCode() * 107)) * 311;
    }

    public boolean isInfinite() {
        if (isNaN()) {
            return false;
        }
        return Double.isInfinite(this.f6778x.getReal()) || Double.isInfinite(this.f6779y.getReal()) || Double.isInfinite(this.f6780z.getReal());
    }

    public boolean isNaN() {
        return Double.isNaN(this.f6778x.getReal()) || Double.isNaN(this.f6779y.getReal()) || Double.isNaN(this.f6780z.getReal());
    }

    public FieldVector3D<T> negate() {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.negate(), (RealFieldElement) this.f6779y.negate(), (RealFieldElement) this.f6780z.negate());
    }

    public FieldVector3D<T> normalize() {
        RealFieldElement norm = getNorm();
        if (norm.getReal() != 0.0d) {
            return scalarMultiply((RealFieldElement) norm.reciprocal());
        }
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    public FieldVector3D<T> orthogonal() {
        double real = getNorm().getReal() * 0.6d;
        if (real == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        if (FastMath.abs(this.f6778x.getReal()) <= real) {
            T t6 = this.f6779y;
            RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(t6);
            T t7 = this.f6780z;
            RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.add(t7.multiply(t7))).sqrt()).reciprocal();
            return new FieldVector3D<>((RealFieldElement) realFieldElement2.getField().getZero(), (RealFieldElement) realFieldElement2.multiply(this.f6780z), (RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(this.f6779y)).negate());
        }
        if (FastMath.abs(this.f6779y.getReal()) <= real) {
            T t8 = this.f6778x;
            RealFieldElement realFieldElement3 = (RealFieldElement) t8.multiply(t8);
            T t9 = this.f6780z;
            RealFieldElement realFieldElement4 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement3.add(t9.multiply(t9))).sqrt()).reciprocal();
            return new FieldVector3D<>((RealFieldElement) ((RealFieldElement) realFieldElement4.multiply(this.f6780z)).negate(), (RealFieldElement) realFieldElement4.getField().getZero(), (RealFieldElement) realFieldElement4.multiply(this.f6778x));
        }
        T t10 = this.f6778x;
        RealFieldElement realFieldElement5 = (RealFieldElement) t10.multiply(t10);
        T t11 = this.f6779y;
        RealFieldElement realFieldElement6 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement5.add(t11.multiply(t11))).sqrt()).reciprocal();
        return new FieldVector3D<>((RealFieldElement) realFieldElement6.multiply(this.f6779y), (RealFieldElement) ((RealFieldElement) realFieldElement6.multiply(this.f6778x)).negate(), (RealFieldElement) realFieldElement6.getField().getZero());
    }

    public FieldVector3D<T> scalarMultiply(T t6) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.multiply(t6), (RealFieldElement) this.f6779y.multiply(t6), (RealFieldElement) this.f6780z.multiply(t6));
    }

    public FieldVector3D<T> subtract(FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.subtract(fieldVector3D.f6778x), (RealFieldElement) this.f6779y.subtract(fieldVector3D.f6779y), (RealFieldElement) this.f6780z.subtract(fieldVector3D.f6780z));
    }

    public T[] toArray() {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(this.f6778x.getField(), 3));
        tArr[0] = this.f6778x;
        tArr[1] = this.f6779y;
        tArr[2] = this.f6780z;
        return tArr;
    }

    public String toString() {
        return Vector3DFormat.getInstance().format(toVector3D());
    }

    public Vector3D toVector3D() {
        return new Vector3D(this.f6778x.getReal(), this.f6779y.getReal(), this.f6780z.getReal());
    }

    public FieldVector3D<T> add(Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.add(vector3D.getX()), (RealFieldElement) this.f6779y.add(vector3D.getY()), (RealFieldElement) this.f6780z.add(vector3D.getZ()));
    }

    public FieldVector3D<T> crossProduct(Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.linearCombination(vector3D.getZ(), this.f6779y, -vector3D.getY(), this.f6780z), (RealFieldElement) this.f6779y.linearCombination(vector3D.getX(), this.f6780z, -vector3D.getZ(), this.f6778x), (RealFieldElement) this.f6780z.linearCombination(vector3D.getY(), this.f6778x, -vector3D.getX(), this.f6779y));
    }

    public T dotProduct(Vector3D vector3D) {
        return (T) this.f6778x.linearCombination(vector3D.getX(), this.f6778x, vector3D.getY(), this.f6779y, vector3D.getZ(), this.f6780z);
    }

    public FieldVector3D<T> scalarMultiply(double d) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.multiply(d), (RealFieldElement) this.f6779y.multiply(d), (RealFieldElement) this.f6780z.multiply(d));
    }

    public FieldVector3D<T> subtract(Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.subtract(vector3D.getX()), (RealFieldElement) this.f6779y.subtract(vector3D.getY()), (RealFieldElement) this.f6780z.subtract(vector3D.getZ()));
    }

    public String toString(NumberFormat numberFormat) {
        return new Vector3DFormat(numberFormat).format(toVector3D());
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        return fieldVector3D.crossProduct(fieldVector3D2);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        return (T) fieldVector3D.dotProduct(fieldVector3D2);
    }

    public FieldVector3D<T> add(T t6, FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.getField().getOne(), this, t6, fieldVector3D);
    }

    public FieldVector3D<T> subtract(T t6, FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.getField().getOne(), this, (RealFieldElement) t6.negate(), fieldVector3D);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        return fieldVector3D.crossProduct(vector3D);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        return (T) fieldVector3D.dotProduct(vector3D);
    }

    public FieldVector3D<T> add(T t6, Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.add(t6.multiply(vector3D.getX())), (RealFieldElement) this.f6779y.add(t6.multiply(vector3D.getY())), (RealFieldElement) this.f6780z.add(t6.multiply(vector3D.getZ())));
    }

    public FieldVector3D<T> subtract(T t6, Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.subtract(t6.multiply(vector3D.getX())), (RealFieldElement) this.f6779y.subtract(t6.multiply(vector3D.getY())), (RealFieldElement) this.f6780z.subtract(t6.multiply(vector3D.getZ())));
    }

    public FieldVector3D(T[] tArr) {
        if (tArr.length == 3) {
            this.f6778x = tArr[0];
            this.f6779y = tArr[1];
            this.f6780z = tArr[2];
            return;
        }
        throw new DimensionMismatchException(tArr.length, 3);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>((RealFieldElement) ((FieldVector3D) fieldVector3D).f6778x.linearCombination(vector3D.getY(), ((FieldVector3D) fieldVector3D).f6780z, -vector3D.getZ(), ((FieldVector3D) fieldVector3D).f6779y), (RealFieldElement) ((FieldVector3D) fieldVector3D).f6779y.linearCombination(vector3D.getZ(), ((FieldVector3D) fieldVector3D).f6778x, -vector3D.getX(), ((FieldVector3D) fieldVector3D).f6780z), (RealFieldElement) ((FieldVector3D) fieldVector3D).f6780z.linearCombination(vector3D.getX(), ((FieldVector3D) fieldVector3D).f6779y, -vector3D.getY(), ((FieldVector3D) fieldVector3D).f6778x));
    }

    public static <T extends RealFieldElement<T>> T dotProduct(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return (T) fieldVector3D.dotProduct(vector3D);
    }

    public FieldVector3D<T> add(double d, FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>(1.0d, this, d, fieldVector3D);
    }

    public T distance(Vector3D vector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) this.f6778x.subtract(vector3D.getX());
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6779y.subtract(vector3D.getY());
        RealFieldElement realFieldElement3 = (RealFieldElement) this.f6780z.subtract(vector3D.getZ());
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(realFieldElement)).add(realFieldElement2.multiply(realFieldElement2))).add(realFieldElement3.multiply(realFieldElement3))).sqrt();
    }

    public T distance1(Vector3D vector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) this.f6778x.subtract(vector3D.getX())).abs();
        RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) this.f6779y.subtract(vector3D.getY())).abs();
        return (T) ((RealFieldElement) realFieldElement.add(realFieldElement2)).add((RealFieldElement) ((RealFieldElement) this.f6780z.subtract(vector3D.getZ())).abs());
    }

    public T distanceSq(Vector3D vector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) this.f6778x.subtract(vector3D.getX());
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6779y.subtract(vector3D.getY());
        RealFieldElement realFieldElement3 = (RealFieldElement) this.f6780z.subtract(vector3D.getZ());
        return (T) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(realFieldElement)).add(realFieldElement2.multiply(realFieldElement2))).add(realFieldElement3.multiply(realFieldElement3));
    }

    public FieldVector3D<T> subtract(double d, FieldVector3D<T> fieldVector3D) {
        return new FieldVector3D<>(1.0d, this, -d, fieldVector3D);
    }

    public FieldVector3D<T> add(double d, Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.add(vector3D.getX() * d), (RealFieldElement) this.f6779y.add(vector3D.getY() * d), (RealFieldElement) this.f6780z.add(vector3D.getZ() * d));
    }

    public FieldVector3D<T> subtract(double d, Vector3D vector3D) {
        return new FieldVector3D<>((RealFieldElement) this.f6778x.subtract(vector3D.getX() * d), (RealFieldElement) this.f6779y.subtract(vector3D.getY() * d), (RealFieldElement) this.f6780z.subtract(vector3D.getZ() * d));
    }

    public T distanceInf(Vector3D vector3D) {
        T t6 = (T) ((RealFieldElement) this.f6778x.subtract(vector3D.getX())).abs();
        T t7 = (T) ((RealFieldElement) this.f6779y.subtract(vector3D.getY())).abs();
        T t8 = (T) ((RealFieldElement) this.f6780z.subtract(vector3D.getZ())).abs();
        if (t6.getReal() <= t7.getReal()) {
            return t7.getReal() <= t8.getReal() ? t8 : t7;
        }
        return t6.getReal() <= t8.getReal() ? t8 : t6;
    }

    public static <T extends RealFieldElement<T>> T distance(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        return (T) fieldVector3D.distance(fieldVector3D2);
    }

    public static <T extends RealFieldElement<T>> T distance1(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        return (T) fieldVector3D.distance1(fieldVector3D2);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        return (T) fieldVector3D.distanceSq(fieldVector3D2);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        return (T) fieldVector3D.distance(vector3D);
    }

    public static <T extends RealFieldElement<T>> T distance1(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        return (T) fieldVector3D.distance1(vector3D);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        return (T) fieldVector3D.distanceSq(vector3D);
    }

    public FieldVector3D(T t6, T t7) {
        RealFieldElement realFieldElement = (RealFieldElement) t7.cos();
        this.f6778x = (T) ((RealFieldElement) t6.cos()).multiply(realFieldElement);
        this.f6779y = (T) ((RealFieldElement) t6.sin()).multiply(realFieldElement);
        this.f6780z = (T) t7.sin();
    }

    public static <T extends RealFieldElement<T>> T distance(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return (T) fieldVector3D.distance(vector3D);
    }

    public static <T extends RealFieldElement<T>> T distance1(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return (T) fieldVector3D.distance1(vector3D);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return (T) fieldVector3D.distanceSq(vector3D);
    }

    public static <T extends RealFieldElement<T>> T angle(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        RealFieldElement realFieldElement = (RealFieldElement) fieldVector3D.getNorm().multiply(vector3D.getNorm());
        if (realFieldElement.getReal() != 0.0d) {
            RealFieldElement realFieldElementDotProduct = dotProduct(fieldVector3D, vector3D);
            double real = realFieldElement.getReal() * 0.9999d;
            if (realFieldElementDotProduct.getReal() >= (-real) && realFieldElementDotProduct.getReal() <= real) {
                return (T) ((RealFieldElement) realFieldElementDotProduct.divide(realFieldElement)).acos();
            }
            FieldVector3D fieldVector3DCrossProduct = crossProduct(fieldVector3D, vector3D);
            if (realFieldElementDotProduct.getReal() >= 0.0d) {
                return (T) ((RealFieldElement) fieldVector3DCrossProduct.getNorm().divide(realFieldElement)).asin();
            }
            return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DCrossProduct.getNorm().divide(realFieldElement)).asin()).subtract(3.141592653589793d)).negate();
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        return (T) fieldVector3D.distanceInf(fieldVector3D2);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(FieldVector3D<T> fieldVector3D, Vector3D vector3D) {
        return (T) fieldVector3D.distanceInf(vector3D);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return (T) fieldVector3D.distanceInf(vector3D);
    }

    public FieldVector3D(T t6, FieldVector3D<T> fieldVector3D) {
        this.f6778x = (T) t6.multiply(fieldVector3D.f6778x);
        this.f6779y = (T) t6.multiply(fieldVector3D.f6779y);
        this.f6780z = (T) t6.multiply(fieldVector3D.f6780z);
    }

    public FieldVector3D(T t6, Vector3D vector3D) {
        this.f6778x = (T) t6.multiply(vector3D.getX());
        this.f6779y = (T) t6.multiply(vector3D.getY());
        this.f6780z = (T) t6.multiply(vector3D.getZ());
    }

    public static <T extends RealFieldElement<T>> T angle(Vector3D vector3D, FieldVector3D<T> fieldVector3D) {
        return (T) angle(fieldVector3D, vector3D);
    }

    public FieldVector3D(double d, FieldVector3D<T> fieldVector3D) {
        this.f6778x = (T) fieldVector3D.f6778x.multiply(d);
        this.f6779y = (T) fieldVector3D.f6779y.multiply(d);
        this.f6780z = (T) fieldVector3D.f6780z.multiply(d);
    }

    public FieldVector3D(T t6, FieldVector3D<T> fieldVector3D, T t7, FieldVector3D<T> fieldVector3D2) {
        this.f6778x = (T) t6.linearCombination(t6, fieldVector3D.getX(), t7, fieldVector3D2.getX());
        this.f6779y = (T) t6.linearCombination(t6, fieldVector3D.getY(), t7, fieldVector3D2.getY());
        this.f6780z = (T) t6.linearCombination(t6, fieldVector3D.getZ(), t7, fieldVector3D2.getZ());
    }

    public FieldVector3D(T t6, Vector3D vector3D, T t7, Vector3D vector3D2) {
        this.f6778x = (T) t6.linearCombination(vector3D.getX(), t6, vector3D2.getX(), t7);
        this.f6779y = (T) t6.linearCombination(vector3D.getY(), t6, vector3D2.getY(), t7);
        this.f6780z = (T) t6.linearCombination(vector3D.getZ(), t6, vector3D2.getZ(), t7);
    }

    public FieldVector3D(double d, FieldVector3D<T> fieldVector3D, double d6, FieldVector3D<T> fieldVector3D2) {
        RealFieldElement x6 = fieldVector3D.getX();
        this.f6778x = (T) x6.linearCombination(d, fieldVector3D.getX(), d6, fieldVector3D2.getX());
        this.f6779y = (T) x6.linearCombination(d, fieldVector3D.getY(), d6, fieldVector3D2.getY());
        this.f6780z = (T) x6.linearCombination(d, fieldVector3D.getZ(), d6, fieldVector3D2.getZ());
    }

    public FieldVector3D(T t6, FieldVector3D<T> fieldVector3D, T t7, FieldVector3D<T> fieldVector3D2, T t8, FieldVector3D<T> fieldVector3D3) {
        this.f6778x = (T) t6.linearCombination(t6, fieldVector3D.getX(), t7, fieldVector3D2.getX(), t8, fieldVector3D3.getX());
        this.f6779y = (T) t6.linearCombination(t6, fieldVector3D.getY(), t7, fieldVector3D2.getY(), t8, fieldVector3D3.getY());
        this.f6780z = (T) t6.linearCombination(t6, fieldVector3D.getZ(), t7, fieldVector3D2.getZ(), t8, fieldVector3D3.getZ());
    }

    public FieldVector3D(T t6, Vector3D vector3D, T t7, Vector3D vector3D2, T t8, Vector3D vector3D3) {
        this.f6778x = (T) t6.linearCombination(vector3D.getX(), t6, vector3D2.getX(), t7, vector3D3.getX(), t8);
        this.f6779y = (T) t6.linearCombination(vector3D.getY(), t6, vector3D2.getY(), t7, vector3D3.getY(), t8);
        this.f6780z = (T) t6.linearCombination(vector3D.getZ(), t6, vector3D2.getZ(), t7, vector3D3.getZ(), t8);
    }

    public FieldVector3D(double d, FieldVector3D<T> fieldVector3D, double d6, FieldVector3D<T> fieldVector3D2, double d7, FieldVector3D<T> fieldVector3D3) {
        RealFieldElement x6 = fieldVector3D.getX();
        this.f6778x = (T) x6.linearCombination(d, fieldVector3D.getX(), d6, fieldVector3D2.getX(), d7, fieldVector3D3.getX());
        this.f6779y = (T) x6.linearCombination(d, fieldVector3D.getY(), d6, fieldVector3D2.getY(), d7, fieldVector3D3.getY());
        this.f6780z = (T) x6.linearCombination(d, fieldVector3D.getZ(), d6, fieldVector3D2.getZ(), d7, fieldVector3D3.getZ());
    }

    public FieldVector3D(T t6, FieldVector3D<T> fieldVector3D, T t7, FieldVector3D<T> fieldVector3D2, T t8, FieldVector3D<T> fieldVector3D3, T t9, FieldVector3D<T> fieldVector3D4) {
        this.f6778x = (T) t6.linearCombination(t6, fieldVector3D.getX(), t7, fieldVector3D2.getX(), t8, fieldVector3D3.getX(), t9, fieldVector3D4.getX());
        this.f6779y = (T) t6.linearCombination(t6, fieldVector3D.getY(), t7, fieldVector3D2.getY(), t8, fieldVector3D3.getY(), t9, fieldVector3D4.getY());
        this.f6780z = (T) t6.linearCombination(t6, fieldVector3D.getZ(), t7, fieldVector3D2.getZ(), t8, fieldVector3D3.getZ(), t9, fieldVector3D4.getZ());
    }

    public FieldVector3D(T t6, Vector3D vector3D, T t7, Vector3D vector3D2, T t8, Vector3D vector3D3, T t9, Vector3D vector3D4) {
        this.f6778x = (T) t6.linearCombination(vector3D.getX(), t6, vector3D2.getX(), t7, vector3D3.getX(), t8, vector3D4.getX(), t9);
        this.f6779y = (T) t6.linearCombination(vector3D.getY(), t6, vector3D2.getY(), t7, vector3D3.getY(), t8, vector3D4.getY(), t9);
        this.f6780z = (T) t6.linearCombination(vector3D.getZ(), t6, vector3D2.getZ(), t7, vector3D3.getZ(), t8, vector3D4.getZ(), t9);
    }

    public FieldVector3D(double d, FieldVector3D<T> fieldVector3D, double d6, FieldVector3D<T> fieldVector3D2, double d7, FieldVector3D<T> fieldVector3D3, double d8, FieldVector3D<T> fieldVector3D4) {
        RealFieldElement x6 = fieldVector3D.getX();
        this.f6778x = (T) x6.linearCombination(d, fieldVector3D.getX(), d6, fieldVector3D2.getX(), d7, fieldVector3D3.getX(), d8, fieldVector3D4.getX());
        this.f6779y = (T) x6.linearCombination(d, fieldVector3D.getY(), d6, fieldVector3D2.getY(), d7, fieldVector3D3.getY(), d8, fieldVector3D4.getY());
        this.f6780z = (T) x6.linearCombination(d, fieldVector3D.getZ(), d6, fieldVector3D2.getZ(), d7, fieldVector3D3.getZ(), d8, fieldVector3D4.getZ());
    }
}
