package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class K extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f3091a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f3092f;

    public K(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this(inputStream, aVar, 65536);
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        int i5 = this.d;
        if (i5 != -1) {
            int i6 = this.e - i5;
            int i7 = this.c;
            if (i6 < i7) {
                if (i5 == 0 && i7 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i7) {
                        i7 = length;
                    }
                    byte[] bArr2 = (byte[]) ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.f3092f).c(i7, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f3091a = bArr2;
                    ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.f3092f).g(bArr);
                    bArr = bArr2;
                } else if (i5 > 0) {
                    System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                }
                int i8 = this.e - this.d;
                this.e = i8;
                this.d = 0;
                this.b = 0;
                int i9 = inputStream.read(bArr, i8, bArr.length - i8);
                int i10 = this.e;
                if (i9 > 0) {
                    i10 += i9;
                }
                this.b = i10;
                return i9;
            }
        }
        int i11 = inputStream.read(bArr);
        if (i11 > 0) {
            this.d = -1;
            this.e = 0;
            this.b = i11;
        }
        return i11;
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f3091a == null || inputStream == null) {
            throw streamClosed();
        }
        return (this.b - this.e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3091a != null) {
            ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.f3092f).g(this.f3091a);
            this.f3091a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i5) {
        this.c = Math.max(this.c, i5);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f3091a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw streamClosed();
        }
        if (this.e >= this.b && fillbuf(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f3091a && (bArr = this.f3091a) == null) {
            throw streamClosed();
        }
        int i5 = this.b;
        int i6 = this.e;
        if (i5 - i6 <= 0) {
            return -1;
        }
        this.e = i6 + 1;
        return bArr[i6] & UnsignedBytes.MAX_VALUE;
    }

    public final synchronized void release() {
        if (this.f3091a != null) {
            ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.f3092f).g(this.f3091a);
            this.f3091a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f3091a == null) {
            throw new IOException("Stream is closed");
        }
        int i5 = this.d;
        if (-1 == i5) {
            throw new J("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
        }
        this.e = i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j6) {
        if (j6 < 1) {
            return 0L;
        }
        byte[] bArr = this.f3091a;
        if (bArr == null) {
            throw streamClosed();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw streamClosed();
        }
        int i5 = this.b;
        int i6 = this.e;
        if (i5 - i6 >= j6) {
            this.e = (int) (((long) i6) + j6);
            return j6;
        }
        long j7 = ((long) i5) - ((long) i6);
        this.e = i5;
        if (this.d == -1 || j6 > this.c) {
            long jSkip = inputStream.skip(j6 - j7);
            if (jSkip > 0) {
                this.d = -1;
            }
            return j7 + jSkip;
        }
        if (fillbuf(inputStream, bArr) == -1) {
            return j7;
        }
        int i7 = this.b;
        int i8 = this.e;
        if (i7 - i8 >= j6 - j7) {
            this.e = (int) ((((long) i8) + j6) - j7);
            return j6;
        }
        long j8 = (j7 + ((long) i7)) - ((long) i8);
        this.e = i7;
        return j8;
    }

    @VisibleForTesting
    public K(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar, int i5) {
        super(inputStream);
        this.d = -1;
        this.f3092f = aVar;
        this.f3091a = (byte[]) ((com.bumptech.glide.load.engine.bitmap_recycle.j) aVar).c(i5, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i5, int i6) {
        int i7;
        int i8;
        byte[] bArr2 = this.f3091a;
        if (bArr2 == null) {
            throw streamClosed();
        }
        if (i6 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i9 = this.e;
            int i10 = this.b;
            if (i9 < i10) {
                int i11 = i10 - i9 >= i6 ? i6 : i10 - i9;
                System.arraycopy(bArr2, i9, bArr, i5, i11);
                this.e += i11;
                if (i11 == i6 || inputStream.available() == 0) {
                    return i11;
                }
                i5 += i11;
                i7 = i6 - i11;
            } else {
                i7 = i6;
            }
            while (true) {
                if (this.d == -1 && i7 >= bArr2.length) {
                    i8 = inputStream.read(bArr, i5, i7);
                    if (i8 == -1) {
                        return i7 != i6 ? i6 - i7 : -1;
                    }
                } else {
                    if (fillbuf(inputStream, bArr2) == -1) {
                        return i7 != i6 ? i6 - i7 : -1;
                    }
                    if (bArr2 != this.f3091a && (bArr2 = this.f3091a) == null) {
                        throw streamClosed();
                    }
                    int i12 = this.b;
                    int i13 = this.e;
                    i8 = i12 - i13 >= i7 ? i7 : i12 - i13;
                    System.arraycopy(bArr2, i13, bArr, i5, i8);
                    this.e += i8;
                }
                i7 -= i8;
                if (i7 == 0) {
                    return i6;
                }
                if (inputStream.available() == 0) {
                    return i6 - i7;
                }
                i5 += i8;
            }
        } else {
            throw streamClosed();
        }
    }
}
