package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class GutsRecord extends StandardRecord {
    public static final short sid = 128;
    private short field_1_left_row_gutter;
    private short field_2_top_col_gutter;
    private short field_3_row_level_max;
    private short field_4_col_level_max;

    public GutsRecord() {
    }

    public short getColLevelMax() {
        return this.field_4_col_level_max;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.U
            public final /* synthetic */ GutsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short leftRowGutter;
                switch (i5) {
                    case 0:
                        leftRowGutter = this.b.getLeftRowGutter();
                        break;
                    case 1:
                        leftRowGutter = this.b.getTopColGutter();
                        break;
                    case 2:
                        leftRowGutter = this.b.getRowLevelMax();
                        break;
                    default:
                        leftRowGutter = this.b.getColLevelMax();
                        break;
                }
                return Short.valueOf(leftRowGutter);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.U
            public final /* synthetic */ GutsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short leftRowGutter;
                switch (i6) {
                    case 0:
                        leftRowGutter = this.b.getLeftRowGutter();
                        break;
                    case 1:
                        leftRowGutter = this.b.getTopColGutter();
                        break;
                    case 2:
                        leftRowGutter = this.b.getRowLevelMax();
                        break;
                    default:
                        leftRowGutter = this.b.getColLevelMax();
                        break;
                }
                return Short.valueOf(leftRowGutter);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.U
            public final /* synthetic */ GutsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short leftRowGutter;
                switch (i7) {
                    case 0:
                        leftRowGutter = this.b.getLeftRowGutter();
                        break;
                    case 1:
                        leftRowGutter = this.b.getTopColGutter();
                        break;
                    case 2:
                        leftRowGutter = this.b.getRowLevelMax();
                        break;
                    default:
                        leftRowGutter = this.b.getColLevelMax();
                        break;
                }
                return Short.valueOf(leftRowGutter);
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("leftGutter", supplier, "topGutter", supplier2, "rowLevelMax", supplier3, "colLevelMax", new Supplier(this) { // from class: org.apache.poi.hssf.record.U
            public final /* synthetic */ GutsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short leftRowGutter;
                switch (i8) {
                    case 0:
                        leftRowGutter = this.b.getLeftRowGutter();
                        break;
                    case 1:
                        leftRowGutter = this.b.getTopColGutter();
                        break;
                    case 2:
                        leftRowGutter = this.b.getRowLevelMax();
                        break;
                    default:
                        leftRowGutter = this.b.getColLevelMax();
                        break;
                }
                return Short.valueOf(leftRowGutter);
            }
        });
    }

    public short getLeftRowGutter() {
        return this.field_1_left_row_gutter;
    }

    public short getRowLevelMax() {
        return this.field_3_row_level_max;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 128;
    }

    public short getTopColGutter() {
        return this.field_2_top_col_gutter;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getLeftRowGutter());
        littleEndianOutput.writeShort(getTopColGutter());
        littleEndianOutput.writeShort(getRowLevelMax());
        littleEndianOutput.writeShort(getColLevelMax());
    }

    public void setColLevelMax(short s6) {
        this.field_4_col_level_max = s6;
    }

    public void setLeftRowGutter(short s6) {
        this.field_1_left_row_gutter = s6;
    }

    public void setRowLevelMax(short s6) {
        this.field_3_row_level_max = s6;
    }

    public void setTopColGutter(short s6) {
        this.field_2_top_col_gutter = s6;
    }

    public GutsRecord(GutsRecord gutsRecord) {
        super(gutsRecord);
        this.field_1_left_row_gutter = gutsRecord.field_1_left_row_gutter;
        this.field_2_top_col_gutter = gutsRecord.field_2_top_col_gutter;
        this.field_3_row_level_max = gutsRecord.field_3_row_level_max;
        this.field_4_col_level_max = gutsRecord.field_4_col_level_max;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.GUTS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public GutsRecord copy() {
        return new GutsRecord(this);
    }

    public GutsRecord(RecordInputStream recordInputStream) {
        this.field_1_left_row_gutter = recordInputStream.readShort();
        this.field_2_top_col_gutter = recordInputStream.readShort();
        this.field_3_row_level_max = recordInputStream.readShort();
        this.field_4_col_level_max = recordInputStream.readShort();
    }
}
