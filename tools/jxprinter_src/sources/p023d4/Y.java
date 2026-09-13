package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import p018c4.x0;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3842a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ InterfaceC0612o d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Y(InterfaceC0612o interfaceC0612o, g gVar, int i5) {
        super(2, gVar);
        this.f3842a = i5;
        this.d = interfaceC0612o;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3842a) {
            case 0:
                Y y6 = new Y(this.d, gVar, 0);
                y6.c = obj;
                return y6;
            case 1:
                Y y7 = new Y(this.d, gVar, 1);
                y7.c = obj;
                return y7;
            default:
                Y y8 = new Y(this.d, gVar, 2);
                y8.c = obj;
                return y8;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        x0 x0Var = (x0) obj;
        g gVar = (g) obj2;
        switch (this.f3842a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((Y) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f3842a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    X x6 = new X((x0) this.c, 0);
                    this.b = 1;
                    if (this.d.collect(x6, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 1:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    X x7 = new X((x0) this.c, 1);
                    this.b = 1;
                    if (this.d.collect(x7, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                if (i7 == 0) {
                    v.throwOnFailure(obj);
                    X x8 = new X((x0) this.c, 2);
                    this.b = 1;
                    if (this.d.collect(x8, this) == coroutine_suspended3) {
                        return coroutine_suspended3;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }
}
