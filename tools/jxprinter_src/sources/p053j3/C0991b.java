package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.S;
import io.reactivex.internal.operators.flowable.C0771o3;
import io.reactivex.internal.schedulers.B;
import java.util.concurrent.Callable;
import p017c3.c;
import p017c3.d;
import p027e3.g;
import p027e3.q;

/* JADX INFO: renamed from: j3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0991b implements InterfaceC0679f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5427a;
    public final Object b;
    public final Object c;

    public /* synthetic */ C0991b(Object obj, InterfaceC0679f interfaceC0679f, int i5) {
        this.f5427a = i5;
        this.c = obj;
        this.b = interfaceC0679f;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        Object objCall;
        switch (this.f5427a) {
            case 0:
                ((InterfaceC0679f) this.b).onComplete();
                break;
            case 1:
                InterfaceC0679f interfaceC0679f = (InterfaceC0679f) this.b;
                try {
                    ((g) ((B) this.c).c).accept(null);
                    interfaceC0679f.onComplete();
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0679f.onError(th);
                    return;
                }
                break;
            case 2:
                ((InterfaceC0679f) this.b).onComplete();
                break;
            default:
                S s6 = (S) this.c;
                C0771o3 c0771o3 = (C0771o3) this.b;
                Callable callable = (Callable) c0771o3.c;
                if (callable != null) {
                    try {
                        objCall = callable.call();
                    } catch (Throwable th2) {
                        d.throwIfFatal(th2);
                        s6.onError(th2);
                        return;
                    }
                } else {
                    objCall = c0771o3.d;
                }
                if (objCall != null) {
                    s6.onSuccess(objCall);
                } else {
                    s6.onError(new NullPointerException("The value supplied is null"));
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        switch (this.f5427a) {
            case 0:
                ((InterfaceC0679f) this.b).onError(th);
                break;
            case 1:
                try {
                    ((g) ((B) this.c).c).accept(th);
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    th = new c(th, th2);
                }
                ((InterfaceC0679f) this.b).onError(th);
                break;
            case 2:
                InterfaceC0679f interfaceC0679f = (InterfaceC0679f) this.b;
                try {
                    if (!((q) ((B) this.c).c).test(th)) {
                        interfaceC0679f.onError(th);
                    } else {
                        interfaceC0679f.onComplete();
                    }
                } catch (Throwable th3) {
                    d.throwIfFatal(th3);
                    interfaceC0679f.onError(new c(th, th3));
                    return;
                }
                break;
            default:
                ((S) this.c).onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5427a) {
            case 0:
                p033f3.d.c((C0992c) this.c, cVar);
                break;
            case 1:
                ((InterfaceC0679f) this.b).onSubscribe(cVar);
                break;
            case 2:
                ((InterfaceC0679f) this.b).onSubscribe(cVar);
                break;
            default:
                ((S) this.c).onSubscribe(cVar);
                break;
        }
    }

    public C0991b(C0771o3 c0771o3, S s6) {
        this.f5427a = 3;
        this.b = c0771o3;
        this.c = s6;
    }
}
