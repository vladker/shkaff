package org.apache.commons.compress.compressors.z;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZCompressorInputStream extends LZWInputStream {
    private static final int BLOCK_MODE_MASK = 128;
    private static final int MAGIC_1 = 31;
    private static final int MAGIC_2 = 157;
    private static final int MAX_CODE_SIZE_MASK = 31;
    private final boolean blockMode;
    private final int maxCodeSize;
    private long totalCodesRead;

    public ZCompressorInputStream(InputStream inputStream, int i5) throws IOException {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
        int bits = (int) this.in.readBits(8);
        int bits2 = (int) this.in.readBits(8);
        int bits3 = (int) this.in.readBits(8);
        if (bits != 31 || bits2 != 157 || bits3 < 0) {
            throw new IOException("Input is not in .Z format");
        }
        boolean z6 = (bits3 & 128) != 0;
        this.blockMode = z6;
        int i6 = bits3 & 31;
        this.maxCodeSize = i6;
        if (z6) {
            setClearCode(9);
        }
        initializeTables(i6, i5);
        clearEntries();
    }

    private void clearEntries() {
        setTableSize((this.blockMode ? 1 : 0) + 256);
    }

    public static boolean matches(byte[] bArr, int i5) {
        return i5 > 3 && bArr[0] == 31 && bArr[1] == -99;
    }

    private void reAlignReading() {
        long j6 = 8 - (this.totalCodesRead % 8);
        if (j6 == 8) {
            j6 = 0;
        }
        for (long j7 = 0; j7 < j6; j7++) {
            readNextCode();
        }
        this.in.clearBitCache();
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    public int addEntry(int i5, byte b) {
        int codeSize = 1 << getCodeSize();
        int iAddEntry = addEntry(i5, b, codeSize);
        if (getTableSize() == codeSize && getCodeSize() < this.maxCodeSize) {
            reAlignReading();
            incrementCodeSize();
        }
        return iAddEntry;
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    public int decompressNextSymbol() throws IOException {
        int nextCode = readNextCode();
        if (nextCode < 0) {
            return -1;
        }
        boolean z6 = false;
        if (this.blockMode && nextCode == getClearCode()) {
            clearEntries();
            reAlignReading();
            resetCodeSize();
            resetPreviousCode();
            return 0;
        }
        if (nextCode == getTableSize()) {
            addRepeatOfPreviousCode();
            z6 = true;
        } else if (nextCode > getTableSize()) {
            throw new IOException(String.format("Invalid %d bit code 0x%x", Integer.valueOf(getCodeSize()), Integer.valueOf(nextCode)));
        }
        return expandCodeToOutputStack(nextCode, z6);
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    public int readNextCode() {
        int nextCode = super.readNextCode();
        if (nextCode >= 0) {
            this.totalCodesRead++;
        }
        return nextCode;
    }

    public ZCompressorInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }
}
