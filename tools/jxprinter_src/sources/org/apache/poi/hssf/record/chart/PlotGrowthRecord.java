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
public final class PlotGrowthRecord extends StandardRecord {
    public static final short sid = 4196;
    private int field_1_horizontalScale;
    private int field_2_verticalScale;

    public PlotGrowthRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("horizontalScale", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.C
            public final /* synthetic */ PlotGrowthRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int horizontalScale;
                switch (i5) {
                    case 0:
                        horizontalScale = this.b.getHorizontalScale();
                        break;
                    default:
                        horizontalScale = this.b.getVerticalScale();
                        break;
                }
                return Integer.valueOf(horizontalScale);
            }
        }, "verticalScale", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.C
            public final /* synthetic */ PlotGrowthRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int horizontalScale;
                switch (i6) {
                    case 0:
                        horizontalScale = this.b.getHorizontalScale();
                        break;
                    default:
                        horizontalScale = this.b.getVerticalScale();
                        break;
                }
                return Integer.valueOf(horizontalScale);
            }
        });
    }

    public int getHorizontalScale() {
        return this.field_1_horizontalScale;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public int getVerticalScale() {
        return this.field_2_verticalScale;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_horizontalScale);
        littleEndianOutput.writeInt(this.field_2_verticalScale);
    }

    public void setHorizontalScale(int i5) {
        this.field_1_horizontalScale = i5;
    }

    public void setVerticalScale(int i5) {
        this.field_2_verticalScale = i5;
    }

    public PlotGrowthRecord(PlotGrowthRecord plotGrowthRecord) {
        this.field_1_horizontalScale = plotGrowthRecord.field_1_horizontalScale;
        this.field_2_verticalScale = plotGrowthRecord.field_2_verticalScale;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PLOT_GROWTH;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public PlotGrowthRecord copy() {
        return new PlotGrowthRecord(this);
    }

    public PlotGrowthRecord(RecordInputStream recordInputStream) {
        this.field_1_horizontalScale = recordInputStream.readInt();
        this.field_2_verticalScale = recordInputStream.readInt();
    }
}
