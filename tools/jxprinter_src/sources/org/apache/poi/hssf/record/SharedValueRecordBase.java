package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SharedValueRecordBase extends StandardRecord {
    private CellRangeAddress8Bit _range;

    public SharedValueRecordBase(SharedValueRecordBase sharedValueRecordBase) {
        super(sharedValueRecordBase);
        CellRangeAddress8Bit cellRangeAddress8Bit = sharedValueRecordBase._range;
        this._range = cellRangeAddress8Bit == null ? null : cellRangeAddress8Bit.copy();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return getExtraDataSize() + 6;
    }

    public abstract int getExtraDataSize();

    public final int getFirstColumn() {
        return (short) this._range.getFirstColumn();
    }

    public final int getFirstRow() {
        return this._range.getFirstRow();
    }

    public final int getLastColumn() {
        return (short) this._range.getLastColumn();
    }

    public final int getLastRow() {
        return this._range.getLastRow();
    }

    public final CellRangeAddress8Bit getRange() {
        return this._range;
    }

    public final boolean isFirstCell(int i5, int i6) {
        CellRangeAddress8Bit range = getRange();
        return range.getFirstRow() == i5 && range.getFirstColumn() == i6;
    }

    public final boolean isInRange(int i5, int i6) {
        CellRangeAddress8Bit cellRangeAddress8Bit = this._range;
        return cellRangeAddress8Bit.getFirstRow() <= i5 && cellRangeAddress8Bit.getLastRow() >= i5 && cellRangeAddress8Bit.getFirstColumn() <= i6 && cellRangeAddress8Bit.getLastColumn() >= i6;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this._range.serialize(littleEndianOutput);
        serializeExtraData(littleEndianOutput);
    }

    public abstract void serializeExtraData(LittleEndianOutput littleEndianOutput);

    public SharedValueRecordBase(CellRangeAddress8Bit cellRangeAddress8Bit) {
        if (cellRangeAddress8Bit != null) {
            this._range = cellRangeAddress8Bit;
            return;
        }
        throw new IllegalArgumentException("range must be supplied.");
    }

    public SharedValueRecordBase() {
        this(new CellRangeAddress8Bit(0, 0, 0, 0));
    }

    public SharedValueRecordBase(LittleEndianInput littleEndianInput) {
        this._range = new CellRangeAddress8Bit(littleEndianInput);
    }
}
