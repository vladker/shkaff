package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.q;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q1 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3826a;
    public int b;
    public /* synthetic */ Object[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Q1(int i5, g gVar, int i6) {
        super(i5, gVar);
        this.f3826a = i6;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object[] objArr = (Object[]) obj2;
        g gVar = (g) obj3;
        switch (this.f3826a) {
            case 0:
                Q1 q6 = new Q1(3, gVar, 0);
                q6.c = objArr;
                return q6.invokeSuspend(Q.INSTANCE);
            case 1:
                Q1 q7 = new Q1(3, gVar, 1);
                q7.c = objArr;
                return q7.invokeSuspend(Q.INSTANCE);
            default:
                Q1 q8 = new Q1(3, gVar, 2);
                q8.c = objArr;
                return q8.invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f3826a;
        i.getCOROUTINE_SUSPENDED();
        switch (i5) {
            case 0:
                int i6 = this.b;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                Object[] objArr = this.c;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.b = 1;
                throw null;
            case 1:
                int i7 = this.b;
                if (i7 != 0) {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                Object[] objArr2 = this.c;
                Object obj5 = objArr2[0];
                Object obj6 = objArr2[1];
                Object obj7 = objArr2[2];
                Object obj8 = objArr2[3];
                this.b = 1;
                throw null;
            default:
                int i8 = this.b;
                if (i8 != 0) {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                Object[] objArr3 = this.c;
                Object obj9 = objArr3[0];
                Object obj10 = objArr3[1];
                Object obj11 = objArr3[2];
                Object obj12 = objArr3[3];
                Object obj13 = objArr3[4];
                this.b = 1;
                throw null;
        }
    }
}
