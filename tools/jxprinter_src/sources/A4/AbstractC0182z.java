package A4;

/* JADX INFO: renamed from: A4.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0182z implements h0 {
    private final h0 delegate;

    public AbstractC0182z(h0 delegate) {
        kotlin.jvm.internal.E.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final h0 m132deprecated_delegate() {
        return this.delegate;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final h0 delegate() {
        return this.delegate;
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return this.delegate.read(sink, j6);
    }

    @Override // A4.h0
    public k0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
