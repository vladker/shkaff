package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BlankRecord extends StandardRecord implements CellValueRecordInterface {
    public static final short sid = 513;
    private int field_1_row;
    private short field_2_col;
    private short field_3_xf;

    public BlankRecord() {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_col;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.d
            public final /* synthetic */ BlankRecord b;

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
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.d
            public final /* synthetic */ BlankRecord b;

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
        return GenericRecordUtil.getGenericProperties("row", supplier, "col", supplier2, "xfIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.d
            public final /* synthetic */ BlankRecord b;

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

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRow());
        littleEndianOutput.writeShort(getColumn());
        littleEndianOutput.writeShort(getXFIndex());
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setColumn(short s6) {
        this.field_2_col = s6;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setRow(int i5) {
        this.field_1_row = i5;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setXFIndex(short s6) {
        this.field_3_xf = s6;
    }

    public BlankRecord(BlankRecord blankRecord) {
        super(blankRecord);
        this.field_1_row = blankRecord.field_1_row;
        this.field_2_col = blankRecord.field_2_col;
        this.field_3_xf = blankRecord.field_3_xf;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BLANK;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public BlankRecord copy() {
        return new BlankRecord(this);
    }

    public BlankRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_col = recordInputStream.readShort();
        this.field_3_xf = recordInputStream.readShort();
    }
}
