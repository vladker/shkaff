package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5342a;
    public final N b;
    public final long c;

    public L(Runnable runnable, N n6, long j6) {
        this.f5342a = runnable;
        this.b = n6;
        this.c = j6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.d) {
            return;
        }
        long jNow = this.b.now(TimeUnit.MILLISECONDS);
        long j6 = this.c;
        if (j6 > jNow) {
            try {
                Thread.sleep(j6 - jNow);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                io.reactivex.plugins.a.onError(e);
                return;
            }
        }
        if (this.b.d) {
            return;
        }
        this.f5342a.run();
    }
}
