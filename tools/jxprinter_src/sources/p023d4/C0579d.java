package p023d4;

import E3.g;
import E3.q;
import F3.i;
import O3.p;
import kotlinx.coroutines.flow.internal.AbstractC1117f;
import p018c4.C0392w;
import p018c4.EnumC0368b;
import p018c4.x0;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0579d extends C0597j {
    private final p block;

    public C0579d(p pVar, q qVar, int i5, EnumC0368b enumC0368b) {
        super(pVar, qVar, i5, enumC0368b);
        this.block = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.C0597j, kotlinx.coroutines.flow.internal.AbstractC1117f
    public Object collectTo(x0 x0Var, g<? super Q> gVar) throws Throwable {
        C0576c c0576c;
        Object obj;
        if (gVar instanceof C0576c) {
            c0576c = (C0576c) gVar;
            int i5 = c0576c.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0576c.d = i5 - Integer.MIN_VALUE;
            } else {
                c0576c = new C0576c(this, gVar);
            }
        } else {
            c0576c = new C0576c(this, gVar);
        }
        Object obj2 = c0576c.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0576c.d;
        if (i6 == 0) {
            v.throwOnFailure(obj2);
            c0576c.f3859a = x0Var;
            c0576c.d = 1;
            if (super.collectTo(x0Var, c0576c) == coroutine_suspended) {
                obj = x0Var;
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            x0 x0Var2 = c0576c.f3859a;
            v.throwOnFailure(obj2);
            obj = x0Var2;
        }
        obj = x0Var;
        if (((C0392w) obj).c()) {
            return Q.INSTANCE;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override // p023d4.C0597j, kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(q qVar, int i5, EnumC0368b enumC0368b) {
        return new C0579d(this.block, qVar, i5, enumC0368b);
    }
}
