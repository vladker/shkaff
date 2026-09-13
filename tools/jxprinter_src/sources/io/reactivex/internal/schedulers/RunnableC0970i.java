package io.reactivex.internal.schedulers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0970i extends AtomicInteger implements Runnable, p011b3.c {
    private static final long serialVersionUID = -3603436687413320876L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5352a;
    public final p033f3.c b;
    public volatile Thread c;

    public RunnableC0970i(Runnable runnable, p033f3.c cVar) {
        this.f5352a = runnable;
        this.b = cVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        while (true) {
            int i5 = get();
            if (i5 >= 2) {
                return;
            }
            if (i5 == 0) {
                if (compareAndSet(0, 4)) {
                    p033f3.c cVar = this.b;
                    if (cVar != null) {
                        cVar.delete(this);
                        return;
                    }
                    return;
                }
            } else if (compareAndSet(1, 3)) {
                Thread thread = this.c;
                if (thread != null) {
                    thread.interrupt();
                    this.c = null;
                }
                set(4);
                p033f3.c cVar2 = this.b;
                if (cVar2 != null) {
                    cVar2.delete(this);
                    return;
                }
                return;
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() >= 2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() == 0) {
            this.c = Thread.currentThread();
            if (!compareAndSet(0, 1)) {
                this.c = null;
                return;
            }
            try {
                this.f5352a.run();
                this.c = null;
                if (compareAndSet(1, 2)) {
                }
            } finally {
                this.c = null;
                if (compareAndSet(1, 2)) {
                    p033f3.c cVar = this.b;
                    if (cVar != null) {
                        cVar.delete(this);
                    }
                } else {
                    while (get() == 3) {
                        Thread.yield();
                    }
                    Thread.interrupted();
                }
            }
        }
    }
}
