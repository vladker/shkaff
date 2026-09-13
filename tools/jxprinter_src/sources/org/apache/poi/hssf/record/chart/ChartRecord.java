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
public final class ChartRecord extends StandardRecord {
    public static final short sid = 4098;
    private int field_1_x;
    private int field_2_y;
    private int field_3_width;
    private int field_4_height;

    public ChartRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.p
            public final /* synthetic */ ChartRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int x6;
                switch (i5) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getWidth();
                        break;
                    default:
                        x6 = this.b.getHeight();
                        break;
                }
                return Integer.valueOf(x6);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.p
            public final /* synthetic */ ChartRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int x6;
                switch (i6) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getWidth();
                        break;
                    default:
                        x6 = this.b.getHeight();
                        break;
                }
                return Integer.valueOf(x6);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.p
            public final /* synthetic */ ChartRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int x6;
                switch (i7) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getWidth();
                        break;
                    default:
                        x6 = this.b.getHeight();
                        break;
                }
                return Integer.valueOf(x6);
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("x", supplier, "y", supplier2, "width", supplier3, "height", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.p
            public final /* synthetic */ ChartRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int x6;
                switch (i8) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getWidth();
                        break;
                    default:
                        x6 = this.b.getHeight();
                        break;
                }
                return Integer.valueOf(x6);
            }
        });
    }

    public int getHeight() {
        return this.field_4_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public int getWidth() {
        return this.field_3_width;
    }

    public int getX() {
        return this.field_1_x;
    }

    public int getY() {
        return this.field_2_y;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_x);
        littleEndianOutput.writeInt(this.field_2_y);
        littleEndianOutput.writeInt(this.field_3_width);
        littleEndianOutput.writeInt(this.field_4_height);
    }

    public void setHeight(int i5) {
        this.field_4_height = i5;
    }

    public void setWidth(int i5) {
        this.field_3_width = i5;
    }

    public void setX(int i5) {
        this.field_1_x = i5;
    }

    public void setY(int i5) {
        this.field_2_y = i5;
    }

    public ChartRecord(ChartRecord chartRecord) {
        super(chartRecord);
        this.field_1_x = chartRecord.field_1_x;
        this.field_2_y = chartRecord.field_2_y;
        this.field_3_width = chartRecord.field_3_width;
        this.field_4_height = chartRecord.field_4_height;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ChartRecord copy() {
        return new ChartRecord(this);
    }

    public ChartRecord(RecordInputStream recordInputStream) {
        this.field_1_x = recordInputStream.readInt();
        this.field_2_y = recordInputStream.readInt();
        this.field_3_width = recordInputStream.readInt();
        this.field_4_height = recordInputStream.readInt();
    }
}
