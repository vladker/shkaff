package cn.sharesdk.loopshare;

import android.app.Activity;
import com.mob.tools.proguard.EverythingKeeper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface RestoreSceneListener extends EverythingKeeper {
    void completeRestore(Scene scene);

    void notFoundScene(Scene scene);

    Class<? extends Activity> willRestoreScene(Scene scene);
}
