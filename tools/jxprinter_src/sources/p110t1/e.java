package p110t1;

import com.facebook.crypto.mac.NativeMac;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeMac f8545a;
    public final OutputStream b;
    public boolean c = false;

    public e(NativeMac nativeMac, OutputStream outputStream) {
        this.f8545a = nativeMac;
        this.b = outputStream;
    }

    private void appendMac() throws IOException {
        NativeMac nativeMac = this.f8545a;
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            this.b.write(nativeMac.doFinal());
        } finally {
            nativeMac.destroy();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.b;
        try {
            appendMac();
        } finally {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        this.f8545a.update(bArr, i5, i6);
        this.b.write(bArr, i5, i6);
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        this.f8545a.update((byte) i5);
        this.b.write(i5);
    }
}
