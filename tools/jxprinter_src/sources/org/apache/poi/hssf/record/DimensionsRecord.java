package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DimensionsRecord extends StandardRecord {
    private static final Logger LOG = LogManager.getLogger((Class<?>) DimensionsRecord.class);
    public static final short sid = 512;
    private int field_1_first_row;
    private int field_2_last_row;
    private short field_3_first_col;
    private short field_4_last_col;
    private short field_5_zero;

    public DimensionsRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Short.valueOf(this.field_5_zero);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 14;
    }

    public short getFirstCol() {
        return this.field_3_first_col;
    }

    public int getFirstRow() {
        return this.field_1_first_row;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.x
            public final /* synthetic */ DimensionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Short.valueOf(this.b.getFirstCol());
                    case 3:
                        return Short.valueOf(this.b.getLastCol());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.x
            public final /* synthetic */ DimensionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Short.valueOf(this.b.getFirstCol());
                    case 3:
                        return Short.valueOf(this.b.getLastCol());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.x
            public final /* synthetic */ DimensionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Short.valueOf(this.b.getFirstCol());
                    case 3:
                        return Short.valueOf(this.b.getLastCol());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.x
            public final /* synthetic */ DimensionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Short.valueOf(this.b.getFirstCol());
                    case 3:
                        return Short.valueOf(this.b.getLastCol());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("firstRow", supplier, "lastRow", supplier2, "firstColumn", supplier3, "lastColumn", supplier4, "zero", new Supplier(this) { // from class: org.apache.poi.hssf.record.x
            public final /* synthetic */ DimensionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Short.valueOf(this.b.getFirstCol());
                    case 3:
                        return Short.valueOf(this.b.getLastCol());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        });
    }

    public short getLastCol() {
        return this.field_4_last_col;
    }

    public int getLastRow() {
        return this.field_2_last_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getFirstRow());
        littleEndianOutput.writeInt(getLastRow());
        littleEndianOutput.writeShort(getFirstCol());
        littleEndianOutput.writeShort(getLastCol());
        littleEndianOutput.writeShort(0);
    }

    public void setFirstCol(short s6) {
        this.field_3_first_col = s6;
    }

    public void setFirstRow(int i5) {
        this.field_1_first_row = i5;
    }

    public void setLastCol(short s6) {
        this.field_4_last_col = s6;
    }

    public void setLastRow(int i5) {
        this.field_2_last_row = i5;
    }

    public DimensionsRecord(DimensionsRecord dimensionsRecord) {
        super(dimensionsRecord);
        this.field_1_first_row = dimensionsRecord.field_1_first_row;
        this.field_2_last_row = dimensionsRecord.field_2_last_row;
        this.field_3_first_col = dimensionsRecord.field_3_first_col;
        this.field_4_last_col = dimensionsRecord.field_4_last_col;
        this.field_5_zero = dimensionsRecord.field_5_zero;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DIMENSIONS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DimensionsRecord copy() {
        return new DimensionsRecord(this);
    }

    public DimensionsRecord(RecordInputStream recordInputStream) {
        this.field_1_first_row = recordInputStream.readInt();
        this.field_2_last_row = recordInputStream.readInt();
        this.field_3_first_col = recordInputStream.readShort();
        this.field_4_last_col = recordInputStream.readShort();
        this.field_5_zero = recordInputStream.readShort();
        if (recordInputStream.available() == 2) {
            LOG.atInfo().log("DimensionsRecord has extra 2 bytes.");
            recordInputStream.readShort();
        }
    }
}
