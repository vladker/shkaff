package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0700c4 extends io.reactivex.O implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.b f4580a;
    public final t5.b b;
    public final p027e3.d c;
    public final int d;

    public C0700c4(t5.b bVar, t5.b bVar2, p027e3.d dVar, int i5) {
        this.f4580a = bVar;
        this.b = bVar2;
        this.c = dVar;
        this.d = i5;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        return io.reactivex.plugins.a.onAssembly(new C0790s(this.f4580a, this.b, this.c, this.d));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        C0694b4 c0694b4 = new C0694b4(s6, this.d, this.c);
        s6.onSubscribe(c0694b4);
        this.f4580a.subscribe(c0694b4.c);
        this.b.subscribe(c0694b4.d);
    }
}
