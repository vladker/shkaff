package io.reactivex.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0969h extends AtomicBoolean implements Runnable, p011b3.c {
    private static final long serialVersionUID = -2421395018820541164L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5351a;

    public RunnableC0969h(Runnable runnable) {
        this.f5351a = runnable;
    }

    @Override // p011b3.c
    public final void dispose() {
        lazySet(true);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get()) {
            return;
        }
        try {
            this.f5351a.run();
        } finally {
            lazySet(true);
        }
    }
}
