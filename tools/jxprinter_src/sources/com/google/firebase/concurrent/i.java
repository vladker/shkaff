package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3480a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ Object c;

    public /* synthetic */ i(Object obj, int i5, Runnable runnable) {
        this.f3480a = i5;
        this.b = runnable;
        this.c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f3480a) {
            case 0:
                return LimitedConcurrencyExecutorService.lambda$submit$0(this.b, this.c);
            default:
                return PausableExecutorServiceImpl.lambda$submit$0(this.b, this.c);
        }
    }
}
