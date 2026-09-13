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
public final class CategorySeriesAxisRecord extends StandardRecord {
    public static final short sid = 4128;
    private short field_1_crossingPoint;
    private short field_2_labelFrequency;
    private short field_3_tickMarkFrequency;
    private short field_4_options;
    private static final BitField valueAxisCrossing = BitFieldFactory.getInstance(1);
    private static final BitField crossesFarRight = BitFieldFactory.getInstance(2);
    private static final BitField reversed = BitFieldFactory.getInstance(4);

    public CategorySeriesAxisRecord() {
    }

    public short getCrossingPoint() {
        return this.field_1_crossingPoint;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        };
        final int i11 = 6;
        return GenericRecordUtil.getGenericProperties("crossingPoint", supplier, "labelFrequency", supplier2, "tickMarkFrequency", supplier3, "options", supplier4, "valueAxisCrossing", supplier5, "crossesFarRight", supplier6, "reversed", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.i
            public final /* synthetic */ CategorySeriesAxisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getCrossingPoint());
                    case 1:
                        return Short.valueOf(this.b.getLabelFrequency());
                    case 2:
                        return Short.valueOf(this.b.getTickMarkFrequency());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Boolean.valueOf(this.b.isValueAxisCrossing());
                    case 5:
                        return Boolean.valueOf(this.b.isCrossesFarRight());
                    default:
                        return Boolean.valueOf(this.b.isReversed());
                }
            }
        });
    }

    public short getLabelFrequency() {
        return this.field_2_labelFrequency;
    }

    public short getOptions() {
        return this.field_4_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getTickMarkFrequency() {
        return this.field_3_tickMarkFrequency;
    }

    public boolean isCrossesFarRight() {
        return crossesFarRight.isSet(this.field_4_options);
    }

    public boolean isReversed() {
        return reversed.isSet(this.field_4_options);
    }

    public boolean isValueAxisCrossing() {
        return valueAxisCrossing.isSet(this.field_4_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_crossingPoint);
        littleEndianOutput.writeShort(this.field_2_labelFrequency);
        littleEndianOutput.writeShort(this.field_3_tickMarkFrequency);
        littleEndianOutput.writeShort(this.field_4_options);
    }

    public void setCrossesFarRight(boolean z6) {
        this.field_4_options = crossesFarRight.setShortBoolean(this.field_4_options, z6);
    }

    public void setCrossingPoint(short s6) {
        this.field_1_crossingPoint = s6;
    }

    public void setLabelFrequency(short s6) {
        this.field_2_labelFrequency = s6;
    }

    public void setOptions(short s6) {
        this.field_4_options = s6;
    }

    public void setReversed(boolean z6) {
        this.field_4_options = reversed.setShortBoolean(this.field_4_options, z6);
    }

    public void setTickMarkFrequency(short s6) {
        this.field_3_tickMarkFrequency = s6;
    }

    public void setValueAxisCrossing(boolean z6) {
        this.field_4_options = valueAxisCrossing.setShortBoolean(this.field_4_options, z6);
    }

    public CategorySeriesAxisRecord(CategorySeriesAxisRecord categorySeriesAxisRecord) {
        super(categorySeriesAxisRecord);
        this.field_1_crossingPoint = categorySeriesAxisRecord.field_1_crossingPoint;
        this.field_2_labelFrequency = categorySeriesAxisRecord.field_2_labelFrequency;
        this.field_3_tickMarkFrequency = categorySeriesAxisRecord.field_3_tickMarkFrequency;
        this.field_4_options = categorySeriesAxisRecord.field_4_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CATEGORY_SERIES_AXIS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public CategorySeriesAxisRecord copy() {
        return new CategorySeriesAxisRecord(this);
    }

    public CategorySeriesAxisRecord(RecordInputStream recordInputStream) {
        this.field_1_crossingPoint = recordInputStream.readShort();
        this.field_2_labelFrequency = recordInputStream.readShort();
        this.field_3_tickMarkFrequency = recordInputStream.readShort();
        this.field_4_options = recordInputStream.readShort();
    }
}
