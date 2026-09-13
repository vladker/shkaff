package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B0 extends io.reactivex.O implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f4873a;
    public final long b;
    public final Object c;

    public B0(io.reactivex.B b, long j6, Object obj) {
        this.f4873a = b;
        this.b = j6;
        this.c = obj;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new C0951x0(this.f4873a, this.b, this.c, true));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        this.f4873a.subscribe(new A0(s6, this.b, this.c));
    }
}
