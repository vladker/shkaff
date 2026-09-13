package androidx.window.embedding;

import F3.i;
import G3.m;
import O3.l;
import O3.p;
import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import kotlin.jvm.internal.AbstractC1107v;
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
public final class SplitController {
    public static final Companion Companion = new Companion(null);
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final SplitController getInstance(Context context) {
            E.f(context, "context");
            return new SplitController(EmbeddingBackend.Companion.getInstance(context));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SplitSupportStatus {
        private final int rawValue;
        public static final Companion Companion = new Companion(null);
        public static final SplitSupportStatus SPLIT_AVAILABLE = new SplitSupportStatus(0);
        public static final SplitSupportStatus SPLIT_UNAVAILABLE = new SplitSupportStatus(1);
        public static final SplitSupportStatus SPLIT_ERROR_PROPERTY_NOT_DECLARED = new SplitSupportStatus(2);

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
                this();
            }

            private Companion() {
            }
        }

        private SplitSupportStatus(int i5) {
            this.rawValue = i5;
        }

        public String toString() {
            int i5 = this.rawValue;
            if (i5 == 0) {
                return "SplitSupportStatus: AVAILABLE";
            }
            if (i5 != 1) {
                return i5 != 2 ? "UNKNOWN" : "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED";
            }
            return "SplitSupportStatus: UNAVAILABLE";
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SplitController$splitInfoList$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @G3.f(c = "androidx.window.embedding.SplitController$splitInfoList$1", f = "SplitController.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.window.embedding.SplitController$splitInfoList$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class AnonymousClass2 extends F implements O3.a {
            final /* synthetic */ Consumer<List<SplitInfo>> $listener;
            final /* synthetic */ SplitController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(SplitController splitController, Consumer<List<SplitInfo>> consumer) {
                super(0);
                this.this$0 = splitController;
                this.$listener = consumer;
            }

            @Override // O3.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m995invoke();
                return Q.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m995invoke() {
                this.this$0.embeddingBackend.removeSplitListenerForActivity(this.$listener);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, E3.g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.$activity = activity;
        }

        @Override // G3.a
        public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
            AnonymousClass1 anonymousClass1 = SplitController.this.new AnonymousClass1(this.$activity, gVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // O3.p
        public final Object invoke(x0 x0Var, E3.g<? super Q> gVar) {
            return ((AnonymousClass1) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                final x0 x0Var = (x0) this.L$0;
                Consumer<List<SplitInfo>> consumer = new Consumer() { // from class: androidx.window.embedding.g
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj2) {
                        x0Var.mo1011trySendJP2dKIU((List) obj2);
                    }
                };
                SplitController.this.embeddingBackend.addSplitListenerForActivity(this.$activity, new androidx.arch.core.executor.a(2), consumer);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(SplitController.this, consumer);
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

    public SplitController(EmbeddingBackend embeddingBackend) {
        E.f(embeddingBackend, "embeddingBackend");
        this.embeddingBackend = embeddingBackend;
    }

    public static final SplitController getInstance(Context context) {
        return Companion.getInstance(context);
    }

    @RequiresWindowSdkExtension(version = 2)
    public final void clearSplitAttributesCalculator() {
        this.embeddingBackend.clearSplitAttributesCalculator();
    }

    public final SplitSupportStatus getSplitSupportStatus() {
        return this.embeddingBackend.getSplitSupportStatus();
    }

    @ExperimentalWindowApi
    @RequiresWindowSdkExtension(version = 3)
    public final void invalidateTopVisibleSplitAttributes() {
        this.embeddingBackend.invalidateTopVisibleSplitAttributes();
    }

    @RequiresWindowSdkExtension(version = 2)
    public final void setSplitAttributesCalculator(l calculator) {
        E.f(calculator, "calculator");
        this.embeddingBackend.setSplitAttributesCalculator(calculator);
    }

    public final InterfaceC0612o splitInfoList(Activity activity) {
        E.f(activity, "activity");
        return AbstractC0618q.callbackFlow(new AnonymousClass1(activity, null));
    }

    @ExperimentalWindowApi
    @RequiresWindowSdkExtension(version = 3)
    public final void updateSplitAttributes(SplitInfo splitInfo, SplitAttributes splitAttributes) {
        E.f(splitInfo, "splitInfo");
        E.f(splitAttributes, "splitAttributes");
        this.embeddingBackend.updateSplitAttributes(splitInfo, splitAttributes);
    }
}
