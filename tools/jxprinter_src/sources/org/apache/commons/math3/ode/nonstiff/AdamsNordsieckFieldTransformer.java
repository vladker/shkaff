package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.FieldDecompositionSolver;
import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdamsNordsieckFieldTransformer<T extends RealFieldElement<T>> {
    private static final Map<Integer, Map<Field<? extends RealFieldElement<?>>, AdamsNordsieckFieldTransformer<? extends RealFieldElement<?>>>> CACHE = new HashMap();

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private final T[] f6833c1;
    private final Field<T> field;
    private final Array2DRowFieldMatrix<T> update;

    private AdamsNordsieckFieldTransformer(Field<T> field, int i5) {
        this.field = field;
        int i6 = i5 - 1;
        FieldMatrix<T> fieldMatrixBuildP = buildP(i6);
        FieldDecompositionSolver solver = new FieldLUDecomposition(fieldMatrixBuildP).getSolver();
        RealFieldElement[] realFieldElementArr = (RealFieldElement[]) MathArrays.buildArray(field, i6);
        Arrays.fill(realFieldElementArr, field.getOne());
        this.f6833c1 = (T[]) ((RealFieldElement[]) solver.solve(new ArrayFieldVector((FieldElement[]) realFieldElementArr, false)).toArray());
        RealFieldElement[][] realFieldElementArr2 = (RealFieldElement[][]) fieldMatrixBuildP.getData();
        for (int length = realFieldElementArr2.length - 1; length > 0; length--) {
            realFieldElementArr2[length] = realFieldElementArr2[length - 1];
        }
        RealFieldElement[] realFieldElementArr3 = (RealFieldElement[]) MathArrays.buildArray(field, i6);
        realFieldElementArr2[0] = realFieldElementArr3;
        Arrays.fill(realFieldElementArr3, field.getZero());
        this.update = new Array2DRowFieldMatrix<>(solver.solve(new Array2DRowFieldMatrix((FieldElement[][]) realFieldElementArr2, false)).getData());
    }

    private FieldMatrix<T> buildP(int i5) {
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(this.field, i5, i5);
        for (int i6 = 1; i6 <= realFieldElementArr.length; i6++) {
            RealFieldElement[] realFieldElementArr2 = realFieldElementArr[i6 - 1];
            int i7 = -i6;
            RealFieldElement realFieldElement = (RealFieldElement) this.field.getZero().add(i7);
            int i8 = 1;
            while (i8 <= realFieldElementArr2.length) {
                int i9 = i8 - 1;
                i8++;
                realFieldElementArr2[i9] = (RealFieldElement) realFieldElement.multiply(i8);
                realFieldElement = (RealFieldElement) realFieldElement.multiply(i7);
            }
        }
        return new Array2DRowFieldMatrix((FieldElement[][]) realFieldElementArr, false);
    }

    public static <T extends RealFieldElement<T>> AdamsNordsieckFieldTransformer<T> getInstance(Field<T> field, int i5) {
        AdamsNordsieckFieldTransformer<T> adamsNordsieckFieldTransformer;
        Map<Integer, Map<Field<? extends RealFieldElement<?>>, AdamsNordsieckFieldTransformer<? extends RealFieldElement<?>>>> map = CACHE;
        synchronized (map) {
            try {
                Map map2 = map.get(Integer.valueOf(i5));
                if (map2 == null) {
                    map2 = new HashMap();
                    map.put(Integer.valueOf(i5), (Map<Field<? extends RealFieldElement<?>>, AdamsNordsieckFieldTransformer<? extends RealFieldElement<?>>>) map2);
                }
                adamsNordsieckFieldTransformer = (AdamsNordsieckFieldTransformer) map2.get(field);
                if (adamsNordsieckFieldTransformer == null) {
                    adamsNordsieckFieldTransformer = new AdamsNordsieckFieldTransformer<>(field, i5);
                    map2.put(field, adamsNordsieckFieldTransformer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return adamsNordsieckFieldTransformer;
    }

    public Array2DRowFieldMatrix<T> initializeHighOrderDerivatives(T t6, T[] tArr, T[][] tArr2, T[][] tArr3) {
        T[][] tArr4 = tArr2;
        Field<T> field = this.field;
        T[] tArr5 = this.f6833c1;
        int i5 = 1;
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(field, tArr5.length + 1, tArr5.length + 1);
        int i6 = 0;
        RealFieldElement[][] realFieldElementArr2 = (RealFieldElement[][]) MathArrays.buildArray(this.field, this.f6833c1.length + 1, tArr4[0].length);
        T[] tArr6 = tArr4[0];
        T[] tArr7 = tArr3[0];
        int i7 = 1;
        while (i7 < tArr4.length) {
            RealFieldElement realFieldElement = (RealFieldElement) tArr[i7].subtract(tArr[i6]);
            RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.divide(t6);
            RealFieldElement realFieldElement3 = (RealFieldElement) t6.reciprocal();
            int i8 = i7 * 2;
            int i9 = i8 - 2;
            RealFieldElement[] realFieldElementArr3 = realFieldElementArr[i9];
            int i10 = i8 - i5;
            int i11 = i5;
            RealFieldElement[] realFieldElementArr4 = i10 < realFieldElementArr.length ? realFieldElementArr[i10] : null;
            while (i6 < realFieldElementArr3.length) {
                realFieldElement3 = (RealFieldElement) realFieldElement3.multiply(realFieldElement2);
                realFieldElementArr3[i6] = (RealFieldElement) realFieldElement.multiply(realFieldElement3);
                if (realFieldElementArr4 != null) {
                    realFieldElementArr4[i6] = (RealFieldElement) realFieldElement3.multiply(i6 + 2);
                }
                i6++;
            }
            T[] tArr8 = tArr2[i7];
            T[] tArr9 = tArr3[i7];
            RealFieldElement[] realFieldElementArr5 = realFieldElementArr2[i9];
            RealFieldElement[] realFieldElementArr6 = i10 < realFieldElementArr2.length ? realFieldElementArr2[i10] : null;
            for (int i12 = 0; i12 < tArr8.length; i12++) {
                realFieldElementArr5[i12] = (RealFieldElement) ((RealFieldElement) tArr8[i12].subtract(tArr6[i12])).subtract(realFieldElement.multiply(tArr7[i12]));
                if (realFieldElementArr6 != null) {
                    realFieldElementArr6[i12] = (RealFieldElement) tArr9[i12].subtract(tArr7[i12]);
                }
            }
            i7++;
            tArr4 = tArr2;
            i5 = i11;
            i6 = 0;
        }
        FieldMatrix fieldMatrixSolve = new FieldLUDecomposition(new Array2DRowFieldMatrix((FieldElement[][]) realFieldElementArr, false)).getSolver().solve(new Array2DRowFieldMatrix((FieldElement[][]) realFieldElementArr2, false));
        Array2DRowFieldMatrix<T> array2DRowFieldMatrix = new Array2DRowFieldMatrix<>(this.field, fieldMatrixSolve.getRowDimension() - 1, fieldMatrixSolve.getColumnDimension());
        for (int i13 = 0; i13 < array2DRowFieldMatrix.getRowDimension(); i13++) {
            for (int i14 = 0; i14 < array2DRowFieldMatrix.getColumnDimension(); i14++) {
                array2DRowFieldMatrix.setEntry(i13, i14, fieldMatrixSolve.getEntry(i13, i14));
            }
        }
        return array2DRowFieldMatrix;
    }

    public Array2DRowFieldMatrix<T> updateHighOrderDerivativesPhase1(Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        return (Array2DRowFieldMatrix<T>) this.update.multiply((Array2DRowFieldMatrix) array2DRowFieldMatrix);
    }

    public void updateHighOrderDerivativesPhase2(T[] tArr, T[] tArr2, Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) array2DRowFieldMatrix.getDataRef();
        for (int i5 = 0; i5 < realFieldElementArr.length; i5++) {
            RealFieldElement[] realFieldElementArr2 = realFieldElementArr[i5];
            T t6 = this.f6833c1[i5];
            for (int i6 = 0; i6 < realFieldElementArr2.length; i6++) {
                realFieldElementArr2[i6] = (RealFieldElement) realFieldElementArr2[i6].add(t6.multiply(tArr[i6].subtract(tArr2[i6])));
            }
        }
    }
}
