package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.M;
import p007a4.N;
import p049i4.b;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f8849a;
    public int b;

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new D(2, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((D) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        b bVar;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.b;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            b bVar2 = E.lock;
            this.f8849a = bVar2;
            this.b = 1;
            p049i4.g gVar = (p049i4.g) bVar2;
            if (gVar.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = gVar;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = this.f8849a;
            v.throwOnFailure(obj);
        }
        try {
            if (E.reconnectJob != null) {
                return Q.INSTANCE;
            }
            if (E.getPrinter() != null) {
                K0 printer = E.getPrinter();
                E.c(printer);
                if (printer.b()) {
                    return Q.INSTANCE;
                }
            }
            kotlin.jvm.internal.Q q6 = new kotlin.jvm.internal.Q();
            q6.f5687a = 100;
            E.reconnectJob = AbstractC0272e.b(N.CoroutineScope(C0276f0.getDefault()), null, 3, new C(q6, null));
            return Q.INSTANCE;
        } finally {
            ((p049i4.g) bVar).unlock(null);
        }
    }
}
