package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherClientDataRecord extends EscherRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private byte[] remainingData;
    public static final short RECORD_ID = EscherRecordTypes.CLIENT_DATA.typeID;
    private static int MAX_RECORD_LENGTH = 100000;
    private static final byte[] EMPTY = new byte[0];

    public EscherClientDataRecord() {
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        this.remainingData = header == 0 ? EMPTY : IOUtils.safelyClone(bArr, i5 + 8, header, MAX_RECORD_LENGTH);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ddf.i
            public final /* synthetic */ EscherClientDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getRemainingData();
                }
            }
        }, "remainingData", new Supplier(this) { // from class: org.apache.poi.ddf.i
            public final /* synthetic */ EscherClientDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CLIENT_DATA;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.CLIENT_DATA.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        byte[] bArr = this.remainingData;
        return (bArr == null ? 0 : bArr.length) + 8;
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        if (this.remainingData == null) {
            this.remainingData = EMPTY;
        }
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, this.remainingData.length);
        byte[] bArr2 = this.remainingData;
        int i6 = i5 + 8;
        System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
        int length = i6 + this.remainingData.length;
        int i7 = length - i5;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i7, this);
        return i7;
    }

    public void setRemainingData(byte[] bArr) {
        this.remainingData = bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public EscherClientDataRecord(EscherClientDataRecord escherClientDataRecord) {
        super(escherClientDataRecord);
        byte[] bArr = escherClientDataRecord.remainingData;
        this.remainingData = bArr == null ? null : (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherClientDataRecord copy() {
        return new EscherClientDataRecord(this);
    }
}
