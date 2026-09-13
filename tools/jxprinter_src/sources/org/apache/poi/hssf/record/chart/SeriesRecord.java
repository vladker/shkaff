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
public final class SeriesRecord extends StandardRecord {
    public static final short BUBBLE_SERIES_TYPE_DATES = 0;
    public static final short BUBBLE_SERIES_TYPE_NUMERIC = 1;
    public static final short BUBBLE_SERIES_TYPE_SEQUENCE = 2;
    public static final short BUBBLE_SERIES_TYPE_TEXT = 3;
    public static final short CATEGORY_DATA_TYPE_DATES = 0;
    public static final short CATEGORY_DATA_TYPE_NUMERIC = 1;
    public static final short CATEGORY_DATA_TYPE_SEQUENCE = 2;
    public static final short CATEGORY_DATA_TYPE_TEXT = 3;
    public static final short VALUES_DATA_TYPE_DATES = 0;
    public static final short VALUES_DATA_TYPE_NUMERIC = 1;
    public static final short VALUES_DATA_TYPE_SEQUENCE = 2;
    public static final short VALUES_DATA_TYPE_TEXT = 3;
    public static final short sid = 4099;
    private short field_1_categoryDataType;
    private short field_2_valuesDataType;
    private short field_3_numCategories;
    private short field_4_numValues;
    private short field_5_bubbleSeriesType;
    private short field_6_numBubbleValues;

    public SeriesRecord() {
    }

    public short getBubbleSeriesType() {
        return this.field_5_bubbleSeriesType;
    }

