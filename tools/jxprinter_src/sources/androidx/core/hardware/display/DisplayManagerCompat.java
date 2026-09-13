package androidx.core.hardware.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    static final String DISPLAY_CATEGORY_ALL = "android.hardware.display.category.ALL_INCLUDING_DISABLED";

    @ExperimentalDisplayApi
    public static final String DISPLAY_CATEGORY_BUILT_IN_DISPLAYS = "android.hardware.display.category.BUILT_IN_DISPLAYS";
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    static final int DISPLAY_TYPE_INTERNAL = 1;
    private final Context mContext;

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    private static Display[] computeBuiltInDisplays(DisplayManager displayManager) {
        Display[] displays = Build.VERSION.SDK_INT >= 32 ? displayManager.getDisplays(DISPLAY_CATEGORY_ALL) : displayManager.getDisplays();
        Display[] displayArr = new Display[numberOfDisplaysByType(1, displays)];
        int i5 = 0;
        for (Display display : displays) {
            if (1 == getTypeCompat(display)) {
                displayArr[i5] = display;
                i5++;
            }
        }
        return displayArr;
    }

    public static DisplayManagerCompat getInstance(Context context) {
        return new DisplayManagerCompat(context);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public static int getTypeCompat(Display display) {
        try {
            Object objInvoke = Display.class.getMethod("getType", null).invoke(display, null);
            Objects.requireNonNull(objInvoke);
            return ((Integer) objInvoke).intValue();
        } catch (NoSuchMethodException unused) {
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int numberOfDisplaysByType(int i5, Display[] displayArr) {
        int i6 = 0;
        for (Display display : displayArr) {
            if (i5 == getTypeCompat(display)) {
                i6++;
            }
        }
        return i6;
    }

    public Display getDisplay(int i5) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(i5);
    }

    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    public Display[] getDisplays(String str) {
        return DISPLAY_CATEGORY_BUILT_IN_DISPLAYS.equals(str) ? computeBuiltInDisplays((DisplayManager) this.mContext.getSystemService("display")) : ((DisplayManager) this.mContext.getSystemService("display")).getDisplays(str);
    }
}
