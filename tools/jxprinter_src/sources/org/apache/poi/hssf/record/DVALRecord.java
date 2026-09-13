package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DVALRecord extends StandardRecord {
    public static final short sid = 434;
    private short field_1_options;
    private int field_2_horiz_pos;
    private int field_3_vert_pos;
    private int field_5_dv_no;
    private int field_cbo_id;

    public DVALRecord() {
        this.field_cbo_id = -1;
        this.field_5_dv_no = 0;
    }

    public int getDVRecNo() {
        return this.field_5_dv_no;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.u
            public final /* synthetic */ DVALRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Integer.valueOf(this.b.getHorizontalPos());
                    case 2:
                        return Integer.valueOf(this.b.getVerticalPos());
                    case 3:
                        return Integer.valueOf(this.b.getObjectID());
                    default:
                        return Integer.valueOf(this.b.getDVRecNo());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.u
            public final /* synthetic */ DVALRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Integer.valueOf(this.b.getHorizontalPos());
                    case 2:
                        return Integer.valueOf(this.b.getVerticalPos());
                    case 3:
                        return Integer.valueOf(this.b.getObjectID());
                    default:
                        return Integer.valueOf(this.b.getDVRecNo());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.u
            public final /* synthetic */ DVALRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Integer.valueOf(this.b.getHorizontalPos());
                    case 2:
                        return Integer.valueOf(this.b.getVerticalPos());
                    case 3:
                        return Integer.valueOf(this.b.getObjectID());
                    default:
                        return Integer.valueOf(this.b.getDVRecNo());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.u
            public final /* synthetic */ DVALRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Integer.valueOf(this.b.getHorizontalPos());
                    case 2:
                        return Integer.valueOf(this.b.getVerticalPos());
                    case 3:
                        return Integer.valueOf(this.b.getObjectID());
                    default:
                        return Integer.valueOf(this.b.getDVRecNo());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("options", supplier, "horizPos", supplier2, "vertPos", supplier3, "comboObjectID", supplier4, "dvRecordsNumber", new Supplier(this) { // from class: org.apache.poi.hssf.record.u
            public final /* synthetic */ DVALRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Integer.valueOf(this.b.getHorizontalPos());
                    case 2:
                        return Integer.valueOf(this.b.getVerticalPos());
                    case 3:
                        return Integer.valueOf(this.b.getObjectID());
                    default:
                        return Integer.valueOf(this.b.getDVRecNo());
                }
            }
        });
    }

    public int getHorizontalPos() {
        return this.field_2_horiz_pos;
    }

    public int getObjectID() {
        return this.field_cbo_id;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public int getVerticalPos() {
        return this.field_3_vert_pos;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeInt(getHorizontalPos());
        littleEndianOutput.writeInt(getVerticalPos());
        littleEndianOutput.writeInt(getObjectID());
        littleEndianOutput.writeInt(getDVRecNo());
    }

    public void setDVRecNo(int i5) {
        this.field_5_dv_no = i5;
    }

    public void setHorizontalPos(int i5) {
        this.field_2_horiz_pos = i5;
    }

    public void setObjectID(int i5) {
        this.field_cbo_id = i5;
    }

    public void setOptions(short s6) {
        this.field_1_options = s6;
    }

    public void setVerticalPos(int i5) {
        this.field_3_vert_pos = i5;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DVAL;
    }

    public DVALRecord(DVALRecord dVALRecord) {
        super(dVALRecord);
        this.field_1_options = dVALRecord.field_1_options;
        this.field_2_horiz_pos = dVALRecord.field_2_horiz_pos;
        this.field_3_vert_pos = dVALRecord.field_3_vert_pos;
        this.field_cbo_id = dVALRecord.field_cbo_id;
        this.field_5_dv_no = dVALRecord.field_5_dv_no;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DVALRecord copy() {
        return new DVALRecord(this);
    }

    public DVALRecord(RecordInputStream recordInputStream) {
        this.field_1_options = recordInputStream.readShort();
        this.field_2_horiz_pos = recordInputStream.readInt();
        this.field_3_vert_pos = recordInputStream.readInt();
        this.field_cbo_id = recordInputStream.readInt();
        this.field_5_dv_no = recordInputStream.readInt();
    }
}
