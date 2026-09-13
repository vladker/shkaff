package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.internal.operators.observable.C0851c2;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.c;
import p017c3.d;
import p027e3.a;
import p077n3.A;

/* JADX INFO: renamed from: k3.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1044v implements InterfaceC0988v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5584a;
    public final InterfaceC0988v b;
    public final Object c;

    public /* synthetic */ C1044v(int i5, InterfaceC0988v interfaceC0988v, Object obj) {
        this.f5584a = i5;
        this.c = obj;
        this.b = interfaceC0988v;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5584a) {
            case 0:
                this.b.onComplete();
                break;
            case 1:
                InterfaceC0988v interfaceC0988v = this.b;
                try {
                    ((a) ((C0851c2) this.c).c).run();
                    interfaceC0988v.onComplete();
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0988v.onError(th);
                    return;
                }
                break;
            case 2:
                this.b.onComplete();
                break;
            case 3:
                this.b.onComplete();
                break;
            default:
                this.b.onComplete();
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5584a) {
            case 0:
                this.b.onError(th);
                break;
            case 1:
                try {
                    ((a) ((C0851c2) this.c).c).run();
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    th = new c(th, th2);
                }
                this.b.onError(th);
                break;
            case 2:
                this.b.onError(th);
                break;
            case 3:
                this.b.onError(th);
                break;
            default:
                this.b.onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5584a) {
            case 0:
                p033f3.d.c((C1045w) this.c, cVar);
                break;
            case 1:
                this.b.onSubscribe(cVar);
                break;
            case 2:
                p033f3.d.f((C1035m0) this.c, cVar);
                break;
            case 3:
                p033f3.d.f((q0) this.c, cVar);
                break;
            default:
                p033f3.d.c((A) this.c, cVar);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5584a) {
            case 0:
                this.b.onSuccess(obj);
                break;
            case 1:
                InterfaceC0988v interfaceC0988v = this.b;
                try {
                    ((a) ((C0851c2) this.c).c).run();
                    interfaceC0988v.onSuccess(obj);
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0988v.onError(th);
                    return;
                }
                break;
            case 2:
                this.b.onSuccess(obj);
                break;
            case 3:
                this.b.onSuccess(obj);
                break;
            default:
                this.b.onSuccess(obj);
                break;
        }
    }

    public /* synthetic */ C1044v(InterfaceC0988v interfaceC0988v, AtomicReference atomicReference, int i5) {
        this.f5584a = i5;
        this.b = interfaceC0988v;
        this.c = atomicReference;
    }
}