    public short getCategoryDataType() {
        return this.field_1_categoryDataType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.D
            public final /* synthetic */ SeriesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short categoryDataType;
                switch (i5) {
                    case 0:
                        categoryDataType = this.b.getCategoryDataType();
                        break;
                    case 1:
                        categoryDataType = this.b.getValuesDataType();
                        break;
                    case 2:
                        categoryDataType = this.b.getNumCategories();
                        break;
                    case 3:
                        categoryDataType = this.b.getNumValues();
                        break;
                    case 4:
                        categoryDataType = this.b.getBubbleSeriesType();
                        break;
                    default:
                        categoryDataType = this.b.getNumBubbleValues();
                        break;
                }
                return Short.valueOf(categoryDataType);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.D
            public final /* synthetic */ SeriesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short categoryDataType;
                switch (i6) {
                    case 0:
                        categoryDataType = this.b.getCategoryDataType();
                        break;
                    case 1:
                        categoryDataType = this.b.getValuesDataType();
                        break;
                    case 2:
                        categoryDataType = this.b.getNumCategories();
                        break;
                    case 3:
                        categoryDataType = this.b.getNumValues();
                        break;
                    case 4:
                        categoryDataType = this.b.getBubbleSeriesType();
                        break;
                    default:
                        categoryDataType = this.b.getNumBubbleValues();
                        break;
                }
                return Short.valueOf(categoryDataType);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.D
            public final /* synthetic */ SeriesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short categoryDataType;
                switch (i7) {
                    case 0:
                        categoryDataType = this.b.getCategoryDataType();
                        break;
                    case 1:
                        categoryDataType = this.b.getValuesDataType();
                        break;
                    case 2:
                        categoryDataType = this.b.getNumCategories();
                        break;
                    case 3:
                        categoryDataType = this.b.getNumValues();
                        break;
                    case 4:
                        categoryDataType = this.b.getBubbleSeriesType();
                        break;
                    default:
                        categoryDataType = this.b.getNumBubbleValues();
                        break;
                }
                return Short.valueOf(categoryDataType);
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.D
            public final /* synthetic */ SeriesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short categoryDataType;
                switch (i8) {
                    case 0:
                        categoryDataType = this.b.getCategoryDataType();
                        break;
                    case 1:
                        categoryDataType = this.b.getValuesDataType();
                        break;
                    case 2:
                        categoryDataType = this.b.getNumCategories();
                        break;
                    case 3:
                        categoryDataType = this.b.getNumValues();
                        break;
                    case 4:
                        categoryDataType = this.b.getBubbleSeriesType();
                        break;
                    default:
                        categoryDataType = this.b.getNumBubbleValues();
                        break;
                }
                return Short.valueOf(categoryDataType);
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.D
            public final /* synthetic */ SeriesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short categoryDataType;
                switch (i9) {
                    case 0:
                        categoryDataType = this.b.getCategoryDataType();
                        break;
                    case 1:
                        categoryDataType = this.b.getValuesDataType();
                        break;
                    case 2:
                        categoryDataType = this.b.getNumCategories();
                        break;
                    case 3:
                        categoryDataType = this.b.getNumValues();
                        break;
                    case 4:
                        categoryDataType = this.b.getBubbleSeriesType();
                        break;
                    default:
                        categoryDataType = this.b.getNumBubbleValues();
                        break;
                }
                return Short.valueOf(categoryDataType);
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("categoryDataType", supplier, "valuesDataType", supplier2, "numCategories", supplier3, "numValues", supplier4, "bubbleSeriesType", supplier5, "numBubbleValues", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.D
            public final /* synthetic */ SeriesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short categoryDataType;
                switch (i10) {
                    case 0:
                        categoryDataType = this.b.getCategoryDataType();
                        break;
                    case 1:
                        categoryDataType = this.b.getValuesDataType();
                        break;
                    case 2:
                        categoryDataType = this.b.getNumCategories();
                        break;
                    case 3:
                        categoryDataType = this.b.getNumValues();
                        break;
                    case 4:
                        categoryDataType = this.b.getBubbleSeriesType();
                        break;
                    default:
                        categoryDataType = this.b.getNumBubbleValues();
                        break;
                }
                return Short.valueOf(categoryDataType);
            }
        });
    }

    public short getNumBubbleValues() {
        return this.field_6_numBubbleValues;
    }

    public short getNumCategories() {
        return this.field_3_numCategories;
    }

    public short getNumValues() {
        return this.field_4_numValues;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getValuesDataType() {
        return this.field_2_valuesDataType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_categoryDataType);
        littleEndianOutput.writeShort(this.field_2_valuesDataType);
        littleEndianOutput.writeShort(this.field_3_numCategories);
        littleEndianOutput.writeShort(this.field_4_numValues);
        littleEndianOutput.writeShort(this.field_5_bubbleSeriesType);
        littleEndianOutput.writeShort(this.field_6_numBubbleValues);
    }

    public void setBubbleSeriesType(short s6) {
        this.field_5_bubbleSeriesType = s6;
    }

    public void setCategoryDataType(short s6) {
        this.field_1_categoryDataType = s6;
    }

    public void setNumBubbleValues(short s6) {
        this.field_6_numBubbleValues = s6;
    }

    public void setNumCategories(short s6) {
        this.field_3_numCategories = s6;
    }

    public void setNumValues(short s6) {
        this.field_4_numValues = s6;
    }

    public void setValuesDataType(short s6) {
        this.field_2_valuesDataType = s6;
    }

    public SeriesRecord(SeriesRecord seriesRecord) {
        super(seriesRecord);
        this.field_1_categoryDataType = seriesRecord.field_1_categoryDataType;
        this.field_2_valuesDataType = seriesRecord.field_2_valuesDataType;
        this.field_3_numCategories = seriesRecord.field_3_numCategories;
        this.field_4_numValues = seriesRecord.field_4_numValues;
        this.field_5_bubbleSeriesType = seriesRecord.field_5_bubbleSeriesType;
        this.field_6_numBubbleValues = seriesRecord.field_6_numBubbleValues;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SeriesRecord copy() {
        return new SeriesRecord(this);
    }

    public SeriesRecord(RecordInputStream recordInputStream) {
        this.field_1_categoryDataType = recordInputStream.readShort();
        this.field_2_valuesDataType = recordInputStream.readShort();
        this.field_3_numCategories = recordInputStream.readShort();
        this.field_4_numValues = recordInputStream.readShort();
        this.field_5_bubbleSeriesType = recordInputStream.readShort();
        this.field_6_numBubbleValues = recordInputStream.readShort();
    }
}
