package p146z2;

import F3.i;
import G3.m;
import O3.p;
import p007a4.M;
import p134x2.O;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9119a;
    public final /* synthetic */ j b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j jVar, E3.g gVar) {
        super(2, gVar);
        this.b = jVar;
    }

    @Override // G3.a
    public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
        return new g(this.b, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, E3.g<? super Q> gVar) {
        return ((g) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1124connectInnerIoAF18A;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f9119a;
        j jVar = this.b;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            this.f9119a = 1;
            objM1124connectInnerIoAF18A = jVar.m1124connectInnerIoAF18A(this);
            if (objM1124connectInnerIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            objM1124connectInnerIoAF18A = ((u) obj).b();
        }
        if (objM1124connectInnerIoAF18A instanceof u.a) {
            O.INSTANCE.e("UsbConnection", "connect failed", u.m1362exceptionOrNullimpl(objM1124connectInnerIoAF18A));
            jVar.state = d.c;
        } else {
            jVar.state = d.b;
        }
        return Q.INSTANCE;
    }
}
