package androidx.window.layout.util;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class ContextCompatHelperApi24 {
    public static final ContextCompatHelperApi24 INSTANCE = new ContextCompatHelperApi24();

    private ContextCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(Activity activity) {
        E.f(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}
