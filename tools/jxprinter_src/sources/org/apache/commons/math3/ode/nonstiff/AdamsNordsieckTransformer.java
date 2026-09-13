package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.FieldDecompositionSolver;
import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdamsNordsieckTransformer {
    private static final Map<Integer, AdamsNordsieckTransformer> CACHE = new HashMap();

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private final double[] f6834c1;
    private final Array2DRowRealMatrix update;

    private AdamsNordsieckTransformer(int i5) {
        int i6 = i5 - 1;
        FieldMatrix<BigFraction> fieldMatrixBuildP = buildP(i6);
        FieldDecompositionSolver solver = new FieldLUDecomposition(fieldMatrixBuildP).getSolver();
        BigFraction[] bigFractionArr = new BigFraction[i6];
        Arrays.fill(bigFractionArr, BigFraction.ONE);
        BigFraction[] bigFractionArr2 = (BigFraction[]) solver.solve(new ArrayFieldVector((FieldElement[]) bigFractionArr, false)).toArray();
        BigFraction[][] bigFractionArr3 = (BigFraction[][]) fieldMatrixBuildP.getData();
        for (int length = bigFractionArr3.length - 1; length > 0; length--) {
            bigFractionArr3[length] = bigFractionArr3[length - 1];
        }
        BigFraction[] bigFractionArr4 = new BigFraction[i6];
        bigFractionArr3[0] = bigFractionArr4;
        Arrays.fill(bigFractionArr4, BigFraction.ZERO);
        this.update = MatrixUtils.bigFractionMatrixToRealMatrix(solver.solve(new Array2DRowFieldMatrix((FieldElement[][]) bigFractionArr3, false)));
        this.f6834c1 = new double[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            this.f6834c1[i7] = bigFractionArr2[i7].doubleValue();
        }
    }

    private FieldMatrix<BigFraction> buildP(int i5) {
        BigFraction[][] bigFractionArr = (BigFraction[][]) Array.newInstance((Class<?>) BigFraction.class, i5, i5);
        for (int i6 = 1; i6 <= bigFractionArr.length; i6++) {
            BigFraction[] bigFractionArr2 = bigFractionArr[i6 - 1];
            int i7 = -i6;
            int i8 = 1;
            int i9 = i7;
            while (i8 <= bigFractionArr2.length) {
                int i10 = i8 - 1;
                i8++;
                bigFractionArr2[i10] = new BigFraction(i9 * i8);
                i9 *= i7;
            }
        }
        return new Array2DRowFieldMatrix((FieldElement[][]) bigFractionArr, false);
    }

    public static AdamsNordsieckTransformer getInstance(int i5) {
        AdamsNordsieckTransformer adamsNordsieckTransformer;
        Map<Integer, AdamsNordsieckTransformer> map = CACHE;
        synchronized (map) {
            try {
                adamsNordsieckTransformer = map.get(Integer.valueOf(i5));
                if (adamsNordsieckTransformer == null) {
                    adamsNordsieckTransformer = new AdamsNordsieckTransformer(i5);
                    map.put(Integer.valueOf(i5), adamsNordsieckTransformer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return adamsNordsieckTransformer;
    }

    @Deprecated
    public int getNSteps() {
        return this.f6834c1.length;
    }

    public Array2DRowRealMatrix initializeHighOrderDerivatives(double d, double[] dArr, double[][] dArr2, double[][] dArr3) {
        int i5;
        double[][] dArr4 = dArr2;
        double[] dArr5 = this.f6834c1;
        boolean z6 = true;
        int[] iArr = {dArr5.length + 1, dArr5.length + 1};
        char c = 0;
        Class cls = Double.TYPE;
        double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) cls, this.f6834c1.length + 1, dArr4[0].length);
        double[] dArr8 = dArr4[0];
        double[] dArr9 = dArr3[0];
        int i6 = 1;
        while (i6 < dArr4.length) {
            double d6 = dArr[i6] - dArr[c];
            double d7 = d6 / d;
            double d8 = 1.0d / d;
            int i7 = i6 * 2;
            int i8 = i7 - 2;
            boolean z7 = z6;
            double[] dArr10 = dArr6[i8];
            int i9 = i7 - 1;
            double[] dArr11 = i9 < dArr6.length ? dArr6[i9] : null;
            int i10 = 0;
            while (i10 < dArr10.length) {
                d8 *= d7;
                dArr10[i10] = d6 * d8;
                if (dArr11 != null) {
                    i5 = i10;
                    dArr11[i5] = ((double) (i10 + 2)) * d8;
                } else {
                    i5 = i10;
                }
                i10 = i5 + 1;
            }
            double[] dArr12 = dArr2[i6];
            double[] dArr13 = dArr3[i6];
            double[] dArr14 = dArr7[i8];
            double[] dArr15 = i9 < dArr7.length ? dArr7[i9] : null;
            for (int i11 = 0; i11 < dArr12.length; i11++) {
                dArr14[i11] = (dArr12[i11] - dArr8[i11]) - (dArr9[i11] * d6);
                if (dArr15 != null) {
                    dArr15[i11] = dArr13[i11] - dArr9[i11];
                }
            }
            i6++;
            dArr4 = dArr2;
            z6 = z7;
            c = 0;
        }
        RealMatrix realMatrixSolve = new QRDecomposition(new Array2DRowRealMatrix(dArr6, false)).getSolver().solve(new Array2DRowRealMatrix(dArr7, false));
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(realMatrixSolve.getRowDimension() - 1, realMatrixSolve.getColumnDimension());
        for (int i12 = 0; i12 < array2DRowRealMatrix.getRowDimension(); i12++) {
            for (int i13 = 0; i13 < array2DRowRealMatrix.getColumnDimension(); i13++) {
                array2DRowRealMatrix.setEntry(i12, i13, realMatrixSolve.getEntry(i12, i13));
            }
        }
        return array2DRowRealMatrix;
    }

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(Array2DRowRealMatrix array2DRowRealMatrix) {
        return this.update.multiply(array2DRowRealMatrix);
    }

    public void updateHighOrderDerivativesPhase2(double[] dArr, double[] dArr2, Array2DRowRealMatrix array2DRowRealMatrix) {
        double[][] dataRef = array2DRowRealMatrix.getDataRef();
        for (int i5 = 0; i5 < dataRef.length; i5++) {
            double[] dArr3 = dataRef[i5];
            double d = this.f6834c1[i5];
            for (int i6 = 0; i6 < dArr3.length; i6++) {
                dArr3[i6] = a.a(dArr[i6], dArr2[i6], d, dArr3[i6]);
            }
        }
    }
}
