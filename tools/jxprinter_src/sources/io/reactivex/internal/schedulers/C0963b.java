package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0963b extends io.reactivex.M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p033f3.f f5346a;
    public final p011b3.b b;
    public final p033f3.f c;
    public final C0965d d;
    public volatile boolean e;

    public C0963b(C0965d c0965d) {
        this.d = c0965d;
        p033f3.f fVar = new p033f3.f();
        this.f5346a = fVar;
        p011b3.b bVar = new p011b3.b();
        this.b = bVar;
        p033f3.f fVar2 = new p033f3.f();
        this.c = fVar2;
        fVar2.add(fVar);
        fVar2.add(bVar);
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.c.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e;
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable) {
        return this.e ? p033f3.e.f3970a : this.d.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.f5346a);
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        if (this.e) {
            return p033f3.e.f3970a;
        }
        return this.d.scheduleActual(runnable, j6, timeUnit, this.b);
    }
}
