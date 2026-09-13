package p048i3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import io.reactivex.internal.operators.flowable.C0771o3;
import io.reactivex.internal.operators.flowable.C0817w2;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.c;
import p017c3.d;
import p027e3.b;
import p027e3.o;
import p039g3.A;
import p059k3.T;
import p059k3.U;
import p059k3.s0;
import p077n3.C1262p;
import p077n3.C1263q;
import p077n3.C1267v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4062a;
    public final Object b;
    public final Object c;

    public /* synthetic */ t(S s6, Object obj, int i5) {
        this.f4062a = i5;
        this.b = s6;
        this.c = obj;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        Object objApply;
        switch (this.f4062a) {
            case 0:
                ((S) this.b).onError(th);
                break;
            case 1:
                ((S) this.b).onError(th);
                break;
            case 2:
                ((InterfaceC0988v) this.b).onError(th);
                break;
            case 3:
                ((S) this.b).onError(th);
                break;
            case 4:
                ((S) this.b).onError(th);
                break;
            case 5:
                try {
                    ((C1262p) this.c).c.accept(th);
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    th = new c(th, th2);
                }
                ((S) this.b).onError(th);
                break;
            case 6:
                try {
                    ((b) ((C0817w2) this.c).b).accept(null, th);
                } catch (Throwable th3) {
                    d.throwIfFatal(th3);
                    th = new c(th, th3);
                }
                ((S) this.b).onError(th);
                break;
            case 7:
                ((S) this.b).onError(th);
                break;
            case 8:
                try {
                    ((C1263q) this.c).c.run();
                } catch (Throwable th4) {
                    d.throwIfFatal(th4);
                    th = new c(th, th4);
                }
                ((S) this.b).onError(th);
                break;
            case 9:
                ((S) this.b).onError(th);
                break;
            case 10:
                ((S) this.b).onError(th);
                break;
            default:
                S s6 = (S) this.b;
                C0771o3 c0771o3 = (C0771o3) this.c;
                o oVar = (o) c0771o3.c;
                if (oVar != null) {
                    try {
                        objApply = oVar.apply(th);
                    } catch (Throwable th5) {
                        d.throwIfFatal(th5);
                        s6.onError(new c(th, th5));
                        return;
                    }
                } else {
                    objApply = c0771o3.d;
                }
                if (objApply != null) {
                    s6.onSuccess(objApply);
                } else {
                    NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                    nullPointerException.initCause(th);
                    s6.onError(nullPointerException);
                }
                break;
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f4062a) {
            case 0:
                p033f3.d.c((AtomicReference) this.c, cVar);
                break;
            case 1:
                p033f3.d.c((T) this.c, cVar);
                break;
            case 2:
                p033f3.d.c((U) this.c, cVar);
                break;
            case 3:
                p033f3.d.f((s0) this.c, cVar);
                break;
            case 4:
                ((S) this.b).onSubscribe(cVar);
                break;
            case 5:
                ((S) this.b).onSubscribe(cVar);
                break;
            case 6:
                ((S) this.b).onSubscribe(cVar);
                break;
            case 7:
                ((S) this.b).onSubscribe(cVar);
                break;
            case 8:
                ((S) this.b).onSubscribe(cVar);
                break;
            case 9:
                p033f3.d.c((C1267v) this.c, cVar);
                break;
            case 10:
                ((S) this.b).onSubscribe(cVar);
                break;
            default:
                ((S) this.b).onSubscribe(cVar);
                break;
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        switch (this.f4062a) {
            case 0:
                ((S) this.b).onSuccess(obj);
                break;
            case 1:
                ((S) this.b).onSuccess(obj);
                break;
            case 2:
                ((InterfaceC0988v) this.b).onSuccess(obj);
                break;
            case 3:
                ((S) this.b).onSuccess(obj);
                break;
            case 4:
                S s6 = (S) this.b;
                try {
                    C0771o3 c0771o3 = (C0771o3) this.c;
                    p027e3.d dVar = (p027e3.d) c0771o3.c;
                    Object obj2 = c0771o3.d;
                    ((V1.b) dVar).getClass();
                    s6.onSuccess(Boolean.valueOf(A.a(obj, obj2)));
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    s6.onError(th);
                    return;
                }
                break;
            case 5:
                ((S) this.b).onSuccess(obj);
                break;
            case 6:
                S s7 = (S) this.b;
                try {
                    ((b) ((C0817w2) this.c).b).accept(obj, null);
                    s7.onSuccess(obj);
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    s7.onError(th2);
                    return;
                }
                break;
            case 7:
                S s8 = (S) this.b;
                try {
                    ((C1262p) this.c).c.accept(obj);
                    s8.onSuccess(obj);
                } catch (Throwable th3) {
                    d.throwIfFatal(th3);
                    s8.onError(th3);
                    return;
                }
                break;
            case 8:
                S s9 = (S) this.b;
                try {
                    ((C1263q) this.c).c.run();
                    s9.onSuccess(obj);
                } catch (Throwable th4) {
                    d.throwIfFatal(th4);
                    s9.onError(th4);
                    return;
                }
                break;
            case 9:
                ((S) this.b).onSuccess(obj);
                break;
            case 10:
                try {
                    Object objApply = ((o) this.c).apply(obj);
                    A.b(objApply, "The mapper function returned a null value.");
                    ((S) this.b).onSuccess(objApply);
                } catch (Throwable th5) {
                    d.throwIfFatal(th5);
                    onError(th5);
                    return;
                }
                break;
            default:
                ((S) this.b).onSuccess(obj);
                break;
        }
    }

    public /* synthetic */ t(Object obj, Object obj2, int i5) {
        this.f4062a = i5;
        this.c = obj;
        this.b = obj2;
    }
}
