package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface EngagementSignalsCallback {
    default void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i5, @NonNull Bundle bundle) {
    }

    default void onSessionEnded(boolean z6, @NonNull Bundle bundle) {
    }

    default void onVerticalScrollEvent(boolean z6, @NonNull Bundle bundle) {
    }
}
