package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.n4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0766n4 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final t5.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0766n4(AbstractC0979l abstractC0979l, t5.b bVar, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = bVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                C0760m4 c0760m4 = new C0760m4(cVar);
                cVar.onSubscribe(c0760m4);
                this.d.subscribe(c0760m4.d);
                this.b.subscribe((InterfaceC0984q) c0760m4);
                break;
            case 1:
                C0789r4 c0789r4 = new C0789r4(cVar, this.d);
                cVar.onSubscribe(c0789r4.c);
                this.b.subscribe((InterfaceC0984q) c0789r4);
                break;
            default:
                A4 a6 = new A4(cVar);
                cVar.onSubscribe(a6);
                this.d.subscribe(a6.e);
                this.b.subscribe((InterfaceC0984q) a6);
                break;
        }
    }
}
