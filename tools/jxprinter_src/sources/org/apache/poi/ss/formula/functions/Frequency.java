package org.apache.poi.ss.formula.functions;

import java.util.Arrays;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Frequency extends Fixed2ArgFunction {
    public static final Function instance = new Frequency();

    private Frequency() {
    }

    public static int findBin(double d, double[] dArr) {
        int iBinarySearch = Arrays.binarySearch(dArr, d);
        return iBinarySearch >= 0 ? iBinarySearch + 1 : -iBinarySearch;
    }

    public static int[] histogram(double[] dArr, double[] dArr2) {
        int[] iArr = new int[dArr2.length + 1];
        for (double d : dArr) {
            int iFindBin = findBin(d, dArr2) - 1;
            iArr[iFindBin] = iArr[iFindBin] + 1;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NumberEval[] lambda$evaluate$0(int i5) {
        return new NumberEval[i5];
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        MatrixFunction.MutableValueCollector mutableValueCollector = new MatrixFunction.MutableValueCollector(false, false);
        try {
            NumberEval[] numberEvalArr = (NumberEval[]) Arrays.stream(histogram(mutableValueCollector.collectValues(valueEval), mutableValueCollector.collectValues(valueEval2))).boxed().map(new d()).toArray(new e());
            return new CacheAreaEval(i5, i6, (numberEvalArr.length + i5) - 1, i6, numberEvalArr);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
