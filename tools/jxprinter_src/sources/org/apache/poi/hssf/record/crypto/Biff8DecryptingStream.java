package org.apache.poi.hssf.record.crypto;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.io.PushbackInputStream;
import org.apache.poi.hssf.record.BiffHeaderInput;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.SuppressForbidden;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Biff8DecryptingStream implements BiffHeaderInput, LittleEndianInput {
    public static final int RC4_REKEYING_INTERVAL = 1024;
    private final byte[] buffer = new byte[8];
    private final ChunkedCipherInputStream ccis;
    private boolean shouldSkipEncryptionOnCurrentRecord;

    public Biff8DecryptingStream(InputStream inputStream, int i5, EncryptionInfo encryptionInfo) {
        try {
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, HSSFWorkbook.getMaxRecordLength());
            if (i5 != 0) {
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, i5);
                pushbackInputStream.unread(bArrSafelyAllocate);
                inputStream = pushbackInputStream;
            }
            Decryptor decryptor = encryptionInfo.getDecryptor();
            decryptor.setChunkSize(1024);
            ChunkedCipherInputStream chunkedCipherInputStream = (ChunkedCipherInputStream) decryptor.getDataStream(inputStream, Integer.MAX_VALUE, 0);
            this.ccis = chunkedCipherInputStream;
            if (i5 > 0) {
                chunkedCipherInputStream.readFully(bArrSafelyAllocate);
            }
        } catch (Exception e) {
            throw new RecordFormatException(e);
        }
    }

    public static boolean isNeverEncryptedRecord(int i5) {
        return i5 == 47 || i5 == 225 || i5 == 2057;
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    @SuppressForbidden("just delegating")
    public int available() {
        return this.ccis.available();
    }

    public long getPosition() {
        return this.ccis.getPos();
    }

    @Internal
    public boolean isCurrentRecordEncrypted() {
        return !this.shouldSkipEncryptionOnCurrentRecord;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        if (!this.shouldSkipEncryptionOnCurrentRecord) {
            return this.ccis.readByte();
        }
        readPlain(this.buffer, 0, 1);
        return this.buffer[0];
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readDataSize() {
        readPlain(this.buffer, 0, 2);
        int uShort = LittleEndian.getUShort(this.buffer, 0);
        this.ccis.setNextRecordSize(uShort);
        return uShort;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        double dLongBitsToDouble = Double.longBitsToDouble(readLong());
        if (Double.isNaN(dLongBitsToDouble)) {
            throw new RuntimeException("Did not expect to read NaN");
        }
        return dLongBitsToDouble;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        if (!this.shouldSkipEncryptionOnCurrentRecord) {
            return this.ccis.readInt();
        }
        readPlain(this.buffer, 0, 4);
        return LittleEndian.getInt(this.buffer);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        if (!this.shouldSkipEncryptionOnCurrentRecord) {
            return this.ccis.readLong();
        }
        readPlain(this.buffer, 0, 8);
        return LittleEndian.getLong(this.buffer);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i5, int i6) {
        this.ccis.readPlain(bArr, i5, i6);
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readRecordSID() {
        readPlain(this.buffer, 0, 2);
        int uShort = LittleEndian.getUShort(this.buffer, 0);
        this.shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(uShort);
        return uShort;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        if (!this.shouldSkipEncryptionOnCurrentRecord) {
            return this.ccis.readShort();
        }
        readPlain(this.buffer, 0, 2);
        return LittleEndian.getShort(this.buffer);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & UnsignedBytes.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & 65535;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i5, int i6) {
        if (this.shouldSkipEncryptionOnCurrentRecord) {
            readPlain(bArr, i5, bArr.length);
        } else {
            this.ccis.readFully(bArr, i5, i6);
        }
    }
}
