package androidx.window.area;

import A3.I;
import android.app.Activity;
import android.os.Binder;
import androidx.window.core.ExperimentalWindowApi;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.E;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class EmptyWindowAreaControllerImpl implements WindowAreaController {
    @Override // androidx.window.area.WindowAreaController
    public InterfaceC0612o getWindowAreaInfos() {
        return AbstractC0618q.flowOf(I.emptyList());
    }

    @Override // androidx.window.area.WindowAreaController
    public void presentContentOnWindowArea(Binder token, Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback) {
        E.f(token, "token");
        E.f(activity, "activity");
        E.f(executor, "executor");
        E.f(windowAreaPresentationSessionCallback, "windowAreaPresentationSessionCallback");
        windowAreaPresentationSessionCallback.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }

    @Override // androidx.window.area.WindowAreaController
    public void transferActivityToWindowArea(Binder token, Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback) {
        E.f(token, "token");
        E.f(activity, "activity");
        E.f(executor, "executor");
        E.f(windowAreaSessionCallback, "windowAreaSessionCallback");
        windowAreaSessionCallback.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }
}
