package androidx.window.layout;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.layout.adapter.WindowBackend;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.C0276f0;
import p018c4.v0;
import p018c4.x0;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class AnonymousClass2 extends F implements O3.a {
            final /* synthetic */ Consumer<WindowLayoutInfo> $listener;
            final /* synthetic */ WindowInfoTrackerImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(WindowInfoTrackerImpl windowInfoTrackerImpl, Consumer<WindowLayoutInfo> consumer) {
                super(0);
                this.this$0 = windowInfoTrackerImpl;
                this.$listener = consumer;
            }

            @Override // O3.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m996invoke();
                return Q.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m996invoke() {
                this.this$0.windowBackend.unregisterLayoutChangeCallback(this.$listener);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.$context = context;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass1 anonymousClass1 = WindowInfoTrackerImpl.this.new AnonymousClass1(this.$context, gVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // O3.p
        public final Object invoke(x0 x0Var, g<? super Q> gVar) {
            return ((AnonymousClass1) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                x0 x0Var = (x0) this.L$0;
                a aVar = new a(x0Var, 0);
                WindowInfoTrackerImpl.this.windowBackend.registerLayoutChangeCallback(this.$context, new androidx.arch.core.executor.a(2), aVar);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(WindowInfoTrackerImpl.this, aVar);
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

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2", f = "WindowInfoTrackerImpl.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class C00092 extends F implements O3.a {
            final /* synthetic */ Consumer<WindowLayoutInfo> $listener;
            final /* synthetic */ WindowInfoTrackerImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00092(WindowInfoTrackerImpl windowInfoTrackerImpl, Consumer<WindowLayoutInfo> consumer) {
                super(0);
                this.this$0 = windowInfoTrackerImpl;
                this.$listener = consumer;
            }

            @Override // O3.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m997invoke();
                return Q.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m997invoke() {
                this.this$0.windowBackend.unregisterLayoutChangeCallback(this.$listener);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.$activity = activity;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass2 anonymousClass2 = WindowInfoTrackerImpl.this.new AnonymousClass2(this.$activity, gVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // O3.p
        public final Object invoke(x0 x0Var, g<? super Q> gVar) {
            return ((AnonymousClass2) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                x0 x0Var = (x0) this.L$0;
                a aVar = new a(x0Var, 1);
                WindowInfoTrackerImpl.this.windowBackend.registerLayoutChangeCallback(this.$activity, new androidx.arch.core.executor.a(2), aVar);
                C00092 c00092 = new C00092(WindowInfoTrackerImpl.this, aVar);
                this.label = 1;
                if (v0.awaitClose(x0Var, c00092, this) == coroutine_suspended) {
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

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        E.f(windowMetricsCalculator, "windowMetricsCalculator");
        E.f(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public InterfaceC0612o windowLayoutInfo(Context context) {
        E.f(context, "context");
        return AbstractC0618q.flowOn(AbstractC0618q.callbackFlow(new AnonymousClass1(context, null)), C0276f0.getMain());
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public InterfaceC0612o windowLayoutInfo(Activity activity) {
        E.f(activity, "activity");
        return AbstractC0618q.flowOn(AbstractC0618q.callbackFlow(new AnonymousClass2(activity, null)), C0276f0.getMain());
    }
}
