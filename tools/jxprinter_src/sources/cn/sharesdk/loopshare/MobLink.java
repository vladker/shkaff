package cn.sharesdk.loopshare;

import android.app.Activity;
import android.content.Intent;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.loopshare.utils.MobLinkImpl;
import com.mob.tools.proguard.ProtectedMemberKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MobLink implements ProtectedMemberKeeper, PublicMemberKeeper {
    public static final boolean DEBUGGABLE = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MobLinkImpl f2300a;

    static {
        a();
    }

    private static synchronized void a() {
        if (f2300a == null) {
            f2300a = new MobLinkImpl();
        }
    }

    public static void getMobID(Scene scene, ActionListener<String> actionListener) {
        a();
        f2300a.a(scene, actionListener);
    }

    public static String getSdkTag() {
        return "MOBLINK";
    }

    public static int getSdkVersion() {
        int i5 = 0;
        for (String str : ShareSDK.SDK_VERSION_NAME.split("\\.")) {
            i5 = (i5 * 100) + Integer.parseInt(str);
        }
        return i5;
    }

    public static void registerSpecifiedSchemeListener(String str, RestoreSceneListener restoreSceneListener) {
        a();
        f2300a.a(str, restoreSceneListener);
    }

    public static void setActivityDelegate(Activity activity, SceneRestorable sceneRestorable) {
        a();
        f2300a.a(activity, sceneRestorable);
    }

    public static void setRestoreSceneListener(RestoreSceneListener restoreSceneListener) {
        a();
        f2300a.a(restoreSceneListener);
    }

    public static void skipRestoreSceneFromWx(Class<? extends Activity>... clsArr) {
        a();
        f2300a.a(clsArr);
    }

    public static void updateNewIntent(Intent intent, Activity activity) {
        a();
        f2300a.a(intent, activity);
    }
}
