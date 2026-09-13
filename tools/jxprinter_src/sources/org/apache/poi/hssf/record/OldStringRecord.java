package org.apache.poi.hssf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class OldStringRecord implements GenericRecord {
    public static final short biff2_sid = 7;
    public static final short biff345_sid = 519;
    private CodepageRecord codepage;
    private short field_1_string_len;
    private byte[] field_2_bytes;
    private short sid;

    public OldStringRecord(RecordInputStream recordInputStream) {
        this.sid = recordInputStream.getSid();
        if (recordInputStream.getSid() == 7) {
            this.field_1_string_len = (short) recordInputStream.readUByte();
        } else {
            this.field_1_string_len = recordInputStream.readShort();
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(this.field_1_string_len, HSSFWorkbook.getMaxRecordLength());
        this.field_2_bytes = bArrSafelyAllocate;
        recordInputStream.read(bArrSafelyAllocate, 0, this.field_1_string_len);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(TypedValues.Custom.S_STRING, new C1381b(this, 28));
    }

    public short getSid() {
        return this.sid;
    }

    public String getString() {
        return getString(this.field_2_bytes, this.codepage);
    }

    public boolean isBiff2() {
        return this.sid == 7;
    }

    public void setCodePage(CodepageRecord codepageRecord) {
        this.codepage = codepageRecord;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public static String getString(byte[] bArr, CodepageRecord codepageRecord) {
        try {
            return CodePageUtil.getStringFromCodePage(bArr, codepageRecord != null ? codepageRecord.getCodepage() & 65535 : 1252);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported codepage requested", e);
        }
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.STRING;
    }
}
