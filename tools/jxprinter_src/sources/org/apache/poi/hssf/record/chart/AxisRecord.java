package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class AxisRecord extends StandardRecord {
    public static final short AXIS_TYPE_CATEGORY_OR_X_AXIS = 0;
    public static final short AXIS_TYPE_SERIES_AXIS = 2;
    public static final short AXIS_TYPE_VALUE_AXIS = 1;
    public static final short sid = 4125;
    private short field_1_axisType;
    private int field_2_reserved1;
    private int field_3_reserved2;
    private int field_4_reserved3;
    private int field_5_reserved4;

    public AxisRecord() {
    }

    public short getAxisType() {
        return this.field_1_axisType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.f
            public final /* synthetic */ AxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getReserved1());
                    case 2:
                        return Integer.valueOf(this.b.getReserved2());
                    case 3:
                        return Integer.valueOf(this.b.getReserved3());
                    default:
                        return Integer.valueOf(this.b.getReserved4());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.f
            public final /* synthetic */ AxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getReserved1());
                    case 2:
                        return Integer.valueOf(this.b.getReserved2());
                    case 3:
                        return Integer.valueOf(this.b.getReserved3());
                    default:
                        return Integer.valueOf(this.b.getReserved4());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.f
            public final /* synthetic */ AxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getReserved1());
                    case 2:
                        return Integer.valueOf(this.b.getReserved2());
                    case 3:
                        return Integer.valueOf(this.b.getReserved3());
                    default:
                        return Integer.valueOf(this.b.getReserved4());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.f
            public final /* synthetic */ AxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getReserved1());
                    case 2:
                        return Integer.valueOf(this.b.getReserved2());
                    case 3:
                        return Integer.valueOf(this.b.getReserved3());
                    default:
                        return Integer.valueOf(this.b.getReserved4());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("axisType", supplier, "reserved1", supplier2, "reserved2", supplier3, "reserved3", supplier4, "reserved4", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.f
            public final /* synthetic */ AxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getReserved1());
                    case 2:
                        return Integer.valueOf(this.b.getReserved2());
                    case 3:
                        return Integer.valueOf(this.b.getReserved3());
                    default:
                        return Integer.valueOf(this.b.getReserved4());
                }
            }
        });
    }

    public int getReserved1() {
        return this.field_2_reserved1;
    }

    public int getReserved2() {
        return this.field_3_reserved2;
    }

    public int getReserved3() {
        return this.field_4_reserved3;
    }

    public int getReserved4() {
        return this.field_5_reserved4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_axisType);
        littleEndianOutput.writeInt(this.field_2_reserved1);
        littleEndianOutput.writeInt(this.field_3_reserved2);
        littleEndianOutput.writeInt(this.field_4_reserved3);
        littleEndianOutput.writeInt(this.field_5_reserved4);
    }

    public void setAxisType(short s6) {
        this.field_1_axisType = s6;
    }

    public void setReserved1(int i5) {
        this.field_2_reserved1 = i5;
    }

    public void setReserved2(int i5) {
        this.field_3_reserved2 = i5;
    }

    public void setReserved3(int i5) {
        this.field_4_reserved3 = i5;
    }

    public void setReserved4(int i5) {
        this.field_5_reserved4 = i5;
    }

    public AxisRecord(AxisRecord axisRecord) {
        super(axisRecord);
        this.field_1_axisType = axisRecord.field_1_axisType;
        this.field_2_reserved1 = axisRecord.field_2_reserved1;
        this.field_3_reserved2 = axisRecord.field_3_reserved2;
        this.field_4_reserved3 = axisRecord.field_4_reserved3;
        this.field_5_reserved4 = axisRecord.field_5_reserved4;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AXIS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public AxisRecord copy() {
        return new AxisRecord(this);
    }

    public AxisRecord(RecordInputStream recordInputStream) {
        this.field_1_axisType = recordInputStream.readShort();
        this.field_2_reserved1 = recordInputStream.readInt();
        this.field_3_reserved2 = recordInputStream.readInt();
        this.field_4_reserved3 = recordInputStream.readInt();
        this.field_5_reserved4 = recordInputStream.readInt();
    }
}
