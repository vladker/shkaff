package A4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Z extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f66a;

    public Z(a0 a0Var) {
        this.f66a = a0Var;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        a0 a0Var = this.f66a;
        if (a0Var.closed) {
            throw new IOException("closed");
        }
        return (int) Math.min(a0Var.bufferField.size(), Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        this.f66a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        a0 a0Var = this.f66a;
        if (a0Var.closed) {
            throw new IOException("closed");
        }
        if (a0Var.bufferField.size() == 0 && a0Var.source.read(a0Var.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return a0Var.bufferField.readByte() & UnsignedBytes.MAX_VALUE;
    }

    public String toString() {
        return this.f66a + ".inputStream()";
    }

    @Override // java.io.InputStream
    public int read(byte[] data, int i5, int i6) throws IOException {
        kotlin.jvm.internal.E.f(data, "data");
        a0 a0Var = this.f66a;
        if (!a0Var.closed) {
            AbstractC0159b.a(data.length, i5, i6);
            if (a0Var.bufferField.size() == 0 && a0Var.source.read(a0Var.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return a0Var.bufferField.read(data, i5, i6);
        }
        throw new IOException("closed");
    }
}
