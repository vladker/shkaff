package W4;

import V4.h;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends BufferedInputStream {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f827g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f828a;
    public final int b;
    public long c;
    public long d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f829f;

    public a(InputStream inputStream, int i5) {
        super(inputStream, 32768);
        this.d = 0L;
        h.b(i5 >= 0);
        this.b = i5;
        this.e = i5;
        this.f828a = i5 != 0;
        this.c = System.nanoTime();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        boolean z6;
        int i7;
        if (this.f829f || ((z6 = this.f828a) && this.e <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f829f = true;
            return -1;
        }
        if (this.d != 0 && System.nanoTime() - this.c > this.d) {
            throw new SocketTimeoutException("Read timeout");
        }
        if (z6 && i6 > (i7 = this.e)) {
            i6 = i7;
        }
        try {
            int i8 = super.read(bArr, i5, i6);
            this.e -= i8;
            return i8;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    public ByteBuffer readToByteBuffer(int i5) throws IOException {
        h.a("maxSize must be 0 (unlimited) or larger", i5 >= 0);
        boolean z6 = i5 > 0;
        int i6 = 32768;
        if (z6 && i5 < 32768) {
            i6 = i5;
        }
        byte[] bArr = new byte[i6];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i6);
        while (true) {
            int i7 = read(bArr);
            if (i7 == -1) {
                break;
            }
            if (z6) {
                if (i7 >= i5) {
                    byteArrayOutputStream.write(bArr, 0, i5);
                    break;
                }
                i5 -= i7;
            }
            byteArrayOutputStream.write(bArr, 0, i7);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.e = this.b - ((BufferedInputStream) this).markpos;
    }
}
