package p023d4;

import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.p;
import O3.r;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0645z0 extends m implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3933a;
    public /* synthetic */ Throwable b;
    public /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ p e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0645z0(long j6, p pVar, g gVar) {
        super(4, gVar);
        this.d = j6;
        this.e = pVar;
    }

    @Override // O3.r
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        long jLongValue = ((Number) obj3).longValue();
        C0645z0 c0645z0 = new C0645z0(this.d, this.e, (g) obj4);
        c0645z0.b = (Throwable) obj2;
        c0645z0.c = jLongValue;
        return c0645z0.invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f3933a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            Throwable th = this.b;
            if (this.c < this.d) {
                this.f3933a = 1;
                obj = this.e.invoke(th, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return b.boxBoolean(z);
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        boolean z6 = ((Boolean) obj).booleanValue();
        return b.boxBoolean(z6);
    }
}
