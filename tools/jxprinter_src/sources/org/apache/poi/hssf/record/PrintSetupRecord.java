package org.apache.poi.hssf.record;

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
public final class PrintSetupRecord extends StandardRecord {
    public static final short sid = 161;
    private double field_10_footermargin;
    private short field_11_copies;
    private short field_1_paper_size;
    private short field_2_scale;
    private short field_3_page_start;
    private short field_4_fit_width;
    private short field_5_fit_height;
    private short field_6_options;
    private short field_7_hresolution;
    private short field_8_vresolution;
    private double field_9_headermargin;
    private static final BitField lefttoright = BitFieldFactory.getInstance(1);
    private static final BitField landscape = BitFieldFactory.getInstance(2);
    private static final BitField validsettings = BitFieldFactory.getInstance(4);
    private static final BitField nocolor = BitFieldFactory.getInstance(8);
    private static final BitField draft = BitFieldFactory.getInstance(16);
    private static final BitField notes = BitFieldFactory.getInstance(32);
    private static final BitField noOrientation = BitFieldFactory.getInstance(64);
    private static final BitField usepage = BitFieldFactory.getInstance(128);

    public PrintSetupRecord() {
    }

    public short getCopies() {
        return this.field_11_copies;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 34;
    }

    public boolean getDraft() {
        return draft.isSet(this.field_6_options);
    }

    public short getFitHeight() {
        return this.field_5_fit_height;
    }

    public short getFitWidth() {
        return this.field_4_fit_width;
    }

