package v5;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c {
    public static double calcBgLuminance(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return 0.0d;
        }
        return calcBgLuminance((Activity) activity);
    }

    public static int getHeight(@NonNull Context context) {
        try {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isBgLight(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return false;
        }
        return isBgLight((Activity) activity);
    }

    public static boolean isIconDark(@NonNull Fragment fragment) {
        return p035f5.b.e().isDarkIconMode(fragment);
    }

    public static boolean isTransparent(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return false;
        }
        return isTransparent((Activity) activity);
    }

    public static void registerToAutoChangeIconMode(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        registerToAutoChangeIconMode((Activity) activity);
    }

    public static void setColor(@NonNull Fragment fragment, @ColorInt int i5) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        setColor((Activity) activity, i5);
    }

    public static void setIconDark(@NonNull Fragment fragment) {
        setIconMode(fragment, true);
    }

    public static void setIconLight(@NonNull Fragment fragment) {
        setIconMode(fragment, false);
    }

    public static void setIconMode(@NonNull Fragment fragment, boolean z6) {
        p035f5.b.e().setDarkIconMode(fragment, z6);
    }

    public static void setIconModeAuto(@NonNull Fragment fragment) {
        setIconMode(fragment, isBgLight(fragment));
    }

    public static void transparent(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        transparent((Activity) activity);
    }

    public static void unTransparent(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        unTransparent((Activity) activity);
    }

    public static void unregisterToAutoChangeIconMode(@NonNull Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        unregisterToAutoChangeIconMode((Activity) activity);
    }

    public static boolean isIconDark(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return false;
        }
        return p035f5.b.e().isDarkIconMode(activity);
    }

    public static void setIconDark(@NonNull Context context) {
        setIconMode(context, true);
    }

    public static void setIconLight(@NonNull Context context) {
        setIconMode(context, false);
    }

    public static void setIconMode(@NonNull Context context, boolean z6) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return;
        }
        p035f5.b.e().setDarkIconMode(activity, z6);
    }

    public static void setIconModeAuto(@NonNull Context context) {
        setIconMode(context, isBgLight(context));
    }

    public static double calcBgLuminance(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return 0.0d;
        }
        return calcBgLuminance(activity);
    }

    public static boolean isBgLight(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return false;
        }
        return isBgLight(activity);
    }

    public static boolean isTransparent(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return false;
        }
        return isTransparent(activity);
    }

    public static void registerToAutoChangeIconMode(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return;
        }
        registerToAutoChangeIconMode(activity);
    }

    public static void setColor(@NonNull Context context, @ColorInt int i5) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return;
        }
        setColor(activity, i5);
    }

    public static void setIconDark(@NonNull Activity activity) {
        setIconMode(activity, true);
    }

    public static void setIconLight(@NonNull Activity activity) {
        setIconMode(activity, false);
    }

    public static void setIconModeAuto(@NonNull Activity activity) {
        setIconMode(activity, isBgLight(activity));
    }

    public static void transparent(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return;
        }
        transparent(activity);
    }

    public static void unTransparent(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return;
        }
        unTransparent(activity);
    }

    public static void unregisterToAutoChangeIconMode(@NonNull Context context) {
        Activity activity = x5.a.getActivity(context);
        if (activity == null) {
            return;
        }
        unregisterToAutoChangeIconMode(activity);
    }

    public static boolean isIconDark(@NonNull Activity activity) {
        return p035f5.b.e().isDarkIconMode(activity);
    }

    public static void setIconDark(@NonNull Window window) {
        setIconMode(window, true);
    }

    public static void setIconLight(@NonNull Window window) {
        setIconMode(window, false);
    }

    public static void setIconMode(@NonNull Activity activity, boolean z6) {
        p035f5.b.e().setDarkIconMode(activity, z6);
    }

    public static void setIconModeAuto(@NonNull Window window) {
        setIconMode(window, isBgLight(window));
    }

    public static double calcBgLuminance(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return 0.0d;
        }
        return calcBgLuminance(window);
    }

    public static boolean isBgLight(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        return isBgLight(window);
    }

    public static boolean isIconDark(@NonNull Window window) {
        return p035f5.b.e().isDarkIconMode(window);
    }

    public static boolean isTransparent(@NonNull Activity activity) {
        return isTransparent(activity.getWindow());
    }

    public static void registerToAutoChangeIconMode(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        registerToAutoChangeIconMode(window);
    }

    public static void setColor(@NonNull Activity activity, @ColorInt int i5) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        setColor(window, i5);
    }

    public static void setIconMode(@NonNull Window window, boolean z6) {
        p035f5.b.e().setDarkIconMode(window, z6);
    }

    public static void transparent(@NonNull Activity activity) {
        transparent(activity.getWindow());
    }

    public static void unTransparent(@NonNull Activity activity) {
        unTransparent(activity.getWindow());
    }

    public static void unregisterToAutoChangeIconMode(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        unregisterToAutoChangeIconMode(window);
    }

    public static boolean isTransparent(@NonNull Window window) {
        return x5.c.isTransparentStatusBarAbove21(window);
    }

    public static void transparent(@NonNull Window window) {
        x5.c.transparentStatusBarAbove21(window);
    }

    public static void unTransparent(@NonNull Window window) {
        x5.c.unTransparentStatusBarAbove21(window);
    }

    public static double calcBgLuminance(@NonNull Window window) {
        if (isTransparent(window)) {
            View decorView = window.getDecorView();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(decorView.getMeasuredWidth(), getHeight(window.getContext()), Bitmap.Config.RGB_565);
            decorView.draw(new Canvas(bitmapCreateBitmap));
            double d = 0.0d;
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                int width = bitmapCreateBitmap.getWidth();
                int height = bitmapCreateBitmap.getHeight();
                if (width != 0 && height != 0) {
                    int i5 = height / 2;
                    int i6 = width / 2;
                    int i7 = 0;
                    int i8 = 0;
                    for (int i9 = 0; i9 < width; i9++) {
                        int i10 = (int) (height * (i9 / width));
                        int i11 = (height - i10) - 1;
                        if (ColorUtils.calculateLuminance(bitmapCreateBitmap.getPixel(i9, i10)) >= 0.382d) {
                            i8++;
                        } else {
                            i7++;
                        }
                        if (ColorUtils.calculateLuminance(bitmapCreateBitmap.getPixel(i9, i11)) >= 0.382d) {
                            i8++;
                        } else {
                            i7++;
                        }
                        if (ColorUtils.calculateLuminance(bitmapCreateBitmap.getPixel(i9, i5)) >= 0.382d) {
                            i8++;
                        } else {
                            i7++;
                        }
                        if (i9 == i6) {
                            for (int i12 = 0; i12 < height; i12++) {
                                if (ColorUtils.calculateLuminance(bitmapCreateBitmap.getPixel(i9, i12)) >= 0.382d) {
                                    i8++;
                                } else {
                                    i7++;
                                }
                            }
                        }
                    }
                    if (i7 <= i8) {
                        d = 1.0d;
                    }
                }
            }
            bitmapCreateBitmap.recycle();
            return d;
        }
        return ColorUtils.calculateLuminance(window.getStatusBarColor());
    }

    public static boolean isBgLight(@NonNull Window window) {
        return calcBgLuminance(window) >= 0.382d;
    }

    public static void registerToAutoChangeIconMode(@NonNull Window window) {
        View decorView = window.getDecorView();
        Object tag = decorView.getTag();
        if (tag instanceof ViewTreeObserver.OnPreDrawListener) {
            decorView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) tag);
            decorView.setTag(null);
        }
        a aVar = new a(window);
        decorView.addOnAttachStateChangeListener(new b(decorView, aVar));
        decorView.getViewTreeObserver().addOnPreDrawListener(aVar);
        decorView.setTag(aVar);
    }

    public static void setColor(@NonNull Window window, @ColorInt int i5) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i5);
    }

    public static void unregisterToAutoChangeIconMode(@NonNull Window window) {
        View decorView = window.getDecorView();
        Object tag = decorView.getTag();
        if (tag instanceof ViewTreeObserver.OnPreDrawListener) {
            decorView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) tag);
            decorView.setTag(null);
        }
    }
}
