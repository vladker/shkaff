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
public final class ValueRangeRecord extends StandardRecord {
    public static final short sid = 4127;
    private double field_1_minimumAxisValue;
    private double field_2_maximumAxisValue;
    private double field_3_majorIncrement;
    private double field_4_minorIncrement;
    private double field_5_categoryAxisCross;
    private short field_6_options;
    private static final BitField automaticMinimum = BitFieldFactory.getInstance(1);
    private static final BitField automaticMaximum = BitFieldFactory.getInstance(2);
    private static final BitField automaticMajor = BitFieldFactory.getInstance(4);
    private static final BitField automaticMinor = BitFieldFactory.getInstance(8);
    private static final BitField automaticCategoryCrossing = BitFieldFactory.getInstance(16);
    private static final BitField logarithmicScale = BitFieldFactory.getInstance(32);
    private static final BitField valuesInReverse = BitFieldFactory.getInstance(64);
    private static final BitField crossCategoryAxisAtMaximum = BitFieldFactory.getInstance(128);
    private static final BitField reserved = BitFieldFactory.getInstance(256);

    public ValueRangeRecord() {
    }

    public double getCategoryAxisCross() {
        return this.field_5_categoryAxisCross;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 42;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.I
            public final /* synthetic */ ValueRangeRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Double.valueOf(this.b.getMinimumAxisValue());
                    case 1:
                        return Double.valueOf(this.b.getMaximumAxisValue());
                    case 2:
                        return Double.valueOf(this.b.getMajorIncrement());
                    case 3:
                        return Double.valueOf(this.b.getMinorIncrement());
                    case 4:
                        return Double.valueOf(this.b.getCategoryAxisCross());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.I
            public final /* synthetic */ ValueRangeRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Double.valueOf(this.b.getMinimumAxisValue());
                    case 1:
                        return Double.valueOf(this.b.getMaximumAxisValue());
                    case 2:
                        return Double.valueOf(this.b.getMajorIncrement());
                    case 3:
                        return Double.valueOf(this.b.getMinorIncrement());
                    case 4:
                        return Double.valueOf(this.b.getCategoryAxisCross());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.I
            public final /* synthetic */ ValueRangeRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Double.valueOf(this.b.getMinimumAxisValue());
                    case 1:
                        return Double.valueOf(this.b.getMaximumAxisValue());
                    case 2:
                        return Double.valueOf(this.b.getMajorIncrement());
                    case 3:
                        return Double.valueOf(this.b.getMinorIncrement());
                    case 4:
                        return Double.valueOf(this.b.getCategoryAxisCross());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.I
            public final /* synthetic */ ValueRangeRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Double.valueOf(this.b.getMinimumAxisValue());
                    case 1:
                        return Double.valueOf(this.b.getMaximumAxisValue());
                    case 2:
                        return Double.valueOf(this.b.getMajorIncrement());
                    case 3:
                        return Double.valueOf(this.b.getMinorIncrement());
                    case 4:
                        return Double.valueOf(this.b.getCategoryAxisCross());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i9 = 4;
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("minimumAxisValue", supplier, "maximumAxisValue", supplier2, "majorIncrement", supplier3, "minorIncrement", supplier4, "categoryAxisCross", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.I
            public final /* synthetic */ ValueRangeRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Double.valueOf(this.b.getMinimumAxisValue());
                    case 1:
                        return Double.valueOf(this.b.getMaximumAxisValue());
                    case 2:
                        return Double.valueOf(this.b.getMajorIncrement());
                    case 3:
                        return Double.valueOf(this.b.getMinorIncrement());
                    case 4:
                        return Double.valueOf(this.b.getCategoryAxisCross());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        }, "options", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.I
            public final /* synthetic */ ValueRangeRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Double.valueOf(this.b.getMinimumAxisValue());
                    case 1:
                        return Double.valueOf(this.b.getMaximumAxisValue());
                    case 2:
                        return Double.valueOf(this.b.getMajorIncrement());
                    case 3:
                        return Double.valueOf(this.b.getMinorIncrement());
                    case 4:
                        return Double.valueOf(this.b.getCategoryAxisCross());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        }, new BitField[]{automaticMinimum, automaticMaximum, automaticMajor, automaticMinor, automaticCategoryCrossing, logarithmicScale, valuesInReverse, crossCategoryAxisAtMaximum, reserved}, new String[]{"AUTOMATIC_MINIMUM", "AUTOMATIC_MAXIMUM", "AUTOMATIC_MAJOR", "AUTOMATIC_MINOR", "AUTOMATIC_CATEGORY_CROSSING", "LOGARITHMIC_SCALE", "VALUES_IN_REVERSE", "CROSS_CATEGORY_AXIS_AT_MAXIMUM", "RESERVED"}));
    }

    public double getMajorIncrement() {
        return this.field_3_majorIncrement;
    }

    public double getMaximumAxisValue() {
        return this.field_2_maximumAxisValue;
    }

    public double getMinimumAxisValue() {
        return this.field_1_minimumAxisValue;
    }

    public double getMinorIncrement() {
        return this.field_4_minorIncrement;
    }

    public short getOptions() {
        return this.field_6_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isAutomaticCategoryCrossing() {
        return automaticCategoryCrossing.isSet(this.field_6_options);
    }

    public boolean isAutomaticMajor() {
        return automaticMajor.isSet(this.field_6_options);
    }

    public boolean isAutomaticMaximum() {
        return automaticMaximum.isSet(this.field_6_options);
    }

    public boolean isAutomaticMinimum() {
        return automaticMinimum.isSet(this.field_6_options);
    }

    public boolean isAutomaticMinor() {
        return automaticMinor.isSet(this.field_6_options);
    }

    public boolean isCrossCategoryAxisAtMaximum() {
        return crossCategoryAxisAtMaximum.isSet(this.field_6_options);
    }

    public boolean isLogarithmicScale() {
        return logarithmicScale.isSet(this.field_6_options);
    }

    public boolean isReserved() {
        return reserved.isSet(this.field_6_options);
    }

    public boolean isValuesInReverse() {
        return valuesInReverse.isSet(this.field_6_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(this.field_1_minimumAxisValue);
        littleEndianOutput.writeDouble(this.field_2_maximumAxisValue);
        littleEndianOutput.writeDouble(this.field_3_majorIncrement);
        littleEndianOutput.writeDouble(this.field_4_minorIncrement);
        littleEndianOutput.writeDouble(this.field_5_categoryAxisCross);
        littleEndianOutput.writeShort(this.field_6_options);
    }

    public void setAutomaticCategoryCrossing(boolean z6) {
        this.field_6_options = automaticCategoryCrossing.setShortBoolean(this.field_6_options, z6);
    }

    public void setAutomaticMajor(boolean z6) {
        this.field_6_options = automaticMajor.setShortBoolean(this.field_6_options, z6);
    }

    public void setAutomaticMaximum(boolean z6) {
        this.field_6_options = automaticMaximum.setShortBoolean(this.field_6_options, z6);
    }

    public void setAutomaticMinimum(boolean z6) {
        this.field_6_options = automaticMinimum.setShortBoolean(this.field_6_options, z6);
    }

    public void setAutomaticMinor(boolean z6) {
        this.field_6_options = automaticMinor.setShortBoolean(this.field_6_options, z6);
    }

    public void setCategoryAxisCross(double d) {
        this.field_5_categoryAxisCross = d;
    }

    public void setCrossCategoryAxisAtMaximum(boolean z6) {
        this.field_6_options = crossCategoryAxisAtMaximum.setShortBoolean(this.field_6_options, z6);
    }

    public void setLogarithmicScale(boolean z6) {
        this.field_6_options = logarithmicScale.setShortBoolean(this.field_6_options, z6);
    }

    public void setMajorIncrement(double d) {
        this.field_3_majorIncrement = d;
    }

    public void setMaximumAxisValue(double d) {
        this.field_2_maximumAxisValue = d;
    }

    public void setMinimumAxisValue(double d) {
        this.field_1_minimumAxisValue = d;
    }

    public void setMinorIncrement(double d) {
        this.field_4_minorIncrement = d;
    }

    public void setOptions(short s6) {
        this.field_6_options = s6;
    }

    public void setReserved(boolean z6) {
        this.field_6_options = reserved.setShortBoolean(this.field_6_options, z6);
    }

    public void setValuesInReverse(boolean z6) {
        this.field_6_options = valuesInReverse.setShortBoolean(this.field_6_options, z6);
    }

    public ValueRangeRecord(ValueRangeRecord valueRangeRecord) {
        super(valueRangeRecord);
        this.field_1_minimumAxisValue = valueRangeRecord.field_1_minimumAxisValue;
        this.field_2_maximumAxisValue = valueRangeRecord.field_2_maximumAxisValue;
        this.field_3_majorIncrement = valueRangeRecord.field_3_majorIncrement;
        this.field_4_minorIncrement = valueRangeRecord.field_4_minorIncrement;
        this.field_5_categoryAxisCross = valueRangeRecord.field_5_categoryAxisCross;
        this.field_6_options = valueRangeRecord.field_6_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.VALUE_RANGE;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ValueRangeRecord copy() {
        return new ValueRangeRecord(this);
    }

    public ValueRangeRecord(RecordInputStream recordInputStream) {
        this.field_1_minimumAxisValue = recordInputStream.readDouble();
        this.field_2_maximumAxisValue = recordInputStream.readDouble();
        this.field_3_majorIncrement = recordInputStream.readDouble();
        this.field_4_minorIncrement = recordInputStream.readDouble();
        this.field_5_categoryAxisCross = recordInputStream.readDouble();
        this.field_6_options = recordInputStream.readShort();
    }
}
