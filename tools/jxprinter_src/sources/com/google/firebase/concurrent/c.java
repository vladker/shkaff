package com.google.firebase.concurrent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3473a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ DelegatingScheduledFuture.Completer c;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i5) {
        this.f3473a = i5;
        this.b = runnable;
        this.c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.f3473a) {
            case 0:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.b, this.c);
                break;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$0(this.b, this.c);
                break;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.b, this.c);
                break;
        }
    }
}
