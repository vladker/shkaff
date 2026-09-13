package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.EnumC0674a;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final long d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4209f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ D0(AbstractC0979l abstractC0979l, long j6, Object obj, Object obj2, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = j6;
        this.e = obj;
        this.f4209f = obj2;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0(new p135x3.c(cVar), this.d, (TimeUnit) this.e, ((io.reactivex.N) this.f4209f).createWorker()));
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new B4(new p135x3.c(cVar), this.d, (TimeUnit) this.e, ((io.reactivex.N) this.f4209f).createWorker()));
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new P2(cVar, (p027e3.a) this.e, (EnumC0674a) this.f4209f, this.d));
                break;
        }
    }
}
