package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.utils.BitInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BitStream extends BitInputStream {
    public BitStream(InputStream inputStream) {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
    }

    public int nextBit() {
        return (int) readBits(1);
    }

    public long nextBits(int i5) throws IOException {
        if (i5 < 0 || i5 > 8) {
            throw new IOException(androidx.collection.a.i(i5, "Trying to read ", " bits, at most 8 are allowed"));
        }
        return readBits(i5);
    }

    public int nextByte() {
        return (int) readBits(8);
    }
}
