package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q0 extends AbstractC0683a implements p027e3.g {
    public final /* synthetic */ int c;
    public final p027e3.g d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Q0(AbstractC0979l abstractC0979l, p027e3.g gVar, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = gVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                boolean z6 = cVar instanceof p043h3.a;
                p027e3.g gVar = this.d;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new P0(cVar, gVar));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new O0((p043h3.a) cVar, gVar));
                }
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new Q2(cVar, this.d));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q0(AbstractC0979l abstractC0979l) {
        super(abstractC0979l);
        this.c = 1;
        this.d = this;
    }

    @Override // p027e3.g
    public void accept(Object obj) {
    }
}
