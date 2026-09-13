package x5;

import android.annotation.TargetApi;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import io.flutter.plugin.platform.PlatformPlugin;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c {
    @TargetApi(19)
    public static boolean isTransparentStatusBarAbove19(@NonNull Window window) {
        return 67108864 == (window.getAttributes().flags & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    @TargetApi(21)
    public static boolean isTransparentStatusBarAbove21(@NonNull Window window) {
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        return 1024 == (window.getDecorView().getSystemUiVisibility() & 1024);
    }

    @TargetApi(19)
    public static void transparentStatusBarAbove19(@NonNull Window window) {
        window.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    @TargetApi(21)
    public static void transparentStatusBarAbove21(@NonNull Window window) {
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    @TargetApi(19)
    public static void unTransparentStatusBarAbove19(@NonNull Window window) {
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    @TargetApi(21)
    public static void unTransparentStatusBarAbove21(@NonNull Window window) {
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-1281));
        window.clearFlags(Integer.MIN_VALUE);
    }
}
