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
public @interface OnTextChanged {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Callback {
        public static final Callback AFTER_TEXT_CHANGED;
        public static final Callback BEFORE_TEXT_CHANGED;
        public static final Callback TEXT_CHANGED;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Callback[] f1093a;

        static {
            Callback callback = new Callback("TEXT_CHANGED", 0);
            TEXT_CHANGED = callback;
            Callback callback2 = new Callback("BEFORE_TEXT_CHANGED", 1);
            BEFORE_TEXT_CHANGED = callback2;
            Callback callback3 = new Callback("AFTER_TEXT_CHANGED", 2);
            AFTER_TEXT_CHANGED = callback3;
            f1093a = new Callback[]{callback, callback2, callback3};
        }

        public static Callback valueOf(String str) {
            return (Callback) Enum.valueOf(Callback.class, str);
        }

        public static Callback[] values() {
            return (Callback[]) f1093a.clone();
        }
    }

    @IdRes
    int[] value() default {-1};
}
