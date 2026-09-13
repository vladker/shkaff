package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BoundSheetRecord extends StandardRecord {
    public static final short sid = 133;
    private int field_1_position_of_BOF;
    private int field_2_option_flags;
    private int field_4_isMultibyteUnicode;
    private String field_5_sheetname;
    private static final BitField hiddenFlag = BitFieldFactory.getInstance(1);
    private static final BitField veryHiddenFlag = BitFieldFactory.getInstance(2);

    public BoundSheetRecord(String str) {
        this.field_2_option_flags = 0;
        setSheetname(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareRecords(BoundSheetRecord boundSheetRecord, BoundSheetRecord boundSheetRecord2) {
        return boundSheetRecord.getPositionOfBof() - boundSheetRecord2.getPositionOfBof();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMultibyte() {
        return (this.field_4_isMultibyteUnicode & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field_2_option_flags);
    }

    public static BoundSheetRecord[] orderByBofPosition(List<BoundSheetRecord> list) {
        BoundSheetRecord[] boundSheetRecordArr = new BoundSheetRecord[list.size()];
        list.toArray(boundSheetRecordArr);
        Arrays.sort(boundSheetRecordArr, new C1398f());
        return boundSheetRecordArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_5_sheetname.length() * (isMultibyte() ? 2 : 1)) + 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.g
            public final /* synthetic */ BoundSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return Boolean.valueOf(this.b.isMultibyte());
                    case 3:
                        return this.b.getSheetname();
                    case 4:
                        return Boolean.valueOf(this.b.isHidden());
                    default:
                        return Boolean.valueOf(this.b.isVeryHidden());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g
            public final /* synthetic */ BoundSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return Boolean.valueOf(this.b.isMultibyte());
                    case 3:
                        return this.b.getSheetname();
                    case 4:
                        return Boolean.valueOf(this.b.isHidden());
                    default:
                        return Boolean.valueOf(this.b.isVeryHidden());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g
            public final /* synthetic */ BoundSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return Boolean.valueOf(this.b.isMultibyte());
                    case 3:
                        return this.b.getSheetname();
                    case 4:
                        return Boolean.valueOf(this.b.isHidden());
                    default:
                        return Boolean.valueOf(this.b.isVeryHidden());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g
            public final /* synthetic */ BoundSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return Boolean.valueOf(this.b.isMultibyte());
                    case 3:
                        return this.b.getSheetname();
                    case 4:
                        return Boolean.valueOf(this.b.isHidden());
                    default:
                        return Boolean.valueOf(this.b.isVeryHidden());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g
            public final /* synthetic */ BoundSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return Boolean.valueOf(this.b.isMultibyte());
                    case 3:
                        return this.b.getSheetname();
                    case 4:
                        return Boolean.valueOf(this.b.isHidden());
                    default:
                        return Boolean.valueOf(this.b.isVeryHidden());
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("bof", supplier, "optionFlags", supplier2, "multiByte", supplier3, "sheetName", supplier4, CellUtil.HIDDEN, supplier5, "veryHidden", new Supplier(this) { // from class: org.apache.poi.hssf.record.g
            public final /* synthetic */ BoundSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return Boolean.valueOf(this.b.isMultibyte());
                    case 3:
                        return this.b.getSheetname();
                    case 4:
                        return Boolean.valueOf(this.b.isHidden());
                    default:
                        return Boolean.valueOf(this.b.isVeryHidden());
                }
            }
        });
    }

    public int getPositionOfBof() {
        return this.field_1_position_of_BOF;
    }

    public String getSheetname() {
        return this.field_5_sheetname;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 133;
    }

    public boolean isHidden() {
        return hiddenFlag.isSet(this.field_2_option_flags);
    }

    public boolean isVeryHidden() {
        return veryHiddenFlag.isSet(this.field_2_option_flags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getPositionOfBof());
        littleEndianOutput.writeShort(this.field_2_option_flags);
        String str = this.field_5_sheetname;
        littleEndianOutput.writeByte(str.length());
        littleEndianOutput.writeByte(this.field_4_isMultibyteUnicode);
        if (isMultibyte()) {
            StringUtil.putUnicodeLE(str, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public void setHidden(boolean z6) {
        this.field_2_option_flags = hiddenFlag.setBoolean(this.field_2_option_flags, z6);
    }

    public void setPositionOfBof(int i5) {
        this.field_1_position_of_BOF = i5;
    }

    public void setSheetname(String str) {
        WorkbookUtil.validateSheetName(str);
        this.field_5_sheetname = str;
        this.field_4_isMultibyteUnicode = StringUtil.hasMultibyte(str) ? 1 : 0;
    }

    public void setVeryHidden(boolean z6) {
        this.field_2_option_flags = veryHiddenFlag.setBoolean(this.field_2_option_flags, z6);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOUND_SHEET;
    }

    public BoundSheetRecord(BoundSheetRecord boundSheetRecord) {
        super(boundSheetRecord);
        this.field_1_position_of_BOF = boundSheetRecord.field_1_position_of_BOF;
        this.field_2_option_flags = boundSheetRecord.field_2_option_flags;
        this.field_4_isMultibyteUnicode = boundSheetRecord.field_4_isMultibyteUnicode;
        this.field_5_sheetname = boundSheetRecord.field_5_sheetname;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public BoundSheetRecord copy() {
        return new BoundSheetRecord(this);
    }

    public BoundSheetRecord(RecordInputStream recordInputStream) {
        byte[] bArr = new byte[4];
        recordInputStream.readPlain(bArr, 0, 4);
        this.field_1_position_of_BOF = LittleEndian.getInt(bArr);
        this.field_2_option_flags = recordInputStream.readUShort();
        int uByte = recordInputStream.readUByte();
        this.field_4_isMultibyteUnicode = recordInputStream.readByte();
        if (isMultibyte()) {
            this.field_5_sheetname = recordInputStream.readUnicodeLEString(uByte);
        } else {
            this.field_5_sheetname = recordInputStream.readCompressedUnicode(uByte);
        }
    }
}
