package p023d4;

import E3.g;
import F3.i;
import kotlin.jvm.internal.P;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0610n0 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3892a;
    public final /* synthetic */ P b;
    public final /* synthetic */ InterfaceC0615p c;

    public /* synthetic */ C0610n0(P p6, InterfaceC0615p interfaceC0615p, int i5) {
        this.f3892a = i5;
        this.b = p6;
        this.c = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object a(int i5, g gVar) throws Throwable {
        j2 j2Var;
        if (gVar instanceof j2) {
            j2Var = (j2) gVar;
            int i6 = j2Var.c;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                j2Var.c = i6 - Integer.MIN_VALUE;
            } else {
                j2Var = new j2(this, gVar);
            }
        } else {
            j2Var = new j2(this, gVar);
        }
        Object obj = j2Var.f3880a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i7 = j2Var.c;
        if (i7 == 0) {
            v.throwOnFailure(obj);
            if (i5 > 0) {
                P p6 = this.b;
                if (!p6.f5686a) {
                    p6.f5686a = true;
                    e2 e2Var = e2.f3867a;
                    j2Var.c = 1;
                    if (this.c.emit(e2Var, j2Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Q.INSTANCE;
        }
        if (i7 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        return Q.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        C0607m0 c0607m0;
        switch (this.f3892a) {
            case 0:
                if (gVar instanceof C0607m0) {
                    c0607m0 = (C0607m0) gVar;
                    int i5 = c0607m0.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0607m0.c = i5 - Integer.MIN_VALUE;
                    } else {
                        c0607m0 = new C0607m0(this, gVar);
                    }
                } else {
                    c0607m0 = new C0607m0(this, gVar);
                }
                Object obj2 = c0607m0.f3889a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0607m0.c;
                if (i6 == 0) {
                    v.throwOnFailure(obj2);
                    this.b.f5686a = false;
                    c0607m0.c = 1;
                    if (this.c.emit(obj, c0607m0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj2);
                }
                return Q.INSTANCE;
            default:
                return a(((Number) obj).intValue(), gVar);
        }
    }
}
