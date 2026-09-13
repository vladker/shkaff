package io.reactivex.internal.operators.flowable;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K1 implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f4318a;

    public K1(ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.f4318a = concurrentLinkedQueue;
    }

    @Override // p027e3.g
    public void accept(Object obj) {
        this.f4318a.offer((M1) obj);
    }
}
