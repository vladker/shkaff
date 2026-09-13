package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class CountUtils {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface I_MatchAreaPredicate extends I_MatchPredicate {
        boolean matches(TwoDEval twoDEval, int i5, int i6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface I_MatchPredicate {
        boolean matches(ValueEval valueEval);
    }

    private CountUtils() {
    }

    public static int countArg(ValueEval valueEval, I_MatchPredicate i_MatchPredicate) {
        if (valueEval == null) {
            throw new IllegalArgumentException("eval must not be null");
        }
        if (valueEval instanceof ThreeDEval) {
            return countMatchingCellsInArea((ThreeDEval) valueEval, i_MatchPredicate);
        }
        if (valueEval instanceof TwoDEval) {
            throw new IllegalArgumentException("Count requires 3D Evals, 2D ones aren't supported");
        }
        return valueEval instanceof RefEval ? countMatchingCellsInRef((RefEval) valueEval, i_MatchPredicate) : i_MatchPredicate.matches(valueEval) ? 1 : 0;
    }

    public static int countMatchingCellsInArea(ThreeDEval threeDEval, I_MatchPredicate i_MatchPredicate) {
        int lastSheetIndex = threeDEval.getLastSheetIndex();
        int i5 = 0;
        for (int firstSheetIndex = threeDEval.getFirstSheetIndex(); firstSheetIndex <= lastSheetIndex; firstSheetIndex++) {
            int height = threeDEval.getHeight();
            int width = threeDEval.getWidth();
            for (int i6 = 0; i6 < height; i6++) {
                for (int i7 = 0; i7 < width; i7++) {
                    ValueEval value = threeDEval.getValue(firstSheetIndex, i6, i7);
                    if ((!(i_MatchPredicate instanceof I_MatchAreaPredicate) || ((I_MatchAreaPredicate) i_MatchPredicate).matches(threeDEval, i6, i7)) && i_MatchPredicate.matches(value)) {
                        i5++;
                    }
                }
            }
        }
        return i5;
    }

    public static int countMatchingCellsInRef(RefEval refEval, I_MatchPredicate i_MatchPredicate) {
        int lastSheetIndex = refEval.getLastSheetIndex();
        int i5 = 0;
        for (int firstSheetIndex = refEval.getFirstSheetIndex(); firstSheetIndex <= lastSheetIndex; firstSheetIndex++) {
            if (i_MatchPredicate.matches(refEval.getInnerValueEval(firstSheetIndex))) {
                i5++;
            }
        }
        return i5;
    }
}
