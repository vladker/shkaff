package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0973l extends io.reactivex.M {
    @Override // p011b3.c
    public final boolean e() {
        return false;
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable) {
        runnable.run();
        return C0974m.d;
    }

    @Override // io.reactivex.M
    public p011b3.c schedulePeriodically(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // p011b3.c
    public final void dispose() {
    }
}
