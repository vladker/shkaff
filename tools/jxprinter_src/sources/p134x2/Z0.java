package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import kotlin.jvm.internal.E;
import p007a4.InterfaceC0304u;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8889a;
    public final /* synthetic */ InterfaceC0304u b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(InterfaceC0304u interfaceC0304u, g gVar) {
        super(2, gVar);
        this.b = interfaceC0304u;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new Z0(this.b, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super u> gVar) {
        return ((Z0) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1361constructorimpl;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f8889a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            this.f8889a = 1;
            obj = this.b.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        Object objB = ((u) obj).b();
        if (objB instanceof u.a) {
            objM1361constructorimpl = u.m1361constructorimpl(objB);
        } else {
            byte[] bArr = (byte[]) objB;
            E.c(bArr);
            objM1361constructorimpl = u.m1361constructorimpl(bArr);
        }
        return u.a(objM1361constructorimpl);
    }
}
