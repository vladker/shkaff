package org.apache.poi.ddf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherBSERecord extends EscherRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static int MAX_RECORD_LENGTH = 100000;
    public static final short RECORD_ID = EscherRecordTypes.BSE.typeID;
    private byte[] _remainingData;
    private byte field_10_unused2;
    private byte field_11_unused3;
    private EscherBlipRecord field_12_blipRecord;
    private byte field_1_blipTypeWin32;
    private byte field_2_blipTypeMacOS;
    private final byte[] field_3_uid;
    private short field_4_tag;
    private int field_5_size;
    private int field_6_ref;
    private int field_7_offset;
    private byte field_8_usage;
    private byte field_9_name;

    public EscherBSERecord() {
        this.field_3_uid = new byte[16];
        this._remainingData = new byte[0];
        setRecordId(RECORD_ID);
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int iFillFields;
        int header = readHeader(bArr, i5);
        int i6 = i5 + 8;
        this.field_1_blipTypeWin32 = bArr[i6];
        this.field_2_blipTypeMacOS = bArr[i5 + 9];
        System.arraycopy(bArr, i5 + 10, this.field_3_uid, 0, 16);
        this.field_4_tag = LittleEndian.getShort(bArr, i5 + 26);
        this.field_5_size = LittleEndian.getInt(bArr, i5 + 28);
        this.field_6_ref = LittleEndian.getInt(bArr, i5 + 32);
        this.field_7_offset = LittleEndian.getInt(bArr, i5 + 36);
        this.field_8_usage = bArr[i5 + 40];
        this.field_9_name = bArr[i5 + 41];
        this.field_10_unused2 = bArr[i5 + 42];
        this.field_11_unused3 = bArr[i5 + 43];
        int i7 = header - 36;
        if (i7 > 0) {
            int i8 = i5 + 44;
            EscherBlipRecord escherBlipRecord = (EscherBlipRecord) escherRecordFactory.createRecord(bArr, i8);
            this.field_12_blipRecord = escherBlipRecord;
            iFillFields = escherBlipRecord.fillFields(bArr, i8, escherRecordFactory);
        } else {
            iFillFields = 0;
        }
        int i9 = i7 - iFillFields;
        this._remainingData = IOUtils.safelyClone(bArr, iFillFields + 36 + i6, i9, MAX_RECORD_LENGTH);
        int i10 = i9 + 44;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        return i10 + (escherBlipRecord2 != null ? escherBlipRecord2.getRecordSize() : 0);
    }

    public EscherBlipRecord getBlipRecord() {
        return this.field_12_blipRecord;
    }

    public byte getBlipTypeMacOS() {
        return this.field_2_blipTypeMacOS;
    }

    public byte getBlipTypeWin32() {
        return this.field_1_blipTypeWin32;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(super.getGenericProperties());
        final int i5 = 0;
        linkedHashMap.put("blipTypeWin32", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i6 = 11;
        linkedHashMap.put("pictureTypeWin32", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i7 = 12;
        linkedHashMap.put("blipTypeMacOS", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i8 = 13;
        linkedHashMap.put("pictureTypeMacOS", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i9 = 14;
        linkedHashMap.put("suid", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i10 = 1;
        linkedHashMap.put("tag", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i11 = 2;
        linkedHashMap.put("size", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i12 = 3;
        linkedHashMap.put("ref", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i13 = 4;
        linkedHashMap.put(TypedValues.CycleType.S_WAVE_OFFSET, new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i14 = 5;
        linkedHashMap.put("usage", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i15 = 6;
        linkedHashMap.put("name", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i16 = 7;
        linkedHashMap.put("unused2", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i17 = 8;
        linkedHashMap.put("unused3", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i17) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i18 = 9;
        linkedHashMap.put("blipRecord", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i18) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        final int i19 = 10;
        linkedHashMap.put("remainingData", new Supplier(this) { // from class: org.apache.poi.ddf.d
            public final /* synthetic */ EscherBSERecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i19) {
                    case 0:
                        return Byte.valueOf(this.b.getBlipTypeWin32());
                    case 1:
                        return Short.valueOf(this.b.getTag());
                    case 2:
                        return Integer.valueOf(this.b.getSize());
                    case 3:
                        return Integer.valueOf(this.b.getRef());
                    case 4:
                        return Integer.valueOf(this.b.getOffset());
                    case 5:
                        return Byte.valueOf(this.b.getUsage());
                    case 6:
                        return Byte.valueOf(this.b.getName());
                    case 7:
                        return Byte.valueOf(this.b.getUnused2());
                    case 8:
                        return Byte.valueOf(this.b.getUnused3());
                    case 9:
                        return this.b.getBlipRecord();
                    case 10:
                        return this.b.getRemainingData();
                    case 11:
                        return this.b.getPictureTypeWin32();
                    case 12:
                        return Byte.valueOf(this.b.getBlipTypeMacOS());
                    case 13:
                        return this.b.getPictureTypeMacOS();
                    default:
                        return this.b.getUid();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.BSE;
    }

    public byte getName() {
        return this.field_9_name;
    }

    public int getOffset() {
        return this.field_7_offset;
    }

    public PictureData.PictureType getPictureTypeMacOS() {
        return PictureData.PictureType.forNativeID(this.field_2_blipTypeMacOS);
    }

    public PictureData.PictureType getPictureTypeWin32() {
        return PictureData.PictureType.forNativeID(this.field_1_blipTypeWin32);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.BSE.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        int recordSize = escherBlipRecord != null ? escherBlipRecord.getRecordSize() : 0;
        byte[] bArr = this._remainingData;
        return recordSize + 44 + (bArr != null ? bArr.length : 0);
    }

    public int getRef() {
        return this.field_6_ref;
    }

    public byte[] getRemainingData() {
        return this._remainingData;
    }

    public int getSize() {
        return this.field_5_size;
    }

    public short getTag() {
        return this.field_4_tag;
    }

    public byte[] getUid() {
        return this.field_3_uid;
    }

    public byte getUnused2() {
        return this.field_10_unused2;
    }

    public byte getUnused3() {
        return this.field_11_unused3;
    }

    public byte getUsage() {
        return this.field_8_usage;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        LittleEndian.putInt(bArr, i5 + 4, this._remainingData.length + 36 + (escherBlipRecord == null ? 0 : escherBlipRecord.getRecordSize()));
        bArr[i5 + 8] = this.field_1_blipTypeWin32;
        bArr[i5 + 9] = this.field_2_blipTypeMacOS;
        System.arraycopy(this.field_3_uid, 0, bArr, i5 + 10, 16);
        LittleEndian.putShort(bArr, i5 + 26, this.field_4_tag);
        LittleEndian.putInt(bArr, i5 + 28, this.field_5_size);
        LittleEndian.putInt(bArr, i5 + 32, this.field_6_ref);
        LittleEndian.putInt(bArr, i5 + 36, this.field_7_offset);
        bArr[i5 + 40] = this.field_8_usage;
        bArr[i5 + 41] = this.field_9_name;
        bArr[i5 + 42] = this.field_10_unused2;
        bArr[i5 + 43] = this.field_11_unused3;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        int iSerialize = escherBlipRecord2 != null ? escherBlipRecord2.serialize(i5 + 44, bArr, new NullEscherSerializationListener()) : 0;
        byte[] bArr2 = this._remainingData;
        System.arraycopy(bArr2, 0, bArr, i5 + 44 + iSerialize, bArr2.length);
        int length = i5 + 44 + this._remainingData.length + iSerialize;
        int i6 = length - i5;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i6, this);
        return i6;
    }

    public void setBlipRecord(EscherBlipRecord escherBlipRecord) {
        this.field_12_blipRecord = escherBlipRecord;
    }

    public void setBlipTypeMacOS(byte b) {
        this.field_2_blipTypeMacOS = b;
    }

    public void setBlipTypeWin32(byte b) {
        this.field_1_blipTypeWin32 = b;
    }

    public void setName(byte b) {
        this.field_9_name = b;
    }

    public void setOffset(int i5) {
        this.field_7_offset = i5;
    }

    public void setRef(int i5) {
        this.field_6_ref = i5;
    }

    public void setRemainingData(byte[] bArr) {
        this._remainingData = bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public void setSize(int i5) {
        this.field_5_size = i5;
    }

    public void setTag(short s6) {
        this.field_4_tag = s6;
    }

    public void setUid(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("uid must be byte[16]");
        }
        byte[] bArr2 = this.field_3_uid;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public void setUnused2(byte b) {
        this.field_10_unused2 = b;
    }

    public void setUnused3(byte b) {
        this.field_11_unused3 = b;
    }

    public void setUsage(byte b) {
        this.field_8_usage = b;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherBSERecord copy() {
        return new EscherBSERecord(this);
    }

    public EscherBSERecord(EscherBSERecord escherBSERecord) {
        super(escherBSERecord);
        byte[] bArr = new byte[16];
        this.field_3_uid = bArr;
        this._remainingData = new byte[0];
        this.field_1_blipTypeWin32 = escherBSERecord.field_1_blipTypeWin32;
        this.field_2_blipTypeMacOS = escherBSERecord.field_2_blipTypeMacOS;
        System.arraycopy(escherBSERecord.field_3_uid, 0, bArr, 0, bArr.length);
        this.field_4_tag = escherBSERecord.field_4_tag;
        this.field_5_size = escherBSERecord.field_5_size;
        this.field_6_ref = escherBSERecord.field_6_ref;
        this.field_7_offset = escherBSERecord.field_7_offset;
        this.field_8_usage = escherBSERecord.field_8_usage;
        this.field_9_name = escherBSERecord.field_9_name;
        this.field_10_unused2 = escherBSERecord.field_10_unused2;
        this.field_11_unused3 = escherBSERecord.field_11_unused3;
        this.field_12_blipRecord = escherBSERecord.field_12_blipRecord.copy();
        this._remainingData = (byte[]) escherBSERecord._remainingData.clone();
    }
}
