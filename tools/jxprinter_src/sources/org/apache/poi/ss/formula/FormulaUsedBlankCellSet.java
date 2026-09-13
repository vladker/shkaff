package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.util.CellReference;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class FormulaUsedBlankCellSet {
    private final Map<BookSheetKey, BlankCellSheetGroup> _sheetGroupsByBookSheet = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BlankCellRectangleGroup {
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _lastColumnIndex;
        private int _lastRowIndex;

        public BlankCellRectangleGroup(int i5, int i6, int i7) {
            this._firstRowIndex = i5;
            this._firstColumnIndex = i6;
            this._lastColumnIndex = i7;
            this._lastRowIndex = i5;
        }

        public boolean acceptRow(int i5, int i6, int i7) {
            if (i6 != this._firstColumnIndex || i7 != this._lastColumnIndex || i5 != this._lastRowIndex + 1) {
                return false;
            }
            this._lastRowIndex = i5;
            return true;
        }

        public boolean containsCell(int i5, int i6) {
            return i6 >= this._firstColumnIndex && i6 <= this._lastColumnIndex && i5 >= this._firstRowIndex && i5 <= this._lastRowIndex;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            CellReference cellReference = new CellReference(this._firstRowIndex, this._firstColumnIndex, false, false);
            CellReference cellReference2 = new CellReference(this._lastRowIndex, this._lastColumnIndex, false, false);
            sb.append(BlankCellRectangleGroup.class.getName());
            sb.append(" [");
            sb.append(cellReference.formatAsString());
            sb.append(NameUtil.COLON);
            sb.append(cellReference2.formatAsString());
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BlankCellSheetGroup {
        private BlankCellRectangleGroup _currentRectangleGroup;
        private int _firstColumnIndex;
        private int _lastColumnIndex;
        private int _lastDefinedRow;
        private final List<BlankCellRectangleGroup> _rectangleGroups = new ArrayList();
        private int _currentRowIndex = -1;

        public BlankCellSheetGroup(int i5) {
            this._lastDefinedRow = i5;
        }

        public void addCell(int i5, int i6) {
            if (i5 > this._lastDefinedRow) {
                return;
            }
            int i7 = this._currentRowIndex;
            if (i7 == -1) {
                this._currentRowIndex = i5;
                this._firstColumnIndex = i6;
                this._lastColumnIndex = i6;
            } else {
                if (i7 == i5 && this._lastColumnIndex + 1 == i6) {
                    this._lastColumnIndex = i6;
                    return;
                }
                BlankCellRectangleGroup blankCellRectangleGroup = this._currentRectangleGroup;
                if (blankCellRectangleGroup == null) {
                    this._currentRectangleGroup = new BlankCellRectangleGroup(i7, this._firstColumnIndex, this._lastColumnIndex);
                } else if (!blankCellRectangleGroup.acceptRow(i7, this._firstColumnIndex, this._lastColumnIndex)) {
                    this._rectangleGroups.add(this._currentRectangleGroup);
                    this._currentRectangleGroup = new BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
                }
                this._currentRowIndex = i5;
                this._firstColumnIndex = i6;
                this._lastColumnIndex = i6;
            }
        }

        public boolean containsCell(int i5, int i6) {
            if (i5 > this._lastDefinedRow) {
                return true;
            }
            for (int size = this._rectangleGroups.size() - 1; size >= 0; size--) {
                if (this._rectangleGroups.get(size).containsCell(i5, i6)) {
                    return true;
                }
            }
            BlankCellRectangleGroup blankCellRectangleGroup = this._currentRectangleGroup;
            if (blankCellRectangleGroup != null && blankCellRectangleGroup.containsCell(i5, i6)) {
                return true;
            }
            int i7 = this._currentRowIndex;
            return i7 != -1 && i7 == i5 && this._firstColumnIndex <= i6 && i6 <= this._lastColumnIndex;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BookSheetKey {
        private final int _bookIndex;
        private final int _sheetIndex;

        public BookSheetKey(int i5, int i6) {
            this._bookIndex = i5;
            this._sheetIndex = i6;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BookSheetKey)) {
                return false;
            }
            BookSheetKey bookSheetKey = (BookSheetKey) obj;
            return this._bookIndex == bookSheetKey._bookIndex && this._sheetIndex == bookSheetKey._sheetIndex;
        }

        public int hashCode() {
            return (this._bookIndex * 17) + this._sheetIndex;
        }
    }

    private BlankCellSheetGroup getSheetGroup(EvaluationWorkbook evaluationWorkbook, int i5, int i6) {
        BookSheetKey bookSheetKey = new BookSheetKey(i5, i6);
        BlankCellSheetGroup blankCellSheetGroup = this._sheetGroupsByBookSheet.get(bookSheetKey);
        if (blankCellSheetGroup != null) {
            return blankCellSheetGroup;
        }
        BlankCellSheetGroup blankCellSheetGroup2 = new BlankCellSheetGroup(evaluationWorkbook.getSheet(i6).getLastRowNum());
        this._sheetGroupsByBookSheet.put(bookSheetKey, blankCellSheetGroup2);
        return blankCellSheetGroup2;
    }

    public void addCell(EvaluationWorkbook evaluationWorkbook, int i5, int i6, int i7, int i8) {
        getSheetGroup(evaluationWorkbook, i5, i6).addCell(i7, i8);
    }

    public boolean containsCell(BookSheetKey bookSheetKey, int i5, int i6) {
        BlankCellSheetGroup blankCellSheetGroup = this._sheetGroupsByBookSheet.get(bookSheetKey);
        if (blankCellSheetGroup == null) {
            return false;
        }
        return blankCellSheetGroup.containsCell(i5, i6);
    }

    public boolean isEmpty() {
        return this._sheetGroupsByBookSheet.isEmpty();
    }
}
