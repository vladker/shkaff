package p023d4;

import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.p;
import p007a4.M;
import p051j0.a;
import p051j0.f;
import p134x2.E;
import p134x2.K0;
import p134x2.P0;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: d4.u1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0631u1 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3916a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0631u1(int i5, g gVar, int i6) {
        super(i5, gVar);
        this.f3916a = i6;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3916a) {
            case 0:
                C0631u1 c0631u1 = new C0631u1(2, gVar, 0);
                c0631u1.b = ((Number) obj).intValue();
                return c0631u1;
            case 1:
                return new C0631u1(2, gVar, 1);
            case 2:
                return new C0631u1(2, gVar, 2);
            case 3:
                return new C0631u1(2, gVar, 3);
            case 4:
                return new C0631u1(2, gVar, 4);
            case 5:
                return new C0631u1(2, gVar, 5);
            default:
                return new C0631u1(2, gVar, 6);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3916a) {
            case 0:
                return ((C0631u1) create(Integer.valueOf(((Number) obj).intValue()), (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 1:
                return ((C0631u1) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 2:
                return ((C0631u1) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 3:
                return ((C0631u1) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 4:
                return ((C0631u1) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 5:
                return ((C0631u1) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((C0631u1) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:88:0x0142  */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        u uVarA;
        Object objM1099getPrinterInfoIoAF18A;
        u uVarA2;
        Object objM1099getPrinterInfoIoAF18A2;
        Object objM1104resetPrinterIoAF18A;
        Object objM1105selfCheckIoAF18A;
        switch (this.f3916a) {
            case 0:
                i.getCOROUTINE_SUSPENDED();
                v.throwOnFailure(obj);
                return b.boxBoolean(this.b > 0);
            case 1:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    E e = E.INSTANCE;
                    this.b = 1;
                    if (e.disconnectDevice(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 2:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    if (a.h() != null) {
                        return a.h();
                    }
                    K0 printer = E.getPrinter();
                    if (printer != null) {
                        this.b = 1;
                        objM1099getPrinterInfoIoAF18A = printer.m1099getPrinterInfoIoAF18A(this);
                        if (objM1099getPrinterInfoIoAF18A == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } else {
                        uVarA = null;
                    }
                    if (uVarA != null && !(uVarA.b() instanceof u.a)) {
                        Object objB = uVarA.b();
                        Object obj2 = objB instanceof u.a ? null : objB;
                        kotlin.jvm.internal.E.c(obj2);
                        a.n((P0) obj2);
                    }
                    return a.h();
                }
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                objM1099getPrinterInfoIoAF18A = ((u) obj).b();
                uVarA = u.a(objM1099getPrinterInfoIoAF18A);
                if (uVarA != null) {
                    Object objB2 = uVarA.b();
                    if (objB2 instanceof u.a) {
                    }
                    kotlin.jvm.internal.E.c(obj2);
                    a.n((P0) obj2);
                }
                return a.h();
            case 3:
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                if (i7 == 0) {
                    v.throwOnFailure(obj);
                    K0 printer2 = E.getPrinter();
                    if (printer2 != null) {
                        this.b = 1;
                        objM1099getPrinterInfoIoAF18A2 = printer2.m1099getPrinterInfoIoAF18A(this);
                        if (objM1099getPrinterInfoIoAF18A2 == coroutine_suspended3) {
                            return coroutine_suspended3;
                        }
                    } else {
                        uVarA2 = null;
                    }
                    if (uVarA2 != null && !(uVarA2.b() instanceof u.a)) {
                        Object objB3 = uVarA2.b();
                        Object obj3 = objB3 instanceof u.a ? null : objB3;
                        kotlin.jvm.internal.E.c(obj3);
                        a.n((P0) obj3);
                    }
                    return a.h();
                }
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                objM1099getPrinterInfoIoAF18A2 = ((u) obj).b();
                uVarA2 = u.a(objM1099getPrinterInfoIoAF18A2);
                if (uVarA2 != null) {
                    Object objB4 = uVarA2.b();
                    if (objB4 instanceof u.a) {
                    }
                    kotlin.jvm.internal.E.c(obj3);
                    a.n((P0) obj3);
                }
                return a.h();
            case 4:
                Object coroutine_suspended4 = i.getCOROUTINE_SUSPENDED();
                int i8 = this.b;
                if (i8 == 0) {
                    v.throwOnFailure(obj);
                    E e6 = E.INSTANCE;
                    this.b = 1;
                    if (e6.disconnectDevice(this) == coroutine_suspended4) {
                        return coroutine_suspended4;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 5:
                Object coroutine_suspended5 = i.getCOROUTINE_SUSPENDED();
                int i9 = this.b;
                if (i9 == 0) {
                    v.throwOnFailure(obj);
                    K0 printer3 = f.getPrinter();
                    if (printer3 != null) {
                        this.b = 1;
                        objM1104resetPrinterIoAF18A = printer3.m1104resetPrinterIoAF18A(this);
                        if (objM1104resetPrinterIoAF18A == coroutine_suspended5) {
                            return coroutine_suspended5;
                        }
                    }
                    return Q.INSTANCE;
                }
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                objM1104resetPrinterIoAF18A = ((u) obj).b();
                u.a(objM1104resetPrinterIoAF18A);
                return Q.INSTANCE;
            default:
                Object coroutine_suspended6 = i.getCOROUTINE_SUSPENDED();
                int i10 = this.b;
                if (i10 == 0) {
                    v.throwOnFailure(obj);
                    K0 printer4 = f.getPrinter();
                    if (printer4 != null) {
                        this.b = 1;
                        objM1105selfCheckIoAF18A = printer4.m1105selfCheckIoAF18A(this);
                        if (objM1105selfCheckIoAF18A == coroutine_suspended6) {
                            return coroutine_suspended6;
                        }
                    }
                    return Q.INSTANCE;
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                objM1105selfCheckIoAF18A = ((u) obj).b();
                u.a(objM1105selfCheckIoAF18A);
                return Q.INSTANCE;
        }
    }
}
