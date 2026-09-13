package org.apache.poi.util;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class LittleEndian implements LittleEndianConsts {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BufferUnderrunException extends IOException {
        private static final long serialVersionUID = 8736973884877006145L;

        public BufferUnderrunException() {
            super("buffer underrun");
        }
    }

    private LittleEndian() {
    }

    public static double getDouble(byte[] bArr) {
        return Double.longBitsToDouble(getLong(bArr, 0));
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 0);
    }

    public static int getInt(byte[] bArr) {
        return getInt(bArr, 0);
    }

    public static long getLong(byte[] bArr) {
        return getLong(bArr, 0);
    }

    public static short getShort(byte[] bArr) {
        return getShort(bArr, 0);
    }

    public static short[] getShortArray(byte[] bArr, int i5, int i6) {
        int i7 = i6 / 2;
        short[] sArr = new short[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            sArr[i8] = getShort(bArr, (i8 * 2) + i5);
        }
        return sArr;
    }

    public static short getUByte(byte[] bArr) {
        return (short) (bArr[0] & UnsignedBytes.MAX_VALUE);
    }

    public static long getUInt(byte[] bArr) {
        return getUInt(bArr, 0);
    }

    public static int getUShort(byte[] bArr) {
        return getUShort(bArr, 0);
    }

    public static void putByte(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) i6;
    }

    public static void putDouble(byte[] bArr, int i5, double d) {
        putLong(bArr, i5, Double.doubleToLongBits(d));
    }

    public static void putFloat(byte[] bArr, int i5, float f6) {
        putInt(bArr, i5, Float.floatToIntBits(f6));
    }

    public static void putInt(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >>> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >>> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >>> 24) & 255);
    }

    public static void putLong(byte[] bArr, int i5, long j6) {
        bArr[i5] = (byte) (j6 & 255);
        bArr[i5 + 1] = (byte) ((j6 >>> 8) & 255);
        bArr[i5 + 2] = (byte) ((j6 >>> 16) & 255);
        bArr[i5 + 3] = (byte) ((j6 >>> 24) & 255);
        bArr[i5 + 4] = (byte) ((j6 >>> 32) & 255);
        bArr[i5 + 5] = (byte) ((j6 >>> 40) & 255);
        bArr[i5 + 6] = (byte) ((j6 >>> 48) & 255);
        bArr[i5 + 7] = (byte) ((j6 >>> 56) & 255);
    }

    public static void putShort(byte[] bArr, int i5, short s6) {
        bArr[i5] = (byte) (s6 & 255);
        bArr[i5 + 1] = (byte) ((s6 >>> 8) & 255);
    }

    public static void putShortArray(byte[] bArr, int i5, short[] sArr) {
        for (short s6 : sArr) {
            putShort(bArr, i5, s6);
            i5 += 2;
        }
    }

    public static void putUByte(byte[] bArr, int i5, short s6) {
        bArr[i5] = (byte) (s6 & 255);
    }

    public static void putUInt(byte[] bArr, int i5, long j6) {
        bArr[i5] = (byte) (j6 & 255);
        bArr[i5 + 1] = (byte) ((j6 >>> 8) & 255);
        bArr[i5 + 2] = (byte) ((j6 >>> 16) & 255);
        bArr[i5 + 3] = (byte) ((j6 >>> 24) & 255);
    }

    public static void putUShort(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >>> 8) & 255);
    }

    public static int readInt(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        int i7 = inputStream.read();
        int i8 = inputStream.read();
        if ((i5 | i6 | i7 | i8) >= 0) {
            return (i8 << 24) + (i7 << 16) + (i6 << 8) + i5;
        }
        throw new BufferUnderrunException();
    }

    public static long readLong(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        int i7 = inputStream.read();
        int i8 = inputStream.read();
        int i9 = inputStream.read();
        int i10 = inputStream.read();
        int i11 = inputStream.read();
        int i12 = inputStream.read();
        if ((i5 | i6 | i7 | i8 | i9 | i10 | i11 | i12) >= 0) {
            return (((long) i12) << 56) + (((long) i11) << 48) + (((long) i10) << 40) + (((long) i9) << 32) + (((long) i8) << 24) + ((long) (i7 << 16)) + ((long) (i6 << 8)) + ((long) i5);
        }
        throw new BufferUnderrunException();
    }

    public static short readShort(InputStream inputStream) {
        return (short) readUShort(inputStream);
    }

    public static long readUInt(InputStream inputStream) {
        return ((long) readInt(inputStream)) & KeyboardMap.kValueMask;
    }

    public static int readUShort(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        if ((i5 | i6) >= 0) {
            return (i6 << 8) + i5;
        }
        throw new BufferUnderrunException();
    }

    public static int ubyteToInt(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    public static double getDouble(byte[] bArr, int i5) {
        return Double.longBitsToDouble(getLong(bArr, i5));
    }

    public static float getFloat(byte[] bArr, int i5) {
        return Float.intBitsToFloat(getInt(bArr, i5));
    }

    public static int getInt(byte[] bArr, int i5) {
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[i5 + 1] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16) + (i7 << 8) + i6;
    }

    public static long getLong(byte[] bArr, int i5) {
        long j6 = bArr[i5 + 7] & UnsignedBytes.MAX_VALUE;
        for (int i6 = i5 + 7; i6 >= i5; i6--) {
            j6 = (j6 << 8) | ((long) (bArr[i6] & UnsignedBytes.MAX_VALUE));
        }
        return j6;
    }

    public static short getShort(byte[] bArr, int i5) {
        return (short) (((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i5] & UnsignedBytes.MAX_VALUE));
    }

    public static short getUByte(byte[] bArr, int i5) {
        return (short) (bArr[i5] & UnsignedBytes.MAX_VALUE);
    }

    public static long getUInt(byte[] bArr, int i5) {
        return ((long) getInt(bArr, i5)) & KeyboardMap.kValueMask;
    }

    public static int getUShort(byte[] bArr, int i5) {
        return ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i5] & UnsignedBytes.MAX_VALUE);
    }

    public static void putDouble(double d, OutputStream outputStream) throws IOException {
        putLong(Double.doubleToLongBits(d), outputStream);
    }

    public static void putFloat(float f6, OutputStream outputStream) throws IOException {
        putInt(Float.floatToIntBits(f6), outputStream);
    }

    public static void putShort(OutputStream outputStream, short s6) throws IOException {
        outputStream.write((byte) (s6 & 255));
        outputStream.write((byte) ((s6 >>> 8) & 255));
    }

    public static void putUShort(int i5, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i5 & 255));
        outputStream.write((byte) ((i5 >>> 8) & 255));
    }

    public static void putInt(int i5, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i5 & 255));
        outputStream.write((byte) ((i5 >>> 8) & 255));
        outputStream.write((byte) ((i5 >>> 16) & 255));
        outputStream.write((byte) ((i5 >>> 24) & 255));
    }

    public static void putUInt(long j6, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j6 & 255));
        outputStream.write((byte) ((j6 >>> 8) & 255));
        outputStream.write((byte) ((j6 >>> 16) & 255));
        outputStream.write((byte) ((j6 >>> 24) & 255));
    }

    public static void putLong(long j6, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j6 & 255));
        outputStream.write((byte) ((j6 >>> 8) & 255));
        outputStream.write((byte) ((j6 >>> 16) & 255));
        outputStream.write((byte) ((j6 >>> 24) & 255));
        outputStream.write((byte) ((j6 >>> 32) & 255));
        outputStream.write((byte) ((j6 >>> 40) & 255));
        outputStream.write((byte) ((j6 >>> 48) & 255));
        outputStream.write((byte) ((j6 >>> 56) & 255));
    }
}
