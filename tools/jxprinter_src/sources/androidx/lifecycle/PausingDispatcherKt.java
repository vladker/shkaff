package androidx.lifecycle;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.H0;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcherKt {

    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, p pVar, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = pVar;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, gVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super T> gVar) {
            return ((AnonymousClass2) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    v.throwOnFailure(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            v.throwOnFailure(obj);
            H0 h1 = (H0) ((M) this.L$0).getCoroutineContext().get(H0.Key);
            if (h1 == null) {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, h1);
            try {
                p pVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = AbstractC0272e.withContext(pausingDispatcher, pVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }
    }

    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p pVar, g<? super T> gVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, gVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p pVar, g<? super T> gVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, gVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p pVar, g<? super T> gVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, gVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p pVar, g<? super T> gVar) {
        return AbstractC0272e.withContext(C0276f0.getMain().getImmediate(), new AnonymousClass2(lifecycle, state, pVar, null), gVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p pVar, g<? super T> gVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, gVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p pVar, g<? super T> gVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, gVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p pVar, g<? super T> gVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, gVar);
    }
}
