package io.reactivex.internal.schedulers;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0968g extends AtomicReference implements Runnable, p011b3.c, io.reactivex.schedulers.a {
    private static final long serialVersionUID = -4101336210206799084L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p033f3.h f5350a;
    public final p033f3.h b;

    public RunnableC0968g(Runnable runnable) {
        super(runnable);
        this.f5350a = new p033f3.h();
        this.b = new p033f3.h();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (getAndSet(null) != null) {
            p033f3.h hVar = this.f5350a;
            hVar.getClass();
            p033f3.d.a(hVar);
            p033f3.h hVar2 = this.b;
            hVar2.getClass();
            p033f3.d.a(hVar2);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == null;
    }

    @Override // io.reactivex.schedulers.a
    public final Runnable getWrappedRunnable() {
        Runnable runnable = (Runnable) get();
        return runnable != null ? runnable : p039g3.z.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p033f3.h hVar = this.b;
        p033f3.h hVar2 = this.f5350a;
        p033f3.d dVar = p033f3.d.f3969a;
        Runnable runnable = (Runnable) get();
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                lazySet(null);
                hVar2.lazySet(dVar);
                hVar.lazySet(dVar);
            }
        }
    }
}
