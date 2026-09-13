package butterknife;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewCollections {
    private ViewCollections() {
    }

    @SafeVarargs
    @UiThread
    public static <T extends View> void run(@NonNull List<T> list, @NonNull Action<? super T>... actionArr) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            for (Action<? super T> action : actionArr) {
                action.apply(list.get(i5), i5);
            }
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull List<T> list, @NonNull Setter<? super T, V> setter, @Nullable V v6) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            setter.set(list.get(i5), v6, i5);
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T[] tArr, @NonNull Setter<? super T, V> setter, @Nullable V v6) {
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            setter.set(tArr[i5], v6, i5);
        }
    }

    @SafeVarargs
    @UiThread
    public static <T extends View> void run(@NonNull T[] tArr, @NonNull Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            for (Action<? super T> action : actionArr) {
                action.apply(tArr[i5], i5);
            }
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T t6, @NonNull Setter<? super T, V> setter, @Nullable V v6) {
        setter.set(t6, v6, 0);
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull List<T> list, @NonNull Property<? super T, V> property, @Nullable V v6) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            property.set(list.get(i5), v6);
        }
    }

    @UiThread
    public static <T extends View> void run(@NonNull List<T> list, @NonNull Action<? super T> action) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            action.apply(list.get(i5), i5);
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T[] tArr, @NonNull Property<? super T, V> property, @Nullable V v6) {
        for (T t6 : tArr) {
            property.set(t6, v6);
        }
    }

    @UiThread
    public static <T extends View> void run(@NonNull T[] tArr, @NonNull Action<? super T> action) {
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            action.apply(tArr[i5], i5);
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T t6, @NonNull Property<? super T, V> property, @Nullable V v6) {
        property.set(t6, v6);
    }

    @SafeVarargs
    @UiThread
    public static <T extends View> void run(@NonNull T t6, @NonNull Action<? super T>... actionArr) {
        for (Action<? super T> action : actionArr) {
            action.apply(t6, 0);
        }
    }

    @UiThread
    public static <T extends View> void run(@NonNull T t6, @NonNull Action<? super T> action) {
        action.apply(t6, 0);
    }
}
