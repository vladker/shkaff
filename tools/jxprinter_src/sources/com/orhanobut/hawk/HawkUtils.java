package com.orhanobut.hawk;

import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class HawkUtils {
    private HawkUtils() {
    }

    public static void checkNull(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException(a.n(str, " should not be null"));
        }
    }

    public static void checkNullOrEmpty(String str, String str2) {
        if (isEmpty(str2)) {
            throw new NullPointerException(a.n(str, " should not be null or empty"));
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
