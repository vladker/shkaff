package p023d4;

import E3.g;
import F3.i;
import O3.q;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.t0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0627t0 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3913a;
    public final /* synthetic */ InterfaceC0612o b;
    public final /* synthetic */ q c;

    public /* synthetic */ C0627t0(InterfaceC0612o interfaceC0612o, q qVar, int i5) {
        this.f3913a = i5;
        this.b = interfaceC0612o;
        this.c = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) throws Throwable {
        C0636w0 c0636w0;
        C0627t0 c0627t0;
        switch (this.f3913a) {
            case 0:
                Object objCollect = this.b.collect(new C0621r0(this.c, interfaceC0615p, 1), gVar);
                return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
            case 1:
                if (gVar instanceof C0636w0) {
                    c0636w0 = (C0636w0) gVar;
                    int i5 = c0636w0.b;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0636w0.b = i5 - Integer.MIN_VALUE;
                    } else {
                        c0636w0 = new C0636w0(this, gVar);
                    }
                } else {
                    c0636w0 = new C0636w0(this, gVar);
                }
                Object objCatchImpl = c0636w0.f3920a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0636w0.b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        interfaceC0615p = c0636w0.e;
                        c0627t0 = c0636w0.d;
                        v.throwOnFailure(objCatchImpl);
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(objCatchImpl);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(objCatchImpl);
                c0636w0.d = this;
                c0636w0.e = interfaceC0615p;
                c0636w0.b = 1;
                objCatchImpl = AbstractC0618q.catchImpl(this.b, interfaceC0615p, c0636w0);
                if (objCatchImpl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c0627t0 = this;
                Throwable th = (Throwable) objCatchImpl;
                if (th != null) {
                    q qVar = c0627t0.c;
                    c0636w0.d = null;
                    c0636w0.e = null;
                    c0636w0.b = 2;
                    if (qVar.invoke(interfaceC0615p, th, c0636w0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Q.INSTANCE;
            default:
                T t6 = new T();
                t6.f5689a = E.NULL;
                Object objCollect2 = this.b.collect(new H1(t6, this.c, interfaceC0615p, 1), gVar);
                return objCollect2 == i.getCOROUTINE_SUSPENDED() ? objCollect2 : Q.INSTANCE;
        }
    }
}
