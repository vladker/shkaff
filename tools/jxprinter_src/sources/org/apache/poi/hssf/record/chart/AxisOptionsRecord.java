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
public final class AxisOptionsRecord extends StandardRecord {
    public static final short sid = 4194;
    private short field_1_minimumCategory;
    private short field_2_maximumCategory;
    private short field_3_majorUnitValue;
    private short field_4_majorUnit;
    private short field_5_minorUnitValue;
    private short field_6_minorUnit;
    private short field_7_baseUnit;
    private short field_8_crossingPoint;
    private short field_9_options;
    private static final BitField defaultMinimum = BitFieldFactory.getInstance(1);
    private static final BitField defaultMaximum = BitFieldFactory.getInstance(2);
    private static final BitField defaultMajor = BitFieldFactory.getInstance(4);
    private static final BitField defaultMinorUnit = BitFieldFactory.getInstance(8);
    private static final BitField isDate = BitFieldFactory.getInstance(16);
    private static final BitField defaultBase = BitFieldFactory.getInstance(32);
    private static final BitField defaultCross = BitFieldFactory.getInstance(64);
    private static final BitField defaultDateSettings = BitFieldFactory.getInstance(128);
    private static final int[] FLAG_MASKS = {1, 2, 4, 8, 16, 32, 64, 128};
    private static final String[] FLAG_NAMES = {"DEFAULT_MINIMUM", "DEFAULT_MAXIMUM", "DEFAULT_MAJOR", "DEFAULT_MINOR_UNIT", "IS_DATE", "DEFAULT_BASE", "DEFAULT_CROSS", "DEFAULT_DATE_SETTINGS"};

    public AxisOptionsRecord() {
    }

    public short getBaseUnit() {
        return this.field_7_baseUnit;
    }

