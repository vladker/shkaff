package androidx.window.area;

import A3.T;
import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.core.util.function.Consumer;
import java.util.Collection;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p018c4.D0;
import p018c4.v0;
import p018c4.x0;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.window.area.WindowAreaControllerImpl$windowAreaInfos$1", f = "WindowAreaControllerImpl.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
public final class WindowAreaControllerImpl$windowAreaInfos$1 extends m implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowAreaControllerImpl this$0;

    /* JADX INFO: renamed from: androidx.window.area.WindowAreaControllerImpl$windowAreaInfos$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements O3.a {
        final /* synthetic */ Consumer<Integer> $rearDisplayListener;
        final /* synthetic */ Consumer<ExtensionWindowAreaStatus> $rearDisplayPresentationListener;
        final /* synthetic */ WindowAreaControllerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WindowAreaControllerImpl windowAreaControllerImpl, Consumer<Integer> consumer, Consumer<ExtensionWindowAreaStatus> consumer2) {
            super(0);
            this.this$0 = windowAreaControllerImpl;
            this.$rearDisplayListener = consumer;
            this.$rearDisplayPresentationListener = consumer2;
        }

        @Override // O3.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m994invoke();
            return Q.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m994invoke() {
            this.this$0.windowAreaComponent.removeRearDisplayStatusListener(this.$rearDisplayListener);
            if (this.this$0.vendorApiLevel > 2) {
                this.this$0.windowAreaComponent.removeRearDisplayPresentationStatusListener(this.$rearDisplayPresentationListener);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowAreaControllerImpl$windowAreaInfos$1(WindowAreaControllerImpl windowAreaControllerImpl, g<? super WindowAreaControllerImpl$windowAreaInfos$1> gVar) {
        super(2, gVar);
        this.this$0 = windowAreaControllerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(WindowAreaControllerImpl windowAreaControllerImpl, x0 x0Var, Integer status) {
        E.e(status, "status");
        windowAreaControllerImpl.updateRearDisplayAvailability(status.intValue());
        D0 channel = x0Var.getChannel();
        Collection collectionValues = windowAreaControllerImpl.currentWindowAreaInfoMap.values();
        E.e(collectionValues, "currentWindowAreaInfoMap.values");
        channel.mo1011trySendJP2dKIU(T.toList(collectionValues));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(WindowAreaControllerImpl windowAreaControllerImpl, x0 x0Var, ExtensionWindowAreaStatus extensionWindowAreaStatus) {
        E.e(extensionWindowAreaStatus, "extensionWindowAreaStatus");
        windowAreaControllerImpl.updateRearDisplayPresentationAvailability(extensionWindowAreaStatus);
        D0 channel = x0Var.getChannel();
        Collection collectionValues = windowAreaControllerImpl.currentWindowAreaInfoMap.values();
        E.e(collectionValues, "currentWindowAreaInfoMap.values");
        channel.mo1011trySendJP2dKIU(T.toList(collectionValues));
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        WindowAreaControllerImpl$windowAreaInfos$1 windowAreaControllerImpl$windowAreaInfos$1 = new WindowAreaControllerImpl$windowAreaInfos$1(this.this$0, gVar);
        windowAreaControllerImpl$windowAreaInfos$1.L$0 = obj;
        return windowAreaControllerImpl$windowAreaInfos$1;
    }

    @Override // O3.p
    public final Object invoke(x0 x0Var, g<? super Q> gVar) {
        return ((WindowAreaControllerImpl$windowAreaInfos$1) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            final x0 x0Var = (x0) this.L$0;
            final WindowAreaControllerImpl windowAreaControllerImpl = this.this$0;
            Consumer consumer = new Consumer() { // from class: androidx.window.area.c
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj2) {
                    WindowAreaControllerImpl$windowAreaInfos$1.invokeSuspend$lambda$0(windowAreaControllerImpl, x0Var, (Integer) obj2);
                }
            };
            Consumer consumer2 = new Consumer() { // from class: androidx.window.area.d
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj2) {
                    WindowAreaControllerImpl$windowAreaInfos$1.invokeSuspend$lambda$1(windowAreaControllerImpl, x0Var, (ExtensionWindowAreaStatus) obj2);
                }
            };
            windowAreaControllerImpl.windowAreaComponent.addRearDisplayStatusListener(consumer);
            if (this.this$0.vendorApiLevel > 2) {
                this.this$0.windowAreaComponent.addRearDisplayPresentationStatusListener(consumer2);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, consumer, consumer2);
            this.label = 1;
            if (v0.awaitClose(x0Var, anonymousClass1, this) == coroutine_suspended) {
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
