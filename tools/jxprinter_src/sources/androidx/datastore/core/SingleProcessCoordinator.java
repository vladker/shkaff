package androidx.datastore.core;

import E3.g;
import G3.d;
import G3.f;
import O3.l;
import O3.p;
import kotlin.jvm.internal.E;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p049i4.b;
import p049i4.i;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleProcessCoordinator implements InterProcessCoordinator {
    private final String filePath;
    private final b mutex;
    private final InterfaceC0612o updateNotifications;
    private final AtomicInt version;

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", i = {0, 0, 1}, l = {66, 41}, m = "lock", n = {"block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    public static final class AnonymousClass1<T> extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", i = {0, 0}, l = {50}, m = "tryLock", n = {"$this$withTryLock_u24default$iv", "locked$iv"}, s = {"L$0", "Z$0"})
    public static final class C03421<T> extends d {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C03421(g<? super C03421> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleProcessCoordinator.this.tryLock(null, this);
        }
    }

    public SingleProcessCoordinator(String filePath) {
        E.f(filePath, "filePath");
        this.filePath = filePath;
        this.mutex = i.Mutex(false);
        this.version = new AtomicInt(0);
        this.updateNotifications = AbstractC0618q.flow(new SingleProcessCoordinator$updateNotifications$1(null));
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public InterfaceC0612o getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(g<? super Integer> gVar) {
        return G3.b.boxInt(this.version.get());
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(g<? super Integer> gVar) {
        return G3.b.boxInt(this.version.incrementAndGet());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    public <T> Object lock(l lVar, g<? super T> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        b bVar;
        Throwable th;
        b bVar2;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                b bVar3 = this.mutex;
                anonymousClass1.L$0 = lVar;
                anonymousClass1.L$1 = bVar3;
                anonymousClass1.label = 1;
                bVar = (p049i4.g) bVar3;
                if (bVar.lock(null, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar2 = (b) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    ((p049i4.g) bVar2).unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    ((p049i4.g) bVar2).unlock(null);
                    throw th;
                }
            }
            b bVar4 = (b) anonymousClass1.L$1;
            l lVar2 = (l) anonymousClass1.L$0;
            v.throwOnFailure(obj);
            bVar = bVar4;
            lVar = lVar2;
            anonymousClass1.L$0 = bVar;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            Object objInvoke = lVar.invoke(anonymousClass1);
            if (objInvoke != coroutine_suspended) {
                b bVar5 = bVar;
                obj = objInvoke;
                bVar2 = bVar5;
                ((p049i4.g) bVar2).unlock(null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            b bVar6 = bVar;
            th = th3;
            bVar2 = bVar6;
            ((p049i4.g) bVar2).unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    public <T> Object tryLock(p pVar, g<? super T> gVar) throws Throwable {
        C03421 c03421;
        b bVar;
        Throwable th;
        boolean z6;
        if (gVar instanceof C03421) {
            c03421 = (C03421) gVar;
            int i5 = c03421.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c03421.label = i5 - Integer.MIN_VALUE;
            } else {
                c03421 = new C03421(gVar);
            }
        } else {
            c03421 = new C03421(gVar);
        }
        Object obj = c03421.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c03421.label;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z6 = c03421.Z$0;
            bVar = (b) c03421.L$0;
            try {
                v.throwOnFailure(obj);
                if (z6) {
                    ((p049i4.g) bVar).unlock(null);
                }
                return obj;
            } catch (Throwable th2) {
                th = th2;
                if (z6) {
                    ((p049i4.g) bVar).unlock(null);
                }
                throw th;
            }
        }
        v.throwOnFailure(obj);
        p049i4.g gVar2 = (p049i4.g) this.mutex;
        boolean zTryLock = gVar2.tryLock(null);
        try {
            Object objBoxBoolean = G3.b.boxBoolean(zTryLock);
            c03421.L$0 = gVar2;
            c03421.Z$0 = zTryLock;
            c03421.label = 1;
            Object objInvoke = pVar.invoke(objBoxBoolean, c03421);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = gVar2;
            obj = objInvoke;
            z6 = zTryLock;
            if (z6) {
                ((p049i4.g) bVar).unlock(null);
            }
            return obj;
        } catch (Throwable th3) {
            bVar = gVar2;
            th = th3;
            z6 = zTryLock;
            if (z6) {
                ((p049i4.g) bVar).unlock(null);
            }
            throw th;
        }
    }
}
