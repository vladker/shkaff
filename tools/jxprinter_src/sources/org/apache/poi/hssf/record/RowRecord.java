package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RowRecord extends StandardRecord {
    public static final int ENCODED_SIZE = 20;
    private static final int OPTION_BITS_ALWAYS_SET = 256;
    public static final short sid = 520;
    private int field_1_row_number;
    private int field_2_first_col;
    private int field_3_last_col;
    private short field_4_height;
    private short field_5_optimize;
    private short field_6_reserved;
    private int field_7_option_flags;
    private int field_8_option_flags;
    private static final BitField outlineLevel = BitFieldFactory.getInstance(7);
    private static final BitField collapsed = BitFieldFactory.getInstance(16);
    private static final BitField zeroHeight = BitFieldFactory.getInstance(32);
    private static final BitField badFontHeight = BitFieldFactory.getInstance(64);
    private static final BitField formatted = BitFieldFactory.getInstance(128);
    private static final BitField xfIndex = BitFieldFactory.getInstance(4095);
    private static final BitField topBorder = BitFieldFactory.getInstance(4096);
    private static final BitField bottomBorder = BitFieldFactory.getInstance(8192);
    private static final BitField phoneticGuide = BitFieldFactory.getInstance(16384);

    public RowRecord(RowRecord rowRecord) {
        super(rowRecord);
        this.field_1_row_number = rowRecord.field_1_row_number;
        this.field_2_first_col = rowRecord.field_2_first_col;
        this.field_3_last_col = rowRecord.field_3_last_col;
        this.field_4_height = rowRecord.field_4_height;
        this.field_5_optimize = rowRecord.field_5_optimize;
        this.field_6_reserved = rowRecord.field_6_reserved;
        this.field_7_option_flags = rowRecord.field_7_option_flags;
        this.field_8_option_flags = rowRecord.field_8_option_flags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Short.valueOf(this.field_6_reserved);
    }

    public boolean getBadFontHeight() {
        return badFontHeight.isSet(this.field_7_option_flags);
    }

    public boolean getBottomBorder() {
        return bottomBorder.isSet(this.field_8_option_flags);
    }

    public boolean getColapsed() {
        return collapsed.isSet(this.field_7_option_flags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    public int getFirstCol() {
        return this.field_2_first_col;
    }

    public boolean getFormatted() {
        return formatted.isSet(this.field_7_option_flags);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("rowNumber", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("firstCol", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("lastCol", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("height", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("optimized", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("reserved", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("options", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        }, new BitField[]{collapsed, zeroHeight, badFontHeight, formatted}, new String[]{"COLAPSED", "ZERO_HEIGHT", "BAD_FONT_HEIGHT", "FORMATTED"}));
        final int i12 = 7;
        linkedHashMap.put("outlineLevel", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        final int i13 = 8;
        linkedHashMap.put("optionFlags2", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        }, new BitField[]{topBorder, bottomBorder, phoneticGuide}, new String[]{"TOP_BORDER", "BOTTOM_BORDER", "PHOENETIC_GUIDE"}));
        final int i14 = 9;
        linkedHashMap.put("xfIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.I0
            public final /* synthetic */ RowRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Integer.valueOf(this.b.getRowNumber());
                    case 1:
                        return Integer.valueOf(this.b.getFirstCol());
                    case 2:
                        return Integer.valueOf(this.b.getLastCol());
                    case 3:
                        return Short.valueOf(this.b.getHeight());
                    case 4:
                        return Short.valueOf(this.b.getOptimize());
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return Short.valueOf(this.b.getOptionFlags());
                    case 7:
                        return Short.valueOf(this.b.getOutlineLevel());
                    case 8:
                        return Short.valueOf(this.b.getOptionFlags2());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public short getHeight() {
        return this.field_4_height;
    }

    public int getLastCol() {
        return this.field_3_last_col;
    }

    public short getOptimize() {
        return this.field_5_optimize;
    }

    public short getOptionFlags() {
        return (short) this.field_7_option_flags;
    }

    public short getOptionFlags2() {
        return (short) this.field_8_option_flags;
    }

    public short getOutlineLevel() {
        return (short) outlineLevel.getValue(this.field_7_option_flags);
    }

    public boolean getPhoeneticGuide() {
        return phoneticGuide.isSet(this.field_8_option_flags);
    }

    public int getRowNumber() {
        return this.field_1_row_number;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean getTopBorder() {
        return topBorder.isSet(this.field_8_option_flags);
    }

    public short getXFIndex() {
        return xfIndex.getShortValue((short) this.field_8_option_flags);
    }

    public boolean getZeroHeight() {
        return zeroHeight.isSet(this.field_7_option_flags);
    }

    public boolean isEmpty() {
        return (this.field_2_first_col | this.field_3_last_col) == 0;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRowNumber());
        littleEndianOutput.writeShort(getFirstCol() == -1 ? 0 : getFirstCol());
        littleEndianOutput.writeShort(getLastCol() != -1 ? getLastCol() : 0);
        littleEndianOutput.writeShort(getHeight());
        littleEndianOutput.writeShort(getOptimize());
        littleEndianOutput.writeShort(this.field_6_reserved);
        littleEndianOutput.writeShort(getOptionFlags());
        littleEndianOutput.writeShort(getOptionFlags2());
    }

    public void setBadFontHeight(boolean z6) {
        this.field_7_option_flags = badFontHeight.setBoolean(this.field_7_option_flags, z6);
    }

    public void setBottomBorder(boolean z6) {
        this.field_8_option_flags = bottomBorder.setBoolean(this.field_8_option_flags, z6);
    }

    public void setColapsed(boolean z6) {
        this.field_7_option_flags = collapsed.setBoolean(this.field_7_option_flags, z6);
    }

    public void setEmpty() {
        this.field_2_first_col = 0;
        this.field_3_last_col = 0;
    }

    public void setFirstCol(int i5) {
        this.field_2_first_col = i5;
    }

    public void setFormatted(boolean z6) {
        this.field_7_option_flags = formatted.setBoolean(this.field_7_option_flags, z6);
    }

    public void setHeight(short s6) {
        this.field_4_height = s6;
    }

    public void setLastCol(int i5) {
        this.field_3_last_col = i5;
    }

    public void setOptimize(short s6) {
        this.field_5_optimize = s6;
    }

    public void setOutlineLevel(short s6) {
        this.field_7_option_flags = outlineLevel.setValue(this.field_7_option_flags, s6);
    }

    public void setPhoeneticGuide(boolean z6) {
        this.field_8_option_flags = phoneticGuide.setBoolean(this.field_8_option_flags, z6);
    }

    public void setRowNumber(int i5) {
        this.field_1_row_number = i5;
    }

    public void setTopBorder(boolean z6) {
        this.field_8_option_flags = topBorder.setBoolean(this.field_8_option_flags, z6);
    }

    public void setXFIndex(short s6) {
        this.field_8_option_flags = xfIndex.setValue(this.field_8_option_flags, s6);
    }

    public void setZeroHeight(boolean z6) {
        this.field_7_option_flags = zeroHeight.setBoolean(this.field_7_option_flags, z6);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.ROW;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public RowRecord copy() {
        return new RowRecord(this);
    }

    public RowRecord(int i5) {
        if (i5 >= 0) {
            this.field_1_row_number = i5;
            this.field_4_height = (short) 255;
            this.field_5_optimize = (short) 0;
            this.field_6_reserved = (short) 0;
            this.field_7_option_flags = 256;
            this.field_8_option_flags = 15;
            setEmpty();
            return;
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Invalid row number (", ")"));
    }

    public RowRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        this.field_1_row_number = uShort;
        if (uShort >= 0) {
            this.field_2_first_col = recordInputStream.readShort();
            this.field_3_last_col = recordInputStream.readShort();
            this.field_4_height = recordInputStream.readShort();
            this.field_5_optimize = recordInputStream.readShort();
            this.field_6_reserved = recordInputStream.readShort();
            this.field_7_option_flags = recordInputStream.readShort();
            this.field_8_option_flags = recordInputStream.readShort();
            return;
        }
        throw new IllegalArgumentException(AbstractC0157z.l(" found in InputStream", this.field_1_row_number, new StringBuilder("Invalid row number ")));
    }
}
