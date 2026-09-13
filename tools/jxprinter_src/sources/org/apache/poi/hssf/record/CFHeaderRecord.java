package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CFHeaderRecord extends CFHeaderBase {
    public static final short sid = 432;

    public CFHeaderRecord() {
        createEmpty();
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase
    public String getRecordName() {
        return "CFHEADER";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_HEADER;
    }

    public CFHeaderRecord(CFHeaderRecord cFHeaderRecord) {
        super(cFHeaderRecord);
    }

    public CFHeaderRecord(CellRangeAddress[] cellRangeAddressArr, int i5) {
        super(cellRangeAddressArr, i5);
    }

    public CFHeaderRecord(RecordInputStream recordInputStream) {
        read(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public CFHeaderRecord copy() {
        return new CFHeaderRecord(this);
    }
}
