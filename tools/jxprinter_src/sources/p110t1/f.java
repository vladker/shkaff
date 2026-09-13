package p110t1;

import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f8546a;
    public final int b;
    public int c;
    public boolean d;

    public f(InputStream inputStream, int i5) {
        super(inputStream);
        this.f8546a = new byte[i5];
        this.b = i5;
    }

    private int readTail(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = this.c;
        int i8 = 0;
        if (i6 < i7) {
            int i9 = i7 - i6;
            System.arraycopy(this.f8546a, 0, bArr, i5, i6);
            byte[] bArr2 = this.f8546a;
            System.arraycopy(bArr2, i6, bArr2, 0, i9);
            int i10 = ((FilterInputStream) this).in.read(this.f8546a, i9, this.b - i9);
            if (i10 != -1) {
                return a(bArr, i6, i10 + i9, i5);
            }
            byte[] bArr3 = this.f8546a;
            System.arraycopy(bArr3, 0, bArr3, i6, i9);
            System.arraycopy(bArr, i5, this.f8546a, 0, i6);
            this.d = true;
            return -1;
        }
        int i11 = ((FilterInputStream) this).in.read(bArr, this.c + i5, i6 - i7);
        if (i11 == -1) {
            this.d = true;
            return -1;
        }
        int i12 = this.c;
        if (i12 > 0) {
            System.arraycopy(this.f8546a, 0, bArr, i5, i12);
        }
        int i13 = this.c + i11;
        int i14 = ((FilterInputStream) this).in.read(this.f8546a, 0, this.b);
        if (i14 == -1) {
            this.d = true;
        } else {
            i8 = i14;
        }
        return a(bArr, i13, i8, i5);
    }

    public final int a(byte[] bArr, int i5, int i6, int i7) {
        int i8 = this.b - i6;
        int iMax = Math.max(0, i5 - i8) + i7;
        int iMin = Math.min(i8, i5);
        if (iMin > 0) {
            byte[] bArr2 = this.f8546a;
            if (i6 > 0) {
                System.arraycopy(bArr2, 0, bArr2, iMin, i6);
            }
            System.arraycopy(bArr, iMax, bArr2, 0, iMin);
        }
        this.c = iMin + i6;
        return iMax - i7;
    }

    public byte[] getTail() throws IOException {
        if (this.c == this.b) {
            return this.f8546a;
        }
        throw new IOException("Not enough tail data");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
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

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (this.d) {
            return -1;
        }
        int tail = 0;
        if (i6 == 0) {
            return 0;
        }
        while (tail == 0) {
            tail = readTail(bArr, i5, i6);
        }
        return tail;
    }
}
