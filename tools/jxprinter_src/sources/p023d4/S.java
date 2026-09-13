package p023d4;

import A3.C0133b0;
import E3.g;
import F3.i;
import O3.p;
import V3.c;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.T;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3829a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ S(Object obj, Object obj2, int i5) {
        this.f3829a = i5;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:78:0x011a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        Q q6;
        S s6;
        C0642y0 c0642y0;
        Throwable th;
        S s7;
        C0646z1 c0646z1;
        J1 j1;
        switch (this.f3829a) {
            case 0:
                if (gVar instanceof Q) {
                    q6 = (Q) gVar;
                    int i5 = q6.d;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        q6.d = i5 - Integer.MIN_VALUE;
                    } else {
                        q6 = new Q(this, gVar);
                    }
                } else {
                    q6 = new Q(this, gVar);
                }
                Object objInvoke = q6.b;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = q6.d;
                if (i6 == 0) {
                    v.throwOnFailure(objInvoke);
                    p pVar = (p) this.b;
                    q6.f3824a = this;
                    q6.d = 1;
                    objInvoke = pVar.invoke(obj, q6);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    s6 = this;
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s6 = q6.f3824a;
                    v.throwOnFailure(objInvoke);
                }
                if (((Boolean) objInvoke).booleanValue()) {
                    ((Q) s6.c).f5687a++;
                }
                return p147z3.Q.INSTANCE;
            case 1:
                if (gVar instanceof C0642y0) {
                    c0642y0 = (C0642y0) gVar;
                    int i7 = c0642y0.d;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0642y0.d = i7 - Integer.MIN_VALUE;
                    } else {
                        c0642y0 = new C0642y0(this, gVar);
                    }
                } else {
                    c0642y0 = new C0642y0(this, gVar);
                }
                Object obj2 = c0642y0.b;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = c0642y0.d;
                if (i8 != 0) {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s7 = c0642y0.f3928a;
                    try {
                        v.throwOnFailure(obj2);
                        return p147z3.Q.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        ((T) s7.c).f5689a = th;
                        throw th;
                    }
                }
                v.throwOnFailure(obj2);
                try {
                    InterfaceC0615p interfaceC0615p = (InterfaceC0615p) this.b;
                    try {
                        c0642y0.f3928a = this;
                        c0642y0.d = 1;
                        if (interfaceC0615p.emit(obj, c0642y0) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                        return p147z3.Q.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        s7 = this;
                        ((T) s7.c).f5689a = th;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                break;
            case 2:
                if (gVar instanceof C0646z1) {
                    c0646z1 = (C0646z1) gVar;
                    int i9 = c0646z1.b;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        c0646z1.b = i9 - Integer.MIN_VALUE;
                    } else {
                        c0646z1 = new C0646z1(this, gVar);
                    }
                } else {
                    c0646z1 = new C0646z1(this, gVar);
                }
                Object obj3 = c0646z1.f3934a;
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i10 = c0646z1.b;
                if (i10 == 0) {
                    v.throwOnFailure(obj3);
                    InterfaceC0615p interfaceC0615p2 = (InterfaceC0615p) this.b;
                    if (((c) this.c).isInstance(obj)) {
                        c0646z1.b = 1;
                        if (interfaceC0615p2.emit(obj, c0646z1) == coroutine_suspended3) {
                            return coroutine_suspended3;
                        }
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj3);
                }
                return p147z3.Q.INSTANCE;
            default:
                if (gVar instanceof J1) {
                    j1 = (J1) gVar;
                    int i11 = j1.c;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        j1.c = i11 - Integer.MIN_VALUE;
                    } else {
                        j1 = new J1(this, gVar);
                    }
                } else {
                    j1 = new J1(this, gVar);
                }
                Object obj4 = j1.f3808a;
                Object coroutine_suspended4 = i.getCOROUTINE_SUSPENDED();
                int i12 = j1.c;
                if (i12 == 0) {
                    v.throwOnFailure(obj4);
                    InterfaceC0615p interfaceC0615p3 = (InterfaceC0615p) this.b;
                    Q q7 = (Q) this.c;
                    int i13 = q7.f5687a;
                    q7.f5687a = i13 + 1;
                    if (i13 < 0) {
                        throw new ArithmeticException("Index overflow has happened");
                    }
                    C0133b0 c0133b0 = new C0133b0(i13, obj);
                    j1.c = 1;
                    if (interfaceC0615p3.emit(c0133b0, j1) == coroutine_suspended4) {
                        return coroutine_suspended4;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj4);
                }
                return p147z3.Q.INSTANCE;
        }
    }
}
