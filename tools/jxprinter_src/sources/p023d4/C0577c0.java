package p023d4;

import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.p;
import p018c4.B;
import p018c4.D;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0577c0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3860a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ InterfaceC0615p d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0577c0(InterfaceC0615p interfaceC0615p, g gVar, int i5) {
        super(2, gVar);
        this.f3860a = i5;
        this.d = interfaceC0615p;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3860a) {
            case 0:
                C0577c0 c0577c0 = new C0577c0(this.d, gVar, 0);
                c0577c0.c = obj;
                return c0577c0;
            default:
                C0577c0 c0577c1 = new C0577c0(this.d, gVar, 1);
                c0577c1.c = obj;
                return c0577c1;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3860a) {
            case 0:
                return ((C0577c0) create(B.b(((B) obj).c()), (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((C0577c0) create(obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:33:0x0077  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC;
        Object obj2;
        Throwable thM1003exceptionOrNullimpl;
        switch (this.f3860a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    objC = ((B) this.c).c();
                    if (!(objC instanceof D)) {
                        this.c = objC;
                        this.b = 1;
                        if (this.d.emit(objC, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = objC;
                    }
                    if (objC instanceof B.a) {
                        return b.boxBoolean(true);
                    }
                    thM1003exceptionOrNullimpl = B.m1003exceptionOrNullimpl(objC);
                    if (thM1003exceptionOrNullimpl == null) {
                        return b.boxBoolean(false);
                    }
                    throw thM1003exceptionOrNullimpl;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.c;
                v.throwOnFailure(obj);
                objC = obj2;
                if (objC instanceof B.a) {
                    return b.boxBoolean(true);
                }
                thM1003exceptionOrNullimpl = B.m1003exceptionOrNullimpl(objC);
                if (thM1003exceptionOrNullimpl == null) {
                    return b.boxBoolean(false);
                }
                throw thM1003exceptionOrNullimpl;
            default:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    Object obj3 = this.c;
                    this.b = 1;
                    if (this.d.emit(obj3, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }
}
