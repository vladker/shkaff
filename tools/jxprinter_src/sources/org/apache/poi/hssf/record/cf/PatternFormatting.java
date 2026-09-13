package org.apache.poi.hssf.record.cf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PatternFormatting implements Duplicatable, GenericRecord {
    public static final short ALT_BARS = 3;
    public static final short BIG_SPOTS = 9;
    public static final short BRICKS = 10;
    public static final short DIAMONDS = 16;
    public static final short FINE_DOTS = 2;
    public static final short LEAST_DOTS = 18;
    public static final short LESS_DOTS = 17;
    public static final short NO_FILL = 0;
    public static final short SOLID_FOREGROUND = 1;
    public static final short SPARSE_DOTS = 4;
    public static final short SQUARES = 15;
    public static final short THICK_BACKWARD_DIAG = 7;
    public static final short THICK_FORWARD_DIAG = 8;
    public static final short THICK_HORZ_BANDS = 5;
    public static final short THICK_VERT_BANDS = 6;
    public static final short THIN_BACKWARD_DIAG = 13;
    public static final short THIN_FORWARD_DIAG = 14;
    public static final short THIN_HORZ_BANDS = 11;
    public static final short THIN_VERT_BANDS = 12;
    private int field_15_pattern_style;
    private int field_16_pattern_color_indexes;
    private static final BitField fillPatternStyle = BitFieldFactory.getInstance(64512);
    private static final BitField patternColorIndex = BitFieldFactory.getInstance(127);
    private static final BitField patternBackgroundColorIndex = BitFieldFactory.getInstance(16256);

    public PatternFormatting() {
        this.field_15_pattern_style = 0;
        this.field_16_pattern_color_indexes = 0;
    }

    public int getDataLength() {
        return 4;
    }

    public int getFillBackgroundColor() {
        return patternBackgroundColorIndex.getValue(this.field_16_pattern_color_indexes);
    }

    public int getFillForegroundColor() {
        return patternColorIndex.getValue(this.field_16_pattern_color_indexes);
    }

    public int getFillPattern() {
        return fillPatternStyle.getValue(this.field_15_pattern_style);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties(CellUtil.FILL_PATTERN, GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: H4.h
            public final /* synthetic */ PatternFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int fillPattern;
                switch (i5) {
                    case 0:
                        fillPattern = this.b.getFillPattern();
                        break;
                    default:
                        fillPattern = this.b.getFillForegroundColor();
                        break;
                }
                return Integer.valueOf(fillPattern);
            }
        }, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, new String[]{"NO_FILL", "SOLID_FOREGROUND", "FINE_DOTS", "ALT_BARS", "SPARSE_DOTS", "THICK_HORZ_BANDS", "THICK_VERT_BANDS", "THICK_BACKWARD_DIAG", "THICK_FORWARD_DIAG", "BIG_SPOTS", "BRICKS", "THIN_HORZ_BANDS", "THIN_VERT_BANDS", "THIN_BACKWARD_DIAG", "THIN_FORWARD_DIAG", "SQUARES", "DIAMONDS", "LESS_DOTS", "LEAST_DOTS"}), CellUtil.FILL_FOREGROUND_COLOR, new Supplier(this) { // from class: H4.h
            public final /* synthetic */ PatternFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int fillPattern;
                switch (i6) {
                    case 0:
                        fillPattern = this.b.getFillPattern();
                        break;
                    default:
                        fillPattern = this.b.getFillForegroundColor();
                        break;
                }
                return Integer.valueOf(fillPattern);
            }
        }, CellUtil.FILL_BACKGROUND_COLOR, new Supplier(this) { // from class: H4.h
            public final /* synthetic */ PatternFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int fillPattern;
                switch (i6) {
                    case 0:
                        fillPattern = this.b.getFillPattern();
                        break;
                    default:
                        fillPattern = this.b.getFillForegroundColor();
                        break;
                }
                return Integer.valueOf(fillPattern);
            }
        });
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_15_pattern_style);
        littleEndianOutput.writeShort(this.field_16_pattern_color_indexes);
    }

    public void setFillBackgroundColor(int i5) {
        this.field_16_pattern_color_indexes = patternBackgroundColorIndex.setValue(this.field_16_pattern_color_indexes, i5);
    }

    public void setFillForegroundColor(int i5) {
        this.field_16_pattern_color_indexes = patternColorIndex.setValue(this.field_16_pattern_color_indexes, i5);
    }

    public void setFillPattern(int i5) {
        this.field_15_pattern_style = fillPatternStyle.setValue(this.field_15_pattern_style, i5);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public PatternFormatting copy() {
        return new PatternFormatting(this);
    }

    public PatternFormatting(PatternFormatting patternFormatting) {
        this.field_15_pattern_style = patternFormatting.field_15_pattern_style;
        this.field_16_pattern_color_indexes = patternFormatting.field_16_pattern_color_indexes;
    }

    public PatternFormatting(LittleEndianInput littleEndianInput) {
        this.field_15_pattern_style = littleEndianInput.readUShort();
        this.field_16_pattern_color_indexes = littleEndianInput.readUShort();
    }
}
