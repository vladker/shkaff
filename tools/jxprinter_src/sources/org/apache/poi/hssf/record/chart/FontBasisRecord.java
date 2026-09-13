package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FontBasisRecord extends StandardRecord {
    public static final short sid = 4192;
    private short field_1_xBasis;
    private short field_2_yBasis;
    private short field_3_heightBasis;
    private short field_4_scale;
    private short field_5_indexToFontTable;

    public FontBasisRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 10;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.w
            public final /* synthetic */ FontBasisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short xBasis;
                switch (i5) {
                    case 0:
                        xBasis = this.b.getXBasis();
                        break;
                    case 1:
                        xBasis = this.b.getYBasis();
                        break;
                    case 2:
                        xBasis = this.b.getHeightBasis();
                        break;
                    case 3:
                        xBasis = this.b.getScale();
                        break;
                    default:
                        xBasis = this.b.getIndexToFontTable();
                        break;
                }
                return Short.valueOf(xBasis);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.w
            public final /* synthetic */ FontBasisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short xBasis;
                switch (i6) {
                    case 0:
                        xBasis = this.b.getXBasis();
                        break;
                    case 1:
                        xBasis = this.b.getYBasis();
                        break;
                    case 2:
                        xBasis = this.b.getHeightBasis();
                        break;
                    case 3:
                        xBasis = this.b.getScale();
                        break;
                    default:
                        xBasis = this.b.getIndexToFontTable();
                        break;
                }
                return Short.valueOf(xBasis);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.w
            public final /* synthetic */ FontBasisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short xBasis;
                switch (i7) {
                    case 0:
                        xBasis = this.b.getXBasis();
                        break;
                    case 1:
                        xBasis = this.b.getYBasis();
                        break;
                    case 2:
                        xBasis = this.b.getHeightBasis();
                        break;
                    case 3:
                        xBasis = this.b.getScale();
                        break;
                    default:
                        xBasis = this.b.getIndexToFontTable();
                        break;
                }
                return Short.valueOf(xBasis);
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.w
            public final /* synthetic */ FontBasisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short xBasis;
                switch (i8) {
                    case 0:
                        xBasis = this.b.getXBasis();
                        break;
                    case 1:
                        xBasis = this.b.getYBasis();
                        break;
                    case 2:
                        xBasis = this.b.getHeightBasis();
                        break;
                    case 3:
                        xBasis = this.b.getScale();
                        break;
                    default:
                        xBasis = this.b.getIndexToFontTable();
                        break;
                }
                return Short.valueOf(xBasis);
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("xBasis", supplier, "yBasis", supplier2, "heightBasis", supplier3, "scale", supplier4, "indexToFontTable", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.w
            public final /* synthetic */ FontBasisRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short xBasis;
                switch (i9) {
                    case 0:
                        xBasis = this.b.getXBasis();
                        break;
                    case 1:
                        xBasis = this.b.getYBasis();
                        break;
                    case 2:
                        xBasis = this.b.getHeightBasis();
                        break;
                    case 3:
                        xBasis = this.b.getScale();
                        break;
                    default:
                        xBasis = this.b.getIndexToFontTable();
                        break;
                }
                return Short.valueOf(xBasis);
            }
        });
    }

    public short getHeightBasis() {
        return this.field_3_heightBasis;
    }

    public short getIndexToFontTable() {
        return this.field_5_indexToFontTable;
    }

    public short getScale() {
        return this.field_4_scale;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getXBasis() {
        return this.field_1_xBasis;
    }

    public short getYBasis() {
        return this.field_2_yBasis;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_xBasis);
        littleEndianOutput.writeShort(this.field_2_yBasis);
        littleEndianOutput.writeShort(this.field_3_heightBasis);
        littleEndianOutput.writeShort(this.field_4_scale);
        littleEndianOutput.writeShort(this.field_5_indexToFontTable);
    }

    public void setHeightBasis(short s6) {
        this.field_3_heightBasis = s6;
    }

    public void setIndexToFontTable(short s6) {
        this.field_5_indexToFontTable = s6;
    }

    public void setScale(short s6) {
        this.field_4_scale = s6;
    }

    public void setXBasis(short s6) {
        this.field_1_xBasis = s6;
    }

    public void setYBasis(short s6) {
        this.field_2_yBasis = s6;
    }

    public FontBasisRecord(FontBasisRecord fontBasisRecord) {
        super(fontBasisRecord);
        this.field_1_xBasis = fontBasisRecord.field_1_xBasis;
        this.field_2_yBasis = fontBasisRecord.field_2_yBasis;
        this.field_3_heightBasis = fontBasisRecord.field_3_heightBasis;
        this.field_4_scale = fontBasisRecord.field_4_scale;
        this.field_5_indexToFontTable = fontBasisRecord.field_5_indexToFontTable;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FONT_BASIS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FontBasisRecord copy() {
        return new FontBasisRecord(this);
    }

    public FontBasisRecord(RecordInputStream recordInputStream) {
        this.field_1_xBasis = recordInputStream.readShort();
        this.field_2_yBasis = recordInputStream.readShort();
        this.field_3_heightBasis = recordInputStream.readShort();
        this.field_4_scale = recordInputStream.readShort();
        this.field_5_indexToFontTable = recordInputStream.readShort();
    }
}
