package p023d4;

import E3.g;
import F3.i;
import O3.p;
import kotlin.jvm.internal.P;
import kotlinx.coroutines.flow.internal.A;
import kotlinx.coroutines.flow.internal.C1112a;
import kotlinx.coroutines.flow.internal.F;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0616p0 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3901a;
    public final /* synthetic */ InterfaceC0612o b;
    public final /* synthetic */ p c;

    public /* synthetic */ C0616p0(InterfaceC0612o interfaceC0612o, int i5, p pVar) {
        this.f3901a = i5;
        this.b = interfaceC0612o;
        this.c = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:74:0x0130  */
    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) throws Throwable {
        C0613o0 c0613o0;
        Throwable th;
        F f6;
        C0616p0 c0616p0;
        InterfaceC0615p interfaceC0615p2;
        InterfaceC0612o interfaceC0612o;
        N0 n6;
        P0 p1;
        switch (this.f3901a) {
            case 0:
                if (gVar instanceof C0613o0) {
                    c0613o0 = (C0613o0) gVar;
                    int i5 = c0613o0.b;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0613o0.b = i5 - Integer.MIN_VALUE;
                    } else {
                        c0613o0 = new C0613o0(this, gVar);
                    }
                } else {
                    c0613o0 = new C0613o0(this, gVar);
                }
                Object obj = c0613o0.f3894a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0613o0.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    F f7 = new F(interfaceC0615p, c0613o0.getContext());
                    try {
                        p pVar = this.c;
                        c0613o0.d = this;
                        c0613o0.e = interfaceC0615p;
                        c0613o0.f3895f = f7;
                        c0613o0.b = 1;
                        if (pVar.invoke(f7, c0613o0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c0616p0 = this;
                        interfaceC0615p2 = interfaceC0615p;
                        f6 = f7;
                        f6.releaseIntercepted();
                        interfaceC0612o = c0616p0.b;
                        c0613o0.d = null;
                        c0613o0.e = null;
                        c0613o0.f3895f = null;
                        c0613o0.b = 2;
                        if (interfaceC0612o.collect(interfaceC0615p2, c0613o0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        f6 = f7;
                        f6.releaseIntercepted();
                        throw th;
                    }
                } else if (i6 == 1) {
                    f6 = c0613o0.f3895f;
                    interfaceC0615p2 = c0613o0.e;
                    c0616p0 = c0613o0.d;
                    try {
                        v.throwOnFailure(obj);
                        f6.releaseIntercepted();
                        interfaceC0612o = c0616p0.b;
                        c0613o0.d = null;
                        c0613o0.e = null;
                        c0613o0.f3895f = null;
                        c0613o0.b = 2;
                        if (interfaceC0612o.collect(interfaceC0615p2, c0613o0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        f6.releaseIntercepted();
                        throw th;
                    }
                } else {
                    if (i6 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 1:
                Object objCollect = this.b.collect(new C0603l(new P(), interfaceC0615p, this.c), gVar);
                return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
            case 2:
                if (gVar instanceof N0) {
                    n6 = (N0) gVar;
                    int i7 = n6.b;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        n6.b = i7 - Integer.MIN_VALUE;
                    } else {
                        n6 = new N0(this, gVar);
                    }
                } else {
                    n6 = new N0(this, gVar);
                }
                Object obj2 = n6.f3816a;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = n6.b;
                if (i8 != 0) {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p1 = n6.d;
                    try {
                        v.throwOnFailure(obj2);
                    } catch (C1112a e) {
                        e = e;
                        A.checkOwnership(e, p1);
                    }
                    break;
                } else {
                    v.throwOnFailure(obj2);
                    InterfaceC0612o interfaceC0612o2 = this.b;
                    P0 p6 = new P0(interfaceC0615p, this.c);
                    try {
                        n6.d = p6;
                        n6.b = 1;
                        if (interfaceC0612o2.collect(p6, n6) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } catch (C1112a e6) {
                        e = e6;
                        p1 = p6;
                        A.checkOwnership(e, p1);
                    }
                }
                return Q.INSTANCE;
            case 3:
                Object objCollect2 = this.b.collect(new P0(interfaceC0615p, this.c, 1), gVar);
                return objCollect2 == i.getCOROUTINE_SUSPENDED() ? objCollect2 : Q.INSTANCE;
            case 4:
                Object objCollect3 = this.b.collect(new P0(interfaceC0615p, this.c, 2), gVar);
                return objCollect3 == i.getCOROUTINE_SUSPENDED() ? objCollect3 : Q.INSTANCE;
            case 5:
                Object objCollect4 = this.b.collect(new P0(interfaceC0615p, this.c, 3), gVar);
                return objCollect4 == i.getCOROUTINE_SUSPENDED() ? objCollect4 : Q.INSTANCE;
            case 6:
                Object objCollect5 = this.b.collect(new P0(interfaceC0615p, this.c, 4), gVar);
                return objCollect5 == i.getCOROUTINE_SUSPENDED() ? objCollect5 : Q.INSTANCE;
            case 7:
                Object objCollect6 = this.b.collect(new P0(interfaceC0615p, this.c, 5), gVar);
                return objCollect6 == i.getCOROUTINE_SUSPENDED() ? objCollect6 : Q.INSTANCE;
            case 8:
                Object objCollect7 = this.b.collect(new P0(interfaceC0615p, this.c, 6), gVar);
                return objCollect7 == i.getCOROUTINE_SUSPENDED() ? objCollect7 : Q.INSTANCE;
            default:
                Object objCollect8 = this.b.collect(new P0(interfaceC0615p, this.c, 7), gVar);
                return objCollect8 == i.getCOROUTINE_SUSPENDED() ? objCollect8 : Q.INSTANCE;
        }
    }

    public C0616p0(InterfaceC0612o interfaceC0612o, p pVar) {
        this.f3901a = 0;
        this.c = pVar;
        this.b = interfaceC0612o;
    }
}
