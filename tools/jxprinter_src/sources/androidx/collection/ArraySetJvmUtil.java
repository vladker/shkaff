package androidx.collection;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    public static <T> T[] resizeForToArray(T[] tArr, int i5) {
        if (tArr.length < i5) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5));
        }
        if (tArr.length > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }
}
