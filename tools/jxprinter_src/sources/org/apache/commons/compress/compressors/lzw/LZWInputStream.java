package org.apache.commons.compress.compressors.lzw;

import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LZWInputStream extends CompressorInputStream implements InputStreamStatistics {
    protected static final int DEFAULT_CODE_SIZE = 9;
    protected static final int UNUSED_PREFIX = -1;
    private byte[] characters;
    protected final BitInputStream in;
    private byte[] outputStack;
    private int outputStackLocation;
    private int[] prefixes;
    private byte previousCodeFirstChar;
    private int tableSize;
    private final byte[] oneByte = new byte[1];
    private int clearCode = -1;
    private int codeSize = 9;
    private int previousCode = -1;

    public LZWInputStream(InputStream inputStream, ByteOrder byteOrder) {
        this.in = new BitInputStream(inputStream, byteOrder);
    }

    private int readFromStack(byte[] bArr, int i5, int i6) {
        int length = this.outputStack.length - this.outputStackLocation;
        if (length <= 0) {
            return 0;
        }
        int iMin = Math.min(length, i6);
        System.arraycopy(this.outputStack, this.outputStackLocation, bArr, i5, iMin);
        this.outputStackLocation += iMin;
        return iMin;
    }

    public abstract int addEntry(int i5, byte b);

    public int addEntry(int i5, byte b, int i6) {
        int i7 = this.tableSize;
        if (i7 >= i6) {
            return -1;
        }
        this.prefixes[i7] = i5;
        this.characters[i7] = b;
        this.tableSize = i7 + 1;
        return i7;
    }

    public int addRepeatOfPreviousCode() throws IOException {
        int i5 = this.previousCode;
        if (i5 != -1) {
            return addEntry(i5, this.previousCodeFirstChar);
        }
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    public abstract int decompressNextSymbol();

    public int expandCodeToOutputStack(int i5, boolean z6) {
        int i6 = i5;
        while (i6 >= 0) {
            byte[] bArr = this.outputStack;
            int i7 = this.outputStackLocation - 1;
            this.outputStackLocation = i7;
            bArr[i7] = this.characters[i6];
            i6 = this.prefixes[i6];
        }
        int i8 = this.previousCode;
        if (i8 != -1 && !z6) {
            addEntry(i8, this.outputStack[this.outputStackLocation]);
        }
        this.previousCode = i5;
        byte[] bArr2 = this.outputStack;
        int i9 = this.outputStackLocation;
        this.previousCodeFirstChar = bArr2[i9];
        return i9;
    }

    public int getClearCode() {
        return this.clearCode;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    public int getPrefix(int i5) {
        return this.prefixes[i5];
    }

    public int getPrefixesLength() {
        return this.prefixes.length;
    }

    public int getTableSize() {
        return this.tableSize;
    }

    public void incrementCodeSize() {
        this.codeSize++;
    }

    public void initializeTables(int i5, int i6) throws MemoryLimitException {
        if (i5 <= 0) {
            throw new IllegalArgumentException(a.i(i5, "maxCodeSize is ", ", must be bigger than 0"));
        }
        if (i6 > -1) {
            long j6 = (((long) (1 << i5)) * 6) >> 10;
            if (j6 > i6) {
                throw new MemoryLimitException(j6, i6);
            }
        }
        initializeTables(i5);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i5 = read(this.oneByte);
        return i5 < 0 ? i5 : this.oneByte[0] & UnsignedBytes.MAX_VALUE;
    }

    public int readNextCode() {
        int i5 = this.codeSize;
        if (i5 <= 31) {
            return (int) this.in.readBits(i5);
        }
        throw new IllegalArgumentException("Code size must not be bigger than 31");
    }

    public void resetCodeSize() {
        setCodeSize(9);
    }

    public void resetPreviousCode() {
        this.previousCode = -1;
    }

    public void setClearCode(int i5) {
        this.clearCode = 1 << (i5 - 1);
    }

    public void setCodeSize(int i5) {
        this.codeSize = i5;
    }

    public void setPrefix(int i5, int i6) {
        this.prefixes[i5] = i6;
    }

    public void setTableSize(int i5) {
        this.tableSize = i5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        int fromStack = readFromStack(bArr, i5, i6);
        while (true) {
            int i7 = i6 - fromStack;
            if (i7 > 0) {
                int iDecompressNextSymbol = decompressNextSymbol();
                if (iDecompressNextSymbol < 0) {
                    if (fromStack <= 0) {
                        return iDecompressNextSymbol;
                    }
                    count(fromStack);
                    return fromStack;
                }
                fromStack += readFromStack(bArr, i5 + fromStack, i7);
            } else {
                count(fromStack);
                return fromStack;
            }
        }
    }

    public void initializeTables(int i5) {
        if (i5 > 0) {
            int i6 = 1 << i5;
            this.prefixes = new int[i6];
            this.characters = new byte[i6];
            this.outputStack = new byte[i6];
            this.outputStackLocation = i6;
            for (int i7 = 0; i7 < 256; i7++) {
                this.prefixes[i7] = -1;
                this.characters[i7] = (byte) i7;
            }
            return;
        }
        throw new IllegalArgumentException(a.i(i5, "maxCodeSize is ", ", must be bigger than 0"));
    }
}
