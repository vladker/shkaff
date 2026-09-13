package p120v0;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileInputStream f8777a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public h(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(i.f8778a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f8777a = fileInputStream;
        this.b = charset;
        this.c = new byte[8192];
    }

    private void fillBuf() throws IOException {
        byte[] bArr = this.c;
        int i5 = this.f8777a.read(bArr, 0, bArr.length);
        if (i5 == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f8777a) {
            try {
                if (this.c != null) {
                    this.c = null;
                    this.f8777a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String readLine() {
        int i5;
        byte[] bArr;
        int i6;
        synchronized (this.f8777a) {
            try {
                if (this.c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.d >= this.e) {
                    fillBuf();
                }
                for (int i7 = this.d; i7 != this.e; i7++) {
                    byte[] bArr2 = this.c;
                    if (bArr2[i7] == 10) {
                        int i8 = this.d;
                        if (i7 != i8) {
                            i6 = i7 - 1;
                            if (bArr2[i6] != 13) {
                                i6 = i7;
                            }
                        } else {
                            i6 = i7;
                        }
                        String str = new String(bArr2, i8, i6 - i8, this.b.name());
                        this.d = i7 + 1;
                        return str;
                    }
                }
                g gVar = new g(this, (this.e - this.d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.c;
                    int i9 = this.d;
                    gVar.write(bArr3, i9, this.e - i9);
                    this.e = -1;
                    fillBuf();
                    i5 = this.d;
                    while (i5 != this.e) {
                        bArr = this.c;
                        if (bArr[i5] == 10) {
                            break loop1;
                        }
                        i5++;
                    }
                }
                int i10 = this.d;
                if (i5 != i10) {
                    gVar.write(bArr, i10, i5 - i10);
                }
                this.d = i5 + 1;
                return gVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
