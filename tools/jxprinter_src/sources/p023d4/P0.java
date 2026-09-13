package p023d4;

import E3.g;
import F3.i;
import O3.p;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P0 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3822a;
    public final /* synthetic */ InterfaceC0615p b;
    public final /* synthetic */ p c;

    public /* synthetic */ P0(InterfaceC0615p interfaceC0615p, p pVar, int i5) {
        this.f3822a = i5;
        this.b = interfaceC0615p;
        this.c = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:130:0x0214  */
    /* JADX WARN: Code duplicated, block: B:153:0x0272  */
    /* JADX WARN: Code duplicated, block: B:176:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:196:0x032f  */
    /* JADX WARN: Code duplicated, block: B:198:0x0332  */
    /* JADX WARN: Code duplicated, block: B:32:0x007b  */
    /* JADX WARN: Code duplicated, block: B:57:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x013a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        O0 o6;
        Object obj2;
        Object obj3;
        P0 p1;
        T0 t6;
        InterfaceC0615p interfaceC0615p;
        V0 v6;
        InterfaceC0615p interfaceC0615p2;
        C0643y1 c0643y1;
        Object obj4;
        InterfaceC0615p interfaceC0615p3;
        A1 a6;
        Object obj5;
        InterfaceC0615p interfaceC0615p4;
        C1 c6;
        InterfaceC0615p interfaceC0615p5;
        D1 d1;
        InterfaceC0615p interfaceC0615p6;
        E1 e1;
        Object obj6;
        InterfaceC0615p interfaceC0615p7;
        switch (this.f3822a) {
            case 0:
                if (gVar instanceof O0) {
                    o6 = (O0) gVar;
                    int i5 = o6.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        o6.c = i5 - Integer.MIN_VALUE;
                    } else {
                        o6 = new O0(this, gVar);
                    }
                } else {
                    o6 = new O0(this, gVar);
                }
                Object obj7 = o6.b;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = o6.c;
                boolean z6 = true;
                if (i6 != 0) {
                    if (i6 == 1) {
                        Object obj8 = o6.e;
                        P0 p6 = o6.f3819a;
                        v.throwOnFailure(obj7);
                        obj3 = obj8;
                        p1 = p6;
                        obj2 = obj7;
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p1 = o6.f3819a;
                        v.throwOnFailure(obj7);
                    }
                    if (z6) {
                        return Q.INSTANCE;
                    }
                    throw new C1112a(p1);
                }
                v.throwOnFailure(obj7);
                o6.f3819a = this;
                o6.e = obj;
                o6.c = 1;
                Object objInvoke = this.c.invoke(obj, o6);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objInvoke;
                obj3 = obj;
                p1 = this;
                if (((Boolean) obj2).booleanValue()) {
                    InterfaceC0615p interfaceC0615p8 = p1.b;
                    o6.f3819a = p1;
                    o6.e = null;
                    o6.c = 2;
                    if (interfaceC0615p8.emit(obj3, o6) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    z6 = false;
                }
                if (z6) {
                    return Q.INSTANCE;
                }
                throw new C1112a(p1);
            case 1:
                if (gVar instanceof T0) {
                    t6 = (T0) gVar;
                    int i7 = t6.b;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        t6.b = i7 - Integer.MIN_VALUE;
                    } else {
                        t6 = new T0(this, gVar);
                    }
                } else {
                    t6 = new T0(this, gVar);
                }
                Object obj9 = t6.f3831a;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = t6.b;
                if (i8 != 0) {
                    if (i8 == 1) {
                        interfaceC0615p = t6.c;
                        v.throwOnFailure(obj9);
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj9);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj9);
                InterfaceC0615p interfaceC0615p9 = this.b;
                t6.c = interfaceC0615p9;
                t6.b = 1;
                Object objInvoke2 = this.c.invoke(obj, t6);
                if (objInvoke2 == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                obj9 = objInvoke2;
                interfaceC0615p = interfaceC0615p9;
                t6.c = null;
                t6.b = 2;
                if (interfaceC0615p.emit(obj9, t6) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Q.INSTANCE;
            case 2:
                if (gVar instanceof V0) {
                    v6 = (V0) gVar;
                    int i9 = v6.b;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        v6.b = i9 - Integer.MIN_VALUE;
                    } else {
                        v6 = new V0(this, gVar);
                    }
                } else {
                    v6 = new V0(this, gVar);
                }
                Object obj10 = v6.f3835a;
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i10 = v6.b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        interfaceC0615p2 = v6.c;
                        v.throwOnFailure(obj10);
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj10);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj10);
                InterfaceC0615p interfaceC0615p10 = this.b;
                v6.c = interfaceC0615p10;
                v6.b = 1;
                Object objInvoke3 = this.c.invoke(obj, v6);
                if (objInvoke3 == coroutine_suspended3) {
                    return coroutine_suspended3;
                }
                obj10 = objInvoke3;
                interfaceC0615p2 = interfaceC0615p10;
                v6.c = null;
                v6.b = 2;
                if (interfaceC0615p2.emit(obj10, v6) == coroutine_suspended3) {
                    return coroutine_suspended3;
                }
                return Q.INSTANCE;
            case 3:
                if (gVar instanceof C0643y1) {
                    c0643y1 = (C0643y1) gVar;
                    int i11 = c0643y1.b;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        c0643y1.b = i11 - Integer.MIN_VALUE;
                    } else {
                        c0643y1 = new C0643y1(this, gVar);
                    }
                } else {
                    c0643y1 = new C0643y1(this, gVar);
                }
                Object obj11 = c0643y1.f3929a;
                Object coroutine_suspended4 = i.getCOROUTINE_SUSPENDED();
                int i12 = c0643y1.b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        interfaceC0615p3 = c0643y1.e;
                        obj4 = c0643y1.d;
                        v.throwOnFailure(obj11);
                    } else {
                        if (i12 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj11);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj11);
                c0643y1.d = obj;
                InterfaceC0615p interfaceC0615p11 = this.b;
                c0643y1.e = interfaceC0615p11;
                c0643y1.b = 1;
                Object objInvoke4 = this.c.invoke(obj, c0643y1);
                if (objInvoke4 == coroutine_suspended4) {
                    return coroutine_suspended4;
                }
                obj4 = obj;
                interfaceC0615p3 = interfaceC0615p11;
                obj11 = objInvoke4;
                if (((Boolean) obj11).booleanValue()) {
                    c0643y1.d = null;
                    c0643y1.e = null;
                    c0643y1.b = 2;
                    if (interfaceC0615p3.emit(obj4, c0643y1) == coroutine_suspended4) {
                        return coroutine_suspended4;
                    }
                }
                return Q.INSTANCE;
            case 4:
                if (gVar instanceof A1) {
                    a6 = (A1) gVar;
                    int i13 = a6.b;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        a6.b = i13 - Integer.MIN_VALUE;
                    } else {
                        a6 = new A1(this, gVar);
                    }
                } else {
                    a6 = new A1(this, gVar);
                }
                Object obj12 = a6.f3781a;
                Object coroutine_suspended5 = i.getCOROUTINE_SUSPENDED();
                int i14 = a6.b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        interfaceC0615p4 = a6.e;
                        obj5 = a6.d;
                        v.throwOnFailure(obj12);
                    } else {
                        if (i14 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj12);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj12);
                a6.d = obj;
                InterfaceC0615p interfaceC0615p12 = this.b;
                a6.e = interfaceC0615p12;
                a6.b = 1;
                Object objInvoke5 = this.c.invoke(obj, a6);
                if (objInvoke5 == coroutine_suspended5) {
                    return coroutine_suspended5;
                }
                obj5 = obj;
                interfaceC0615p4 = interfaceC0615p12;
                obj12 = objInvoke5;
                if (!((Boolean) obj12).booleanValue()) {
                    a6.d = null;
                    a6.e = null;
                    a6.b = 2;
                    if (interfaceC0615p4.emit(obj5, a6) == coroutine_suspended5) {
                        return coroutine_suspended5;
                    }
                }
                return Q.INSTANCE;
            case 5:
                if (gVar instanceof C1) {
                    c6 = (C1) gVar;
                    int i15 = c6.b;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        c6.b = i15 - Integer.MIN_VALUE;
                    } else {
                        c6 = new C1(this, gVar);
                    }
                } else {
                    c6 = new C1(this, gVar);
                }
                Object obj13 = c6.f3788a;
                Object coroutine_suspended6 = i.getCOROUTINE_SUSPENDED();
                int i16 = c6.b;
                if (i16 != 0) {
                    if (i16 == 1) {
                        interfaceC0615p5 = c6.d;
                        v.throwOnFailure(obj13);
                    } else {
                        if (i16 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj13);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj13);
                InterfaceC0615p interfaceC0615p13 = this.b;
                c6.d = interfaceC0615p13;
                c6.b = 1;
                Object objInvoke6 = this.c.invoke(obj, c6);
                if (objInvoke6 == coroutine_suspended6) {
                    return coroutine_suspended6;
                }
                obj13 = objInvoke6;
                interfaceC0615p5 = interfaceC0615p13;
                c6.d = null;
                c6.b = 2;
                if (interfaceC0615p5.emit(obj13, c6) == coroutine_suspended6) {
                    return coroutine_suspended6;
                }
                return Q.INSTANCE;
            case 6:
                if (gVar instanceof D1) {
                    d1 = (D1) gVar;
                    int i17 = d1.b;
                    if ((i17 & Integer.MIN_VALUE) != 0) {
                        d1.b = i17 - Integer.MIN_VALUE;
                    } else {
                        d1 = new D1(this, gVar);
                    }
                } else {
                    d1 = new D1(this, gVar);
                }
                Object obj14 = d1.f3790a;
                Object coroutine_suspended7 = i.getCOROUTINE_SUSPENDED();
                int i18 = d1.b;
                if (i18 != 0) {
                    if (i18 == 1) {
                        interfaceC0615p6 = d1.d;
                        v.throwOnFailure(obj14);
                    } else {
                        if (i18 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj14);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj14);
                InterfaceC0615p interfaceC0615p14 = this.b;
                d1.d = interfaceC0615p14;
                d1.b = 1;
                Object objInvoke7 = this.c.invoke(obj, d1);
                if (objInvoke7 == coroutine_suspended7) {
                    return coroutine_suspended7;
                }
                obj14 = objInvoke7;
                interfaceC0615p6 = interfaceC0615p14;
                if (obj14 != null) {
                    d1.d = null;
                    d1.b = 2;
                    if (interfaceC0615p6.emit(obj14, d1) == coroutine_suspended7) {
                        return coroutine_suspended7;
                    }
                }
                return Q.INSTANCE;
            default:
                if (gVar instanceof E1) {
                    e1 = (E1) gVar;
                    int i19 = e1.b;
                    if ((i19 & Integer.MIN_VALUE) != 0) {
                        e1.b = i19 - Integer.MIN_VALUE;
                    } else {
                        e1 = new E1(this, gVar);
                    }
                } else {
                    e1 = new E1(this, gVar);
                }
                Object obj15 = e1.f3794a;
                Object coroutine_suspended8 = i.getCOROUTINE_SUSPENDED();
                int i20 = e1.b;
                if (i20 != 0) {
                    if (i20 == 1) {
                        interfaceC0615p7 = e1.e;
                        obj6 = e1.d;
                        v.throwOnFailure(obj15);
                    } else {
                        if (i20 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj15);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj15);
                e1.d = obj;
                InterfaceC0615p interfaceC0615p15 = this.b;
                e1.e = interfaceC0615p15;
                e1.b = 1;
                if (this.c.invoke(obj, e1) == coroutine_suspended8) {
                    return coroutine_suspended8;
                }
                obj6 = obj;
                interfaceC0615p7 = interfaceC0615p15;
                e1.d = null;
                e1.e = null;
                e1.b = 2;
                if (interfaceC0615p7.emit(obj6, e1) == coroutine_suspended8) {
                    return coroutine_suspended8;
                }
                return Q.INSTANCE;
        }
    }

    public P0(InterfaceC0615p interfaceC0615p, p pVar) {
        this.f3822a = 0;
        this.c = pVar;
        this.b = interfaceC0615p;
    }
}
