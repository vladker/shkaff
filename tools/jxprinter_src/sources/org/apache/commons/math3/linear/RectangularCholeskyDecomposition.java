package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RectangularCholeskyDecomposition {
    private int rank;
    private final RealMatrix root;

    public RectangularCholeskyDecomposition(RealMatrix realMatrix) {
        this(realMatrix, 0.0d);
    }

    public int getRank() {
        return this.rank;
    }

    public RealMatrix getRootMatrix() {
        return this.root;
    }

    public RectangularCholeskyDecomposition(RealMatrix realMatrix, double d) {
        int[] iArr;
        int rowDimension = realMatrix.getRowDimension();
        double[][] data = realMatrix.getData();
        boolean z6 = true;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, rowDimension);
        int[] iArr2 = new int[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            iArr2[i5] = i5;
        }
        boolean z7 = true;
        int i6 = 0;
        while (z7) {
            int i7 = i6 + 1;
            int i8 = i6;
            for (int i9 = i7; i9 < rowDimension; i9++) {
                int i10 = iArr2[i9];
                int i11 = iArr2[i8];
                if (data[i10][i10] > data[i11][i11]) {
                    i8 = i9;
                }
            }
            if (i8 != i6) {
                int i12 = iArr2[i6];
                iArr2[i6] = iArr2[i8];
                iArr2[i8] = i12;
                double[] dArr2 = dArr[i6];
                dArr[i6] = dArr[i8];
                dArr[i8] = dArr2;
            }
            boolean z8 = z6;
            int i13 = iArr2[i6];
            double d6 = data[i13][i13];
            if (d6 > d) {
                iArr = iArr2;
                double dSqrt = FastMath.sqrt(d6);
                dArr[i6][i6] = dSqrt;
                double d7 = 1.0d / dSqrt;
                double d8 = 1.0d / data[i13][i13];
                for (int i14 = i7; i14 < rowDimension; i14++) {
                    int i15 = iArr[i14];
                    double[] dArr3 = data[i15];
                    double d9 = dArr3[i13] * d7;
                    dArr[i14][i6] = d9;
                    double d10 = dArr3[i15];
                    double d11 = dArr3[i13];
                    dArr3[i15] = d10 - ((d11 * d11) * d8);
                    for (int i16 = i7; i16 < i14; i16++) {
                        int i17 = iArr[i16];
                        double[] dArr4 = data[i15];
                        double d12 = dArr4[i17] - (dArr[i16][i6] * d9);
                        dArr4[i17] = d12;
                        data[i17][i15] = d12;
                    }
                }
                i6 = i7;
                z7 = i7 < rowDimension ? z8 : false;
            } else {
                if (i6 == 0) {
                    throw new NonPositiveDefiniteMatrixException(data[i13][i13], i13, d);
                }
                int i18 = i6;
                while (i18 < rowDimension) {
                    int i19 = iArr2[i18];
                    int[] iArr3 = iArr2;
                    if (data[i19][i19] < (-d)) {
                        int i20 = iArr3[i18];
                        throw new NonPositiveDefiniteMatrixException(data[i20][i20], i18, d);
                    }
                    i18++;
                    iArr2 = iArr3;
                }
                iArr = iArr2;
                z7 = false;
            }
            z6 = z8;
            iArr2 = iArr;
        }
        int[] iArr4 = iArr2;
        this.rank = i6;
        this.root = MatrixUtils.createRealMatrix(rowDimension, i6);
        for (int i21 = 0; i21 < rowDimension; i21++) {
            for (int i22 = 0; i22 < i6; i22++) {
                this.root.setEntry(iArr4[i21], i22, dArr[i21][i22]);
            }
        }
    }
}
