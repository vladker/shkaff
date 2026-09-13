package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import p007a4.AbstractC0261a0;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3846a;
    public int b;
    public final /* synthetic */ long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z0(long j6, g gVar, int i5) {
        super(2, gVar);
        this.f3846a = i5;
        this.c = j6;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3846a) {
            case 0:
                return new Z0(this.c, gVar, 0);
            default:
                return new Z0(this.c, gVar, 1);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3846a) {
            case 0:
                return ((Z0) create(obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((Z0) create((InterfaceC0615p) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f3846a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    this.b = 1;
                    if (AbstractC0261a0.delay(this.c, this) == coroutine_suspended) {
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
                    this.b = 1;
                    if (AbstractC0261a0.delay(this.c, this) == coroutine_suspended2) {
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
