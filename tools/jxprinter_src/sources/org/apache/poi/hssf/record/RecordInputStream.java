package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RecordInputStream implements LittleEndianInput {
    private static final int DATA_LEN_NEEDS_TO_BE_READ = -1;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int INVALID_SID_VALUE = -1;
    public static final short MAX_RECORD_DATA_SIZE = 8224;
    private final BiffHeaderInput _bhi;
    private int _currentDataLength;
    private int _currentDataOffset;
    private int _currentSid;
    private final LittleEndianInput _dataInput;
    private int _markedDataOffset;
    private int _nextSid;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LeftoverDataException extends RuntimeException {
        public LeftoverDataException(int i5, int i6) {
            super("Initialisation of record 0x" + Integer.toHexString(i5).toUpperCase(Locale.ROOT) + "(" + getRecordName(i5) + ") left " + i6 + " bytes remaining still to be read.");
        }

        private static String getRecordName(int i5) {
            Class<? extends Record> recordClass = RecordFactory.getRecordClass(i5);
            if (recordClass == null) {
                return null;
            }
            return recordClass.getSimpleName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SimpleHeaderInput implements BiffHeaderInput {
        private final LittleEndianInput _lei;

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int available() {
            return this._lei.available();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readDataSize() {
            return this._lei.readUShort();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readRecordSID() {
            return this._lei.readUShort();
        }

        private SimpleHeaderInput(LittleEndianInput littleEndianInput) {
            this._lei = littleEndianInput;
        }
    }

    public RecordInputStream(InputStream inputStream) {
        this(inputStream, null, 0);
    }

    private void checkRecordPosition(int i5) {
        int iRemaining = remaining();
        if (iRemaining >= i5) {
            return;
        }
        if (iRemaining != 0 || !isContinueNext()) {
            throw new RecordFormatException(androidx.collection.a.m("Not enough data (", iRemaining, i5, ") to read requested (", ") bytes"));
        }
        nextRecord();
    }

    private boolean isContinueNext() {
        int i5 = this._currentDataLength;
        if (i5 == -1 || this._currentDataOffset == i5) {
            return hasNextRecord() && this._nextSid == 60;
        }
        throw new IllegalStateException("Should never be called before end of current record");
    }

    private int readNextSid() {
        if (this._bhi.available() < 4) {
            return -1;
        }
        int recordSID = this._bhi.readRecordSID();
        if (recordSID == -1) {
            throw new RecordFormatException(androidx.collection.a.i(recordSID, "Found invalid sid (", ")"));
        }
        this._currentDataLength = -1;
        return recordSID;
    }

    private String readStringCommon(int i5, boolean z6) {
        if (i5 < 0 || i5 > 1048576) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Bad requested string length (", ")"));
        }
        char[] cArr = new char[i5];
        int i6 = 0;
        while (true) {
            int iRemaining = remaining();
            if (!z6) {
                iRemaining /= 2;
            }
            if (i5 - i6 <= iRemaining) {
                while (i6 < i5) {
                    cArr[i6] = (char) (z6 ? readUByte() : readShort());
                    i6++;
                }
                return new String(cArr);
            }
            while (iRemaining > 0) {
                cArr[i6] = (char) (z6 ? readUByte() : readShort());
                i6++;
                iRemaining--;
            }
            if (!isContinueNext()) {
                throw new RecordFormatException("Expected to find a ContinueRecord in order to read remaining " + (i5 - i6) + " of " + i5 + " chars");
            }
            if (remaining() != 0) {
                throw new RecordFormatException("Odd number of bytes(" + remaining() + ") left behind");
            }
            nextRecord();
            byte b = readByte();
            if (b != 0 && b != 1) {
                throw new RecordFormatException(AbstractC0157z.k(b, "Invalid compressFlag: "));
            }
            z6 = b == 0;
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return remaining();
    }

    public int getNextSid() {
        return this._nextSid;
    }

    public short getSid() {
        return (short) this._currentSid;
    }

    public boolean hasNextRecord() {
        int i5 = this._currentDataLength;
        if (i5 != -1 && i5 != this._currentDataOffset) {
            throw new LeftoverDataException(this._currentSid, remaining());
        }
        if (i5 != -1) {
            this._nextSid = readNextSid();
        }
        return this._nextSid != -1;
    }

    @Internal
    public boolean isEncrypted() {
        LittleEndianInput littleEndianInput = this._dataInput;
        return (littleEndianInput instanceof Biff8DecryptingStream) && ((Biff8DecryptingStream) littleEndianInput).isCurrentRecordEncrypted();
    }

    @Internal
    public void mark(int i5) {
        ((InputStream) this._dataInput).mark(i5);
        this._markedDataOffset = this._currentDataOffset;
    }

    public void nextRecord() {
        int i5 = this._nextSid;
        if (i5 == -1) {
            throw new IllegalStateException("EOF - next record not available");
        }
        if (this._currentDataLength != -1) {
            throw new IllegalStateException("Cannot call nextRecord() without checking hasNextRecord() first");
        }
        this._currentSid = i5;
        this._currentDataOffset = 0;
        int dataSize = this._bhi.readDataSize();
        this._currentDataLength = dataSize;
        if (dataSize > 8224) {
            throw new RecordFormatException("The content of an excel record cannot exceed 8224 bytes");
        }
    }

    public int read(byte[] bArr, int i5, int i6) {
        int iMin = Math.min(i6, remaining());
        if (iMin == 0) {
            return 0;
        }
        readFully(bArr, i5, iMin);
        return iMin;
    }

    @Deprecated
    public byte[] readAllContinuedRemainder() {
        try {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(16448);
            while (true) {
                try {
                    byte[] remainder = readRemainder();
                    unsynchronizedByteArrayOutputStream.write(remainder, 0, remainder.length);
                    if (!isContinueNext()) {
                        byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                        unsynchronizedByteArrayOutputStream.close();
                        return byteArray;
                    }
                    nextRecord();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            unsynchronizedByteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                throw new RecordFormatException(e);
            }
        } catch (IOException e) {
            throw new RecordFormatException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkRecordPosition(1);
        this._currentDataOffset++;
        return this._dataInput.readByte();
    }

    public String readCompressedUnicode(int i5) {
        return readStringCommon(i5, true);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length, false);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkRecordPosition(4);
        this._currentDataOffset += 4;
        return this._dataInput.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkRecordPosition(8);
        this._currentDataOffset += 8;
        return this._dataInput.readLong();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i5, int i6) {
        readFully(bArr, 0, bArr.length, true);
    }

    public byte[] readRemainder() {
        int iRemaining = remaining();
        if (iRemaining == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(iRemaining, HSSFWorkbook.getMaxRecordLength());
        readFully(bArrSafelyAllocate);
        return bArrSafelyAllocate;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readShort();
    }

    public String readString() {
        return readStringCommon(readUShort(), readByte() == 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & UnsignedBytes.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readUShort();
    }

    public String readUnicodeLEString(int i5) {
        return readStringCommon(i5, false);
    }

    public int remaining() {
        int i5 = this._currentDataLength;
        if (i5 == -1) {
            return 0;
        }
        return i5 - this._currentDataOffset;
    }

    @Internal
    public void reset() throws IOException {
        ((InputStream) this._dataInput).reset();
        this._currentDataOffset = this._markedDataOffset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordInputStream(InputStream inputStream, EncryptionInfo encryptionInfo, int i5) {
        if (encryptionInfo == null) {
            LittleEndianInput littleEndianInputStream = inputStream instanceof LittleEndianInput ? (LittleEndianInput) inputStream : new LittleEndianInputStream(inputStream);
            this._dataInput = littleEndianInputStream;
            this._bhi = new SimpleHeaderInput(littleEndianInputStream);
        } else {
            Biff8DecryptingStream biff8DecryptingStream = new Biff8DecryptingStream(inputStream, i5, encryptionInfo);
            this._dataInput = biff8DecryptingStream;
            this._bhi = biff8DecryptingStream;
        }
        this._nextSid = readNextSid();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i5, int i6) {
        readFully(bArr, i5, i6, false);
    }

    private void readFully(byte[] bArr, int i5, int i6, boolean z6) {
        bArr.getClass();
        if (i5 < 0 || i6 < 0 || i6 > bArr.length - i5) {
            throw new IndexOutOfBoundsException();
        }
        int i7 = i6;
        while (i7 > 0) {
            int iMin = Math.min(available(), i7);
            if (iMin == 0) {
                if (hasNextRecord()) {
                    nextRecord();
                    iMin = Math.min(available(), i7);
                    if (iMin <= 0) {
                        StringBuilder sbS = androidx.collection.a.s("Need to have a valid next chunk, but had: ", iMin, i7, " with len: ", " and available: ");
                        sbS.append(available());
                        throw new RecordFormatException(sbS.toString());
                    }
                } else {
                    throw new RecordFormatException(androidx.collection.a.m("Can't read the remaining ", i7, i6, " bytes of the requested ", " bytes. No further record exists."));
                }
            }
            checkRecordPosition(iMin);
            if (z6) {
                this._dataInput.readPlain(bArr, i5, iMin);
            } else {
                this._dataInput.readFully(bArr, i5, iMin);
            }
            this._currentDataOffset += iMin;
            i5 += iMin;
            i7 -= iMin;
        }
    }
}
