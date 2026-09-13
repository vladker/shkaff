package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StyleRecord extends StandardRecord {
    public static final short sid = 659;
    private int field_1_xf_index;
    private int field_2_builtin_style;
    private int field_3_outline_style_level;
    private boolean field_3_stringHasMultibyte;
    private String field_4_name;
    private static final BitField styleIndexMask = BitFieldFactory.getInstance(4095);
    private static final BitField isBuiltinFlag = BitFieldFactory.getInstance(32768);

    public StyleRecord() {
        this.field_1_xf_index = isBuiltinFlag.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return isBuiltin() ? "built-in" : "user-defined";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.field_2_builtin_style);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this.field_3_outline_style_level);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if (isBuiltin()) {
            return 4;
        }
        return (this.field_4_name.length() * (this.field_3_stringHasMultibyte ? 2 : 1)) + 5;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.O0
            public final /* synthetic */ StyleRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getXFIndex());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getName();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.O0
            public final /* synthetic */ StyleRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getXFIndex());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getName();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.O0
            public final /* synthetic */ StyleRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getXFIndex());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getName();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.O0
            public final /* synthetic */ StyleRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getXFIndex());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getName();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("xfIndex", supplier, "type", supplier2, "builtin_style", supplier3, "outline_level", supplier4, "name", new Supplier(this) { // from class: org.apache.poi.hssf.record.O0
            public final /* synthetic */ StyleRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getXFIndex());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getName();
                }
            }
        });
    }

    public String getName() {
        return this.field_4_name;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public int getXFIndex() {
        return styleIndexMask.getValue(this.field_1_xf_index);
    }

    public boolean isBuiltin() {
        return isBuiltinFlag.isSet(this.field_1_xf_index);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_xf_index);
        if (isBuiltin()) {
            littleEndianOutput.writeByte(this.field_2_builtin_style);
            littleEndianOutput.writeByte(this.field_3_outline_style_level);
            return;
        }
        littleEndianOutput.writeShort(this.field_4_name.length());
        littleEndianOutput.writeByte(this.field_3_stringHasMultibyte ? 1 : 0);
        if (this.field_3_stringHasMultibyte) {
            StringUtil.putUnicodeLE(getName(), littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(getName(), littleEndianOutput);
        }
    }

    public void setBuiltinStyle(int i5) {
        this.field_1_xf_index = isBuiltinFlag.set(this.field_1_xf_index);
        this.field_2_builtin_style = i5;
    }

    public void setName(String str) {
        this.field_4_name = str;
        this.field_3_stringHasMultibyte = StringUtil.hasMultibyte(str);
        this.field_1_xf_index = isBuiltinFlag.clear(this.field_1_xf_index);
    }

    public void setOutlineStyleLevel(int i5) {
        this.field_3_outline_style_level = i5 & 255;
    }

    public void setXFIndex(int i5) {
        this.field_1_xf_index = styleIndexMask.setValue(this.field_1_xf_index, i5);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.STYLE;
    }

    public StyleRecord(StyleRecord styleRecord) {
        super(styleRecord);
        this.field_1_xf_index = styleRecord.field_1_xf_index;
        this.field_2_builtin_style = styleRecord.field_2_builtin_style;
        this.field_3_outline_style_level = styleRecord.field_3_outline_style_level;
        this.field_3_stringHasMultibyte = styleRecord.field_3_stringHasMultibyte;
        this.field_4_name = styleRecord.field_4_name;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public StyleRecord copy() {
        return new StyleRecord(this);
    }

    public StyleRecord(RecordInputStream recordInputStream) {
        this.field_1_xf_index = recordInputStream.readShort();
        if (isBuiltin()) {
            this.field_2_builtin_style = recordInputStream.readByte();
            this.field_3_outline_style_level = recordInputStream.readByte();
            return;
        }
        short s6 = recordInputStream.readShort();
        if (recordInputStream.remaining() < 1) {
            if (s6 == 0) {
                this.field_4_name = "";
                return;
            }
            throw new RecordFormatException("Ran out of data reading style record");
        }
        boolean z6 = recordInputStream.readByte() != 0;
        this.field_3_stringHasMultibyte = z6;
        if (z6) {
            this.field_4_name = StringUtil.readUnicodeLE(recordInputStream, s6);
        } else {
            this.field_4_name = StringUtil.readCompressedUnicode(recordInputStream, s6);
        }
    }
}
