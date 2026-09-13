package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MemoryPackagePartOutputStream extends OutputStream {
    private final UnsynchronizedByteArrayOutputStream _buff = new UnsynchronizedByteArrayOutputStream();
    private final MemoryPackagePart _part;

    public MemoryPackagePartOutputStream(MemoryPackagePart memoryPackagePart) {
        this._part = memoryPackagePart;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._buff.flush();
        MemoryPackagePart memoryPackagePart = this._part;
        byte[] bArr = memoryPackagePart.data;
        if (bArr != null) {
            byte[] bArr2 = new byte[this._buff.size() + bArr.length];
            byte[] bArr3 = this._part.data;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            byte[] byteArray = this._buff.toByteArray();
            System.arraycopy(byteArray, 0, bArr2, this._part.data.length, byteArray.length);
            this._part.data = bArr2;
        } else {
            memoryPackagePart.data = this._buff.toByteArray();
        }
        this._buff.reset();
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        this._buff.write(i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this._buff.write(bArr, i5, i6);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this._buff.write(bArr);
    }
}
