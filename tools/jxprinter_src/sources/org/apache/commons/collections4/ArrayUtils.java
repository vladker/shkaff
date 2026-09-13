package org.apache.commons.collections4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ArrayUtils {
    static final int INDEX_NOT_FOUND = -1;

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static <T> int indexOf(T[] tArr, Object obj) {
        return indexOf(tArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i5) {
        if (objArr == null) {
            return -1;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (obj == null) {
            while (i5 < objArr.length) {
                if (objArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
        } else {
            while (i5 < objArr.length) {
                if (obj.equals(objArr[i5])) {
                    return i5;
                }
                i5++;
            }
        }
        return -1;
    }
}
