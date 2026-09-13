package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.u3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0806u3 extends AbstractC0818w3 {
    private static final long serialVersionUID = -2680129890138081029L;

    @Override // t5.c
    public final void onComplete() {
        f(0);
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0818w3, t5.c
    public final void onError(Throwable th) {
        this.f4819k.cancel();
        this.f4817i.onError(th);
    }
}
