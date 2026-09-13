package org.apache.commons.io;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EndianUtils {
    private static int read(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        if (-1 != i5) {
            return i5;
        }
        throw new EOFException("Unexpected EOF reached");
    }

    public static double readSwappedDouble(byte[] bArr, int i5) {
        return Double.longBitsToDouble(readSwappedLong(bArr, i5));
    }

    public static float readSwappedFloat(byte[] bArr, int i5) {
        return Float.intBitsToFloat(readSwappedInteger(bArr, i5));
    }

    public static int readSwappedInteger(byte[] bArr, int i5) {
        return (bArr[i5] & UnsignedBytes.MAX_VALUE) + ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) + ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24);
    }

    public static long readSwappedLong(byte[] bArr, int i5) {
        return (((long) readSwappedInteger(bArr, i5 + 4)) << 32) + (((long) readSwappedInteger(bArr, i5)) & KeyboardMap.kValueMask);
    }

    public static short readSwappedShort(byte[] bArr, int i5) {
        return (short) ((bArr[i5] & UnsignedBytes.MAX_VALUE) + ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8));
    }

    public static long readSwappedUnsignedInteger(byte[] bArr, int i5) {
        return (((long) (bArr[i5 + 3] & UnsignedBytes.MAX_VALUE)) << 24) + (((long) ((bArr[i5] & UnsignedBytes.MAX_VALUE) + ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) + ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16))) & KeyboardMap.kValueMask);
    }

    public static int readSwappedUnsignedShort(byte[] bArr, int i5) {
        return (bArr[i5] & UnsignedBytes.MAX_VALUE) + ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static double swapDouble(double d) {
        return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(d)));
    }

    public static float swapFloat(float f6) {
        return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(f6)));
    }

    public static int swapInteger(int i5) {
        return ((i5 & 255) << 24) + (((i5 >> 8) & 255) << 16) + (((i5 >> 16) & 255) << 8) + ((i5 >> 24) & 255);
    }

    public static long swapLong(long j6) {
        return ((j6 & 255) << 56) + (((j6 >> 8) & 255) << 48) + (((j6 >> 16) & 255) << 40) + (((j6 >> 24) & 255) << 32) + (((j6 >> 32) & 255) << 24) + (((j6 >> 40) & 255) << 16) + (((j6 >> 48) & 255) << 8) + ((j6 >> 56) & 255);
    }

    public static short swapShort(short s6) {
        return (short) (((s6 & 255) << 8) + ((s6 >> 8) & 255));
    }

    public static void writeSwappedDouble(byte[] bArr, int i5, double d) {
        writeSwappedLong(bArr, i5, Double.doubleToLongBits(d));
    }

    public static void writeSwappedFloat(byte[] bArr, int i5, float f6) {
        writeSwappedInteger(bArr, i5, Float.floatToIntBits(f6));
    }

    public static void writeSwappedInteger(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
    }

    public static void writeSwappedLong(byte[] bArr, int i5, long j6) {
        bArr[i5] = (byte) (j6 & 255);
        bArr[i5 + 1] = (byte) ((j6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((j6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((j6 >> 24) & 255);
        bArr[i5 + 4] = (byte) ((j6 >> 32) & 255);
        bArr[i5 + 5] = (byte) ((j6 >> 40) & 255);
        bArr[i5 + 6] = (byte) ((j6 >> 48) & 255);
        bArr[i5 + 7] = (byte) ((j6 >> 56) & 255);
    }

    public static void writeSwappedShort(byte[] bArr, int i5, short s6) {
        bArr[i5] = (byte) (s6 & 255);
        bArr[i5 + 1] = (byte) ((s6 >> 8) & 255);
    }

    public static double readSwappedDouble(InputStream inputStream) {
        return Double.longBitsToDouble(readSwappedLong(inputStream));
    }

    public static float readSwappedFloat(InputStream inputStream) {
        return Float.intBitsToFloat(readSwappedInteger(inputStream));
    }

    public static int readSwappedInteger(InputStream inputStream) throws IOException {
        return (read(inputStream) & 255) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16) + ((read(inputStream) & 255) << 24);
    }

    public static short readSwappedShort(InputStream inputStream) {
        return (short) ((read(inputStream) & 255) + ((read(inputStream) & 255) << 8));
    }

    public static int readSwappedUnsignedShort(InputStream inputStream) throws IOException {
        return (read(inputStream) & 255) + ((read(inputStream) & 255) << 8);
    }

    public static void writeSwappedDouble(OutputStream outputStream, double d) throws IOException {
        writeSwappedLong(outputStream, Double.doubleToLongBits(d));
    }

    public static void writeSwappedFloat(OutputStream outputStream, float f6) throws IOException {
        writeSwappedInteger(outputStream, Float.floatToIntBits(f6));
    }

    public static long readSwappedLong(InputStream inputStream) {
        byte[] bArr = new byte[8];
        for (int i5 = 0; i5 < 8; i5++) {
            bArr[i5] = (byte) read(inputStream);
        }
        return readSwappedLong(bArr, 0);
    }

    public static long readSwappedUnsignedInteger(InputStream inputStream) throws IOException {
        return (((long) (read(inputStream) & 255)) << 24) + (((long) ((read(inputStream) & 255) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16))) & KeyboardMap.kValueMask);
    }

    public static void writeSwappedShort(OutputStream outputStream, short s6) throws IOException {
        outputStream.write((byte) (s6 & 255));
        outputStream.write((byte) ((s6 >> 8) & 255));
    }

    public static void writeSwappedInteger(OutputStream outputStream, int i5) throws IOException {
        outputStream.write((byte) (i5 & 255));
        outputStream.write((byte) ((i5 >> 8) & 255));
        outputStream.write((byte) ((i5 >> 16) & 255));
        outputStream.write((byte) ((i5 >> 24) & 255));
    }

    public static void writeSwappedLong(OutputStream outputStream, long j6) throws IOException {
        outputStream.write((byte) (j6 & 255));
        outputStream.write((byte) ((j6 >> 8) & 255));
        outputStream.write((byte) ((j6 >> 16) & 255));
        outputStream.write((byte) ((j6 >> 24) & 255));
        outputStream.write((byte) ((j6 >> 32) & 255));
        outputStream.write((byte) ((j6 >> 40) & 255));
        outputStream.write((byte) ((j6 >> 48) & 255));
        outputStream.write((byte) ((j6 >> 56) & 255));
    }
}
