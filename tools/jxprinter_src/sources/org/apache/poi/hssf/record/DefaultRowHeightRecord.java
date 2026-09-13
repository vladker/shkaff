package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultRowHeightRecord extends StandardRecord {
    public static final short DEFAULT_ROW_HEIGHT = 255;
    public static final short sid = 549;
    private short field_1_option_flags;
    private short field_2_row_height;

    public DefaultRowHeightRecord() {
        this.field_1_option_flags = (short) 0;
        this.field_2_row_height = (short) 255;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("optionFlags", new Supplier(this) { // from class: org.apache.poi.hssf.record.w
            public final /* synthetic */ DefaultRowHeightRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short optionFlags;
                switch (i5) {
                    case 0:
                        optionFlags = this.b.getOptionFlags();
                        break;
                    default:
                        optionFlags = this.b.getRowHeight();
                        break;
                }
                return Short.valueOf(optionFlags);
            }
        }, "rowHeight", new Supplier(this) { // from class: org.apache.poi.hssf.record.w
            public final /* synthetic */ DefaultRowHeightRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short optionFlags;
                switch (i6) {
                    case 0:
                        optionFlags = this.b.getOptionFlags();
                        break;
                    default:
                        optionFlags = this.b.getRowHeight();
                        break;
                }
                return Short.valueOf(optionFlags);
            }
        });
    }

    public short getOptionFlags() {
        return this.field_1_option_flags;
    }

    public short getRowHeight() {
        return this.field_2_row_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getOptionFlags());
        littleEndianOutput.writeShort(getRowHeight());
    }

    public void setOptionFlags(short s6) {
        this.field_1_option_flags = s6;
    }

    public void setRowHeight(short s6) {
        this.field_2_row_height = s6;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DEFAULT_ROW_HEIGHT;
    }

    public DefaultRowHeightRecord(DefaultRowHeightRecord defaultRowHeightRecord) {
        super(defaultRowHeightRecord);
        this.field_1_option_flags = defaultRowHeightRecord.field_1_option_flags;
        this.field_2_row_height = defaultRowHeightRecord.field_2_row_height;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DefaultRowHeightRecord copy() {
        return new DefaultRowHeightRecord(this);
    }

    public DefaultRowHeightRecord(RecordInputStream recordInputStream) {
        this.field_1_option_flags = recordInputStream.readShort();
        this.field_2_row_height = recordInputStream.readShort();
    }
}
