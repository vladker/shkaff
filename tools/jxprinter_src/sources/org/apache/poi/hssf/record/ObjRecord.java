package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ObjRecord extends Record {
    private static int MAX_PAD_ALIGNMENT = 4;
    private static final int NORMAL_PAD_ALIGNMENT = 2;
    public static final short sid = 93;
    private boolean _isPaddedToQuadByteMultiple;
    private final byte[] _uninterpretedData;
    private final List<SubRecord> subrecords;

    public ObjRecord() {
        this.subrecords = new ArrayList();
        this._uninterpretedData = null;
    }

    private static boolean canPaddingBeDiscarded(byte[] bArr, int i5) {
        for (int length = bArr.length - i5; length < bArr.length; length++) {
            if (bArr[length] != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this._uninterpretedData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Boolean.valueOf(this._isPaddedToQuadByteMultiple);
    }

    public void addSubRecord(int i5, SubRecord subRecord) {
        this.subrecords.add(i5, subRecord);
    }

    public void clearSubRecords() {
        this.subrecords.clear();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<SubRecord> getGenericChildren() {
        return getSubRecords();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("uninterpretedData", new Supplier(this) { // from class: org.apache.poi.hssf.record.q0
            public final /* synthetic */ ObjRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "paddedToQuadByteMultiple", new Supplier(this) { // from class: org.apache.poi.hssf.record.q0
            public final /* synthetic */ ObjRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] bArr = this._uninterpretedData;
        if (bArr != null) {
            return bArr.length + 4;
        }
        Iterator<SubRecord> it = this.subrecords.iterator();
        int dataSize = 0;
        while (it.hasNext()) {
            dataSize += it.next().getDataSize() + 4;
        }
        if (this._isPaddedToQuadByteMultiple) {
            while (dataSize % MAX_PAD_ALIGNMENT != 0) {
                dataSize++;
            }
        } else {
            while (dataSize % 2 != 0) {
                dataSize++;
            }
        }
        return dataSize + 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 93;
    }

    public List<SubRecord> getSubRecords() {
        return this.subrecords;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i5, byte[] bArr) {
        int recordSize = getRecordSize();
        int i6 = recordSize - 4;
        try {
            LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i5, recordSize);
            try {
                littleEndianByteArrayOutputStream.writeShort(93);
                littleEndianByteArrayOutputStream.writeShort(i6);
                byte[] bArr2 = this._uninterpretedData;
                if (bArr2 == null) {
                    Iterator<SubRecord> it = this.subrecords.iterator();
                    while (it.hasNext()) {
                        it.next().serialize(littleEndianByteArrayOutputStream);
                    }
                    int i7 = i5 + i6;
                    while (littleEndianByteArrayOutputStream.getWriteIndex() < i7) {
                        littleEndianByteArrayOutputStream.writeByte(0);
                    }
                } else {
                    littleEndianByteArrayOutputStream.write(bArr2);
                }
                littleEndianByteArrayOutputStream.close();
                return recordSize;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        littleEndianByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean addSubRecord(SubRecord subRecord) {
        return this.subrecords.add(subRecord);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.OBJ;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ObjRecord copy() {
        return new ObjRecord(this);
    }

    public ObjRecord(ObjRecord objRecord) {
        ArrayList arrayList = new ArrayList();
        this.subrecords = arrayList;
        objRecord.subrecords.stream().map(new G(5)).forEach(new H(arrayList, 2));
        byte[] bArr = objRecord._uninterpretedData;
        this._uninterpretedData = bArr == null ? null : (byte[]) bArr.clone();
        this._isPaddedToQuadByteMultiple = objRecord._isPaddedToQuadByteMultiple;
    }

    public ObjRecord(RecordInputStream recordInputStream) {
        SubRecord subRecordCreateSubRecord;
        ArrayList arrayList = new ArrayList();
        this.subrecords = arrayList;
        byte[] remainder = recordInputStream.readRemainder();
        if (LittleEndian.getUShort(remainder, 0) != 21) {
            this._uninterpretedData = remainder;
            return;
        }
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(remainder);
        CommonObjectDataSubRecord commonObjectDataSubRecord = (CommonObjectDataSubRecord) SubRecord.createSubRecord(littleEndianByteArrayInputStream, 0);
        arrayList.add(commonObjectDataSubRecord);
        do {
            subRecordCreateSubRecord = SubRecord.createSubRecord(littleEndianByteArrayInputStream, commonObjectDataSubRecord.getObjectType());
            this.subrecords.add(subRecordCreateSubRecord);
        } while (!subRecordCreateSubRecord.isTerminating());
        int length = remainder.length - littleEndianByteArrayInputStream.getReadIndex();
        if (length > 0) {
            int length2 = remainder.length;
            int i5 = MAX_PAD_ALIGNMENT;
            boolean z6 = length2 % i5 == 0;
            this._isPaddedToQuadByteMultiple = z6;
            if (length >= (z6 ? i5 : 2)) {
                if (canPaddingBeDiscarded(remainder, length)) {
                    this._isPaddedToQuadByteMultiple = false;
                } else {
                    StringBuilder sbT = AbstractC0157z.t(length, "Leftover ", " bytes in subrecord data ");
                    sbT.append(HexDump.toHex(remainder));
                    throw new RecordFormatException(sbT.toString());
                }
            }
        } else {
            this._isPaddedToQuadByteMultiple = false;
        }
        this._uninterpretedData = null;
    }
}
