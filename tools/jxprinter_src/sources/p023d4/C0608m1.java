package p023d4;

import E3.g;
import F3.i;
import O3.q;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.m1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0608m1 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3890a;
    public final /* synthetic */ T b;
    public final /* synthetic */ q c;

    public /* synthetic */ C0608m1(T t6, q qVar, int i5) {
        this.f3890a = i5;
        this.b = t6;
        this.c = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006e  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        C0605l1 c0605l1;
        T t6;
        C0620q1 c0620q1;
        T t7;
        T t8;
        switch (this.f3890a) {
            case 0:
                if (gVar instanceof C0605l1) {
                    c0605l1 = (C0605l1) gVar;
                    int i5 = c0605l1.d;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c0605l1.d = i5 - Integer.MIN_VALUE;
                    } else {
                        c0605l1 = new C0605l1(this, gVar);
                    }
                } else {
                    c0605l1 = new C0605l1(this, gVar);
                }
                Object obj2 = c0605l1.b;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = c0605l1.d;
                if (i6 == 0) {
                    v.throwOnFailure(obj2);
                    T t9 = this.b;
                    Object obj3 = t9.f5689a;
                    c0605l1.f3887a = t9;
                    c0605l1.d = 1;
                    Object objInvoke = this.c.invoke(obj3, obj, c0605l1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objInvoke;
                    t6 = t9;
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t6 = c0605l1.f3887a;
                    v.throwOnFailure(obj2);
                }
                t6.f5689a = obj2;
                return Q.INSTANCE;
            default:
                if (gVar instanceof C0620q1) {
                    c0620q1 = (C0620q1) gVar;
                    int i7 = c0620q1.d;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0620q1.d = i7 - Integer.MIN_VALUE;
                    } else {
                        c0620q1 = new C0620q1(this, gVar);
                    }
                } else {
                    c0620q1 = new C0620q1(this, gVar);
                }
                Object obj4 = c0620q1.b;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = c0620q1.d;
                if (i8 == 0) {
                    v.throwOnFailure(obj4);
                    t7 = this.b;
                    Object obj5 = t7.f5689a;
                    if (obj5 != E.NULL) {
                        c0620q1.f3904a = t7;
                        c0620q1.d = 1;
                        Object objInvoke2 = this.c.invoke(obj5, obj, c0620q1);
                        if (objInvoke2 == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                        obj4 = objInvoke2;
                        t8 = t7;
                    }
                    t7.f5689a = obj;
                    return Q.INSTANCE;
                }
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t8 = c0620q1.f3904a;
                v.throwOnFailure(obj4);
                Object obj6 = obj4;
                t7 = t8;
                obj = obj6;
                t7.f5689a = obj;
                return Q.INSTANCE;
        }
    }
}
