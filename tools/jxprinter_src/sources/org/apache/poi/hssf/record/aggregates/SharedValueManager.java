package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.SharedValueRecordBase;
import org.apache.poi.hssf.record.TableRecord;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SharedValueManager {
    private final List<ArrayRecord> _arrayRecords;
    private final Map<SharedFormulaRecord, SharedFormulaGroup> _groupsBySharedFormulaRecord;
    private Map<Integer, SharedFormulaGroup> _groupsCache;
    private final TableRecord[] _tableRecords;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SharedFormulaGroup {
        private final CellReference _firstCell;
        private final FormulaRecordAggregate[] _frAggs;
        private int _numberOfFormulas;
        private final SharedFormulaRecord _sfr;

        public SharedFormulaGroup(SharedFormulaRecord sharedFormulaRecord, CellReference cellReference) {
            if (sharedFormulaRecord.isInRange(cellReference.getRow(), cellReference.getCol())) {
                this._sfr = sharedFormulaRecord;
                this._firstCell = cellReference;
                this._frAggs = new FormulaRecordAggregate[((sharedFormulaRecord.getLastRow() - sharedFormulaRecord.getFirstRow()) + 1) * ((sharedFormulaRecord.getLastColumn() - sharedFormulaRecord.getFirstColumn()) + 1)];
                this._numberOfFormulas = 0;
                return;
            }
            throw new IllegalArgumentException("First formula cell " + cellReference.formatAsString() + " is not shared formula range " + sharedFormulaRecord.getRange() + Consts.DOT);
        }

        public void add(FormulaRecordAggregate formulaRecordAggregate) {
            if (this._numberOfFormulas == 0 && (this._firstCell.getRow() != formulaRecordAggregate.getRow() || this._firstCell.getCol() != formulaRecordAggregate.getColumn())) {
                throw new IllegalStateException("shared formula coding error: " + ((int) this._firstCell.getCol()) + '/' + this._firstCell.getRow() + " != " + ((int) formulaRecordAggregate.getColumn()) + '/' + formulaRecordAggregate.getRow());
            }
            int i5 = this._numberOfFormulas;
            FormulaRecordAggregate[] formulaRecordAggregateArr = this._frAggs;
            if (i5 < formulaRecordAggregateArr.length) {
                this._numberOfFormulas = i5 + 1;
                formulaRecordAggregateArr[i5] = formulaRecordAggregate;
            } else {
                throw new IllegalStateException("Too many formula records for shared formula group: " + this._numberOfFormulas + ", expecting less than " + this._frAggs.length);
            }
        }

        public SharedFormulaRecord getSFR() {
            return this._sfr;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            androidx.collection.a.w(SharedFormulaGroup.class, sb, " [");
            sb.append(this._sfr.getRange());
            sb.append("]");
            return sb.toString();
        }

        public void unlinkSharedFormulas() {
            for (int i5 = 0; i5 < this._numberOfFormulas; i5++) {
                this._frAggs[i5].unlinkSharedFormula();
            }
        }
    }

    private SharedValueManager(SharedFormulaRecord[] sharedFormulaRecordArr, CellReference[] cellReferenceArr, ArrayRecord[] arrayRecordArr, TableRecord[] tableRecordArr) {
        int length = sharedFormulaRecordArr.length;
        if (length != cellReferenceArr.length) {
            throw new IllegalArgumentException(AbstractC0157z.l(Consts.DOT, cellReferenceArr.length, AbstractC0157z.t(length, "array sizes don't match: ", "!=")));
        }
        this._arrayRecords = toList(arrayRecordArr);
        this._tableRecords = tableRecordArr;
        HashMap map = new HashMap((length * 3) / 2);
        for (int i5 = 0; i5 < length; i5++) {
            SharedFormulaRecord sharedFormulaRecord = sharedFormulaRecordArr[i5];
            map.put(sharedFormulaRecord, new SharedFormulaGroup(sharedFormulaRecord, cellReferenceArr[i5]));
        }
        this._groupsBySharedFormulaRecord = map;
    }

    public static SharedValueManager create(SharedFormulaRecord[] sharedFormulaRecordArr, CellReference[] cellReferenceArr, ArrayRecord[] arrayRecordArr, TableRecord[] tableRecordArr) {
        return ((sharedFormulaRecordArr.length + cellReferenceArr.length) + arrayRecordArr.length) + tableRecordArr.length < 1 ? createEmpty() : new SharedValueManager(sharedFormulaRecordArr, cellReferenceArr, arrayRecordArr, tableRecordArr);
    }

    public static SharedValueManager createEmpty() {
        return new SharedValueManager(new SharedFormulaRecord[0], new CellReference[0], new ArrayRecord[0], new TableRecord[0]);
    }

    private SharedFormulaGroup findFormulaGroupForCell(CellReference cellReference) {
        if (this._groupsCache == null) {
            this._groupsCache = new HashMap(this._groupsBySharedFormulaRecord.size());
            for (SharedFormulaGroup sharedFormulaGroup : this._groupsBySharedFormulaRecord.values()) {
                this._groupsCache.put(getKeyForCache(sharedFormulaGroup._firstCell), sharedFormulaGroup);
            }
        }
        return this._groupsCache.get(getKeyForCache(cellReference));
    }

    private Integer getKeyForCache(CellReference cellReference) {
        return Integer.valueOf(cellReference.getRow() | ((cellReference.getCol() + 1) << 16));
    }

    private static <Z> List<Z> toList(Z[] zArr) {
        ArrayList arrayList = new ArrayList(zArr.length);
        Collections.addAll(arrayList, zArr);
        return arrayList;
    }

    public void addArrayRecord(ArrayRecord arrayRecord) {
        this._arrayRecords.add(arrayRecord);
    }

    public ArrayRecord getArrayRecord(int i5, int i6) {
        for (ArrayRecord arrayRecord : this._arrayRecords) {
            if (arrayRecord.isFirstCell(i5, i6)) {
                return arrayRecord;
            }
        }
        return null;
    }

    public SharedValueRecordBase getRecordForFirstCell(FormulaRecordAggregate formulaRecordAggregate) {
        SharedFormulaGroup sharedFormulaGroupFindFormulaGroupForCell;
        CellReference expReference = formulaRecordAggregate.getFormulaRecord().getFormula().getExpReference();
        if (expReference == null) {
            return null;
        }
        int row = expReference.getRow();
        short col = expReference.getCol();
        if (formulaRecordAggregate.getRow() == row && formulaRecordAggregate.getColumn() == col) {
            if (!this._groupsBySharedFormulaRecord.isEmpty() && (sharedFormulaGroupFindFormulaGroupForCell = findFormulaGroupForCell(expReference)) != null) {
                return sharedFormulaGroupFindFormulaGroupForCell.getSFR();
            }
            for (TableRecord tableRecord : this._tableRecords) {
                if (tableRecord.isFirstCell(row, col)) {
                    return tableRecord;
                }
            }
            for (ArrayRecord arrayRecord : this._arrayRecords) {
                if (arrayRecord.isFirstCell(row, col)) {
                    return arrayRecord;
                }
            }
        }
        return null;
    }

    public SharedFormulaRecord linkSharedFormulaRecord(CellReference cellReference, FormulaRecordAggregate formulaRecordAggregate) {
        SharedFormulaGroup sharedFormulaGroupFindFormulaGroupForCell = findFormulaGroupForCell(cellReference);
        if (sharedFormulaGroupFindFormulaGroupForCell != null) {
            sharedFormulaGroupFindFormulaGroupForCell.add(formulaRecordAggregate);
            return sharedFormulaGroupFindFormulaGroupForCell.getSFR();
        }
        throw new IllegalArgumentException("Failed to find a matching shared formula record for cell: " + cellReference);
    }

    public CellRangeAddress8Bit removeArrayFormula(int i5, int i6) {
        for (ArrayRecord arrayRecord : this._arrayRecords) {
            if (arrayRecord.isInRange(i5, i6)) {
                this._arrayRecords.remove(arrayRecord);
                return arrayRecord.getRange();
            }
        }
        throw new IllegalArgumentException(AbstractC0157z.o("Specified cell ", new CellReference(i5, i6, false, false).formatAsString(), " is not part of an array formula."));
    }

    public void unlink(SharedFormulaRecord sharedFormulaRecord) {
        SharedFormulaGroup sharedFormulaGroupRemove = this._groupsBySharedFormulaRecord.remove(sharedFormulaRecord);
        if (sharedFormulaGroupRemove == null) {
            throw new IllegalStateException("Failed to find formulas for shared formula");
        }
        this._groupsCache = null;
        sharedFormulaGroupRemove.unlinkSharedFormulas();
    }
}
