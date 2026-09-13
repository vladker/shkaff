package p023d4;

import E3.g;
import F3.i;
import kotlinx.coroutines.flow.internal.E;
import kotlinx.coroutines.flow.internal.v;
import p018c4.D0;
import p018c4.x0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3839a;
    public final /* synthetic */ x0 b;

    public /* synthetic */ X(x0 x0Var, int i5) {
        this.f3839a = i5;
        this.b = x0Var;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        W w6;
        C0571a0 c0571a0;
        v vVar;
        switch (this.f3839a) {
            case 0:
                if (gVar instanceof W) {
                    w6 = (W) gVar;
                    int i5 = w6.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        w6.c = i5 - Integer.MIN_VALUE;
                    } else {
                        w6 = new W(this, gVar);
                    }
                } else {
                    w6 = new W(this, gVar);
                }
                Object obj2 = w6.f3836a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = w6.c;
                if (i6 == 0) {
                    p147z3.v.throwOnFailure(obj2);
                    if (obj == null) {
                        obj = E.NULL;
                    }
                    w6.c = 1;
                    if (this.b.send(obj, w6) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj2);
                }
                return Q.INSTANCE;
            case 1:
                if (gVar instanceof C0571a0) {
                    c0571a0 = (C0571a0) gVar;
                    int i7 = c0571a0.c;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0571a0.c = i7 - Integer.MIN_VALUE;
                    } else {
                        c0571a0 = new C0571a0(this, gVar);
                    }
                } else {
                    c0571a0 = new C0571a0(this, gVar);
                }
                Object obj3 = c0571a0.f3848a;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = c0571a0.c;
                if (i8 == 0) {
                    p147z3.v.throwOnFailure(obj3);
                    if (obj == null) {
                        obj = E.NULL;
                    }
                    c0571a0.c = 1;
                    if (this.b.send(obj, c0571a0) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj3);
                }
                return Q.INSTANCE;
            default:
                if (gVar instanceof v) {
                    vVar = (v) gVar;
                    int i9 = vVar.c;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        vVar.c = i9 - Integer.MIN_VALUE;
                    } else {
                        vVar = new v(this, gVar);
                    }
                } else {
                    vVar = new v(this, gVar);
                }
                Object obj4 = vVar.f5723a;
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i10 = vVar.c;
                if (i10 == 0) {
                    p147z3.v.throwOnFailure(obj4);
                    D0 channel = this.b.getChannel();
                    if (obj == null) {
                        obj = E.NULL;
                    }
                    vVar.c = 1;
                    if (channel.send(obj, vVar) == coroutine_suspended3) {
                        return coroutine_suspended3;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj4);
                }
                return Q.INSTANCE;
        }
    }
}
