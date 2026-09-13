package A4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class A extends k0 {
    private k0 delegate;

    public A(k0 delegate) {
        kotlin.jvm.internal.E.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // A4.k0
    public final long a() {
        return this.delegate.a();
    }

    @Override // A4.k0
    public final boolean b() {
        return this.delegate.b();
    }

    @Override // A4.k0
    public final long c() {
        return this.delegate.c();
    }

    @Override // A4.k0
    public k0 clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // A4.k0
    public k0 clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // A4.k0
    public k0 deadlineNanoTime(long j6) {
        return this.delegate.deadlineNanoTime(j6);
    }

    public final k0 delegate() {
        return this.delegate;
    }

    public final A setDelegate(k0 delegate) {
        kotlin.jvm.internal.E.f(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    @Override // A4.k0
    public void throwIfReached() throws InterruptedIOException {
        this.delegate.throwIfReached();
    }

    @Override // A4.k0
    public k0 timeout(long j6, TimeUnit unit) {
        kotlin.jvm.internal.E.f(unit, "unit");
        return this.delegate.timeout(j6, unit);
    }
}
