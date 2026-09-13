package org.apache.commons.math3.analysis.differentiation;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DerivativeStructure implements RealFieldElement<DerivativeStructure>, Serializable {
    private static final long serialVersionUID = 20120730;
    private transient DSCompiler compiler;
    private final double[] data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120730;
        private final double[] data;
        private final int order;
        private final int variables;

        public DataTransferObject(int i5, int i6, double[] dArr) {
            this.variables = i5;
            this.order = i6;
            this.data = dArr;
        }

        private Object readResolve() {
            return new DerivativeStructure(this.variables, this.order, this.data);
        }
    }

    private DerivativeStructure(DSCompiler dSCompiler) {
        this.compiler = dSCompiler;
        this.data = new double[dSCompiler.getSize()];
    }

    private Object writeReplace() {
        return new DataTransferObject(this.compiler.getFreeParameters(), this.compiler.getOrder(), this.data);
    }

    public DerivativeStructure compose(double... dArr) {
        if (dArr.length != getOrder() + 1) {
            throw new DimensionMismatchException(dArr.length, getOrder() + 1);
        }
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.compose(this.data, 0, dArr, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    public DerivativeStructure createConstant(double d) {
        return new DerivativeStructure(getFreeParameters(), getOrder(), d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DerivativeStructure) {
            DerivativeStructure derivativeStructure = (DerivativeStructure) obj;
            if (getFreeParameters() == derivativeStructure.getFreeParameters() && getOrder() == derivativeStructure.getOrder() && MathArrays.equals(this.data, derivativeStructure.data)) {
                return true;
            }
        }
        return false;
    }

    public double[] getAllDerivatives() {
        return (double[]) this.data.clone();
    }

    public int getExponent() {
        return FastMath.getExponent(this.data[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<DerivativeStructure> getField() {
        return new Field<DerivativeStructure>() { // from class: org.apache.commons.math3.analysis.differentiation.DerivativeStructure.1
            @Override // org.apache.commons.math3.Field
            public Class<? extends FieldElement<DerivativeStructure>> getRuntimeClass() {
                return DerivativeStructure.class;
            }

            @Override // org.apache.commons.math3.Field
            public DerivativeStructure getOne() {
                return new DerivativeStructure(DerivativeStructure.this.compiler.getFreeParameters(), DerivativeStructure.this.compiler.getOrder(), 1.0d);
            }

            @Override // org.apache.commons.math3.Field
            public DerivativeStructure getZero() {
                return new DerivativeStructure(DerivativeStructure.this.compiler.getFreeParameters(), DerivativeStructure.this.compiler.getOrder(), 0.0d);
            }
        };
    }

    public int getFreeParameters() {
        return this.compiler.getFreeParameters();
    }

    public int getOrder() {
        return this.compiler.getOrder();
    }

    public double getPartialDerivative(int... iArr) {
        return this.data[this.compiler.getPartialDerivativeIndex(iArr)];
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.data[0];
    }

    public double getValue() {
        return this.data[0];
    }

    public int hashCode() {
        return (MathUtils.hash(this.data) * 239) + (getOrder() * 233) + (getFreeParameters() * 229) + 227;
    }

    public DerivativeStructure log10() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.log10(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public long round() {
        return FastMath.round(this.data[0]);
    }

    public double taylor(double... dArr) {
        return this.compiler.taylor(this.data, 0, dArr);
    }

    public DerivativeStructure toDegrees() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        int i5 = 0;
        while (true) {
            double[] dArr = derivativeStructure.data;
            if (i5 >= dArr.length) {
                return derivativeStructure;
            }
            dArr[i5] = FastMath.toDegrees(this.data[i5]);
            i5++;
        }
    }

    public DerivativeStructure toRadians() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        int i5 = 0;
        while (true) {
            double[] dArr = derivativeStructure.data;
            if (i5 >= dArr.length) {
                return derivativeStructure;
            }
            dArr[i5] = FastMath.toRadians(this.data[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure abs() {
        return Double.doubleToLongBits(this.data[0]) < 0 ? negate() : this;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure acos() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.acos(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure acosh() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.acosh(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure asin() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.asin(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure asinh() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.asinh(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure atan() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.atan(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure atan2(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this.compiler);
        this.compiler.atan2(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure atanh() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.atanh(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure cbrt() {
        return rootN(3);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure ceil() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.ceil(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure cos() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.cos(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure cosh() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.cosh(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure exp() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.exp(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure expm1() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.expm1(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure floor() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.floor(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure hypot(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        if (Double.isInfinite(this.data[0]) || Double.isInfinite(derivativeStructure.data[0])) {
            return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getFreeParameters(), Double.POSITIVE_INFINITY);
        }
        if (Double.isNaN(this.data[0]) || Double.isNaN(derivativeStructure.data[0])) {
            return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getFreeParameters(), Double.NaN);
        }
        int exponent = getExponent();
        int exponent2 = derivativeStructure.getExponent();
        if (exponent > exponent2 + 27) {
            return abs();
        }
        if (exponent2 > exponent + 27) {
            return derivativeStructure.abs();
        }
        int i5 = (exponent + exponent2) / 2;
        int i6 = -i5;
        DerivativeStructure derivativeStructureScalb = scalb(i6);
        DerivativeStructure derivativeStructureScalb2 = derivativeStructure.scalb(i6);
        return derivativeStructureScalb.multiply(derivativeStructureScalb).add(derivativeStructureScalb2.multiply(derivativeStructureScalb2)).sqrt().scalb(i5);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure log() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.log(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure log1p() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.log1p(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure negate() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        int i5 = 0;
        while (true) {
            double[] dArr = derivativeStructure.data;
            if (i5 >= dArr.length) {
                return derivativeStructure;
            }
            dArr[i5] = -this.data[i5];
            i5++;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public DerivativeStructure reciprocal() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, -1, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure rint() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.rint(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure rootN(int i5) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.rootN(this.data, 0, i5, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure scalb(int i5) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        int i6 = 0;
        while (true) {
            double[] dArr = derivativeStructure.data;
            if (i6 >= dArr.length) {
                return derivativeStructure;
            }
            dArr[i6] = FastMath.scalb(this.data[i6], i5);
            i6++;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure signum() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.signum(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure sin() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.sin(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure sinh() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.sinh(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure sqrt() {
        return rootN(2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure tan() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.tan(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure tanh() {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.tanh(this.data, 0, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure add(double d) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this);
        double[] dArr = derivativeStructure.data;
        dArr[0] = dArr[0] + d;
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure copySign(DerivativeStructure derivativeStructure) {
        long jDoubleToLongBits = Double.doubleToLongBits(this.data[0]);
        long jDoubleToLongBits2 = Double.doubleToLongBits(derivativeStructure.data[0]);
        return ((jDoubleToLongBits < 0 || jDoubleToLongBits2 < 0) && (jDoubleToLongBits >= 0 || jDoubleToLongBits2 >= 0)) ? negate() : this;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure divide(double d) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this);
        int i5 = 0;
        while (true) {
            double[] dArr = derivativeStructure.data;
            if (i5 >= dArr.length) {
                return derivativeStructure;
            }
            dArr[i5] = dArr[i5] / d;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure remainder(double d) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this);
        double[] dArr = derivativeStructure.data;
        dArr[0] = FastMath.IEEEremainder(dArr[0], d);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure subtract(double d) {
        return add(-d);
    }

    public DerivativeStructure(int i5, int i6) {
        this(DSCompiler.getCompiler(i5, i6));
    }

    public static DerivativeStructure pow(double d, DerivativeStructure derivativeStructure) {
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(derivativeStructure.compiler);
        derivativeStructure.compiler.pow(d, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure multiply(int i5) {
        return multiply(i5);
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure subtract(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this);
        this.compiler.subtract(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    public DerivativeStructure(int i5, int i6, double d) {
        this(i5, i6);
        this.data[0] = d;
    }

    public static DerivativeStructure atan2(DerivativeStructure derivativeStructure, DerivativeStructure derivativeStructure2) {
        return derivativeStructure.atan2(derivativeStructure2);
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure add(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this);
        this.compiler.add(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure multiply(double d) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this);
        int i5 = 0;
        while (true) {
            double[] dArr = derivativeStructure.data;
            if (i5 >= dArr.length) {
                return derivativeStructure;
            }
            dArr[i5] = dArr[i5] * d;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure remainder(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this.compiler);
        this.compiler.remainder(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure copySign(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(this.data[0]);
        long jDoubleToLongBits2 = Double.doubleToLongBits(d);
        return ((jDoubleToLongBits < 0 || jDoubleToLongBits2 < 0) && (jDoubleToLongBits >= 0 || jDoubleToLongBits2 >= 0)) ? negate() : this;
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure divide(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this.compiler);
        this.compiler.divide(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure pow(double d) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, d, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    public DerivativeStructure(int i5, int i6, int i7, double d) {
        this(i5, i6, d);
        if (i7 >= i5) {
            throw new NumberIsTooLargeException(Integer.valueOf(i7), Integer.valueOf(i5), false);
        }
        if (i6 > 0) {
            this.data[DSCompiler.getCompiler(i7, i6).getSize()] = 1.0d;
        }
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure multiply(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this.compiler);
        this.compiler.multiply(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure pow(int i5) {
        DerivativeStructure derivativeStructure = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, i5, derivativeStructure.data, 0);
        return derivativeStructure;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(DerivativeStructure[] derivativeStructureArr, DerivativeStructure[] derivativeStructureArr2) {
        double[] dArr = new double[derivativeStructureArr.length];
        for (int i5 = 0; i5 < derivativeStructureArr.length; i5++) {
            dArr[i5] = derivativeStructureArr[i5].getValue();
        }
        double[] dArr2 = new double[derivativeStructureArr2.length];
        for (int i6 = 0; i6 < derivativeStructureArr2.length; i6++) {
            dArr2[i6] = derivativeStructureArr2[i6].getValue();
        }
        double dLinearCombination = MathArrays.linearCombination(dArr, dArr2);
        DerivativeStructure zero = derivativeStructureArr[0].getField().getZero();
        for (int i7 = 0; i7 < derivativeStructureArr.length; i7++) {
            zero = zero.add(derivativeStructureArr[i7].multiply(derivativeStructureArr2[i7]));
        }
        double[] allDerivatives = zero.getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(zero.getFreeParameters(), zero.getOrder(), allDerivatives);
    }

    public DerivativeStructure(double d, DerivativeStructure derivativeStructure, double d6, DerivativeStructure derivativeStructure2) {
        this(derivativeStructure.compiler);
        this.compiler.checkCompatibility(derivativeStructure2.compiler);
        this.compiler.linearCombination(d, derivativeStructure.data, 0, d6, derivativeStructure2.data, 0, this.data, 0);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure pow(DerivativeStructure derivativeStructure) {
        this.compiler.checkCompatibility(derivativeStructure.compiler);
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, derivativeStructure.data, 0, derivativeStructure2.data, 0);
        return derivativeStructure2;
    }

    public DerivativeStructure(double d, DerivativeStructure derivativeStructure, double d6, DerivativeStructure derivativeStructure2, double d7, DerivativeStructure derivativeStructure3) {
        this(derivativeStructure.compiler);
        this.compiler.checkCompatibility(derivativeStructure2.compiler);
        this.compiler.checkCompatibility(derivativeStructure3.compiler);
        this.compiler.linearCombination(d, derivativeStructure.data, 0, d6, derivativeStructure2.data, 0, d7, derivativeStructure3.data, 0, this.data, 0);
    }

    public static DerivativeStructure hypot(DerivativeStructure derivativeStructure, DerivativeStructure derivativeStructure2) {
        return derivativeStructure.hypot(derivativeStructure2);
    }

    public DerivativeStructure(double d, DerivativeStructure derivativeStructure, double d6, DerivativeStructure derivativeStructure2, double d7, DerivativeStructure derivativeStructure3, double d8, DerivativeStructure derivativeStructure4) {
        this(derivativeStructure.compiler);
        this.compiler.checkCompatibility(derivativeStructure2.compiler);
        this.compiler.checkCompatibility(derivativeStructure3.compiler);
        this.compiler.checkCompatibility(derivativeStructure4.compiler);
        this.compiler.linearCombination(d, derivativeStructure.data, 0, d6, derivativeStructure2.data, 0, d7, derivativeStructure3.data, 0, d8, derivativeStructure4.data, 0, this.data, 0);
    }

    public DerivativeStructure(int i5, int i6, double... dArr) {
        this(i5, i6);
        int length = dArr.length;
        double[] dArr2 = this.data;
        if (length == dArr2.length) {
            System.arraycopy(dArr, 0, dArr2, 0, dArr2.length);
            return;
        }
        throw new DimensionMismatchException(dArr.length, this.data.length);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(double[] dArr, DerivativeStructure[] derivativeStructureArr) {
        double[] dArr2 = new double[derivativeStructureArr.length];
        for (int i5 = 0; i5 < derivativeStructureArr.length; i5++) {
            dArr2[i5] = derivativeStructureArr[i5].getValue();
        }
        double dLinearCombination = MathArrays.linearCombination(dArr, dArr2);
        DerivativeStructure zero = derivativeStructureArr[0].getField().getZero();
        for (int i6 = 0; i6 < dArr.length; i6++) {
            zero = zero.add(derivativeStructureArr[i6].multiply(dArr[i6]));
        }
        double[] allDerivatives = zero.getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(zero.getFreeParameters(), zero.getOrder(), allDerivatives);
    }

    private DerivativeStructure(DerivativeStructure derivativeStructure) {
        this.compiler = derivativeStructure.compiler;
        this.data = (double[]) derivativeStructure.data.clone();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(DerivativeStructure derivativeStructure, DerivativeStructure derivativeStructure2, DerivativeStructure derivativeStructure3, DerivativeStructure derivativeStructure4) {
        double dLinearCombination = MathArrays.linearCombination(derivativeStructure.getValue(), derivativeStructure2.getValue(), derivativeStructure3.getValue(), derivativeStructure4.getValue());
        double[] allDerivatives = derivativeStructure.multiply(derivativeStructure2).add(derivativeStructure3.multiply(derivativeStructure4)).getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(getFreeParameters(), getOrder(), allDerivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(double d, DerivativeStructure derivativeStructure, double d6, DerivativeStructure derivativeStructure2) {
        double dLinearCombination = MathArrays.linearCombination(d, derivativeStructure.getValue(), d6, derivativeStructure2.getValue());
        double[] allDerivatives = derivativeStructure.multiply(d).add(derivativeStructure2.multiply(d6)).getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(getFreeParameters(), getOrder(), allDerivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(DerivativeStructure derivativeStructure, DerivativeStructure derivativeStructure2, DerivativeStructure derivativeStructure3, DerivativeStructure derivativeStructure4, DerivativeStructure derivativeStructure5, DerivativeStructure derivativeStructure6) {
        double dLinearCombination = MathArrays.linearCombination(derivativeStructure.getValue(), derivativeStructure2.getValue(), derivativeStructure3.getValue(), derivativeStructure4.getValue(), derivativeStructure5.getValue(), derivativeStructure6.getValue());
        double[] allDerivatives = derivativeStructure.multiply(derivativeStructure2).add(derivativeStructure3.multiply(derivativeStructure4)).add(derivativeStructure5.multiply(derivativeStructure6)).getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(getFreeParameters(), getOrder(), allDerivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(double d, DerivativeStructure derivativeStructure, double d6, DerivativeStructure derivativeStructure2, double d7, DerivativeStructure derivativeStructure3) {
        double dLinearCombination = MathArrays.linearCombination(d, derivativeStructure.getValue(), d6, derivativeStructure2.getValue(), d7, derivativeStructure3.getValue());
        double[] allDerivatives = derivativeStructure.multiply(d).add(derivativeStructure2.multiply(d6)).add(derivativeStructure3.multiply(d7)).getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(getFreeParameters(), getOrder(), allDerivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(DerivativeStructure derivativeStructure, DerivativeStructure derivativeStructure2, DerivativeStructure derivativeStructure3, DerivativeStructure derivativeStructure4, DerivativeStructure derivativeStructure5, DerivativeStructure derivativeStructure6, DerivativeStructure derivativeStructure7, DerivativeStructure derivativeStructure8) {
        double dLinearCombination = MathArrays.linearCombination(derivativeStructure.getValue(), derivativeStructure2.getValue(), derivativeStructure3.getValue(), derivativeStructure4.getValue(), derivativeStructure5.getValue(), derivativeStructure6.getValue(), derivativeStructure7.getValue(), derivativeStructure8.getValue());
        double[] allDerivatives = derivativeStructure.multiply(derivativeStructure2).add(derivativeStructure3.multiply(derivativeStructure4)).add(derivativeStructure5.multiply(derivativeStructure6)).add(derivativeStructure7.multiply(derivativeStructure8)).getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(getFreeParameters(), getOrder(), allDerivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public DerivativeStructure linearCombination(double d, DerivativeStructure derivativeStructure, double d6, DerivativeStructure derivativeStructure2, double d7, DerivativeStructure derivativeStructure3, double d8, DerivativeStructure derivativeStructure4) {
        double dLinearCombination = MathArrays.linearCombination(d, derivativeStructure.getValue(), d6, derivativeStructure2.getValue(), d7, derivativeStructure3.getValue(), d8, derivativeStructure4.getValue());
        double[] allDerivatives = derivativeStructure.multiply(d).add(derivativeStructure2.multiply(d6)).add(derivativeStructure3.multiply(d7)).add(derivativeStructure4.multiply(d8)).getAllDerivatives();
        allDerivatives[0] = dLinearCombination;
        return new DerivativeStructure(getFreeParameters(), getOrder(), allDerivatives);
    }
}
