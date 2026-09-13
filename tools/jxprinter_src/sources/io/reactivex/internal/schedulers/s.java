package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends io.reactivex.N {
    public static final u c = new u("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())), false);
    public final ThreadFactory b;

    public s(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return new t(this.b);
    }
}
