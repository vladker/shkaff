package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ByteCounterInputStream extends InputStream implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f3647a;
    private long b;
    private OnReadListener c;

    public ByteCounterInputStream(InputStream inputStream) {
        this.f3647a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f3647a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3647a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i5) {
        this.f3647a.mark(i5);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f3647a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i5 = this.f3647a.read();
        if (i5 >= 0) {
            long j6 = this.b + 1;
            this.b = j6;
            OnReadListener onReadListener = this.c;
            if (onReadListener != null) {
                onReadListener.onRead(j6);
            }
        }
        return i5;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f3647a.reset();
        this.b = 0L;
    }

    public void setOnInputStreamReadListener(OnReadListener onReadListener) {
        this.c = onReadListener;
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return this.f3647a.skip(j6);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = this.f3647a.read(bArr, i5, i6);
        if (i7 > 0) {
            long j6 = this.b + ((long) i7);
            this.b = j6;
            OnReadListener onReadListener = this.c;
            if (onReadListener != null) {
                onReadListener.onRead(j6);
            }
        }
        return i7;
    }
}
