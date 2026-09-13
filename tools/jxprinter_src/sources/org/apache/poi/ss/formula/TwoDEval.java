package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface TwoDEval extends ValueEval {
    TwoDEval getColumn(int i5);

    int getHeight();

    TwoDEval getRow(int i5);

    ValueEval getValue(int i5, int i6);

    int getWidth();

    boolean isColumn();

    default boolean isRow() {
        return false;
    }

    boolean isRowHidden(int i5);

    boolean isSubTotal(int i5, int i6);
}
