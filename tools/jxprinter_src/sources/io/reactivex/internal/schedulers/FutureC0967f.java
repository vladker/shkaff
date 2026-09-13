package io.reactivex.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class FutureC0967f implements Future {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p011b3.c f5349a;

    public FutureC0967f(p011b3.c cVar) {
        this.f5349a = cVar;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        this.f5349a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j6, TimeUnit timeUnit) {
        return null;
    }
}
