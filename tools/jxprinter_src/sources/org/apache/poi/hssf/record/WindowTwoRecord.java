package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WindowTwoRecord extends StandardRecord {
    public static final short sid = 574;
    private short field_1_options;
    private short field_2_top_row;
    private short field_3_left_col;
    private int field_4_header_color;
    private short field_5_page_break_zoom;
    private short field_6_normal_zoom;
    private int field_7_reserved;
    private static final BitField displayFormulas = BitFieldFactory.getInstance(1);
    private static final BitField displayGridlines = BitFieldFactory.getInstance(2);
    private static final BitField displayRowColHeadings = BitFieldFactory.getInstance(4);
    private static final BitField freezePanes = BitFieldFactory.getInstance(8);
    private static final BitField displayZeros = BitFieldFactory.getInstance(16);
    private static final BitField defaultHeader = BitFieldFactory.getInstance(32);
    private static final BitField arabic = BitFieldFactory.getInstance(64);
    private static final BitField displayGuts = BitFieldFactory.getInstance(128);
    private static final BitField freezePanesNoSplit = BitFieldFactory.getInstance(256);
    private static final BitField selected = BitFieldFactory.getInstance(512);
    private static final BitField active = BitFieldFactory.getInstance(1024);
    private static final BitField savedInPageBreakPreview = BitFieldFactory.getInstance(2048);

    public WindowTwoRecord() {
    }

    public boolean getArabic() {
        return arabic.isSet(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    public boolean getDefaultHeader() {
        return defaultHeader.isSet(this.field_1_options);
    }

    public boolean getDisplayFormulas() {
        return displayFormulas.isSet(this.field_1_options);
    }

    public boolean getDisplayGridlines() {
        return displayGridlines.isSet(this.field_1_options);
    }

    public boolean getDisplayGuts() {
        return displayGuts.isSet(this.field_1_options);
    }

    public boolean getDisplayRowColHeadings() {
        return displayRowColHeadings.isSet(this.field_1_options);
    }

    public boolean getDisplayZeros() {
        return displayZeros.isSet(this.field_1_options);
    }

    public boolean getFreezePanes() {
        return freezePanes.isSet(this.field_1_options);
    }

    public boolean getFreezePanesNoSplit() {
        return freezePanesNoSplit.isSet(this.field_1_options);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        }, new BitField[]{displayFormulas, displayGridlines, displayRowColHeadings, freezePanes, displayZeros, defaultHeader, arabic, displayGuts, freezePanesNoSplit, selected, active, savedInPageBreakPreview}, new String[]{"DISPLAY_FORMULAS", "DISPLAY_GRIDLINES", "DISPLAY_ROW_COL_HEADINGS", "FREEZE_PANES", "DISPLAY_ZEROS", "DEFAULT_HEADER", "ARABIC", "DISPLAY_GUTS", "FREEZE_PANES_NO_SPLIT", "SELECTED", "ACTIVE", "SAVED_IN_PAGE_BREAK_PREVIEW"});
        final int i6 = 1;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        };
        final int i10 = 5;
        final int i11 = 6;
        return GenericRecordUtil.getGenericProperties("options", bitsAsString, "topRow", supplier, "leftCol", supplier2, "headerColor", supplier3, "pageBreakZoom", supplier4, "normalZoom", new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        }, "reserved", new Supplier(this) { // from class: org.apache.poi.hssf.record.a1
            public final /* synthetic */ WindowTwoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getOptions());
                    case 1:
                        return Short.valueOf(this.b.getTopRow());
                    case 2:
                        return Short.valueOf(this.b.getLeftCol());
                    case 3:
                        return Integer.valueOf(this.b.getHeaderColor());
                    case 4:
                        return Short.valueOf(this.b.getPageBreakZoom());
                    case 5:
                        return Short.valueOf(this.b.getNormalZoom());
                    default:
                        return Integer.valueOf(this.b.getReserved());
                }
            }
        });
    }

    public int getHeaderColor() {
        return this.field_4_header_color;
    }

    public short getLeftCol() {
        return this.field_3_left_col;
    }

    public short getNormalZoom() {
        return this.field_6_normal_zoom;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    public short getPageBreakZoom() {
        return this.field_5_page_break_zoom;
    }

    public int getReserved() {
        return this.field_7_reserved;
    }

    public boolean getSavedInPageBreakPreview() {
        return savedInPageBreakPreview.isSet(this.field_1_options);
    }

    public boolean getSelected() {
        return selected.isSet(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getTopRow() {
        return this.field_2_top_row;
    }

    public boolean isActive() {
        return active.isSet(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeShort(getTopRow());
        littleEndianOutput.writeShort(getLeftCol());
        littleEndianOutput.writeInt(getHeaderColor());
        littleEndianOutput.writeShort(getPageBreakZoom());
        littleEndianOutput.writeShort(getNormalZoom());
        littleEndianOutput.writeInt(getReserved());
    }

    public void setActive(boolean z6) {
        this.field_1_options = active.setShortBoolean(this.field_1_options, z6);
    }

    public void setArabic(boolean z6) {
        this.field_1_options = arabic.setShortBoolean(this.field_1_options, z6);
    }

    public void setDefaultHeader(boolean z6) {
        this.field_1_options = defaultHeader.setShortBoolean(this.field_1_options, z6);
    }

    public void setDisplayFormulas(boolean z6) {
        this.field_1_options = displayFormulas.setShortBoolean(this.field_1_options, z6);
    }

    public void setDisplayGridlines(boolean z6) {
        this.field_1_options = displayGridlines.setShortBoolean(this.field_1_options, z6);
    }

    public void setDisplayGuts(boolean z6) {
        this.field_1_options = displayGuts.setShortBoolean(this.field_1_options, z6);
    }

    public void setDisplayRowColHeadings(boolean z6) {
        this.field_1_options = displayRowColHeadings.setShortBoolean(this.field_1_options, z6);
    }

    public void setDisplayZeros(boolean z6) {
        this.field_1_options = displayZeros.setShortBoolean(this.field_1_options, z6);
    }

    public void setFreezePanes(boolean z6) {
        this.field_1_options = freezePanes.setShortBoolean(this.field_1_options, z6);
    }

    public void setFreezePanesNoSplit(boolean z6) {
        this.field_1_options = freezePanesNoSplit.setShortBoolean(this.field_1_options, z6);
    }

    public void setHeaderColor(int i5) {
        this.field_4_header_color = i5;
    }

    public void setLeftCol(short s6) {
        this.field_3_left_col = s6;
    }

    public void setNormalZoom(short s6) {
        this.field_6_normal_zoom = s6;
    }

    public void setOptions(short s6) {
        this.field_1_options = s6;
    }

    public void setPageBreakZoom(short s6) {
        this.field_5_page_break_zoom = s6;
    }

    public void setReserved(int i5) {
        this.field_7_reserved = i5;
    }

    public void setSavedInPageBreakPreview(boolean z6) {
        this.field_1_options = savedInPageBreakPreview.setShortBoolean(this.field_1_options, z6);
    }

    public void setSelected(boolean z6) {
        this.field_1_options = selected.setShortBoolean(this.field_1_options, z6);
    }

    public void setTopRow(short s6) {
        this.field_2_top_row = s6;
    }

    public WindowTwoRecord(WindowTwoRecord windowTwoRecord) {
        super(windowTwoRecord);
        this.field_1_options = windowTwoRecord.field_1_options;
        this.field_2_top_row = windowTwoRecord.field_2_top_row;
        this.field_3_left_col = windowTwoRecord.field_3_left_col;
        this.field_4_header_color = windowTwoRecord.field_4_header_color;
        this.field_5_page_break_zoom = windowTwoRecord.field_5_page_break_zoom;
        this.field_6_normal_zoom = windowTwoRecord.field_6_normal_zoom;
        this.field_7_reserved = windowTwoRecord.field_7_reserved;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WINDOW_TWO;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public WindowTwoRecord copy() {
        return new WindowTwoRecord(this);
    }

    public WindowTwoRecord(RecordInputStream recordInputStream) {
        int iRemaining = recordInputStream.remaining();
        this.field_1_options = recordInputStream.readShort();
        this.field_2_top_row = recordInputStream.readShort();
        this.field_3_left_col = recordInputStream.readShort();
        this.field_4_header_color = recordInputStream.readInt();
        if (iRemaining > 10) {
            this.field_5_page_break_zoom = recordInputStream.readShort();
            this.field_6_normal_zoom = recordInputStream.readShort();
        }
        if (iRemaining > 14) {
            this.field_7_reserved = recordInputStream.readInt();
        }
    }
}
