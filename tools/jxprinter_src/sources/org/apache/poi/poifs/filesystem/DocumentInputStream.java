package org.apache.poi.poifs.filesystem;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DocumentInputStream extends InputStream implements LittleEndianInput {
    private static final int EOF = -1;
    private ByteBuffer _buffer;
    private boolean _closed;
    private int _current_block_count;
    private int _current_offset;
    private Iterator<ByteBuffer> _data;
    private final POIFSDocument _document;
    private final int _document_size;
    private int _marked_offset;
    private int _marked_offset_count;

    public DocumentInputStream(DocumentEntry documentEntry) throws IOException {
        if (!(documentEntry instanceof DocumentNode)) {
            throw new IOException("Cannot open internal document storage, " + documentEntry + " not a Document Node");
        }
        this._current_offset = 0;
        this._current_block_count = 0;
        this._marked_offset = 0;
        this._marked_offset_count = 0;
        this._document_size = documentEntry.getSize();
        this._closed = false;
        DocumentNode documentNode = (DocumentNode) documentEntry;
        POIFSDocument pOIFSDocument = new POIFSDocument((DocumentProperty) documentNode.getProperty(), ((DirectoryNode) documentNode.getParent()).getFileSystem());
        this._document = pOIFSDocument;
        this._data = pOIFSDocument.getBlockIterator();
    }

    private boolean atEOD() {
        return this._current_offset == this._document_size;
    }

    private void checkAvaliable(int i5) {
        if (this._closed) {
            throw new IllegalStateException("cannot perform requested operation on a closed stream");
        }
        if (i5 <= this._document_size - this._current_offset) {
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Buffer underrun - requested ", " bytes but ");
        sbT.append(this._document_size - this._current_offset);
        sbT.append(" was available");
        throw new IllegalStateException(sbT.toString());
    }

    private void dieIfClosed() throws IOException {
        if (this._closed) {
            throw new IOException("cannot perform requested operation on a closed stream");
        }
    }

    private int remainingBytes() {
        if (this._closed) {
            throw new IllegalStateException("cannot perform requested operation on a closed stream");
        }
        return this._document_size - this._current_offset;
    }

    @Override // java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return remainingBytes();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._closed = true;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        this._marked_offset = this._current_offset;
        this._marked_offset_count = Math.max(0, this._current_block_count - 1);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dieIfClosed();
        if (atEOD()) {
            return -1;
        }
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & UnsignedBytes.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkAvaliable(4);
        byte[] bArr = new byte[4];
        readFully(bArr, 0, 4);
        return LittleEndian.getInt(bArr);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkAvaliable(8);
        byte[] bArr = new byte[8];
        readFully(bArr, 0, 8);
        return LittleEndian.getLong(bArr, 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i5, int i6) {
        readFully(bArr, i5, i6);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkAvaliable(2);
        byte[] bArr = new byte[2];
        readFully(bArr, 0, 2);
        return LittleEndian.getShort(bArr);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkAvaliable(1);
        byte[] bArr = new byte[1];
        readFully(bArr, 0, 1);
        byte b = bArr[0];
        return b >= 0 ? b : b + 256;
    }

    public long readUInt() {
        return ((long) readInt()) & KeyboardMap.kValueMask;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkAvaliable(2);
        byte[] bArr = new byte[2];
        readFully(bArr, 0, 2);
        return LittleEndian.getUShort(bArr);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        int i5;
        int i6;
        int i7 = this._marked_offset;
        if (i7 == 0 && (i6 = this._marked_offset_count) == 0) {
            this._current_block_count = i6;
            this._current_offset = i7;
            this._data = this._document.getBlockIterator();
            this._buffer = null;
            return;
        }
        this._data = this._document.getBlockIterator();
        int i8 = 0;
        this._current_offset = 0;
        while (true) {
            i5 = this._marked_offset_count;
            if (i8 >= i5) {
                break;
            }
            ByteBuffer next = this._data.next();
            this._buffer = next;
            this._current_offset += next.remaining();
            i8++;
        }
        this._current_block_count = i5;
        if (this._current_offset != this._marked_offset) {
            ByteBuffer next2 = this._data.next();
            this._buffer = next2;
            this._current_block_count++;
            next2.position(next2.position() + (this._marked_offset - this._current_offset));
        }
        this._current_offset = this._marked_offset;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        int i5;
        dieIfClosed();
        if (j6 < 0) {
            return 0L;
        }
        int i6 = this._current_offset;
        long j7 = ((long) i6) + j6;
        if (j7 >= i6) {
            i5 = this._document_size;
            if (j7 > i5) {
            }
            long j8 = j7 - ((long) i6);
            readFully(IOUtils.safelyAllocate(j8, Integer.MAX_VALUE));
            return j8;
        }
        i5 = this._document_size;
        j7 = i5;
        long j9 = j7 - ((long) i6);
        readFully(IOUtils.safelyAllocate(j9, Integer.MAX_VALUE));
        return j9;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i5, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Can't read negative number of bytes, but had: "));
        }
        checkAvaliable(i6);
        int i7 = 0;
        while (i7 < i6) {
            ByteBuffer byteBuffer = this._buffer;
            if (byteBuffer == null || byteBuffer.remaining() == 0) {
                this._current_block_count++;
                this._buffer = this._data.next();
            }
            int iMin = Math.min(i6 - i7, this._buffer.remaining());
            this._buffer.get(bArr, i5 + i7, iMin);
            this._current_offset += iMin;
            i7 += iMin;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        dieIfClosed();
        if (bArr != null) {
            if (i5 < 0 || i6 < 0 || bArr.length < i5 + i6) {
                throw new IndexOutOfBoundsException("can't read past buffer boundaries");
            }
            if (i6 == 0) {
                return 0;
            }
            if (atEOD()) {
                return -1;
            }
            int iMin = Math.min(remainingBytes(), i6);
            readFully(bArr, i5, iMin);
            return iMin;
        }
        throw new IllegalArgumentException("buffer must not be null");
    }

    public DocumentInputStream(POIFSDocument pOIFSDocument) {
        this._current_offset = 0;
        this._current_block_count = 0;
        this._marked_offset = 0;
        this._marked_offset_count = 0;
        this._document_size = pOIFSDocument.getSize();
        this._closed = false;
        this._document = pOIFSDocument;
        this._data = pOIFSDocument.getBlockIterator();
    }
}
