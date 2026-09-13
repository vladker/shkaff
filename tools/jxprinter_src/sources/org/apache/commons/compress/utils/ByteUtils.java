package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ByteConsumer {
        void accept(int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ByteSupplier {
        int getAsByte();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InputStreamByteSupplier implements ByteSupplier {
        private final InputStream is;

        public InputStreamByteSupplier(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // org.apache.commons.compress.utils.ByteUtils.ByteSupplier
        public int getAsByte() {
            return this.is.read();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class OutputStreamByteConsumer implements ByteConsumer {
        private final OutputStream os;

        public OutputStreamByteConsumer(OutputStream outputStream) {
            this.os = outputStream;
        }

        @Override // org.apache.commons.compress.utils.ByteUtils.ByteConsumer
        public void accept(int i5) throws IOException {
            this.os.write(i5);
        }
    }

    private ByteUtils() {
    }

    private static void checkReadLength(int i5) {
        if (i5 > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }

    public static long fromLittleEndian(byte[] bArr) {
        return fromLittleEndian(bArr, 0, bArr.length);
    }

    public static void toLittleEndian(byte[] bArr, long j6, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[i5 + i7] = (byte) (255 & j6);
            j6 >>= 8;
        }
    }

    public static long fromLittleEndian(byte[] bArr, int i5, int i6) {
        checkReadLength(i6);
        long j6 = 0;
        for (int i7 = 0; i7 < i6; i7++) {
            j6 |= (((long) bArr[i5 + i7]) & 255) << (i7 * 8);
        }
        return j6;
    }

    public static void toLittleEndian(OutputStream outputStream, long j6, int i5) throws IOException {
        for (int i6 = 0; i6 < i5; i6++) {
            outputStream.write((int) (255 & j6));
            j6 >>= 8;
        }
    }

    public static void toLittleEndian(ByteConsumer byteConsumer, long j6, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            byteConsumer.accept((int) (255 & j6));
            j6 >>= 8;
        }
    }

    public static long fromLittleEndian(InputStream inputStream, int i5) throws IOException {
        checkReadLength(i5);
        long j6 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            long j7 = inputStream.read();
            if (j7 == -1) {
                throw new IOException("Premature end of data");
            }
            j6 |= j7 << (i6 * 8);
        }
        return j6;
    }

    public static void toLittleEndian(DataOutput dataOutput, long j6, int i5) throws IOException {
        for (int i6 = 0; i6 < i5; i6++) {
            dataOutput.write((int) (255 & j6));
            j6 >>= 8;
        }
    }

    public static long fromLittleEndian(ByteSupplier byteSupplier, int i5) throws IOException {
        checkReadLength(i5);
        long j6 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            long asByte = byteSupplier.getAsByte();
            if (asByte == -1) {
                throw new IOException("Premature end of data");
            }
            j6 |= asByte << (i6 * 8);
        }
        return j6;
    }

    public static long fromLittleEndian(DataInput dataInput, int i5) {
        checkReadLength(i5);
        long unsignedByte = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            unsignedByte |= ((long) dataInput.readUnsignedByte()) << (i6 * 8);
        }
        return unsignedByte;
    }
}
