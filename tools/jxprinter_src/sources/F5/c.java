package F5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c {
    public static String a() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
    }

    public static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        if (point2.x == point.x && point2.y == point.y) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean c(MotionEvent motionEvent, Context context) {
        int iApplyDimension = (int) TypedValue.applyDimension(1, 40.0f, context.getResources().getDisplayMetrics());
        float f6 = iApplyDimension;
        if (motionEvent.getRawX() >= f6) {
            if (motionEvent.getRawX() <= (b(context) + context.getResources().getDisplayMetrics().widthPixels) - iApplyDimension && motionEvent.getRawY() >= f6) {
                if (motionEvent.getRawY() <= (b(context) + context.getResources().getDisplayMetrics().heightPixels) - iApplyDimension) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Activity d(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return d(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String e(int i5) {
        int i6 = i5 / 1000;
        int i7 = i6 % 60;
        int i8 = (i6 / 60) % 60;
        int i9 = i6 / 3600;
        return i9 > 0 ? String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(i9), Integer.valueOf(i8), Integer.valueOf(i7)) : String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i8), Integer.valueOf(i7));
    }

    @SuppressLint({"PrivateApi"})
    @Deprecated
    public static Application getApplication() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t6 : collection) {
            if (t6 != null) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }
}
