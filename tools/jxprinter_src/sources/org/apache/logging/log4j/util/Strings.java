package org.apache.logging.log4j.util;

import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Strings {
    private static final String COMMA_DELIMITED_RE = "\\s*,\\s*";
    public static final String EMPTY = "";
    private static final ThreadLocal<StringBuilder> tempStr = ThreadLocal.withInitial(new j());
    public static final String[] EMPTY_ARRAY = new String[0];
    public static final String LINE_SEPARATOR = PropertiesUtil.getProperties().getStringProperty("line.separator", "\n");

    private Strings() {
    }

    public static String concat(String str, String str2) {
        if (isEmpty(str)) {
            return str2;
        }
        if (isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = tempStr.get();
        try {
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        } finally {
            sb.setLength(0);
        }
    }

    public static String dquote(String str) {
        return "\"" + str + Chars.DQUOTE;
    }

    public static boolean isBlank(String str) {
        if (str != null && !str.isEmpty()) {
            for (int i5 = 0; i5 < str.length(); i5++) {
                if (!Character.isWhitespace(str.charAt(i5))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c);
    }

    public static String left(String str, int i5) {
        if (str == null) {
            return null;
        }
        if (i5 < 0) {
            return "";
        }
        return str.length() <= i5 ? str : str.substring(0, i5);
    }

    public static String quote(String str) {
        return "'" + str + Chars.QUOTE;
    }

    public static String repeat(String str, int i5) {
        Objects.requireNonNull(str, "str");
        if (i5 < 0) {
            throw new IllegalArgumentException("count");
        }
        StringBuilder sb = tempStr.get();
        for (int i6 = 0; i6 < i5; i6++) {
            try {
                sb.append(str);
            } catch (Throwable th) {
                sb.setLength(0);
                throw th;
            }
        }
        String string = sb.toString();
        sb.setLength(0);
        return string;
    }

    public static String[] splitList(String str) {
        return str != null ? str.split(COMMA_DELIMITED_RE) : new String[0];
    }

    public static String toRootLowerCase(String str) {
        return str.toLowerCase(Locale.ROOT);
    }

    public static String toRootUpperCase(String str) {
        return str.toUpperCase(Locale.ROOT);
    }

    public static String trimToNull(String str) {
        String strTrim = str == null ? null : str.trim();
        if (isEmpty(strTrim)) {
            return null;
        }
        return strTrim;
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }
}
