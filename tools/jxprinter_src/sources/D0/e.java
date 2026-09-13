package D0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f160a = true;

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i5) {
        return getDrawable(context, context2, i5, null);
    }

    private static Drawable loadDrawableV4(Context context, @DrawableRes int i5, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i5, theme);
    }

    private static Drawable loadDrawableV7(Context context, @DrawableRes int i5, @Nullable Resources.Theme theme) {
        if (theme != null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, theme);
            contextThemeWrapper.applyOverrideConfiguration(theme.getResources().getConfiguration());
            context = contextThemeWrapper;
        }
        return AppCompatResources.getDrawable(context, i5);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i5, @Nullable Resources.Theme theme) {
        return getDrawable(context, context, i5, theme);
    }

    private static Drawable getDrawable(Context context, Context context2, @DrawableRes int i5, @Nullable Resources.Theme theme) {
        try {
            if (f160a) {
                return loadDrawableV7(context2, i5, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i5);
            }
            throw e;
        } catch (NoClassDefFoundError unused2) {
            f160a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i5, theme);
    }
}
