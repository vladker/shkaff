package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f2918a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a b;
    public int c;

    @NonNull
    private final OutputStream out;

    public c(@NonNull OutputStream outputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this(outputStream, aVar, 65536);
    }

    private void flushBuffer() throws IOException {
        int i5 = this.c;
        if (i5 > 0) {
            this.out.write(this.f2918a, 0, i5);
            this.c = 0;
        }
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.c == this.f2918a.length) {
            flushBuffer();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            byte[] bArr = this.f2918a;
            if (bArr != null) {
                ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.b).g(bArr);
                this.f2918a = null;
            }
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.f2918a;
        int i6 = this.c;
        this.c = i6 + 1;
        bArr[i6] = (byte) i5;
        maybeFlushBuffer();
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.bumptech.glide.load.engine.bitmap_recycle.a aVar, int i5) {
        this.out = outputStream;
        this.b = aVar;
        this.f2918a = (byte[]) ((com.bumptech.glide.load.engine.bitmap_recycle.j) aVar).c(i5, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i5, int i6) throws IOException {
        int i7 = 0;
        do {
            int i8 = i6 - i7;
            int i9 = i5 + i7;
            int i10 = this.c;
            if (i10 == 0 && i8 >= this.f2918a.length) {
                this.out.write(bArr, i9, i8);
                return;
            }
            int iMin = Math.min(i8, this.f2918a.length - i10);
            System.arraycopy(bArr, i9, this.f2918a, this.c, iMin);
            this.c += iMin;
            i7 += iMin;
            maybeFlushBuffer();
        } while (i7 < i6);
    }
}
