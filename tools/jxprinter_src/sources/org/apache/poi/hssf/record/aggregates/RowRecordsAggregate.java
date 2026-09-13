package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.DBCellRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.IndexRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RowRecordsAggregate extends RecordAggregate {
    private int _firstrow;
    private int _lastrow;
    private RowRecord[] _rowRecordValues;
    private final Map<Integer, RowRecord> _rowRecords;
    private final SharedValueManager _sharedValueManager;
    private final List<Record> _unknownRecords;
    private final ValueRecordsAggregate _valuesAgg;

    public RowRecordsAggregate() {
        this(SharedValueManager.createEmpty());
    }

    private void addUnknownRecord(Record record) {
        this._unknownRecords.add(record);
    }

    public static RowRecord createRow(int i5) {
        return new RowRecord(i5);
    }

    private int getEndRowNumberForBlock(int i5) {
        int size = ((i5 + 1) * 32) - 1;
        if (size >= this._rowRecords.size()) {
            size = this._rowRecords.size() - 1;
        }
        if (this._rowRecordValues == null) {
            this._rowRecordValues = (RowRecord[]) this._rowRecords.values().toArray(new RowRecord[0]);
        }
        try {
            return this._rowRecordValues[size].getRowNumber();
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Did not find end row for block "));
        }
    }

    private int getRowBlockSize(int i5) {
        return getRowCountForBlock(i5) * 20;
    }

    private int getStartRowNumberForBlock(int i5) {
        int i6 = i5 * 32;
        if (this._rowRecordValues == null) {
            this._rowRecordValues = (RowRecord[]) this._rowRecords.values().toArray(new RowRecord[0]);
        }
        try {
            return this._rowRecordValues[i6].getRowNumber();
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Did not find start row for block "));
        }
    }

    private static short[] shortListToArray(List<Short> list) {
        short[] sArr = new short[list.size()];
        Iterator<Short> it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            sArr[i5] = it.next().shortValue();
            i5++;
        }
        return sArr;
    }

    private int visitRowRecordsForBlock(int i5, RecordAggregate.RecordVisitor recordVisitor) {
        int i6 = i5 * 32;
        int i7 = i6 + 32;
        Iterator<RowRecord> it = this._rowRecords.values().iterator();
        int recordSize = 0;
        int i8 = 0;
        while (i8 < i6) {
            it.next();
            i8++;
        }
        while (it.hasNext()) {
            int i9 = i8 + 1;
            if (i8 >= i7) {
                break;
            }
            RowRecord next = it.next();
            recordSize += next.getRecordSize();
            recordVisitor.visitRecord(next);
            i8 = i9;
        }
        return recordSize;
    }

    private int writeHidden(RowRecord rowRecord, int i5) {
        short outlineLevel = rowRecord.getOutlineLevel();
        while (rowRecord != null && getRow(i5).getOutlineLevel() >= outlineLevel) {
            rowRecord.setZeroHeight(true);
            i5++;
            rowRecord = getRow(i5);
        }
        return i5;
    }

    public void collapseRow(int i5) {
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i5);
        int iWriteHidden = writeHidden(getRow(iFindStartOfRowOutlineGroup), iFindStartOfRowOutlineGroup);
        RowRecord row = getRow(iWriteHidden);
        if (row == null) {
            row = createRow(iWriteHidden);
            insertRow(row);
        }
        row.setColapsed(true);
    }

    public DimensionsRecord createDimensions() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.setFirstRow(this._firstrow);
        dimensionsRecord.setLastRow(this._lastrow);
        dimensionsRecord.setFirstCol((short) this._valuesAgg.getFirstCellNum());
        dimensionsRecord.setLastCol((short) this._valuesAgg.getLastCellNum());
        return dimensionsRecord;
    }

    public FormulaRecordAggregate createFormula(int i5, int i6) {
        FormulaRecord formulaRecord = new FormulaRecord();
        formulaRecord.setRow(i5);
        formulaRecord.setColumn((short) i6);
        return new FormulaRecordAggregate(formulaRecord, null, this._sharedValueManager);
    }

    public IndexRecord createIndexRecord(int i5, int i6) {
        IndexRecord indexRecord = new IndexRecord();
        indexRecord.setFirstRow(this._firstrow);
        indexRecord.setLastRowAdd1(this._lastrow + 1);
        int rowBlockCount = getRowBlockCount();
        int recordSizeForBlockCount = IndexRecord.getRecordSizeForBlockCount(rowBlockCount) + i5 + i6;
        for (int i7 = 0; i7 < rowBlockCount; i7++) {
            int rowCellBlockSize = this._valuesAgg.getRowCellBlockSize(getStartRowNumberForBlock(i7), getEndRowNumberForBlock(i7)) + recordSizeForBlockCount + getRowBlockSize(i7);
            indexRecord.addDbcell(rowCellBlockSize);
            recordSizeForBlockCount = (getRowCountForBlock(i7) * 2) + 8 + rowCellBlockSize;
        }
        return indexRecord;
    }

    public void expandRow(int i5) {
        if (i5 != -1 && isRowGroupCollapsed(i5)) {
            int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i5);
            RowRecord row = getRow(iFindStartOfRowOutlineGroup);
            int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i5);
            if (!isRowGroupHiddenByParent(i5)) {
                while (iFindStartOfRowOutlineGroup <= iFindEndOfRowOutlineGroup) {
                    RowRecord row2 = getRow(iFindStartOfRowOutlineGroup);
                    if (row.getOutlineLevel() == row2.getOutlineLevel() || !isRowGroupCollapsed(iFindStartOfRowOutlineGroup)) {
                        row2.setZeroHeight(false);
                    }
                    iFindStartOfRowOutlineGroup++;
                }
            }
            getRow(iFindEndOfRowOutlineGroup + 1).setColapsed(false);
        }
    }

    public int findEndOfRowOutlineGroup(int i5) {
        short outlineLevel = getRow(i5).getOutlineLevel();
        while (i5 < getLastRowNum() && getRow(i5) != null && getRow(i5).getOutlineLevel() >= outlineLevel) {
            i5++;
        }
        return i5 - 1;
    }

    public int findStartOfRowOutlineGroup(int i5) {
        short outlineLevel = getRow(i5).getOutlineLevel();
        while (i5 >= 0 && getRow(i5) != null) {
            if (getRow(i5).getOutlineLevel() < outlineLevel) {
                return i5 + 1;
            }
            i5--;
        }
        return i5 + 1;
    }

    public Iterator<CellValueRecordInterface> getCellValueIterator() {
        return this._valuesAgg.iterator();
    }

    public Spliterator<CellValueRecordInterface> getCellValueSpliterator() {
        return this._valuesAgg.spliterator();
    }

    public int getFirstRowNum() {
        return this._firstrow;
    }

    public Iterator<RowRecord> getIterator() {
        return this._rowRecords.values().iterator();
    }

    public int getLastRowNum() {
        return this._lastrow;
    }

    public int getPhysicalNumberOfRows() {
        return this._rowRecords.size();
    }

    public RowRecord getRow(int i5) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i5 < 0 || i5 > lastRowIndex) {
            throw new IllegalArgumentException(androidx.collection.a.h(lastRowIndex, i5, "The row number must be between 0 and ", ", but had: "));
        }
        return this._rowRecords.get(Integer.valueOf(i5));
    }

    public int getRowBlockCount() {
        int size = this._rowRecords.size() / 32;
        return this._rowRecords.size() % 32 != 0 ? size + 1 : size;
    }

    public int getRowCountForBlock(int i5) {
        int i6 = i5 * 32;
        int size = i6 + 31;
        if (size >= this._rowRecords.size()) {
            size = this._rowRecords.size() - 1;
        }
        return (size - i6) + 1;
    }

    public Spliterator<RowRecord> getSpliterator() {
        return this._rowRecords.values().spliterator();
    }

    public void insertCell(CellValueRecordInterface cellValueRecordInterface) {
        this._valuesAgg.insertCell(cellValueRecordInterface);
    }

    public void insertRow(RowRecord rowRecord) {
        this._rowRecords.put(Integer.valueOf(rowRecord.getRowNumber()), rowRecord);
        this._rowRecordValues = null;
        int rowNumber = rowRecord.getRowNumber();
        int i5 = this._firstrow;
        if (rowNumber < i5 || i5 == -1) {
            this._firstrow = rowRecord.getRowNumber();
        }
        int rowNumber2 = rowRecord.getRowNumber();
        int i6 = this._lastrow;
        if (rowNumber2 > i6 || i6 == -1) {
            this._lastrow = rowRecord.getRowNumber();
        }
    }

    public boolean isRowGroupCollapsed(int i5) {
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i5) + 1;
        return getRow(iFindEndOfRowOutlineGroup) != null && getRow(iFindEndOfRowOutlineGroup).getColapsed();
    }

    public boolean isRowGroupHiddenByParent(int i5) {
        short outlineLevel;
        boolean zeroHeight;
        boolean zeroHeight2;
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i5) + 1;
        short outlineLevel2 = 0;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            zeroHeight = false;
            outlineLevel = 0;
        } else {
            outlineLevel = getRow(iFindEndOfRowOutlineGroup).getOutlineLevel();
            zeroHeight = getRow(iFindEndOfRowOutlineGroup).getZeroHeight();
        }
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i5) - 1;
        if (iFindStartOfRowOutlineGroup < 0 || getRow(iFindStartOfRowOutlineGroup) == null) {
            zeroHeight2 = false;
        } else {
            outlineLevel2 = getRow(iFindStartOfRowOutlineGroup).getOutlineLevel();
            zeroHeight2 = getRow(iFindStartOfRowOutlineGroup).getZeroHeight();
        }
        return outlineLevel > outlineLevel2 ? zeroHeight : zeroHeight2;
    }

    public void removeCell(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            ((FormulaRecordAggregate) cellValueRecordInterface).notifyFormulaChanging();
        }
        this._valuesAgg.removeCell(cellValueRecordInterface);
    }

    public void removeRow(RowRecord rowRecord) {
        int rowNumber = rowRecord.getRowNumber();
        this._valuesAgg.removeAllCellsValuesForRow(rowNumber);
        RowRecord rowRecordRemove = this._rowRecords.remove(Integer.valueOf(rowNumber));
        if (rowRecordRemove == null) {
            throw new IllegalArgumentException(androidx.collection.a.i(rowNumber, "Invalid row index (", ")"));
        }
        if (rowRecord == rowRecordRemove) {
            this._rowRecordValues = null;
        } else {
            this._rowRecords.put(Integer.valueOf(rowNumber), rowRecordRemove);
            throw new IllegalArgumentException("Attempt to remove row that does not belong to this sheet");
        }
    }

    public void updateFormulasAfterRowShift(FormulaShifter formulaShifter, int i5) {
        this._valuesAgg.updateFormulasAfterRowShift(formulaShifter, i5);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(recordVisitor, 0);
        int rowBlockCount = getRowBlockCount();
        for (int i5 = 0; i5 < rowBlockCount; i5++) {
            int iVisitRowRecordsForBlock = visitRowRecordsForBlock(i5, recordVisitor);
            int endRowNumberForBlock = getEndRowNumberForBlock(i5);
            ArrayList arrayList = new ArrayList();
            int i6 = iVisitRowRecordsForBlock - 20;
            for (int startRowNumberForBlock = getStartRowNumberForBlock(i5); startRowNumberForBlock <= endRowNumberForBlock; startRowNumberForBlock++) {
                if (this._valuesAgg.rowHasCells(startRowNumberForBlock)) {
                    positionTrackingVisitor.setPosition(0);
                    this._valuesAgg.visitCellsForRow(startRowNumberForBlock, positionTrackingVisitor);
                    int position = positionTrackingVisitor.getPosition();
                    iVisitRowRecordsForBlock += position;
                    arrayList.add(Short.valueOf((short) i6));
                    i6 = position;
                }
            }
            recordVisitor.visitRecord(new DBCellRecord(iVisitRowRecordsForBlock, shortListToArray(arrayList)));
        }
        List<Record> list = this._unknownRecords;
        recordVisitor.getClass();
        list.forEach(new b(recordVisitor, 1));
    }

    private RowRecordsAggregate(SharedValueManager sharedValueManager) {
        this._firstrow = -1;
        this._lastrow = -1;
        if (sharedValueManager == null) {
            throw new IllegalArgumentException("SharedValueManager must be provided.");
        }
        this._rowRecords = new TreeMap();
        this._valuesAgg = new ValueRecordsAggregate();
        this._unknownRecords = new ArrayList();
        this._sharedValueManager = sharedValueManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RowRecordsAggregate(RecordStream recordStream, SharedValueManager sharedValueManager) {
        this(sharedValueManager);
        while (recordStream.hasNext()) {
            Record next = recordStream.getNext();
            short sid = next.getSid();
            if (sid == 81) {
                addUnknownRecord(next);
            } else if (sid != 215 && sid != 440) {
                if (sid != 520) {
                    if (next instanceof UnknownRecord) {
                        addUnknownRecord(next);
                        while (recordStream.peekNextSid() == 60) {
                            addUnknownRecord(recordStream.getNext());
                        }
                    } else if (next instanceof MulBlankRecord) {
                        this._valuesAgg.addMultipleBlanks((MulBlankRecord) next);
                    } else if (next instanceof CellValueRecordInterface) {
                        this._valuesAgg.construct((CellValueRecordInterface) next, recordStream, sharedValueManager);
                    } else {
                        throw new IllegalArgumentException("Unexpected record type (" + next.getClass().getName() + ")");
                    }
                } else {
                    insertRow((RowRecord) next);
                }
            }
        }
    }
}
