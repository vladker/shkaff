package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F1 extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4939a;
    public final io.reactivex.B b;

    public /* synthetic */ F1(io.reactivex.B b, int i5) {
        this.f4939a = i5;
        this.b = b;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.f4939a) {
            case 0:
                this.b.subscribe(new E1(interfaceC0988v, 0));
                break;
            default:
                this.b.subscribe(new C0909o0(interfaceC0988v));
                break;
        }
    }
}
