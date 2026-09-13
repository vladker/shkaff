package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NullReader extends Reader {
    private boolean eof;
    private long mark;
    private final boolean markSupported;
    private long position;
    private long readlimit;
    private final long size;
    private final boolean throwEofException;

    public NullReader() {
        this(0L, true, false);
    }

    private int doEndOfFile() throws EOFException {
        this.eof = true;
        if (this.throwEofException) {
            throw new EOFException();
        }
        return -1;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = false;
        this.position = 0L;
        this.mark = -1L;
    }

    public long getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i5) {
        if (!this.markSupported) {
            throw UnsupportedOperationExceptions.mark();
        }
        this.mark = this.position;
        this.readlimit = i5;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return this.markSupported;
    }

    public int processChar() {
        return 0;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.eof) {
            throw new IOException("Read after end of file");
        }
        long j6 = this.position;
        if (j6 == this.size) {
            return doEndOfFile();
        }
        this.position = j6 + 1;
        return processChar();
    }

    @Override // java.io.Reader
    public synchronized void reset() {
        if (!this.markSupported) {
            throw UnsupportedOperationExceptions.reset();
        }
        long j6 = this.mark;
        if (j6 < 0) {
            throw new IOException("No position has been marked");
        }
        if (this.position > this.readlimit + j6) {
            throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
        }
        this.position = j6;
        this.eof = false;
    }

    @Override // java.io.Reader
    public long skip(long j6) throws IOException {
        if (this.eof) {
            throw new IOException("Skip after end of file");
        }
        long j7 = this.position;
        long j8 = this.size;
        if (j7 == j8) {
            return doEndOfFile();
        }
        long j9 = j7 + j6;
        this.position = j9;
        if (j9 <= j8) {
            return j6;
        }
        long j10 = j6 - (j9 - j8);
        this.position = j8;
        return j10;
    }

    public NullReader(long j6) {
        this(j6, true, false);
    }

    public NullReader(long j6, boolean z6, boolean z7) {
        this.mark = -1L;
        this.size = j6;
        this.markSupported = z6;
        this.throwEofException = z7;
    }

    @Override // java.io.Reader
    public int read(char[] cArr) {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i5, int i6) throws IOException {
        if (!this.eof) {
            long j6 = this.position;
            long j7 = this.size;
            if (j6 == j7) {
                return doEndOfFile();
            }
            long j8 = j6 + ((long) i6);
            this.position = j8;
            if (j8 > j7) {
                i6 -= (int) (j8 - j7);
                this.position = j7;
            }
            processChars(cArr, i5, i6);
            return i6;
        }
        throw new IOException("Read after end of file");
    }

    public void processChars(char[] cArr, int i5, int i6) {
    }
}
