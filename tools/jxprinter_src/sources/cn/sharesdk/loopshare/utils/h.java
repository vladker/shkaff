package cn.sharesdk.loopshare.utils;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static boolean a(String str) {
        try {
            Class<?> cls = Class.forName("com.youzu.yad.YAD");
            Object objA = a();
            cls.getMethod("ulinkclickEvent", String.class, objA.getClass()).invoke(null, str, objA);
            return true;
        } catch (ClassNotFoundException e) {
            MobLinkLog.getInstance().d(e);
            return false;
        } catch (IllegalAccessException e6) {
            MobLinkLog.getInstance().e(e6);
            return false;
        } catch (IllegalArgumentException e7) {
            MobLinkLog.getInstance().e(e7);
            return false;
        } catch (NoSuchMethodException e8) {
            MobLinkLog.getInstance().e(e8);
            return false;
        } catch (InvocationTargetException e9) {
            MobLinkLog.getInstance().e(e9);
            return false;
        }
    }

    private static Object a() {
        return new Object();
    }
}