    public double getFooterMargin() {
        return this.field_10_footermargin;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("paperSize", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i6 = 3;
        linkedHashMap.put("scale", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i7 = 4;
        linkedHashMap.put("pageStart", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i8 = 5;
        linkedHashMap.put("fitWidth", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i9 = 6;
        linkedHashMap.put("fitHeight", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i10 = 7;
        linkedHashMap.put("options", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        }, new BitField[]{lefttoright, landscape, validsettings, nocolor, draft, notes, noOrientation, usepage}, new String[]{"lefttoright", "landscape", "validsettings", "nocolor", "draft", "notes", "noOrientation", "usepage"}));
        final int i11 = 8;
        linkedHashMap.put("hResolution", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i12 = 9;
        linkedHashMap.put("vResolution", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i13 = 10;
        linkedHashMap.put("headerMargin", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i14 = 1;
        linkedHashMap.put("footerMargin", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        final int i15 = 2;
        linkedHashMap.put("copies", new Supplier(this) { // from class: org.apache.poi.hssf.record.B0
            public final /* synthetic */ PrintSetupRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return Short.valueOf(this.b.getPaperSize());
                    case 1:
                        return Double.valueOf(this.b.getFooterMargin());
                    case 2:
                        return Short.valueOf(this.b.getCopies());
                    case 3:
                        return Short.valueOf(this.b.getScale());
                    case 4:
                        return Short.valueOf(this.b.getPageStart());
                    case 5:
                        return Short.valueOf(this.b.getFitWidth());
                    case 6:
                        return Short.valueOf(this.b.getFitHeight());
                    case 7:
                        return Short.valueOf(this.b.getOptions());
                    case 8:
                        return Short.valueOf(this.b.getHResolution());
                    case 9:
                        return Short.valueOf(this.b.getVResolution());
                    default:
                        return Double.valueOf(this.b.getHeaderMargin());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public short getHResolution() {
        return this.field_7_hresolution;
    }

    public double getHeaderMargin() {
        return this.field_9_headermargin;
    }

    public boolean getLandscape() {
        return landscape.isSet(this.field_6_options);
    }

    public boolean getLeftToRight() {
        return lefttoright.isSet(this.field_6_options);
    }

    public boolean getNoColor() {
        return nocolor.isSet(this.field_6_options);
    }

    public boolean getNoOrientation() {
        return noOrientation.isSet(this.field_6_options);
    }

    public boolean getNotes() {
        return notes.isSet(this.field_6_options);
    }

    public short getOptions() {
        return this.field_6_options;
    }

    public short getPageStart() {
        return this.field_3_page_start;
    }

    public short getPaperSize() {
        return this.field_1_paper_size;
    }

    public short getScale() {
        return this.field_2_scale;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 161;
    }

    public boolean getUsePage() {
        return usepage.isSet(this.field_6_options);
    }

    public short getVResolution() {
        return this.field_8_vresolution;
    }

    public boolean getValidSettings() {
        return validsettings.isSet(this.field_6_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getPaperSize());
        littleEndianOutput.writeShort(getScale());
        littleEndianOutput.writeShort(getPageStart());
        littleEndianOutput.writeShort(getFitWidth());
        littleEndianOutput.writeShort(getFitHeight());
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeShort(getHResolution());
        littleEndianOutput.writeShort(getVResolution());
        littleEndianOutput.writeDouble(getHeaderMargin());
        littleEndianOutput.writeDouble(getFooterMargin());
        littleEndianOutput.writeShort(getCopies());
    }

    public void setCopies(short s6) {
        this.field_11_copies = s6;
    }

    public void setDraft(boolean z6) {
        this.field_6_options = draft.setShortBoolean(this.field_6_options, z6);
    }

    public void setFitHeight(short s6) {
        this.field_5_fit_height = s6;
    }

    public void setFitWidth(short s6) {
        this.field_4_fit_width = s6;
    }

    public void setFooterMargin(double d) {
        this.field_10_footermargin = d;
    }

    public void setHResolution(short s6) {
        this.field_7_hresolution = s6;
    }

    public void setHeaderMargin(double d) {
        this.field_9_headermargin = d;
    }

    public void setLandscape(boolean z6) {
        this.field_6_options = landscape.setShortBoolean(this.field_6_options, z6);
    }

    public void setLeftToRight(boolean z6) {
        this.field_6_options = lefttoright.setShortBoolean(this.field_6_options, z6);
    }

    public void setNoColor(boolean z6) {
        this.field_6_options = nocolor.setShortBoolean(this.field_6_options, z6);
    }

    public void setNoOrientation(boolean z6) {
        this.field_6_options = noOrientation.setShortBoolean(this.field_6_options, z6);
    }

    public void setNotes(boolean z6) {
        this.field_6_options = notes.setShortBoolean(this.field_6_options, z6);
    }

    public void setOptions(short s6) {
        this.field_6_options = s6;
    }

    public void setPageStart(short s6) {
        this.field_3_page_start = s6;
    }

    public void setPaperSize(short s6) {
        this.field_1_paper_size = s6;
    }

    public void setScale(short s6) {
        this.field_2_scale = s6;
    }

    public void setUsePage(boolean z6) {
        this.field_6_options = usepage.setShortBoolean(this.field_6_options, z6);
    }

    public void setVResolution(short s6) {
        this.field_8_vresolution = s6;
    }

    public void setValidSettings(boolean z6) {
        this.field_6_options = validsettings.setShortBoolean(this.field_6_options, z6);
    }

    public PrintSetupRecord(PrintSetupRecord printSetupRecord) {
        super(printSetupRecord);
        this.field_1_paper_size = printSetupRecord.field_1_paper_size;
        this.field_2_scale = printSetupRecord.field_2_scale;
        this.field_3_page_start = printSetupRecord.field_3_page_start;
        this.field_4_fit_width = printSetupRecord.field_4_fit_width;
        this.field_5_fit_height = printSetupRecord.field_5_fit_height;
        this.field_6_options = printSetupRecord.field_6_options;
        this.field_7_hresolution = printSetupRecord.field_7_hresolution;
        this.field_8_vresolution = printSetupRecord.field_8_vresolution;
        this.field_9_headermargin = printSetupRecord.field_9_headermargin;
        this.field_10_footermargin = printSetupRecord.field_10_footermargin;
        this.field_11_copies = printSetupRecord.field_11_copies;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PRINT_SETUP;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public PrintSetupRecord copy() {
        return new PrintSetupRecord(this);
    }

    public PrintSetupRecord(RecordInputStream recordInputStream) {
        this.field_1_paper_size = recordInputStream.readShort();
        this.field_2_scale = recordInputStream.readShort();
        this.field_3_page_start = recordInputStream.readShort();
        this.field_4_fit_width = recordInputStream.readShort();
        this.field_5_fit_height = recordInputStream.readShort();
        this.field_6_options = recordInputStream.readShort();
        this.field_7_hresolution = recordInputStream.readShort();
        this.field_8_vresolution = recordInputStream.readShort();
        this.field_9_headermargin = recordInputStream.readDouble();
        this.field_10_footermargin = recordInputStream.readDouble();
        this.field_11_copies = recordInputStream.readShort();
    }
}
