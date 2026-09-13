package androidx.activity;

import kotlin.jvm.internal.F;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentActivity$fullyDrawnReporter$2 extends F implements O3.a {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: renamed from: androidx.activity.ComponentActivity$fullyDrawnReporter$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements O3.a {
        final /* synthetic */ ComponentActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity) {
            super(0);
            this.this$0 = componentActivity;
        }

        @Override // O3.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m933invoke();
            return Q.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m933invoke() {
            this.this$0.reportFullyDrawn();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentActivity$fullyDrawnReporter$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    @Override // O3.a
    public final FullyDrawnReporter invoke() {
        return new FullyDrawnReporter(this.this$0.reportFullyDrawnExecutor, new AnonymousClass1(this.this$0));
    }
}
