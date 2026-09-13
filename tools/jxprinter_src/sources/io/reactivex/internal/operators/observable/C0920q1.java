package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0920q1 implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5260a;

    public C0920q1(io.reactivex.I i5) {
        this.f5260a = i5;
    }

    @Override // p027e3.g
    public void accept(Throwable th) {
        this.f5260a.onError(th);
    }
}
