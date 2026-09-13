package org.apache.poi.xssf.streaming;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class Zip64Impl {
    private static final int DATA_DESCRIPTOR_USED = 8;
    private static final long MAX32 = 4294967295L;
    private static final long PK0102 = 33639248;
    private static final long PK0304 = 67324752;
    private static final long PK0506 = 101010256;
    private static final long PK0708 = 134695760;
    private static final int VERSION_20 = 20;
    private static final int VERSION_45 = 45;
    private static final int ZIP64_FIELD = 1;
    private final OutputStream out;
    private int written = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Entry {
        int compressedSize;
        long crc;
        final String filename;
        int offset;
        long size;

        public Entry(String str) {
            this.filename = str;
        }
    }

    public Zip64Impl(OutputStream outputStream) {
        this.out = outputStream;
    }

    private void writeInt(long j6) throws IOException {
        OutputStream outputStream = this.out;
        outputStream.write((int) (j6 & 255));
        outputStream.write((int) ((j6 >>> 8) & 255));
        outputStream.write((int) ((j6 >>> 16) & 255));
        outputStream.write((int) ((j6 >>> 24) & 255));
        this.written += 4;
    }

    private void writeLong(long j6) throws IOException {
        OutputStream outputStream = this.out;
        outputStream.write((int) (j6 & 255));
        outputStream.write((int) ((j6 >>> 8) & 255));
        outputStream.write((int) ((j6 >>> 16) & 255));
        outputStream.write((int) ((j6 >>> 24) & 255));
        outputStream.write((int) ((j6 >>> 32) & 255));
        outputStream.write((int) ((j6 >>> 40) & 255));
        outputStream.write((int) ((j6 >>> 48) & 255));
        outputStream.write((int) ((j6 >>> 56) & 255));
        this.written += 8;
    }

    private void writeShort(int i5) throws IOException {
        OutputStream outputStream = this.out;
        outputStream.write(i5 & 255);
        outputStream.write((i5 >>> 8) & 255);
        this.written += 2;
    }

    public int writeCEN(Entry entry) throws IOException {
        this.written = 0;
        boolean z6 = entry.size > 4294967295L;
        writeInt(PK0102);
        writeShort(45);
        writeShort(z6 ? 45 : 20);
        writeShort(8);
        writeShort(8);
        writeInt(0L);
        writeInt(entry.crc);
        writeInt(entry.compressedSize);
        writeInt(z6 ? 4294967295L : entry.size);
        writeShort(entry.filename.length());
        writeShort(z6 ? 12 : 0);
        writeShort(0);
        writeShort(0);
        writeShort(0);
        writeInt(0L);
        writeInt(entry.offset);
        byte[] bytes = entry.filename.getBytes(StandardCharsets.US_ASCII);
        this.out.write(bytes);
        if (z6) {
            writeShort(1);
            writeShort(8);
            writeLong(entry.size);
        }
        return this.written + bytes.length;
    }

    public int writeDAT(Entry entry) throws IOException {
        this.written = 0;
        writeInt(PK0708);
        writeInt(entry.crc);
        writeLong(entry.compressedSize);
        writeLong(entry.size);
        return this.written;
    }

    public int writeEND(int i5, int i6, int i7) throws IOException {
        this.written = 0;
        writeInt(PK0506);
        writeShort(0);
        writeShort(0);
        writeShort(i5);
        writeShort(i5);
        writeInt(i7);
        writeInt(i6);
        writeShort(0);
        return this.written;
    }

    public int writeLFH(Entry entry) throws IOException {
        this.written = 0;
        writeInt(PK0304);
        writeShort(45);
        writeShort(8);
        writeShort(8);
        writeInt(0L);
        writeInt(entry.crc);
        writeInt(0L);
        writeInt(0L);
        writeShort(entry.filename.length());
        writeShort(0);
        byte[] bytes = entry.filename.getBytes(StandardCharsets.US_ASCII);
        this.out.write(bytes);
        return this.written + bytes.length;
    }
}
