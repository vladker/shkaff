package com.google.firebase.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements DelegatingScheduledFuture.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3475a;
    public final /* synthetic */ DelegatingScheduledExecutorService b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f3476f;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j6, long j7, TimeUnit timeUnit, int i5) {
        this.f3475a = i5;
        this.b = delegatingScheduledExecutorService;
        this.c = runnable;
        this.d = j6;
        this.e = j7;
        this.f3476f = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f3475a) {
            case 0:
                return this.b.lambda$scheduleAtFixedRate$8(this.c, this.d, this.e, this.f3476f, completer);
            default:
                return this.b.lambda$scheduleWithFixedDelay$11(this.c, this.d, this.e, this.f3476f, completer);
        }
    }
}
