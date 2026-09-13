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
public final class BarRecord extends StandardRecord {
    public static final short sid = 4119;
    private short field_1_barSpace;
    private short field_2_categorySpace;
    private short field_3_formatFlags;
    private static final BitField horizontal = BitFieldFactory.getInstance(1);
    private static final BitField stacked = BitFieldFactory.getInstance(2);
    private static final BitField displayAsPercentage = BitFieldFactory.getInstance(4);
    private static final BitField shadow = BitFieldFactory.getInstance(8);

    public BarRecord() {
    }

    public short getBarSpace() {
        return this.field_1_barSpace;
    }

    public short getCategorySpace() {
        return this.field_2_categorySpace;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 6;
    }

    public short getFormatFlags() {
        return this.field_3_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("barSpace", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("categorySpace", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("formatFlags", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("horizontal", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("stacked", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("displayAsPercentage", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("shadow", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.g
            public final /* synthetic */ BarRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getBarSpace());
                    case 1:
                        return Short.valueOf(this.b.getCategorySpace());
                    case 2:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 3:
                        return Boolean.valueOf(this.b.isHorizontal());
                    case 4:
                        return Boolean.valueOf(this.b.isStacked());
                    case 5:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_3_formatFlags);
    }

    public boolean isHorizontal() {
        return horizontal.isSet(this.field_3_formatFlags);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_3_formatFlags);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_3_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_barSpace);
        littleEndianOutput.writeShort(this.field_2_categorySpace);
        littleEndianOutput.writeShort(this.field_3_formatFlags);
    }

    public void setBarSpace(short s6) {
        this.field_1_barSpace = s6;
    }

    public void setCategorySpace(short s6) {
        this.field_2_categorySpace = s6;
    }

    public void setDisplayAsPercentage(boolean z6) {
        this.field_3_formatFlags = displayAsPercentage.setShortBoolean(this.field_3_formatFlags, z6);
    }

    public void setFormatFlags(short s6) {
        this.field_3_formatFlags = s6;
    }

    public void setHorizontal(boolean z6) {
        this.field_3_formatFlags = horizontal.setShortBoolean(this.field_3_formatFlags, z6);
    }

    public void setShadow(boolean z6) {
        this.field_3_formatFlags = shadow.setShortBoolean(this.field_3_formatFlags, z6);
    }

    public void setStacked(boolean z6) {
        this.field_3_formatFlags = stacked.setShortBoolean(this.field_3_formatFlags, z6);
    }

    public BarRecord(BarRecord barRecord) {
        super(barRecord);
        this.field_1_barSpace = barRecord.field_1_barSpace;
        this.field_2_categorySpace = barRecord.field_2_categorySpace;
        this.field_3_formatFlags = barRecord.field_3_formatFlags;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BAR;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public BarRecord copy() {
        return new BarRecord(this);
    }

    public BarRecord(RecordInputStream recordInputStream) {
        this.field_1_barSpace = recordInputStream.readShort();
        this.field_2_categorySpace = recordInputStream.readShort();
        this.field_3_formatFlags = recordInputStream.readShort();
    }
}
