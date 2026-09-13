package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FormatRecord extends StandardRecord {
    private static final Logger LOG = LogManager.getLogger((Class<?>) FormatRecord.class);
    public static final short sid = 1054;
    private final int field_1_index_code;
    private final boolean field_3_hasMultibyte;
    private final String field_4_formatstring;

    private FormatRecord(FormatRecord formatRecord) {
        super(formatRecord);
        this.field_1_index_code = formatRecord.field_1_index_code;
        this.field_3_hasMultibyte = formatRecord.field_3_hasMultibyte;
        this.field_4_formatstring = formatRecord.field_4_formatstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Boolean.valueOf(this.field_3_hasMultibyte);
    }

    private static String readStringCommon(RecordInputStream recordInputStream, int i5, boolean z6) {
        if (i5 < 0 || i5 > 1048576) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Bad requested string length (", ")"));
        }
        int iRemaining = recordInputStream.remaining();
        if (!z6) {
            iRemaining /= 2;
        }
        char[] cArr = i5 == iRemaining ? new char[i5] : new char[iRemaining];
        for (int i6 = 0; i6 < cArr.length; i6++) {
            cArr[i6] = (char) (z6 ? recordInputStream.readUByte() : recordInputStream.readShort());
        }
        if (recordInputStream.available() == 1) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length + 1);
            cArrCopyOf[cArr.length] = (char) recordInputStream.readUByte();
            cArr = cArrCopyOf;
        }
        if (recordInputStream.available() > 0) {
            LOG.atInfo().log("FormatRecord has {} unexplained bytes. Silently skipping", Unbox.box(recordInputStream.available()));
            while (recordInputStream.available() > 0) {
                recordInputStream.readByte();
            }
        }
        return new String(cArr);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (getFormatString().length() * (this.field_3_hasMultibyte ? 2 : 1)) + 5;
    }

    public String getFormatString() {
        return this.field_4_formatstring;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.Q
            public final /* synthetic */ FormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getIndexCode());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getFormatString();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.Q
            public final /* synthetic */ FormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getIndexCode());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getFormatString();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("indexCode", supplier, "unicode", supplier2, "formatString", new Supplier(this) { // from class: org.apache.poi.hssf.record.Q
            public final /* synthetic */ FormatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getIndexCode());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getFormatString();
                }
            }
        });
    }

    public int getIndexCode() {
        return this.field_1_index_code;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String formatString = getFormatString();
        littleEndianOutput.writeShort(getIndexCode());
        littleEndianOutput.writeShort(formatString.length());
        littleEndianOutput.writeByte(this.field_3_hasMultibyte ? 1 : 0);
        if (this.field_3_hasMultibyte) {
            StringUtil.putUnicodeLE(formatString, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(formatString, littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FORMAT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FormatRecord copy() {
        return new FormatRecord(this);
    }

    public FormatRecord(int i5, String str) {
        this.field_1_index_code = i5;
        this.field_4_formatstring = str;
        this.field_3_hasMultibyte = StringUtil.hasMultibyte(str);
    }

    public FormatRecord(RecordInputStream recordInputStream) {
        this.field_1_index_code = recordInputStream.readShort();
        int uShort = recordInputStream.readUShort();
        boolean z6 = (recordInputStream.readByte() & 1) != 0;
        this.field_3_hasMultibyte = z6;
        if (z6) {
            this.field_4_formatstring = readStringCommon(recordInputStream, uShort, false);
        } else {
            this.field_4_formatstring = readStringCommon(recordInputStream, uShort, true);
        }
    }
}
