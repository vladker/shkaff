package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.q;
import S2.t;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p007a4.M;
import p018c4.B0;
import p018c4.G;
import p018c4.v0;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0574b0 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f3853a;
    public B0 b;
    public int c;
    public /* synthetic */ Object d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f3854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o f3855g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0574b0(long j6, InterfaceC0612o interfaceC0612o, g gVar) {
        super(3, gVar);
        this.f3854f = j6;
        this.f3855g = interfaceC0612o;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C0574b0 c0574b0 = new C0574b0(this.f3854f, this.f3855g, (g) obj3);
        c0574b0.d = (M) obj;
        c0574b0.e = (InterfaceC0615p) obj2;
        return c0574b0.invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        B0 b1;
        T t6;
        InterfaceC0615p interfaceC0615p;
        B0 b0FixedPeriodTicker;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.c;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            M m6 = (M) this.d;
            InterfaceC0615p interfaceC0615p2 = (InterfaceC0615p) this.e;
            B0 b0A = v0.a(m6, -1, new Y(this.f3855g, null, 1), 1);
            T t7 = new T();
            b1 = b0A;
            t6 = t7;
            interfaceC0615p = interfaceC0615p2;
            b0FixedPeriodTicker = AbstractC0618q.fixedPeriodTicker(m6, this.f3854f);
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b0FixedPeriodTicker = this.b;
            t6 = this.f3853a;
            b1 = (B0) this.e;
            interfaceC0615p = (InterfaceC0615p) this.d;
            v.throwOnFailure(obj);
        }
        while (t6.f5689a != E.DONE) {
            p044h4.m mVar = new p044h4.m(getContext());
            mVar.invoke(b1.getOnReceiveCatching(), new t(t6, b0FixedPeriodTicker, null));
            mVar.invoke(b0FixedPeriodTicker.getOnReceive(), new G(t6, interfaceC0615p, null, 2));
            this.d = interfaceC0615p;
            this.e = b1;
            this.f3853a = t6;
            this.b = b0FixedPeriodTicker;
            this.c = 1;
            if (mVar.doSelect(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Q.INSTANCE;
    }
}
