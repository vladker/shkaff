package p023d4;

import E3.g;
import F3.i;
import O3.p;
import O3.q;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.A;
import kotlinx.coroutines.flow.internal.C1112a;
import kotlinx.coroutines.flow.internal.E;
import p147z3.v;

/* JADX INFO: renamed from: d4.t1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0628t1 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object first(InterfaceC0612o interfaceC0612o, g<? super T> gVar) throws Throwable {
        C0587f1 c0587f1;
        T t6;
        C1112a e;
        C0578c1 c0578c1;
        if (gVar instanceof C0587f1) {
            c0587f1 = (C0587f1) gVar;
            int i5 = c0587f1.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0587f1.d = i5 - Integer.MIN_VALUE;
            } else {
                c0587f1 = new C0587f1(gVar);
            }
        } else {
            c0587f1 = new C0587f1(gVar);
        }
        Object obj = c0587f1.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0587f1.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = E.NULL;
            C0578c1 c0578c2 = new C0578c1(0, t7);
            try {
                c0587f1.f3869a = t7;
                c0587f1.b = c0578c2;
                c0587f1.d = 1;
                if (interfaceC0612o.collect(c0578c2, c0587f1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t6 = t7;
            } catch (C1112a e6) {
                t6 = t7;
                e = e6;
                c0578c1 = c0578c2;
                A.checkOwnership(e, c0578c1);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0578c1 = c0587f1.b;
            t6 = c0587f1.f3869a;
            try {
                v.throwOnFailure(obj);
            } catch (C1112a e7) {
                e = e7;
                A.checkOwnership(e, c0578c1);
            }
        }
        Object obj2 = t6.f5689a;
        if (obj2 != E.NULL) {
            return obj2;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object firstOrNull(InterfaceC0612o interfaceC0612o, g<? super T> gVar) throws Throwable {
        C0596i1 c0596i1;
        T t6;
        C1112a e;
        C0578c1 c0578c1;
        if (gVar instanceof C0596i1) {
            c0596i1 = (C0596i1) gVar;
            int i5 = c0596i1.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0596i1.d = i5 - Integer.MIN_VALUE;
            } else {
                c0596i1 = new C0596i1(gVar);
            }
        } else {
            c0596i1 = new C0596i1(gVar);
        }
        Object obj = c0596i1.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0596i1.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            C0578c1 c0578c2 = new C0578c1(1, t7);
            try {
                c0596i1.f3877a = t7;
                c0596i1.b = c0578c2;
                c0596i1.d = 1;
                if (interfaceC0612o.collect(c0578c2, c0596i1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t6 = t7;
            } catch (C1112a e6) {
                t6 = t7;
                e = e6;
                c0578c1 = c0578c2;
                A.checkOwnership(e, c0578c1);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0578c1 = c0596i1.b;
            t6 = c0596i1.f3877a;
            try {
                v.throwOnFailure(obj);
            } catch (C1112a e7) {
                e = e7;
                A.checkOwnership(e, c0578c1);
            }
        }
        return t6.f5689a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T, R> Object fold(InterfaceC0612o interfaceC0612o, R r6, q qVar, g<? super R> gVar) throws Throwable {
        C0602k1 c0602k1;
        T t6;
        if (gVar instanceof C0602k1) {
            c0602k1 = (C0602k1) gVar;
            int i5 = c0602k1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0602k1.c = i5 - Integer.MIN_VALUE;
            } else {
                c0602k1 = new C0602k1(gVar);
            }
        } else {
            c0602k1 = new C0602k1(gVar);
        }
        Object obj = c0602k1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0602k1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = r6;
            InterfaceC0615p c0608m1 = new C0608m1(t7, qVar, 0);
            c0602k1.f3884a = t7;
            c0602k1.c = 1;
            if (interfaceC0612o.collect(c0608m1, c0602k1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t6 = t7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = c0602k1.f3884a;
            v.throwOnFailure(obj);
        }
        return t6.f5689a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object last(InterfaceC0612o interfaceC0612o, g<? super T> gVar) throws Throwable {
        C0611n1 c0611n1;
        T t6;
        if (gVar instanceof C0611n1) {
            c0611n1 = (C0611n1) gVar;
            int i5 = c0611n1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0611n1.c = i5 - Integer.MIN_VALUE;
            } else {
                c0611n1 = new C0611n1(gVar);
            }
        } else {
            c0611n1 = new C0611n1(gVar);
        }
        Object obj = c0611n1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0611n1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = E.NULL;
            InterfaceC0615p c0578c1 = new C0578c1(2, t7);
            c0611n1.f3893a = t7;
            c0611n1.c = 1;
            if (interfaceC0612o.collect(c0578c1, c0611n1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t6 = t7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = c0611n1.f3893a;
            v.throwOnFailure(obj);
        }
        Object obj2 = t6.f5689a;
        if (obj2 != E.NULL) {
            return obj2;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object lastOrNull(InterfaceC0612o interfaceC0612o, g<? super T> gVar) throws Throwable {
        C0614o1 c0614o1;
        T t6;
        if (gVar instanceof C0614o1) {
            c0614o1 = (C0614o1) gVar;
            int i5 = c0614o1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0614o1.c = i5 - Integer.MIN_VALUE;
            } else {
                c0614o1 = new C0614o1(gVar);
            }
        } else {
            c0614o1 = new C0614o1(gVar);
        }
        Object obj = c0614o1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0614o1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            InterfaceC0615p c0578c1 = new C0578c1(3, t7);
            c0614o1.f3896a = t7;
            c0614o1.c = 1;
            if (interfaceC0612o.collect(c0578c1, c0614o1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t6 = t7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = c0614o1.f3896a;
            v.throwOnFailure(obj);
        }
        return t6.f5689a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <S, T extends S> Object reduce(InterfaceC0612o interfaceC0612o, q qVar, g<? super S> gVar) throws Throwable {
        C0617p1 c0617p1;
        T t6;
        if (gVar instanceof C0617p1) {
            c0617p1 = (C0617p1) gVar;
            int i5 = c0617p1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0617p1.c = i5 - Integer.MIN_VALUE;
            } else {
                c0617p1 = new C0617p1(gVar);
            }
        } else {
            c0617p1 = new C0617p1(gVar);
        }
        Object obj = c0617p1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0617p1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = E.NULL;
            InterfaceC0615p c0608m1 = new C0608m1(t7, qVar, 1);
            c0617p1.f3902a = t7;
            c0617p1.c = 1;
            if (interfaceC0612o.collect(c0608m1, c0617p1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t6 = t7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = c0617p1.f3902a;
            v.throwOnFailure(obj);
        }
        Object obj2 = t6.f5689a;
        if (obj2 != E.NULL) {
            return obj2;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object single(InterfaceC0612o interfaceC0612o, g<? super T> gVar) throws Throwable {
        C0622r1 c0622r1;
        T t6;
        if (gVar instanceof C0622r1) {
            c0622r1 = (C0622r1) gVar;
            int i5 = c0622r1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0622r1.c = i5 - Integer.MIN_VALUE;
            } else {
                c0622r1 = new C0622r1(gVar);
            }
        } else {
            c0622r1 = new C0622r1(gVar);
        }
        Object obj = c0622r1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0622r1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = E.NULL;
            InterfaceC0615p c0578c1 = new C0578c1(4, t7);
            c0622r1.f3907a = t7;
            c0622r1.c = 1;
            if (interfaceC0612o.collect(c0578c1, c0622r1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t6 = t7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = c0622r1.f3907a;
            v.throwOnFailure(obj);
        }
        Object obj2 = t6.f5689a;
        if (obj2 != E.NULL) {
            return obj2;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object singleOrNull(InterfaceC0612o interfaceC0612o, g<? super T> gVar) throws Throwable {
        C0625s1 c0625s1;
        T t6;
        C1112a e;
        C0578c1 c0578c1;
        if (gVar instanceof C0625s1) {
            c0625s1 = (C0625s1) gVar;
            int i5 = c0625s1.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0625s1.d = i5 - Integer.MIN_VALUE;
            } else {
                c0625s1 = new C0625s1(gVar);
            }
        } else {
            c0625s1 = new C0625s1(gVar);
        }
        Object obj = c0625s1.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0625s1.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = E.NULL;
            C0578c1 c0578c2 = new C0578c1(5, t7);
            try {
                c0625s1.f3910a = t7;
                c0625s1.b = c0578c2;
                c0625s1.d = 1;
                if (interfaceC0612o.collect(c0578c2, c0625s1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t6 = t7;
            } catch (C1112a e6) {
                t6 = t7;
                e = e6;
                c0578c1 = c0578c2;
                A.checkOwnership(e, c0578c1);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0578c1 = c0625s1.b;
            t6 = c0625s1.f3910a;
            try {
                v.throwOnFailure(obj);
            } catch (C1112a e7) {
                e = e7;
                A.checkOwnership(e, c0578c1);
            }
        }
        Object obj2 = t6.f5689a;
        if (obj2 == E.NULL) {
            return null;
        }
        return obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object firstOrNull(InterfaceC0612o interfaceC0612o, p pVar, g<? super T> gVar) throws Throwable {
        C0599j1 c0599j1;
        T t6;
        C1112a e;
        C0584e1 c0584e1;
        if (gVar instanceof C0599j1) {
            c0599j1 = (C0599j1) gVar;
            int i5 = c0599j1.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0599j1.d = i5 - Integer.MIN_VALUE;
            } else {
                c0599j1 = new C0599j1(gVar);
            }
        } else {
            c0599j1 = new C0599j1(gVar);
        }
        Object obj = c0599j1.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0599j1.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            C0584e1 c0584e2 = new C0584e1(pVar, t7, 1);
            try {
                c0599j1.f3879a = t7;
                c0599j1.b = c0584e2;
                c0599j1.d = 1;
                if (interfaceC0612o.collect(c0584e2, c0599j1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t6 = t7;
            } catch (C1112a e6) {
                t6 = t7;
                e = e6;
                c0584e1 = c0584e2;
                A.checkOwnership(e, c0584e1);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0584e1 = c0599j1.b;
            t6 = c0599j1.f3879a;
            try {
                v.throwOnFailure(obj);
            } catch (C1112a e7) {
                e = e7;
                A.checkOwnership(e, c0584e1);
            }
        }
        return t6.f5689a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object first(InterfaceC0612o interfaceC0612o, p pVar, g<? super T> gVar) throws Throwable {
        C0590g1 c0590g1;
        p pVar2;
        T t6;
        C1112a e;
        C0584e1 c0584e1;
        if (gVar instanceof C0590g1) {
            c0590g1 = (C0590g1) gVar;
            int i5 = c0590g1.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0590g1.e = i5 - Integer.MIN_VALUE;
            } else {
                c0590g1 = new C0590g1(gVar);
            }
        } else {
            c0590g1 = new C0590g1(gVar);
        }
        Object obj = c0590g1.d;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0590g1.e;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            T t7 = new T();
            t7.f5689a = E.NULL;
            C0584e1 c0584e2 = new C0584e1(pVar, t7, 0);
            try {
                c0590g1.f3871a = pVar;
                c0590g1.b = t7;
                c0590g1.c = c0584e2;
                c0590g1.e = 1;
                if (interfaceC0612o.collect(c0584e2, c0590g1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pVar2 = pVar;
                t6 = t7;
            } catch (C1112a e6) {
                pVar2 = pVar;
                t6 = t7;
                e = e6;
                c0584e1 = c0584e2;
                A.checkOwnership(e, c0584e1);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0584e1 = c0590g1.c;
            t6 = c0590g1.b;
            pVar2 = c0590g1.f3871a;
            try {
                v.throwOnFailure(obj);
            } catch (C1112a e7) {
                e = e7;
                A.checkOwnership(e, c0584e1);
            }
        }
        Object obj2 = t6.f5689a;
        if (obj2 != E.NULL) {
            return obj2;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + pVar2);
    }
}
