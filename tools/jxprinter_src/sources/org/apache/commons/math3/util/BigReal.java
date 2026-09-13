package org.apache.commons.math3.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BigReal implements FieldElement<BigReal>, Comparable<BigReal>, Serializable {
    private static final long serialVersionUID = 4984534880991310382L;
    private final BigDecimal d;
    private RoundingMode roundingMode = RoundingMode.HALF_UP;
    private int scale = 64;
    public static final BigReal ZERO = new BigReal(BigDecimal.ZERO);
    public static final BigReal ONE = new BigReal(BigDecimal.ONE);

    public BigReal(BigDecimal bigDecimal) {
        this.d = bigDecimal;
    }

    public BigDecimal bigDecimalValue() {
        return this.d;
    }

    public double doubleValue() {
        return this.d.doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BigReal) {
            return this.d.equals(((BigReal) obj).d);
        }
        return false;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<BigReal> getField() {
        return BigRealField.getInstance();
    }

    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    public int getScale() {
        return this.scale;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }

    public void setScale(int i5) {
        this.scale = i5;
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal add(BigReal bigReal) {
        return new BigReal(this.d.add(bigReal.d));
    }

    @Override // java.lang.Comparable
    public int compareTo(BigReal bigReal) {
        return this.d.compareTo(bigReal.d);
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal divide(BigReal bigReal) {
        try {
            return new BigReal(this.d.divide(bigReal.d, this.scale, this.roundingMode));
        } catch (ArithmeticException unused) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NOT_ALLOWED, new Object[0]);
        }
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal negate() {
        return new BigReal(this.d.negate());
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal reciprocal() {
        try {
            return new BigReal(BigDecimal.ONE.divide(this.d, this.scale, this.roundingMode));
        } catch (ArithmeticException unused) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NOT_ALLOWED, new Object[0]);
        }
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal subtract(BigReal bigReal) {
        return new BigReal(this.d.subtract(bigReal.d));
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal multiply(BigReal bigReal) {
        return new BigReal(this.d.multiply(bigReal.d));
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigReal multiply(int i5) {
        return new BigReal(this.d.multiply(new BigDecimal(i5)));
    }

    public BigReal(BigInteger bigInteger) {
        this.d = new BigDecimal(bigInteger);
    }

    public BigReal(BigInteger bigInteger, int i5) {
        this.d = new BigDecimal(bigInteger, i5);
    }

    public BigReal(BigInteger bigInteger, int i5, MathContext mathContext) {
        this.d = new BigDecimal(bigInteger, i5, mathContext);
    }

    public BigReal(BigInteger bigInteger, MathContext mathContext) {
        this.d = new BigDecimal(bigInteger, mathContext);
    }

    public BigReal(char[] cArr) {
        this.d = new BigDecimal(cArr);
    }

    public BigReal(char[] cArr, int i5, int i6) {
        this.d = new BigDecimal(cArr, i5, i6);
    }

    public BigReal(char[] cArr, int i5, int i6, MathContext mathContext) {
        this.d = new BigDecimal(cArr, i5, i6, mathContext);
    }

    public BigReal(char[] cArr, MathContext mathContext) {
        this.d = new BigDecimal(cArr, mathContext);
    }

    public BigReal(double d) {
        this.d = new BigDecimal(d);
    }

    public BigReal(double d, MathContext mathContext) {
        this.d = new BigDecimal(d, mathContext);
    }

    public BigReal(int i5) {
        this.d = new BigDecimal(i5);
    }

    public BigReal(int i5, MathContext mathContext) {
        this.d = new BigDecimal(i5, mathContext);
    }

    public BigReal(long j6) {
        this.d = new BigDecimal(j6);
    }

    public BigReal(long j6, MathContext mathContext) {
        this.d = new BigDecimal(j6, mathContext);
    }

    public BigReal(String str) {
        this.d = new BigDecimal(str);
    }

    public BigReal(String str, MathContext mathContext) {
        this.d = new BigDecimal(str, mathContext);
    }
}
