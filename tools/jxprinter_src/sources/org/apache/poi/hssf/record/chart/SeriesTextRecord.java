package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SeriesTextRecord extends StandardRecord {
    private static final int MAX_LEN = 255;
    public static final short sid = 4109;
    private int field_1_id;
    private String field_4_text;
    private boolean is16bit;

    public SeriesTextRecord() {
        this.field_4_text = "";
        this.is16bit = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Boolean.valueOf(this.is16bit);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_4_text.length() * (this.is16bit ? 2 : 1)) + 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.E
            public final /* synthetic */ SeriesTextRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getId());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getText();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.E
            public final /* synthetic */ SeriesTextRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getId());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getText();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("id", supplier, "bit16", supplier2, "text", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.E
            public final /* synthetic */ SeriesTextRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getId());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getText();
                }
            }
        });
    }

    public int getId() {
        return this.field_1_id;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public String getText() {
        return this.field_4_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_id);
        littleEndianOutput.writeByte(this.field_4_text.length());
        if (this.is16bit) {
            littleEndianOutput.writeByte(1);
            StringUtil.putUnicodeLE(this.field_4_text, littleEndianOutput);
        } else {
            littleEndianOutput.writeByte(0);
            StringUtil.putCompressedUnicode(this.field_4_text, littleEndianOutput);
        }
    }

    public void setId(int i5) {
        this.field_1_id = i5;
    }

    public void setText(String str) {
        if (str.length() <= 255) {
            this.field_4_text = str;
            this.is16bit = StringUtil.hasMultibyte(str);
        } else {
            throw new IllegalArgumentException("Text is too long (" + str.length() + ">255)");
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES_TEXT;
    }

    public SeriesTextRecord(SeriesTextRecord seriesTextRecord) {
        super(seriesTextRecord);
        this.field_1_id = seriesTextRecord.field_1_id;
        this.is16bit = seriesTextRecord.is16bit;
        this.field_4_text = seriesTextRecord.field_4_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SeriesTextRecord copy() {
        return new SeriesTextRecord(this);
    }

    public SeriesTextRecord(RecordInputStream recordInputStream) {
        this.field_1_id = recordInputStream.readUShort();
        int uByte = recordInputStream.readUByte();
        boolean z6 = (recordInputStream.readUByte() & 1) != 0;
        this.is16bit = z6;
        if (z6) {
            this.field_4_text = recordInputStream.readUnicodeLEString(uByte);
        } else {
            this.field_4_text = recordInputStream.readCompressedUnicode(uByte);
        }
    }
}
