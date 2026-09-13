package org.apache.poi.ss.formula.functions;

import java.util.Arrays;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Mirr extends MultiOperandNumericFunction {
    public Mirr() {
        super(false, false);
    }

    private static double mirr(double[] dArr, double d, double d6) {
        double d7;
        double[] dArr2 = dArr;
        double d8 = 1.0d;
        double length = ((double) dArr2.length) - 1.0d;
        int length2 = dArr2.length;
        double d9 = 0.0d;
        int i5 = 0;
        double dPow = 0.0d;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length2) {
            double d10 = dArr2[i6];
            if (d10 < d9) {
                dPow += d10 / Math.pow((d + d8) + d6, i7);
                i7++;
            }
            i6++;
            d8 = d8;
            d9 = d9;
        }
        double d11 = d8;
        double d12 = d9;
        int length3 = dArr2.length;
        double dPow2 = d12;
        while (i5 < length3) {
            double d13 = dArr2[i5];
            if (d13 > d12) {
                d7 = length;
                dPow2 += Math.pow(d + d11, d7 - ((double) i7)) * d13;
                i7++;
            } else {
                d7 = length;
            }
            i5++;
            dArr2 = dArr;
            length = d7;
        }
        return (dPow2 == d12 || dPow == d12) ? d12 : Math.pow((-dPow2) / dPow, d11 / length) - d11;
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    public double evaluate(double[] dArr) throws EvaluationException {
        double d = dArr[dArr.length - 1];
        double d6 = dArr[dArr.length - 2];
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length - 2);
        boolean z6 = true;
        for (double d7 : dArrCopyOf) {
            z6 &= d7 < 0.0d;
        }
        if (z6) {
            return -1.0d;
        }
        boolean z7 = true;
        for (double d8 : dArrCopyOf) {
            z7 &= d8 > 0.0d;
        }
        if (z7) {
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
        return mirr(dArrCopyOf, d, d6);
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    public int getMaxNumOperands() {
        return 3;
    }
}
