package A4;

import java.io.OutputStream;

/* JADX INFO: renamed from: A4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0168k extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0169l f74a;

    public C0168k(C0169l c0169l) {
        this.f74a = c0169l;
    }

    public String toString() {
        return this.f74a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i5) {
        this.f74a.writeByte(i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int i5, int i6) {
        kotlin.jvm.internal.E.f(data, "data");
        this.f74a.write(data, i5, i6);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }
}
