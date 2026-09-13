package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0720g0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final InterfaceC0682i d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0720g0(AbstractC0979l abstractC0979l, InterfaceC0682i interfaceC0682i, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = interfaceC0682i;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0714f0(cVar, this.d));
                break;
            default:
                E2 e6 = new E2(cVar);
                cVar.onSubscribe(e6);
                this.b.subscribe((InterfaceC0984q) e6);
                ((AbstractC0676c) this.d).subscribe(e6.c);
                break;
        }
    }
}
