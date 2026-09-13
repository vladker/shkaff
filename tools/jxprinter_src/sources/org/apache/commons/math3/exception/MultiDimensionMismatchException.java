package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiDimensionMismatchException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final Integer[] expected;
    private final Integer[] wrong;

    public MultiDimensionMismatchException(Integer[] numArr, Integer[] numArr2) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH, numArr, numArr2);
    }

    public int getExpectedDimension(int i5) {
        return this.expected[i5].intValue();
    }

    public Integer[] getExpectedDimensions() {
        return (Integer[]) this.expected.clone();
    }

    public int getWrongDimension(int i5) {
        return this.wrong[i5].intValue();
    }

    public Integer[] getWrongDimensions() {
        return (Integer[]) this.wrong.clone();
    }

    public MultiDimensionMismatchException(Localizable localizable, Integer[] numArr, Integer[] numArr2) {
        super(localizable, numArr, numArr2);
        this.wrong = (Integer[]) numArr.clone();
        this.expected = (Integer[]) numArr2.clone();
    }
}
