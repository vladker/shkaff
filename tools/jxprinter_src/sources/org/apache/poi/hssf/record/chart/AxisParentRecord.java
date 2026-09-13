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
public final class AxisParentRecord extends StandardRecord {
    public static final short AXIS_TYPE_MAIN = 0;
    public static final short AXIS_TYPE_SECONDARY = 1;
    public static final short sid = 4161;
    private short field_1_axisType;
    private int field_2_x;
    private int field_3_y;
    private int field_4_width;
    private int field_5_height;

    public AxisParentRecord() {
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
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.e
            public final /* synthetic */ AxisParentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getX());
                    case 2:
                        return Integer.valueOf(this.b.getY());
                    case 3:
                        return Integer.valueOf(this.b.getWidth());
                    default:
                        return Integer.valueOf(this.b.getHeight());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.e
            public final /* synthetic */ AxisParentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getX());
                    case 2:
                        return Integer.valueOf(this.b.getY());
                    case 3:
                        return Integer.valueOf(this.b.getWidth());
                    default:
                        return Integer.valueOf(this.b.getHeight());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.e
            public final /* synthetic */ AxisParentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getX());
                    case 2:
                        return Integer.valueOf(this.b.getY());
                    case 3:
                        return Integer.valueOf(this.b.getWidth());
                    default:
                        return Integer.valueOf(this.b.getHeight());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.e
            public final /* synthetic */ AxisParentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getX());
                    case 2:
                        return Integer.valueOf(this.b.getY());
                    case 3:
                        return Integer.valueOf(this.b.getWidth());
                    default:
                        return Integer.valueOf(this.b.getHeight());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("axisType", supplier, "x", supplier2, "y", supplier3, "width", supplier4, "height", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.e
            public final /* synthetic */ AxisParentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getAxisType());
                    case 1:
                        return Integer.valueOf(this.b.getX());
                    case 2:
                        return Integer.valueOf(this.b.getY());
                    case 3:
                        return Integer.valueOf(this.b.getWidth());
                    default:
                        return Integer.valueOf(this.b.getHeight());
                }
            }
        });
    }

    public int getHeight() {
        return this.field_5_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public int getWidth() {
        return this.field_4_width;
    }

    public int getX() {
        return this.field_2_x;
    }

    public int getY() {
        return this.field_3_y;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_axisType);
        littleEndianOutput.writeInt(this.field_2_x);
        littleEndianOutput.writeInt(this.field_3_y);
        littleEndianOutput.writeInt(this.field_4_width);
        littleEndianOutput.writeInt(this.field_5_height);
    }

    public void setAxisType(short s6) {
        this.field_1_axisType = s6;
    }

    public void setHeight(int i5) {
        this.field_5_height = i5;
    }

    public void setWidth(int i5) {
        this.field_4_width = i5;
    }

    public void setX(int i5) {
        this.field_2_x = i5;
    }

    public void setY(int i5) {
        this.field_3_y = i5;
    }

    public AxisParentRecord(AxisParentRecord axisParentRecord) {
        super(axisParentRecord);
        this.field_1_axisType = axisParentRecord.field_1_axisType;
        this.field_2_x = axisParentRecord.field_2_x;
        this.field_3_y = axisParentRecord.field_3_y;
        this.field_4_width = axisParentRecord.field_4_width;
        this.field_5_height = axisParentRecord.field_5_height;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AXIS_PARENT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public AxisParentRecord copy() {
        return new AxisParentRecord(this);
    }

    public AxisParentRecord(RecordInputStream recordInputStream) {
        this.field_1_axisType = recordInputStream.readShort();
        this.field_2_x = recordInputStream.readInt();
        this.field_3_y = recordInputStream.readInt();
        this.field_4_width = recordInputStream.readInt();
        this.field_5_height = recordInputStream.readInt();
    }
}
