package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.v1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0810v1 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final p027e3.o d;
    public final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0810v1(AbstractC0979l abstractC0979l, p027e3.o oVar, int i5, int i6) {
        super(abstractC0979l);
        this.c = i6;
        this.d = oVar;
        this.e = i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                p094q3.d dVar = p094q3.d.f7843a;
                AbstractC0979l abstractC0979l = this.b;
                boolean z6 = abstractC0979l instanceof Callable;
                p027e3.o oVar = this.d;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0804u1(cVar, oVar, this.e));
                } else {
                    try {
                        Object objCall = ((Callable) abstractC0979l).call();
                        if (objCall == null) {
                            cVar.onSubscribe(dVar);
                            cVar.onComplete();
                        } else {
                            try {
                                F1.g(cVar, ((Iterable) oVar.apply(objCall)).iterator());
                            } catch (Throwable th) {
                                p017c3.d.throwIfFatal(th);
                                cVar.onSubscribe(dVar);
                                cVar.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        cVar.onSubscribe(dVar);
                        cVar.onError(th2);
                        return;
                    }
                }
                break;
            default:
                C0687a3 c0687a3 = new C0687a3(this.e);
                try {
                    Object objApply = this.d.apply(c0687a3);
                    p039g3.A.b(objApply, "selector returned a null Publisher");
                    ((t5.b) objApply).subscribe(new C0699c3(cVar, c0687a3));
                    this.b.subscribe((InterfaceC0984q) c0687a3);
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th3);
                }
                break;
        }
    }
}
