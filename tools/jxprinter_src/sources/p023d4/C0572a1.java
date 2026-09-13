package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.l;
import O3.q;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.a1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0572a1 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3849a;
    public /* synthetic */ InterfaceC0615p b;
    public /* synthetic */ Throwable c;
    public final /* synthetic */ l d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0572a1(l lVar, Object obj, g gVar) {
        super(3, gVar);
        this.d = lVar;
        this.e = obj;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C0572a1 c0572a1 = new C0572a1(this.d, this.e, (g) obj3);
        c0572a1.b = (InterfaceC0615p) obj;
        c0572a1.c = (Throwable) obj2;
        return c0572a1.invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f3849a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            InterfaceC0615p interfaceC0615p = this.b;
            Throwable th = this.c;
            if (!((Boolean) this.d.invoke(th)).booleanValue()) {
                throw th;
            }
            this.b = null;
            this.f3849a = 1;
            if (interfaceC0615p.emit(this.e, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        return Q.INSTANCE;
    }
}
