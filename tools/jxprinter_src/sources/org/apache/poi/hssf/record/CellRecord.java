package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CellRecord extends StandardRecord implements CellValueRecordInterface {
    private int _columnIndex;
    private int _formatIndex;
    private int _rowIndex;

    public CellRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public abstract CellRecord copy();

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getColumn() {
        return (short) this._columnIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final int getDataSize() {
        return getValueDataSize() + 6;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.n
            public final /* synthetic */ CellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.n
            public final /* synthetic */ CellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("row", supplier, "col", supplier2, "xfIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.n
            public final /* synthetic */ CellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
    }

    public abstract String getRecordName();

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final int getRow() {
        return this._rowIndex;
    }

    public abstract int getValueDataSize();

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getXFIndex() {
        return (short) this._formatIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRow());
        littleEndianOutput.writeShort(getColumn());
        littleEndianOutput.writeShort(getXFIndex());
        serializeValue(littleEndianOutput);
    }

    public abstract void serializeValue(LittleEndianOutput littleEndianOutput);

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setColumn(short s6) {
        this._columnIndex = s6;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setRow(int i5) {
        this._rowIndex = i5;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setXFIndex(short s6) {
        this._formatIndex = s6;
    }

    public CellRecord(CellRecord cellRecord) {
        super(cellRecord);
        this._rowIndex = cellRecord.getRow();
        this._columnIndex = cellRecord.getColumn();
        this._formatIndex = cellRecord.getXFIndex();
    }

    public CellRecord(RecordInputStream recordInputStream) {
        this._rowIndex = recordInputStream.readUShort();
        this._columnIndex = recordInputStream.readUShort();
        this._formatIndex = recordInputStream.readUShort();
    }
}
