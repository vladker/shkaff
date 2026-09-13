package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0959z0 extends AbstractC0985s implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5331a;
    public final long b;

    public C0959z0(io.reactivex.B b, long j6) {
        this.f5331a = b;
        this.b = j6;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        this.f5331a.subscribe(new C0955y0(interfaceC0988v, this.b));
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new C0951x0(this.f5331a, this.b, null, false));
    }
}
