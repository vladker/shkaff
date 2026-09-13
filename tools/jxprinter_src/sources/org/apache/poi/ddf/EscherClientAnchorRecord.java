package org.apache.poi.ddf;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherClientAnchorRecord extends EscherRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static int MAX_RECORD_LENGTH = 100000;
    public static final short RECORD_ID = EscherRecordTypes.CLIENT_ANCHOR.typeID;
    private short field_1_flag;
    private short field_2_col1;
    private short field_3_dx1;
    private short field_4_row1;
    private short field_5_dy1;
    private short field_6_col2;
    private short field_7_dx2;
    private short field_8_row2;
    private short field_9_dy2;
    private byte[] remainingData;
    private boolean shortRecord;

    public EscherClientAnchorRecord() {
        this.remainingData = new byte[0];
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        int i6 = i5 + 8;
        int i7 = 0;
        if (header != 4) {
            this.field_1_flag = LittleEndian.getShort(bArr, i6);
            this.field_2_col1 = LittleEndian.getShort(bArr, i5 + 10);
            this.field_3_dx1 = LittleEndian.getShort(bArr, i5 + 12);
            this.field_4_row1 = LittleEndian.getShort(bArr, i5 + 14);
            if (header >= 18) {
                this.field_5_dy1 = LittleEndian.getShort(bArr, i5 + 16);
                this.field_6_col2 = LittleEndian.getShort(bArr, i5 + 18);
                this.field_7_dx2 = LittleEndian.getShort(bArr, i5 + 20);
                this.field_8_row2 = LittleEndian.getShort(bArr, i5 + 22);
                this.field_9_dy2 = LittleEndian.getShort(bArr, i5 + 24);
                this.shortRecord = false;
                i7 = 18;
            } else {
                this.shortRecord = true;
                i7 = 8;
            }
        }
        int i8 = header - i7;
        this.remainingData = IOUtils.safelyClone(bArr, i6 + i7, i8, MAX_RECORD_LENGTH);
        return i7 + 8 + i8;
    }

    public short getCol1() {
        return this.field_2_col1;
    }

    public short getCol2() {
        return this.field_6_col2;
    }

    public short getDx1() {
        return this.field_3_dx1;
    }

    public short getDx2() {
        return this.field_7_dx2;
    }

    public short getDy1() {
        return this.field_5_dy1;
    }

    public short getDy2() {
        return this.field_9_dy2;
    }

    public short getFlag() {
        return this.field_1_flag;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(super.getGenericProperties());
        final int i5 = 0;
        linkedHashMap.put("flag", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("col1", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("dx1", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("row1", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("dy1", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("col2", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("dx2", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("row2", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i13 = 8;
        linkedHashMap.put("dy2", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        final int i14 = 9;
        linkedHashMap.put("remainingData", new Supplier(this) { // from class: org.apache.poi.ddf.h
            public final /* synthetic */ EscherClientAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Short.valueOf(this.b.getFlag());
                    case 1:
                        return Short.valueOf(this.b.getCol1());
                    case 2:
                        return Short.valueOf(this.b.getDx1());
                    case 3:
                        return Short.valueOf(this.b.getRow1());
                    case 4:
                        return Short.valueOf(this.b.getDy1());
                    case 5:
                        return Short.valueOf(this.b.getCol2());
                    case 6:
                        return Short.valueOf(this.b.getDx2());
                    case 7:
                        return Short.valueOf(this.b.getRow2());
                    case 8:
                        return Short.valueOf(this.b.getDy2());
                    default:
                        return this.b.getRemainingData();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CLIENT_ANCHOR;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.CLIENT_ANCHOR.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        int i5 = (this.shortRecord ? 8 : 18) + 8;
        byte[] bArr = this.remainingData;
        return i5 + (bArr == null ? 0 : bArr.length);
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public short getRow1() {
        return this.field_4_row1;
    }

    public short getRow2() {
        return this.field_8_row2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        if (this.remainingData == null) {
            this.remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, this.remainingData.length + (this.shortRecord ? 8 : 18));
        int i6 = i5 + 8;
        LittleEndian.putShort(bArr, i6, this.field_1_flag);
        LittleEndian.putShort(bArr, i5 + 10, this.field_2_col1);
        LittleEndian.putShort(bArr, i5 + 12, this.field_3_dx1);
        LittleEndian.putShort(bArr, i5 + 14, this.field_4_row1);
        if (!this.shortRecord) {
            LittleEndian.putShort(bArr, i5 + 16, this.field_5_dy1);
            LittleEndian.putShort(bArr, i5 + 18, this.field_6_col2);
            LittleEndian.putShort(bArr, i5 + 20, this.field_7_dx2);
            LittleEndian.putShort(bArr, i5 + 22, this.field_8_row2);
            LittleEndian.putShort(bArr, i5 + 24, this.field_9_dy2);
        }
        byte[] bArr2 = this.remainingData;
        System.arraycopy(bArr2, 0, bArr, (this.shortRecord ? 16 : 26) + i5, bArr2.length);
        int length = i6 + (this.shortRecord ? 8 : 18) + this.remainingData.length;
        int i7 = length - i5;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i7, this);
        return i7;
    }

    public void setCol1(short s6) {
        this.field_2_col1 = s6;
    }

    public void setCol2(short s6) {
        this.shortRecord = false;
        this.field_6_col2 = s6;
    }

    public void setDx1(short s6) {
        this.field_3_dx1 = s6;
    }

    public void setDx2(short s6) {
        this.shortRecord = false;
        this.field_7_dx2 = s6;
    }

    public void setDy1(short s6) {
        this.shortRecord = false;
        this.field_5_dy1 = s6;
    }

    public void setDy2(short s6) {
        this.shortRecord = false;
        this.field_9_dy2 = s6;
    }

    public void setFlag(short s6) {
        this.field_1_flag = s6;
    }

    public void setRemainingData(byte[] bArr) {
        if (bArr == null) {
            this.remainingData = new byte[0];
        } else {
            this.remainingData = (byte[]) bArr.clone();
        }
    }

    public void setRow1(short s6) {
        this.field_4_row1 = s6;
    }

    public void setRow2(short s6) {
        this.shortRecord = false;
        this.field_8_row2 = s6;
    }

    public EscherClientAnchorRecord(EscherClientAnchorRecord escherClientAnchorRecord) {
        super(escherClientAnchorRecord);
        this.remainingData = new byte[0];
        this.field_1_flag = escherClientAnchorRecord.field_1_flag;
        this.field_2_col1 = escherClientAnchorRecord.field_2_col1;
        this.field_3_dx1 = escherClientAnchorRecord.field_3_dx1;
        this.field_4_row1 = escherClientAnchorRecord.field_4_row1;
        this.field_5_dy1 = escherClientAnchorRecord.field_5_dy1;
        this.field_6_col2 = escherClientAnchorRecord.field_6_col2;
        this.field_7_dx2 = escherClientAnchorRecord.field_7_dx2;
        this.field_8_row2 = escherClientAnchorRecord.field_8_row2;
        this.field_9_dy2 = escherClientAnchorRecord.field_9_dy2;
        byte[] bArr = escherClientAnchorRecord.remainingData;
        this.remainingData = bArr == null ? null : (byte[]) bArr.clone();
        this.shortRecord = escherClientAnchorRecord.shortRecord;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherClientAnchorRecord copy() {
        return new EscherClientAnchorRecord(this);
    }
}
