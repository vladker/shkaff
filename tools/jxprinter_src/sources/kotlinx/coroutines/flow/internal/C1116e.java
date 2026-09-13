package kotlinx.coroutines.flow.internal;

import p018c4.B0;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1116e extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5707a = 2;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ InterfaceC0615p d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1116e(O3.q qVar, InterfaceC0615p interfaceC0615p, E3.g gVar) {
        super(2, gVar);
        this.e = qVar;
        this.d = interfaceC0615p;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f5707a) {
            case 0:
                C1116e c1116e = new C1116e(this.d, (AbstractC1117f) this.e, gVar);
                c1116e.c = obj;
                return c1116e;
            case 1:
                return new C1116e((InterfaceC0612o) this.c, (J) this.d, (p049i4.j) this.e, gVar);
            default:
                C1116e c1116e2 = new C1116e((O3.q) this.e, this.d, gVar);
                c1116e2.c = obj;
                return c1116e2;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        p007a4.M m6 = (p007a4.M) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f5707a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((C1116e) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [i4.j] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [i4.m] */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f5707a) {
            case 0:
                Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    B0 b0ProduceImpl = ((AbstractC1117f) this.e).produceImpl((p007a4.M) this.c);
                    this.b = 1;
                    if (AbstractC0618q.emitAll(this.d, b0ProduceImpl, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 1:
                ?? r6 = (p049i4.j) this.e;
                Object coroutine_suspended2 = F3.i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                try {
                    if (i6 == 0) {
                        p147z3.v.throwOnFailure(obj);
                        InterfaceC0612o interfaceC0612o = (InterfaceC0612o) this.c;
                        J j6 = (J) this.d;
                        this.b = 1;
                        if (interfaceC0612o.collect(j6, this) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } else {
                        if (i6 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p147z3.v.throwOnFailure(obj);
                    }
                    r6 = (p049i4.m) r6;
                    r6.b();
                    return Q.INSTANCE;
                } catch (Throwable th) {
                    ((p049i4.m) r6).b();
                    throw th;
                }
            default:
                Object coroutine_suspended3 = F3.i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                if (i7 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    p007a4.M m6 = (p007a4.M) this.c;
                    O3.q qVar = (O3.q) this.e;
                    this.b = 1;
                    if (qVar.invoke(m6, this.d, this) == coroutine_suspended3) {
                        return coroutine_suspended3;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1116e(InterfaceC0612o interfaceC0612o, J j6, p049i4.j jVar, E3.g gVar) {
        super(2, gVar);
        this.c = interfaceC0612o;
        this.d = j6;
        this.e = jVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1116e(InterfaceC0615p interfaceC0615p, AbstractC1117f abstractC1117f, E3.g gVar) {
        super(2, gVar);
        this.d = interfaceC0615p;
        this.e = abstractC1117f;
    }
}
