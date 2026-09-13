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
public final class AreaRecord extends StandardRecord {
    public static final short sid = 4122;
    private short field_1_formatFlags;
    private static final BitField stacked = BitFieldFactory.getInstance(1);
    private static final BitField displayAsPercentage = BitFieldFactory.getInstance(2);
    private static final BitField shadow = BitFieldFactory.getInstance(4);

    public AreaRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public short getFormatFlags() {
        return this.field_1_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.b
            public final /* synthetic */ AreaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 1:
                        return Boolean.valueOf(this.b.isStacked());
                    case 2:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.b
            public final /* synthetic */ AreaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 1:
                        return Boolean.valueOf(this.b.isStacked());
                    case 2:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.b
            public final /* synthetic */ AreaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 1:
                        return Boolean.valueOf(this.b.isStacked());
                    case 2:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("formatFlags", supplier, "stacked", supplier2, "displayAsPercentage", supplier3, "shadow", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.b
            public final /* synthetic */ AreaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getFormatFlags());
                    case 1:
                        return Boolean.valueOf(this.b.isStacked());
                    case 2:
                        return Boolean.valueOf(this.b.isDisplayAsPercentage());
                    default:
                        return Boolean.valueOf(this.b.isShadow());
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_1_formatFlags);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_1_formatFlags);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_1_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_formatFlags);
    }

    public void setDisplayAsPercentage(boolean z6) {
        this.field_1_formatFlags = displayAsPercentage.setShortBoolean(this.field_1_formatFlags, z6);
    }

    public void setFormatFlags(short s6) {
        this.field_1_formatFlags = s6;
    }

    public void setShadow(boolean z6) {
        this.field_1_formatFlags = shadow.setShortBoolean(this.field_1_formatFlags, z6);
    }

    public void setStacked(boolean z6) {
        this.field_1_formatFlags = stacked.setShortBoolean(this.field_1_formatFlags, z6);
    }

    public AreaRecord(AreaRecord areaRecord) {
        super(areaRecord);
        this.field_1_formatFlags = areaRecord.field_1_formatFlags;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AREA;
    }

    public AreaRecord(RecordInputStream recordInputStream) {
        this.field_1_formatFlags = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public AreaRecord copy() {
        return new AreaRecord(this);
    }
}
