package A4;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;

/* JADX INFO: renamed from: A4.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0167j extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0169l f73a;

    public C0167j(C0169l c0169l) {
        this.f73a = c0169l;
    }

    @Override // java.io.InputStream
    public final int available() {
        return (int) Math.min(this.f73a.size(), Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream
    public final int read() {
        C0169l c0169l = this.f73a;
        if (c0169l.size() > 0) {
            return c0169l.readByte() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    public String toString() {
        return this.f73a + ".inputStream()";
    }

    @Override // java.io.InputStream
    public int read(byte[] sink, int i5, int i6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return this.f73a.read(sink, i5, i6);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
