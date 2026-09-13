package p051j0;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import p007a4.M;
import p134x2.K0;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5395a;
    public int b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, g gVar, int i5) {
        super(2, gVar);
        this.f5395a = i5;
        this.c = str;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f5395a) {
            case 0:
                return new b(this.c, gVar, 0);
            default:
                return new b(this.c, gVar, 1);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        g gVar = (g) obj2;
        switch (this.f5395a) {
            case 0:
                break;
        }
        return ((b) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1114updateTimegIAlus;
        switch (this.f5395a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    f fVar = f.INSTANCE;
                    this.b = 1;
                    if (fVar.connectBluetoothDeviceAsync(this.c, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    K0 printer = f.getPrinter();
                    if (printer != null) {
                        this.b = 1;
                        objM1114updateTimegIAlus = printer.m1114updateTimegIAlus(this.c, this);
                        if (objM1114updateTimegIAlus == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    }
                    return Q.INSTANCE;
                }
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                objM1114updateTimegIAlus = ((u) obj).b();
                u.a(objM1114updateTimegIAlus);
                return Q.INSTANCE;
        }
    }
}
