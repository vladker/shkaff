package p110t1;

import com.facebook.crypto.mac.NativeMac;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeMac f8544a;
    public final f b;
    public boolean c = false;

    public d(NativeMac nativeMac, InputStream inputStream) {
        this.f8544a = nativeMac;
        this.b = new f(inputStream, nativeMac.a());
    }

    private void ensureMacValid() throws IOException {
        NativeMac nativeMac = this.f8544a;
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            byte[] bArrDoFinal = nativeMac.doFinal();
            byte[] tail = this.b.getTail();
            if (tail.length == bArrDoFinal.length) {
                int i5 = 0;
                for (int i6 = 0; i6 < tail.length; i6++) {
                    i5 |= tail[i6] ^ bArrDoFinal[i6];
                }
                if (i5 == 0) {
                    nativeMac.destroy();
                    return;
                }
            }
            throw new IOException("Mac does not match");
        } catch (Throwable th) {
            nativeMac.destroy();
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f fVar = this.b;
        try {
            ensureMacValid();
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
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i5 = read(bArr, 0, 1);
        while (i5 == 0) {
            i5 = read(bArr, 0, 1);
        }
        if (i5 == -1) {
            return -1;
        }
        return bArr[0] & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = this.b.read(bArr, i5, i6);
        if (i7 == -1) {
            ensureMacValid();
            return -1;
        }
        if (i7 > 0) {
            this.f8544a.update(bArr, i5, i7);
        }
        return i7;
    }
}
