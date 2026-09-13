package p147z3;

import E3.g;
import E3.r;
import F3.i;
import G3.a;
import G3.h;
import O3.q;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Y;

/* JADX INFO: renamed from: z3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1925e extends AbstractC1923c implements g {
    private g<Object> cont;
    private q function;
    private Object result;
    private Object value;

    public C1925e(q block, Object obj) {
        E.f(block, "block");
        this.function = block;
        this.value = obj;
        this.cont = this;
        this.result = AbstractC1922b.UNDEFINED_RESULT;
    }

    @Override // p147z3.AbstractC1923c
    public Object callRecursive(Object obj, g<Object> gVar) {
        E.d(gVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = gVar;
        this.value = obj;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == i.getCOROUTINE_SUSPENDED()) {
            h.probeCoroutineSuspended(gVar);
        }
        return coroutine_suspended;
    }

    public final Object d() throws Throwable {
        Object objInvoke;
        while (true) {
            Object obj = this.result;
            g<Object> gVar = this.cont;
            if (gVar == null) {
                v.throwOnFailure(obj);
                return obj;
            }
            if (E.a(AbstractC1922b.UNDEFINED_RESULT, obj)) {
                try {
                    q qVar = this.function;
                    Object obj2 = this.value;
                    if (qVar instanceof a) {
                        Y.c(3, qVar);
                        objInvoke = qVar.invoke(this, obj2, gVar);
                    } else {
                        objInvoke = F3.h.wrapWithContinuationImpl(qVar, this, obj2, gVar);
                    }
                    if (objInvoke != i.getCOROUTINE_SUSPENDED()) {
                        gVar.resumeWith(u.m1361constructorimpl(objInvoke));
                    }
                } catch (Throwable th) {
                    gVar.resumeWith(u.m1361constructorimpl(v.createFailure(th)));
                }
            } else {
                this.result = AbstractC1922b.UNDEFINED_RESULT;
                gVar.resumeWith(obj);
            }
        }
    }

    @Override // E3.g
    public E3.q getContext() {
        return r.INSTANCE;
    }

    @Override // E3.g
    public void resumeWith(Object obj) {
        this.cont = null;
        this.result = obj;
    }

    @Override // p147z3.AbstractC1923c
    public <U, S> Object callRecursive(C1921a c1921a, U u6, g<? super S> gVar) {
        q block$kotlin_stdlib = c1921a.getBlock$kotlin_stdlib();
        E.d(block$kotlin_stdlib, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>");
        q qVar = this.function;
        if (block$kotlin_stdlib != qVar) {
            this.function = block$kotlin_stdlib;
            E.d(gVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.cont = new C1924d(r.INSTANCE, this, qVar, gVar);
        } else {
            E.d(gVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.cont = gVar;
        }
        this.value = u6;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == i.getCOROUTINE_SUSPENDED()) {
            h.probeCoroutineSuspended(gVar);
        }
        return coroutine_suspended;
    }
}
