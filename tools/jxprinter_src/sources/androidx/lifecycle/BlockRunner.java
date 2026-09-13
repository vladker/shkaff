package androidx.lifecycle;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import androidx.annotation.MainThread;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0261a0;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.H0;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class BlockRunner<T> {
    private final p block;
    private H0 cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final O3.a onDone;
    private H0 runningJob;
    private final M scope;
    private final long timeoutInMs;

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BlockRunner<T> blockRunner, g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.this$0 = blockRunner;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass1(this.this$0, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((AnonymousClass1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                long j6 = ((BlockRunner) this.this$0).timeoutInMs;
                this.label = 1;
                if (AbstractC0261a0.delay(j6, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            if (!((BlockRunner) this.this$0).liveData.hasActiveObservers()) {
                H0 h1 = ((BlockRunner) this.this$0).runningJob;
                if (h1 != null) {
                    h1.cancel((CancellationException) null);
                }
                ((BlockRunner) this.this$0).runningJob = null;
            }
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03471 extends m implements p {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03471(BlockRunner<T> blockRunner, g<? super C03471> gVar) {
            super(2, gVar);
            this.this$0 = blockRunner;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            C03471 c03471 = new C03471(this.this$0, gVar);
            c03471.L$0 = obj;
            return c03471;
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((C03471) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(((BlockRunner) this.this$0).liveData, ((M) this.L$0).getCoroutineContext());
                p pVar = ((BlockRunner) this.this$0).block;
                this.label = 1;
                if (pVar.invoke(liveDataScopeImpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            ((BlockRunner) this.this$0).onDone.invoke();
            return Q.INSTANCE;
        }
    }

    public BlockRunner(CoroutineLiveData<T> liveData, p block, long j6, M scope, O3.a onDone) {
        E.f(liveData, "liveData");
        E.f(block, "block");
        E.f(scope, "scope");
        E.f(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j6;
        this.scope = scope;
        this.onDone = onDone;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
        }
        this.cancellationJob = AbstractC0272e.b(this.scope, C0276f0.getMain().getImmediate(), 2, new AnonymousClass1(this, null));
    }

    @MainThread
    public final void maybeRun() {
        H0 h1 = this.cancellationJob;
        if (h1 != null) {
            h1.cancel((CancellationException) null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = AbstractC0272e.b(this.scope, null, 3, new C03471(this, null));
    }
}
