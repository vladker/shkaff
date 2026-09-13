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
public final class DataFormatRecord extends StandardRecord {
    public static final short sid = 4102;
    private static final BitField useExcel4Colors = BitFieldFactory.getInstance(1);
    private short field_1_pointNumber;
    private short field_2_seriesIndex;
    private short field_3_seriesNumber;
    private short field_4_formatFlags;

    public DataFormatRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    public short getFormatFlags() {
        return this.field_4_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.u
            public final /* synthetic */ DataFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getPointNumber());
                    case 1:
                        return Short.valueOf(this.b.getSeriesIndex());
                    case 2:
                        return Short.valueOf(this.b.getSeriesNumber());
                    case 3:
                        return Short.valueOf(this.b.getFormatFlags());
                    default:
                        return Boolean.valueOf(this.b.isUseExcel4Colors());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.u
            public final /* synthetic */ DataFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getPointNumber());
                    case 1:
                        return Short.valueOf(this.b.getSeriesIndex());
                    case 2:
                        return Short.valueOf(this.b.getSeriesNumber());
                    case 3:
                        return Short.valueOf(this.b.getFormatFlags());
                    default:
                        return Boolean.valueOf(this.b.isUseExcel4Colors());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.u
            public final /* synthetic */ DataFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getPointNumber());
                    case 1:
                        return Short.valueOf(this.b.getSeriesIndex());
                    case 2:
                        return Short.valueOf(this.b.getSeriesNumber());
                    case 3:
                        return Short.valueOf(this.b.getFormatFlags());
                    default:
                        return Boolean.valueOf(this.b.isUseExcel4Colors());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.u
            public final /* synthetic */ DataFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getPointNumber());
                    case 1:
                        return Short.valueOf(this.b.getSeriesIndex());
                    case 2:
                        return Short.valueOf(this.b.getSeriesNumber());
                    case 3:
                        return Short.valueOf(this.b.getFormatFlags());
                    default:
                        return Boolean.valueOf(this.b.isUseExcel4Colors());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("pointNumber", supplier, "seriesIndex", supplier2, "seriesNumber", supplier3, "formatFlags", supplier4, "useExcel4Colors", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.u
            public final /* synthetic */ DataFormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getPointNumber());
                    case 1:
                        return Short.valueOf(this.b.getSeriesIndex());
                    case 2:
                        return Short.valueOf(this.b.getSeriesNumber());
                    case 3:
                        return Short.valueOf(this.b.getFormatFlags());
                    default:
                        return Boolean.valueOf(this.b.isUseExcel4Colors());
                }
            }
        });
    }

    public short getPointNumber() {
        return this.field_1_pointNumber;
    }

    public short getSeriesIndex() {
        return this.field_2_seriesIndex;
    }

    public short getSeriesNumber() {
        return this.field_3_seriesNumber;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isUseExcel4Colors() {
        return useExcel4Colors.isSet(this.field_4_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_pointNumber);
        littleEndianOutput.writeShort(this.field_2_seriesIndex);
        littleEndianOutput.writeShort(this.field_3_seriesNumber);
        littleEndianOutput.writeShort(this.field_4_formatFlags);
    }

    public void setFormatFlags(short s6) {
        this.field_4_formatFlags = s6;
    }

    public void setPointNumber(short s6) {
        this.field_1_pointNumber = s6;
    }

    public void setSeriesIndex(short s6) {
        this.field_2_seriesIndex = s6;
    }

    public void setSeriesNumber(short s6) {
        this.field_3_seriesNumber = s6;
    }

    public void setUseExcel4Colors(boolean z6) {
        this.field_4_formatFlags = useExcel4Colors.setShortBoolean(this.field_4_formatFlags, z6);
    }

    public DataFormatRecord(DataFormatRecord dataFormatRecord) {
        super(dataFormatRecord);
        this.field_1_pointNumber = dataFormatRecord.field_1_pointNumber;
        this.field_2_seriesIndex = dataFormatRecord.field_2_seriesIndex;
        this.field_3_seriesNumber = dataFormatRecord.field_3_seriesNumber;
        this.field_4_formatFlags = dataFormatRecord.field_4_formatFlags;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DATA_FORMAT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DataFormatRecord copy() {
        return new DataFormatRecord(this);
    }

    public DataFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_pointNumber = recordInputStream.readShort();
        this.field_2_seriesIndex = recordInputStream.readShort();
        this.field_3_seriesNumber = recordInputStream.readShort();
        this.field_4_formatFlags = recordInputStream.readShort();
    }
}
