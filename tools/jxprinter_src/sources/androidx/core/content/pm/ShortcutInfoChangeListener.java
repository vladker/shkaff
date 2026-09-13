package androidx.core.content.pm;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ShortcutInfoChangeListener {
    @AnyThread
    public void onAllShortcutsRemoved() {
    }

    @AnyThread
    public void onShortcutAdded(List<ShortcutInfoCompat> list) {
    }

    @AnyThread
    public void onShortcutRemoved(List<String> list) {
    }

    @AnyThread
    public void onShortcutUpdated(List<ShortcutInfoCompat> list) {
    }

    @AnyThread
    public void onShortcutUsageReported(List<String> list) {
    }
}
