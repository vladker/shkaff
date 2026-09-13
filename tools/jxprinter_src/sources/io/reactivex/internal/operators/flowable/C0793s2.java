package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.s2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0793s2 extends AbstractC0979l implements p043h3.h {
    public final Object b;

    public C0793s2(Object obj) {
        this.b = obj;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        cVar.onSubscribe(new p094q3.e(this.b, cVar));
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.b;
    }
}
