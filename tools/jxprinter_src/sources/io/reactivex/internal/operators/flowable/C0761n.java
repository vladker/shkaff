package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0761n extends io.reactivex.O implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4707a;
    public final AbstractC0979l b;
    public final p027e3.q c;

    public /* synthetic */ C0761n(AbstractC0979l abstractC0979l, p027e3.q qVar, int i5) {
        this.f4707a = i5;
        this.b = abstractC0979l;
        this.c = qVar;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        switch (this.f4707a) {
            case 0:
                return io.reactivex.plugins.a.onAssembly(new C0749l(this.b, this.c, 0));
            default:
                return io.reactivex.plugins.a.onAssembly(new C0749l(this.b, this.c, 1));
        }
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        switch (this.f4707a) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0755m(s6, this.c, 0));
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new C0755m(s6, this.c, 1));
                break;
        }
    }
}
