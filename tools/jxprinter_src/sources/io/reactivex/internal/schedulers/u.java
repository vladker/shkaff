package io.reactivex.internal.schedulers;

import A3.AbstractC0157z;
import A4.C0161d;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5364a;
    public final int b;
    public final boolean c;

    public u(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f5364a + '-' + incrementAndGet();
        Thread c0161d = this.c ? new C0161d(str, runnable) : new Thread(runnable, str);
        c0161d.setPriority(this.b);
        c0161d.setDaemon(true);
        return c0161d;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return AbstractC0157z.s(new StringBuilder("RxThreadFactory["), this.f5364a, "]");
    }

    public u(String str, int i5, boolean z6) {
        this.f5364a = str;
        this.b = i5;
        this.c = z6;
    }
}
