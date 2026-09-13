package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X4 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final int d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ X4(AbstractC0979l abstractC0979l, Object obj, int i5, int i6) {
        super(abstractC0979l);
        this.c = i6;
        this.e = obj;
        this.d = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                W4 w6 = new W4(cVar, this.d);
                cVar.onSubscribe(w6);
                w6.b();
                ((t5.b) this.e).subscribe(w6.c);
                this.b.subscribe((InterfaceC0984q) w6);
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new c5(cVar, this.d, (Callable) this.e));
                break;
        }
    }
}
