package y5;

import io.reactivex.B;
import io.reactivex.I;
import retrofit2.InterfaceC1613k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9047a;
    public final InterfaceC1613k b;

    public /* synthetic */ d(InterfaceC1613k interfaceC1613k, int i5) {
        this.f9047a = i5;
        this.b = interfaceC1613k;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        switch (this.f9047a) {
            case 0:
                InterfaceC1613k interfaceC1613kClone = this.b.clone();
                c cVar = new c(interfaceC1613kClone, i5);
                i5.onSubscribe(cVar);
                interfaceC1613kClone.b(cVar);
                break;
            default:
                InterfaceC1613k interfaceC1613kClone2 = this.b.clone();
                e eVar = new e(interfaceC1613kClone2);
                i5.onSubscribe(eVar);
                boolean z6 = false;
                try {
                    Object objExecute = interfaceC1613kClone2.execute();
                    if (!eVar.b) {
                        i5.onNext(objExecute);
                    }
                    if (!eVar.b) {
                        try {
                            i5.onComplete();
                            break;
                        } catch (Throwable th) {
                            th = th;
                            z6 = true;
                            p017c3.d.throwIfFatal(th);
                            if (z6) {
                                io.reactivex.plugins.a.onError(th);
                                return;
                            }
                            if (eVar.b) {
                                return;
                            }
                            try {
                                i5.onError(th);
                                return;
                            } catch (Throwable th2) {
                                p017c3.d.throwIfFatal(th2);
                                io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                break;
        }
    }
}
