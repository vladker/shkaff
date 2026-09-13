package androidx.window.layout;

import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackend;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoTracker$Companion$extensionBackend$2 extends F implements O3.a {
    public static final WindowInfoTracker$Companion$extensionBackend$2 INSTANCE = new WindowInfoTracker$Companion$extensionBackend$2();

    public WindowInfoTracker$Companion$extensionBackend$2() {
        super(0);
    }

    @Override // O3.a
    public final WindowBackend invoke() {
        WindowLayoutComponent windowLayoutComponent;
        try {
            ClassLoader loader = WindowInfoTracker.class.getClassLoader();
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = loader != null ? new SafeWindowLayoutComponentProvider(loader, new ConsumerAdapter(loader)) : null;
            if (safeWindowLayoutComponentProvider == null || (windowLayoutComponent = safeWindowLayoutComponentProvider.getWindowLayoutComponent()) == null) {
                return null;
            }
            ExtensionWindowBackend.Companion companion = ExtensionWindowBackend.Companion;
            E.e(loader, "loader");
            return companion.newInstance(windowLayoutComponent, new ConsumerAdapter(loader));
        } catch (Throwable unused) {
            if (WindowInfoTracker.Companion.DEBUG) {
                Log.d(WindowInfoTracker.Companion.TAG, "Failed to load WindowExtensions");
            }
            return null;
        }
    }
}
