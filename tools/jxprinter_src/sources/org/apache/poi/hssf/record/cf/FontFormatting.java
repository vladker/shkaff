package org.apache.poi.hssf.record.cf;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.cf.FontFormatting;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FontFormatting implements Duplicatable, GenericRecord {
    public static final int FONT_CELL_HEIGHT_PRESERVED = -1;
    private static final short FONT_WEIGHT_BOLD = 700;
    private static final short FONT_WEIGHT_NORMAL = 400;
    private static final int OFFSET_ESCAPEMENT_TYPE = 74;
    private static final int OFFSET_ESCAPEMENT_TYPE_MODIFIED = 92;
    private static final int OFFSET_FONT_COLOR_INDEX = 80;
    private static final int OFFSET_FONT_FORMATING_END = 116;
    private static final int OFFSET_FONT_HEIGHT = 64;
    private static final int OFFSET_FONT_NAME = 0;
    private static final int OFFSET_FONT_OPTIONS = 68;
    private static final int OFFSET_FONT_WEIGHT = 72;
    private static final int OFFSET_FONT_WEIGHT_MODIFIED = 100;
    private static final int OFFSET_NOT_USED1 = 104;
    private static final int OFFSET_NOT_USED2 = 108;
    private static final int OFFSET_NOT_USED3 = 112;
    private static final int OFFSET_OPTION_FLAGS = 88;
    private static final int OFFSET_UNDERLINE_TYPE = 76;
    private static final int OFFSET_UNDERLINE_TYPE_MODIFIED = 96;
    private static final int RAW_DATA_SIZE = 118;
    private final byte[] _rawData;
    private static final BitField POSTURE = BitFieldFactory.getInstance(2);
    private static final BitField OUTLINE = BitFieldFactory.getInstance(8);
    private static final BitField SHADOW = BitFieldFactory.getInstance(16);
    private static final BitField CANCELLATION = BitFieldFactory.getInstance(128);

    public FontFormatting() {
        this._rawData = new byte[118];
        setFontHeight(-1);
        setItalic(false);
        setFontWieghtModified(false);
        setOutline(false);
        setShadow(false);
        setStrikeout(false);
        setEscapementType((short) 0);
        setUnderlineType((short) 0);
        setFontColorIndex((short) -1);
        setFontStyleModified(false);
        setFontOutlineModified(false);
        setFontShadowModified(false);
        setFontCancellationModified(false);
        setEscapementTypeModified(false);
        setUnderlineTypeModified(false);
        setShort(0, 0);
        setInt(104, 1);
        setInt(108, 0);
        setInt(112, Integer.MAX_VALUE);
        setShort(116, 1);
    }

    private boolean getFontOption(BitField bitField) {
        return bitField.isSet(getInt(68));
    }

    private int getInt(int i5) {
        return LittleEndian.getInt(this._rawData, i5);
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.getValue(getInt(88)) == 0;
    }

    private short getShort(int i5) {
        return LittleEndian.getShort(this._rawData, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$0() {
        return Integer.valueOf(getInt(88));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$1() {
        return Integer.valueOf(getInt(68));
    }

    private void setFontOption(boolean z6, BitField bitField) {
        setInt(68, bitField.setBoolean(getInt(68), z6));
    }

    private void setFontWeight(short s6) {
        setShort(72, Math.max(100, Math.min(1000, (int) s6)));
    }

    private void setInt(int i5, int i6) {
        LittleEndian.putInt(this._rawData, i5, i6);
    }

    private void setOptionFlag(boolean z6, BitField bitField) {
        setInt(88, bitField.setValue(getInt(88), !z6 ? 1 : 0));
    }

    private void setShort(int i5, int i6) {
        LittleEndian.putShort(this._rawData, i5, (short) i6);
    }

    public int getDataLength() {
        return 118;
    }

    public short getEscapementType() {
        return getShort(74);
    }

    public short getFontColorIndex() {
        return (short) getInt(80);
    }

    public int getFontHeight() {
        return getInt(64);
    }

    public short getFontWeight() {
        return getShort(72);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("fontHeight", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        final int i6 = 1;
        Supplier supplier = new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        };
        BitField bitField = POSTURE;
        BitField bitField2 = OUTLINE;
        BitField bitField3 = SHADOW;
        BitField bitField4 = CANCELLATION;
        linkedHashMap.put("options", GenericRecordUtil.getBitsAsString((Supplier<Number>) supplier, new BitField[]{bitField, bitField2, bitField3, bitField4}, new String[]{"POSTURE_MODIFIED", "OUTLINE_MODIFIED", "SHADOW_MODIFIED", "STRUCKOUT_MODIFIED"}));
        final int i7 = 2;
        linkedHashMap.put("fontOptions", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        }, new BitField[]{bitField, bitField2, bitField3, bitField4}, new String[]{"ITALIC", "OUTLINE", "SHADOW", "STRUCKOUT"}));
        final int i8 = 3;
        linkedHashMap.put("fontWEightModified", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("fontWeight", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        }, new int[]{400, 700}, new String[]{"NORMAL", "BOLD"}));
        final int i10 = 5;
        linkedHashMap.put("escapementTypeModified", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("escapementType", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("underlineTypeModified", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        final int i13 = 8;
        linkedHashMap.put("underlineType", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        final int i14 = 9;
        linkedHashMap.put("colorIndex", new Supplier(this) { // from class: H4.f
            public final /* synthetic */ FontFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Integer.valueOf(this.b.getFontHeight());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return Boolean.valueOf(this.b.isFontWeightModified());
                    case 4:
                        return Short.valueOf(this.b.getFontWeight());
                    case 5:
                        return Boolean.valueOf(this.b.isEscapementTypeModified());
                    case 6:
                        return Short.valueOf(this.b.getEscapementType());
                    case 7:
                        return Boolean.valueOf(this.b.isUnderlineTypeModified());
                    case 8:
                        return Short.valueOf(this.b.getUnderlineType());
                    default:
                        return Short.valueOf(this.b.getFontColorIndex());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public byte[] getRawRecord() {
        return this._rawData;
    }

    public short getUnderlineType() {
        return getShort(76);
    }

    public boolean isBold() {
        return getFontWeight() == 700;
    }

    public boolean isEscapementTypeModified() {
        return getInt(92) == 0;
    }

    public boolean isFontCancellationModified() {
        return getOptionFlag(CANCELLATION);
    }

    public boolean isFontOutlineModified() {
        return getOptionFlag(OUTLINE);
    }

    public boolean isFontShadowModified() {
        return getOptionFlag(SHADOW);
    }

    public boolean isFontStyleModified() {
        return getOptionFlag(POSTURE);
    }

    public boolean isFontWeightModified() {
        return getInt(100) == 0;
    }

    public boolean isItalic() {
        return getFontOption(POSTURE);
    }

    public boolean isOutlineOn() {
        return getFontOption(OUTLINE);
    }

    public boolean isShadowOn() {
        return getFontOption(SHADOW);
    }

    public boolean isStruckout() {
        return getFontOption(CANCELLATION);
    }

    public boolean isUnderlineTypeModified() {
        return getInt(96) == 0;
    }

    public void setBold(boolean z6) {
        setFontWeight(z6 ? FONT_WEIGHT_BOLD : FONT_WEIGHT_NORMAL);
    }

    public void setEscapementType(short s6) {
        setShort(74, s6);
    }

    public void setEscapementTypeModified(boolean z6) {
        setInt(92, !z6 ? 1 : 0);
    }

    public void setFontCancellationModified(boolean z6) {
        setOptionFlag(z6, CANCELLATION);
    }

    public void setFontColorIndex(short s6) {
        setInt(80, s6);
    }

    public void setFontHeight(int i5) {
        setInt(64, i5);
    }

    public void setFontOutlineModified(boolean z6) {
        setOptionFlag(z6, OUTLINE);
    }

    public void setFontShadowModified(boolean z6) {
        setOptionFlag(z6, SHADOW);
    }

    public void setFontStyleModified(boolean z6) {
        setOptionFlag(z6, POSTURE);
    }

    public void setFontWieghtModified(boolean z6) {
        setInt(100, !z6 ? 1 : 0);
    }

    public void setItalic(boolean z6) {
        setFontOption(z6, POSTURE);
    }

    public void setOutline(boolean z6) {
        setFontOption(z6, OUTLINE);
    }

    public void setShadow(boolean z6) {
        setFontOption(z6, SHADOW);
    }

    public void setStrikeout(boolean z6) {
        setFontOption(z6, CANCELLATION);
    }

    public void setUnderlineType(short s6) {
        setShort(76, s6);
    }

    public void setUnderlineTypeModified(boolean z6) {
        setInt(96, !z6 ? 1 : 0);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public FontFormatting copy() {
        return new FontFormatting(this);
    }

    public FontFormatting(FontFormatting fontFormatting) {
        byte[] bArr = new byte[118];
        this._rawData = bArr;
        System.arraycopy(fontFormatting._rawData, 0, bArr, 0, 118);
    }

    public FontFormatting(RecordInputStream recordInputStream) {
        byte[] bArr = new byte[118];
        this._rawData = bArr;
        recordInputStream.readFully(bArr);
    }
}
