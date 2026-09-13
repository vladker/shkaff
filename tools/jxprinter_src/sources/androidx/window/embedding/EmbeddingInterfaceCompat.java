package androidx.window.embedding;

import O3.l;
import android.app.Activity;
import android.app.ActivityOptions;
import android.os.IBinder;
import androidx.window.RequiresWindowSdkExtension;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface EmbeddingInterfaceCompat {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface EmbeddingCallbackInterface {
        void onSplitInfoChanged(List<SplitInfo> list);
    }

    @RequiresWindowSdkExtension(version = 2)
    void clearSplitAttributesCalculator();

    @RequiresWindowSdkExtension(version = 3)
    void invalidateTopVisibleSplitAttributes();

    boolean isActivityEmbedded(Activity activity);

    void setEmbeddingCallback(EmbeddingCallbackInterface embeddingCallbackInterface);

    @RequiresWindowSdkExtension(version = 3)
    ActivityOptions setLaunchingActivityStack(ActivityOptions activityOptions, IBinder iBinder);

    void setRules(Set<? extends EmbeddingRule> set);

    @RequiresWindowSdkExtension(version = 2)
    void setSplitAttributesCalculator(l lVar);

    @RequiresWindowSdkExtension(version = 3)
    void updateSplitAttributes(SplitInfo splitInfo, SplitAttributes splitAttributes);
}
