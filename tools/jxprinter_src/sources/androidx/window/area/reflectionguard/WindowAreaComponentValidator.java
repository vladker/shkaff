package androidx.window.area.reflectionguard;

import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.reflection.ReflectionUtils;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowAreaComponentValidator {
    public static final WindowAreaComponentValidator INSTANCE = new WindowAreaComponentValidator();

    private WindowAreaComponentValidator() {
    }

    public final boolean isExtensionWindowAreaPresentationValid$window_release(Class<?> extensionWindowAreaPresentation, int i5) {
        E.f(extensionWindowAreaPresentation, "extensionWindowAreaPresentation");
        if (i5 <= 2) {
            return false;
        }
        return ReflectionUtils.INSTANCE.validateImplementation$window_release(extensionWindowAreaPresentation, ExtensionWindowAreaPresentation.class);
    }

    public final boolean isExtensionWindowAreaStatusValid$window_release(Class<?> extensionWindowAreaStatus, int i5) {
        E.f(extensionWindowAreaStatus, "extensionWindowAreaStatus");
        if (i5 <= 1) {
            return false;
        }
        return ReflectionUtils.INSTANCE.validateImplementation$window_release(extensionWindowAreaStatus, ExtensionWindowAreaStatusRequirements.class);
    }

    public final boolean isWindowAreaComponentValid$window_release(Class<?> windowAreaComponent, int i5) {
        E.f(windowAreaComponent, "windowAreaComponent");
        if (i5 <= 1) {
            return false;
        }
        return i5 == 2 ? ReflectionUtils.INSTANCE.validateImplementation$window_release(windowAreaComponent, WindowAreaComponentApi2Requirements.class) : ReflectionUtils.INSTANCE.validateImplementation$window_release(windowAreaComponent, WindowAreaComponentApi3Requirements.class);
    }
}
