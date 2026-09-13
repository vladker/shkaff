package org.apache.poi.ss.formula.functions;

import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ArrayFunctionUtils {
    private static Double collectValue(ValueEval valueEval) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("ve must not be null");
        }
        if (valueEval instanceof NumericValueEval) {
            return Double.valueOf(((NumericValueEval) valueEval).getNumberValue());
        }
        if (valueEval instanceof StringValueEval) {
            return OperandResolver.parseDouble(((StringValueEval) valueEval).getStringValue().trim());
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval == BlankEval.instance) {
            return null;
        }
        throw new RuntimeException("Invalid ValueEval type passed for conversion: (" + valueEval.getClass() + ")");
    }

    private static DoubleList collectValuesWithBlanks(ValueEval valueEval) throws EvaluationException {
        DoubleList doubleList = new DoubleList();
        if (valueEval instanceof ThreeDEval) {
            ThreeDEval threeDEval = (ThreeDEval) valueEval;
            for (int firstSheetIndex = threeDEval.getFirstSheetIndex(); firstSheetIndex <= threeDEval.getLastSheetIndex(); firstSheetIndex++) {
                int width = threeDEval.getWidth();
                int height = threeDEval.getHeight();
                for (int i5 = 0; i5 < height; i5++) {
                    for (int i6 = 0; i6 < width; i6++) {
                        Double dCollectValue = collectValue(threeDEval.getValue(firstSheetIndex, i5, i6));
                        if (dCollectValue == null) {
                            doubleList.add(Double.NaN);
                        } else {
                            doubleList.add(dCollectValue.doubleValue());
                        }
                    }
                }
            }
        } else if (valueEval instanceof TwoDEval) {
            TwoDEval twoDEval = (TwoDEval) valueEval;
            int width2 = twoDEval.getWidth();
            int height2 = twoDEval.getHeight();
            for (int i7 = 0; i7 < height2; i7++) {
                for (int i8 = 0; i8 < width2; i8++) {
                    Double dCollectValue2 = collectValue(twoDEval.getValue(i7, i8));
                    if (dCollectValue2 == null) {
                        doubleList.add(Double.NaN);
                    } else {
                        doubleList.add(dCollectValue2.doubleValue());
                    }
                }
            }
        } else {
            if (!(valueEval instanceof RefEval)) {
                Double dCollectValue3 = collectValue(valueEval);
                if (dCollectValue3 == null) {
                    doubleList.add(Double.NaN);
                    return doubleList;
                }
                doubleList.add(dCollectValue3.doubleValue());
                return doubleList;
            }
            RefEval refEval = (RefEval) valueEval;
            for (int firstSheetIndex2 = refEval.getFirstSheetIndex(); firstSheetIndex2 <= refEval.getLastSheetIndex(); firstSheetIndex2++) {
                Double dCollectValue4 = collectValue(refEval.getInnerValueEval(firstSheetIndex2));
                if (dCollectValue4 == null) {
                    doubleList.add(Double.NaN);
                } else {
                    doubleList.add(dCollectValue4.doubleValue());
                }
            }
        }
        return doubleList;
    }

    public static List<DoubleList> getNumberArrays(ValueEval valueEval, ValueEval valueEval2) throws EvaluationException {
        double[] array = collectValuesWithBlanks(valueEval).toArray();
        double[] array2 = collectValuesWithBlanks(valueEval2).toArray();
        if (array.length != array2.length) {
            throw new EvaluationException(ErrorEval.NA);
        }
        DoubleList doubleList = new DoubleList();
        DoubleList doubleList2 = new DoubleList();
        int iMin = Math.min(array.length, array2.length);
        for (int i5 = 0; i5 < iMin; i5++) {
            if (!Double.isNaN(array[i5]) && !Double.isNaN(array2[i5])) {
                doubleList.add(array[i5]);
                doubleList2.add(array2[i5]);
            }
        }
        return Arrays.asList(doubleList, doubleList2);
    }
}
