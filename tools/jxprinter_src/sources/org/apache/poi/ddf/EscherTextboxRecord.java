package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherTextboxRecord extends EscherRecord {
    private static int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static int MAX_RECORD_LENGTH = 100000;
    private byte[] thedata;
    public static final short RECORD_ID = EscherRecordTypes.CLIENT_TEXTBOX.typeID;
    private static final byte[] NO_BYTES = new byte[0];

    public EscherTextboxRecord() {
        this.thedata = NO_BYTES;
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
        this.thedata = IOUtils.safelyClone(bArr, i5 + 8, header, MAX_RECORD_LENGTH);
        return header + 8;
    }

    public byte[] getData() {
        return this.thedata;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.y
            public final /* synthetic */ EscherTextboxRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isContainerRecord());
                    default:
                        return this.b.getData();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.y
            public final /* synthetic */ EscherTextboxRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isContainerRecord());
                    default:
                        return this.b.getData();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("base", supplier, "isContainer", supplier2, "extraData", new Supplier(this) { // from class: org.apache.poi.ddf.y
            public final /* synthetic */ EscherTextboxRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isContainerRecord());
                    default:
                        return this.b.getData();
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CLIENT_TEXTBOX;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.CLIENT_TEXTBOX.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, this.thedata.length);
        byte[] bArr2 = this.thedata;
        int i6 = i5 + 8;
        System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
        int length = i6 + this.thedata.length;
        int i7 = length - i5;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i7, this);
        if (i7 == getRecordSize()) {
            return i7;
        }
        throw new RecordFormatException(i7 + " bytes written but getRecordSize() reports " + getRecordSize());
    }

    public void setData(byte[] bArr, int i5, int i6) {
        this.thedata = IOUtils.safelyClone(bArr, i5, i6, MAX_RECORD_LENGTH);
    }

    public void setData(byte[] bArr) {
        setData(bArr, 0, bArr.length);
    }

    public EscherTextboxRecord(EscherTextboxRecord escherTextboxRecord) {
        super(escherTextboxRecord);
        byte[] bArr = NO_BYTES;
        this.thedata = bArr;
        byte[] bArr2 = escherTextboxRecord.thedata;
        this.thedata = bArr2 != null ? (byte[]) bArr2.clone() : bArr;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherTextboxRecord copy() {
        return new EscherTextboxRecord(this);
    }
}
