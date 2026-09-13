package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0839a0 extends io.reactivex.O implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5142a;

    public C0839a0(io.reactivex.B b) {
        this.f5142a = b;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new Z(this.f5142a, 0));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        this.f5142a.subscribe(new Y(s6, 2));
    }
}
