package p023d4;

import E3.g;
import F3.i;
import O3.q;
import kotlinx.coroutines.flow.internal.F;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0598j0 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o f3878a;
    public final /* synthetic */ q b;

    public C0598j0(InterfaceC0612o interfaceC0612o, q qVar) {
        this.f3878a = interfaceC0612o;
        this.b = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007d  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) throws Throwable {
        C0595i0 c0595i0;
        C0598j0 c0598j0;
        w2 w2Var;
        q qVar;
        F f6;
        Throwable th;
        F f7;
        q qVar2;
        if (gVar instanceof C0595i0) {
            c0595i0 = (C0595i0) gVar;
            int i5 = c0595i0.b;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0595i0.b = i5 - Integer.MIN_VALUE;
            } else {
                c0595i0 = new C0595i0(this, gVar);
            }
        } else {
            c0595i0 = new C0595i0(this, gVar);
        }
        Object obj = c0595i0.f3876a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0595i0.b;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            try {
                InterfaceC0612o interfaceC0612o = this.f3878a;
                c0595i0.d = this;
                c0595i0.e = interfaceC0615p;
                c0595i0.b = 1;
                if (interfaceC0612o.collect(interfaceC0615p, c0595i0) != coroutine_suspended) {
                    c0598j0 = this;
                    f6 = new F(interfaceC0615p, c0595i0.getContext());
                    qVar2 = c0598j0.b;
                    c0595i0.d = f6;
                    c0595i0.e = null;
                    c0595i0.b = 3;
                    if (qVar2.invoke(f6, null, c0595i0) != coroutine_suspended) {
                        f7 = f6;
                        f7.releaseIntercepted();
                        return Q.INSTANCE;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                c0598j0 = this;
                w2Var = new w2(th);
                qVar = c0598j0.b;
                c0595i0.d = th;
                c0595i0.e = null;
                c0595i0.b = 2;
                if (AbstractC0633v0.a(w2Var, qVar, th, c0595i0) == coroutine_suspended) {
                    throw th;
                }
            }
            return coroutine_suspended;
        }
        if (i6 != 1) {
            if (i6 == 2) {
                Throwable th3 = (Throwable) c0595i0.d;
                v.throwOnFailure(obj);
                throw th3;
            }
            if (i6 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f7 = (F) c0595i0.d;
            try {
                v.throwOnFailure(obj);
                f7.releaseIntercepted();
                return Q.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                f7.releaseIntercepted();
                throw th;
            }
        }
        interfaceC0615p = c0595i0.e;
        c0598j0 = (C0598j0) c0595i0.d;
        try {
            v.throwOnFailure(obj);
            f6 = new F(interfaceC0615p, c0595i0.getContext());
            try {
                qVar2 = c0598j0.b;
                c0595i0.d = f6;
                c0595i0.e = null;
                c0595i0.b = 3;
                if (qVar2.invoke(f6, null, c0595i0) != coroutine_suspended) {
                    f7 = f6;
                    f7.releaseIntercepted();
                    return Q.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                f7 = f6;
                f7.releaseIntercepted();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            w2Var = new w2(th);
            qVar = c0598j0.b;
            c0595i0.d = th;
            c0595i0.e = null;
            c0595i0.b = 2;
            if (AbstractC0633v0.a(w2Var, qVar, th, c0595i0) == coroutine_suspended) {
                throw th;
            }
        }
    }
}
