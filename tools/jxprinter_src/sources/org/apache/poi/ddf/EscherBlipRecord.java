package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherBlipRecord extends EscherRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 104857600;
    private static final int HEADER_SIZE = 8;
    private static int MAX_RECORD_LENGTH = 104857600;
    private byte[] field_pictureData;
    public static final short RECORD_ID_START = EscherRecordTypes.BLIP_START.typeID;
    public static final short RECORD_ID_END = EscherRecordTypes.BLIP_END.typeID;

    public EscherBlipRecord() {
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
        this.field_pictureData = IOUtils.safelyClone(bArr, i5 + 8, header, MAX_RECORD_LENGTH);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ddf.f
            public final /* synthetic */ EscherBlipRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getPicturedata();
                }
            }
        }, "pictureData", new Supplier(this) { // from class: org.apache.poi.ddf.f
            public final /* synthetic */ EscherBlipRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getPicturedata();
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        EscherRecordTypes escherRecordTypesForTypeID = EscherRecordTypes.forTypeID(getRecordId());
        return escherRecordTypesForTypeID != EscherRecordTypes.UNKNOWN ? escherRecordTypesForTypeID : EscherRecordTypes.BLIP_START;
    }

    public byte[] getPicturedata() {
        return this.field_pictureData;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        EscherRecordTypes escherRecordTypesForTypeID = EscherRecordTypes.forTypeID(getRecordId());
        if (escherRecordTypesForTypeID == EscherRecordTypes.UNKNOWN) {
            escherRecordTypesForTypeID = EscherRecordTypes.BLIP_START;
        }
        return escherRecordTypesForTypeID.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.field_pictureData.length + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        byte[] bArr2 = this.field_pictureData;
        int i6 = i5 + 4;
        System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
        escherSerializationListener.afterRecordSerialize(i6 + this.field_pictureData.length, getRecordId(), this.field_pictureData.length + 4, this);
        return this.field_pictureData.length + 4;
    }

    public void setPictureData(byte[] bArr) {
        setPictureData(bArr, 0, bArr == null ? 0 : bArr.length);
    }

    public EscherBlipRecord(EscherBlipRecord escherBlipRecord) {
        super(escherBlipRecord);
        byte[] bArr = escherBlipRecord.field_pictureData;
        this.field_pictureData = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setPictureData(byte[] bArr, int i5, int i6) {
        if (bArr == null || i5 < 0 || i6 < 0 || bArr.length < i5 + i6) {
            throw new IllegalArgumentException("picture data can't be null");
        }
        this.field_pictureData = IOUtils.safelyClone(bArr, i5, i6, MAX_RECORD_LENGTH);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherBlipRecord copy() {
        return new EscherBlipRecord(this);
    }
}
