package L0;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class o extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f408a;

    public o(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f408a = Integer.MIN_VALUE;
    }

    public final long a(long j6) {
        int i5 = this.f408a;
        if (i5 == 0) {
            return -1L;
        }
        return (i5 == Integer.MIN_VALUE || j6 <= ((long) i5)) ? j6 : i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i5 = this.f408a;
        return i5 == Integer.MIN_VALUE ? super.available() : Math.min(i5, super.available());
    }

    public final void b(long j6) {
        int i5 = this.f408a;
        if (i5 == Integer.MIN_VALUE || j6 == -1) {
            return;
        }
        this.f408a = (int) (((long) i5) - j6);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i5) {
        super.mark(i5);
        this.f408a = i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i5 = super.read();
        b(1L);
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f408a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        long jA = a(j6);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i5, int i6) throws IOException {
        int iA = (int) a(i6);
        if (iA == -1) {
            return -1;
        }
        int i7 = super.read(bArr, i5, iA);
        b(i7);
        return i7;
    }
}
