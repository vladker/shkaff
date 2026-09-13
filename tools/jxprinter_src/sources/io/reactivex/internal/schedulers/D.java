package io.reactivex.internal.schedulers;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5337a;
    public final long b;
    public final TimeUnit c;

    public D(Runnable runnable, long j6, TimeUnit timeUnit) {
        this.f5337a = runnable;
        this.b = j6;
        this.c = timeUnit;
    }

    @Override // io.reactivex.internal.schedulers.G
    public final p011b3.c a(io.reactivex.M m6, InterfaceC0679f interfaceC0679f) {
        return m6.schedule(new Q0.b(this.f5337a, 20, interfaceC0679f, false), this.b, this.c);
    }
}
