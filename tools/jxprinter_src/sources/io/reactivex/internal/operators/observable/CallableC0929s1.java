package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0929s1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5278a;

    public CallableC0929s1(io.reactivex.B b) {
        this.f5278a = b;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f5278a.replay();
    }
}
