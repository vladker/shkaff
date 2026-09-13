package p102s;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import kotlin.jvm.internal.T;
import p007a4.M;
import p051j0.a;
import p051j0.f;
import p134x2.K0;
import p134x2.P0;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8182a;
    public int b;
    public final /* synthetic */ T c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(T t6, g gVar, int i5) {
        super(2, gVar);
        this.f8182a = i5;
        this.c = t6;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f8182a) {
            case 0:
                return new x(this.c, gVar, 0);
            default:
                return new x(this.c, gVar, 1);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        g gVar = (g) obj2;
        switch (this.f8182a) {
            case 0:
                break;
        }
        return ((x) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1113updateSettinggIAlus;
        Object objM1113updateSettinggIAlus2;
        switch (this.f8182a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 != 0) {
                    if (i5 == 1) {
                        v.throwOnFailure(obj);
                        objM1113updateSettinggIAlus = ((u) obj).b();
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                T t6 = this.c;
                a.n((P0) t6.f5689a);
                K0 printer = f.getPrinter();
                if (printer != null) {
                    P0 p1 = (P0) t6.f5689a;
                    this.b = 1;
                    objM1113updateSettinggIAlus = printer.m1113updateSettinggIAlus(p1, this);
                    if (objM1113updateSettinggIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.b = 2;
                if (f.update_print_info_async(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
                u.a(objM1113updateSettinggIAlus);
                this.b = 2;
                if (f.update_print_info_async(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        v.throwOnFailure(obj);
                        objM1113updateSettinggIAlus2 = ((u) obj).b();
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                T t7 = this.c;
                a.n((P0) t7.f5689a);
                K0 printer2 = f.getPrinter();
                if (printer2 != null) {
                    P0 p6 = (P0) t7.f5689a;
                    this.b = 1;
                    objM1113updateSettinggIAlus2 = printer2.m1113updateSettinggIAlus(p6, this);
                    if (objM1113updateSettinggIAlus2 == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                }
                this.b = 2;
                if (f.update_print_info_async(this) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Q.INSTANCE;
                u.a(objM1113updateSettinggIAlus2);
                this.b = 2;
                if (f.update_print_info_async(this) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Q.INSTANCE;
        }
    }
}
