package org.apache.poi.hssf.record.aggregates;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MergedCellsTable extends RecordAggregate {
    private static final int MAX_MERGED_REGIONS = 1027;
    private final List<CellRangeAddress> _mergedRegions = new ArrayList();

    private void addMergeCellsRecord(MergeCellsRecord mergeCellsRecord) {
        short numAreas = mergeCellsRecord.getNumAreas();
        for (int i5 = 0; i5 < numAreas; i5++) {
            this._mergedRegions.add(mergeCellsRecord.getAreaAt(i5));
        }
    }

    private void checkIndex(int i5) {
        if (i5 < 0 || i5 >= this._mergedRegions.size()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified CF index ", " is outside the allowable range (0..");
            sbT.append(this._mergedRegions.size() - 1);
            sbT.append(")");
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    public void addArea(int i5, int i6, int i7, int i8) {
        this._mergedRegions.add(new CellRangeAddress(i5, i7, i6, i8));
    }

    public void addRecords(MergeCellsRecord[] mergeCellsRecordArr) {
        for (MergeCellsRecord mergeCellsRecord : mergeCellsRecordArr) {
            addMergeCellsRecord(mergeCellsRecord);
        }
    }

    public CellRangeAddress get(int i5) {
        checkIndex(i5);
        return this._mergedRegions.get(i5);
    }

    public int getNumberOfMergedRegions() {
        return this._mergedRegions.size();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        int size = this._mergedRegions.size();
        if (size < 1) {
            return 0;
        }
        int i5 = size / MAX_MERGED_REGIONS;
        int i6 = size % MAX_MERGED_REGIONS;
        return CellRangeAddressList.getEncodedSize(i6) + ((CellRangeAddressList.getEncodedSize(MAX_MERGED_REGIONS) + 4) * i5) + 4;
    }

    public void read(RecordStream recordStream) {
        while (recordStream.peekNextClass() == MergeCellsRecord.class) {
            MergeCellsRecord mergeCellsRecord = (MergeCellsRecord) recordStream.getNext();
            short numAreas = mergeCellsRecord.getNumAreas();
            for (int i5 = 0; i5 < numAreas; i5++) {
                this._mergedRegions.add(mergeCellsRecord.getAreaAt(i5));
            }
        }
    }

    public void remove(int i5) {
        checkIndex(i5);
        this._mergedRegions.remove(i5);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        int size = this._mergedRegions.size();
        if (size < 1) {
            return;
        }
        int i5 = size / MAX_MERGED_REGIONS;
        int i6 = size % MAX_MERGED_REGIONS;
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[size];
        this._mergedRegions.toArray(cellRangeAddressArr);
        for (int i7 = 0; i7 < i5; i7++) {
            recordVisitor.visitRecord(new MergeCellsRecord(cellRangeAddressArr, i7 * MAX_MERGED_REGIONS, MAX_MERGED_REGIONS));
        }
        if (i6 > 0) {
            recordVisitor.visitRecord(new MergeCellsRecord(cellRangeAddressArr, i5 * MAX_MERGED_REGIONS, i6));
        }
    }
}
