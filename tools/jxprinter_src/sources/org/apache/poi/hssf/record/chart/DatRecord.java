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
public final class DatRecord extends StandardRecord {
    public static final short sid = 4195;
    private short field_1_options;
    private static final BitField horizontalBorder = BitFieldFactory.getInstance(1);
    private static final BitField verticalBorder = BitFieldFactory.getInstance(2);
    private static final BitField border = BitFieldFactory.getInstance(4);
    private static final BitField showSeriesKey = BitFieldFactory.getInstance(8);

    public DatRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.t
            public final /* synthetic */ DatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Boolean.valueOf(this.b.isHorizontalBorder());
                    case 2:
                        return Boolean.valueOf(this.b.isVerticalBorder());
                    case 3:
                        return Boolean.valueOf(this.b.isBorder());
                    default:
                        return Boolean.valueOf(this.b.isShowSeriesKey());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.t
            public final /* synthetic */ DatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Boolean.valueOf(this.b.isHorizontalBorder());
                    case 2:
                        return Boolean.valueOf(this.b.isVerticalBorder());
                    case 3:
                        return Boolean.valueOf(this.b.isBorder());
                    default:
                        return Boolean.valueOf(this.b.isShowSeriesKey());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.t
            public final /* synthetic */ DatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Boolean.valueOf(this.b.isHorizontalBorder());
                    case 2:
                        return Boolean.valueOf(this.b.isVerticalBorder());
                    case 3:
                        return Boolean.valueOf(this.b.isBorder());
                    default:
                        return Boolean.valueOf(this.b.isShowSeriesKey());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.t
            public final /* synthetic */ DatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Boolean.valueOf(this.b.isHorizontalBorder());
                    case 2:
                        return Boolean.valueOf(this.b.isVerticalBorder());
                    case 3:
                        return Boolean.valueOf(this.b.isBorder());
                    default:
                        return Boolean.valueOf(this.b.isShowSeriesKey());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("options", supplier, "horizontalBorder", supplier2, "verticalBorder", supplier3, "border", supplier4, "showSeriesKey", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.t
            public final /* synthetic */ DatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Boolean.valueOf(this.b.isHorizontalBorder());
                    case 2:
                        return Boolean.valueOf(this.b.isVerticalBorder());
                    case 3:
                        return Boolean.valueOf(this.b.isBorder());
                    default:
                        return Boolean.valueOf(this.b.isShowSeriesKey());
                }
            }
        });
    }

    public short getOptions() {
        return this.field_1_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isBorder() {
        return border.isSet(this.field_1_options);
    }

    public boolean isHorizontalBorder() {
        return horizontalBorder.isSet(this.field_1_options);
    }

    public boolean isShowSeriesKey() {
        return showSeriesKey.isSet(this.field_1_options);
    }

    public boolean isVerticalBorder() {
        return verticalBorder.isSet(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_options);
    }

    public void setBorder(boolean z6) {
        this.field_1_options = border.setShortBoolean(this.field_1_options, z6);
    }

    public void setHorizontalBorder(boolean z6) {
        this.field_1_options = horizontalBorder.setShortBoolean(this.field_1_options, z6);
    }

    public void setOptions(short s6) {
        this.field_1_options = s6;
    }

    public void setShowSeriesKey(boolean z6) {
        this.field_1_options = showSeriesKey.setShortBoolean(this.field_1_options, z6);
    }

    public void setVerticalBorder(boolean z6) {
        this.field_1_options = verticalBorder.setShortBoolean(this.field_1_options, z6);
    }

    public DatRecord(DatRecord datRecord) {
        super(datRecord);
        this.field_1_options = datRecord.field_1_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DAT;
    }

    public DatRecord(RecordInputStream recordInputStream) {
        this.field_1_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DatRecord copy() {
        return new DatRecord(this);
    }
}
