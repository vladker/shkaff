package org.apache.poi.ss.util.cellwalk;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellWalk {
    private final CellRangeAddress range;
    private final Sheet sheet;
    private boolean traverseEmptyCells = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SimpleCellWalkContext implements CellWalkContext {
        private int colNumber;
        private long ordinalNumber;
        private int rowNumber;

        private SimpleCellWalkContext() {
        }

        public static /* synthetic */ int access$104(SimpleCellWalkContext simpleCellWalkContext) {
            int i5 = simpleCellWalkContext.rowNumber + 1;
            simpleCellWalkContext.rowNumber = i5;
            return i5;
        }

        public static /* synthetic */ int access$204(SimpleCellWalkContext simpleCellWalkContext) {
            int i5 = simpleCellWalkContext.colNumber + 1;
            simpleCellWalkContext.colNumber = i5;
            return i5;
        }

        @Override // org.apache.poi.ss.util.cellwalk.CellWalkContext
        public int getColumnNumber() {
            return this.colNumber;
        }

        @Override // org.apache.poi.ss.util.cellwalk.CellWalkContext
        public long getOrdinalNumber() {
            return this.ordinalNumber;
        }

        @Override // org.apache.poi.ss.util.cellwalk.CellWalkContext
        public int getRowNumber() {
            return this.rowNumber;
        }
    }

    public CellWalk(Sheet sheet, CellRangeAddress cellRangeAddress) {
        this.sheet = sheet;
        this.range = cellRangeAddress;
    }

    private boolean isEmpty(Cell cell) {
        return cell.getCellType() == CellType.BLANK;
    }

    public boolean isTraverseEmptyCells() {
        return this.traverseEmptyCells;
    }

    public void setTraverseEmptyCells(boolean z6) {
        this.traverseEmptyCells = z6;
    }

    public void traverse(CellHandler cellHandler) {
        int firstRow = this.range.getFirstRow();
        int lastRow = this.range.getLastRow();
        int firstColumn = this.range.getFirstColumn();
        int lastColumn = this.range.getLastColumn();
        int i5 = (lastColumn - firstColumn) + 1;
        SimpleCellWalkContext simpleCellWalkContext = new SimpleCellWalkContext();
        simpleCellWalkContext.rowNumber = firstRow;
        while (simpleCellWalkContext.rowNumber <= lastRow) {
            Row row = this.sheet.getRow(simpleCellWalkContext.rowNumber);
            if (row != null) {
                simpleCellWalkContext.colNumber = firstColumn;
                while (simpleCellWalkContext.colNumber <= lastColumn) {
                    Cell cell = row.getCell(simpleCellWalkContext.colNumber);
                    if (cell != null && (!isEmpty(cell) || this.traverseEmptyCells)) {
                        simpleCellWalkContext.ordinalNumber = Math.addExact(Math.multiplyExact(Math.subtractExact(simpleCellWalkContext.rowNumber, firstRow), i5), (simpleCellWalkContext.colNumber - firstColumn) + 1);
                        cellHandler.onCell(cell, simpleCellWalkContext);
                    }
                    SimpleCellWalkContext.access$204(simpleCellWalkContext);
                }
            }
            SimpleCellWalkContext.access$104(simpleCellWalkContext);
        }
    }
}
