package org.apache.logging.log4j.message;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.StringBuilders;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ParameterFormatter {
    private static final char DELIM_START = '{';
    private static final char DELIM_STOP = '}';
    static final String ERROR_MSG_SEPARATOR = ":";
    static final String ERROR_PREFIX = "[!!!";
    static final String ERROR_SEPARATOR = "=>";
    static final String ERROR_SUFFIX = "!!!]";
    private static final char ESCAPE_CHAR = '\\';
    static final String RECURSION_PREFIX = "[...";
    static final String RECURSION_SUFFIX = "...]";
    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_REF = ThreadLocal.withInitial(new c(0));

    private ParameterFormatter() {
    }

    private static void appendArray(Object obj, StringBuilder sb, Set<Object> set, Class<?> cls) {
        if (cls == byte[].class) {
            sb.append(Arrays.toString((byte[]) obj));
            return;
        }
        if (cls == short[].class) {
            sb.append(Arrays.toString((short[]) obj));
            return;
        }
        if (cls == int[].class) {
            sb.append(Arrays.toString((int[]) obj));
            return;
        }
        if (cls == long[].class) {
            sb.append(Arrays.toString((long[]) obj));
            return;
        }
        if (cls == float[].class) {
            sb.append(Arrays.toString((float[]) obj));
            return;
        }
        if (cls == double[].class) {
            sb.append(Arrays.toString((double[]) obj));
            return;
        }
        if (cls == boolean[].class) {
            sb.append(Arrays.toString((boolean[]) obj));
            return;
        }
        if (cls == char[].class) {
            sb.append(Arrays.toString((char[]) obj));
            return;
        }
        Set<Object> orCreateDejaVu = getOrCreateDejaVu(set);
        if (!orCreateDejaVu.add(obj)) {
            androidx.collection.a.x(sb, "[...", identityToString(obj), "...]");
            return;
        }
        sb.append('[');
        boolean z6 = true;
        for (Object obj2 : (Object[]) obj) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(", ");
            }
            recursiveDeepToString(obj2, sb, cloneDejaVu(orCreateDejaVu));
        }
        sb.append(']');
    }

    private static void appendCollection(Object obj, StringBuilder sb, Set<Object> set) {
        Set<Object> orCreateDejaVu = getOrCreateDejaVu(set);
        if (!orCreateDejaVu.add(obj)) {
            androidx.collection.a.x(sb, "[...", identityToString(obj), "...]");
            return;
        }
        sb.append('[');
        boolean z6 = true;
        for (Object obj2 : (Collection) obj) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(", ");
            }
            recursiveDeepToString(obj2, sb, cloneDejaVu(orCreateDejaVu));
        }
        sb.append(']');
    }

    private static boolean appendDate(Object obj, StringBuilder sb) {
        if (!(obj instanceof Date)) {
            return false;
        }
        sb.append(SIMPLE_DATE_FORMAT_REF.get().format((Date) obj));
        return true;
    }

    private static void appendMap(Object obj, StringBuilder sb, Set<Object> set) {
        Set<Object> orCreateDejaVu = getOrCreateDejaVu(set);
        if (!orCreateDejaVu.add(obj)) {
            androidx.collection.a.x(sb, "[...", identityToString(obj), "...]");
            return;
        }
        sb.append(DELIM_START);
        boolean z6 = true;
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(", ");
            }
            Object key = entry.getKey();
            Object value = entry.getValue();
            recursiveDeepToString(key, sb, cloneDejaVu(orCreateDejaVu));
            sb.append(Chars.EQ);
            recursiveDeepToString(value, sb, cloneDejaVu(orCreateDejaVu));
        }
        sb.append(DELIM_STOP);
    }

    private static void appendPotentiallyRecursiveValue(Object obj, StringBuilder sb, Set<Object> set) {
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            appendArray(obj, sb, set, cls);
            return;
        }
        if (obj instanceof Map) {
            appendMap(obj, sb, set);
        } else if (obj instanceof Collection) {
            appendCollection(obj, sb, set);
        } else {
            throw new IllegalArgumentException("was expecting a container, found " + cls);
        }
    }

    private static boolean appendSpecialTypes(Object obj, StringBuilder sb) {
        return StringBuilders.appendSpecificTypes(sb, obj) || appendDate(obj, sb);
    }

    private static Set<Object> cloneDejaVu(Set<Object> set) {
        Set<Object> setCreateDejaVu = createDejaVu();
        setCreateDejaVu.addAll(set);
        return setCreateDejaVu;
    }

    public static int countArgumentPlaceholders(String str) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        boolean z6 = false;
        while (i5 < length - 1) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '\\') {
                z6 = !z6;
            } else {
                if (cCharAt == '{' && !z6) {
                    int i7 = i5 + 1;
                    if (str.charAt(i7) == '}') {
                        i6++;
                        i5 = i7;
                    }
                }
                z6 = false;
            }
            i5++;
        }
        return i6;
    }

    public static int countArgumentPlaceholders2(String str, int[] iArr) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        boolean z6 = false;
        while (i5 < length - 1) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '\\') {
                z6 = !z6;
                iArr[0] = -1;
                i6++;
            } else {
                if (cCharAt == '{' && !z6) {
                    int i7 = i5 + 1;
                    if (str.charAt(i7) == '}') {
                        iArr[i6] = i5;
                        i6++;
                        i5 = i7;
                    }
                }
                z6 = false;
            }
            i5++;
        }
        return i6;
    }

    public static int countArgumentPlaceholders3(char[] cArr, int i5, int[] iArr) {
        int i6 = 0;
        int i7 = 0;
        boolean z6 = false;
        while (i6 < i5 - 1) {
            char c = cArr[i6];
            if (c == '\\') {
                z6 = !z6;
            } else {
                if (c == '{' && !z6) {
                    int i8 = i6 + 1;
                    if (cArr[i8] == '}') {
                        iArr[i7] = i6;
                        i7++;
                        i6 = i8;
                    }
                }
                z6 = false;
            }
            i6++;
        }
        return i7;
    }

    private static Set<Object> createDejaVu() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static String deepToString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return Integer.toString(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return Long.toString(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return Double.toString(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return Boolean.toString(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Character) {
            return Character.toString(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return Short.toString(((Short) obj).shortValue());
        }
        if (obj instanceof Float) {
            return Float.toString(((Float) obj).floatValue());
        }
        if (obj instanceof Byte) {
            return Byte.toString(((Byte) obj).byteValue());
        }
        StringBuilder sb = new StringBuilder();
        recursiveDeepToString(obj, sb);
        return sb.toString();
    }

    public static String format(String str, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        formatMessage(sb, str, objArr, objArr == null ? 0 : objArr.length);
        return sb.toString();
    }

    public static void formatMessage(StringBuilder sb, String str, Object[] objArr, int i5) {
        if (str == null || objArr == null || i5 == 0) {
            sb.append(str);
            return;
        }
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length - 1) {
            char cCharAt = str.charAt(i6);
            if (cCharAt == '\\') {
                i7++;
            } else {
                if (isDelimPair(cCharAt, str, i6)) {
                    i6++;
                    writeEscapedEscapeChars(i7, sb);
                    if (isOdd(i7)) {
                        writeDelimPair(sb);
                    } else {
                        writeArgOrDelimPair(objArr, i5, i8, sb);
                        i8++;
                    }
                } else {
                    handleLiteralChar(sb, i7, cCharAt);
                }
                i7 = 0;
            }
            i6++;
        }
        handleRemainingCharIfAny(str, length, sb, i7, i6);
    }

    public static void formatMessage2(StringBuilder sb, String str, Object[] objArr, int i5, int[] iArr) {
        if (str == null || objArr == null || i5 == 0) {
            sb.append(str);
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append((CharSequence) str, i6, iArr[i7]);
            i6 = iArr[i7] + 2;
            recursiveDeepToString(objArr[i7], sb);
        }
        sb.append((CharSequence) str, i6, str.length());
    }

    public static void formatMessage3(StringBuilder sb, char[] cArr, int i5, Object[] objArr, int i6, int[] iArr) {
        if (cArr == null) {
            return;
        }
        if (objArr == null || i6 == 0) {
            sb.append(cArr);
            return;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            sb.append(cArr, i7, iArr[i8]);
            i7 = iArr[i8] + 2;
            recursiveDeepToString(objArr[i8], sb);
        }
        sb.append(cArr, i7, i5);
    }

    private static Set<Object> getOrCreateDejaVu(Set<Object> set) {
        return set == null ? createDejaVu() : set;
    }

    private static void handleErrorInObjectToString(Object obj, StringBuilder sb, Throwable th) {
        sb.append("[!!!");
        sb.append(identityToString(obj));
        sb.append("=>");
        String message = th.getMessage();
        String name = th.getClass().getName();
        sb.append(name);
        if (!name.equals(message)) {
            sb.append(":");
            sb.append(message);
        }
        sb.append("!!!]");
    }

    private static void handleLastChar(StringBuilder sb, int i5, char c) {
        if (c == '\\') {
            writeUnescapedEscapeChars(i5 + 1, sb);
        } else {
            handleLiteralChar(sb, i5, c);
        }
    }

    private static void handleLiteralChar(StringBuilder sb, int i5, char c) {
        writeUnescapedEscapeChars(i5, sb);
        sb.append(c);
    }

    private static void handleRemainingCharIfAny(String str, int i5, StringBuilder sb, int i6, int i7) {
        if (i7 == i5 - 1) {
            handleLastChar(sb, i6, str.charAt(i7));
        }
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
    }

    private static boolean isDelimPair(char c, String str, int i5) {
        return c == '{' && str.charAt(i5 + 1) == '}';
    }

    private static boolean isMaybeRecursive(Object obj) {
        return obj.getClass().isArray() || (obj instanceof Map) || (obj instanceof Collection);
    }

    private static boolean isOdd(int i5) {
        return (i5 & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SimpleDateFormat lambda$static$0() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

    public static void recursiveDeepToString(Object obj, StringBuilder sb) {
        recursiveDeepToString(obj, sb, null);
    }

    private static void tryObjectToString(Object obj, StringBuilder sb) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            handleErrorInObjectToString(obj, sb, th);
        }
    }

    private static void writeArgOrDelimPair(Object[] objArr, int i5, int i6, StringBuilder sb) {
        if (i6 < i5) {
            recursiveDeepToString(objArr[i6], sb);
        } else {
            writeDelimPair(sb);
        }
    }

    private static void writeDelimPair(StringBuilder sb) {
        sb.append(DELIM_START);
        sb.append(DELIM_STOP);
    }

    private static void writeEscapedEscapeChars(int i5, StringBuilder sb) {
        writeUnescapedEscapeChars(i5 >> 1, sb);
    }

    private static void writeUnescapedEscapeChars(int i5, StringBuilder sb) {
        while (i5 > 0) {
            sb.append('\\');
            i5--;
        }
    }

    private static void recursiveDeepToString(Object obj, StringBuilder sb, Set<Object> set) {
        if (appendSpecialTypes(obj, sb)) {
            return;
        }
        if (isMaybeRecursive(obj)) {
            appendPotentiallyRecursiveValue(obj, sb, set);
        } else {
            tryObjectToString(obj, sb);
        }
    }
}
