package org.apache.commons.math3.ode;

import java.io.Serializable;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldEquationsMapper<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20151114;
    private final int[] start;

    public FieldEquationsMapper(FieldEquationsMapper<T> fieldEquationsMapper, int i5) {
        int numberOfEquations = fieldEquationsMapper == null ? 0 : fieldEquationsMapper.getNumberOfEquations();
        int[] iArr = new int[numberOfEquations + 2];
        this.start = iArr;
        if (fieldEquationsMapper == null) {
            iArr[0] = 0;
        } else {
            System.arraycopy(fieldEquationsMapper.start, 0, iArr, 0, numberOfEquations + 1);
        }
        iArr[numberOfEquations + 1] = iArr[numberOfEquations] + i5;
    }

    private void checkIndex(int i5) {
        if (i5 < 0 || i5 > this.start.length - 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.ARGUMENT_OUTSIDE_DOMAIN, Integer.valueOf(i5), 0, Integer.valueOf(this.start.length - 2));
        }
    }

    public T[] extractEquationData(int i5, T[] tArr) {
        checkIndex(i5);
        int[] iArr = this.start;
        int i6 = iArr[i5];
        int i7 = iArr[i5 + 1];
        if (tArr.length < i7) {
            throw new DimensionMismatchException(tArr.length, i7);
        }
        int i8 = i7 - i6;
        T[] tArr2 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(tArr[0].getField(), i8));
        System.arraycopy(tArr, i6, tArr2, 0, i8);
        return tArr2;
    }

    public int getNumberOfEquations() {
        return this.start.length - 1;
    }

    public int getTotalDimension() {
        int[] iArr = this.start;
        return iArr[iArr.length - 1];
    }

    public void insertEquationData(int i5, T[] tArr, T[] tArr2) {
        checkIndex(i5);
        int[] iArr = this.start;
        int i6 = iArr[i5];
        int i7 = iArr[i5 + 1];
        int i8 = i7 - i6;
        if (tArr2.length < i7) {
            throw new DimensionMismatchException(tArr2.length, i7);
        }
        if (tArr.length != i8) {
            throw new DimensionMismatchException(tArr.length, i8);
        }
        System.arraycopy(tArr, 0, tArr2, i6, i8);
    }

    public T[] mapDerivative(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative) {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(fieldODEStateAndDerivative.getTime().getField(), getTotalDimension()));
        int i5 = 0;
        insertEquationData(0, fieldODEStateAndDerivative.getDerivative(), tArr);
        while (true) {
            i5++;
            if (i5 >= getNumberOfEquations()) {
                return tArr;
            }
            insertEquationData(i5, fieldODEStateAndDerivative.getSecondaryDerivative(i5), tArr);
        }
    }

    public T[] mapState(FieldODEState<T> fieldODEState) {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(fieldODEState.getTime().getField(), getTotalDimension()));
        int i5 = 0;
        insertEquationData(0, fieldODEState.getState(), tArr);
        while (true) {
            i5++;
            if (i5 >= getNumberOfEquations()) {
                return tArr;
            }
            insertEquationData(i5, fieldODEState.getSecondaryState(i5), tArr);
        }
    }

    public FieldODEStateAndDerivative<T> mapStateAndDerivative(T t6, T[] tArr, T[] tArr2) {
        if (tArr.length != getTotalDimension()) {
            throw new DimensionMismatchException(tArr.length, getTotalDimension());
        }
        if (tArr2.length != getTotalDimension()) {
            throw new DimensionMismatchException(tArr2.length, getTotalDimension());
        }
        int numberOfEquations = getNumberOfEquations();
        int i5 = 0;
        RealFieldElement[] realFieldElementArrExtractEquationData = extractEquationData(0, tArr);
        RealFieldElement[] realFieldElementArrExtractEquationData2 = extractEquationData(0, tArr2);
        if (numberOfEquations < 2) {
            return new FieldODEStateAndDerivative<>(t6, realFieldElementArrExtractEquationData, realFieldElementArrExtractEquationData2);
        }
        int i6 = numberOfEquations - 1;
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(t6.getField(), i6, -1);
        RealFieldElement[][] realFieldElementArr2 = (RealFieldElement[][]) MathArrays.buildArray(t6.getField(), i6, -1);
        while (true) {
            int i7 = i5 + 1;
            if (i7 >= getNumberOfEquations()) {
                return new FieldODEStateAndDerivative<>(t6, realFieldElementArrExtractEquationData, realFieldElementArrExtractEquationData2, realFieldElementArr, realFieldElementArr2);
            }
            realFieldElementArr[i5] = extractEquationData(i7, tArr);
            realFieldElementArr2[i5] = extractEquationData(i7, tArr2);
            i5 = i7;
        }
    }
}
