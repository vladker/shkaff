package kotlinx.serialization.json.internal;

import p147z3.AbstractC1923c;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class W extends G3.l implements O3.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5730a;
    public /* synthetic */ AbstractC1923c b;
    public final /* synthetic */ Y c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(Y y6, E3.g gVar) {
        super(3, gVar);
        this.c = y6;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        W w6 = new W(this.c, (E3.g) obj3);
        w6.b = (AbstractC1923c) obj;
        return w6.invokeSuspend(p147z3.Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i5 = this.f5730a;
        if (i5 == 0) {
            p147z3.v.throwOnFailure(obj);
            AbstractC1923c abstractC1923c = this.b;
            Y y6 = this.c;
            byte bQ = y6.lexer.q();
            if (bQ == 1) {
                return y6.d(true);
            }
            if (bQ == 0) {
                return y6.d(false);
            }
            if (bQ != 6) {
                if (bQ == 8) {
                    return y6.c();
                }
                AbstractC1126b.n(y6.lexer, "Can't begin reading element, unexpected token", 0, null, 6);
                throw new C1929i();
            }
            this.f5730a = 1;
            obj = Y.b(y6, abstractC1923c, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p147z3.v.throwOnFailure(obj);
        }
        return (p089p4.m) obj;
    }
}
