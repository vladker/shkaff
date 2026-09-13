package androidx.window.java.area;

import android.app.Activity;
import android.os.Binder;
import androidx.core.util.Consumer;
import androidx.window.area.WindowAreaController;
import androidx.window.area.WindowAreaInfo;
import androidx.window.area.WindowAreaPresentationSessionCallback;
import androidx.window.area.WindowAreaSessionCallback;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.java.core.CallbackToFlowAdapter;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.E;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class WindowAreaControllerCallbackAdapter implements WindowAreaController {
    private final CallbackToFlowAdapter callbackToFlowAdapter;
    private final WindowAreaController controller;

    private WindowAreaControllerCallbackAdapter(WindowAreaController windowAreaController, CallbackToFlowAdapter callbackToFlowAdapter) {
        this.controller = windowAreaController;
        this.callbackToFlowAdapter = callbackToFlowAdapter;
    }

    public final void addWindowAreaInfoListListener(Executor executor, Consumer<List<WindowAreaInfo>> listener) {
        E.f(executor, "executor");
        E.f(listener, "listener");
        this.callbackToFlowAdapter.connect(executor, listener, this.controller.getWindowAreaInfos());
    }

    @Override // androidx.window.area.WindowAreaController
    public InterfaceC0612o getWindowAreaInfos() {
        return this.controller.getWindowAreaInfos();
    }

    @Override // androidx.window.area.WindowAreaController
    public void presentContentOnWindowArea(Binder token, Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback) {
        E.f(token, "token");
        E.f(activity, "activity");
        E.f(executor, "executor");
        E.f(windowAreaPresentationSessionCallback, "windowAreaPresentationSessionCallback");
        this.controller.presentContentOnWindowArea(token, activity, executor, windowAreaPresentationSessionCallback);
    }

    public final void removeWindowAreaInfoListListener(Consumer<List<WindowAreaInfo>> listener) {
        E.f(listener, "listener");
        this.callbackToFlowAdapter.disconnect(listener);
    }

    @Override // androidx.window.area.WindowAreaController
    public void transferActivityToWindowArea(Binder token, Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback) {
        E.f(token, "token");
        E.f(activity, "activity");
        E.f(executor, "executor");
        E.f(windowAreaSessionCallback, "windowAreaSessionCallback");
        this.controller.transferActivityToWindowArea(token, activity, executor, windowAreaSessionCallback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowAreaControllerCallbackAdapter(WindowAreaController controller) {
        this(controller, new CallbackToFlowAdapter());
        E.f(controller, "controller");
    }
}
