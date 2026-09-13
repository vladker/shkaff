package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.Internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class XSSFEvaluationSheet implements EvaluationSheet {
    private Map<CellKey, EvaluationCell> _cellCache;
    private final XSSFSheet _xs;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CellKey {
        private final int _col;
        private int _hash = -1;
        private final int _row;

        public CellKey(int i5, int i6) {
            this._row = i5;
            this._col = i6;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CellKey)) {
                return false;
            }
            CellKey cellKey = (CellKey) obj;
            return this._row == cellKey._row && this._col == cellKey._col;
        }

        public int hashCode() {
            if (this._hash == -1) {
                this._hash = ((this._row + 629) * 37) + this._col;
            }
            return this._hash;
        }
    }

    public XSSFEvaluationSheet(XSSFSheet xSSFSheet) {
        this._xs = xSSFSheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public void clearAllCachedResultValues() {
        this._cellCache = null;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int i5, int i6) {
        XSSFCell cell;
        if (i5 > getLastRowNum()) {
            return null;
        }
        if (this._cellCache == null) {
            this._cellCache = new HashMap(this._xs.getLastRowNum() * 3);
            for (Row row : this._xs) {
                int rowNum = row.getRowNum();
                for (Cell cell2 : row) {
                    this._cellCache.put(new CellKey(rowNum, cell2.getColumnIndex()), new XSSFEvaluationCell((XSSFCell) cell2, this));
                }
            }
        }
        CellKey cellKey = new CellKey(i5, i6);
        EvaluationCell evaluationCell = this._cellCache.get(cellKey);
        if (evaluationCell != null) {
            return evaluationCell;
        }
        XSSFRow row2 = this._xs.getRow(i5);
        if (row2 == null || (cell = row2.getCell(i6)) == null) {
            return null;
        }
        XSSFEvaluationCell xSSFEvaluationCell = new XSSFEvaluationCell(cell, this);
        this._cellCache.put(cellKey, xSSFEvaluationCell);
        return xSSFEvaluationCell;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public int getLastRowNum() {
        return this._xs.getLastRowNum();
    }

    public XSSFSheet getXSSFSheet() {
        return this._xs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public boolean isRowHidden(int i5) {
        XSSFRow row = this._xs.getRow(i5);
        if (row == null) {
            return false;
        }
        return row.getZeroHeight();
    }
}
