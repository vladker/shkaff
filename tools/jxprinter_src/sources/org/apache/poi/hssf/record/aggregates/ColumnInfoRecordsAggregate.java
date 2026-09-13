package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import com.google.android.material.color.utilities.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.ddf.l;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.ColumnInfoRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ColumnInfoRecordsAggregate extends RecordAggregate implements Duplicatable {
    private final List<ColumnInfoRecord> records;

    public ColumnInfoRecordsAggregate() {
        this.records = new ArrayList();
    }

    private void attemptMergeColInfoRecords(int i5) {
        int size = this.records.size();
        if (i5 < 0 || i5 >= size) {
            StringBuilder sbT = AbstractC0157z.t(i5, "colInfoIx ", " is out of range (0..");
            sbT.append(size - 1);
            sbT.append(")");
            throw new IllegalArgumentException(sbT.toString());
        }
        ColumnInfoRecord colInfo = getColInfo(i5);
        int i6 = i5 + 1;
        if (i6 < size && mergeColInfoRecords(colInfo, getColInfo(i6))) {
            this.records.remove(i6);
        }
        if (i5 <= 0 || !mergeColInfoRecords(getColInfo(i5 - 1), colInfo)) {
            return;
        }
        this.records.remove(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareColInfos(ColumnInfoRecord columnInfoRecord, ColumnInfoRecord columnInfoRecord2) {
        return columnInfoRecord.getFirstColumn() - columnInfoRecord2.getFirstColumn();
    }

    private static ColumnInfoRecord copyColInfo(ColumnInfoRecord columnInfoRecord) {
        return columnInfoRecord.copy();
    }

    private int findColInfoIdx(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "column parameter out of range: "));
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "fromIdx parameter out of range: "));
        }
        while (i6 < this.records.size()) {
            ColumnInfoRecord colInfo = getColInfo(i6);
            if (colInfo.containsColumn(i5)) {
                return i6;
            }
            if (colInfo.getFirstColumn() > i5) {
                return -1;
            }
            i6++;
        }
        return -1;
    }

    private int findEndOfColumnOutlineGroup(int i5) {
        ColumnInfoRecord columnInfoRecord = this.records.get(i5);
        int outlineLevel = columnInfoRecord.getOutlineLevel();
        while (i5 < this.records.size() - 1) {
            int i6 = i5 + 1;
            ColumnInfoRecord columnInfoRecord2 = this.records.get(i6);
            if (!columnInfoRecord.isAdjacentBefore(columnInfoRecord2) || columnInfoRecord2.getOutlineLevel() < outlineLevel) {
                break;
            }
            columnInfoRecord = columnInfoRecord2;
            i5 = i6;
        }
        return i5;
    }

    private int findStartOfColumnOutlineGroup(int i5) {
        ColumnInfoRecord columnInfoRecord = this.records.get(i5);
        int outlineLevel = columnInfoRecord.getOutlineLevel();
        while (i5 != 0) {
            ColumnInfoRecord columnInfoRecord2 = this.records.get(i5 - 1);
            if (!columnInfoRecord2.isAdjacentBefore(columnInfoRecord) || columnInfoRecord2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i5--;
            columnInfoRecord = columnInfoRecord2;
        }
        return i5;
    }

    private ColumnInfoRecord getColInfo(int i5) {
        return this.records.get(i5);
    }

    private boolean isColumnGroupCollapsed(int i5) {
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i5);
        int i6 = iFindEndOfColumnOutlineGroup + 1;
        if (i6 >= this.records.size()) {
            return false;
        }
        ColumnInfoRecord colInfo = getColInfo(i6);
        if (getColInfo(iFindEndOfColumnOutlineGroup).isAdjacentBefore(colInfo)) {
            return colInfo.getCollapsed();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0047  */
    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    private boolean isColumnGroupHiddenByParent(int i5) {
        int outlineLevel;
        boolean hidden;
        boolean hidden2;
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i5);
        int outlineLevel2 = 0;
        if (iFindEndOfColumnOutlineGroup < this.records.size()) {
            ColumnInfoRecord colInfo = getColInfo(iFindEndOfColumnOutlineGroup + 1);
            if (getColInfo(iFindEndOfColumnOutlineGroup).isAdjacentBefore(colInfo)) {
                outlineLevel = colInfo.getOutlineLevel();
                hidden = colInfo.getHidden();
            } else {
                outlineLevel = 0;
                hidden = false;
            }
        } else {
            outlineLevel = 0;
            hidden = false;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(i5);
        if (iFindStartOfColumnOutlineGroup > 0) {
            ColumnInfoRecord colInfo2 = getColInfo(iFindStartOfColumnOutlineGroup - 1);
            if (colInfo2.isAdjacentBefore(getColInfo(iFindStartOfColumnOutlineGroup))) {
                outlineLevel2 = colInfo2.getOutlineLevel();
                hidden2 = colInfo2.getHidden();
            } else {
                hidden2 = false;
            }
        } else {
            hidden2 = false;
        }
        return outlineLevel > outlineLevel2 ? hidden : hidden2;
    }

    private static boolean mergeColInfoRecords(ColumnInfoRecord columnInfoRecord, ColumnInfoRecord columnInfoRecord2) {
        if (!columnInfoRecord.isAdjacentBefore(columnInfoRecord2) || !columnInfoRecord.formatMatches(columnInfoRecord2)) {
            return false;
        }
        columnInfoRecord.setLastColumn(columnInfoRecord2.getLastColumn());
        return true;
    }

    private static void setColumnInfoFields(ColumnInfoRecord columnInfoRecord, Short sh, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        if (sh != null) {
            columnInfoRecord.setXFIndex(sh.shortValue());
        }
        if (num != null) {
            columnInfoRecord.setColumnWidth(num.intValue());
        }
        if (num2 != null) {
            columnInfoRecord.setOutlineLevel(num2.shortValue());
        }
        if (bool != null) {
            columnInfoRecord.setHidden(bool.booleanValue());
        }
        if (bool2 != null) {
            columnInfoRecord.setCollapsed(bool2.booleanValue());
        }
    }

    private int setGroupHidden(int i5, int i6, boolean z6) {
        ColumnInfoRecord colInfo = getColInfo(i5);
        while (i5 < this.records.size()) {
            colInfo.setHidden(z6);
            i5++;
            if (i5 < this.records.size()) {
                ColumnInfoRecord colInfo2 = getColInfo(i5);
                if (!colInfo.isAdjacentBefore(colInfo2) || colInfo2.getOutlineLevel() < i6) {
                    break;
                }
                colInfo = colInfo2;
            }
        }
        return colInfo.getLastColumn();
    }

    public void collapseColumn(int i5) {
        int iFindColInfoIdx = findColInfoIdx(i5, 0);
        if (iFindColInfoIdx == -1) {
            return;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(iFindColInfoIdx);
        setColumn(setGroupHidden(iFindStartOfColumnOutlineGroup, getColInfo(iFindStartOfColumnOutlineGroup).getOutlineLevel(), true) + 1, null, null, null, null, Boolean.TRUE);
    }

    public void expandColumn(int i5) {
        int iFindColInfoIdx = findColInfoIdx(i5, 0);
        if (iFindColInfoIdx != -1 && isColumnGroupCollapsed(iFindColInfoIdx)) {
            int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(iFindColInfoIdx);
            ColumnInfoRecord colInfo = getColInfo(iFindEndOfColumnOutlineGroup);
            if (!isColumnGroupHiddenByParent(iFindColInfoIdx)) {
                int outlineLevel = colInfo.getOutlineLevel();
                for (int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(iFindColInfoIdx); iFindStartOfColumnOutlineGroup <= iFindEndOfColumnOutlineGroup; iFindStartOfColumnOutlineGroup++) {
                    ColumnInfoRecord colInfo2 = getColInfo(iFindStartOfColumnOutlineGroup);
                    if (outlineLevel == colInfo2.getOutlineLevel()) {
                        colInfo2.setHidden(false);
                    }
                }
            }
            setColumn(colInfo.getLastColumn() + 1, null, null, null, null, Boolean.FALSE);
        }
    }

    public ColumnInfoRecord findColumnInfo(int i5) {
        int size = this.records.size();
        for (int i6 = 0; i6 < size; i6++) {
            ColumnInfoRecord colInfo = getColInfo(i6);
            if (colInfo.containsColumn(i5)) {
                return colInfo;
            }
        }
        return null;
    }

    public int getMaxColumnIndex() {
        if (this.records.isEmpty()) {
            return 0;
        }
        int size = this.records.size();
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            iMax = Math.max(iMax, getColInfo(i5).getLastColumn());
        }
        return iMax;
    }

    public int getMaxOutlineLevel() {
        int size = this.records.size();
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            iMax = Math.max(getColInfo(i5).getOutlineLevel(), iMax);
        }
        return iMax;
    }

    public int getMinColumnIndex() {
        if (this.records.isEmpty()) {
            return 0;
        }
        int size = this.records.size();
        int iMin = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            iMin = Math.min(iMin, getColInfo(i5).getFirstColumn());
        }
        return iMin;
    }

    public int getNumColumns() {
        return this.records.size();
    }

    public int getOutlineLevel(int i5) {
        ColumnInfoRecord columnInfoRecordFindColumnInfo = findColumnInfo(i5);
        if (columnInfoRecordFindColumnInfo != null) {
            return columnInfoRecordFindColumnInfo.getOutlineLevel();
        }
        return 0;
    }

    public void groupColumnRange(int i5, int i6, boolean z6) {
        int iMax;
        int iMin;
        int i7 = i5;
        int i8 = 0;
        while (i7 <= i6) {
            int iFindColInfoIdx = findColInfoIdx(i7, i8);
            if (iFindColInfoIdx != -1) {
                int outlineLevel = getColInfo(iFindColInfoIdx).getOutlineLevel();
                iMin = Math.min(7, Math.max(0, z6 ? outlineLevel + 1 : outlineLevel - 1));
                iMax = Math.max(0, iFindColInfoIdx - 1);
            } else {
                iMax = i8;
                iMin = 1;
            }
            setColumn(i7, null, null, Integer.valueOf(iMin), null, null);
            i7++;
            i8 = iMax;
        }
    }

    public void insertColumn(ColumnInfoRecord columnInfoRecord) {
        this.records.add(columnInfoRecord);
        this.records.sort(new I4.a(25));
    }

    public void setColumn(int i5, Short sh, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        ColumnInfoRecord columnInfoRecord;
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            if (i6 < this.records.size()) {
                columnInfoRecord = this.records.get(i6);
                if (columnInfoRecord.containsColumn(i5)) {
                    break;
                } else if (columnInfoRecord.getFirstColumn() <= i5) {
                    i6++;
                }
            }
            columnInfoRecord = null;
            break;
        }
        ColumnInfoRecord columnInfoRecord2 = columnInfoRecord;
        if (columnInfoRecord2 == null) {
            ColumnInfoRecord columnInfoRecord3 = new ColumnInfoRecord();
            columnInfoRecord3.setFirstColumn(i5);
            columnInfoRecord3.setLastColumn(i5);
            setColumnInfoFields(columnInfoRecord3, sh, num, num2, bool, bool2);
            insertColumn(i6, columnInfoRecord3);
            attemptMergeColInfoRecords(i6);
            return;
        }
        boolean z7 = (sh == null || columnInfoRecord2.getXFIndex() == sh.shortValue()) ? false : true;
        boolean z8 = (num == null || columnInfoRecord2.getColumnWidth() == num.shortValue()) ? false : true;
        boolean z9 = (num2 == null || columnInfoRecord2.getOutlineLevel() == num2.intValue()) ? false : true;
        boolean z10 = (bool == null || columnInfoRecord2.getHidden() == bool.booleanValue()) ? false : true;
        if (bool2 != null && columnInfoRecord2.getCollapsed() != bool2.booleanValue()) {
            z6 = true;
        }
        if (z7 || z8 || z9 || z10 || z6) {
            if (columnInfoRecord2.getFirstColumn() == i5 && columnInfoRecord2.getLastColumn() == i5) {
                setColumnInfoFields(columnInfoRecord2, sh, num, num2, bool, bool2);
                attemptMergeColInfoRecords(i6);
                return;
            }
            if (columnInfoRecord2.getFirstColumn() == i5 || columnInfoRecord2.getLastColumn() == i5) {
                if (columnInfoRecord2.getFirstColumn() == i5) {
                    columnInfoRecord2.setFirstColumn(i5 + 1);
                } else {
                    columnInfoRecord2.setLastColumn(i5 - 1);
                    i6++;
                }
                ColumnInfoRecord columnInfoRecordCopyColInfo = copyColInfo(columnInfoRecord2);
                columnInfoRecordCopyColInfo.setFirstColumn(i5);
                columnInfoRecordCopyColInfo.setLastColumn(i5);
                setColumnInfoFields(columnInfoRecordCopyColInfo, sh, num, num2, bool, bool2);
                insertColumn(i6, columnInfoRecordCopyColInfo);
                attemptMergeColInfoRecords(i6);
                return;
            }
            ColumnInfoRecord columnInfoRecordCopyColInfo2 = copyColInfo(columnInfoRecord2);
            ColumnInfoRecord columnInfoRecordCopyColInfo3 = copyColInfo(columnInfoRecord2);
            int lastColumn = columnInfoRecord2.getLastColumn();
            columnInfoRecord2.setLastColumn(i5 - 1);
            columnInfoRecordCopyColInfo2.setFirstColumn(i5);
            columnInfoRecordCopyColInfo2.setLastColumn(i5);
            setColumnInfoFields(columnInfoRecordCopyColInfo2, sh, num, num2, bool, bool2);
            insertColumn(i6 + 1, columnInfoRecordCopyColInfo2);
            columnInfoRecordCopyColInfo3.setFirstColumn(i5 + 1);
            columnInfoRecordCopyColInfo3.setLastColumn(lastColumn);
            insertColumn(i6 + 2, columnInfoRecordCopyColInfo3);
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        if (this.records.size() < 1) {
            return;
        }
        ColumnInfoRecord columnInfoRecord = null;
        for (ColumnInfoRecord columnInfoRecord2 : this.records) {
            recordVisitor.visitRecord(columnInfoRecord2);
            if (columnInfoRecord != null && compareColInfos(columnInfoRecord, columnInfoRecord2) > 0) {
                throw new RuntimeException("Column info records are out of order");
            }
            columnInfoRecord = columnInfoRecord2;
        }
    }

    @Override // org.apache.poi.common.Duplicatable
    public ColumnInfoRecordsAggregate copy() {
        return new ColumnInfoRecordsAggregate(this);
    }

    public ColumnInfoRecordsAggregate(ColumnInfoRecordsAggregate columnInfoRecordsAggregate) {
        ArrayList arrayList = new ArrayList();
        this.records = arrayList;
        columnInfoRecordsAggregate.records.stream().map(new g(15)).forEach(new l(arrayList, 5));
    }

    private void insertColumn(int i5, ColumnInfoRecord columnInfoRecord) {
        this.records.add(i5, columnInfoRecord);
    }

    public ColumnInfoRecordsAggregate(RecordStream recordStream) {
        this();
        ColumnInfoRecord columnInfoRecord = null;
        boolean z6 = true;
        while (recordStream.peekNextClass() == ColumnInfoRecord.class) {
            ColumnInfoRecord columnInfoRecord2 = (ColumnInfoRecord) recordStream.getNext();
            this.records.add(columnInfoRecord2);
            if (columnInfoRecord != null && compareColInfos(columnInfoRecord, columnInfoRecord2) > 0) {
                z6 = false;
            }
            columnInfoRecord = columnInfoRecord2;
        }
        if (this.records.size() < 1) {
            throw new RuntimeException("No column info records found");
        }
        if (z6) {
            return;
        }
        this.records.sort(new I4.a(25));
    }
}
