package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.r1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0924r1 implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5268a;

    public C0924r1(io.reactivex.I i5) {
        this.f5268a = i5;
    }

    @Override // p027e3.g
    public void accept(Object obj) {
        this.f5268a.onNext(obj);
    }
}
