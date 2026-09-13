package com.google.firebase.concurrent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3474a;
    public final /* synthetic */ DelegatingScheduledExecutorService b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ DelegatingScheduledFuture.Completer d;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i5) {
        this.f3474a = i5;
        this.b = delegatingScheduledExecutorService;
        this.c = runnable;
        this.d = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3474a) {
            case 0:
                this.b.lambda$scheduleWithFixedDelay$10(this.c, this.d);
                break;
            case 1:
                this.b.lambda$scheduleAtFixedRate$7(this.c, this.d);
                break;
            default:
                this.b.lambda$schedule$1(this.c, this.d);
                break;
        }
    }
}
