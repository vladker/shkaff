package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Countblank extends Fixed1ArgFunction {
    private static final CountUtils.I_MatchPredicate predicate = new h(10);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(ValueEval valueEval) {
        if (valueEval != BlankEval.instance) {
            return (valueEval instanceof StringEval) && ((StringEval) valueEval).getStringValue().isEmpty();
        }
        return true;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        int iCountMatchingCellsInArea;
        if (valueEval instanceof RefEval) {
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInRef((RefEval) valueEval, predicate);
        } else {
            if (!(valueEval instanceof ThreeDEval)) {
                throw new IllegalArgumentException("Bad range arg type (" + valueEval.getClass().getName() + ")");
            }
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInArea((ThreeDEval) valueEval, predicate);
        }
        return new NumberEval(iCountMatchingCellsInArea);
    }
}
