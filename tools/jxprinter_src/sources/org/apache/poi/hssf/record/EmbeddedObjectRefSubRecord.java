package org.apache.poi.hssf.record;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EmbeddedObjectRefSubRecord extends SubRecord {
    public static final short sid = 9;
    private int field_1_unknown_int;
    private Ptg field_2_refPtg;
    private byte[] field_2_unknownFormulaData;
    private boolean field_3_unicode_flag;
    private String field_4_ole_classname;
    private Byte field_4_unknownByte;
    private Integer field_5_stream_id;
    private byte[] field_6_unknown;
    private static final Logger LOG = LogManager.getLogger((Class<?>) EmbeddedObjectRefSubRecord.class);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public EmbeddedObjectRefSubRecord() {
        this.field_2_unknownFormulaData = new byte[]{2, 108, 106, 22, 1};
        this.field_6_unknown = EMPTY_BYTE_ARRAY;
        this.field_4_ole_classname = null;
    }

    private int getDataSize(int i5) {
        int i6 = i5 + 2;
        if (this.field_5_stream_id != null) {
            i6 = i5 + 6;
        }
        return i6 + this.field_6_unknown.length;
    }

    private int getStreamIDOffset(int i5) {
        int i6 = i5 + 6;
        String str = this.field_4_ole_classname;
        if (str != null) {
            i6 = i5 + 9;
            int length = str.length();
            if (length > 0) {
                int i7 = i5 + 10;
                i6 = this.field_3_unicode_flag ? (length * 2) + i7 : i7 + length;
            }
        }
        return i6 % 2 != 0 ? i6 + 1 : i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field_1_unknown_int);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this.field_2_unknownFormulaData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return this.field_2_refPtg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Boolean.valueOf(this.field_3_unicode_flag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return this.field_4_ole_classname;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$5() {
        return this.field_4_unknownByte;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$6() {
        return this.field_5_stream_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$7() {
        return this.field_6_unknown;
    }

    private static byte[] readRawData(LittleEndianInput littleEndianInput, int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Negative size (", ")"));
        }
        if (i5 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, HSSFWorkbook.getMaxRecordLength());
        littleEndianInput.readFully(bArrSafelyAllocate);
        return bArrSafelyAllocate;
    }

    private static Ptg readRefPtg(byte[] bArr) {
        Ptg refPtg;
        try {
            LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(new UnsynchronizedByteArrayInputStream(bArr));
            try {
                byte b = littleEndianInputStream.readByte();
                if (b == 36) {
                    refPtg = new RefPtg(littleEndianInputStream);
                } else if (b == 37) {
                    refPtg = new AreaPtg(littleEndianInputStream);
                } else if (b == 58) {
                    refPtg = new Ref3DPtg(littleEndianInputStream);
                } else {
                    if (b != 59) {
                        littleEndianInputStream.close();
                        return null;
                    }
                    refPtg = new Area3DPtg(littleEndianInputStream);
                }
                littleEndianInputStream.close();
                return refPtg;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        littleEndianInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unexpected exception in readRefPtg", e);
        }
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        return GenericRecordUtil.getGenericProperties("f2unknown", supplier, "f3unknown", supplier2, "formula", supplier3, "unicodeFlag", supplier4, "oleClassname", supplier5, "f4unknown", supplier6, "streamId", new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        }, "f7unknown", new Supplier(this) { // from class: org.apache.poi.hssf.record.B
            public final /* synthetic */ EmbeddedObjectRefSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return this.b.lambda$getGenericProperties$4();
                    case 5:
                        return this.b.lambda$getGenericProperties$5();
                    case 6:
                        return this.b.lambda$getGenericProperties$6();
                    default:
                        return this.b.lambda$getGenericProperties$7();
                }
            }
        });
    }

    public String getOLEClassName() {
        return this.field_4_ole_classname;
    }

    public byte[] getObjectData() {
        return this.field_6_unknown;
    }

    public short getSid() {
        return (short) 9;
    }

    public Integer getStreamId() {
        return this.field_5_stream_id;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        Ptg ptg = this.field_2_refPtg;
        int length = ptg == null ? this.field_2_unknownFormulaData.length : ptg.getSize();
        int streamIDOffset = getStreamIDOffset(length);
        int dataSize = getDataSize(streamIDOffset);
        littleEndianOutput.writeShort(9);
        littleEndianOutput.writeShort(dataSize);
        littleEndianOutput.writeShort(streamIDOffset);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeInt(this.field_1_unknown_int);
        Ptg ptg2 = this.field_2_refPtg;
        if (ptg2 == null) {
            littleEndianOutput.write(this.field_2_unknownFormulaData);
        } else {
            ptg2.write(littleEndianOutput);
        }
        int i5 = length + 12;
        if (this.field_4_ole_classname != null) {
            littleEndianOutput.writeByte(3);
            int length2 = this.field_4_ole_classname.length();
            littleEndianOutput.writeShort(length2);
            int i6 = length + 15;
            if (length2 > 0) {
                littleEndianOutput.writeByte(this.field_3_unicode_flag ? 1 : 0);
                int i7 = length + 16;
                if (this.field_3_unicode_flag) {
                    StringUtil.putUnicodeLE(this.field_4_ole_classname, littleEndianOutput);
                    i5 = (length2 * 2) + i7;
                } else {
                    StringUtil.putCompressedUnicode(this.field_4_ole_classname, littleEndianOutput);
                    i5 = length2 + i7;
                }
            } else {
                i5 = i6;
            }
        }
        int i8 = streamIDOffset - (i5 - 6);
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException(androidx.collection.a.m("Bad padding calculation (", streamIDOffset, i5, ", ", ")"));
            }
            Byte b = this.field_4_unknownByte;
            littleEndianOutput.writeByte(b == null ? 0 : b.intValue());
        }
        Integer num = this.field_5_stream_id;
        if (num != null) {
            littleEndianOutput.writeInt(num.intValue());
        }
        littleEndianOutput.write(this.field_6_unknown);
    }

    public void setOleClassname(String str) {
        this.field_4_ole_classname = str;
    }

    public void setStorageId(int i5) {
        this.field_5_stream_id = Integer.valueOf(i5);
    }

    public void setUnknownFormulaData(byte[] bArr) {
        this.field_2_unknownFormulaData = bArr;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.EMBEDDED_OBJECT_REF;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public EmbeddedObjectRefSubRecord copy() {
        return new EmbeddedObjectRefSubRecord(this);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        Ptg ptg = this.field_2_refPtg;
        return getDataSize(getStreamIDOffset(ptg == null ? this.field_2_unknownFormulaData.length : ptg.getSize()));
    }

    public EmbeddedObjectRefSubRecord(EmbeddedObjectRefSubRecord embeddedObjectRefSubRecord) {
        super(embeddedObjectRefSubRecord);
        this.field_1_unknown_int = embeddedObjectRefSubRecord.field_1_unknown_int;
        Ptg ptg = embeddedObjectRefSubRecord.field_2_refPtg;
        this.field_2_refPtg = ptg == null ? null : ptg.copy();
        byte[] bArr = embeddedObjectRefSubRecord.field_2_unknownFormulaData;
        this.field_2_unknownFormulaData = bArr == null ? null : (byte[]) bArr.clone();
        this.field_3_unicode_flag = embeddedObjectRefSubRecord.field_3_unicode_flag;
        this.field_4_ole_classname = embeddedObjectRefSubRecord.field_4_ole_classname;
        this.field_4_unknownByte = embeddedObjectRefSubRecord.field_4_unknownByte;
        this.field_5_stream_id = embeddedObjectRefSubRecord.field_5_stream_id;
        byte[] bArr2 = embeddedObjectRefSubRecord.field_6_unknown;
        this.field_6_unknown = bArr2 != null ? (byte[]) bArr2.clone() : null;
    }

    public EmbeddedObjectRefSubRecord(LittleEndianInput littleEndianInput, int i5) {
        this(littleEndianInput, i5, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmbeddedObjectRefSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        int i7;
        int i8 = (i5 - 2) - littleEndianInput.readShort();
        int uShort = littleEndianInput.readUShort();
        this.field_1_unknown_int = littleEndianInput.readInt();
        byte[] rawData = readRawData(littleEndianInput, uShort);
        int i9 = (i5 - 8) - uShort;
        Ptg refPtg = readRefPtg(rawData);
        this.field_2_refPtg = refPtg;
        if (refPtg == null) {
            this.field_2_unknownFormulaData = rawData;
        } else {
            this.field_2_unknownFormulaData = null;
        }
        int i10 = 0;
        if (i9 >= i8 + 3) {
            if (littleEndianInput.readByte() == 3) {
                int uShort2 = littleEndianInput.readUShort();
                if (uShort2 > 0) {
                    boolean z6 = (littleEndianInput.readByte() & 1) != 0;
                    this.field_3_unicode_flag = z6;
                    if (z6) {
                        this.field_4_ole_classname = StringUtil.readUnicodeLE(littleEndianInput, uShort2);
                        i7 = (uShort2 * 2) + 4;
                    } else {
                        this.field_4_ole_classname = StringUtil.readCompressedUnicode(littleEndianInput, uShort2);
                        i7 = uShort2 + 4;
                    }
                    i10 = i7;
                } else {
                    this.field_4_ole_classname = "";
                    i10 = 3;
                }
            } else {
                throw new RecordFormatException("Expected byte 0x03 here");
            }
        } else {
            this.field_4_ole_classname = null;
        }
        int i11 = i9 - i10;
        if ((i10 + uShort) % 2 != 0) {
            byte b = littleEndianInput.readByte();
            i11--;
            if (this.field_2_refPtg != null && this.field_4_ole_classname == null) {
                this.field_4_unknownByte = Byte.valueOf(b);
            }
        }
        int i12 = i11 - i8;
        if (i12 > 0) {
            LOG.atError().log("Discarding {} unexpected padding bytes", Unbox.box(i12));
            readRawData(littleEndianInput, i12);
            i11 -= i12;
        }
        if (i8 >= 4) {
            this.field_5_stream_id = Integer.valueOf(littleEndianInput.readInt());
            i11 -= 4;
        } else {
            this.field_5_stream_id = null;
        }
        this.field_6_unknown = readRawData(littleEndianInput, i11);
    }
}
