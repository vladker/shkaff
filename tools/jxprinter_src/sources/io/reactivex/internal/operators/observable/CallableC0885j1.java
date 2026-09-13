package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0885j1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5209a;
    public final int b;

    public CallableC0885j1(io.reactivex.B b, int i5) {
        this.f5209a = b;
        this.b = i5;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f5209a.replay(this.b);
    }
}
