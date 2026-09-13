package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3458a;
    public final /* synthetic */ Object b;

    public /* synthetic */ h(Object obj, int i5) {
        this.f3458a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3458a) {
            case 0:
                ((JdkFutureAdapters.ListenableFutureAdapter) this.b).lambda$addListener$0();
                break;
            default:
                WrappingExecutorService.lambda$wrapTask$0((Callable) this.b);
                break;
        }
    }
}
