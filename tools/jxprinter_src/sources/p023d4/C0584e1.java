package p023d4;

import E3.g;
import F3.i;
import O3.p;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.e1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0584e1 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3866a;
    public final /* synthetic */ p b;
    public final /* synthetic */ T c;

    public /* synthetic */ C0584e1(p pVar, T t6, int i5) {
        this.f3866a = i5;
        this.b = pVar;
        this.c = t6;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        C0581d1 c0581d1;
        C0584e1 c0584e1;
        C0593h1 c0593h1;
        C0584e1 c0584e2;
        switch (this.f3866a) {
            case 0:
                if (gVar instanceof C0581d1) {
                    c0581d1 = (C0581d1) gVar;
                    int i5 = c0581d1.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0581d1.c = i5 - Integer.MIN_VALUE;
                    } else {
                        c0581d1 = new C0581d1(this, gVar);
                    }
                } else {
                    c0581d1 = new C0581d1(this, gVar);
                }
                Object objInvoke = c0581d1.b;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0581d1.c;
                if (i6 == 0) {
                    v.throwOnFailure(objInvoke);
                    c0581d1.f3863a = this;
                    c0581d1.e = obj;
                    c0581d1.c = 1;
                    objInvoke = this.b.invoke(obj, c0581d1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c0584e1 = this;
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = c0581d1.e;
                    c0584e1 = c0581d1.f3863a;
                    v.throwOnFailure(objInvoke);
                }
                if (!((Boolean) objInvoke).booleanValue()) {
                    return Q.INSTANCE;
                }
                c0584e1.c.f5689a = obj;
                throw new C1112a(c0584e1);
            default:
                if (gVar instanceof C0593h1) {
                    c0593h1 = (C0593h1) gVar;
                    int i7 = c0593h1.c;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0593h1.c = i7 - Integer.MIN_VALUE;
                    } else {
                        c0593h1 = new C0593h1(this, gVar);
                    }
                } else {
                    c0593h1 = new C0593h1(this, gVar);
                }
                Object objInvoke2 = c0593h1.b;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = c0593h1.c;
                if (i8 == 0) {
                    v.throwOnFailure(objInvoke2);
                    c0593h1.f3874a = this;
                    c0593h1.e = obj;
                    c0593h1.c = 1;
                    objInvoke2 = this.b.invoke(obj, c0593h1);
                    if (objInvoke2 == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                    c0584e2 = this;
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = c0593h1.e;
                    c0584e2 = c0593h1.f3874a;
                    v.throwOnFailure(objInvoke2);
                }
                if (!((Boolean) objInvoke2).booleanValue()) {
                    return Q.INSTANCE;
                }
                c0584e2.c.f5689a = obj;
                throw new C1112a(c0584e2);
        }
    }
}
