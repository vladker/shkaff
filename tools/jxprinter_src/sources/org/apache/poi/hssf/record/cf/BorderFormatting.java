package org.apache.poi.hssf.record.cf;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cf.BorderFormatting;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BorderFormatting implements Duplicatable, GenericRecord {
    public static final short BORDER_DASHED = 3;
    public static final short BORDER_DASH_DOT = 9;
    public static final short BORDER_DASH_DOT_DOT = 11;
    public static final short BORDER_DOTTED = 7;
    public static final short BORDER_DOUBLE = 6;
    public static final short BORDER_HAIR = 4;
    public static final short BORDER_MEDIUM = 2;
    public static final short BORDER_MEDIUM_DASHED = 8;
    public static final short BORDER_MEDIUM_DASH_DOT = 10;
    public static final short BORDER_MEDIUM_DASH_DOT_DOT = 12;
    public static final short BORDER_NONE = 0;
    public static final short BORDER_SLANTED_DASH_DOT = 13;
    public static final short BORDER_THICK = 5;
    public static final short BORDER_THIN = 1;
    private int field_13_border_styles1;
    private int field_14_border_styles2;
    private static final BitField bordLeftLineStyle = BitFieldFactory.getInstance(15);
    private static final BitField bordRightLineStyle = BitFieldFactory.getInstance(240);
    private static final BitField bordTopLineStyle = BitFieldFactory.getInstance(3840);
    private static final BitField bordBottomLineStyle = BitFieldFactory.getInstance(61440);
    private static final BitField bordLeftLineColor = BitFieldFactory.getInstance(8323072);
    private static final BitField bordRightLineColor = BitFieldFactory.getInstance(1065353216);
    private static final BitField bordTlBrLineOnOff = BitFieldFactory.getInstance(1073741824);
    private static final BitField bordBlTrtLineOnOff = BitFieldFactory.getInstance(Integer.MIN_VALUE);
    private static final BitField bordTopLineColor = BitFieldFactory.getInstance(127);
    private static final BitField bordBottomLineColor = BitFieldFactory.getInstance(16256);
    private static final BitField bordDiagLineColor = BitFieldFactory.getInstance(2080768);
    private static final BitField bordDiagLineStyle = BitFieldFactory.getInstance(31457280);

    public BorderFormatting() {
        this.field_13_border_styles1 = 0;
        this.field_14_border_styles2 = 0;
    }

    public int getBorderBottom() {
        return bordBottomLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderDiagonal() {
        return bordDiagLineStyle.getValue(this.field_14_border_styles2);
    }

    public int getBorderLeft() {
        return bordLeftLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderRight() {
        return bordRightLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderTop() {
        return bordTopLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBottomBorderColor() {
        return bordBottomLineColor.getValue(this.field_14_border_styles2);
    }

    public int getDataLength() {
        return 8;
    }

    public int getDiagonalBorderColor() {
        return bordDiagLineColor.getValue(this.field_14_border_styles2);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put(CellUtil.BORDER_LEFT, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put(CellUtil.BORDER_RIGHT, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put(CellUtil.BORDER_TOP, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put(CellUtil.BORDER_BOTTOM, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put(CellUtil.LEFT_BORDER_COLOR, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put(CellUtil.RIGHT_BORDER_COLOR, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put(CellUtil.TOP_BORDER_COLOR, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put(CellUtil.BOTTOM_BORDER_COLOR, new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i13 = 8;
        linkedHashMap.put("forwardDiagonalOn", new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        final int i14 = 9;
        linkedHashMap.put("backwardDiagonalOn", new Supplier(this) { // from class: H4.a
            public final /* synthetic */ BorderFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Integer.valueOf(this.b.getBorderLeft());
                    case 1:
                        return Integer.valueOf(this.b.getBorderRight());
                    case 2:
                        return Integer.valueOf(this.b.getBorderTop());
                    case 3:
                        return Integer.valueOf(this.b.getBorderBottom());
                    case 4:
                        return Integer.valueOf(this.b.getLeftBorderColor());
                    case 5:
                        return Integer.valueOf(this.b.getRightBorderColor());
                    case 6:
                        return Integer.valueOf(this.b.getTopBorderColor());
                    case 7:
                        return Integer.valueOf(this.b.getBottomBorderColor());
                    case 8:
                        return Boolean.valueOf(this.b.isForwardDiagonalOn());
                    default:
                        return Boolean.valueOf(this.b.isBackwardDiagonalOn());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public int getLeftBorderColor() {
        return bordLeftLineColor.getValue(this.field_13_border_styles1);
    }

    public int getRightBorderColor() {
        return bordRightLineColor.getValue(this.field_13_border_styles1);
    }

    public int getTopBorderColor() {
        return bordTopLineColor.getValue(this.field_14_border_styles2);
    }

    public boolean isBackwardDiagonalOn() {
        return bordTlBrLineOnOff.isSet(this.field_13_border_styles1);
    }

    public boolean isForwardDiagonalOn() {
        return bordBlTrtLineOnOff.isSet(this.field_13_border_styles1);
    }

    public int serialize(int i5, byte[] bArr) {
        LittleEndian.putInt(bArr, i5, this.field_13_border_styles1);
        LittleEndian.putInt(bArr, i5 + 4, this.field_14_border_styles2);
        return 8;
    }

    public void setBackwardDiagonalOn(boolean z6) {
        this.field_13_border_styles1 = bordTlBrLineOnOff.setBoolean(this.field_13_border_styles1, z6);
    }

    public void setBorderBottom(int i5) {
        this.field_13_border_styles1 = bordBottomLineStyle.setValue(this.field_13_border_styles1, i5);
    }

    public void setBorderDiagonal(int i5) {
        this.field_14_border_styles2 = bordDiagLineStyle.setValue(this.field_14_border_styles2, i5);
    }

    public void setBorderLeft(int i5) {
        this.field_13_border_styles1 = bordLeftLineStyle.setValue(this.field_13_border_styles1, i5);
    }

    public void setBorderRight(int i5) {
        this.field_13_border_styles1 = bordRightLineStyle.setValue(this.field_13_border_styles1, i5);
    }

    public void setBorderTop(int i5) {
        this.field_13_border_styles1 = bordTopLineStyle.setValue(this.field_13_border_styles1, i5);
    }

    public void setBottomBorderColor(int i5) {
        this.field_14_border_styles2 = bordBottomLineColor.setValue(this.field_14_border_styles2, i5);
    }

    public void setDiagonalBorderColor(int i5) {
        this.field_14_border_styles2 = bordDiagLineColor.setValue(this.field_14_border_styles2, i5);
    }

    public void setForwardDiagonalOn(boolean z6) {
        this.field_13_border_styles1 = bordBlTrtLineOnOff.setBoolean(this.field_13_border_styles1, z6);
    }

    public void setLeftBorderColor(int i5) {
        this.field_13_border_styles1 = bordLeftLineColor.setValue(this.field_13_border_styles1, i5);
    }

    public void setRightBorderColor(int i5) {
        this.field_13_border_styles1 = bordRightLineColor.setValue(this.field_13_border_styles1, i5);
    }

    public void setTopBorderColor(int i5) {
        this.field_14_border_styles2 = bordTopLineColor.setValue(this.field_14_border_styles2, i5);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public BorderFormatting copy() {
        return new BorderFormatting(this);
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_13_border_styles1);
        littleEndianOutput.writeInt(this.field_14_border_styles2);
    }

    public BorderFormatting(BorderFormatting borderFormatting) {
        this.field_13_border_styles1 = borderFormatting.field_13_border_styles1;
        this.field_14_border_styles2 = borderFormatting.field_14_border_styles2;
    }

    public BorderFormatting(LittleEndianInput littleEndianInput) {
        this.field_13_border_styles1 = littleEndianInput.readInt();
        this.field_14_border_styles2 = littleEndianInput.readInt();
    }
}
