package org.apache.poi.hssf.record.aggregates;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ValueRecordsAggregate implements Iterable<CellValueRecordInterface> {
    private static final int INDEX_NOT_SET = -1;
    private static final int MAX_ROW_INDEX = 65535;
    private int firstcell;
    private int lastcell;
    private CellValueRecordInterface[][] records;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ValueIterator implements Iterator<CellValueRecordInterface> {
        int curRowIndex;
        int nextRowIndex;
        int curColIndex = -1;
        int nextColIndex = -1;

        public ValueIterator() {
            getNextPos();
        }

        public void getNextPos() {
            if (this.nextRowIndex >= ValueRecordsAggregate.this.records.length) {
                return;
            }
            while (this.nextRowIndex < ValueRecordsAggregate.this.records.length) {
                this.nextColIndex++;
                if (ValueRecordsAggregate.this.records[this.nextRowIndex] == null || this.nextColIndex >= ValueRecordsAggregate.this.records[this.nextRowIndex].length) {
                    this.nextRowIndex++;
                    this.nextColIndex = -1;
                } else if (ValueRecordsAggregate.this.records[this.nextRowIndex][this.nextColIndex] != null) {
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextRowIndex < ValueRecordsAggregate.this.records.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            ValueRecordsAggregate.this.records[this.curRowIndex][this.curColIndex] = null;
        }

        @Override // java.util.Iterator
        public CellValueRecordInterface next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curRowIndex = this.nextRowIndex;
            this.curColIndex = this.nextColIndex;
            CellValueRecordInterface cellValueRecordInterface = ValueRecordsAggregate.this.records[this.curRowIndex][this.curColIndex];
            getNextPos();
            return cellValueRecordInterface;
        }
    }

    public ValueRecordsAggregate() {
        this(-1, -1, new CellValueRecordInterface[30][]);
    }

    private static int countBlanks(CellValueRecordInterface[] cellValueRecordInterfaceArr, int i5) {
        int i6 = i5;
        while (i6 < cellValueRecordInterfaceArr.length && (cellValueRecordInterfaceArr[i6] instanceof BlankRecord)) {
            i6++;
        }
        return i6 - i5;
    }

    private MulBlankRecord createMBR(CellValueRecordInterface[] cellValueRecordInterfaceArr, int i5, int i6) {
        short[] sArr = new short[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            sArr[i7] = cellValueRecordInterfaceArr[i5 + i7].getXFIndex();
        }
        return new MulBlankRecord(cellValueRecordInterfaceArr[i5].getRow(), i5, sArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int getRowSerializedSize(CellValueRecordInterface[] cellValueRecordInterfaceArr) {
        int recordSize;
        int i5 = 0;
        if (cellValueRecordInterfaceArr == 0) {
            return 0;
        }
        int i6 = 0;
        while (i5 < cellValueRecordInterfaceArr.length) {
            RecordBase recordBase = (RecordBase) cellValueRecordInterfaceArr[i5];
            if (recordBase != null) {
                int iCountBlanks = countBlanks(cellValueRecordInterfaceArr, i5);
                if (iCountBlanks > 1) {
                    recordSize = (iCountBlanks * 2) + 10 + i6;
                    i5 += iCountBlanks - 1;
                } else {
                    recordSize = recordBase.getRecordSize() + i6;
                }
                i6 = recordSize;
            }
            i5++;
        }
        return i6;
    }

    public void addMultipleBlanks(MulBlankRecord mulBlankRecord) {
        for (int i5 = 0; i5 < mulBlankRecord.getNumColumns(); i5++) {
            BlankRecord blankRecord = new BlankRecord();
            blankRecord.setColumn((short) (mulBlankRecord.getFirstColumn() + i5));
            blankRecord.setRow(mulBlankRecord.getRow());
            blankRecord.setXFIndex(mulBlankRecord.getXFAt(i5));
            insertCell(blankRecord);
        }
    }

    public void construct(CellValueRecordInterface cellValueRecordInterface, RecordStream recordStream, SharedValueManager sharedValueManager) {
        if (cellValueRecordInterface instanceof FormulaRecord) {
            insertCell(new FormulaRecordAggregate((FormulaRecord) cellValueRecordInterface, recordStream.peekNextClass() == StringRecord.class ? (StringRecord) recordStream.getNext() : null, sharedValueManager));
        } else {
            insertCell(cellValueRecordInterface);
        }
    }

    public int getFirstCellNum() {
        return this.firstcell;
    }

    public int getLastCellNum() {
        return this.lastcell;
    }

    public int getPhysicalNumberOfCells() {
        int i5 = 0;
        for (CellValueRecordInterface[] cellValueRecordInterfaceArr : this.records) {
            if (cellValueRecordInterfaceArr != null) {
                for (CellValueRecordInterface cellValueRecordInterface : cellValueRecordInterfaceArr) {
                    if (cellValueRecordInterface != null) {
                        i5++;
                    }
                }
            }
        }
        return i5;
    }

    public int getRowCellBlockSize(int i5, int i6) {
        int rowSerializedSize = 0;
        while (i5 <= i6) {
            CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
            if (i5 >= cellValueRecordInterfaceArr.length) {
                break;
            }
            rowSerializedSize += getRowSerializedSize(cellValueRecordInterfaceArr[i5]);
            i5++;
        }
        return rowSerializedSize;
    }

    public void insertCell(CellValueRecordInterface cellValueRecordInterface) {
        short column = cellValueRecordInterface.getColumn();
        int row = cellValueRecordInterface.getRow();
        CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
        if (row >= cellValueRecordInterfaceArr.length) {
            int length = cellValueRecordInterfaceArr.length * 2;
            int i5 = row + 1;
            if (length < i5) {
                length = i5;
            }
            CellValueRecordInterface[][] cellValueRecordInterfaceArr2 = new CellValueRecordInterface[length][];
            this.records = cellValueRecordInterfaceArr2;
            System.arraycopy(cellValueRecordInterfaceArr, 0, cellValueRecordInterfaceArr2, 0, cellValueRecordInterfaceArr.length);
        }
        CellValueRecordInterface[][] cellValueRecordInterfaceArr3 = this.records;
        CellValueRecordInterface[] cellValueRecordInterfaceArr4 = cellValueRecordInterfaceArr3[row];
        if (cellValueRecordInterfaceArr4 == null) {
            int i6 = column + 1;
            if (i6 < 10) {
                i6 = 10;
            }
            cellValueRecordInterfaceArr4 = new CellValueRecordInterface[i6];
            cellValueRecordInterfaceArr3[row] = cellValueRecordInterfaceArr4;
        }
        if (column >= cellValueRecordInterfaceArr4.length) {
            int length2 = cellValueRecordInterfaceArr4.length * 2;
            int i7 = column + 1;
            if (length2 < i7) {
                length2 = i7;
            }
            CellValueRecordInterface[] cellValueRecordInterfaceArr5 = new CellValueRecordInterface[length2];
            System.arraycopy(cellValueRecordInterfaceArr4, 0, cellValueRecordInterfaceArr5, 0, cellValueRecordInterfaceArr4.length);
            this.records[row] = cellValueRecordInterfaceArr5;
            cellValueRecordInterfaceArr4 = cellValueRecordInterfaceArr5;
        }
        cellValueRecordInterfaceArr4[column] = cellValueRecordInterface;
        int i8 = this.firstcell;
        if (column < i8 || i8 == -1) {
            this.firstcell = column;
        }
        int i9 = this.lastcell;
        if (column > i9 || i9 == -1) {
            this.lastcell = column;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<CellValueRecordInterface> iterator() {
        return new ValueIterator();
    }

    public void removeAllCellsValuesForRow(int i5) {
        if (i5 < 0 || i5 > 65535) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Specified rowIndex ", " is outside the allowable range (0..65535)"));
        }
        CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
        if (i5 >= cellValueRecordInterfaceArr.length) {
            return;
        }
        cellValueRecordInterfaceArr[i5] = null;
    }

    public void removeCell(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface == null) {
            throw new IllegalArgumentException("cell must not be null");
        }
        int row = cellValueRecordInterface.getRow();
        CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
        if (row >= cellValueRecordInterfaceArr.length) {
            throw new RuntimeException("cell row is out of range");
        }
        CellValueRecordInterface[] cellValueRecordInterfaceArr2 = cellValueRecordInterfaceArr[row];
        if (cellValueRecordInterfaceArr2 == null) {
            throw new RuntimeException("cell row is already empty");
        }
        short column = cellValueRecordInterface.getColumn();
        if (column >= cellValueRecordInterfaceArr2.length) {
            throw new RuntimeException("cell column is out of range");
        }
        cellValueRecordInterfaceArr2[column] = null;
    }

    public boolean rowHasCells(int i5) {
        CellValueRecordInterface[] cellValueRecordInterfaceArr;
        CellValueRecordInterface[][] cellValueRecordInterfaceArr2 = this.records;
        if (i5 >= cellValueRecordInterfaceArr2.length || (cellValueRecordInterfaceArr = cellValueRecordInterfaceArr2[i5]) == null) {
            return false;
        }
        for (CellValueRecordInterface cellValueRecordInterface : cellValueRecordInterfaceArr) {
            if (cellValueRecordInterface != null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Spliterator<CellValueRecordInterface> spliterator() {
        return Spliterators.spliterator(iterator(), getPhysicalNumberOfCells(), 0);
    }

    public void updateFormulasAfterRowShift(FormulaShifter formulaShifter, int i5) {
        for (CellValueRecordInterface[] cellValueRecordInterfaceArr : this.records) {
            if (cellValueRecordInterfaceArr != null) {
                for (CellValueRecordInterface cellValueRecordInterface : cellValueRecordInterfaceArr) {
                    if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
                        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) cellValueRecordInterface;
                        Ptg[] formulaTokens = formulaRecordAggregate.getFormulaTokens();
                        formulaRecordAggregate.getFormulaRecord().getParsedExpression();
                        if (formulaShifter.adjustFormula(formulaTokens, i5)) {
                            formulaRecordAggregate.setParsedExpression(formulaTokens);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void visitCellsForRow(int i5, RecordAggregate.RecordVisitor recordVisitor) {
        CellValueRecordInterface[] cellValueRecordInterfaceArr = this.records[i5];
        if (cellValueRecordInterfaceArr == 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Row [", "] is empty"));
        }
        int i6 = 0;
        while (i6 < cellValueRecordInterfaceArr.length) {
            RecordBase recordBase = (RecordBase) cellValueRecordInterfaceArr[i6];
            if (recordBase != null) {
                int iCountBlanks = countBlanks(cellValueRecordInterfaceArr, i6);
                if (iCountBlanks > 1) {
                    recordVisitor.visitRecord(createMBR(cellValueRecordInterfaceArr, i6, iCountBlanks));
                    i6 += iCountBlanks - 1;
                } else if (recordBase instanceof RecordAggregate) {
                    ((RecordAggregate) recordBase).visitContainedRecords(recordVisitor);
                } else {
                    recordVisitor.visitRecord((Record) recordBase);
                }
            }
            i6++;
        }
    }

    private ValueRecordsAggregate(int i5, int i6, CellValueRecordInterface[][] cellValueRecordInterfaceArr) {
        this.firstcell = i5;
        this.lastcell = i6;
        this.records = cellValueRecordInterfaceArr;
    }
}
