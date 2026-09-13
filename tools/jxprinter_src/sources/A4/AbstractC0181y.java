package A4;

/* JADX INFO: renamed from: A4.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0181y implements f0 {
    private final f0 delegate;

    public AbstractC0181y(f0 delegate) {
        kotlin.jvm.internal.E.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final f0 m131deprecated_delegate() {
        return this.delegate;
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final f0 delegate() {
        return this.delegate;
    }

    @Override // A4.f0, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // A4.f0
    public k0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // A4.f0
    public void write(C0169l source, long j6) {
        kotlin.jvm.internal.E.f(source, "source");
        this.delegate.write(source, j6);
    }
}
