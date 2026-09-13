package org.apache.commons.math3.complex;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Complex implements FieldElement<Complex>, Serializable {
    private static final long serialVersionUID = -6195664516687396620L;
    private final double imaginary;
    private final transient boolean isInfinite;
    private final transient boolean isNaN;
    private final double real;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final Complex f6754I = new Complex(0.0d, 1.0d);
    public static final Complex NaN = new Complex(Double.NaN, Double.NaN);
    public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final Complex ONE = new Complex(1.0d, 0.0d);
    public static final Complex ZERO = new Complex(0.0d, 0.0d);

    public Complex(double d) {
        this(d, 0.0d);
    }

    public static boolean equalsWithRelativeTolerance(Complex complex, Complex complex2, double d) {
        return Precision.equalsWithRelativeTolerance(complex.real, complex2.real, d) && Precision.equalsWithRelativeTolerance(complex.imaginary, complex2.imaginary, d);
    }

    public static Complex valueOf(double d, double d6) {
        return (Double.isNaN(d) || Double.isNaN(d6)) ? NaN : new Complex(d, d6);
    }

    public double abs() {
        if (this.isNaN) {
            return Double.NaN;
        }
        if (isInfinite()) {
            return Double.POSITIVE_INFINITY;
        }
        if (FastMath.abs(this.real) < FastMath.abs(this.imaginary)) {
            double d = this.imaginary;
            if (d == 0.0d) {
                return FastMath.abs(this.real);
            }
            double d6 = this.real / d;
            return FastMath.sqrt((d6 * d6) + 1.0d) * FastMath.abs(d);
        }
        double d7 = this.real;
        if (d7 == 0.0d) {
            return FastMath.abs(this.imaginary);
        }
        double d8 = this.imaginary / d7;
        return FastMath.sqrt((d8 * d8) + 1.0d) * FastMath.abs(d7);
    }

    public Complex acos() {
        if (this.isNaN) {
            return NaN;
        }
        Complex complexSqrt1z = sqrt1z();
        Complex complex = f6754I;
        return add(complexSqrt1z.multiply(complex)).log().multiply(complex.negate());
    }

    public Complex asin() {
        if (this.isNaN) {
            return NaN;
        }
        Complex complexSqrt1z = sqrt1z();
        Complex complex = f6754I;
        return complexSqrt1z.add(multiply(complex)).log().multiply(complex.negate());
    }

    public Complex atan() {
        if (this.isNaN) {
            return NaN;
        }
        Complex complex = f6754I;
        return add(complex).divide(complex.subtract(this)).log().multiply(complex.divide(createComplex(2.0d, 0.0d)));
    }

    public Complex conjugate() {
        return this.isNaN ? NaN : createComplex(this.real, -this.imaginary);
    }

    public Complex cos() {
        if (this.isNaN) {
            return NaN;
        }
        return createComplex(FastMath.cosh(this.imaginary) * FastMath.cos(this.real), FastMath.sinh(this.imaginary) * (-FastMath.sin(this.real)));
    }

    public Complex cosh() {
        if (this.isNaN) {
            return NaN;
        }
        return createComplex(FastMath.cos(this.imaginary) * FastMath.cosh(this.real), FastMath.sin(this.imaginary) * FastMath.sinh(this.real));
    }

    public Complex createComplex(double d, double d6) {
        return new Complex(d, d6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Complex) {
            Complex complex = (Complex) obj;
            if (complex.isNaN) {
                return this.isNaN;
            }
            if (MathUtils.equals(this.real, complex.real) && MathUtils.equals(this.imaginary, complex.imaginary)) {
                return true;
            }
        }
        return false;
    }

    public Complex exp() {
        if (this.isNaN) {
            return NaN;
        }
        double dExp = FastMath.exp(this.real);
        return createComplex(FastMath.cos(this.imaginary) * dExp, FastMath.sin(this.imaginary) * dExp);
    }

    public double getArgument() {
        return FastMath.atan2(getImaginary(), getReal());
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public int hashCode() {
        if (this.isNaN) {
            return 7;
        }
        return (MathUtils.hash(this.real) + (MathUtils.hash(this.imaginary) * 17)) * 37;
    }

    public boolean isInfinite() {
        return this.isInfinite;
    }

    public boolean isNaN() {
        return this.isNaN;
    }

    public Complex log() {
        return this.isNaN ? NaN : createComplex(FastMath.log(abs()), FastMath.atan2(this.imaginary, this.real));
    }

    public List<Complex> nthRoot(int i5) {
        if (i5 <= 0) {
            throw new NotPositiveException(LocalizedFormats.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N, Integer.valueOf(i5));
        }
        ArrayList arrayList = new ArrayList();
        if (this.isNaN) {
            arrayList.add(NaN);
            return arrayList;
        }
        if (isInfinite()) {
            arrayList.add(INF);
            return arrayList;
        }
        double d = i5;
        double dPow = FastMath.pow(abs(), 1.0d / d);
        double argument = getArgument() / d;
        double d6 = 6.283185307179586d / d;
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(createComplex(FastMath.cos(argument) * dPow, FastMath.sin(argument) * dPow));
            argument += d6;
        }
        return arrayList;
    }

    public Complex pow(Complex complex) {
        MathUtils.checkNotNull(complex);
        return log().multiply(complex).exp();
    }

    public final Object readResolve() {
        return createComplex(this.real, this.imaginary);
    }

    public Complex sin() {
        if (this.isNaN) {
            return NaN;
        }
        return createComplex(FastMath.cosh(this.imaginary) * FastMath.sin(this.real), FastMath.sinh(this.imaginary) * FastMath.cos(this.real));
    }

    public Complex sinh() {
        if (this.isNaN) {
            return NaN;
        }
        return createComplex(FastMath.cos(this.imaginary) * FastMath.sinh(this.real), FastMath.sin(this.imaginary) * FastMath.cosh(this.real));
    }

    public Complex sqrt() {
        if (this.isNaN) {
            return NaN;
        }
        double d = this.real;
        if (d == 0.0d && this.imaginary == 0.0d) {
            return createComplex(0.0d, 0.0d);
        }
        double dSqrt = FastMath.sqrt((abs() + FastMath.abs(d)) / 2.0d);
        return this.real >= 0.0d ? createComplex(dSqrt, this.imaginary / (2.0d * dSqrt)) : createComplex(FastMath.abs(this.imaginary) / (2.0d * dSqrt), FastMath.copySign(1.0d, this.imaginary) * dSqrt);
    }

    public Complex sqrt1z() {
        return createComplex(1.0d, 0.0d).subtract(multiply(this)).sqrt();
    }

    public Complex tan() {
        if (this.isNaN || Double.isInfinite(this.real)) {
            return NaN;
        }
        double d = this.imaginary;
        if (d > 20.0d) {
            return createComplex(0.0d, 1.0d);
        }
        if (d < -20.0d) {
            return createComplex(0.0d, -1.0d);
        }
        double d6 = this.real * 2.0d;
        double d7 = d * 2.0d;
        double dCosh = FastMath.cosh(d7) + FastMath.cos(d6);
        return createComplex(FastMath.sin(d6) / dCosh, FastMath.sinh(d7) / dCosh);
    }

    public Complex tanh() {
        if (this.isNaN || Double.isInfinite(this.imaginary)) {
            return NaN;
        }
        double d = this.real;
        if (d > 20.0d) {
            return createComplex(1.0d, 0.0d);
        }
        if (d < -20.0d) {
            return createComplex(-1.0d, 0.0d);
        }
        double d6 = d * 2.0d;
        double d7 = this.imaginary * 2.0d;
        double dCos = FastMath.cos(d7) + FastMath.cosh(d6);
        return createComplex(FastMath.sinh(d6) / dCos, FastMath.sin(d7) / dCos);
    }

    public String toString() {
        return "(" + this.real + ", " + this.imaginary + ")";
    }

    public Complex(double d, double d6) {
        this.real = d;
        this.imaginary = d6;
        boolean z6 = true;
        boolean z7 = Double.isNaN(d) || Double.isNaN(d6);
        this.isNaN = z7;
        if (z7 || (!Double.isInfinite(d) && !Double.isInfinite(d6))) {
            z6 = false;
        }
        this.isInfinite = z6;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex add(Complex complex) {
        MathUtils.checkNotNull(complex);
        if (this.isNaN || complex.isNaN) {
            return NaN;
        }
        return createComplex(complex.getReal() + this.real, complex.getImaginary() + this.imaginary);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex divide(Complex complex) {
        MathUtils.checkNotNull(complex);
        if (this.isNaN || complex.isNaN) {
            return NaN;
        }
        double real = complex.getReal();
        double imaginary = complex.getImaginary();
        if (real == 0.0d && imaginary == 0.0d) {
            return NaN;
        }
        if (complex.isInfinite() && !isInfinite()) {
            return ZERO;
        }
        if (FastMath.abs(real) < FastMath.abs(imaginary)) {
            double d = real / imaginary;
            double d6 = (real * d) + imaginary;
            double d7 = this.real;
            double d8 = this.imaginary;
            return createComplex(((d7 * d) + d8) / d6, ((d8 * d) - d7) / d6);
        }
        double d9 = imaginary / real;
        double d10 = (imaginary * d9) + real;
        double d11 = this.imaginary;
        double d12 = this.real;
        return createComplex(((d11 * d9) + d12) / d10, a.a(d12, d9, d11, d10));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<Complex> getField() {
        return ComplexField.getInstance();
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex negate() {
        return this.isNaN ? NaN : createComplex(-this.real, -this.imaginary);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex reciprocal() {
        if (this.isNaN) {
            return NaN;
        }
        double d = this.real;
        if (d == 0.0d && this.imaginary == 0.0d) {
            return INF;
        }
        if (this.isInfinite) {
            return ZERO;
        }
        if (FastMath.abs(d) < FastMath.abs(this.imaginary)) {
            double d6 = this.real;
            double d7 = this.imaginary;
            double d8 = d6 / d7;
            double d9 = 1.0d / ((d6 * d8) + d7);
            return createComplex(d8 * d9, -d9);
        }
        double d10 = this.imaginary;
        double d11 = this.real;
        double d12 = d10 / d11;
        double d13 = 1.0d / ((d10 * d12) + d11);
        return createComplex(d13, (-d13) * d12);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex subtract(Complex complex) {
        MathUtils.checkNotNull(complex);
        return (this.isNaN || complex.isNaN) ? NaN : createComplex(this.real - complex.getReal(), this.imaginary - complex.getImaginary());
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex multiply(Complex complex) {
        MathUtils.checkNotNull(complex);
        if (!this.isNaN && !complex.isNaN) {
            if (!Double.isInfinite(this.real) && !Double.isInfinite(this.imaginary) && !Double.isInfinite(complex.real) && !Double.isInfinite(complex.imaginary)) {
                double d = this.real;
                double d6 = complex.real;
                double d7 = this.imaginary;
                double d8 = complex.imaginary;
                return createComplex((d * d6) - (d7 * d8), (d7 * d6) + (d * d8));
            }
            return INF;
        }
        return NaN;
    }

    public Complex pow(double d) {
        return log().multiply(d).exp();
    }

    public static Complex valueOf(double d) {
        if (Double.isNaN(d)) {
            return NaN;
        }
        return new Complex(d);
    }

    public static boolean equals(Complex complex, Complex complex2, int i5) {
        return Precision.equals(complex.real, complex2.real, i5) && Precision.equals(complex.imaginary, complex2.imaginary, i5);
    }

    public Complex add(double d) {
        if (!this.isNaN && !Double.isNaN(d)) {
            return createComplex(this.real + d, this.imaginary);
        }
        return NaN;
    }

    public Complex subtract(double d) {
        if (!this.isNaN && !Double.isNaN(d)) {
            return createComplex(this.real - d, this.imaginary);
        }
        return NaN;
    }

    public static boolean equals(Complex complex, Complex complex2) {
        return equals(complex, complex2, 1);
    }

    public static boolean equals(Complex complex, Complex complex2, double d) {
        return Precision.equals(complex.real, complex2.real, d) && Precision.equals(complex.imaginary, complex2.imaginary, d);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Complex multiply(int i5) {
        if (this.isNaN) {
            return NaN;
        }
        if (!Double.isInfinite(this.real) && !Double.isInfinite(this.imaginary)) {
            double d = i5;
            return createComplex(this.real * d, this.imaginary * d);
        }
        return INF;
    }

    public Complex divide(double d) {
        if (this.isNaN || Double.isNaN(d)) {
            return NaN;
        }
        if (d == 0.0d) {
            return NaN;
        }
        if (Double.isInfinite(d)) {
            return !isInfinite() ? ZERO : NaN;
        }
        return createComplex(this.real / d, this.imaginary / d);
    }

    public Complex multiply(double d) {
        if (!this.isNaN && !Double.isNaN(d)) {
            if (!Double.isInfinite(this.real) && !Double.isInfinite(this.imaginary) && !Double.isInfinite(d)) {
                return createComplex(this.real * d, this.imaginary * d);
            }
            return INF;
        }
        return NaN;
    }
}
