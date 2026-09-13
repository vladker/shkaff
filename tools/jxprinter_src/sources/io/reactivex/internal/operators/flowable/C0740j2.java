package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.j2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0740j2 implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4677a;

    public C0740j2(t5.c cVar) {
        this.f4677a = cVar;
    }

    @Override // p027e3.g
    public void accept(Throwable th) {
        this.f4677a.onError(th);
    }
}
