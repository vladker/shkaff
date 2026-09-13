package A4;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class X extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f65a;

    public X(Y y6) {
        this.f65a = y6;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.f65a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        Y y6 = this.f65a;
        if (y6.closed) {
            return;
        }
        y6.flush();
    }

    public String toString() {
        return this.f65a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i5) throws IOException {
        Y y6 = this.f65a;
        if (y6.closed) {
            throw new IOException("closed");
        }
        y6.bufferField.writeByte((int) ((byte) i5));
        y6.emitCompleteSegments();
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int i5, int i6) throws IOException {
        kotlin.jvm.internal.E.f(data, "data");
        Y y6 = this.f65a;
        if (!y6.closed) {
            y6.bufferField.write(data, i5, i6);
            y6.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }
}
