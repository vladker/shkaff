package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherBitmapBlip extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    private final byte[] field_1_UID;
    private byte field_2_marker;
    public static final short RECORD_ID_JPEG = EscherRecordTypes.BLIP_JPEG.typeID;
    public static final short RECORD_ID_PNG = EscherRecordTypes.BLIP_PNG.typeID;
    public static final short RECORD_ID_DIB = EscherRecordTypes.BLIP_DIB.typeID;

    public EscherBitmapBlip() {
        this.field_1_UID = new byte[16];
        this.field_2_marker = (byte) -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        System.arraycopy(bArr, i5 + 8, this.field_1_UID, 0, 16);
        this.field_2_marker = bArr[i5 + 24];
        setPictureData(bArr, i5 + 25, header - 17);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.e
            public final /* synthetic */ EscherBitmapBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getUID();
                    default:
                        return Byte.valueOf(this.b.getMarker());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.e
            public final /* synthetic */ EscherBitmapBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getUID();
                    default:
                        return Byte.valueOf(this.b.getMarker());
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("base", supplier, "uid", supplier2, "marker", new Supplier(this) { // from class: org.apache.poi.ddf.e
            public final /* synthetic */ EscherBitmapBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getUID();
                    default:
                        return Byte.valueOf(this.b.getMarker());
                }
            }
        });
    }

    public byte getMarker() {
        return this.field_2_marker;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return (getPicturedata() == null ? 0 : getPicturedata().length) + 25;
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, getRecordSize() - 8);
        System.arraycopy(this.field_1_UID, 0, bArr, i5 + 8, 16);
        bArr[i5 + 24] = this.field_2_marker;
        byte[] picturedata = getPicturedata();
        System.arraycopy(picturedata, 0, bArr, i5 + 25, picturedata.length);
        escherSerializationListener.afterRecordSerialize(getRecordSize() + i5, getRecordId(), getRecordSize(), this);
        return picturedata.length + 25;
    }

    public void setMarker(byte b) {
        this.field_2_marker = b;
    }

    public void setUID(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("field_1_UID must be byte[16]");
        }
        System.arraycopy(bArr, 0, this.field_1_UID, 0, 16);
    }

    public EscherBitmapBlip(EscherBitmapBlip escherBitmapBlip) {
        super(escherBitmapBlip);
        byte[] bArr = new byte[16];
        this.field_1_UID = bArr;
        this.field_2_marker = (byte) -1;
        System.arraycopy(escherBitmapBlip.field_1_UID, 0, bArr, 0, bArr.length);
        this.field_2_marker = escherBitmapBlip.field_2_marker;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherBitmapBlip copy() {
        return new EscherBitmapBlip(this);
    }
}
