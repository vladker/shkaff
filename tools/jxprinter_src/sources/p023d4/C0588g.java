package p023d4;

import E3.g;
import F3.i;
import p007a4.K0;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0588g implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3870a;
    public final /* synthetic */ InterfaceC0615p b;

    public /* synthetic */ C0588g(InterfaceC0615p interfaceC0615p, int i5) {
        this.f3870a = i5;
        this.b = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object a(InterfaceC0612o interfaceC0612o, g gVar) throws Throwable {
        X0 x6;
        if (gVar instanceof X0) {
            x6 = (X0) gVar;
            int i5 = x6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                x6.c = i5 - Integer.MIN_VALUE;
            } else {
                x6 = new X0(this, gVar);
            }
        } else {
            x6 = new X0(this, gVar);
        }
        Object obj = x6.f3840a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = x6.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            x6.c = 1;
            if (AbstractC0618q.emitAll(this.b, interfaceC0612o, x6) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        return Q.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        C0585f c0585f;
        B1 b1;
        switch (this.f3870a) {
            case 0:
                if (gVar instanceof C0585f) {
                    c0585f = (C0585f) gVar;
                    int i5 = c0585f.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0585f.c = i5 - Integer.MIN_VALUE;
                    } else {
                        c0585f = new C0585f(this, gVar);
                    }
                } else {
                    c0585f = new C0585f(this, gVar);
                }
                Object obj2 = c0585f.f3868a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0585f.c;
                if (i6 == 0) {
                    v.throwOnFailure(obj2);
                    K0.ensureActive(c0585f.getContext());
                    c0585f.c = 1;
                    if (this.b.emit(obj, c0585f) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj2);
                }
                return Q.INSTANCE;
            case 1:
                return a((InterfaceC0612o) obj, gVar);
            default:
                if (gVar instanceof B1) {
                    b1 = (B1) gVar;
                    int i7 = b1.b;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        b1.b = i7 - Integer.MIN_VALUE;
                    } else {
                        b1 = new B1(this, gVar);
                    }
                } else {
                    b1 = new B1(this, gVar);
                }
                Object obj3 = b1.f3784a;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = b1.b;
                if (i8 == 0) {
                    v.throwOnFailure(obj3);
                    if (obj != null) {
                        b1.b = 1;
                        if (this.b.emit(obj, b1) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj3);
                }
                return Q.INSTANCE;
        }
    }
}
