package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U2 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final boolean d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ U2(AbstractC0979l abstractC0979l, Object obj, boolean z6, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.e = obj;
        this.d = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                T2 t6 = new T2(cVar, (p027e3.o) this.e, this.d);
                cVar.onSubscribe(t6);
                this.b.subscribe((InterfaceC0984q) t6);
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new C0706d4(cVar, this.e, this.d));
                break;
            default:
                io.reactivex.M mCreateWorker = ((io.reactivex.N) this.e).createWorker();
                RunnableC0784q4 runnableC0784q4 = new RunnableC0784q4(cVar, mCreateWorker, this.b, this.d);
                cVar.onSubscribe(runnableC0784q4);
                mCreateWorker.schedule(runnableC0784q4);
                break;
        }
    }
}
