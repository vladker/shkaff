package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4211a;

    public D3(int i5) {
        this.f4211a = i5;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return new I3(this.f4211a);
    }
}
