package org.apache.poi.hssf.record.chart;

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
public final class FrameRecord extends StandardRecord {
    public static final short BORDER_TYPE_REGULAR = 0;
    public static final short BORDER_TYPE_SHADOW = 1;
    public static final short sid = 4146;
    private short field_1_borderType;
    private short field_2_options;
    private static final BitField autoSize = BitFieldFactory.getInstance(1);
    private static final BitField autoPosition = BitFieldFactory.getInstance(2);

    public FrameRecord() {
    }

    public short getBorderType() {
        return this.field_1_borderType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.x
            public final /* synthetic */ FrameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getBorderType());
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAutoSize());
                    default:
                        return Boolean.valueOf(this.b.isAutoPosition());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.x
            public final /* synthetic */ FrameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getBorderType());
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAutoSize());
                    default:
                        return Boolean.valueOf(this.b.isAutoPosition());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.x
            public final /* synthetic */ FrameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getBorderType());
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAutoSize());
                    default:
                        return Boolean.valueOf(this.b.isAutoPosition());
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("borderType", supplier, "options", supplier2, "autoSize", supplier3, "autoPosition", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.x
            public final /* synthetic */ FrameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getBorderType());
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAutoSize());
                    default:
                        return Boolean.valueOf(this.b.isAutoPosition());
                }
            }
        });
    }

    public short getOptions() {
        return this.field_2_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isAutoPosition() {
        return autoPosition.isSet(this.field_2_options);
    }

    public boolean isAutoSize() {
        return autoSize.isSet(this.field_2_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_borderType);
        littleEndianOutput.writeShort(this.field_2_options);
    }

    public void setAutoPosition(boolean z6) {
        this.field_2_options = autoPosition.setShortBoolean(this.field_2_options, z6);
    }

    public void setAutoSize(boolean z6) {
        this.field_2_options = autoSize.setShortBoolean(this.field_2_options, z6);
    }

    public void setBorderType(short s6) {
        this.field_1_borderType = s6;
    }

    public void setOptions(short s6) {
        this.field_2_options = s6;
    }

    public FrameRecord(FrameRecord frameRecord) {
        super(frameRecord);
        this.field_1_borderType = frameRecord.field_1_borderType;
        this.field_2_options = frameRecord.field_2_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FRAME;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FrameRecord copy() {
        return new FrameRecord(this);
    }

    public FrameRecord(RecordInputStream recordInputStream) {
        this.field_1_borderType = recordInputStream.readShort();
        this.field_2_options = recordInputStream.readShort();
    }
}
