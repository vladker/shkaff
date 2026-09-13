package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractEscherHolderRecord extends Record {
    private static boolean DESERIALIZE;
    private final List<EscherRecord> escherRecords;
    private final LazilyConcatenatedByteArray rawDataContainer;

    static {
        try {
            DESERIALIZE = System.getProperty("poi.deserialize.escher") != null;
        } catch (SecurityException unused) {
            DESERIALIZE = false;
        }
    }

    public AbstractEscherHolderRecord() {
        this.escherRecords = new ArrayList();
        this.rawDataContainer = new LazilyConcatenatedByteArray();
    }

    private void convertToEscherRecords(int i5, int i6, byte[] bArr) {
        this.escherRecords.clear();
        EscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
        int i7 = i5;
        while (i7 < i5 + i6) {
            EscherRecord escherRecordCreateRecord = defaultEscherRecordFactory.createRecord(bArr, i7);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i7, defaultEscherRecordFactory);
            this.escherRecords.add(escherRecordCreateRecord);
            i7 += iFillFields;
        }
    }

    public void addEscherRecord(int i5, EscherRecord escherRecord) {
        this.escherRecords.add(i5, escherRecord);
    }

    public void clearEscherRecords() {
        this.escherRecords.clear();
    }

    @Removal(version = "5.3")
    @Deprecated
    public void convertRawBytesToEscherRecords() {
        if (DESERIALIZE) {
            return;
        }
        decode();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public abstract AbstractEscherHolderRecord copy();

    public void decode() {
        if (this.escherRecords.isEmpty()) {
            byte[] rawData = getRawData();
            convertToEscherRecords(0, rawData.length, rawData);
        }
    }

    public EscherRecord findFirstWithId(short s6) {
        return findFirstWithId(s6, getEscherRecords());
    }

    public EscherContainerRecord getEscherContainer() {
        for (EscherRecord escherRecord : this.escherRecords) {
            if (escherRecord instanceof EscherContainerRecord) {
                return (EscherContainerRecord) escherRecord;
            }
        }
        return null;
    }

    public EscherRecord getEscherRecord(int i5) {
        return this.escherRecords.get(i5);
    }

    public List<EscherRecord> getEscherRecords() {
        return this.escherRecords;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<EscherRecord> getGenericChildren() {
        return this.escherRecords;
    }

    public byte[] getRawData() {
        return this.rawDataContainer.toArray();
    }

    public abstract String getRecordName();

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] rawData = getRawData();
        if (this.escherRecords.isEmpty() && rawData != null) {
            return rawData.length;
        }
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    @Override // org.apache.poi.hssf.record.Record
    public abstract short getSid();

    public void join(AbstractEscherHolderRecord abstractEscherHolderRecord) {
        this.rawDataContainer.concatenate(abstractEscherHolderRecord.getRawData());
    }

    public void processContinueRecord(byte[] bArr) {
        this.rawDataContainer.concatenate(bArr);
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i5, byte[] bArr) {
        byte[] rawData = getRawData();
        LittleEndian.putShort(bArr, i5, getSid());
        LittleEndian.putShort(bArr, i5 + 2, (short) (getRecordSize() - 4));
        int iSerialize = i5 + 4;
        if (this.escherRecords.isEmpty() && rawData != null) {
            System.arraycopy(rawData, 0, bArr, iSerialize, rawData.length);
            return rawData.length + 4;
        }
        NullEscherSerializationListener nullEscherSerializationListener = new NullEscherSerializationListener();
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr, nullEscherSerializationListener);
        }
        return getRecordSize();
    }

    public void setRawData(byte[] bArr) {
        this.rawDataContainer.clear();
        this.rawDataContainer.concatenate(bArr);
    }

    private EscherRecord findFirstWithId(short s6, List<EscherRecord> list) {
        EscherRecord escherRecordFindFirstWithId;
        for (EscherRecord escherRecord : list) {
            if (escherRecord.getRecordId() == s6) {
                return escherRecord;
            }
        }
        for (EscherRecord escherRecord2 : list) {
            if (escherRecord2.isContainerRecord() && (escherRecordFindFirstWithId = findFirstWithId(s6, escherRecord2.getChildRecords())) != null) {
                return escherRecordFindFirstWithId;
            }
        }
        return null;
    }

    public boolean addEscherRecord(EscherRecord escherRecord) {
        return this.escherRecords.add(escherRecord);
    }

    public AbstractEscherHolderRecord(AbstractEscherHolderRecord abstractEscherHolderRecord) {
        ArrayList arrayList = new ArrayList();
        this.escherRecords = arrayList;
        LazilyConcatenatedByteArray lazilyConcatenatedByteArray = new LazilyConcatenatedByteArray();
        this.rawDataContainer = lazilyConcatenatedByteArray;
        abstractEscherHolderRecord.escherRecords.stream().map(new com.google.android.material.color.utilities.g(10)).forEach(new org.apache.poi.ddf.l(arrayList, 0));
        lazilyConcatenatedByteArray.concatenate(abstractEscherHolderRecord.rawDataContainer);
    }

    public AbstractEscherHolderRecord(RecordInputStream recordInputStream) {
        this.escherRecords = new ArrayList();
        LazilyConcatenatedByteArray lazilyConcatenatedByteArray = new LazilyConcatenatedByteArray();
        this.rawDataContainer = lazilyConcatenatedByteArray;
        if (!DESERIALIZE) {
            lazilyConcatenatedByteArray.concatenate(recordInputStream.readRemainder());
        } else {
            byte[] allContinuedRemainder = recordInputStream.readAllContinuedRemainder();
            convertToEscherRecords(0, allContinuedRemainder.length, allContinuedRemainder);
        }
    }
}
