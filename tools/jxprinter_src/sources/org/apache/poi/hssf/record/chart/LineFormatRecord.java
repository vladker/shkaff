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
public final class LineFormatRecord extends StandardRecord {
    public static final short LINE_PATTERN_DARK_GRAY_PATTERN = 6;
    public static final short LINE_PATTERN_DASH = 1;
    public static final short LINE_PATTERN_DASH_DOT = 3;
    public static final short LINE_PATTERN_DASH_DOT_DOT = 4;
    public static final short LINE_PATTERN_DOT = 2;
    public static final short LINE_PATTERN_LIGHT_GRAY_PATTERN = 8;
    public static final short LINE_PATTERN_MEDIUM_GRAY_PATTERN = 7;
    public static final short LINE_PATTERN_NONE = 5;
    public static final short LINE_PATTERN_SOLID = 0;
    public static final short WEIGHT_HAIRLINE = -1;
    public static final short WEIGHT_MEDIUM = 1;
    public static final short WEIGHT_NARROW = 0;
    public static final short WEIGHT_WIDE = 2;
    public static final short sid = 4103;
    private int field_1_lineColor;
    private short field_2_linePattern;
    private short field_3_weight;
    private short field_4_format;
    private short field_5_colourPaletteIndex;
    private static final BitField auto = BitFieldFactory.getInstance(1);
    private static final BitField drawTicks = BitFieldFactory.getInstance(4);
    private static final BitField unknown = BitFieldFactory.getInstance(4);

    public LineFormatRecord() {
    }

    public short getColourPaletteIndex() {
        return this.field_5_colourPaletteIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    public short getFormat() {
        return this.field_4_format;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.z
            public final /* synthetic */ LineFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getLineColor());
                    case 1:
                        return Short.valueOf(this.b.getLinePattern());
                    case 2:
                        return Short.valueOf(this.b.getWeight());
                    case 3:
                        return Short.valueOf(this.b.getFormat());
                    default:
                        return Short.valueOf(this.b.getColourPaletteIndex());
                }
            }
        };
        final int i6 = 1;
        Supplier<GenericRecordUtil.AnnotatedFlag> enumBitsAsString = GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.z
            public final /* synthetic */ LineFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getLineColor());
                    case 1:
                        return Short.valueOf(this.b.getLinePattern());
                    case 2:
                        return Short.valueOf(this.b.getWeight());
                    case 3:
                        return Short.valueOf(this.b.getFormat());
                    default:
                        return Short.valueOf(this.b.getColourPaletteIndex());
                }
            }
        }, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, new String[]{"SOLID", "DASH", "DOT", "DASH_DOT", "DASH_DOT_DOT", "NONE", "DARK_GRAY_PATTERN", "MEDIUM_GRAY_PATTERN", "LIGHT_GRAY_PATTERN"});
        final int i7 = 2;
        final int i8 = 3;
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("lineColor", supplier, "linePattern", enumBitsAsString, "weight", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.z
            public final /* synthetic */ LineFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getLineColor());
                    case 1:
                        return Short.valueOf(this.b.getLinePattern());
                    case 2:
                        return Short.valueOf(this.b.getWeight());
                    case 3:
                        return Short.valueOf(this.b.getFormat());
                    default:
                        return Short.valueOf(this.b.getColourPaletteIndex());
                }
            }
        }, new int[]{-1, 0, 1, 2}, new String[]{"HAIRLINE", "NARROW", "MEDIUM", "WIDE"}), "format", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.z
            public final /* synthetic */ LineFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getLineColor());
                    case 1:
                        return Short.valueOf(this.b.getLinePattern());
                    case 2:
                        return Short.valueOf(this.b.getWeight());
                    case 3:
                        return Short.valueOf(this.b.getFormat());
                    default:
                        return Short.valueOf(this.b.getColourPaletteIndex());
                }
            }
        }, new BitField[]{auto, drawTicks, unknown}, new String[]{"AUTO", "DRAWTICKS", "UNKNOWN"}), "colourPaletteIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.z
            public final /* synthetic */ LineFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getLineColor());
                    case 1:
                        return Short.valueOf(this.b.getLinePattern());
                    case 2:
                        return Short.valueOf(this.b.getWeight());
                    case 3:
                        return Short.valueOf(this.b.getFormat());
                    default:
                        return Short.valueOf(this.b.getColourPaletteIndex());
                }
            }
        });
    }

    public int getLineColor() {
        return this.field_1_lineColor;
    }

    public short getLinePattern() {
        return this.field_2_linePattern;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getWeight() {
        return this.field_3_weight;
    }

    public boolean isAuto() {
        return auto.isSet(this.field_4_format);
    }

    public boolean isDrawTicks() {
        return drawTicks.isSet(this.field_4_format);
    }

    public boolean isUnknown() {
        return unknown.isSet(this.field_4_format);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_lineColor);
        littleEndianOutput.writeShort(this.field_2_linePattern);
        littleEndianOutput.writeShort(this.field_3_weight);
        littleEndianOutput.writeShort(this.field_4_format);
        littleEndianOutput.writeShort(this.field_5_colourPaletteIndex);
    }

    public void setAuto(boolean z6) {
        this.field_4_format = auto.setShortBoolean(this.field_4_format, z6);
    }

    public void setColourPaletteIndex(short s6) {
        this.field_5_colourPaletteIndex = s6;
    }

    public void setDrawTicks(boolean z6) {
        this.field_4_format = drawTicks.setShortBoolean(this.field_4_format, z6);
    }

    public void setFormat(short s6) {
        this.field_4_format = s6;
    }

    public void setLineColor(int i5) {
        this.field_1_lineColor = i5;
    }

    public void setLinePattern(short s6) {
        this.field_2_linePattern = s6;
    }

    public void setUnknown(boolean z6) {
        this.field_4_format = unknown.setShortBoolean(this.field_4_format, z6);
    }

    public void setWeight(short s6) {
        this.field_3_weight = s6;
    }

    public LineFormatRecord(LineFormatRecord lineFormatRecord) {
        super(lineFormatRecord);
        this.field_1_lineColor = lineFormatRecord.field_1_lineColor;
        this.field_2_linePattern = lineFormatRecord.field_2_linePattern;
        this.field_3_weight = lineFormatRecord.field_3_weight;
        this.field_4_format = lineFormatRecord.field_4_format;
        this.field_5_colourPaletteIndex = lineFormatRecord.field_5_colourPaletteIndex;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LINE_FORMAT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public LineFormatRecord copy() {
        return new LineFormatRecord(this);
    }

    public LineFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_lineColor = recordInputStream.readInt();
        this.field_2_linePattern = recordInputStream.readShort();
        this.field_3_weight = recordInputStream.readShort();
        this.field_4_format = recordInputStream.readShort();
        this.field_5_colourPaletteIndex = recordInputStream.readShort();
    }
}
