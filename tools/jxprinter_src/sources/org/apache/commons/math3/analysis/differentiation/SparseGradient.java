package org.apache.commons.math3.analysis.differentiation;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SparseGradient implements RealFieldElement<SparseGradient>, Serializable {
    private static final long serialVersionUID = 20131025;
    private final Map<Integer, Double> derivatives;
    private double value;

    private SparseGradient(double d, Map<Integer, Double> map) {
        this.value = d;
        HashMap map2 = new HashMap();
        this.derivatives = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public static SparseGradient createConstant(double d) {
        return new SparseGradient(d, Collections.EMPTY_MAP);
    }

    public static SparseGradient createVariable(int i5, double d) {
        return new SparseGradient(d, Collections.singletonMap(Integer.valueOf(i5), Double.valueOf(1.0d)));
    }

    public void addInPlace(SparseGradient sparseGradient) {
        this.value += sparseGradient.value;
        for (Map.Entry<Integer, Double> entry : sparseGradient.derivatives.entrySet()) {
            Integer key = entry.getKey();
            key.intValue();
            Double d = this.derivatives.get(key);
            if (d == null) {
                this.derivatives.put(key, entry.getValue());
            } else {
                this.derivatives.put(key, Double.valueOf(entry.getValue().doubleValue() + d.doubleValue()));
            }
        }
    }

    public SparseGradient compose(double d, double d6) {
        return new SparseGradient(d, d6, this.derivatives);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SparseGradient)) {
            return false;
        }
        SparseGradient sparseGradient = (SparseGradient) obj;
        if (!Precision.equals(this.value, sparseGradient.value, 1) || this.derivatives.size() != sparseGradient.derivatives.size()) {
            return false;
        }
        for (Map.Entry<Integer, Double> entry : this.derivatives.entrySet()) {
            if (!sparseGradient.derivatives.containsKey(entry.getKey()) || !Precision.equals(entry.getValue().doubleValue(), sparseGradient.derivatives.get(entry.getKey()).doubleValue(), 1)) {
                return false;
            }
        }
        return true;
    }

    public double getDerivative(int i5) {
        Double d = this.derivatives.get(Integer.valueOf(i5));
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<SparseGradient> getField() {
        return new Field<SparseGradient>() { // from class: org.apache.commons.math3.analysis.differentiation.SparseGradient.1
            @Override // org.apache.commons.math3.Field
            public Class<? extends FieldElement<SparseGradient>> getRuntimeClass() {
                return SparseGradient.class;
            }

            @Override // org.apache.commons.math3.Field
            public SparseGradient getOne() {
                return SparseGradient.createConstant(1.0d);
            }

            @Override // org.apache.commons.math3.Field
            public SparseGradient getZero() {
                return SparseGradient.createConstant(0.0d);
            }
        };
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.value;
    }

    public double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.derivatives.hashCode() * 167) + (MathUtils.hash(this.value) * 809) + 743;
    }

    public SparseGradient log10() {
        return new SparseGradient(FastMath.log10(this.value), 1.0d / (FastMath.log(10.0d) * this.value), this.derivatives);
    }

    public void multiplyInPlace(SparseGradient sparseGradient) {
        for (Map.Entry<Integer, Double> entry : this.derivatives.entrySet()) {
            this.derivatives.put(entry.getKey(), Double.valueOf(entry.getValue().doubleValue() * sparseGradient.value));
        }
        for (Map.Entry<Integer, Double> entry2 : sparseGradient.derivatives.entrySet()) {
            Integer key = entry2.getKey();
            key.intValue();
            Double d = this.derivatives.get(key);
            if (d == null) {
                this.derivatives.put(key, Double.valueOf(entry2.getValue().doubleValue() * this.value));
            } else {
                this.derivatives.put(key, Double.valueOf((entry2.getValue().doubleValue() * this.value) + d.doubleValue()));
            }
        }
        this.value *= sparseGradient.value;
    }

    public int numVars() {
        return this.derivatives.size();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public long round() {
        return FastMath.round(this.value);
    }

    public double taylor(double... dArr) {
        double derivative = this.value;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            derivative += getDerivative(i5) * dArr[i5];
        }
        return derivative;
    }

    public SparseGradient toDegrees() {
        return new SparseGradient(FastMath.toDegrees(this.value), FastMath.toDegrees(1.0d), this.derivatives);
    }

    public SparseGradient toRadians() {
        return new SparseGradient(FastMath.toRadians(this.value), FastMath.toRadians(1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient abs() {
        return Double.doubleToLongBits(this.value) < 0 ? negate() : this;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient acos() {
        double dAcos = FastMath.acos(this.value);
        double d = this.value;
        return new SparseGradient(dAcos, (-1.0d) / FastMath.sqrt(1.0d - (d * d)), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient acosh() {
        double dAcosh = FastMath.acosh(this.value);
        double d = this.value;
        return new SparseGradient(dAcosh, 1.0d / FastMath.sqrt((d * d) - 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient asin() {
        double dAsin = FastMath.asin(this.value);
        double d = this.value;
        return new SparseGradient(dAsin, 1.0d / FastMath.sqrt(1.0d - (d * d)), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient asinh() {
        double dAsinh = FastMath.asinh(this.value);
        double d = this.value;
        return new SparseGradient(dAsinh, 1.0d / FastMath.sqrt((d * d) + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient atan() {
        double dAtan = FastMath.atan(this.value);
        double d = this.value;
        return new SparseGradient(dAtan, 1.0d / ((d * d) + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient atan2(SparseGradient sparseGradient) {
        SparseGradient sparseGradientAdd;
        SparseGradient sparseGradientSqrt = multiply(this).add(sparseGradient.multiply(sparseGradient)).sqrt();
        if (sparseGradient.value >= 0.0d) {
            sparseGradientAdd = divide(sparseGradientSqrt.add(sparseGradient)).atan().multiply(2);
        } else {
            SparseGradient sparseGradientMultiply = divide(sparseGradientSqrt.subtract(sparseGradient)).atan().multiply(-2);
            sparseGradientAdd = sparseGradientMultiply.add(sparseGradientMultiply.value <= 0.0d ? -3.141592653589793d : 3.141592653589793d);
        }
        sparseGradientAdd.value = FastMath.atan2(this.value, sparseGradient.value);
        return sparseGradientAdd;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient atanh() {
        double dAtanh = FastMath.atanh(this.value);
        double d = this.value;
        return new SparseGradient(dAtanh, 1.0d / (1.0d - (d * d)), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient cbrt() {
        double dCbrt = FastMath.cbrt(this.value);
        return new SparseGradient(dCbrt, 1.0d / ((3.0d * dCbrt) * dCbrt), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient ceil() {
        return createConstant(FastMath.ceil(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient cos() {
        return new SparseGradient(FastMath.cos(this.value), -FastMath.sin(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient cosh() {
        return new SparseGradient(FastMath.cosh(this.value), FastMath.sinh(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient exp() {
        double dExp = FastMath.exp(this.value);
        return new SparseGradient(dExp, dExp, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient expm1() {
        return new SparseGradient(FastMath.expm1(this.value), FastMath.exp(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient floor() {
        return createConstant(FastMath.floor(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient hypot(SparseGradient sparseGradient) {
        if (Double.isInfinite(this.value) || Double.isInfinite(sparseGradient.value)) {
            return createConstant(Double.POSITIVE_INFINITY);
        }
        if (Double.isNaN(this.value) || Double.isNaN(sparseGradient.value)) {
            return createConstant(Double.NaN);
        }
        int exponent = FastMath.getExponent(this.value);
        int exponent2 = FastMath.getExponent(sparseGradient.value);
        if (exponent > exponent2 + 27) {
            return abs();
        }
        if (exponent2 > exponent + 27) {
            return sparseGradient.abs();
        }
        int i5 = (exponent + exponent2) / 2;
        int i6 = -i5;
        SparseGradient sparseGradientScalb = scalb(i6);
        SparseGradient sparseGradientScalb2 = sparseGradient.scalb(i6);
        return sparseGradientScalb.multiply(sparseGradientScalb).add(sparseGradientScalb2.multiply(sparseGradientScalb2)).sqrt().scalb(i5);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient log() {
        return new SparseGradient(FastMath.log(this.value), 1.0d / this.value, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient log1p() {
        return new SparseGradient(FastMath.log1p(this.value), 1.0d / (this.value + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient negate() {
        return new SparseGradient(-this.value, -1.0d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public SparseGradient reciprocal() {
        double d = this.value;
        return new SparseGradient(1.0d / d, (-1.0d) / (d * d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient rint() {
        return createConstant(FastMath.rint(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient rootN(int i5) {
        if (i5 == 2) {
            return sqrt();
        }
        if (i5 == 3) {
            return cbrt();
        }
        double d = i5;
        double dPow = FastMath.pow(this.value, 1.0d / d);
        return new SparseGradient(dPow, 1.0d / (FastMath.pow(dPow, i5 - 1) * d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient scalb(int i5) {
        SparseGradient sparseGradient = new SparseGradient(FastMath.scalb(this.value, i5), Collections.EMPTY_MAP);
        for (Map.Entry<Integer, Double> entry : this.derivatives.entrySet()) {
            sparseGradient.derivatives.put(entry.getKey(), Double.valueOf(FastMath.scalb(entry.getValue().doubleValue(), i5)));
        }
        return sparseGradient;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient signum() {
        return createConstant(FastMath.signum(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient sin() {
        return new SparseGradient(FastMath.sin(this.value), FastMath.cos(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient sinh() {
        return new SparseGradient(FastMath.sinh(this.value), FastMath.cosh(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient sqrt() {
        double dSqrt = FastMath.sqrt(this.value);
        return new SparseGradient(dSqrt, 0.5d / dSqrt, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient tan() {
        double dTan = FastMath.tan(this.value);
        return new SparseGradient(dTan, (dTan * dTan) + 1.0d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient tanh() {
        double dTanh = FastMath.tanh(this.value);
        return new SparseGradient(dTanh, 1.0d - (dTanh * dTanh), this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient add(SparseGradient sparseGradient) {
        SparseGradient sparseGradient2 = new SparseGradient(this.value + sparseGradient.value, this.derivatives);
        for (Map.Entry<Integer, Double> entry : sparseGradient.derivatives.entrySet()) {
            Integer key = entry.getKey();
            key.intValue();
            Double d = sparseGradient2.derivatives.get(key);
            if (d == null) {
                sparseGradient2.derivatives.put(key, entry.getValue());
            } else {
                sparseGradient2.derivatives.put(key, Double.valueOf(entry.getValue().doubleValue() + d.doubleValue()));
            }
        }
        return sparseGradient2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient copySign(SparseGradient sparseGradient) {
        long jDoubleToLongBits = Double.doubleToLongBits(this.value);
        long jDoubleToLongBits2 = Double.doubleToLongBits(sparseGradient.value);
        return ((jDoubleToLongBits < 0 || jDoubleToLongBits2 < 0) && (jDoubleToLongBits >= 0 || jDoubleToLongBits2 >= 0)) ? negate() : this;
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient divide(SparseGradient sparseGradient) {
        SparseGradient sparseGradient2 = new SparseGradient(this.value / sparseGradient.value, Collections.EMPTY_MAP);
        for (Map.Entry<Integer, Double> entry : this.derivatives.entrySet()) {
            sparseGradient2.derivatives.put(entry.getKey(), Double.valueOf(entry.getValue().doubleValue() / sparseGradient.value));
        }
        for (Map.Entry<Integer, Double> entry2 : sparseGradient.derivatives.entrySet()) {
            Integer key = entry2.getKey();
            key.intValue();
            Double d = sparseGradient2.derivatives.get(key);
            if (d == null) {
                sparseGradient2.derivatives.put(key, Double.valueOf(entry2.getValue().doubleValue() * ((-sparseGradient2.value) / sparseGradient.value)));
            } else {
                sparseGradient2.derivatives.put(key, Double.valueOf(d.doubleValue() - (entry2.getValue().doubleValue() * (sparseGradient2.value / sparseGradient.value))));
            }
        }
        return sparseGradient2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient remainder(double d) {
        return new SparseGradient(FastMath.IEEEremainder(this.value, d), this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient subtract(SparseGradient sparseGradient) {
        SparseGradient sparseGradient2 = new SparseGradient(this.value - sparseGradient.value, this.derivatives);
        for (Map.Entry<Integer, Double> entry : sparseGradient.derivatives.entrySet()) {
            Integer key = entry.getKey();
            key.intValue();
            Double d = sparseGradient2.derivatives.get(key);
            if (d == null) {
                sparseGradient2.derivatives.put(key, Double.valueOf(-entry.getValue().doubleValue()));
            } else {
                sparseGradient2.derivatives.put(key, Double.valueOf(d.doubleValue() - entry.getValue().doubleValue()));
            }
        }
        return sparseGradient2;
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient multiply(SparseGradient sparseGradient) {
        SparseGradient sparseGradient2 = new SparseGradient(this.value * sparseGradient.value, Collections.EMPTY_MAP);
        for (Map.Entry<Integer, Double> entry : this.derivatives.entrySet()) {
            sparseGradient2.derivatives.put(entry.getKey(), Double.valueOf(entry.getValue().doubleValue() * sparseGradient.value));
        }
        for (Map.Entry<Integer, Double> entry2 : sparseGradient.derivatives.entrySet()) {
            Integer key = entry2.getKey();
            key.intValue();
            Double d = sparseGradient2.derivatives.get(key);
            if (d == null) {
                sparseGradient2.derivatives.put(key, Double.valueOf(entry2.getValue().doubleValue() * this.value));
            } else {
                sparseGradient2.derivatives.put(key, Double.valueOf((entry2.getValue().doubleValue() * this.value) + d.doubleValue()));
            }
        }
        return sparseGradient2;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient pow(double d) {
        return new SparseGradient(FastMath.pow(this.value, d), FastMath.pow(this.value, d - 1.0d) * d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient remainder(SparseGradient sparseGradient) {
        return subtract(sparseGradient.multiply(FastMath.rint((this.value - FastMath.IEEEremainder(this.value, sparseGradient.value)) / sparseGradient.value)));
    }

    private SparseGradient(double d, double d6, Map<Integer, Double> map) {
        this.value = d;
        this.derivatives = new HashMap();
        if (map != null) {
            for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                this.derivatives.put(entry.getKey(), Double.valueOf(entry.getValue().doubleValue() * d6));
            }
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient pow(int i5) {
        if (i5 == 0) {
            return getField().getOne();
        }
        double dPow = FastMath.pow(this.value, i5 - 1);
        return new SparseGradient(this.value * dPow, ((double) i5) * dPow, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient copySign(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(this.value);
        long jDoubleToLongBits2 = Double.doubleToLongBits(d);
        return ((jDoubleToLongBits < 0 || jDoubleToLongBits2 < 0) && (jDoubleToLongBits >= 0 || jDoubleToLongBits2 >= 0)) ? negate() : this;
    }

    public static SparseGradient atan2(SparseGradient sparseGradient, SparseGradient sparseGradient2) {
        return sparseGradient.atan2(sparseGradient2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient pow(SparseGradient sparseGradient) {
        return log().multiply(sparseGradient).exp();
    }

    public static SparseGradient pow(double d, SparseGradient sparseGradient) {
        if (d == 0.0d) {
            double d6 = sparseGradient.value;
            if (d6 == 0.0d) {
                return sparseGradient.compose(1.0d, Double.NEGATIVE_INFINITY);
            }
            if (d6 < 0.0d) {
                return sparseGradient.compose(Double.NaN, Double.NaN);
            }
            return sparseGradient.getField().getZero();
        }
        double dPow = FastMath.pow(d, sparseGradient.value);
        return new SparseGradient(dPow, FastMath.log(d) * dPow, sparseGradient.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient add(double d) {
        return new SparseGradient(this.value + d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(SparseGradient[] sparseGradientArr, SparseGradient[] sparseGradientArr2) {
        SparseGradient zero = sparseGradientArr[0].getField().getZero();
        for (int i5 = 0; i5 < sparseGradientArr.length; i5++) {
            zero = zero.add(sparseGradientArr[i5].multiply(sparseGradientArr2[i5]));
        }
        double[] dArr = new double[sparseGradientArr.length];
        for (int i6 = 0; i6 < sparseGradientArr.length; i6++) {
            dArr[i6] = sparseGradientArr[i6].getValue();
        }
        double[] dArr2 = new double[sparseGradientArr2.length];
        for (int i7 = 0; i7 < sparseGradientArr2.length; i7++) {
            dArr2[i7] = sparseGradientArr2[i7].getValue();
        }
        zero.value = MathArrays.linearCombination(dArr, dArr2);
        return zero;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient subtract(double d) {
        return new SparseGradient(this.value - d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient divide(double d) {
        return new SparseGradient(this.value / d, 1.0d / d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient multiply(double d) {
        return new SparseGradient(this.value * d, d, this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient multiply(int i5) {
        double d = i5;
        return new SparseGradient(this.value * d, d, this.derivatives);
    }

    public static SparseGradient hypot(SparseGradient sparseGradient, SparseGradient sparseGradient2) {
        return sparseGradient.hypot(sparseGradient2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(double[] dArr, SparseGradient[] sparseGradientArr) {
        SparseGradient zero = sparseGradientArr[0].getField().getZero();
        for (int i5 = 0; i5 < dArr.length; i5++) {
            zero = zero.add(sparseGradientArr[i5].multiply(dArr[i5]));
        }
        double[] dArr2 = new double[sparseGradientArr.length];
        for (int i6 = 0; i6 < sparseGradientArr.length; i6++) {
            dArr2[i6] = sparseGradientArr[i6].getValue();
        }
        zero.value = MathArrays.linearCombination(dArr, dArr2);
        return zero;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(SparseGradient sparseGradient, SparseGradient sparseGradient2, SparseGradient sparseGradient3, SparseGradient sparseGradient4) {
        SparseGradient sparseGradientAdd = sparseGradient.multiply(sparseGradient2).add(sparseGradient3.multiply(sparseGradient4));
        sparseGradientAdd.value = MathArrays.linearCombination(sparseGradient.value, sparseGradient2.value, sparseGradient3.value, sparseGradient4.value);
        return sparseGradientAdd;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(double d, SparseGradient sparseGradient, double d6, SparseGradient sparseGradient2) {
        SparseGradient sparseGradientAdd = sparseGradient.multiply(d).add(sparseGradient2.multiply(d6));
        sparseGradientAdd.value = MathArrays.linearCombination(d, sparseGradient.value, d6, sparseGradient2.value);
        return sparseGradientAdd;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(SparseGradient sparseGradient, SparseGradient sparseGradient2, SparseGradient sparseGradient3, SparseGradient sparseGradient4, SparseGradient sparseGradient5, SparseGradient sparseGradient6) {
        SparseGradient sparseGradientAdd = sparseGradient.multiply(sparseGradient2).add(sparseGradient3.multiply(sparseGradient4)).add(sparseGradient5.multiply(sparseGradient6));
        sparseGradientAdd.value = MathArrays.linearCombination(sparseGradient.value, sparseGradient2.value, sparseGradient3.value, sparseGradient4.value, sparseGradient5.value, sparseGradient6.value);
        return sparseGradientAdd;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(double d, SparseGradient sparseGradient, double d6, SparseGradient sparseGradient2, double d7, SparseGradient sparseGradient3) {
        SparseGradient sparseGradientAdd = sparseGradient.multiply(d).add(sparseGradient2.multiply(d6)).add(sparseGradient3.multiply(d7));
        sparseGradientAdd.value = MathArrays.linearCombination(d, sparseGradient.value, d6, sparseGradient2.value, d7, sparseGradient3.value);
        return sparseGradientAdd;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(SparseGradient sparseGradient, SparseGradient sparseGradient2, SparseGradient sparseGradient3, SparseGradient sparseGradient4, SparseGradient sparseGradient5, SparseGradient sparseGradient6, SparseGradient sparseGradient7, SparseGradient sparseGradient8) {
        SparseGradient sparseGradientAdd = sparseGradient.multiply(sparseGradient2).add(sparseGradient3.multiply(sparseGradient4)).add(sparseGradient5.multiply(sparseGradient6)).add(sparseGradient7.multiply(sparseGradient8));
        sparseGradientAdd.value = MathArrays.linearCombination(sparseGradient.value, sparseGradient2.value, sparseGradient3.value, sparseGradient4.value, sparseGradient5.value, sparseGradient6.value, sparseGradient7.value, sparseGradient8.value);
        return sparseGradientAdd;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public SparseGradient linearCombination(double d, SparseGradient sparseGradient, double d6, SparseGradient sparseGradient2, double d7, SparseGradient sparseGradient3, double d8, SparseGradient sparseGradient4) {
        SparseGradient sparseGradientAdd = sparseGradient.multiply(d).add(sparseGradient2.multiply(d6)).add(sparseGradient3.multiply(d7)).add(sparseGradient4.multiply(d8));
        sparseGradientAdd.value = MathArrays.linearCombination(d, sparseGradient.value, d6, sparseGradient2.value, d7, sparseGradient3.value, d8, sparseGradient4.value);
        return sparseGradientAdd;
    }
}
