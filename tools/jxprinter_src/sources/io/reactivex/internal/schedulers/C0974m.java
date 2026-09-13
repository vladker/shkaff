package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0974m extends io.reactivex.N {
    public static final C0974m b = new C0974m();
    public static final C0973l c = new C0973l();
    public static final p011b3.c d;

    static {
        p011b3.c cVarEmpty = p011b3.d.empty();
        d = cVarEmpty;
        cVarEmpty.dispose();
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return c;
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable) {
        runnable.run();
        return d;
    }

    @Override // io.reactivex.N
    public p011b3.c schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }
}
