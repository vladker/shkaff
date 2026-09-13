package p023d4;

import E3.g;
import F3.i;
import O3.q;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.w;
import p007a4.N;
import p018c4.P;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O1 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3820a;
    public final /* synthetic */ InterfaceC0612o b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ q d;

    public /* synthetic */ O1(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, q qVar, int i5) {
        this.f3820a = i5;
        this.b = interfaceC0612o;
        this.c = interfaceC0612o2;
        this.d = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) throws Throwable {
        F1 f1;
        O1 o6;
        InterfaceC0615p interfaceC0615p2;
        T t6;
        int i5 = this.f3820a;
        g gVar2 = null;
        Object obj = this.c;
        switch (i5) {
            case 0:
                Object objCombineInternal = w.combineInternal(interfaceC0615p, new InterfaceC0612o[]{this.b, (InterfaceC0612o) obj}, S1.f3830a, new U0(this.d, gVar2, 3), gVar);
                return objCombineInternal == i.getCOROUTINE_SUSPENDED() ? objCombineInternal : Q.INSTANCE;
            case 1:
                Object objCoroutineScope = N.coroutineScope(new P(this.b, (InterfaceC0612o) obj, interfaceC0615p, this.d, null), gVar);
                return objCoroutineScope == i.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Q.INSTANCE;
            default:
                if (gVar instanceof F1) {
                    f1 = (F1) gVar;
                    int i6 = f1.b;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        f1.b = i6 - Integer.MIN_VALUE;
                    } else {
                        f1 = new F1(this, gVar);
                    }
                } else {
                    f1 = new F1(this, gVar);
                }
                Object obj2 = f1.f3796a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i7 = f1.b;
                if (i7 != 0) {
                    if (i7 == 1) {
                        t6 = f1.f3797f;
                        interfaceC0615p2 = f1.e;
                        o6 = f1.d;
                        v.throwOnFailure(obj2);
                    } else {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj2);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj2);
                T t7 = new T();
                t7.f5689a = obj;
                f1.d = this;
                f1.e = interfaceC0615p;
                f1.f3797f = t7;
                f1.b = 1;
                if (interfaceC0615p.emit(obj, f1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                o6 = this;
                interfaceC0615p2 = interfaceC0615p;
                t6 = t7;
                InterfaceC0612o interfaceC0612o = o6.b;
                H1 h1 = new H1(t6, o6.d, interfaceC0615p2, 0);
                f1.d = null;
                f1.e = null;
                f1.f3797f = null;
                f1.b = 2;
                if (interfaceC0612o.collect(h1, f1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
        }
    }

    public O1(InterfaceC0612o interfaceC0612o, Object obj, q qVar) {
        this.f3820a = 2;
        this.c = obj;
        this.b = interfaceC0612o;
        this.d = qVar;
    }
}
