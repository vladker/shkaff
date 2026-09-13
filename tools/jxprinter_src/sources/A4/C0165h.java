package A4;

import java.io.EOFException;

/* JADX INFO: renamed from: A4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0165h implements f0 {
    @Override // A4.f0
    public k0 timeout() {
        return k0.NONE;
    }

    @Override // A4.f0
    public void write(C0169l source, long j6) throws EOFException {
        kotlin.jvm.internal.E.f(source, "source");
        source.skip(j6);
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // A4.f0, java.io.Flushable
    public final void flush() {
    }
}
