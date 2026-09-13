package p023d4;

import E3.g;
import F3.i;
import O3.p;
import kotlin.jvm.internal.P;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p007a4.C0306v;
import p007a4.InterfaceC0304u;
import p007a4.K0;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0603l implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3885a = 0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public C0603l(C0606m c0606m, T t6, InterfaceC0615p interfaceC0615p) {
        this.c = c0606m;
        this.d = t6;
        this.b = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        C0600k c0600k;
        I0 i1;
        C0603l c0603l;
        InterfaceC0615p interfaceC0615p;
        switch (this.f3885a) {
            case 0:
                T t6 = (T) this.d;
                C0606m c0606m = (C0606m) this.c;
                if (gVar instanceof C0600k) {
                    c0600k = (C0600k) gVar;
                    int i5 = c0600k.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0600k.c = i5 - Integer.MIN_VALUE;
                    } else {
                        c0600k = new C0600k(this, gVar);
                    }
                } else {
                    c0600k = new C0600k(this, gVar);
                }
                Object obj2 = c0600k.f3881a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0600k.c;
                if (i6 == 0) {
                    v.throwOnFailure(obj2);
                    Object objInvoke = c0606m.keySelector.invoke(obj);
                    Object obj3 = t6.f5689a;
                    if (obj3 == E.NULL || !((Boolean) c0606m.areEquivalent.invoke(obj3, objInvoke)).booleanValue()) {
                        t6.f5689a = objInvoke;
                        InterfaceC0615p interfaceC0615p2 = (InterfaceC0615p) this.b;
                        c0600k.c = 1;
                        if (interfaceC0615p2.emit(obj, c0600k) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj2);
                }
                return Q.INSTANCE;
            case 1:
                if (gVar instanceof I0) {
                    i1 = (I0) gVar;
                    int i7 = i1.e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        i1.e = i7 - Integer.MIN_VALUE;
                    } else {
                        i1 = new I0(this, gVar);
                    }
                } else {
                    i1 = new I0(this, gVar);
                }
                Object objInvoke2 = i1.c;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = i1.e;
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            obj = i1.b;
                            c0603l = i1.f3805a;
                            v.throwOnFailure(objInvoke2);
                            if (!((Boolean) objInvoke2).booleanValue()) {
                                ((P) c0603l.c).f5686a = true;
                                interfaceC0615p = (InterfaceC0615p) c0603l.b;
                                i1.f3805a = null;
                                i1.b = null;
                                i1.e = 3;
                                if (interfaceC0615p.emit(obj, i1) == coroutine_suspended2) {
                                    return coroutine_suspended2;
                                }
                            }
                        } else if (i8 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    v.throwOnFailure(objInvoke2);
                } else {
                    v.throwOnFailure(objInvoke2);
                    if (((P) this.c).f5686a) {
                        InterfaceC0615p interfaceC0615p3 = (InterfaceC0615p) this.b;
                        i1.e = 1;
                        if (interfaceC0615p3.emit(obj, i1) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } else {
                        p pVar = (p) this.d;
                        i1.f3805a = this;
                        i1.b = obj;
                        i1.e = 2;
                        objInvoke2 = pVar.invoke(obj, i1);
                        if (objInvoke2 == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                        c0603l = this;
                        if (!((Boolean) objInvoke2).booleanValue()) {
                            ((P) c0603l.c).f5686a = true;
                            interfaceC0615p = (InterfaceC0615p) c0603l.b;
                            i1.f3805a = null;
                            i1.b = null;
                            i1.e = 3;
                            if (interfaceC0615p.emit(obj, i1) == coroutine_suspended2) {
                                return coroutine_suspended2;
                            }
                        }
                    }
                }
                return Q.INSTANCE;
            default:
                T t7 = (T) this.d;
                V1 v6 = (V1) t7.f5689a;
                if (v6 != null) {
                    ((p2) v6).d(obj);
                } else {
                    M m6 = (M) this.c;
                    InterfaceC0304u interfaceC0304u = (InterfaceC0304u) this.b;
                    V1 v1MutableStateFlow = q2.MutableStateFlow(obj);
                    ((C0306v) interfaceC0304u).makeCompleting$kotlinx_coroutines_core(new X1(v1MutableStateFlow, K0.getJob(m6.getCoroutineContext())));
                    t7.f5689a = v1MutableStateFlow;
                }
                return Q.INSTANCE;
        }
    }

    public C0603l(P p6, InterfaceC0615p interfaceC0615p, p pVar) {
        this.c = p6;
        this.b = interfaceC0615p;
        this.d = pVar;
    }

    public C0603l(T t6, M m6, InterfaceC0304u interfaceC0304u) {
        this.d = t6;
        this.c = m6;
        this.b = interfaceC0304u;
    }
}
