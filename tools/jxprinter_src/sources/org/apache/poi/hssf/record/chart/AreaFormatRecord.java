package org.apache.poi.hssf.record.chart;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class AreaFormatRecord extends StandardRecord {
    private static final BitField automatic = BitFieldFactory.getInstance(1);
    private static final BitField invert = BitFieldFactory.getInstance(2);
    public static final short sid = 4106;
    private int field_1_foregroundColor;
    private int field_2_backgroundColor;
    private short field_3_pattern;
    private short field_4_formatFlags;
    private short field_5_forecolorIndex;
    private short field_6_backcolorIndex;

    public AreaFormatRecord() {
    }

    public short getBackcolorIndex() {
        return this.field_6_backcolorIndex;
    }

    public int getBackgroundColor() {
        return this.field_2_backgroundColor;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    public short getForecolorIndex() {
        return this.field_5_forecolorIndex;
    }

    public int getForegroundColor() {
        return this.field_1_foregroundColor;
    }

    public short getFormatFlags() {
        return this.field_4_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("foregroundColor", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("backgroundColor", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("pattern", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("inverted", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("automatic", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("formatFlags", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("forecolorIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("backcolorIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.a
            public final /* synthetic */ AreaFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getForegroundColor());
                    case 1:
                        return Integer.valueOf(this.b.getBackgroundColor());
                    case 2:
                        return Short.valueOf(this.b.getPattern());
                    case 3:
                        return Boolean.valueOf(this.b.isInvert());
                    case 4:
                        return Boolean.valueOf(this.b.isAutomatic());
                    case 5:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 6:
                        return Short.valueOf(this.b.getForecolorIndex());
                    default:
                        return Short.valueOf(this.b.getBackcolorIndex());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public short getPattern() {
        return this.field_3_pattern;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isAutomatic() {
        return automatic.isSet(this.field_4_formatFlags);
    }

    public boolean isInvert() {
        return invert.isSet(this.field_4_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_foregroundColor);
        littleEndianOutput.writeInt(this.field_2_backgroundColor);
        littleEndianOutput.writeShort(this.field_3_pattern);
        littleEndianOutput.writeShort(this.field_4_formatFlags);
        littleEndianOutput.writeShort(this.field_5_forecolorIndex);
        littleEndianOutput.writeShort(this.field_6_backcolorIndex);
    }

    public void setAutomatic(boolean z6) {
        this.field_4_formatFlags = automatic.setShortBoolean(this.field_4_formatFlags, z6);
    }

    public void setBackcolorIndex(short s6) {
        this.field_6_backcolorIndex = s6;
    }

    public void setBackgroundColor(int i5) {
        this.field_2_backgroundColor = i5;
    }

    public void setForecolorIndex(short s6) {
        this.field_5_forecolorIndex = s6;
    }

    public void setForegroundColor(int i5) {
        this.field_1_foregroundColor = i5;
    }

    public void setFormatFlags(short s6) {
        this.field_4_formatFlags = s6;
    }

    public void setInvert(boolean z6) {
        this.field_4_formatFlags = invert.setShortBoolean(this.field_4_formatFlags, z6);
    }

    public void setPattern(short s6) {
        this.field_3_pattern = s6;
    }

    public AreaFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_foregroundColor = recordInputStream.readInt();
        this.field_2_backgroundColor = recordInputStream.readInt();
        this.field_3_pattern = recordInputStream.readShort();
        this.field_4_formatFlags = recordInputStream.readShort();
        this.field_5_forecolorIndex = recordInputStream.readShort();
        this.field_6_backcolorIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AREA_FORMAT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public AreaFormatRecord copy() {
        return new AreaFormatRecord(this);
    }

    public AreaFormatRecord(AreaFormatRecord areaFormatRecord) {
        super(areaFormatRecord);
        this.field_1_foregroundColor = areaFormatRecord.field_1_foregroundColor;
        this.field_2_backgroundColor = areaFormatRecord.field_2_backgroundColor;
        this.field_3_pattern = areaFormatRecord.field_3_pattern;
        this.field_4_formatFlags = areaFormatRecord.field_4_formatFlags;
        this.field_5_forecolorIndex = areaFormatRecord.field_5_forecolorIndex;
        this.field_6_backcolorIndex = areaFormatRecord.field_6_backcolorIndex;
    }
}
