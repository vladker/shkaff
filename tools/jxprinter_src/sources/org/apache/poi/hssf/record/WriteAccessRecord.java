package org.apache.poi.hssf.record;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WriteAccessRecord extends StandardRecord {
    private static final int DATA_SIZE = 112;
    private static final byte[] PADDING;
    private static final byte PAD_CHAR = 32;
    private static final int STRING_SIZE = 109;
    private static final BitField UTF16FLAG = BitFieldFactory.getInstance(1);
    public static final short sid = 92;
    private String field_1_username;

    static {
        byte[] bArr = new byte[109];
        PADDING = bArr;
        Arrays.fill(bArr, (byte) 32);
    }

    public WriteAccessRecord() {
        setUsername("");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 112;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("username", new A0(this, 16));
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 92;
    }

    public String getUsername() {
        return this.field_1_username;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String username = getUsername();
        boolean zHasMultibyte = StringUtil.hasMultibyte(username);
        littleEndianOutput.writeShort(username.length());
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        byte[] bArr = (byte[]) PADDING.clone();
        if (zHasMultibyte) {
            StringUtil.putUnicodeLE(username, bArr, 0);
        } else {
            StringUtil.putCompressedUnicode(username, bArr, 0);
        }
        littleEndianOutput.write(bArr);
    }

    public void setUsername(String str) {
        if (str.length() * (StringUtil.hasMultibyte(str) ? 2 : 1) > 109) {
            throw new IllegalArgumentException("Name is too long: ".concat(str));
        }
        this.field_1_username = str;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WRITE_ACCESS;
    }

    public WriteAccessRecord(WriteAccessRecord writeAccessRecord) {
        super(writeAccessRecord);
        this.field_1_username = writeAccessRecord.field_1_username;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public WriteAccessRecord copy() {
        return new WriteAccessRecord(this);
    }

    public WriteAccessRecord(RecordInputStream recordInputStream) {
        byte[] bArrSafelyAllocate;
        Charset charset;
        int length;
        if (recordInputStream.remaining() <= 112) {
            int uShort = recordInputStream.readUShort();
            int uByte = recordInputStream.readUByte();
            if (uShort <= 109 && (uByte & 254) == 0) {
                bArrSafelyAllocate = IOUtils.safelyAllocate(recordInputStream.remaining(), 109);
                recordInputStream.readFully(bArrSafelyAllocate);
                if (UTF16FLAG.isSet(uByte)) {
                    length = Math.min(uShort * 2, bArrSafelyAllocate.length);
                    charset = StandardCharsets.UTF_16LE;
                } else {
                    length = Math.min(uShort, bArrSafelyAllocate.length);
                    charset = StandardCharsets.ISO_8859_1;
                }
            } else if (recordInputStream.isEncrypted()) {
                bArrSafelyAllocate = IOUtils.safelyAllocate(recordInputStream.remaining(), 109);
                recordInputStream.readPlain(bArrSafelyAllocate, 0, bArrSafelyAllocate.length);
                length = bArrSafelyAllocate.length;
                while (length > 0 && bArrSafelyAllocate[length - 1] == 32) {
                    length--;
                }
                charset = (bArrSafelyAllocate.length <= 1 || bArrSafelyAllocate[1] != 0) ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_16LE;
            } else {
                int iRemaining = recordInputStream.remaining();
                int i5 = iRemaining + 3;
                bArrSafelyAllocate = IOUtils.safelyAllocate(i5, 112);
                LittleEndian.putUShort(bArrSafelyAllocate, 0, uShort);
                LittleEndian.putByte(bArrSafelyAllocate, 2, uByte);
                recordInputStream.readFully(bArrSafelyAllocate, 3, iRemaining);
                charset = StandardCharsets.UTF_8;
                length = i5;
            }
            setUsername(new String(bArrSafelyAllocate, 0, length, charset).trim());
            return;
        }
        throw new RecordFormatException("Expected data size (112) but got (" + recordInputStream.remaining() + ")");
    }
}
