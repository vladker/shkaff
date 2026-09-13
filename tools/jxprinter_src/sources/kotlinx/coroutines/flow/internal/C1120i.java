package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.T;
import p007a4.AbstractC0272e;
import p007a4.H0;
import p007a4.K0;
import p007a4.P;
import p018c4.x0;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1120i implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5709a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ InterfaceC0615p e;

    public /* synthetic */ C1120i(Object obj, Object obj2, Object obj3, InterfaceC0615p interfaceC0615p, int i5) {
        this.f5709a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object a(InterfaceC0612o interfaceC0612o, E3.g gVar) throws Throwable {
        C1119h c1119h;
        C1120i c1120i;
        if (gVar instanceof C1119h) {
            c1119h = (C1119h) gVar;
            int i5 = c1119h.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1119h.e = i5 - Integer.MIN_VALUE;
            } else {
                c1119h = new C1119h(this, gVar);
            }
        } else {
            c1119h = new C1119h(this, gVar);
        }
        Object obj = c1119h.c;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c1119h.e;
        if (i6 == 0) {
            p147z3.v.throwOnFailure(obj);
            H0 h1 = (H0) this.b;
            if (h1 != null) {
                K0.ensureActive(h1);
            }
            Object obj2 = (p049i4.j) this.c;
            c1119h.f5708a = this;
            c1119h.b = interfaceC0612o;
            c1119h.e = 1;
            if (((p049i4.m) obj2).acquire(c1119h) == coroutine_suspended) {
                return coroutine_suspended;
            }
            c1120i = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0612o = c1119h.b;
            c1120i = c1119h.f5708a;
            p147z3.v.throwOnFailure(obj);
        }
        AbstractC0272e.b((x0) c1120i.d, null, 3, new C1116e(interfaceC0612o, (J) c1120i.e, (p049i4.j) c1120i.c, null));
        return Q.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, E3.g gVar) throws Throwable {
        C1124m c1124m;
        C1120i c1120i;
        switch (this.f5709a) {
            case 0:
                return a((InterfaceC0612o) obj, gVar);
            default:
                if (gVar instanceof C1124m) {
                    c1124m = (C1124m) gVar;
                    int i5 = c1124m.e;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        c1124m.e = i5 - Integer.MIN_VALUE;
                    } else {
                        c1124m = new C1124m(this, gVar);
                    }
                } else {
                    c1124m = new C1124m(this, gVar);
                }
                Object obj2 = c1124m.c;
                Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
                int i6 = c1124m.e;
                if (i6 == 0) {
                    p147z3.v.throwOnFailure(obj2);
                    H0 h1 = (H0) ((T) this.b).f5689a;
                    if (h1 != null) {
                        h1.cancel((CancellationException) new q());
                        c1124m.f5711a = this;
                        c1124m.b = obj;
                        c1124m.e = 1;
                        if (h1.join(c1124m) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    c1120i = this;
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = c1124m.b;
                    c1120i = c1124m.f5711a;
                    p147z3.v.throwOnFailure(obj2);
                }
                T t6 = (T) c1120i.b;
                p007a4.M m6 = (p007a4.M) c1120i.c;
                P p6 = P.f943a;
                t6.f5689a = AbstractC0272e.b(m6, null, 1, new n((o) c1120i.d, c1120i.e, obj, null));
                return Q.INSTANCE;
        }
    }
}
