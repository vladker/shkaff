package p044h4;

import A3.G;
import A3.T;
import E3.g;
import E3.q;
import F3.h;
import F3.i;
import O3.l;
import O3.p;
import h4.m.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p007a4.AbstractC0293o;
import p007a4.C0289m;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0283j;
import p007a4.InterfaceC0285k;
import p028e4.E;
import p028e4.H;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class m implements InterfaceC0283j, e, p {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "state$volatile");
    private final q context;
    private Object disposableHandleOrSegment;
    private volatile /* synthetic */ Object state$volatile = r.STATE_REG;
    private List<a> clauses = new ArrayList(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4034a = -1;
    private Object internalResult = r.NO_RESULT;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class a {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final O3.q onCancellationConstructor;
        private final Object param;
        private final O3.q processResFunc;
        private final O3.q regFunc;

        public a(Object obj, O3.q qVar, O3.q qVar2, Object obj2, Object obj3, O3.q qVar3) {
            this.clauseObject = obj;
            this.regFunc = qVar;
            this.processResFunc = qVar2;
            this.param = obj2;
            this.block = obj3;
            this.onCancellationConstructor = qVar3;
        }

        public final void a() {
            Object obj = this.disposableHandleOrSegment;
            if (obj instanceof E) {
                ((E) obj).onCancellation(this.indexInSegment, null, m.this.getContext());
                return;
            }
            InterfaceC0280h0 interfaceC0280h0 = obj instanceof InterfaceC0280h0 ? (InterfaceC0280h0) obj : null;
            if (interfaceC0280h0 != null) {
                interfaceC0280h0.dispose();
            }
        }

        public final O3.q createOnCancellationAction(o oVar, Object obj) {
            O3.q qVar = this.onCancellationConstructor;
            if (qVar != null) {
                return (O3.q) qVar.invoke(oVar, this.param, obj);
            }
            return null;
        }

        public final Object invokeBlock(Object obj, g<Object> gVar) {
            Object obj2 = this.block;
            if (this.param == r.getPARAM_CLAUSE_0()) {
                kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((l) obj2).invoke(gVar);
            }
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((p) obj2).invoke(obj, gVar);
        }

        public final Object processResult(Object obj) {
            return this.processResFunc.invoke(this.clauseObject, this.param, obj);
        }

        public final boolean tryRegisterAsWaiter(m mVar) {
            this.regFunc.invoke(this.clauseObject, mVar, this.param);
            return mVar.internalResult == r.NO_RESULT;
        }
    }

    public m(q qVar) {
        this.context = qVar;
    }

    public static <R> Object doSelect$suspendImpl(m mVar, g<? super R> gVar) {
        mVar.getClass();
        return b.get(mVar) instanceof a ? mVar.b(gVar) : mVar.c(gVar);
    }

    public final Object b(g gVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        Object obj = atomicReferenceFieldUpdater.get(this);
        kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        a aVar = (a) obj;
        Object obj2 = this.internalResult;
        List<a> list = this.clauses;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2 != aVar) {
                    aVar2.a();
                }
            }
            atomicReferenceFieldUpdater.set(this, r.STATE_COMPLETED);
            this.internalResult = r.NO_RESULT;
            this.clauses = null;
        }
        return aVar.invokeBlock(aVar.processResult(obj2), gVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(g gVar) throws Throwable {
        n nVar;
        m mVar;
        if (gVar instanceof n) {
            nVar = (n) gVar;
            int i5 = nVar.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                nVar.d = i5 - Integer.MIN_VALUE;
            } else {
                nVar = new n(this, gVar);
            }
        } else {
            nVar = new n(this, gVar);
        }
        Object obj = nVar.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = nVar.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            nVar.f4036a = this;
            nVar.d = 1;
            C0289m c0289m = new C0289m(h.intercepted(nVar), 1);
            c0289m.initCancellability();
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                if (obj2 == r.STATE_REG) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0289m)) {
                            AbstractC0293o.invokeOnCancellation(c0289m, this);
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj2);
                } else {
                    if (!(obj2 instanceof List)) {
                        if (obj2 instanceof a) {
                            c0289m.resume(Q.INSTANCE, ((a) obj2).createOnCancellationAction(this, this.internalResult));
                            break;
                        }
                        throw new IllegalStateException(("unexpected state: " + obj2).toString());
                    }
                    H h6 = r.STATE_REG;
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, h6)) {
                            Iterator it = ((Iterable) obj2).iterator();
                            while (it.hasNext()) {
                                a aVarD = d(it.next());
                                kotlin.jvm.internal.E.c(aVarD);
                                aVarD.disposableHandleOrSegment = null;
                                aVarD.indexInSegment = -1;
                                register(aVarD, true);
                            }
                            break;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj2);
                }
            }
            Object result = c0289m.getResult();
            if (result == i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(nVar);
            }
            if (result != i.getCOROUTINE_SUSPENDED()) {
                result = Q.INSTANCE;
            }
            if (result != coroutine_suspended) {
                mVar = this;
            }
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return obj;
        }
        mVar = nVar.f4036a;
        v.throwOnFailure(obj);
        nVar.f4036a = null;
        nVar.d = 2;
        Object objB = mVar.b(nVar);
        return objB == coroutine_suspended ? coroutine_suspended : objB;
    }

    public final a d(Object obj) {
        List<a> list = this.clauses;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        for (Object obj3 : list) {
            if (((a) obj3).clauseObject == obj) {
                obj2 = obj3;
                break;
            }
        }
        a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    @Override // p044h4.p, p044h4.o
    public void disposeOnCompletion(InterfaceC0280h0 interfaceC0280h0) {
        this.disposableHandleOrSegment = interfaceC0280h0;
    }

    public Object doSelect(g<Object> gVar) {
        return doSelect$suspendImpl(this, gVar);
    }

    public final int e(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof InterfaceC0285k)) {
                if (kotlin.jvm.internal.E.a(obj3, r.STATE_COMPLETED) || (obj3 instanceof a)) {
                    return 3;
                }
                if (kotlin.jvm.internal.E.a(obj3, r.STATE_CANCELLED)) {
                    return 2;
                }
                if (kotlin.jvm.internal.E.a(obj3, r.STATE_REG)) {
                    List listListOf = G.listOf(obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, listListOf)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        }
                    }
                    return 1;
                }
                if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
                List listPlus = T.plus((Collection<? extends Object>) obj3, obj);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, listPlus)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                    }
                }
                return 1;
            }
            a aVarD = d(obj);
            if (aVarD == null) {
                continue;
            } else {
                O3.q qVarCreateOnCancellationAction = aVarD.createOnCancellationAction(this, obj2);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, aVarD)) {
                        InterfaceC0285k interfaceC0285k = (InterfaceC0285k) obj3;
                        this.internalResult = obj2;
                        int i5 = r.f4038a;
                        Object objTryResume = interfaceC0285k.tryResume(Q.INSTANCE, null, qVarCreateOnCancellationAction);
                        if (objTryResume == null) {
                            this.internalResult = r.NO_RESULT;
                            return 2;
                        }
                        interfaceC0285k.completeResume(objTryResume);
                        return 0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj3);
            }
        }
    }

    @Override // p044h4.p, p044h4.o
    public q getContext() {
        return this.context;
    }

    @Override // p044h4.e
    public <P, Q> void invoke(j jVar, p pVar) {
        d.invoke(this, jVar, pVar);
    }

    @Override // p044h4.p, p007a4.B1
    public void invokeOnCancellation(E e, int i5) {
        this.disposableHandleOrSegment = e;
        this.f4034a = i5;
    }

    @Override // p044h4.e
    public void onTimeout(long j6, l lVar) {
        d.onTimeout(this, j6, lVar);
    }

    public final void register(a aVar, boolean z6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        if (atomicReferenceFieldUpdater.get(this) instanceof a) {
            return;
        }
        if (!z6) {
            Object obj = aVar.clauseObject;
            List<a> list = this.clauses;
            kotlin.jvm.internal.E.c(list);
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((a) it.next()).clauseObject == obj) {
                        throw new IllegalStateException(androidx.collection.a.l(obj, "Cannot use select clauses on the same object: ").toString());
                    }
                }
            }
        }
        if (!aVar.tryRegisterAsWaiter(this)) {
            atomicReferenceFieldUpdater.set(this, aVar);
            return;
        }
        if (!z6) {
            List<a> list2 = this.clauses;
            kotlin.jvm.internal.E.c(list2);
            list2.add(aVar);
        }
        aVar.disposableHandleOrSegment = this.disposableHandleOrSegment;
        aVar.indexInSegment = this.f4034a;
        this.disposableHandleOrSegment = null;
        this.f4034a = -1;
    }

    @Override // p044h4.p, p044h4.o
    public void selectInRegistrationPhase(Object obj) {
        this.internalResult = obj;
    }

    @Override // p044h4.p, p044h4.o
    public boolean trySelect(Object obj, Object obj2) {
        return e(obj, obj2) == 0;
    }

    public final s trySelectDetailed(Object obj, Object obj2) {
        int iE = e(obj, obj2);
        int i5 = r.f4038a;
        if (iE == 0) {
            return s.f4039a;
        }
        if (iE == 1) {
            return s.b;
        }
        if (iE == 2) {
            return s.c;
        }
        if (iE == 3) {
            return s.d;
        }
        throw new IllegalStateException(("Unexpected internal result: " + iE).toString());
    }

    @Override // p044h4.e
    public void invoke(f fVar, l lVar) {
        register(new a(fVar.getClauseObject(), fVar.getRegFunc(), fVar.getProcessResFunc(), r.getPARAM_CLAUSE_0(), lVar, fVar.getOnCancellationConstructor()), false);
    }

    @Override // p044h4.e
    public <Q> void invoke(h hVar, p pVar) {
        register(new a(hVar.getClauseObject(), hVar.getRegFunc(), hVar.getProcessResFunc(), null, pVar, hVar.getOnCancellationConstructor()), false);
    }

    @Override // p044h4.e
    public <P, Q> void invoke(j jVar, P p6, p pVar) {
        register(new a(jVar.getClauseObject(), jVar.getRegFunc(), jVar.getProcessResFunc(), p6, pVar, jVar.getOnCancellationConstructor()), false);
    }

    @Override // p007a4.InterfaceC0283j
    public void invoke(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == r.STATE_COMPLETED) {
                return;
            }
            H h6 = r.STATE_CANCELLED;
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, h6)) {
                    List<a> list = this.clauses;
                    if (list == null) {
                        return;
                    }
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).a();
                    }
                    this.internalResult = r.NO_RESULT;
                    this.clauses = null;
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }
}
