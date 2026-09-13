package org.apache.poi.xssf.streaming;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class OpcZipArchiveOutputStream extends ZipArchiveOutputStream {
    private final OpcOutputStream out;

    public OpcZipArchiveOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.out = new OpcOutputStream(outputStream);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream, org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        this.out.closeEntry();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream, org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        this.out.finish();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream, org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        this.out.putNextEntry(archiveEntry.getName());
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
    public void setLevel(int i5) {
        this.out.setLevel(i5);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this.out.write(bArr, i5, i6);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream, java.io.OutputStream
    public void write(int i5) throws IOException {
        this.out.write(i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
    }
}
