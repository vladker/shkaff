package org.apache.logging.log4j.util;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EnglishEnums {
    private EnglishEnums() {
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        return (T) valueOf(cls, str, null);
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str, T t6) {
        return str == null ? t6 : (T) Enum.valueOf(cls, str.toUpperCase(Locale.ENGLISH));
    }
}
