package androidx.window.layout.adapter;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface WindowBackend {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default boolean hasRegisteredListeners() {
        return false;
    }

    void registerLayoutChangeCallback(Context context, Executor executor, Consumer<WindowLayoutInfo> consumer);

    void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> consumer);
}
