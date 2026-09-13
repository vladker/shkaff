package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NameCommentRecord extends StandardRecord {
    public static final short sid = 2196;
    private final short field_1_record_type;
    private final short field_2_frt_cell_ref_flag;
    private final long field_3_reserved;
    private String field_6_name_text;
    private String field_7_comment_text;

    public NameCommentRecord(NameCommentRecord nameCommentRecord) {
        this.field_1_record_type = nameCommentRecord.field_1_record_type;
        this.field_2_frt_cell_ref_flag = nameCommentRecord.field_2_frt_cell_ref_flag;
        this.field_3_reserved = nameCommentRecord.field_3_reserved;
        this.field_6_name_text = nameCommentRecord.field_6_name_text;
        this.field_7_comment_text = nameCommentRecord.field_7_comment_text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Short.valueOf(this.field_2_frt_cell_ref_flag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Long.valueOf(this.field_3_reserved);
    }

    public String getCommentText() {
        return this.field_7_comment_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (StringUtil.hasMultibyte(this.field_6_name_text) ? this.field_6_name_text.length() * 2 : this.field_6_name_text.length()) + 18 + (StringUtil.hasMultibyte(this.field_7_comment_text) ? this.field_7_comment_text.length() * 2 : this.field_7_comment_text.length());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.m0
            public final /* synthetic */ NameCommentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.getNameText();
                    default:
                        return this.b.getCommentText();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.m0
            public final /* synthetic */ NameCommentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.getNameText();
                    default:
                        return this.b.getCommentText();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.m0
            public final /* synthetic */ NameCommentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.getNameText();
                    default:
                        return this.b.getCommentText();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.m0
            public final /* synthetic */ NameCommentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.getNameText();
                    default:
                        return this.b.getCommentText();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("recordType", supplier, "frtCellRefFlag", supplier2, "reserved", supplier3, "name", supplier4, "comment", new Supplier(this) { // from class: org.apache.poi.hssf.record.m0
            public final /* synthetic */ NameCommentRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.getNameText();
                    default:
                        return this.b.getCommentText();
                }
            }
        });
    }

    public String getNameText() {
        return this.field_6_name_text;
    }

    public short getRecordType() {
        return this.field_1_record_type;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_6_name_text.length();
        int length2 = this.field_7_comment_text.length();
        littleEndianOutput.writeShort(this.field_1_record_type);
        littleEndianOutput.writeShort(this.field_2_frt_cell_ref_flag);
        littleEndianOutput.writeLong(this.field_3_reserved);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeShort(length2);
        boolean zHasMultibyte = StringUtil.hasMultibyte(this.field_6_name_text);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            StringUtil.putUnicodeLE(this.field_6_name_text, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(this.field_6_name_text, littleEndianOutput);
        }
        boolean zHasMultibyte2 = StringUtil.hasMultibyte(this.field_7_comment_text);
        littleEndianOutput.writeByte(zHasMultibyte2 ? 1 : 0);
        if (zHasMultibyte2) {
            StringUtil.putUnicodeLE(this.field_7_comment_text, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(this.field_7_comment_text, littleEndianOutput);
        }
    }

    public void setCommentText(String str) {
        this.field_7_comment_text = str;
    }

    public void setNameText(String str) {
        this.field_6_name_text = str;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NAME_COMMENT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public NameCommentRecord copy() {
        return new NameCommentRecord(this);
    }

    public NameCommentRecord(String str, String str2) {
        this.field_1_record_type = (short) 0;
        this.field_2_frt_cell_ref_flag = (short) 0;
        this.field_3_reserved = 0L;
        this.field_6_name_text = str;
        this.field_7_comment_text = str2;
    }

    public NameCommentRecord(RecordInputStream recordInputStream) {
        this.field_1_record_type = recordInputStream.readShort();
        this.field_2_frt_cell_ref_flag = recordInputStream.readShort();
        this.field_3_reserved = recordInputStream.readLong();
        short s6 = recordInputStream.readShort();
        short s7 = recordInputStream.readShort();
        if (recordInputStream.readByte() == 0) {
            this.field_6_name_text = StringUtil.readCompressedUnicode(recordInputStream, s6);
        } else {
            this.field_6_name_text = StringUtil.readUnicodeLE(recordInputStream, s6);
        }
        if (recordInputStream.readByte() == 0) {
            this.field_7_comment_text = StringUtil.readCompressedUnicode(recordInputStream, s7);
        } else {
            this.field_7_comment_text = StringUtil.readUnicodeLE(recordInputStream, s7);
        }
    }
}
