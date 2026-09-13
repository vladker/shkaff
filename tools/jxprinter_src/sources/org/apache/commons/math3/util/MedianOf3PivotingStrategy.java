package org.apache.commons.math3.util;

import A3.AbstractC0157z;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MedianOf3PivotingStrategy implements PivotingStrategyInterface, Serializable {
    private static final long serialVersionUID = 20140713;

    /* JADX WARN: Code duplicated, block: B:15:0x0029 A[RETURN] */
    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    public int pivotIndex(double[] dArr, int i5, int i6) {
        MathArrays.verifyValues(dArr, i5, i6 - i5);
        int i7 = i6 - 1;
        int iB = AbstractC0157z.b(i7, i5, 2, i5);
        double d = dArr[i5];
        double d6 = dArr[iB];
        double d7 = dArr[i7];
        if (d < d6) {
            if (d6 >= d7) {
                if (d < d7) {
                    return i7;
                }
                return i5;
            }
            return iB;
        }
        if (d >= d7) {
            if (d6 < d7) {
                return i7;
            }
            return iB;
        }
        return i5;
    }
}
