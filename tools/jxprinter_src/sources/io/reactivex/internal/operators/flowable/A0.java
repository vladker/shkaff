package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final p027e3.o d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A0(AbstractC0979l abstractC0979l, p027e3.o oVar, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = oVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0833z0(new p135x3.c(cVar), this.d));
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new J0(cVar, this.d, 0));
                break;
            case 2:
                boolean z6 = cVar instanceof p043h3.a;
                p027e3.o oVar = this.d;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new A2(cVar, oVar));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0835z2((p043h3.a) cVar, oVar));
                }
                break;
            case 3:
                this.b.subscribe((InterfaceC0984q) new V2(cVar, this.d));
                break;
            case 4:
                p135x3.c cVar2 = new p135x3.c(cVar);
                p123v3.a serialized = p123v3.d.create(8).toSerialized();
                try {
                    Object objApply = this.d.apply(serialized);
                    p039g3.A.b(objApply, "handler returned a null Publisher");
                    t5.b bVar = (t5.b) objApply;
                    C0812v3 c0812v3 = new C0812v3(this.b);
                    C0806u3 c0806u3 = new C0806u3(cVar2, serialized, c0812v3);
                    c0812v3.d = c0806u3;
                    cVar.onSubscribe(c0806u3);
                    bVar.subscribe(c0812v3);
                    c0812v3.onNext(0);
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th);
                    return;
                }
                break;
            default:
                p135x3.c cVar3 = new p135x3.c(cVar);
                p123v3.a serialized2 = p123v3.d.create(8).toSerialized();
                try {
                    Object objApply2 = this.d.apply(serialized2);
                    p039g3.A.b(objApply2, "handler returned a null Publisher");
                    t5.b bVar2 = (t5.b) objApply2;
                    C0812v3 c0812v4 = new C0812v3(this.b);
                    O3 o6 = new O3(cVar3, serialized2, c0812v4);
                    c0812v4.d = o6;
                    cVar.onSubscribe(o6);
                    bVar2.subscribe(c0812v4);
                    c0812v4.onNext(0);
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th2);
                }
                break;
        }
    }
}
