package L0;

import androidx.annotation.NonNull;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f397a = -1;

    @NonNull
    private final ByteBuffer byteBuffer;

    public a(@NonNull ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.byteBuffer.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i5) {
        this.f397a = this.byteBuffer.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.byteBuffer.hasRemaining()) {
            return this.byteBuffer.get() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        int i5 = this.f397a;
        if (i5 == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.byteBuffer.position(i5);
    }

    @Override // java.io.InputStream
    public final long skip(long j6) {
        if (!this.byteBuffer.hasRemaining()) {
            return -1L;
        }
        long jMin = Math.min(j6, this.byteBuffer.remaining());
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
        return jMin;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i5, int i6) {
        if (!this.byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i6, this.byteBuffer.remaining());
        this.byteBuffer.get(bArr, i5, iMin);
        return iMin;
    }
}
