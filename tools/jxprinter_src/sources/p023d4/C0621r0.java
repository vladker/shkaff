package p023d4;

import E3.g;
import F3.i;
import O3.q;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.r0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0621r0 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3906a;
    public final /* synthetic */ q b;
    public final /* synthetic */ InterfaceC0615p c;

    public /* synthetic */ C0621r0(q qVar, InterfaceC0615p interfaceC0615p, int i5) {
        this.f3906a = i5;
        this.b = qVar;
        this.c = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        C0619q0 c0619q0;
        C0630u0 c0630u0;
        switch (this.f3906a) {
            case 0:
                if (gVar instanceof C0619q0) {
                    c0619q0 = (C0619q0) gVar;
                    int i5 = c0619q0.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0619q0.c = i5 - Integer.MIN_VALUE;
                    } else {
                        c0619q0 = new C0619q0(this, gVar);
                    }
                } else {
                    c0619q0 = new C0619q0(this, gVar);
                }
                Object obj2 = c0619q0.f3903a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0619q0.c;
                if (i6 == 0) {
                    v.throwOnFailure(obj2);
                    c0619q0.c = 1;
                    if (this.b.invoke(this.c, obj, c0619q0) == coroutine_suspended) {
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
                if (gVar instanceof C0630u0) {
                    c0630u0 = (C0630u0) gVar;
                    int i7 = c0630u0.c;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0630u0.c = i7 - Integer.MIN_VALUE;
                    } else {
                        c0630u0 = new C0630u0(this, gVar);
                    }
                } else {
                    c0630u0 = new C0630u0(this, gVar);
                }
                Object obj3 = c0630u0.f3915a;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = c0630u0.c;
                if (i8 == 0) {
                    v.throwOnFailure(obj3);
                    c0630u0.c = 1;
                    if (this.b.invoke(this.c, obj, c0630u0) == coroutine_suspended2) {
                        return coroutine_suspended2;
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
