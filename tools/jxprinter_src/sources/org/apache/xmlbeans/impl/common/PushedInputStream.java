package org.apache.xmlbeans.impl.common;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class PushedInputStream extends InputStream {
    private static int defaultBufferSize = 2048;
    protected byte[] buf;
    protected int marklimit;
    protected int markpos;
    protected OutputStream outputStream;
    protected int readpos;
    protected int writepos;

    public PushedInputStream() {
        this(defaultBufferSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    public void shift(int i5) {
        int i6 = this.readpos;
        int i7 = this.markpos;
        if (i7 > 0) {
            if (i6 - i7 > this.marklimit) {
                this.markpos = -1;
            } else {
                i6 = i7;
            }
        }
        int i8 = this.writepos - i6;
        if (i6 > 0) {
            byte[] bArr = this.buf;
            if (bArr.length - i8 < i5 || i8 > i5) {
                byte[] bArr2 = new byte[Math.max(this.buf.length << 1, i5 + i8)];
                System.arraycopy(this.buf, i6, bArr2, 0, i8);
                this.buf = bArr2;
            } else {
                System.arraycopy(bArr, i6, bArr, 0, i8);
            }
        } else {
            byte[] bArr3 = new byte[Math.max(this.buf.length << 1, i5 + i8)];
            System.arraycopy(this.buf, i6, bArr3, 0, i8);
            this.buf = bArr3;
        }
        if (i6 > 0) {
            this.readpos -= i6;
            int i9 = this.markpos;
            if (i9 > 0) {
                this.markpos = i9 - i6;
            }
            this.writepos -= i6;
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.writepos - this.readpos;
    }

    public abstract void fill(int i5);

    public final OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        this.marklimit = i5;
        this.markpos = this.readpos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        if (this.readpos >= this.writepos) {
            fill(1);
            if (this.readpos >= this.writepos) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i5 = this.readpos;
        this.readpos = i5 + 1;
        return bArr[i5] & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        int i5 = this.markpos;
        if (i5 < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.readpos = i5;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j6) {
        if (j6 <= 0) {
            return 0L;
        }
        long j7 = this.writepos - this.readpos;
        if (j7 < j6) {
            long j8 = j6 - j7;
            if (j8 > 2147483647L) {
                j8 = 2147483647L;
            }
            fill((int) j8);
            j7 = this.writepos - this.readpos;
            if (j7 <= 0) {
                return 0L;
            }
        }
        if (j7 < j6) {
            j6 = j7;
        }
        this.readpos = Math.addExact(this.readpos, Math.toIntExact(j6));
        return j6;
    }

    public PushedInputStream(int i5) {
        this.markpos = -1;
        this.outputStream = new InternalOutputStream();
        if (i5 < 0) {
            throw new IllegalArgumentException("Negative initial buffer size");
        }
        this.buf = new byte[i5];
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class InternalOutputStream extends OutputStream {
        private InternalOutputStream() {
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i5) {
            try {
                PushedInputStream pushedInputStream = PushedInputStream.this;
                if (pushedInputStream.writepos + 1 > pushedInputStream.buf.length) {
                    pushedInputStream.shift(1);
                }
                PushedInputStream pushedInputStream2 = PushedInputStream.this;
                byte[] bArr = pushedInputStream2.buf;
                int i6 = pushedInputStream2.writepos;
                bArr[i6] = (byte) i5;
                pushedInputStream2.writepos = i6 + 1;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i5, int i6) {
            int i7;
            if (i5 >= 0) {
                try {
                    if (i5 <= bArr.length && i6 >= 0 && (i7 = i5 + i6) <= bArr.length && i7 >= 0) {
                        if (i6 == 0) {
                            return;
                        }
                        PushedInputStream pushedInputStream = PushedInputStream.this;
                        if (pushedInputStream.writepos + i6 > pushedInputStream.buf.length) {
                            pushedInputStream.shift(i6);
                        }
                        PushedInputStream pushedInputStream2 = PushedInputStream.this;
                        System.arraycopy(bArr, i5, pushedInputStream2.buf, pushedInputStream2.writepos, i6);
                        PushedInputStream.this.writepos += i6;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        int i7 = this.writepos - this.readpos;
        if (i7 < i6) {
            fill(i6 - i7);
            i7 = this.writepos - this.readpos;
            if (i7 <= 0) {
                return -1;
            }
        }
        if (i7 < i6) {
            i6 = i7;
        }
        System.arraycopy(this.buf, this.readpos, bArr, i5, i6);
        this.readpos += i6;
        return i6;
    }
}
