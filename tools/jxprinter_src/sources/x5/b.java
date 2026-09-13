package x5;

import android.view.Window;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b {
    public static boolean isDarkIconMode(@NonNull Window window) {
        return 8192 == (window.getDecorView().getSystemUiVisibility() & 8192);
    }

    public static void setDarkIconMode(@NonNull Window window, boolean z6) {
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z6) {
            window.getDecorView().setSystemUiVisibility(systemUiVisibility | 8192);
        } else {
            window.getDecorView().setSystemUiVisibility(systemUiVisibility & (-8193));
        }
    }
}
