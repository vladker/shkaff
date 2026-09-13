package p018c4;

import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.l;
import O3.p;
import kotlin.jvm.internal.P;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.AbstractC1117f;
import kotlinx.coroutines.flow.internal.AbstractC1122k;
import kotlinx.coroutines.flow.internal.E;
import kotlinx.coroutines.flow.internal.J;
import p007a4.M;
import p023d4.C0610n0;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p023d4.n2;
import p051j0.f;
import p102s.w;
import p108t.C1770b;
import p108t.b0;
import p108t.d0;
import p147z3.C1929i;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1103a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G(Object obj, g gVar, int i5) {
        super(2, gVar);
        this.f1103a = i5;
        this.d = obj;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1103a) {
            case 0:
                return new G((D0) this.d, this.c, gVar, 0);
            case 1:
                G g6 = new G((p) this.d, gVar, 1);
                g6.c = obj;
                return g6;
            case 2:
                return new G((T) this.d, (InterfaceC0615p) this.c, gVar, 2);
            case 3:
                G g7 = new G((n2) this.d, gVar, 3);
                g7.c = obj;
                return g7;
            case 4:
                return new G((String) this.d, (String) this.c, gVar, 4);
            case 5:
                G g8 = new G((AbstractC1117f) this.d, gVar, 5);
                g8.c = obj;
                return g8;
            case 6:
                G g9 = new G((AbstractC1122k) this.d, gVar, 6);
                g9.c = obj;
                return g9;
            case 7:
                return new G((InterfaceC0612o) this.d, (J) this.c, gVar, 7);
            case 8:
                return new G((C1770b) this.d, (l) this.c, gVar, 8);
            case 9:
                return new G((b0) this.d, (l) this.c, gVar, 9);
            default:
                return new G((d0) this.d, (l) this.c, gVar, 10);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1103a) {
            case 0:
                return ((G) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 1:
                return ((G) create(obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 2:
                return ((G) create((Q) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 3:
                return ((G) create((InterfaceC0615p) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 4:
                return ((G) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 5:
                return ((G) create((x0) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 6:
                return ((G) create((InterfaceC0615p) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 7:
                return ((G) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 8:
                return ((G) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 9:
                return ((G) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((G) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f1103a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    D0 d1 = (D0) this.d;
                    Object obj2 = this.c;
                    this.b = 1;
                    if (d1.send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 1:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    Object obj3 = this.c;
                    p pVar = (p) this.d;
                    this.b = 1;
                    obj = pVar.invoke(obj3, this);
                    if (obj == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return b.boxBoolean(!((Boolean) obj).booleanValue());
            case 2:
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                if (i7 == 0) {
                    v.throwOnFailure(obj);
                    T t6 = (T) this.d;
                    Object obj4 = t6.f5689a;
                    if (obj4 == null) {
                        return Q.INSTANCE;
                    }
                    t6.f5689a = null;
                    InterfaceC0615p interfaceC0615p = (InterfaceC0615p) this.c;
                    if (obj4 == E.NULL) {
                        obj4 = null;
                    }
                    this.b = 1;
                    if (interfaceC0615p.emit(obj4, this) == coroutine_suspended3) {
                        return coroutine_suspended3;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 3:
                Object coroutine_suspended4 = i.getCOROUTINE_SUSPENDED();
                int i8 = this.b;
                if (i8 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p2 = (InterfaceC0615p) this.c;
                    P p6 = new P();
                    n2 n2Var = (n2) this.d;
                    C0610n0 c0610n0 = new C0610n0(p6, interfaceC0615p2, 1);
                    this.b = 1;
                    if (n2Var.collect(c0610n0, this) == coroutine_suspended4) {
                        return coroutine_suspended4;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                throw new C1929i();
            case 4:
                Object coroutine_suspended5 = i.getCOROUTINE_SUSPENDED();
                int i9 = this.b;
                if (i9 == 0) {
                    v.throwOnFailure(obj);
                    f fVar = f.INSTANCE;
                    String str = (String) this.d;
                    String str2 = (String) this.c;
                    this.b = 1;
                    if (fVar.connectUsbDeviceAsync(str, str2, this) == coroutine_suspended5) {
                        return coroutine_suspended5;
                    }
                } else {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 5:
                Object coroutine_suspended6 = i.getCOROUTINE_SUSPENDED();
                int i10 = this.b;
                if (i10 == 0) {
                    v.throwOnFailure(obj);
                    x0 x0Var = (x0) this.c;
                    AbstractC1117f abstractC1117f = (AbstractC1117f) this.d;
                    this.b = 1;
                    if (abstractC1117f.collectTo(x0Var, this) == coroutine_suspended6) {
                        return coroutine_suspended6;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 6:
                Object coroutine_suspended7 = i.getCOROUTINE_SUSPENDED();
                int i11 = this.b;
                if (i11 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p3 = (InterfaceC0615p) this.c;
                    AbstractC1122k abstractC1122k = (AbstractC1122k) this.d;
                    this.b = 1;
                    if (abstractC1122k.flowCollect(interfaceC0615p3, this) == coroutine_suspended7) {
                        return coroutine_suspended7;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 7:
                Object coroutine_suspended8 = i.getCOROUTINE_SUSPENDED();
                int i12 = this.b;
                if (i12 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0612o interfaceC0612o = (InterfaceC0612o) this.d;
                    J j6 = (J) this.c;
                    this.b = 1;
                    if (interfaceC0612o.collect(j6, this) == coroutine_suspended8) {
                        return coroutine_suspended8;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 8:
                C1770b c1770b = (C1770b) this.d;
                Object coroutine_suspended9 = i.getCOROUTINE_SUSPENDED();
                int i13 = this.b;
                if (i13 == 0) {
                    v.throwOnFailure(obj);
                    w wVar = new w(c1770b, (l) this.c, 0);
                    p134x2.E e = p134x2.E.INSTANCE;
                    e.addEventListener(wVar);
                    String address = c1770b.getAddress();
                    this.b = 1;
                    if (e.connectBluetoothDevice(address, false, this) == coroutine_suspended9) {
                        return coroutine_suspended9;
                    }
                } else {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 9:
                b0 b0Var = (b0) this.d;
                Object coroutine_suspended10 = i.getCOROUTINE_SUSPENDED();
                int i14 = this.b;
                if (i14 == 0) {
                    v.throwOnFailure(obj);
                    w wVar2 = new w(b0Var, (l) this.c, 1);
                    p134x2.E e6 = p134x2.E.INSTANCE;
                    e6.addEventListener(wVar2);
                    String name = b0Var.getName();
                    String address2 = b0Var.getAddress();
                    this.b = 1;
                    if (e6.connectUsbDevice(name, address2, this) == coroutine_suspended10) {
                        return coroutine_suspended10;
                    }
                } else {
                    if (i14 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                d0 d0Var = (d0) this.d;
                Object coroutine_suspended11 = i.getCOROUTINE_SUSPENDED();
                int i15 = this.b;
                if (i15 == 0) {
                    v.throwOnFailure(obj);
                    w wVar3 = new w(d0Var, (l) this.c, 2);
                    p134x2.E e7 = p134x2.E.INSTANCE;
                    e7.addEventListener(wVar3);
                    String name2 = d0Var.getName();
                    String ip = d0Var.getIp();
                    int i16 = (int) d0Var.f8527a;
                    this.b = 1;
                    if (e7.connectWifiDevice(name2, ip, i16, this) == coroutine_suspended11) {
                        return coroutine_suspended11;
                    }
                } else {
                    if (i15 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G(Object obj, Object obj2, g gVar, int i5) {
        super(2, gVar);
        this.f1103a = i5;
        this.d = obj;
        this.c = obj2;
    }
}
