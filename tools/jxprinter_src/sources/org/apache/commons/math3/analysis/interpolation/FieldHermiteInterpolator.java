package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldHermiteInterpolator<T extends FieldElement<T>> {
    private final List<T> abscissae = new ArrayList();
    private final List<T[]> topDiagonal = new ArrayList();
    private final List<T[]> bottomDiagonal = new ArrayList();

    public void addSamplePoint(T t6, T[]... tArr) {
        MathUtils.checkNotNull(t6);
        FieldElement fieldElement = (FieldElement) t6.getField().getOne();
        for (int i5 = 0; i5 < tArr.length; i5++) {
            FieldElement[] fieldElementArr = (FieldElement[]) tArr[i5].clone();
            if (i5 > 1) {
                fieldElement = (FieldElement) fieldElement.multiply(i5);
                FieldElement fieldElement2 = (FieldElement) fieldElement.reciprocal();
                for (int i6 = 0; i6 < fieldElementArr.length; i6++) {
                    fieldElementArr[i6] = (FieldElement) fieldElementArr[i6].multiply(fieldElement2);
                }
            }
            int size = this.abscissae.size();
            this.bottomDiagonal.add(size - i5, (T[]) fieldElementArr);
            int i7 = i5;
            FieldElement[] fieldElementArr2 = fieldElementArr;
            while (i7 < size) {
                i7++;
                int i8 = size - i7;
                T[] tArr2 = this.bottomDiagonal.get(i8);
                if (t6.equals(this.abscissae.get(i8))) {
                    throw new ZeroException(LocalizedFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, t6);
                }
                FieldElement fieldElement3 = (FieldElement) ((FieldElement) t6.subtract(this.abscissae.get(i8))).reciprocal();
                for (int i9 = 0; i9 < fieldElementArr.length; i9++) {
                    tArr2[i9] = (FieldElement) fieldElement3.multiply(fieldElementArr2[i9].subtract(tArr2[i9]));
                }
                fieldElementArr2 = tArr2;
            }
            this.topDiagonal.add((T[]) fieldElementArr2.clone());
            this.abscissae.add(t6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] derivatives(T t6, int i5) {
        MathUtils.checkNotNull(t6);
        if (this.abscissae.isEmpty()) {
            throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
        }
        FieldElement fieldElement = (FieldElement) t6.getField().getZero();
        FieldElement fieldElement2 = (FieldElement) t6.getField().getOne();
        int i6 = i5 + 1;
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(t6.getField(), i6);
        fieldElementArr[0] = fieldElement;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            fieldElementArr[i8] = (FieldElement) fieldElementArr[i7].add(fieldElement2);
            i7 = i8;
        }
        T[][] tArr = (T[][]) ((FieldElement[][]) MathArrays.buildArray(t6.getField(), i6, this.topDiagonal.get(0).length));
        FieldElement[] fieldElementArr2 = (FieldElement[]) MathArrays.buildArray(t6.getField(), i6);
        fieldElementArr2[0] = (FieldElement) t6.getField().getOne();
        for (int i9 = 0; i9 < this.topDiagonal.size(); i9++) {
            T[] tArr2 = this.topDiagonal.get(i9);
            FieldElement fieldElement3 = (FieldElement) t6.subtract(this.abscissae.get(i9));
            for (int i10 = i5; i10 >= 0; i10--) {
                int i11 = 0;
                while (true) {
                    FieldElement[] fieldElementArr3 = tArr[i10];
                    if (i11 >= fieldElementArr3.length) {
                        break;
                    }
                    fieldElementArr3[i11] = (FieldElement) fieldElementArr3[i11].add(tArr2[i11].multiply(fieldElementArr2[i10]));
                    i11++;
                }
                FieldElement fieldElement4 = (FieldElement) fieldElementArr2[i10].multiply(fieldElement3);
                fieldElementArr2[i10] = fieldElement4;
                if (i10 > 0) {
                    fieldElementArr2[i10] = (FieldElement) fieldElement4.add(fieldElementArr[i10].multiply(fieldElementArr2[i10 - 1]));
                }
            }
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] value(T t6) {
        MathUtils.checkNotNull(t6);
        if (this.abscissae.isEmpty()) {
            throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
        }
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(t6.getField(), this.topDiagonal.get(0).length));
        FieldElement fieldElement = (FieldElement) t6.getField().getOne();
        for (int i5 = 0; i5 < this.topDiagonal.size(); i5++) {
            T[] tArr2 = this.topDiagonal.get(i5);
            for (int i6 = 0; i6 < tArr.length; i6++) {
                tArr[i6] = (FieldElement) tArr[i6].add(tArr2[i6].multiply(fieldElement));
            }
            fieldElement = (FieldElement) fieldElement.multiply((FieldElement) t6.subtract(this.abscissae.get(i5)));
        }
        return tArr;
    }
}
