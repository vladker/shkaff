package p050j;

import android.app.Activity;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p010b2.a;
import w5.c;
import x5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Activity f5393a;
    public static a b;

    public static void a(Activity activity, boolean z6) {
        Method method = c.f8836a;
        if (method == null) {
            b.setDarkIconMode(activity.getWindow(), z6);
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z6));
        } catch (Exception unused) {
            b.setDarkIconMode(activity.getWindow(), z6);
        }
    }

    public static StringBuilder b(Enum r6, Enum r7, int i5, int i6, ImageView.ScaleType scaleType, int i7) {
        StringBuilder sb = new StringBuilder();
        sb.append("req=");
        sb.append(r6);
        sb.append("|eff=");
        sb.append(r7);
        sb.append("|w=");
        androidx.exifinterface.media.a.y(sb, i5, "|h=", i6, "|scale=");
        sb.append(scaleType);
        sb.append("|rotate=");
        sb.append(i7);
        return sb;
    }

    public static void c() {
        a aVar = b;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        try {
            b.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean d() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", null).invoke(null, null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static void e() {
        V1.b.h().getClass();
        Activity activityD = V1.b.d();
        if (activityD == null) {
            return;
        }
        if (activityD != f5393a) {
            f5393a = activityD;
            a aVar = b;
            if (aVar != null && aVar.isShowing()) {
                try {
                    b.dismiss();
                } catch (Exception unused) {
                }
            }
            b = null;
        }
        if (b == null) {
            b = new a(activityD);
        }
        try {
            b.f1086a.setText("");
            b.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f(String str) {
        V1.b.h().getClass();
        Activity activityD = V1.b.d();
        if (activityD == null) {
            return;
        }
        if (activityD != f5393a) {
            f5393a = activityD;
            a aVar = b;
            if (aVar != null && aVar.isShowing()) {
                try {
                    b.dismiss();
                } catch (Exception unused) {
                }
            }
            b = null;
        }
        if (b == null) {
            b = new a(activityD);
        }
        try {
            b.f1086a.setText(str);
            b.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
