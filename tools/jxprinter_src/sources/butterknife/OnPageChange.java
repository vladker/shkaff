package butterknife;

import androidx.annotation.IdRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: callback */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnPageChange {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Callback {
        public static final Callback PAGE_SCROLLED;
        public static final Callback PAGE_SCROLL_STATE_CHANGED;
        public static final Callback PAGE_SELECTED;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Callback[] f1092a;

        static {
            Callback callback = new Callback("PAGE_SELECTED", 0);
            PAGE_SELECTED = callback;
            Callback callback2 = new Callback("PAGE_SCROLLED", 1);
            PAGE_SCROLLED = callback2;
            Callback callback3 = new Callback("PAGE_SCROLL_STATE_CHANGED", 2);
            PAGE_SCROLL_STATE_CHANGED = callback3;
            f1092a = new Callback[]{callback, callback2, callback3};
        }

        public static Callback valueOf(String str) {
            return (Callback) Enum.valueOf(Callback.class, str);
        }

        public static Callback[] values() {
            return (Callback[]) f1092a.clone();
        }
    }

    @IdRes
    int[] value() default {-1};
}
