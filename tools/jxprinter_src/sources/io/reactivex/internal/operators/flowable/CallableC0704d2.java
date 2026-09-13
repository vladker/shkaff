package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.d2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0704d2 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4592a;

    public CallableC0704d2(AbstractC0979l abstractC0979l) {
        this.f4592a = abstractC0979l;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f4592a.replay();
    }
}
