package org.apache.poi.ss.formula.functions;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Trend implements Function {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TrendResults {
        private final int resultHeight;
        private final int resultWidth;
        private final double[] vals;

        public TrendResults(double[] dArr, int i5, int i6) {
            this.vals = dArr;
            this.resultWidth = i5;
            this.resultHeight = i6;
        }
    }

    private static double[][] evalToArray(ValueEval valueEval) throws EvaluationException {
        boolean z6 = valueEval instanceof MissingArgEval;
        Class cls = Double.TYPE;
        if (z6) {
            return (double[][]) Array.newInstance((Class<?>) cls, 0, 0);
        }
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            if (refEval.getNumberOfSheets() > 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
        }
        if (valueEval == null) {
            throw new RuntimeException("Parameter may not be null.");
        }
        if (!(valueEval instanceof AreaEval)) {
            if (!(valueEval instanceof NumericValueEval)) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, 1, 1);
            dArr[0][0] = ((NumericValueEval) valueEval).getNumberValue();
            return dArr;
        }
        AreaEval areaEval = (AreaEval) valueEval;
        int width = areaEval.getWidth();
        int height = areaEval.getHeight();
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, height, width);
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                ValueEval relativeValue = areaEval.getRelativeValue(i5, i6);
                if (!(relativeValue instanceof NumericValueEval)) {
                    throw new EvaluationException(ErrorEval.VALUE_INVALID);
                }
                dArr2[i5][i6] = ((NumericValueEval) relativeValue).getNumberValue();
            }
        }
        return dArr2;
    }

    private static double[] flattenArray(double[][] dArr) {
        if (dArr.length < 1) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length * dArr[0].length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double[] dArr3 = dArr[i5];
            double[] dArr4 = dArr[0];
            System.arraycopy(dArr3, 0, dArr2, dArr4.length * i5, dArr4.length);
        }
        return dArr2;
    }

    private static double[][] flattenArrayToRow(double[][] dArr) {
        int length = dArr.length;
        Class cls = Double.TYPE;
        if (length < 1) {
            return (double[][]) Array.newInstance((Class<?>) cls, 0, 0);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, dArr.length * dArr[0].length, 1);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            int i6 = 0;
            while (true) {
                double[] dArr3 = dArr[0];
                if (i6 < dArr3.length) {
                    dArr2[(dArr3.length * i5) + i6][0] = dArr[i5][i6];
                    i6++;
                }
            }
        }
        return dArr2;
    }

    private static double[][] getDefaultArrayOneD(int i5) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, 1);
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6][0] = ((double) i6) + 1.0d;
        }
        return dArr;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x017e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0182  */
    /* JADX WARN: Code duplicated, block: B:109:0x0186 A[LOOP:1: B:107:0x0183->B:109:0x0186, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x0196  */
    /* JADX WARN: Code duplicated, block: B:113:0x019e A[LOOP:2: B:111:0x019b->B:113:0x019e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:121:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:123:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:127:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:22:0x0094  */
    /* JADX WARN: Code duplicated, block: B:24:0x009b  */
    /* JADX WARN: Code duplicated, block: B:25:0x009d  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f2 A[PHI: r3
  0x00f2: PHI (r3v11 double[][]) = (r3v8 double[][]), (r3v13 double[][]) binds: [B:67:0x0108, B:55:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0101  */
    /* JADX WARN: Code duplicated, block: B:66:0x0105  */
    /* JADX WARN: Code duplicated, block: B:67:0x0108  */
    /* JADX WARN: Code duplicated, block: B:70:0x010d  */
    /* JADX WARN: Code duplicated, block: B:75:0x011b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0120  */
    /* JADX WARN: Code duplicated, block: B:79:0x0122  */
    /* JADX WARN: Code duplicated, block: B:90:0x013e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0142  */
    /* JADX WARN: Code duplicated, block: B:94:0x014e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0166  */
    /* JADX WARN: Code duplicated, block: B:98:0x016d  */
    private static TrendResults getNewY(ValueEval[] valueEvalArr) throws EvaluationException {
        double[][] dArrEvalToArray;
        double[][] dArrEvalToArray2;
        double[][] dArrEvalToArray3;
        boolean z6;
        double[] dArrFlattenArray;
        double[][] dArr;
        double[][] dArrSwitchRowsColumns;
        double[][] defaultArrayOneD;
        double[][] dArrFlattenArrayToRow;
        int length;
        double[] dArr2;
        int length2;
        int length3;
        OLSMultipleLinearRegression oLSMultipleLinearRegression;
        double[] dArrEstimateRegressionParameters;
        double[] dArr3;
        int i5;
        int i6;
        int i7;
        int length4 = valueEvalArr.length;
        Class cls = Double.TYPE;
        if (length4 == 1) {
            dArrEvalToArray = evalToArray(valueEvalArr[0]);
            dArrEvalToArray2 = (double[][]) Array.newInstance((Class<?>) cls, 0, 0);
            dArrEvalToArray3 = (double[][]) Array.newInstance((Class<?>) cls, 0, 0);
        } else {
            if (length4 != 2) {
                if (length4 == 3) {
                    dArrEvalToArray = evalToArray(valueEvalArr[0]);
                    dArrEvalToArray2 = evalToArray(valueEvalArr[1]);
                    dArrEvalToArray3 = evalToArray(valueEvalArr[2]);
                } else {
                    if (length4 != 4) {
                        throw new EvaluationException(ErrorEval.VALUE_INVALID);
                    }
                    dArrEvalToArray = evalToArray(valueEvalArr[0]);
                    dArrEvalToArray2 = evalToArray(valueEvalArr[1]);
                    dArrEvalToArray3 = evalToArray(valueEvalArr[2]);
                    ValueEval valueEval = valueEvalArr[3];
                    if (!(valueEval instanceof BoolEval)) {
                        throw new EvaluationException(ErrorEval.VALUE_INVALID);
                    }
                    z6 = !((BoolEval) valueEval).getBooleanValue();
                }
                if (dArrEvalToArray.length >= 1) {
                    throw new EvaluationException(ErrorEval.VALUE_INVALID);
                }
                dArrFlattenArray = flattenArray(dArrEvalToArray);
                if (dArrEvalToArray3.length > 0) {
                    dArr = dArrEvalToArray3;
                } else {
                    dArr = (double[][]) Array.newInstance((Class<?>) cls, 1, 1);
                }
                if (dArrFlattenArray.length != 1) {
                    throw new NotImplementedException("Sample size too small");
                }
                if (dArrEvalToArray.length != 1 || dArrEvalToArray[0].length == 1) {
                    if (dArrEvalToArray2.length < 1) {
                        defaultArrayOneD = getDefaultArrayOneD(dArrFlattenArray.length);
                        if (dArrEvalToArray3.length >= 1) {
                            dArrEvalToArray = dArr;
                        }
                    } else {
                        if (dArrEvalToArray2[0].length > 1 || dArrEvalToArray.length != 1) {
                            dArrSwitchRowsColumns = dArrEvalToArray2;
                        } else {
                            dArrSwitchRowsColumns = switchRowsColumns(dArrEvalToArray2);
                        }
                        if (dArrEvalToArray3.length < 1) {
                            defaultArrayOneD = dArrSwitchRowsColumns;
                            dArrEvalToArray = dArrEvalToArray2;
                        } else {
                            defaultArrayOneD = dArrSwitchRowsColumns;
                            dArrEvalToArray = dArr;
                        }
                    }
                    if (dArrEvalToArray3.length > 0 || !(defaultArrayOneD.length == 1 || defaultArrayOneD[0].length == 1)) {
                        dArr = dArrEvalToArray;
                        dArrFlattenArrayToRow = dArrEvalToArray3;
                    } else {
                        dArrFlattenArrayToRow = flattenArrayToRow(dArrEvalToArray3);
                        dArr = dArrEvalToArray;
                    }
                } else {
                    if (dArrEvalToArray2.length < 1) {
                        defaultArrayOneD = getDefaultArrayOneD(dArrFlattenArray.length);
                        if (dArrEvalToArray3.length < 1) {
                            dArr = dArrEvalToArray;
                        }
                    } else {
                        defaultArrayOneD = flattenArrayToRow(dArrEvalToArray2);
                        if (dArrEvalToArray3.length < 1) {
                            dArr = dArrEvalToArray2;
                        }
                    }
                    dArrFlattenArrayToRow = dArrEvalToArray3.length > 0 ? flattenArrayToRow(dArrEvalToArray3) : dArrEvalToArray3;
                    if (dArrFlattenArray.length != defaultArrayOneD.length || dArrEvalToArray.length != dArrEvalToArray2.length) {
                        throw new EvaluationException(ErrorEval.REF_INVALID);
                    }
                }
                if (dArrEvalToArray3.length < 1) {
                    dArrFlattenArrayToRow = defaultArrayOneD;
                } else if (dArrEvalToArray3.length == 1 && dArrEvalToArray3[0].length > 1 && dArrEvalToArray2.length > 1 && dArrEvalToArray2[0].length == 1) {
                    dArrFlattenArrayToRow = switchRowsColumns(dArrEvalToArray3);
                }
                length = dArrFlattenArrayToRow[0].length;
                dArr2 = defaultArrayOneD[0];
                if (length == dArr2.length) {
                    throw new EvaluationException(ErrorEval.REF_INVALID);
                }
                if (dArr2.length < defaultArrayOneD.length) {
                    throw new NotImplementedException("Sample size too small");
                }
                length2 = dArr.length;
                length3 = dArr[0].length;
                if (isAllColumnsSame(defaultArrayOneD)) {
                    double[] dArr4 = new double[dArrFlattenArrayToRow.length];
                    Arrays.fill(dArr4, Arrays.stream(dArrFlattenArray).average().orElse(0.0d));
                    return new TrendResults(dArr4, length3, length2);
                }
                oLSMultipleLinearRegression = new OLSMultipleLinearRegression();
                if (z6) {
                    oLSMultipleLinearRegression.setNoIntercept(true);
                }
                try {
                    oLSMultipleLinearRegression.newSampleData(dArrFlattenArray, defaultArrayOneD);
                    try {
                        dArrEstimateRegressionParameters = oLSMultipleLinearRegression.estimateRegressionParameters();
                        dArr3 = new double[dArrFlattenArrayToRow.length];
                        for (i5 = 0; i5 < dArrFlattenArrayToRow.length; i5++) {
                            dArr3[i5] = 0.0d;
                            if (z6) {
                                for (i7 = 0; i7 < dArrEstimateRegressionParameters.length; i7++) {
                                    dArr3[i5] = (dArrEstimateRegressionParameters[i7] * dArrFlattenArrayToRow[i5][i7]) + dArr3[i5];
                                }
                            } else {
                                dArr3[i5] = dArrEstimateRegressionParameters[0];
                                for (i6 = 1; i6 < dArrEstimateRegressionParameters.length; i6++) {
                                    dArr3[i5] = (dArrEstimateRegressionParameters[i6] * dArrFlattenArrayToRow[i5][i6 - 1]) + dArr3[i5];
                                }
                            }
                        }
                        return new TrendResults(dArr3, length3, length2);
                    } catch (SingularMatrixException unused) {
                        throw new NotImplementedException("Singular matrix in input");
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new EvaluationException(ErrorEval.REF_INVALID);
                }
            }
            dArrEvalToArray = evalToArray(valueEvalArr[0]);
            dArrEvalToArray2 = evalToArray(valueEvalArr[1]);
            dArrEvalToArray3 = (double[][]) Array.newInstance((Class<?>) cls, 0, 0);
        }
        z6 = false;
        if (dArrEvalToArray.length >= 1) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        dArrFlattenArray = flattenArray(dArrEvalToArray);
        if (dArrEvalToArray3.length > 0) {
            dArr = dArrEvalToArray3;
        } else {
            dArr = (double[][]) Array.newInstance((Class<?>) cls, 1, 1);
        }
        if (dArrFlattenArray.length != 1) {
            throw new NotImplementedException("Sample size too small");
        }
        if (dArrEvalToArray.length != 1) {
            if (dArrEvalToArray2.length < 1) {
                defaultArrayOneD = getDefaultArrayOneD(dArrFlattenArray.length);
                if (dArrEvalToArray3.length >= 1) {
                    dArrEvalToArray = dArr;
                }
            } else {
                if (dArrEvalToArray2[0].length > 1) {
                    dArrSwitchRowsColumns = dArrEvalToArray2;
                } else {
                    dArrSwitchRowsColumns = dArrEvalToArray2;
                }
                if (dArrEvalToArray3.length < 1) {
                    defaultArrayOneD = dArrSwitchRowsColumns;
                    dArrEvalToArray = dArrEvalToArray2;
                } else {
                    defaultArrayOneD = dArrSwitchRowsColumns;
                    dArrEvalToArray = dArr;
                }
            }
            if (dArrEvalToArray3.length > 0) {
                dArr = dArrEvalToArray;
                dArrFlattenArrayToRow = dArrEvalToArray3;
            } else {
                dArr = dArrEvalToArray;
                dArrFlattenArrayToRow = dArrEvalToArray3;
            }
        } else {
            if (dArrEvalToArray2.length < 1) {
                defaultArrayOneD = getDefaultArrayOneD(dArrFlattenArray.length);
                if (dArrEvalToArray3.length >= 1) {
                    dArrEvalToArray = dArr;
                }
            } else {
                if (dArrEvalToArray2[0].length > 1) {
                    dArrSwitchRowsColumns = dArrEvalToArray2;
                } else {
                    dArrSwitchRowsColumns = dArrEvalToArray2;
                }
                if (dArrEvalToArray3.length < 1) {
                    defaultArrayOneD = dArrSwitchRowsColumns;
                    dArrEvalToArray = dArrEvalToArray2;
                } else {
                    defaultArrayOneD = dArrSwitchRowsColumns;
                    dArrEvalToArray = dArr;
                }
            }
            if (dArrEvalToArray3.length > 0) {
                dArr = dArrEvalToArray;
                dArrFlattenArrayToRow = dArrEvalToArray3;
            } else {
                dArr = dArrEvalToArray;
                dArrFlattenArrayToRow = dArrEvalToArray3;
            }
        }
        if (dArrEvalToArray3.length < 1) {
            dArrFlattenArrayToRow = defaultArrayOneD;
        } else if (dArrEvalToArray3.length == 1) {
            dArrFlattenArrayToRow = switchRowsColumns(dArrEvalToArray3);
        }
        length = dArrFlattenArrayToRow[0].length;
        dArr2 = defaultArrayOneD[0];
        if (length == dArr2.length) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        if (dArr2.length < defaultArrayOneD.length) {
            throw new NotImplementedException("Sample size too small");
        }
        length2 = dArr.length;
        length3 = dArr[0].length;
        if (isAllColumnsSame(defaultArrayOneD)) {
            double[] dArr5 = new double[dArrFlattenArrayToRow.length];
            Arrays.fill(dArr5, Arrays.stream(dArrFlattenArray).average().orElse(0.0d));
            return new TrendResults(dArr5, length3, length2);
        }
        oLSMultipleLinearRegression = new OLSMultipleLinearRegression();
        if (z6) {
            oLSMultipleLinearRegression.setNoIntercept(true);
        }
        oLSMultipleLinearRegression.newSampleData(dArrFlattenArray, defaultArrayOneD);
        dArrEstimateRegressionParameters = oLSMultipleLinearRegression.estimateRegressionParameters();
        dArr3 = new double[dArrFlattenArrayToRow.length];
        while (i5 < dArrFlattenArrayToRow.length) {
            dArr3[i5] = 0.0d;
            if (z6) {
                while (i7 < dArrEstimateRegressionParameters.length) {
                    dArr3[i5] = (dArrEstimateRegressionParameters[i7] * dArrFlattenArrayToRow[i5][i7]) + dArr3[i5];
                }
            } else {
                dArr3[i5] = dArrEstimateRegressionParameters[0];
                while (i6 < dArrEstimateRegressionParameters.length) {
                    dArr3[i5] = (dArrEstimateRegressionParameters[i6] * dArrFlattenArrayToRow[i5][i6 - 1]) + dArr3[i5];
                }
            }
        }
        return new TrendResults(dArr3, length3, length2);
    }

    private static boolean isAllColumnsSame(double[][] dArr) {
        if (dArr.length == 0) {
            return false;
        }
        int length = dArr[0].length;
        boolean[] zArr = new boolean[length];
        for (int i5 = 0; i5 < dArr[0].length; i5++) {
            double d = Double.NaN;
            int i6 = 0;
            while (i6 < dArr.length) {
                double d6 = dArr[i6][i5];
                if (i6 > 0 && d6 != d) {
                    zArr[i5] = true;
                    break;
                }
                i6++;
                d = d6;
            }
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (zArr[i7]) {
                return false;
            }
        }
        return true;
    }

    private static double[][] switchRowsColumns(double[][] dArr) {
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr[0].length, dArr.length);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            for (int i6 = 0; i6 < dArr[0].length; i6++) {
                dArr2[i6][i5] = dArr[i5][i6];
            }
        }
        return dArr2;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 1 || valueEvalArr.length > 4) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            TrendResults newY = getNewY(valueEvalArr);
            ValueEval[] valueEvalArr2 = new ValueEval[newY.vals.length];
            for (int i7 = 0; i7 < newY.vals.length; i7++) {
                valueEvalArr2[i7] = new NumberEval(newY.vals[i7]);
            }
            return newY.vals.length == 1 ? valueEvalArr2[0] : new CacheAreaEval(i5, i6, (newY.resultHeight + i5) - 1, (newY.resultWidth + i6) - 1, valueEvalArr2);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
