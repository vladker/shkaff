package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WindowOneRecord extends StandardRecord {
    public static final short sid = 61;
    private short field_1_h_hold;
    private short field_2_v_hold;
    private short field_3_width;
    private short field_4_height;
    private short field_5_options;
    private int field_6_active_sheet;
    private int field_7_first_visible_tab;
    private short field_8_num_selected_tabs;
    private short field_9_tab_width_ratio;
    private static final BitField hidden = BitFieldFactory.getInstance(1);
    private static final BitField iconic = BitFieldFactory.getInstance(2);
    private static final BitField reserved = BitFieldFactory.getInstance(4);
    private static final BitField hscroll = BitFieldFactory.getInstance(8);
    private static final BitField vscroll = BitFieldFactory.getInstance(16);
    private static final BitField tabs = BitFieldFactory.getInstance(32);

    public WindowOneRecord() {
    }

    public int getActiveSheetIndex() {
        return this.field_6_active_sheet;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    public boolean getDisplayHorizontalScrollbar() {
        return hscroll.isSet(this.field_5_options);
    }

    public boolean getDisplayTabs() {
        return tabs.isSet(this.field_5_options);
    }

    public boolean getDisplayVerticalScrollbar() {
        return vscroll.isSet(this.field_5_options);
    }

    public int getFirstVisibleTab() {
        return this.field_7_first_visible_tab;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        };
        final int i8 = 3;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        }, new BitField[]{hidden, iconic, reserved, hscroll, vscroll, tabs}, new String[]{"HIDDEN", "ICONIC", "RESERVED", "HSCROLL", "VSCROLL", "TABS"});
        final int i9 = 4;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        };
        final int i10 = 5;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        return GenericRecordUtil.getGenericProperties("horizontalHold", supplier, "verticalHold", supplier2, "width", supplier3, "options", bitsAsString, "activeSheetIndex", supplier4, "firstVisibleTab", supplier5, "numSelectedTabs", new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        }, "tabWidthRatio", new Supplier(this) { // from class: org.apache.poi.hssf.record.Y0
            public final /* synthetic */ WindowOneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Short.valueOf(this.b.getHorizontalHold());
                    case 1:
                        return Short.valueOf(this.b.getVerticalHold());
                    case 2:
                        return Short.valueOf(this.b.getWidth());
                    case 3:
                        return Short.valueOf(this.b.getOptions());
                    case 4:
                        return Integer.valueOf(this.b.getActiveSheetIndex());
                    case 5:
                        return Integer.valueOf(this.b.getFirstVisibleTab());
                    case 6:
                        return Short.valueOf(this.b.getNumSelectedTabs());
                    default:
                        return Short.valueOf(this.b.getTabWidthRatio());
                }
            }
        });
    }

    public short getHeight() {
        return this.field_4_height;
    }

    public boolean getHidden() {
        return hidden.isSet(this.field_5_options);
    }

    public short getHorizontalHold() {
        return this.field_1_h_hold;
    }

    public boolean getIconic() {
        return iconic.isSet(this.field_5_options);
    }

    public short getNumSelectedTabs() {
        return this.field_8_num_selected_tabs;
    }

    public short getOptions() {
        return this.field_5_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 61;
    }

    public short getTabWidthRatio() {
        return this.field_9_tab_width_ratio;
    }

    public short getVerticalHold() {
        return this.field_2_v_hold;
    }

    public short getWidth() {
        return this.field_3_width;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getHorizontalHold());
        littleEndianOutput.writeShort(getVerticalHold());
        littleEndianOutput.writeShort(getWidth());
        littleEndianOutput.writeShort(getHeight());
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeShort(getActiveSheetIndex());
        littleEndianOutput.writeShort(getFirstVisibleTab());
        littleEndianOutput.writeShort(getNumSelectedTabs());
        littleEndianOutput.writeShort(getTabWidthRatio());
    }

    public void setActiveSheetIndex(int i5) {
        this.field_6_active_sheet = i5;
    }

    public void setDisplayHorizonalScrollbar(boolean z6) {
        this.field_5_options = hscroll.setShortBoolean(this.field_5_options, z6);
    }

    public void setDisplayTabs(boolean z6) {
        this.field_5_options = tabs.setShortBoolean(this.field_5_options, z6);
    }

    public void setDisplayVerticalScrollbar(boolean z6) {
        this.field_5_options = vscroll.setShortBoolean(this.field_5_options, z6);
    }

    public void setFirstVisibleTab(int i5) {
        this.field_7_first_visible_tab = i5;
    }

    public void setHeight(short s6) {
        this.field_4_height = s6;
    }

    public void setHidden(boolean z6) {
        this.field_5_options = hidden.setShortBoolean(this.field_5_options, z6);
    }

    public void setHorizontalHold(short s6) {
        this.field_1_h_hold = s6;
    }

    public void setIconic(boolean z6) {
        this.field_5_options = iconic.setShortBoolean(this.field_5_options, z6);
    }

    public void setNumSelectedTabs(short s6) {
        this.field_8_num_selected_tabs = s6;
    }

    public void setOptions(short s6) {
        this.field_5_options = s6;
    }

    public void setTabWidthRatio(short s6) {
        this.field_9_tab_width_ratio = s6;
    }

    public void setVerticalHold(short s6) {
        this.field_2_v_hold = s6;
    }

    public void setWidth(short s6) {
        this.field_3_width = s6;
    }

    public WindowOneRecord(WindowOneRecord windowOneRecord) {
        super(windowOneRecord);
        this.field_1_h_hold = windowOneRecord.field_1_h_hold;
        this.field_2_v_hold = windowOneRecord.field_2_v_hold;
        this.field_3_width = windowOneRecord.field_3_width;
        this.field_4_height = windowOneRecord.field_4_height;
        this.field_5_options = windowOneRecord.field_5_options;
        this.field_6_active_sheet = windowOneRecord.field_6_active_sheet;
        this.field_7_first_visible_tab = windowOneRecord.field_7_first_visible_tab;
        this.field_8_num_selected_tabs = windowOneRecord.field_8_num_selected_tabs;
        this.field_9_tab_width_ratio = windowOneRecord.field_9_tab_width_ratio;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WINDOW_ONE;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public WindowOneRecord copy() {
        return new WindowOneRecord(this);
    }

    public WindowOneRecord(RecordInputStream recordInputStream) {
        this.field_1_h_hold = recordInputStream.readShort();
        this.field_2_v_hold = recordInputStream.readShort();
        this.field_3_width = recordInputStream.readShort();
        this.field_4_height = recordInputStream.readShort();
        this.field_5_options = recordInputStream.readShort();
        this.field_6_active_sheet = recordInputStream.readShort();
        this.field_7_first_visible_tab = recordInputStream.readShort();
        this.field_8_num_selected_tabs = recordInputStream.readShort();
        this.field_9_tab_width_ratio = recordInputStream.readShort();
    }
}
