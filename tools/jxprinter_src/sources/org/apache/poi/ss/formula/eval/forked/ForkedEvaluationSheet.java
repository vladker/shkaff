package org.apache.poi.ss.formula.eval.forked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
final class ForkedEvaluationSheet implements EvaluationSheet {
    private final EvaluationSheet _masterSheet;
    private final Map<RowColKey, ForkedEvaluationCell> _sharedCellsByRowCol = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RowColKey implements Comparable<RowColKey> {
        private final int _columnIndex;
        private final int _rowIndex;

        public RowColKey(int i5, int i6) {
            this._rowIndex = i5;
            this._columnIndex = i6;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof RowColKey)) {
                return false;
            }
            RowColKey rowColKey = (RowColKey) obj;
            return this._rowIndex == rowColKey._rowIndex && this._columnIndex == rowColKey._columnIndex;
        }

        public int getColumnIndex() {
            return this._columnIndex;
        }

        public int getRowIndex() {
            return this._rowIndex;
        }

        public int hashCode() {
            return this._rowIndex ^ this._columnIndex;
        }

        @Override // java.lang.Comparable
        public int compareTo(RowColKey rowColKey) {
            int i5 = this._rowIndex - rowColKey._rowIndex;
            return i5 != 0 ? i5 : this._columnIndex - rowColKey._columnIndex;
        }
    }

    public ForkedEvaluationSheet(EvaluationSheet evaluationSheet) {
        this._masterSheet = evaluationSheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public void clearAllCachedResultValues() {
        this._masterSheet.clearAllCachedResultValues();
    }

    public void copyUpdatedCells(Sheet sheet) {
        int size = this._sharedCellsByRowCol.size();
        RowColKey[] rowColKeyArr = new RowColKey[size];
        this._sharedCellsByRowCol.keySet().toArray(rowColKeyArr);
        Arrays.sort(rowColKeyArr);
        for (int i5 = 0; i5 < size; i5++) {
            RowColKey rowColKey = rowColKeyArr[i5];
            Row row = sheet.getRow(rowColKey.getRowIndex());
            if (row == null) {
                row = sheet.createRow(rowColKey.getRowIndex());
            }
            Cell cell = row.getCell(rowColKey.getColumnIndex());
            if (cell == null) {
                cell = row.createCell(rowColKey.getColumnIndex());
            }
            this._sharedCellsByRowCol.get(rowColKey).copyValue(cell);
        }
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int i5, int i6) {
        ForkedEvaluationCell forkedEvaluationCell = this._sharedCellsByRowCol.get(new RowColKey(i5, i6));
        return forkedEvaluationCell == null ? this._masterSheet.getCell(i5, i6) : forkedEvaluationCell;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public int getLastRowNum() {
        return this._masterSheet.getLastRowNum();
    }

    public ForkedEvaluationCell getOrCreateUpdatableCell(int i5, int i6) {
        RowColKey rowColKey = new RowColKey(i5, i6);
        ForkedEvaluationCell forkedEvaluationCell = this._sharedCellsByRowCol.get(rowColKey);
        if (forkedEvaluationCell != null) {
            return forkedEvaluationCell;
        }
        EvaluationCell cell = this._masterSheet.getCell(i5, i6);
        if (cell != null) {
            ForkedEvaluationCell forkedEvaluationCell2 = new ForkedEvaluationCell(this, cell);
            this._sharedCellsByRowCol.put(rowColKey, forkedEvaluationCell2);
            return forkedEvaluationCell2;
        }
        throw new UnsupportedOperationException("Underlying cell '" + new CellReference(i5, i6).formatAsString() + "' is missing in master sheet.");
    }

    public int getSheetIndex(EvaluationWorkbook evaluationWorkbook) {
        return evaluationWorkbook.getSheetIndex(this._masterSheet);
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public boolean isRowHidden(int i5) {
        return this._masterSheet.isRowHidden(i5);
    }
}
