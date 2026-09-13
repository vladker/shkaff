package L0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    public static void checkArgument(boolean z6, @NonNull String str) {
        if (!z6) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String checkNotEmpty(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t6) {
        return (T) checkNotNull(t6, "Argument must not be null");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t6, @NonNull String str) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T checkNotEmpty(@NonNull T t6) {
        if (t6.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t6;
    }
}
