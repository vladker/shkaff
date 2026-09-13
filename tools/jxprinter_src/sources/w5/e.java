package w5;

import android.app.Activity;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class e implements a {
    @Override // w5.a
    public boolean isDarkIconMode(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return false;
        }
        return isDarkIconMode(activity);
    }

    @Override // w5.a
    public void setDarkIconMode(@NonNull Fragment fragment, boolean z6) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        setDarkIconMode(activity, z6);
    }

    @Override // w5.a
    public boolean isDarkIconMode(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        return isDarkIconMode(window);
    }

    @Override // w5.a
    public void setDarkIconMode(@NonNull Activity activity, boolean z6) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        setDarkIconMode(window, z6);
    }

    @Override // w5.a
    public boolean isDarkIconMode(@NonNull Window window) {
        return x5.b.isDarkIconMode(window);
    }

    @Override // w5.a
    public void setDarkIconMode(@NonNull Window window, boolean z6) {
        x5.b.setDarkIconMode(window, z6);
    }
}
