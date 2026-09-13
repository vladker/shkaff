package p110t1;

import U4.g;
import androidx.collection.a;
import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f8542a;
    public final NativeGCMCipher b;
    public final int c;
    public final byte[] d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8543f = false;
    public final byte[] e = new byte[16];

    public c(OutputStream outputStream, NativeGCMCipher nativeGCMCipher, byte[] bArr) {
        this.f8542a = outputStream;
        this.b = nativeGCMCipher;
        int iB = nativeGCMCipher.b();
        if (bArr == null) {
            bArr = new byte[iB + 256];
        } else {
            int i5 = iB + 1;
            if (bArr.length < i5) {
                throw new IllegalArgumentException(a.i(i5, "encryptBuffer cannot be smaller than ", "B"));
            }
        }
        this.c = bArr.length - iB;
        this.d = bArr;
    }

    private void appendTag() throws g {
        byte[] bArr = this.e;
        NativeGCMCipher nativeGCMCipher = this.b;
        if (this.f8543f) {
            return;
        }
        this.f8543f = true;
        try {
            nativeGCMCipher.encryptFinal(bArr, bArr.length);
            this.f8542a.write(bArr);
        } finally {
            nativeGCMCipher.destroy();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.f8542a;
        try {
            appendTag();
        } finally {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f8542a.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        byte[] bArr2;
        OutputStream outputStream;
        int i7 = i5 + i6;
        if (bArr.length < i7) {
            throw new ArrayIndexOutOfBoundsException(i7);
        }
        int i8 = this.c;
        int i9 = i6 / i8;
        int i10 = i6 % i8;
        int i11 = i5;
        int i12 = 0;
        while (true) {
            bArr2 = this.d;
            outputStream = this.f8542a;
            if (i12 >= i9) {
                break;
            }
            outputStream.write(bArr2, 0, this.b.update(bArr, i11, this.c, this.d, 0));
            i11 += i8;
            i12++;
        }
        if (i10 > 0) {
            outputStream.write(bArr2, 0, this.b.update(bArr, i11, i10, this.d, 0));
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        write(new byte[]{(byte) i5}, 0, 1);
    }
}
