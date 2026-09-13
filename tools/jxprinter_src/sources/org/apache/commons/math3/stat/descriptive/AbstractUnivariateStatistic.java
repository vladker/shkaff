package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractUnivariateStatistic implements UnivariateStatistic {
    private double[] storedData;

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract UnivariateStatistic copy();

    public double evaluate() {
        return evaluate(this.storedData);
    }

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public abstract double evaluate(double[] dArr, int i5, int i6);

    public double[] getData() {
        double[] dArr = this.storedData;
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public double[] getDataRef() {
        return this.storedData;
    }

    public void setData(double[] dArr) {
        this.storedData = dArr == null ? null : (double[]) dArr.clone();
    }

    public boolean test(double[] dArr, int i5, int i6) {
        return MathArrays.verifyValues(dArr, i5, i6, false);
    }

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr) {
        test(dArr, 0, 0);
        return evaluate(dArr, 0, dArr.length);
    }

    public void setData(double[] dArr, int i5, int i6) {
        if (dArr == null) {
            throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
        }
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(i5));
        }
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(i6));
        }
        int i7 = i5 + i6;
        if (i7 > dArr.length) {
            throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(i7), Integer.valueOf(dArr.length), true);
        }
        double[] dArr2 = new double[i6];
        this.storedData = dArr2;
        System.arraycopy(dArr, i5, dArr2, 0, i6);
    }

    public boolean test(double[] dArr, int i5, int i6, boolean z6) {
        return MathArrays.verifyValues(dArr, i5, i6, z6);
    }

    public boolean test(double[] dArr, double[] dArr2, int i5, int i6) {
        return MathArrays.verifyValues(dArr, dArr2, i5, i6, false);
    }

    public boolean test(double[] dArr, double[] dArr2, int i5, int i6, boolean z6) {
        return MathArrays.verifyValues(dArr, dArr2, i5, i6, z6);
    }
}
