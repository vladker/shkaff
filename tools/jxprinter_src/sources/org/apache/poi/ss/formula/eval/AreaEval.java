package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface AreaEval extends TwoDEval, ThreeDEval {
    boolean contains(int i5, int i6);

    boolean containsColumn(int i5);

    boolean containsRow(int i5);

    ValueEval getAbsoluteValue(int i5, int i6);

    int getFirstColumn();

    int getFirstRow();

    @Override // org.apache.poi.ss.formula.TwoDEval
    int getHeight();

    int getLastColumn();

    int getLastRow();

    ValueEval getRelativeValue(int i5, int i6);

    @Override // org.apache.poi.ss.formula.TwoDEval
    int getWidth();

    AreaEval offset(int i5, int i6, int i7, int i8);
}
