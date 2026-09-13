package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class K0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2439a;
    public final /* synthetic */ Future b;
    public final /* synthetic */ Runnable c;

    public /* synthetic */ K0(Future future, Runnable runnable, int i5) {
        this.f2439a = i5;
        this.b = future;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2439a) {
            case 0:
                Future future = this.b;
                if (!future.isDone() && !future.isCancelled()) {
                    future.cancel(true);
                    zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    Runnable runnable = this.c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    break;
                }
                break;
            default:
                Future future2 = this.b;
                if (!future2.isDone() && !future2.isCancelled()) {
                    future2.cancel(true);
                    zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    this.c.run();
                    break;
                }
                break;
        }
    }
}
