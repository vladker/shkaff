package p023d4;

import E3.g;
import F3.i;
import kotlinx.coroutines.flow.internal.F;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0573b implements InterfaceC0612o, InterfaceC0582e {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) throws Throwable {
        C0570a c0570a;
        Throwable th;
        F f6;
        if (gVar instanceof C0570a) {
            c0570a = (C0570a) gVar;
            int i5 = c0570a.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0570a.d = i5 - Integer.MIN_VALUE;
            } else {
                c0570a = new C0570a(this, gVar);
            }
        } else {
            c0570a = new C0570a(this, gVar);
        }
        Object obj = c0570a.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0570a.d;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f6 = c0570a.f3847a;
            try {
                v.throwOnFailure(obj);
                f6.releaseIntercepted();
                return Q.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                f6.releaseIntercepted();
                throw th;
            }
        }
        v.throwOnFailure(obj);
        F f7 = new F(interfaceC0615p, c0570a.getContext());
        try {
            c0570a.f3847a = f7;
            c0570a.d = 1;
            if (collectSafely(f7, c0570a) == coroutine_suspended) {
                return coroutine_suspended;
            }
            f6 = f7;
            f6.releaseIntercepted();
            return Q.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            f6 = f7;
            f6.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object collectSafely(InterfaceC0615p interfaceC0615p, g<? super Q> gVar);
}
