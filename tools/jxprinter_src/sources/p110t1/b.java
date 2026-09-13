package p110t1;

import U4.g;
import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f8541a;
    public final NativeGCMCipher b;
    public byte[] c;
    public boolean d = false;

    public b(InputStream inputStream, NativeGCMCipher nativeGCMCipher) {
        this.f8541a = new f(inputStream, 16);
        this.b = nativeGCMCipher;
    }

    private void ensureTagValid() throws g {
        NativeGCMCipher nativeGCMCipher = this.b;
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            byte[] tail = this.f8541a.getTail();
            nativeGCMCipher.decryptFinal(tail, tail.length);
        } finally {
            nativeGCMCipher.destroy();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f8541a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f fVar = this.f8541a;
        try {
            ensureTagValid();
        } finally {
            fVar.close();
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        if (this.c == null) {
            this.c = new byte[256];
        }
        long j7 = 0;
        while (j6 > 0) {
            int i5 = read(this.c, 0, (int) Math.min(j6, 256L));
            if (i5 < 0) {
                break;
            }
            long j8 = i5;
            j7 += j8;
            j6 -= j8;
        }
        if (j7 == 0) {
            return -1L;
        }
        return j7;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = i5 + i6;
        if (bArr.length >= i7) {
            int i8 = this.f8541a.read(bArr, i5, i6);
            if (i8 == -1) {
                ensureTagValid();
                return -1;
            }
            return this.b.update(bArr, i5, i8, bArr, i5);
        }
        throw new ArrayIndexOutOfBoundsException(i7);
    }
}
