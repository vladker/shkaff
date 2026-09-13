package androidx.core.os;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import android.content.Context;
import android.os.ProfilingManager;
import android.os.ProfilingResult;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p018c4.v0;
import p018c4.x0;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class Profiling {
    private static final String KEY_BUFFER_FILL_POLICY = "KEY_BUFFER_FILL_POLICY";
    private static final String KEY_DURATION_MS = "KEY_DURATION_MS";
    private static final String KEY_FREQUENCY_HZ = "KEY_FREQUENCY_HZ";
    private static final String KEY_SAMPLING_INTERVAL_BYTES = "KEY_SAMPLING_INTERVAL_BYTES";
    private static final String KEY_SIZE_KB = "KEY_SIZE_KB";
    private static final String KEY_TRACK_JAVA_ALLOCATIONS = "KEY_TRACK_JAVA_ALLOCATIONS";
    private static final int VALUE_BUFFER_FILL_POLICY_DISCARD = 1;
    private static final int VALUE_BUFFER_FILL_POLICY_RING_BUFFER = 2;

    /* JADX INFO: renamed from: androidx.core.os.Profiling$registerForAllProfilingResults$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.core.os.Profiling$registerForAllProfilingResults$1", f = "Profiling.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.core.os.Profiling$registerForAllProfilingResults$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class AnonymousClass2 extends F implements O3.a {
            final /* synthetic */ Consumer<ProfilingResult> $listener;
            final /* synthetic */ ProfilingManager $service;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ProfilingManager profilingManager, Consumer<ProfilingResult> consumer) {
                super(0);
                this.$service = profilingManager;
                this.$listener = consumer;
            }

            @Override // O3.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m974invoke();
                return Q.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m974invoke() {
                this.$service.unregisterForAllProfilingResults(this.$listener);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(x0 x0Var, ProfilingResult result) {
            E.e(result, "result");
            x0Var.mo1011trySendJP2dKIU(result);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, gVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // O3.p
        public final Object invoke(x0 x0Var, g<? super Q> gVar) {
            return ((AnonymousClass1) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.core.os.a, java.util.function.Consumer] */
        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                final x0 x0Var = (x0) this.L$0;
                ?? r6 = new Consumer() { // from class: androidx.core.os.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj2) {
                        Profiling.AnonymousClass1.invokeSuspend$lambda$0(x0Var, (ProfilingResult) obj2);
                    }
                };
                ProfilingManager profilingManagerR = X2.a.r(this.$context.getSystemService(X2.a.s()));
                profilingManagerR.registerForAllProfilingResults(new b(), r6);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(profilingManagerR, r6);
                this.label = 1;
                if (v0.awaitClose(x0Var, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            return Q.INSTANCE;
        }
    }

    @RequiresApi(api = 35)
    public static final InterfaceC0612o registerForAllProfilingResults(Context context) {
        E.f(context, "context");
        return AbstractC0618q.callbackFlow(new AnonymousClass1(context, null));
    }

    @RequiresApi(api = 35)
    public static final void requestProfiling(Context context, ProfilingRequest profilingRequest, Executor executor, Consumer<ProfilingResult> consumer) {
        E.f(context, "context");
        E.f(profilingRequest, "profilingRequest");
        X2.a.r(context.getSystemService(X2.a.s())).requestProfiling(profilingRequest.getProfilingType(), profilingRequest.getParams(), profilingRequest.getTag(), profilingRequest.getCancellationSignal(), executor, consumer);
    }

    @RequiresApi(api = 35)
    public static final void unregisterForAllProfilingResults(Context context, Consumer<ProfilingResult> listener) {
        E.f(context, "context");
        E.f(listener, "listener");
        X2.a.r(context.getSystemService(X2.a.s())).unregisterForAllProfilingResults(listener);
    }

    @RequiresApi(api = 35)
    public static final void registerForAllProfilingResults(Context context, Executor executor, Consumer<ProfilingResult> listener) {
        E.f(context, "context");
        E.f(executor, "executor");
        E.f(listener, "listener");
        X2.a.r(context.getSystemService(X2.a.s())).registerForAllProfilingResults(executor, listener);
    }
}
