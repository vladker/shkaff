package org.apache.poi.hssf.record.chart;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ChartFormatRecord extends StandardRecord {
    public static final short sid = 4116;
    private static final BitField varyDisplayPattern = BitFieldFactory.getInstance(1);
    private int field1_x_position;
    private int field2_y_position;
    private int field3_width;
    private int field4_height;
    private int field5_grbit;
    private int field6_unknown;

    public ChartFormatRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field5_grbit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.field6_unknown);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 20;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i11 = 6;
        return GenericRecordUtil.getGenericProperties("x", supplier, "y", supplier2, "width", supplier3, "height", supplier4, "grbit", supplier5, "varyDisplayPattern", supplier6, EnvironmentCompat.MEDIA_UNKNOWN, new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.o
            public final /* synthetic */ ChartFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getXPosition());
                    case 1:
                        return Integer.valueOf(this.b.getYPosition());
                    case 2:
                        return Integer.valueOf(this.b.getWidth());
                    case 3:
                        return Integer.valueOf(this.b.getHeight());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.b.getVaryDisplayPattern());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public int getHeight() {
        return this.field4_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean getVaryDisplayPattern() {
        return varyDisplayPattern.isSet(this.field5_grbit);
    }

    public int getWidth() {
        return this.field3_width;
    }

    public int getXPosition() {
        return this.field1_x_position;
    }

    public int getYPosition() {
        return this.field2_y_position;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getXPosition());
        littleEndianOutput.writeInt(getYPosition());
        littleEndianOutput.writeInt(getWidth());
        littleEndianOutput.writeInt(getHeight());
        littleEndianOutput.writeShort(this.field5_grbit);
        littleEndianOutput.writeShort(this.field6_unknown);
    }

    public void setHeight(int i5) {
        this.field4_height = i5;
    }

    public void setVaryDisplayPattern(boolean z6) {
        this.field5_grbit = varyDisplayPattern.setBoolean(this.field5_grbit, z6);
    }

    public void setWidth(int i5) {
        this.field3_width = i5;
    }

    public void setXPosition(int i5) {
        this.field1_x_position = i5;
    }

    public void setYPosition(int i5) {
        this.field2_y_position = i5;
    }

    public ChartFormatRecord(ChartFormatRecord chartFormatRecord) {
        super(chartFormatRecord);
        this.field1_x_position = chartFormatRecord.field1_x_position;
        this.field2_y_position = chartFormatRecord.field2_y_position;
        this.field3_width = chartFormatRecord.field3_width;
        this.field4_height = chartFormatRecord.field4_height;
        this.field5_grbit = chartFormatRecord.field5_grbit;
        this.field6_unknown = chartFormatRecord.field6_unknown;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_FORMAT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ChartFormatRecord copy() {
        return new ChartFormatRecord(this);
    }

    public ChartFormatRecord(RecordInputStream recordInputStream) {
        this.field1_x_position = recordInputStream.readInt();
        this.field2_y_position = recordInputStream.readInt();
        this.field3_width = recordInputStream.readInt();
        this.field4_height = recordInputStream.readInt();
        this.field5_grbit = recordInputStream.readUShort();
        this.field6_unknown = recordInputStream.readUShort();
    }
}
