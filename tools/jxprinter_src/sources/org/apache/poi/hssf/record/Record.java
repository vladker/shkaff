package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Record extends RecordBase implements Duplicatable, GenericRecord {
    public Record() {
    }

    public Record cloneViaReserialise() {
        RecordInputStream recordInputStream = new RecordInputStream(new UnsynchronizedByteArrayInputStream(serialize()));
        recordInputStream.nextRecord();
        Record[] recordArrCreateRecord = RecordFactory.createRecord(recordInputStream);
        if (recordArrCreateRecord.length == 1) {
            return recordArrCreateRecord[0];
        }
        throw new IllegalStateException(AbstractC0157z.l(" records back!", recordArrCreateRecord.length, new StringBuilder("Re-serialised a record to clone it, but got ")));
    }

    @Override // org.apache.poi.common.Duplicatable
    public abstract Record copy();

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public abstract HSSFRecordTypes getGenericRecordType();

    public abstract short getSid();

    public final byte[] serialize() {
        byte[] bArr = new byte[getRecordSize()];
        serialize(0, bArr);
        return bArr;
    }

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public Record(Record record) {
    }
}
