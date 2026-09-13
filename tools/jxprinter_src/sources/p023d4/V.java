package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.l;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p028e4.H;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V extends m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3834a;
    public final /* synthetic */ InterfaceC0615p b;
    public final /* synthetic */ T c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(InterfaceC0615p interfaceC0615p, T t6, g gVar) {
        super(1, gVar);
        this.b = interfaceC0615p;
        this.c = t6;
    }

    @Override // G3.a
    public final g create(g gVar) {
        return new V(this.b, this.c, gVar);
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        return ((V) create((g) obj)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f3834a;
        T t6 = this.c;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            H h6 = E.NULL;
            Object obj2 = t6.f5689a;
            if (obj2 == h6) {
                obj2 = null;
            }
            this.f3834a = 1;
            if (this.b.emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        t6.f5689a = null;
        return Q.INSTANCE;
    }
}
