package org.apache.poi.xssf.streaming;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class OpcOutputStream extends DeflaterOutputStream {
    private final CRC32 crc;
    private Zip64Impl.Entry current;
    private final List<Zip64Impl.Entry> entries;
    private boolean finished;
    private final Zip64Impl spec;
    private int written;

    public OpcOutputStream(OutputStream outputStream) {
        super(outputStream, new Deflater(-1, true));
        this.entries = new ArrayList();
        this.crc = new CRC32();
        this.written = 0;
        this.finished = false;
        this.spec = new Zip64Impl(outputStream);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();
        ((DeflaterOutputStream) this).out.close();
    }

    public void closeEntry() throws IOException {
        if (this.current == null) {
            throw new IllegalStateException("not current zip current");
        }
        ((DeflaterOutputStream) this).def.finish();
        while (!((DeflaterOutputStream) this).def.finished()) {
            deflate();
        }
        this.current.size = ((DeflaterOutputStream) this).def.getBytesRead();
        this.current.compressedSize = Math.toIntExact(((DeflaterOutputStream) this).def.getBytesWritten());
        this.current.crc = this.crc.getValue();
        int i5 = this.written;
        Zip64Impl.Entry entry = this.current;
        int i6 = i5 + entry.compressedSize;
        this.written = i6;
        this.written = i6 + this.spec.writeDAT(entry);
        this.current = null;
        ((DeflaterOutputStream) this).def.reset();
        this.crc.reset();
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        if (this.current != null) {
            closeEntry();
        }
        int i5 = this.written;
        Iterator<Zip64Impl.Entry> it = this.entries.iterator();
        while (it.hasNext()) {
            this.written += this.spec.writeCEN(it.next());
        }
        this.written += this.spec.writeEND(this.entries.size(), i5, this.written - i5);
        this.finished = true;
    }

    public void putNextEntry(String str) throws IOException {
        if (this.current != null) {
            closeEntry();
        }
        Zip64Impl.Entry entry = new Zip64Impl.Entry(str);
        this.current = entry;
        int i5 = this.written;
        entry.offset = i5;
        this.written = i5 + this.spec.writeLFH(entry);
        this.entries.add(this.current);
    }

    public void setLevel(int i5) {
        ((DeflaterOutputStream) this).def.setLevel(i5);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i5, int i6) {
        if (i5 >= 0 && i6 >= 0) {
            if (i5 <= bArr.length - i6) {
                if (i6 == 0) {
                    return;
                }
                super.write(bArr, i5, i6);
                this.crc.update(bArr, i5, i6);
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
