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
public final class SeriesListRecord extends StandardRecord {
    public static final short sid = 4118;
    private short[] field_1_seriesNumbers;

    public SeriesListRecord(SeriesListRecord seriesListRecord) {
        super(seriesListRecord);
        short[] sArr = seriesListRecord.field_1_seriesNumbers;
        this.field_1_seriesNumbers = sArr == null ? null : (short[]) sArr.clone();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_1_seriesNumbers.length * 2) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("seriesNumbers", new C1387c(this, 9));
    }

    public short[] getSeriesNumbers() {
        return this.field_1_seriesNumbers;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_seriesNumbers.length);
        for (short s6 : this.field_1_seriesNumbers) {
            littleEndianOutput.writeShort(s6);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES_LIST;
    }

    public SeriesListRecord(short[] sArr) {
        this.field_1_seriesNumbers = sArr == null ? null : (short[]) sArr.clone();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SeriesListRecord copy() {
        return new SeriesListRecord(this);
    }

    public SeriesListRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        short[] sArr = new short[uShort];
        for (int i5 = 0; i5 < uShort; i5++) {
            sArr[i5] = recordInputStream.readShort();
        }
        this.field_1_seriesNumbers = sArr;
    }
}
