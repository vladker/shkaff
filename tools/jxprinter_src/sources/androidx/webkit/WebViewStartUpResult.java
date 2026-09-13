package androidx.webkit;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@WebViewCompat.ExperimentalAsyncStartUp
public interface WebViewStartUpResult {
    @Nullable
    @SuppressLint({"NullableCollection"})
    List<BlockingStartUpLocation> getBlockingStartUpLocations();

    @Nullable
    @SuppressLint({"AutoBoxing"})
    Long getMaxTimePerTaskInUiThreadMillis();

    @Nullable
    @SuppressLint({"AutoBoxing"})
    Long getTotalTimeInUiThreadMillis();
}
