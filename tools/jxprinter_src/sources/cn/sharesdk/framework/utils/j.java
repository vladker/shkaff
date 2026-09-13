package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f2233a = 1.5f;
    public static int b = 540;
    private static Context c;

    public static void a(Context context) {
        Context context2 = c;
        if (context2 == null || context2 != context.getApplicationContext()) {
            c = context;
        }
    }

    public static int b(int i5) {
        return ResHelper.designToDevice(c, b, i5);
    }

    public static int a(int i5) {
        return ResHelper.designToDevice(c, f2233a, i5);
    }
}
