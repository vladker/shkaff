package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FileSharingRecord extends StandardRecord {
    public static final short sid = 91;
    private short field_1_readonly;
    private short field_2_password;
    private byte field_3_username_unicode_options;
    private String field_3_username_value;

    public FileSharingRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int length = this.field_3_username_value.length();
        if (length < 1) {
            return 6;
        }
        return length + 7;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.O
            public final /* synthetic */ FileSharingRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getReadOnly());
                    case 1:
                        return Short.valueOf(this.b.getPassword());
                    default:
                        return this.b.getUsername();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.O
            public final /* synthetic */ FileSharingRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getReadOnly());
                    case 1:
                        return Short.valueOf(this.b.getPassword());
                    default:
                        return this.b.getUsername();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("readOnly", supplier, "password", supplier2, "username", new Supplier(this) { // from class: org.apache.poi.hssf.record.O
            public final /* synthetic */ FileSharingRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getReadOnly());
                    case 1:
                        return Short.valueOf(this.b.getPassword());
                    default:
                        return this.b.getUsername();
                }
            }
        });
    }

    public short getPassword() {
        return this.field_2_password;
    }

    public short getReadOnly() {
        return this.field_1_readonly;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 91;
    }

    public String getUsername() {
        return this.field_3_username_value;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getReadOnly());
        littleEndianOutput.writeShort(getPassword());
        littleEndianOutput.writeShort(this.field_3_username_value.length());
        if (this.field_3_username_value.length() > 0) {
            littleEndianOutput.writeByte(this.field_3_username_unicode_options);
            StringUtil.putCompressedUnicode(getUsername(), littleEndianOutput);
        }
    }

    public void setPassword(short s6) {
        this.field_2_password = s6;
    }

    public void setReadOnly(short s6) {
        this.field_1_readonly = s6;
    }

    public void setUsername(String str) {
        this.field_3_username_value = str;
    }

    public FileSharingRecord(FileSharingRecord fileSharingRecord) {
        super(fileSharingRecord);
        this.field_1_readonly = fileSharingRecord.field_1_readonly;
        this.field_2_password = fileSharingRecord.field_2_password;
        this.field_3_username_unicode_options = fileSharingRecord.field_3_username_unicode_options;
        this.field_3_username_value = fileSharingRecord.field_3_username_value;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FILE_SHARING;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FileSharingRecord copy() {
        return new FileSharingRecord(this);
    }

    public FileSharingRecord(RecordInputStream recordInputStream) {
        this.field_1_readonly = recordInputStream.readShort();
        this.field_2_password = recordInputStream.readShort();
        short s6 = recordInputStream.readShort();
        if (s6 > 0) {
            this.field_3_username_unicode_options = recordInputStream.readByte();
            this.field_3_username_value = recordInputStream.readCompressedUnicode(s6);
        } else {
            this.field_3_username_value = "";
        }
    }
}
