package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3479a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ h(Runnable runnable, int i5) {
        this.f3479a = i5;
        this.b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f3479a) {
            case 0:
                return LimitedConcurrencyExecutorService.lambda$submit$1(this.b);
            default:
                return PausableExecutorServiceImpl.lambda$submit$1(this.b);
        }
    }
}
