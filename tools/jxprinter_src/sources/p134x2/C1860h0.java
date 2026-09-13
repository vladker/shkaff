package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: x2.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1860h0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public I f8903a;
    public int b;
    public final /* synthetic */ K0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1860h0(K0 k6, g gVar) {
        super(2, gVar);
        this.c = k6;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new C1860h0(this.c, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super K> gVar) {
        return ((C1860h0) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
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
            this.f8903a = i7;
            this.b = 1;
            Object objM1100getPrinterStateIoAF18A = this.c.m1100getPrinterStateIoAF18A(this);
            if (objM1100getPrinterStateIoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
            i5 = i7;
            objB = objM1100getPrinterStateIoAF18A;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = this.f8903a;
            v.throwOnFailure(obj);
            objB = ((u) obj).b();
        }
        return i5.from(objB);
    }
}
