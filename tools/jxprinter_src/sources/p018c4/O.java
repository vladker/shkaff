package p018c4;

import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.p;
import p023d4.e2;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1110a;
    public /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ O(int i5, g gVar, int i6) {
        super(i5, gVar);
        this.f1110a = i6;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1110a) {
            case 0:
                O o6 = new O(2, gVar, 0);
                o6.b = obj;
                return o6;
            case 1:
                O o7 = new O(2, gVar, 1);
                o7.b = obj;
                return o7;
            default:
                O o8 = new O(2, gVar, 2);
                o8.b = obj;
                return o8;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1110a) {
            case 0:
                return ((O) create(obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 1:
                return ((O) create(obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((O) create((e2) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f1110a;
        i.getCOROUTINE_SUSPENDED();
        switch (i5) {
            case 0:
                v.throwOnFailure(obj);
                return this.b;
            case 1:
                v.throwOnFailure(obj);
                return b.boxBoolean(this.b != null);
            default:
                v.throwOnFailure(obj);
                return b.boxBoolean(((e2) this.b) != e2.f3867a);
        }
    }
}
