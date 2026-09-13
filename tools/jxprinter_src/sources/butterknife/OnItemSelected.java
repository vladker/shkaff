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
@Retention(RetentionPolicy.CLASS)
public @interface OnItemSelected {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Callback {
        public static final Callback ITEM_SELECTED;
        public static final Callback NOTHING_SELECTED;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Callback[] f1091a;

        static {
            Callback callback = new Callback("ITEM_SELECTED", 0);
            ITEM_SELECTED = callback;
            Callback callback2 = new Callback("NOTHING_SELECTED", 1);
            NOTHING_SELECTED = callback2;
            f1091a = new Callback[]{callback, callback2};
        }

        public static Callback valueOf(String str) {
            return (Callback) Enum.valueOf(Callback.class, str);
        }

        public static Callback[] values() {
            return (Callback[]) f1091a.clone();
        }
    }

    @IdRes
    int[] value() default {-1};
}
