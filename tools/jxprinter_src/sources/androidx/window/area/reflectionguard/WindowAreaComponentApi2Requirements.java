package androidx.window.area.reflectionguard;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.window.extensions.core.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface WindowAreaComponentApi2Requirements {
    void addRearDisplayStatusListener(@NonNull Consumer<Integer> consumer);

    void endRearDisplaySession();

    void removeRearDisplayStatusListener(@NonNull Consumer<Integer> consumer);

    void startRearDisplaySession(@NonNull Activity activity, @NonNull Consumer<Integer> consumer);
}
