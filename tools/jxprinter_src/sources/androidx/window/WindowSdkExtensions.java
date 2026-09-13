package androidx.window;

import A3.AbstractC0157z;
import androidx.annotation.IntRange;
import androidx.window.core.ExtensionsUtil;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WindowSdkExtensions {
    public static final Companion Companion = new Companion(null);
    private static WindowSdkExtensionsDecorator decorator = EmptyDecoratorWindowSdk.INSTANCE;
    private final int extensionVersion = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final WindowSdkExtensions getInstance() {
            return WindowSdkExtensions.decorator.decorate(new WindowSdkExtensions() { // from class: androidx.window.WindowSdkExtensions$Companion$getInstance$1
            });
        }

        public final void overrideDecorator$window_release(WindowSdkExtensionsDecorator overridingDecorator) {
            E.f(overridingDecorator, "overridingDecorator");
            WindowSdkExtensions.decorator = overridingDecorator;
        }

        public final void reset$window_release() {
            WindowSdkExtensions.decorator = EmptyDecoratorWindowSdk.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final WindowSdkExtensions getInstance() {
        return Companion.getInstance();
    }

    @IntRange(from = 0)
    public int getExtensionVersion() {
        return this.extensionVersion;
    }

    public final void requireExtensionVersion$window_release(@IntRange(from = 1) int i5) {
        if (getExtensionVersion() >= i5) {
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "This API requires extension version ", ", but the device is on ");
        sbT.append(getExtensionVersion());
        throw new UnsupportedOperationException(sbT.toString());
    }
}
