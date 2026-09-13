package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0744k0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final io.reactivex.V d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0744k0(AbstractC0979l abstractC0979l, io.reactivex.V v6, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = v6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0738j0(cVar, this.d));
                break;
            default:
                I2 i5 = new I2(cVar);
                cVar.onSubscribe(i5);
                this.b.subscribe((InterfaceC0984q) i5);
                ((io.reactivex.O) this.d).subscribe(i5.c);
                break;
        }
    }
}
