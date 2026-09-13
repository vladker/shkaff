package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public I f8855a;
    public int b;
    public final /* synthetic */ K0 c;
    public final /* synthetic */ P0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H0(K0 k6, P0 p1, g gVar) {
        super(2, gVar);
        this.c = k6;
        this.d = p1;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new H0(this.c, this.d, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super K> gVar) {
        return ((H0) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        I i5;
        Object objB;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = this.b;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            I i7 = K.Companion;
            this.f8855a = i7;
            this.b = 1;
            Object objM1113updateSettinggIAlus = this.c.m1113updateSettinggIAlus(this.d, this);
            if (objM1113updateSettinggIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
            i5 = i7;
            objB = objM1113updateSettinggIAlus;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = this.f8855a;
            v.throwOnFailure(obj);
            objB = ((u) obj).b();
        }
        return i5.from(objB);
    }
}
