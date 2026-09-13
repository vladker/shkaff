package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p023d4.InterfaceC0612o;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;
import p147z3.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface WindowInfoTracker {
    public static final Companion Companion = Companion.$$INSTANCE;

    static WindowInfoTracker getOrCreate(Context context) {
        return Companion.getOrCreate(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void overrideDecorator(WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void reset() {
        Companion.reset();
    }

    InterfaceC0612o windowLayoutInfo(Activity activity);

    default InterfaceC0612o windowLayoutInfo(Context context) {
        E.f(context, "context");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        InterfaceC0612o interfaceC0612oWindowLayoutInfo = activity != null ? windowLayoutInfo(activity) : null;
        if (interfaceC0612oWindowLayoutInfo != null) {
            return interfaceC0612oWindowLayoutInfo;
        }
        throw new r("Must override windowLayoutInfo(context) and provide an implementation.");
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        private static final boolean DEBUG = false;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String TAG = U.a(WindowInfoTracker.class).getSimpleName();
        private static final InterfaceC1934n extensionBackend$delegate = AbstractC1935o.lazy(WindowInfoTracker$Companion$extensionBackend$2.INSTANCE);
        private static WindowInfoTrackerDecorator decorator = EmptyDecorator.INSTANCE;

        private Companion() {
        }

        public final WindowBackend getExtensionBackend$window_release() {
            return (WindowBackend) extensionBackend$delegate.getValue();
        }

        public final WindowInfoTracker getOrCreate(Context context) {
            E.f(context, "context");
            WindowBackend extensionBackend$window_release = getExtensionBackend$window_release();
            if (extensionBackend$window_release == null) {
                extensionBackend$window_release = SidecarWindowBackend.Companion.getInstance(context);
            }
            return decorator.decorate(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.INSTANCE, extensionBackend$window_release));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void overrideDecorator(WindowInfoTrackerDecorator overridingDecorator) {
            E.f(overridingDecorator, "overridingDecorator");
            decorator = overridingDecorator;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void reset() {
            decorator = EmptyDecorator.INSTANCE;
        }

        public static /* synthetic */ void getExtensionBackend$window_release$annotations() {
        }
    }
}
