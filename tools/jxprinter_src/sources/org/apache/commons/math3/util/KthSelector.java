package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KthSelector implements Serializable {
    private static final int MIN_SELECT_SIZE = 15;
    private static final long serialVersionUID = 20140713;
    private final PivotingStrategyInterface pivotingStrategy;

    public KthSelector() {
        this.pivotingStrategy = new MedianOf3PivotingStrategy();
    }

    private int partition(double[] dArr, int i5, int i6, int i7) {
        double d = dArr[i7];
        dArr[i7] = dArr[i5];
        int i8 = i5 + 1;
        int i9 = i6 - 1;
        while (i8 < i9) {
            while (i8 < i9 && dArr[i9] > d) {
                i9--;
            }
            while (i8 < i9 && dArr[i8] < d) {
                i8++;
            }
            if (i8 < i9) {
                double d6 = dArr[i8];
                dArr[i8] = dArr[i9];
                dArr[i9] = d6;
                i9--;
                i8++;
            }
        }
        if (i8 >= i6 || dArr[i8] > d) {
            i8--;
        }
        dArr[i5] = dArr[i8];
        dArr[i8] = d;
        return i8;
    }

    public PivotingStrategyInterface getPivotingStrategy() {
        return this.pivotingStrategy;
    }

    public double select(double[] dArr, int[] iArr, int i5) {
        int iPartition;
        int length = dArr.length;
        int i6 = 0;
        boolean z6 = iArr != null;
        int iMin = 0;
        while (length - i6 > 15) {
            if (!z6 || iMin >= iArr.length || (iPartition = iArr[iMin]) < 0) {
                iPartition = partition(dArr, i6, length, this.pivotingStrategy.pivotIndex(dArr, i6, length));
                if (z6 && iMin < iArr.length) {
                    iArr[iMin] = iPartition;
                }
            }
            if (i5 == iPartition) {
                return dArr[i5];
            }
            if (i5 < iPartition) {
                iMin = FastMath.min((iMin * 2) + 1, z6 ? iArr.length : iPartition);
                length = iPartition;
            } else {
                int i7 = iPartition + 1;
                iMin = FastMath.min((iMin * 2) + 2, z6 ? iArr.length : length);
                i6 = i7;
            }
        }
        Arrays.sort(dArr, i6, length);
        return dArr[i5];
    }

    public KthSelector(PivotingStrategyInterface pivotingStrategyInterface) {
        MathUtils.checkNotNull(pivotingStrategyInterface);
        this.pivotingStrategy = pivotingStrategyInterface;
    }
}
