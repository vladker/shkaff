package org.apache.poi.ddf;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherMetafileBlip extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    private final byte[] field_1_UID;
    private final byte[] field_2_UID;
    private int field_2_cb;
    private int field_3_rcBounds_x1;
    private int field_3_rcBounds_x2;
    private int field_3_rcBounds_y1;
    private int field_3_rcBounds_y2;
    private int field_4_ptSize_h;
    private int field_4_ptSize_w;
    private int field_5_cbSave;
    private byte field_6_fCompression;
    private byte field_7_fFilter;
    private byte[] raw_pictureData;
    private byte[] remainingData;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) EscherMetafileBlip.class);
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000000;
    private static int MAX_RECORD_LENGTH = DEFAULT_MAX_RECORD_LENGTH;

    @Removal(version = "5.3")
    @Deprecated
    public static final short RECORD_ID_EMF = EscherRecordTypes.BLIP_EMF.typeID;

    @Removal(version = "5.3")
    @Deprecated
    public static final short RECORD_ID_WMF = EscherRecordTypes.BLIP_WMF.typeID;

    @Removal(version = "5.3")
    @Deprecated
    public static final short RECORD_ID_PICT = EscherRecordTypes.BLIP_PICT.typeID;

    /* JADX INFO: renamed from: org.apache.poi.ddf.EscherMetafileBlip$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes;

        static {
            int[] iArr = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = iArr;
            try {
                iArr[EscherRecordTypes.BLIP_EMF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_WMF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_PICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public EscherMetafileBlip() {
        this.field_1_UID = new byte[16];
        this.field_2_UID = new byte[16];
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    private static byte[] inflatePictureData(byte[] bArr) {
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new UnsynchronizedByteArrayInputStream(bArr));
            try {
                UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
                try {
                    IOUtils.copy(inflaterInputStream, unsynchronizedByteArrayOutputStream);
                    byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                    unsynchronizedByteArrayOutputStream.close();
                    inflaterInputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            unsynchronizedByteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        inflaterInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            LOGGER.atWarn().withThrowable(e).log("Possibly corrupt compression or non-compressed data");
            return bArr;
        }
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        System.arraycopy(bArr, i5 + 8, this.field_1_UID, 0, 16);
        int i6 = i5 + 24;
        if ((getOptions() ^ getSignature()) == 16) {
            System.arraycopy(bArr, i6, this.field_2_UID, 0, 16);
            i6 = i5 + 40;
        }
        this.field_2_cb = LittleEndian.getInt(bArr, i6);
        this.field_3_rcBounds_x1 = LittleEndian.getInt(bArr, i6 + 4);
        this.field_3_rcBounds_y1 = LittleEndian.getInt(bArr, i6 + 8);
        this.field_3_rcBounds_x2 = LittleEndian.getInt(bArr, i6 + 12);
        this.field_3_rcBounds_y2 = LittleEndian.getInt(bArr, i6 + 16);
        this.field_4_ptSize_w = LittleEndian.getInt(bArr, i6 + 20);
        this.field_4_ptSize_h = LittleEndian.getInt(bArr, i6 + 24);
        int i7 = LittleEndian.getInt(bArr, i6 + 28);
        this.field_5_cbSave = i7;
        this.field_6_fCompression = bArr[i6 + 32];
        this.field_7_fFilter = bArr[i6 + 33];
        int i8 = i6 + 34;
        byte[] bArrSafelyClone = IOUtils.safelyClone(bArr, i8, i7, MAX_RECORD_LENGTH);
        this.raw_pictureData = bArrSafelyClone;
        int i9 = i8 + this.field_5_cbSave;
        if (this.field_6_fCompression == 0) {
            super.setPictureData(inflatePictureData(bArrSafelyClone));
        } else {
            super.setPictureData(bArrSafelyClone);
        }
        int i10 = (header - i9) + i5 + 8;
        if (i10 > 0) {
            this.remainingData = IOUtils.safelyClone(bArr, i9, i10, MAX_RECORD_LENGTH);
        }
        return header + 8;
    }

    public Rectangle getBounds() {
        int i5 = this.field_3_rcBounds_x1;
        int i6 = this.field_3_rcBounds_y1;
        return new Rectangle(i5, i6, this.field_3_rcBounds_x2 - i5, this.field_3_rcBounds_y2 - i6);
    }

    public int getCompressedSize() {
        return this.field_5_cbSave;
    }

    public byte getFilter() {
        return this.field_7_fFilter;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(super.getGenericProperties());
        final int i5 = 0;
        linkedHashMap.put("uid", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("uncompressedSize", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("bounds", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("sizeInEMU", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("compressedSize", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("isCompressed", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("filter", new Supplier(this) { // from class: org.apache.poi.ddf.q
            public final /* synthetic */ EscherMetafileBlip b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.getUID();
                    case 1:
                        return Integer.valueOf(this.b.getUncompressedSize());
                    case 2:
                        return this.b.getBounds();
                    case 3:
                        return this.b.getSizeEMU();
                    case 4:
                        return Integer.valueOf(this.b.getCompressedSize());
                    case 5:
                        return Boolean.valueOf(this.b.isCompressed());
                    default:
                        return Byte.valueOf(this.b.getFilter());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public byte[] getPrimaryUID() {
        return this.field_2_UID;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        int length = this.raw_pictureData.length + 58;
        byte[] bArr = this.remainingData;
        if (bArr != null) {
            length += bArr.length;
        }
        return (getOptions() ^ getSignature()) == 16 ? length + this.field_2_UID.length : length;
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public short getSignature() {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.forTypeID(getRecordId()).ordinal()];
        if (i5 == 1) {
            return HSSFPictureData.MSOBI_EMF;
        }
        if (i5 == 2) {
            return HSSFPictureData.MSOBI_WMF;
        }
        if (i5 == 3) {
            return HSSFPictureData.MSOBI_PICT;
        }
        LOGGER.atWarn().log("Unknown metafile: {}", Unbox.box(getRecordId()));
        return (short) 0;
    }

    public Dimension getSizeEMU() {
        return new Dimension(this.field_4_ptSize_w, this.field_4_ptSize_h);
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    public int getUncompressedSize() {
        return this.field_2_cb;
    }

    public boolean isCompressed() {
        return this.field_6_fCompression == 0;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, getRecordSize() - 8);
        int i6 = i5 + 8;
        byte[] bArr2 = this.field_1_UID;
        System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
        int length = i6 + this.field_1_UID.length;
        if ((getOptions() ^ getSignature()) == 16) {
            byte[] bArr3 = this.field_2_UID;
            System.arraycopy(bArr3, 0, bArr, length, bArr3.length);
            length += this.field_2_UID.length;
        }
        LittleEndian.putInt(bArr, length, this.field_2_cb);
        LittleEndian.putInt(bArr, length + 4, this.field_3_rcBounds_x1);
        LittleEndian.putInt(bArr, length + 8, this.field_3_rcBounds_y1);
        LittleEndian.putInt(bArr, length + 12, this.field_3_rcBounds_x2);
        LittleEndian.putInt(bArr, length + 16, this.field_3_rcBounds_y2);
        LittleEndian.putInt(bArr, length + 20, this.field_4_ptSize_w);
        LittleEndian.putInt(bArr, length + 24, this.field_4_ptSize_h);
        LittleEndian.putInt(bArr, length + 28, this.field_5_cbSave);
        bArr[length + 32] = this.field_6_fCompression;
        bArr[length + 33] = this.field_7_fFilter;
        int i7 = length + 34;
        byte[] bArr4 = this.raw_pictureData;
        System.arraycopy(bArr4, 0, bArr, i7, bArr4.length);
        int length2 = i7 + this.raw_pictureData.length;
        byte[] bArr5 = this.remainingData;
        if (bArr5 != null) {
            System.arraycopy(bArr5, 0, bArr, length2, bArr5.length);
        }
        escherSerializationListener.afterRecordSerialize(getRecordSize() + i5, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public void setBounds(Rectangle rectangle) {
        this.field_3_rcBounds_x1 = rectangle.x;
        this.field_3_rcBounds_y1 = rectangle.y;
        this.field_3_rcBounds_x2 = rectangle.x + rectangle.width;
        this.field_3_rcBounds_y2 = rectangle.y + rectangle.height;
    }

    public void setCompressed(boolean z6) {
        this.field_6_fCompression = z6 ? (byte) 0 : (byte) -2;
    }

    public void setCompressedSize(int i5) {
        this.field_5_cbSave = i5;
    }

    public void setFilter(byte b) {
        this.field_7_fFilter = b;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord
    public void setPictureData(byte[] bArr) {
        super.setPictureData(bArr);
        setUncompressedSize(bArr.length);
        try {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(unsynchronizedByteArrayOutputStream);
                try {
                    deflaterOutputStream.write(bArr);
                    deflaterOutputStream.close();
                    this.raw_pictureData = unsynchronizedByteArrayOutputStream.toByteArray();
                    unsynchronizedByteArrayOutputStream.close();
                    setCompressedSize(this.raw_pictureData.length);
                    setCompressed(true);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            deflaterOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't compress metafile picture data", e);
        }
    }

    public void setPrimaryUID(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("primaryUID must be byte[16]");
        }
        byte[] bArr2 = this.field_2_UID;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public void setSizeEMU(Dimension dimension) {
        this.field_4_ptSize_w = dimension.width;
        this.field_4_ptSize_h = dimension.height;
    }

    public void setUID(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("uid must be byte[16]");
        }
        byte[] bArr2 = this.field_1_UID;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public void setUncompressedSize(int i5) {
        this.field_2_cb = i5;
    }

    public EscherMetafileBlip(EscherMetafileBlip escherMetafileBlip) {
        super(escherMetafileBlip);
        byte[] bArr = new byte[16];
        this.field_1_UID = bArr;
        byte[] bArr2 = new byte[16];
        this.field_2_UID = bArr2;
        System.arraycopy(escherMetafileBlip.field_1_UID, 0, bArr, 0, bArr.length);
        System.arraycopy(escherMetafileBlip.field_2_UID, 0, bArr2, 0, bArr2.length);
        this.field_2_cb = escherMetafileBlip.field_2_cb;
        this.field_3_rcBounds_x1 = escherMetafileBlip.field_3_rcBounds_x1;
        this.field_3_rcBounds_y1 = escherMetafileBlip.field_3_rcBounds_y1;
        this.field_3_rcBounds_x2 = escherMetafileBlip.field_3_rcBounds_x2;
        this.field_3_rcBounds_y2 = escherMetafileBlip.field_3_rcBounds_y2;
        this.field_4_ptSize_h = escherMetafileBlip.field_4_ptSize_h;
        this.field_4_ptSize_w = escherMetafileBlip.field_4_ptSize_w;
        this.field_5_cbSave = escherMetafileBlip.field_5_cbSave;
        this.field_6_fCompression = escherMetafileBlip.field_6_fCompression;
        this.field_7_fFilter = escherMetafileBlip.field_7_fFilter;
        byte[] bArr3 = escherMetafileBlip.raw_pictureData;
        this.raw_pictureData = bArr3 == null ? null : (byte[]) bArr3.clone();
        byte[] bArr4 = escherMetafileBlip.remainingData;
        this.remainingData = bArr4 != null ? (byte[]) bArr4.clone() : null;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherMetafileBlip copy() {
        return new EscherMetafileBlip(this);
    }
}
