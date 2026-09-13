package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final Object d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4176f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(AbstractC0979l abstractC0979l, t5.b bVar, p027e3.o oVar, Object obj, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.e = bVar;
        this.f4176f = oVar;
        this.d = obj;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                C0826y c0826y = new C0826y(cVar, (t5.b) this.e, (p027e3.o) this.f4176f, (Callable) this.d);
                cVar.onSubscribe(c0826y);
                this.b.subscribe((InterfaceC0984q) c0826y);
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new W0(cVar, (p027e3.g) this.d, (p027e3.p) this.e, (p027e3.a) this.f4176f));
                break;
            case 2:
                this.b.subscribe((InterfaceC0984q) new B2(cVar, (p027e3.o) this.f4176f, (p027e3.o) this.e, (Callable) this.d));
                break;
            default:
                t5.b bVar = (t5.b) this.e;
                p027e3.o oVar = (p027e3.o) this.f4176f;
                t5.b bVar2 = (t5.b) this.d;
                AbstractC0979l abstractC0979l = this.b;
                if (bVar2 != null) {
                    F4 f6 = new F4(oVar, bVar2, cVar);
                    cVar.onSubscribe(f6);
                    if (bVar != null) {
                        E4 e6 = new E4(0L, f6);
                        p033f3.h hVar = f6.f4239k;
                        hVar.getClass();
                        if (p033f3.d.c(hVar, e6)) {
                            bVar.subscribe(e6);
                        }
                    }
                    abstractC0979l.subscribe((InterfaceC0984q) f6);
                } else {
                    H4 h6 = new H4(cVar, oVar);
                    cVar.onSubscribe(h6);
                    if (bVar != null) {
                        E4 e7 = new E4(0L, h6);
                        p033f3.h hVar2 = h6.c;
                        hVar2.getClass();
                        if (p033f3.d.c(hVar2, e7)) {
                            bVar.subscribe(e7);
                        }
                    }
                    abstractC0979l.subscribe((InterfaceC0984q) h6);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(AbstractC0979l abstractC0979l, p027e3.g gVar, p027e3.p pVar, p027e3.a aVar) {
        super(abstractC0979l);
        this.c = 1;
        this.d = gVar;
        this.e = pVar;
        this.f4176f = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(AbstractC0979l abstractC0979l, p027e3.o oVar, p027e3.o oVar2, Callable callable) {
        super(abstractC0979l);
        this.c = 2;
        this.f4176f = oVar;
        this.e = oVar2;
        this.d = callable;
    }
}
