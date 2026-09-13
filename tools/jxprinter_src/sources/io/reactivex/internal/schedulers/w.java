package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends AbstractC0962a implements Callable {
    private static final long serialVersionUID = 1811839108042568751L;

    @Override // java.util.concurrent.Callable
    public Void call() {
        FutureTask futureTask = AbstractC0962a.c;
        this.b = Thread.currentThread();
        try {
            this.f5345a.run();
            return null;
        } finally {
            lazySet(futureTask);
            this.b = null;
        }
    }
}
