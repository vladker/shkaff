package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4507a;
    public final int b;

    public X1(AbstractC0979l abstractC0979l, int i5) {
        this.f4507a = abstractC0979l;
        this.b = i5;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f4507a.replay(this.b);
    }
}
