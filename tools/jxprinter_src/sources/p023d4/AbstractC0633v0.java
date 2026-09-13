package p023d4;

import F3.i;
import G3.d;
import O3.p;
import O3.q;
import p147z3.AbstractC1926f;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0633v0 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(w2 w2Var, q qVar, Throwable th, d dVar) throws Throwable {
        C0592h0 c0592h0;
        if (dVar instanceof C0592h0) {
            c0592h0 = (C0592h0) dVar;
            int i5 = c0592h0.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0592h0.c = i5 - Integer.MIN_VALUE;
            } else {
                c0592h0 = new C0592h0(dVar);
            }
        } else {
            c0592h0 = new C0592h0(dVar);
        }
        Object obj = c0592h0.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0592h0.c;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                c0592h0.f3873a = th;
                c0592h0.c = 1;
                if (qVar.invoke(w2Var, th, c0592h0) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = c0592h0.f3873a;
                v.throwOnFailure(obj);
            }
            return Q.INSTANCE;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                AbstractC1926f.addSuppressed(th2, th);
            }
            throw th2;
        }
    }

    public static final void ensureActive(InterfaceC0615p interfaceC0615p) {
        if (interfaceC0615p instanceof w2) {
            throw ((w2) interfaceC0615p).e;
        }
    }

    public static final <T> InterfaceC0612o onCompletion(InterfaceC0612o interfaceC0612o, q qVar) {
        return new C0598j0(interfaceC0612o, qVar);
    }

    public static final <T> InterfaceC0612o onEmpty(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0604l0(interfaceC0612o, pVar);
    }

    public static final <T> InterfaceC0612o onStart(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, pVar);
    }

    public static final <T, R> InterfaceC0612o transform(InterfaceC0612o interfaceC0612o, q qVar) {
        return AbstractC0618q.flow(new C0624s0(interfaceC0612o, qVar, null, 0));
    }

    public static final <T, R> InterfaceC0612o unsafeTransform(InterfaceC0612o interfaceC0612o, q qVar) {
        return new C0627t0(interfaceC0612o, qVar, 0);
    }
}
