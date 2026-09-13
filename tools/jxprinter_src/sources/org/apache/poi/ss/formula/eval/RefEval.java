package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RefEval extends ValueEval, SheetRange {
    int getColumn();

    @Override // org.apache.poi.ss.formula.SheetRange
    int getFirstSheetIndex();

    ValueEval getInnerValueEval(int i5);

    @Override // org.apache.poi.ss.formula.SheetRange
    int getLastSheetIndex();

    int getNumberOfSheets();

    int getRow();

    AreaEval offset(int i5, int i6, int i7, int i8);
}
