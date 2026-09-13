package org.apache.poi.hssf.record;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtendedFormatRecord extends StandardRecord {
    public static final short ALT_BARS = 3;
    public static final short BIG_SPOTS = 9;
    public static final short BRICKS = 10;
    public static final short CENTER = 2;
    public static final short CENTER_SELECTION = 6;
    public static final short DASHED = 3;
    public static final short DASH_DOT = 9;
    public static final short DASH_DOT_DOT = 11;
    public static final short DIAMONDS = 16;
    public static final short DOTTED = 4;
    public static final short DOUBLE = 6;
    public static final short FILL = 4;
    public static final short FINE_DOTS = 2;
    public static final short GENERAL = 0;
    public static final short HAIR = 7;
    public static final short JUSTIFY = 5;
    public static final short LEFT = 1;
    public static final short MEDIUM = 2;
    public static final short MEDIUM_DASHED = 8;
    public static final short MEDIUM_DASH_DOT = 10;
    public static final short MEDIUM_DASH_DOT_DOT = 12;
    public static final short NONE = 0;
    public static final short NO_FILL = 0;
    public static final short NULL = -16;
    public static final short RIGHT = 3;
    public static final short SLANTED_DASH_DOT = 13;
    public static final short SOLID_FILL = 1;
    public static final short SPARSE_DOTS = 4;
    public static final short SQUARES = 15;
    public static final short THICK = 5;
    public static final short THICK_BACKWARD_DIAG = 7;
    public static final short THICK_FORWARD_DIAG = 8;
    public static final short THICK_HORZ_BANDS = 5;
    public static final short THICK_VERT_BANDS = 6;
    public static final short THIN = 1;
    public static final short THIN_BACKWARD_DIAG = 13;
    public static final short THIN_FORWARD_DIAG = 14;
    public static final short THIN_HORZ_BANDS = 11;
    public static final short THIN_VERT_BANDS = 12;
    public static final short VERTICAL_BOTTOM = 2;
    public static final short VERTICAL_CENTER = 1;
    public static final short VERTICAL_JUSTIFY = 3;
    public static final short VERTICAL_TOP = 0;
    public static final short XF_CELL = 0;
    public static final short XF_STYLE = 1;
    public static final short sid = 224;
    private short field_1_font_index;
    private short field_2_format_index;
    private short field_3_cell_options;
    private short field_4_alignment_options;
    private short field_5_indention_options;
    private short field_6_border_options;
    private short field_7_palette_options;
    private int field_8_adtl_palette_options;
    private short field_9_fill_palette_options;
    private static final BitField _locked = bf(1);
    private static final BitField _hidden = bf(2);
    private static final BitField _xf_type = bf(4);
    private static final BitField _123_prefix = bf(8);
    private static final BitField _parent_index = bf(65520);
    private static final BitField _alignment = bf(7);
    private static final BitField _wrap_text = bf(8);
    private static final BitField _vertical_alignment = bf(112);
    private static final BitField _justify_last = bf(128);
    private static final BitField _rotation = bf(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    private static final BitField _indent = bf(15);
    private static final BitField _shrink_to_fit = bf(16);
    private static final BitField _merge_cells = bf(32);
    private static final BitField _reading_order = bf(192);
    private static final BitField _indent_not_parent_format = bf(1024);
    private static final BitField _indent_not_parent_font = bf(2048);
    private static final BitField _indent_not_parent_alignment = bf(4096);
    private static final BitField _indent_not_parent_border = bf(8192);
    private static final BitField _indent_not_parent_pattern = bf(16384);
    private static final BitField _indent_not_parent_cell_options = bf(32768);
    private static final BitField _border_left = bf(15);
    private static final BitField _border_right = bf(240);
    private static final BitField _border_top = bf(3840);
    private static final BitField _border_bottom = bf(61440);
    private static final BitField _left_border_palette_idx = bf(127);
    private static final BitField _right_border_palette_idx = bf(16256);
    private static final BitField _diag = bf(CpioConstants.C_ISSOCK);
    private static final BitField _top_border_palette_idx = bf(127);
    private static final BitField _bottom_border_palette_idx = bf(16256);
    private static final BitField _adtl_diag = bf(2080768);
    private static final BitField _adtl_diag_line_style = bf(31457280);
    private static final BitField _adtl_fill_pattern = bf(-67108864);
    private static final BitField _fill_foreground = bf(127);
    private static final BitField _fill_background = bf(16256);

    public ExtendedFormatRecord() {
    }

    private static BitField bf(int i5) {
        return BitFieldFactory.getInstance(i5);
    }

    public void cloneStyleFrom(ExtendedFormatRecord extendedFormatRecord) {
        this.field_1_font_index = extendedFormatRecord.field_1_font_index;
        this.field_2_format_index = extendedFormatRecord.field_2_format_index;
        this.field_3_cell_options = extendedFormatRecord.field_3_cell_options;
        this.field_4_alignment_options = extendedFormatRecord.field_4_alignment_options;
        this.field_5_indention_options = extendedFormatRecord.field_5_indention_options;
        this.field_6_border_options = extendedFormatRecord.field_6_border_options;
        this.field_7_palette_options = extendedFormatRecord.field_7_palette_options;
        this.field_8_adtl_palette_options = extendedFormatRecord.field_8_adtl_palette_options;
        this.field_9_fill_palette_options = extendedFormatRecord.field_9_fill_palette_options;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ExtendedFormatRecord)) {
            return Arrays.equals(stateSummary(), ((ExtendedFormatRecord) obj).stateSummary());
        }
        return false;
    }

    public boolean get123Prefix() {
        return _123_prefix.isSet(this.field_3_cell_options);
    }

    public short getAdtlDiag() {
        return (short) _adtl_diag.getValue(this.field_8_adtl_palette_options);
    }

    public short getAdtlDiagLineStyle() {
        return (short) _adtl_diag_line_style.getValue(this.field_8_adtl_palette_options);
    }

    public short getAdtlFillPattern() {
        return (short) _adtl_fill_pattern.getValue(this.field_8_adtl_palette_options);
    }

    public int getAdtlPaletteOptions() {
        return this.field_8_adtl_palette_options;
    }

    public short getAlignment() {
        return _alignment.getShortValue(this.field_4_alignment_options);
    }

    public short getAlignmentOptions() {
        return this.field_4_alignment_options;
    }

    public short getBorderBottom() {
        return _border_bottom.getShortValue(this.field_6_border_options);
    }

    public short getBorderLeft() {
        return _border_left.getShortValue(this.field_6_border_options);
    }

    public short getBorderOptions() {
        return this.field_6_border_options;
    }

    public short getBorderRight() {
        return _border_right.getShortValue(this.field_6_border_options);
    }

    public short getBorderTop() {
        return _border_top.getShortValue(this.field_6_border_options);
    }

    public short getBottomBorderPaletteIdx() {
        return (short) _bottom_border_palette_idx.getValue(this.field_8_adtl_palette_options);
    }

    public short getCellOptions() {
        return this.field_3_cell_options;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 20;
    }

    public short getDiag() {
        return _diag.getShortValue(this.field_7_palette_options);
    }

    public short getFillBackground() {
        return _fill_background.getShortValue(this.field_9_fill_palette_options);
    }

    public short getFillForeground() {
        return _fill_foreground.getShortValue(this.field_9_fill_palette_options);
    }

    public short getFillPaletteOptions() {
        return this.field_9_fill_palette_options;
    }

    public short getFontIndex() {
        return this.field_1_font_index;
    }

    public short getFormatIndex() {
        return this.field_2_format_index;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("xfType", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        }, new int[]{0, 1}, new String[]{"CELL", "STYLE"}));
        final int i6 = 2;
        linkedHashMap.put("fontIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i7 = 14;
        linkedHashMap.put("formatIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i8 = 15;
        linkedHashMap.put("cellOptions", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        }, new BitField[]{_locked, _hidden, _123_prefix}, new String[]{"LOCKED", "HIDDEN", "LOTUS_123_PREFIX"}));
        final int i9 = 16;
        linkedHashMap.put("parentIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i10 = 17;
        linkedHashMap.put("alignmentOptions", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        }, new BitField[]{_wrap_text, _justify_last}, new String[]{"WRAP_TEXT", "JUSTIFY_LAST"}));
        final int i11 = 18;
        linkedHashMap.put(CellUtil.ALIGNMENT, new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i12 = 19;
        linkedHashMap.put(CellUtil.VERTICAL_ALIGNMENT, new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i13 = 20;
        linkedHashMap.put("rotation", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i14 = 21;
        linkedHashMap.put("indentionOptions", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        }, new BitField[]{_shrink_to_fit, _merge_cells, _indent_not_parent_format, _indent_not_parent_font, _indent_not_parent_alignment, _indent_not_parent_border, _indent_not_parent_pattern, _indent_not_parent_cell_options}, new String[]{"SHRINK_TO_FIT", "MERGE_CELLS", "NOT_PARENT_FORMAT", "NOT_PARENT_FONT", "NOT_PARENT_ALIGNMENT", "NOT_PARENT_BORDER", "NOT_PARENT_PATTERN", "NOT_PARENT_CELL_OPTIONS"}));
        final int i15 = 11;
        linkedHashMap.put("indent", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i16 = 22;
        linkedHashMap.put("readingOrder", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i17 = 23;
        linkedHashMap.put("borderOptions", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i17) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i18 = 24;
        linkedHashMap.put(CellUtil.BORDER_LEFT, new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i18) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i19 = 25;
        linkedHashMap.put(CellUtil.BORDER_RIGHT, new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i19) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i20 = 26;
        linkedHashMap.put(CellUtil.BORDER_TOP, new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i20) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i21 = 27;
        linkedHashMap.put(CellUtil.BORDER_BOTTOM, new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i21) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i22 = 28;
        linkedHashMap.put("paletteOptions", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i22) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i23 = 29;
        linkedHashMap.put("leftBorderPaletteIdx", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i23) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i24 = 1;
        linkedHashMap.put("rightBorderPaletteIdx", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i24) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i25 = 3;
        linkedHashMap.put("diag", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i25) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i26 = 4;
        linkedHashMap.put("adtlPaletteOptions", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i26) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i27 = 5;
        linkedHashMap.put("topBorderPaletteIdx", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i27) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i28 = 6;
        linkedHashMap.put("bottomBorderPaletteIdx", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i28) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i29 = 7;
        linkedHashMap.put("adtlDiag", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i29) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i30 = 8;
        linkedHashMap.put("adtlDiagLineStyle", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i30) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i31 = 9;
        linkedHashMap.put("adtlFillPattern", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i31) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i32 = 10;
        linkedHashMap.put("fillPaletteOptions", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i32) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i33 = 12;
        linkedHashMap.put("fillForeground", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i33) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        final int i34 = 13;
        linkedHashMap.put("fillBackground", new Supplier(this) { // from class: org.apache.poi.hssf.record.F
            public final /* synthetic */ ExtendedFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i34) {
                    case 0:
                        return Short.valueOf(this.b.getXFType());
                    case 1:
                        return Short.valueOf(this.b.getRightBorderPaletteIdx());
                    case 2:
                        return Short.valueOf(this.b.getFontIndex());
                    case 3:
                        return Short.valueOf(this.b.getDiag());
                    case 4:
                        return Integer.valueOf(this.b.getAdtlPaletteOptions());
                    case 5:
                        return Short.valueOf(this.b.getTopBorderPaletteIdx());
                    case 6:
                        return Short.valueOf(this.b.getBottomBorderPaletteIdx());
                    case 7:
                        return Short.valueOf(this.b.getAdtlDiag());
                    case 8:
                        return Short.valueOf(this.b.getAdtlDiagLineStyle());
                    case 9:
                        return Short.valueOf(this.b.getAdtlFillPattern());
                    case 10:
                        return Short.valueOf(this.b.getFillPaletteOptions());
                    case 11:
                        return Short.valueOf(this.b.getIndent());
                    case 12:
                        return Short.valueOf(this.b.getFillForeground());
                    case 13:
                        return Short.valueOf(this.b.getFillBackground());
                    case 14:
                        return Short.valueOf(this.b.getFormatIndex());
                    case 15:
                        return Short.valueOf(this.b.getCellOptions());
                    case 16:
                        return Short.valueOf(this.b.getParentIndex());
                    case 17:
                        return Short.valueOf(this.b.getAlignmentOptions());
                    case 18:
                        return Short.valueOf(this.b.getAlignment());
                    case 19:
                        return Short.valueOf(this.b.getVerticalAlignment());
                    case 20:
                        return Short.valueOf(this.b.getRotation());
                    case 21:
                        return Short.valueOf(this.b.getIndentionOptions());
                    case 22:
                        return Short.valueOf(this.b.getReadingOrder());
                    case 23:
                        return Short.valueOf(this.b.getBorderOptions());
                    case 24:
                        return Short.valueOf(this.b.getBorderLeft());
                    case 25:
                        return Short.valueOf(this.b.getBorderRight());
                    case 26:
                        return Short.valueOf(this.b.getBorderTop());
                    case 27:
                        return Short.valueOf(this.b.getBorderBottom());
                    case 28:
                        return Short.valueOf(this.b.getPaletteOptions());
                    default:
                        return Short.valueOf(this.b.getLeftBorderPaletteIdx());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public short getIndent() {
        return _indent.getShortValue(this.field_5_indention_options);
    }

    public short getIndentionOptions() {
        return this.field_5_indention_options;
    }

    public short getJustifyLast() {
        return _justify_last.getShortValue(this.field_4_alignment_options);
    }

    public short getLeftBorderPaletteIdx() {
        return _left_border_palette_idx.getShortValue(this.field_7_palette_options);
    }

    public boolean getMergeCells() {
        return _merge_cells.isSet(this.field_5_indention_options);
    }

    public short getPaletteOptions() {
        return this.field_7_palette_options;
    }

    public short getParentIndex() {
        return _parent_index.getShortValue(this.field_3_cell_options);
    }

    public short getReadingOrder() {
        return _reading_order.getShortValue(this.field_5_indention_options);
    }

    public short getRightBorderPaletteIdx() {
        return _right_border_palette_idx.getShortValue(this.field_7_palette_options);
    }

    public short getRotation() {
        return _rotation.getShortValue(this.field_4_alignment_options);
    }

    public boolean getShrinkToFit() {
        return _shrink_to_fit.isSet(this.field_5_indention_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getTopBorderPaletteIdx() {
        return (short) _top_border_palette_idx.getValue(this.field_8_adtl_palette_options);
    }

    public short getVerticalAlignment() {
        return _vertical_alignment.getShortValue(this.field_4_alignment_options);
    }

    public boolean getWrapText() {
        return _wrap_text.isSet(this.field_4_alignment_options);
    }

    public short getXFType() {
        return _xf_type.getShortValue(this.field_3_cell_options);
    }

    public int hashCode() {
        return Objects.hash(Short.valueOf(this.field_1_font_index), Short.valueOf(this.field_2_format_index), Short.valueOf(this.field_3_cell_options), Short.valueOf(this.field_4_alignment_options), Short.valueOf(this.field_5_indention_options), Short.valueOf(this.field_6_border_options), Short.valueOf(this.field_7_palette_options), Integer.valueOf(this.field_8_adtl_palette_options), Short.valueOf(this.field_9_fill_palette_options));
    }

    public boolean isHidden() {
        return _hidden.isSet(this.field_3_cell_options);
    }

    public boolean isIndentNotParentAlignment() {
        return _indent_not_parent_alignment.isSet(this.field_5_indention_options);
    }

    public boolean isIndentNotParentBorder() {
        return _indent_not_parent_border.isSet(this.field_5_indention_options);
    }

    public boolean isIndentNotParentCellOptions() {
        return _indent_not_parent_cell_options.isSet(this.field_5_indention_options);
    }

    public boolean isIndentNotParentFont() {
        return _indent_not_parent_font.isSet(this.field_5_indention_options);
    }

    public boolean isIndentNotParentFormat() {
        return _indent_not_parent_format.isSet(this.field_5_indention_options);
    }

    public boolean isIndentNotParentPattern() {
        return _indent_not_parent_pattern.isSet(this.field_5_indention_options);
    }

    public boolean isLocked() {
        return _locked.isSet(this.field_3_cell_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFontIndex());
        littleEndianOutput.writeShort(getFormatIndex());
        littleEndianOutput.writeShort(getCellOptions());
        littleEndianOutput.writeShort(getAlignmentOptions());
        littleEndianOutput.writeShort(getIndentionOptions());
        littleEndianOutput.writeShort(getBorderOptions());
        littleEndianOutput.writeShort(getPaletteOptions());
        littleEndianOutput.writeInt(getAdtlPaletteOptions());
        littleEndianOutput.writeShort(getFillPaletteOptions());
    }

    public void set123Prefix(boolean z6) {
        this.field_3_cell_options = _123_prefix.setShortBoolean(this.field_3_cell_options, z6);
    }

    public void setAdtlDiag(short s6) {
        this.field_8_adtl_palette_options = _adtl_diag.setValue(this.field_8_adtl_palette_options, s6);
    }

    public void setAdtlDiagLineStyle(short s6) {
        this.field_8_adtl_palette_options = _adtl_diag_line_style.setValue(this.field_8_adtl_palette_options, s6);
    }

    public void setAdtlFillPattern(short s6) {
        this.field_8_adtl_palette_options = _adtl_fill_pattern.setValue(this.field_8_adtl_palette_options, s6);
    }

    public void setAdtlPaletteOptions(short s6) {
        this.field_8_adtl_palette_options = s6;
    }

    public void setAlignment(short s6) {
        this.field_4_alignment_options = _alignment.setShortValue(this.field_4_alignment_options, s6);
    }

    public void setAlignmentOptions(short s6) {
        this.field_4_alignment_options = s6;
    }

    public void setBorderBottom(short s6) {
        this.field_6_border_options = _border_bottom.setShortValue(this.field_6_border_options, s6);
    }

    public void setBorderLeft(short s6) {
        this.field_6_border_options = _border_left.setShortValue(this.field_6_border_options, s6);
    }

    public void setBorderOptions(short s6) {
        this.field_6_border_options = s6;
    }

    public void setBorderRight(short s6) {
        this.field_6_border_options = _border_right.setShortValue(this.field_6_border_options, s6);
    }

    public void setBorderTop(short s6) {
        this.field_6_border_options = _border_top.setShortValue(this.field_6_border_options, s6);
    }

    public void setBottomBorderPaletteIdx(short s6) {
        this.field_8_adtl_palette_options = _bottom_border_palette_idx.setValue(this.field_8_adtl_palette_options, s6);
    }

    public void setCellOptions(short s6) {
        this.field_3_cell_options = s6;
    }

    public void setDiag(short s6) {
        this.field_7_palette_options = _diag.setShortValue(this.field_7_palette_options, s6);
    }

    public void setFillBackground(short s6) {
        this.field_9_fill_palette_options = _fill_background.setShortValue(this.field_9_fill_palette_options, s6);
    }

    public void setFillForeground(short s6) {
        this.field_9_fill_palette_options = _fill_foreground.setShortValue(this.field_9_fill_palette_options, s6);
    }

    public void setFillPaletteOptions(short s6) {
        this.field_9_fill_palette_options = s6;
    }

    public void setFontIndex(short s6) {
        this.field_1_font_index = s6;
    }

    public void setFormatIndex(short s6) {
        this.field_2_format_index = s6;
    }

    public void setHidden(boolean z6) {
        this.field_3_cell_options = _hidden.setShortBoolean(this.field_3_cell_options, z6);
    }

    public void setIndent(short s6) {
        this.field_5_indention_options = _indent.setShortValue(this.field_5_indention_options, s6);
    }

    public void setIndentNotParentAlignment(boolean z6) {
        this.field_5_indention_options = _indent_not_parent_alignment.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setIndentNotParentBorder(boolean z6) {
        this.field_5_indention_options = _indent_not_parent_border.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setIndentNotParentCellOptions(boolean z6) {
        this.field_5_indention_options = _indent_not_parent_cell_options.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setIndentNotParentFont(boolean z6) {
        this.field_5_indention_options = _indent_not_parent_font.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setIndentNotParentFormat(boolean z6) {
        this.field_5_indention_options = _indent_not_parent_format.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setIndentNotParentPattern(boolean z6) {
        this.field_5_indention_options = _indent_not_parent_pattern.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setIndentionOptions(short s6) {
        this.field_5_indention_options = s6;
    }

    public void setJustifyLast(short s6) {
        this.field_4_alignment_options = _justify_last.setShortValue(this.field_4_alignment_options, s6);
    }

    public void setLeftBorderPaletteIdx(short s6) {
        this.field_7_palette_options = _left_border_palette_idx.setShortValue(this.field_7_palette_options, s6);
    }

    public void setLocked(boolean z6) {
        this.field_3_cell_options = _locked.setShortBoolean(this.field_3_cell_options, z6);
    }

    public void setMergeCells(boolean z6) {
        this.field_5_indention_options = _merge_cells.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setPaletteOptions(short s6) {
        this.field_7_palette_options = s6;
    }

    public void setParentIndex(short s6) {
        this.field_3_cell_options = _parent_index.setShortValue(this.field_3_cell_options, s6);
    }

    public void setReadingOrder(short s6) {
        this.field_5_indention_options = _reading_order.setShortValue(this.field_5_indention_options, s6);
    }

    public void setRightBorderPaletteIdx(short s6) {
        this.field_7_palette_options = _right_border_palette_idx.setShortValue(this.field_7_palette_options, s6);
    }

    public void setRotation(short s6) {
        this.field_4_alignment_options = _rotation.setShortValue(this.field_4_alignment_options, s6);
    }

    public void setShrinkToFit(boolean z6) {
        this.field_5_indention_options = _shrink_to_fit.setShortBoolean(this.field_5_indention_options, z6);
    }

    public void setTopBorderPaletteIdx(short s6) {
        this.field_8_adtl_palette_options = _top_border_palette_idx.setValue(this.field_8_adtl_palette_options, s6);
    }

    public void setVerticalAlignment(short s6) {
        this.field_4_alignment_options = _vertical_alignment.setShortValue(this.field_4_alignment_options, s6);
    }

    public void setWrapText(boolean z6) {
        this.field_4_alignment_options = _wrap_text.setShortBoolean(this.field_4_alignment_options, z6);
    }

    public void setXFType(short s6) {
        this.field_3_cell_options = _xf_type.setShortValue(this.field_3_cell_options, s6);
    }

    public int[] stateSummary() {
        return new int[]{this.field_1_font_index, this.field_2_format_index, this.field_3_cell_options, this.field_4_alignment_options, this.field_5_indention_options, this.field_6_border_options, this.field_7_palette_options, this.field_8_adtl_palette_options, this.field_9_fill_palette_options};
    }

    public ExtendedFormatRecord(ExtendedFormatRecord extendedFormatRecord) {
        super(extendedFormatRecord);
        this.field_1_font_index = extendedFormatRecord.field_1_font_index;
        this.field_2_format_index = extendedFormatRecord.field_2_format_index;
        this.field_3_cell_options = extendedFormatRecord.field_3_cell_options;
        this.field_4_alignment_options = extendedFormatRecord.field_4_alignment_options;
        this.field_5_indention_options = extendedFormatRecord.field_5_indention_options;
        this.field_6_border_options = extendedFormatRecord.field_6_border_options;
        this.field_7_palette_options = extendedFormatRecord.field_7_palette_options;
        this.field_8_adtl_palette_options = extendedFormatRecord.field_8_adtl_palette_options;
        this.field_9_fill_palette_options = extendedFormatRecord.field_9_fill_palette_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTENDED_FORMAT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ExtendedFormatRecord copy() {
        return new ExtendedFormatRecord(this);
    }

    public ExtendedFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_font_index = recordInputStream.readShort();
        this.field_2_format_index = recordInputStream.readShort();
        this.field_3_cell_options = recordInputStream.readShort();
        this.field_4_alignment_options = recordInputStream.readShort();
        this.field_5_indention_options = recordInputStream.readShort();
        this.field_6_border_options = recordInputStream.readShort();
        this.field_7_palette_options = recordInputStream.readShort();
        this.field_8_adtl_palette_options = recordInputStream.readInt();
        this.field_9_fill_palette_options = recordInputStream.readShort();
    }
}
