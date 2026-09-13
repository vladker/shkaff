package butterknife.internal;

import A3.AbstractC0157z;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypedValue f1096a = new TypedValue();

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int length = tArr.length;
        int i5 = 0;
        for (T t6 : tArr) {
            if (t6 != null) {
                tArr[i5] = t6;
                i5++;
            }
        }
        return i5 == length ? tArr : (T[]) Arrays.copyOf(tArr, i5);
    }

    public static <T> T castView(View view, @IdRes int i5, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            String resourceEntryName = getResourceEntryName(view, i5);
            StringBuilder sb = new StringBuilder("View '");
            sb.append(resourceEntryName);
            sb.append("' with ID ");
            sb.append(i5);
            sb.append(" for ");
            throw new IllegalStateException(AbstractC0157z.s(sb, str, " was of the wrong type. See cause for more info."), e);
        }
    }

    public static <T> T findOptionalViewAsType(View view, @IdRes int i5, String str, Class<T> cls) {
        return (T) castView(view.findViewById(i5), i5, str, cls);
    }

    public static View findRequiredView(View view, @IdRes int i5, String str) {
        View viewFindViewById = view.findViewById(i5);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        String resourceEntryName = getResourceEntryName(view, i5);
        StringBuilder sb = new StringBuilder("Required view '");
        sb.append(resourceEntryName);
        sb.append("' with ID ");
        sb.append(i5);
        sb.append(" for ");
        throw new IllegalStateException(AbstractC0157z.s(sb, str, " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation."));
    }

    public static <T> T findRequiredViewAsType(View view, @IdRes int i5, String str, Class<T> cls) {
        return (T) castView(findRequiredView(view, i5, str), i5, str, cls);
    }

    @UiThread
    public static float getFloat(Context context, @DimenRes int i5) {
        Resources resources = context.getResources();
        TypedValue typedValue = f1096a;
        resources.getValue(i5, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i5) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    private static String getResourceEntryName(View view, @IdRes int i5) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i5);
    }

    @UiThread
    public static Drawable getTintedDrawable(Context context, @DrawableRes int i5, @AttrRes int i6) {
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = f1096a;
        if (theme.resolveAttribute(i6, typedValue, true)) {
            Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, i5).mutate());
            DrawableCompat.setTint(drawableWrap, ContextCompat.getColor(context, typedValue.resourceId));
            return drawableWrap;
        }
        throw new Resources.NotFoundException("Required tint color attribute with name " + context.getResources().getResourceEntryName(i6) + " and attribute ID " + i6 + " was not found.");
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new c(arrayFilteringNull(tArr));
    }
}