    public short getCrossingPoint() {
        return this.field_8_crossingPoint;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i5) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i6) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i7) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i8) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i9) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i10) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        final int i13 = 8;
        return GenericRecordUtil.getGenericProperties("minimumCategory", supplier, "maximumCategory", supplier2, "majorUnitValue", supplier3, "majorUnit", supplier4, "minorUnitValue", supplier5, "minorUnit", supplier6, "baseUnit", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i11) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        }, "crossingPoint", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i12) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        }, "options", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.d
            public final /* synthetic */ AxisOptionsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short minimumCategory;
                switch (i13) {
                    case 0:
                        minimumCategory = this.b.getMinimumCategory();
                        break;
                    case 1:
                        minimumCategory = this.b.getMaximumCategory();
                        break;
                    case 2:
                        minimumCategory = this.b.getMajorUnitValue();
                        break;
                    case 3:
                        minimumCategory = this.b.getMajorUnit();
                        break;
                    case 4:
                        minimumCategory = this.b.getMinorUnitValue();
                        break;
                    case 5:
                        minimumCategory = this.b.getMinorUnit();
                        break;
                    case 6:
                        minimumCategory = this.b.getBaseUnit();
                        break;
                    case 7:
                        minimumCategory = this.b.getCrossingPoint();
                        break;
                    default:
                        minimumCategory = this.b.getOptions();
                        break;
                }
                return Short.valueOf(minimumCategory);
            }
        }, FLAG_MASKS, FLAG_NAMES));
    }

    public short getMajorUnit() {
        return this.field_4_majorUnit;
    }

    public short getMajorUnitValue() {
        return this.field_3_majorUnitValue;
    }

    public short getMaximumCategory() {
        return this.field_2_maximumCategory;
    }

    public short getMinimumCategory() {
        return this.field_1_minimumCategory;
    }

    public short getMinorUnit() {
        return this.field_6_minorUnit;
    }

    public short getMinorUnitValue() {
        return this.field_5_minorUnitValue;
    }

    public short getOptions() {
        return this.field_9_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isDefaultBase() {
        return defaultBase.isSet(this.field_9_options);
    }

    public boolean isDefaultCross() {
        return defaultCross.isSet(this.field_9_options);
    }

    public boolean isDefaultDateSettings() {
        return defaultDateSettings.isSet(this.field_9_options);
    }

    public boolean isDefaultMajor() {
        return defaultMajor.isSet(this.field_9_options);
    }

    public boolean isDefaultMaximum() {
        return defaultMaximum.isSet(this.field_9_options);
    }

    public boolean isDefaultMinimum() {
        return defaultMinimum.isSet(this.field_9_options);
    }

    public boolean isDefaultMinorUnit() {
        return defaultMinorUnit.isSet(this.field_9_options);
    }

    public boolean isIsDate() {
        return isDate.isSet(this.field_9_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_minimumCategory);
        littleEndianOutput.writeShort(this.field_2_maximumCategory);
        littleEndianOutput.writeShort(this.field_3_majorUnitValue);
        littleEndianOutput.writeShort(this.field_4_majorUnit);
        littleEndianOutput.writeShort(this.field_5_minorUnitValue);
        littleEndianOutput.writeShort(this.field_6_minorUnit);
        littleEndianOutput.writeShort(this.field_7_baseUnit);
        littleEndianOutput.writeShort(this.field_8_crossingPoint);
        littleEndianOutput.writeShort(this.field_9_options);
    }

    public void setBaseUnit(short s6) {
        this.field_7_baseUnit = s6;
    }

    public void setCrossingPoint(short s6) {
        this.field_8_crossingPoint = s6;
    }

    public void setDefaultBase(boolean z6) {
        this.field_9_options = defaultBase.setShortBoolean(this.field_9_options, z6);
    }

    public void setDefaultCross(boolean z6) {
        this.field_9_options = defaultCross.setShortBoolean(this.field_9_options, z6);
    }

    public void setDefaultDateSettings(boolean z6) {
        this.field_9_options = defaultDateSettings.setShortBoolean(this.field_9_options, z6);
    }

    public void setDefaultMajor(boolean z6) {
        this.field_9_options = defaultMajor.setShortBoolean(this.field_9_options, z6);
    }

    public void setDefaultMaximum(boolean z6) {
        this.field_9_options = defaultMaximum.setShortBoolean(this.field_9_options, z6);
    }

    public void setDefaultMinimum(boolean z6) {
        this.field_9_options = defaultMinimum.setShortBoolean(this.field_9_options, z6);
    }

    public void setDefaultMinorUnit(boolean z6) {
        this.field_9_options = defaultMinorUnit.setShortBoolean(this.field_9_options, z6);
    }

    public void setIsDate(boolean z6) {
        this.field_9_options = isDate.setShortBoolean(this.field_9_options, z6);
    }

    public void setMajorUnit(short s6) {
        this.field_4_majorUnit = s6;
    }

    public void setMajorUnitValue(short s6) {
        this.field_3_majorUnitValue = s6;
    }

    public void setMaximumCategory(short s6) {
        this.field_2_maximumCategory = s6;
    }

    public void setMinimumCategory(short s6) {
        this.field_1_minimumCategory = s6;
    }

    public void setMinorUnit(short s6) {
        this.field_6_minorUnit = s6;
    }

    public void setMinorUnitValue(short s6) {
        this.field_5_minorUnitValue = s6;
    }

    public void setOptions(short s6) {
        this.field_9_options = s6;
    }

    public AxisOptionsRecord(AxisOptionsRecord axisOptionsRecord) {
        super(axisOptionsRecord);
        this.field_1_minimumCategory = axisOptionsRecord.field_1_minimumCategory;
        this.field_2_maximumCategory = axisOptionsRecord.field_2_maximumCategory;
        this.field_3_majorUnitValue = axisOptionsRecord.field_3_majorUnitValue;
        this.field_4_majorUnit = axisOptionsRecord.field_4_majorUnit;
        this.field_5_minorUnitValue = axisOptionsRecord.field_5_minorUnitValue;
        this.field_6_minorUnit = axisOptionsRecord.field_6_minorUnit;
        this.field_7_baseUnit = axisOptionsRecord.field_7_baseUnit;
        this.field_8_crossingPoint = axisOptionsRecord.field_8_crossingPoint;
        this.field_9_options = axisOptionsRecord.field_9_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AXIS_OPTIONS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public AxisOptionsRecord copy() {
        return new AxisOptionsRecord(this);
    }

    public AxisOptionsRecord(RecordInputStream recordInputStream) {
        this.field_1_minimumCategory = recordInputStream.readShort();
        this.field_2_maximumCategory = recordInputStream.readShort();
        this.field_3_majorUnitValue = recordInputStream.readShort();
        this.field_4_majorUnit = recordInputStream.readShort();
        this.field_5_minorUnitValue = recordInputStream.readShort();
        this.field_6_minorUnit = recordInputStream.readShort();
        this.field_7_baseUnit = recordInputStream.readShort();
        this.field_8_crossingPoint = recordInputStream.readShort();
        this.field_9_options = recordInputStream.readShort();
    }
}
