package androidx.datastore.core;

import E3.g;
import G3.d;
import G3.f;
import org.opencv.videoio.Videoio;
import p007a4.AbstractC0308w;
import p007a4.B0;
import p007a4.C0306v;
import p007a4.H0;
import p007a4.InterfaceC0304u;
import p007a4.X0;
import p049i4.b;
import p049i4.i;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RunOnce {
    private final b runMutex = i.Mutex(false);
    private final InterfaceC0304u didRun = AbstractC0308w.CompletableDeferred((H0) null);

    /* JADX INFO: renamed from: androidx.datastore.core.RunOnce$runIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", i = {0, 0, 1, 1}, l = {Videoio.CAP_PROP_XI_TRG_DELAY, 497}, m = "runIfNeeded", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1 extends d {
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
            return RunOnce.this.runIfNeeded(this);
        }
    }

    public final Object awaitComplete(g<? super Q> gVar) {
        Object objAwait = this.didRun.await(gVar);
        return objAwait == F3.i.getCOROUTINE_SUSPENDED() ? objAwait : Q.INSTANCE;
    }

    public abstract Object doRun(g<? super Q> gVar);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object runIfNeeded(g<? super Q> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        b bVar;
        RunOnce runOnce;
        b bVar2;
        Throwable th;
        RunOnce runOnce2;
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
                if (!(((X0) this.didRun).getState$kotlinx_coroutines_core() instanceof B0)) {
                    return Q.INSTANCE;
                }
                b bVar3 = this.runMutex;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = bVar3;
                anonymousClass1.label = 1;
                bVar = (p049i4.g) bVar3;
                if (bVar.lock(null, anonymousClass1) != coroutine_suspended) {
                    runOnce = this;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar2 = (b) anonymousClass1.L$1;
                runOnce2 = (RunOnce) anonymousClass1.L$0;
                try {
                    v.throwOnFailure(obj);
                    InterfaceC0304u interfaceC0304u = runOnce2.didRun;
                    Q q6 = Q.INSTANCE;
                    ((C0306v) interfaceC0304u).makeCompleting$kotlinx_coroutines_core(q6);
                    ((p049i4.g) bVar2).unlock(null);
                    return q6;
                } catch (Throwable th2) {
                    th = th2;
                    ((p049i4.g) bVar2).unlock(null);
                    throw th;
                }
            }
            b bVar4 = (b) anonymousClass1.L$1;
            runOnce = (RunOnce) anonymousClass1.L$0;
            v.throwOnFailure(obj);
            bVar = bVar4;
            if (!(((X0) runOnce.didRun).getState$kotlinx_coroutines_core() instanceof B0)) {
                Q q7 = Q.INSTANCE;
                ((p049i4.g) bVar).unlock(null);
                return q7;
            }
            anonymousClass1.L$0 = runOnce;
            anonymousClass1.L$1 = bVar;
            anonymousClass1.label = 2;
            if (runOnce.doRun(anonymousClass1) != coroutine_suspended) {
                bVar2 = bVar;
                runOnce2 = runOnce;
                InterfaceC0304u interfaceC0304u2 = runOnce2.didRun;
                Q q8 = Q.INSTANCE;
                ((C0306v) interfaceC0304u2).makeCompleting$kotlinx_coroutines_core(q8);
                ((p049i4.g) bVar2).unlock(null);
                return q8;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            bVar2 = bVar;
            th = th3;
            ((p049i4.g) bVar2).unlock(null);
            throw th;
        }
    }
}
