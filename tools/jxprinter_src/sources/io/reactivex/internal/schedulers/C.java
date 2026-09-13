package io.reactivex.internal.schedulers;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.M f5336a;

    public C(io.reactivex.M m6) {
        this.f5336a = m6;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        return new B(this, (G) obj);
    }
}
