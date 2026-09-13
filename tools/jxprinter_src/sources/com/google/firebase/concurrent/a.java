package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3471a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, Object obj2, int i5) {
        this.f3471a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3471a) {
            case 0:
                ((CustomThreadFactory) this.b).lambda$newThread$0((Runnable) this.c);
                break;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$3((Callable) this.b, (DelegatingScheduledFuture.Completer) this.c);
                break;
            default:
                ((LimitedConcurrencyExecutor) this.b).lambda$decorate$0((Runnable) this.c);
                break;
        }
    }
}
