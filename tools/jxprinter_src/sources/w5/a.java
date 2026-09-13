package w5;

import android.app.Activity;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface a {
    boolean isDarkIconMode(@NonNull Activity activity);

    boolean isDarkIconMode(@NonNull Window window);

    boolean isDarkIconMode(@NonNull Fragment fragment);

    void setDarkIconMode(@NonNull Activity activity, boolean z6);

    void setDarkIconMode(@NonNull Window window, boolean z6);

    void setDarkIconMode(@NonNull Fragment fragment, boolean z6);
}
