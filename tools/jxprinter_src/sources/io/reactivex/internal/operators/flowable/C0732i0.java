package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0732i0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final io.reactivex.y d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0732i0(AbstractC0979l abstractC0979l, io.reactivex.y yVar, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = yVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0726h0(cVar, this.d));
                break;
            default:
                G2 g6 = new G2(cVar);
                cVar.onSubscribe(g6);
                this.b.subscribe((InterfaceC0984q) g6);
                ((AbstractC0985s) this.d).subscribe(g6.c);
                break;
        }
    }
}
