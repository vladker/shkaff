package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class UnshrinkingInputStream extends LZWInputStream {
    private static final int MAX_CODE_SIZE = 13;
    private static final int MAX_TABLE_SIZE = 8192;
    private final boolean[] isUsed;

    public UnshrinkingInputStream(InputStream inputStream) {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
        setClearCode(9);
        initializeTables(13);
        this.isUsed = new boolean[getPrefixesLength()];
        for (int i5 = 0; i5 < 256; i5++) {
            this.isUsed[i5] = true;
        }
        setTableSize(getClearCode() + 1);
    }

    private void partialClear() {
        boolean[] zArr = new boolean[8192];
        int i5 = 0;
        while (true) {
            boolean[] zArr2 = this.isUsed;
            if (i5 >= zArr2.length) {
                break;
            }
            if (zArr2[i5] && getPrefix(i5) != -1) {
                zArr[getPrefix(i5)] = true;
            }
            i5++;
        }
        for (int clearCode = getClearCode() + 1; clearCode < 8192; clearCode++) {
            if (!zArr[clearCode]) {
                this.isUsed[clearCode] = false;
                setPrefix(clearCode, -1);
            }
        }
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    public int addEntry(int i5, byte b) {
        int tableSize = getTableSize();
        while (tableSize < 8192 && this.isUsed[tableSize]) {
            tableSize++;
        }
        setTableSize(tableSize);
        int iAddEntry = addEntry(i5, b, 8192);
        if (iAddEntry >= 0) {
            this.isUsed[iAddEntry] = true;
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
        if (nextCode != getClearCode()) {
            if (!this.isUsed[nextCode]) {
                nextCode = addRepeatOfPreviousCode();
                z6 = true;
            }
            return expandCodeToOutputStack(nextCode, z6);
        }
        int nextCode2 = readNextCode();
        if (nextCode2 < 0) {
            throw new IOException("Unexpected EOF;");
        }
        if (nextCode2 == 1) {
            if (getCodeSize() >= 13) {
                throw new IOException("Attempt to increase code size beyond maximum");
            }
            incrementCodeSize();
        } else {
            if (nextCode2 != 2) {
                throw new IOException(AbstractC0157z.k(nextCode2, "Invalid clear code subcode "));
            }
            partialClear();
            setTableSize(getClearCode() + 1);
        }
        return 0;
    }
}
