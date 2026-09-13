package org.apache.poi.hssf.record;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DrawingGroupRecord extends AbstractEscherHolderRecord {
    private static final int DEFAULT_MAX_RECORD_SIZE = 8228;
    private static int MAX_RECORD_SIZE = 8228;
    public static final short sid = 235;

    public DrawingGroupRecord() {
    }

    private static int getMaxDataSize() {
        return MAX_RECORD_SIZE - 4;
    }

    public static int getMaxRecordSize() {
        return MAX_RECORD_SIZE;
    }

    private int getRawDataSize() {
        List<EscherRecord> escherRecords = getEscherRecords();
        byte[] rawData = getRawData();
        if (escherRecords.isEmpty() && rawData != null) {
            return rawData.length;
        }
        Iterator<EscherRecord> it = escherRecords.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    public static int grossSizeFromDataSize(int i5) {
        return ((((i5 - 1) / getMaxDataSize()) + 1) * 4) + i5;
    }

    public static void setMaxRecordSize(int i5) {
        MAX_RECORD_SIZE = i5;
    }

    private void writeContinueHeader(byte[] bArr, int i5, int i6) {
        LittleEndian.putShort(bArr, i5, (short) 60);
        LittleEndian.putShort(bArr, i5 + 2, (short) i6);
    }

    private int writeData(int i5, byte[] bArr, byte[] bArr2) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr2.length) {
            int maxDataSize = getMaxDataSize();
            int iMin = Math.min(bArr2.length - i6, maxDataSize);
            if (i6 / maxDataSize >= 2) {
                writeContinueHeader(bArr, i5, iMin);
            } else {
                writeHeader(bArr, i5, iMin);
            }
            int i8 = i5 + 4;
            System.arraycopy(bArr2, i6, bArr, i8, iMin);
            i5 = i8 + iMin;
            i6 += iMin;
            i7 = i7 + 4 + iMin;
        }
        return i7;
    }

    private void writeHeader(byte[] bArr, int i5, int i6) {
        LittleEndian.putShort(bArr, i5, getSid());
        LittleEndian.putShort(bArr, i5 + 2, (short) i6);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord
    public String getRecordName() {
        return "MSODRAWINGGROUP";
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        return grossSizeFromDataSize(getRawDataSize());
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Removal(version = "5.3")
    @Deprecated
    public void processChildRecords() {
        decode();
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int serialize(int i5, byte[] bArr) {
        byte[] rawData = getRawData();
        if (getEscherRecords().isEmpty() && rawData != null) {
            return writeData(i5, bArr, rawData);
        }
        byte[] bArr2 = new byte[getRawDataSize()];
        Iterator<EscherRecord> it = getEscherRecords().iterator();
        int iSerialize = 0;
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr2, new NullEscherSerializationListener());
        }
        return writeData(i5, bArr, bArr2);
    }

    public DrawingGroupRecord(DrawingGroupRecord drawingGroupRecord) {
        super(drawingGroupRecord);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DRAWING_GROUP;
    }

    public DrawingGroupRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DrawingGroupRecord copy() {
        return new DrawingGroupRecord(this);
    }
}
