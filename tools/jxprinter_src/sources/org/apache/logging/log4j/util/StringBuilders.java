package org.apache.logging.log4j.util;

import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StringBuilders {
    private StringBuilders() {
    }

    public static StringBuilder appendDqValue(StringBuilder sb, Object obj) {
        sb.append(Chars.DQUOTE);
        sb.append(obj);
        sb.append(Chars.DQUOTE);
        return sb;
    }

    public static StringBuilder appendKeyDqValue(StringBuilder sb, Map.Entry<String, String> entry) {
        return appendKeyDqValue(sb, entry.getKey(), entry.getValue());
    }

    public static boolean appendSpecificTypes(StringBuilder sb, Object obj) {
        if (obj == null || (obj instanceof String)) {
            sb.append((String) obj);
            return true;
        }
        if (obj instanceof StringBuilderFormattable) {
            ((StringBuilderFormattable) obj).formatTo(sb);
            return true;
        }
        if (obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
            return true;
        }
        if (obj instanceof Integer) {
            sb.append(((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Long) {
            sb.append(((Long) obj).longValue());
            return true;
        }
        if (obj instanceof Double) {
            sb.append(((Double) obj).doubleValue());
            return true;
        }
        if (obj instanceof Boolean) {
            sb.append(((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
            return true;
        }
        if (obj instanceof Short) {
            sb.append((int) ((Short) obj).shortValue());
            return true;
        }
        if (obj instanceof Float) {
            sb.append(((Float) obj).floatValue());
            return true;
        }
        if (!(obj instanceof Byte)) {
            return false;
        }
        sb.append((int) ((Byte) obj).byteValue());
        return true;
    }

    public static void appendValue(StringBuilder sb, Object obj) {
        if (appendSpecificTypes(sb, obj)) {
            return;
        }
        sb.append(obj);
    }

    public static boolean equals(CharSequence charSequence, int i5, int i6, CharSequence charSequence2, int i7, int i8) {
        if (i6 != i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (charSequence.charAt(i9 + i5) != charSequence2.charAt(i9 + i7)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, int i5, int i6, CharSequence charSequence2, int i7, int i8) {
        if (i6 != i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (Character.toLowerCase(charSequence.charAt(i9 + i5)) != Character.toLowerCase(charSequence2.charAt(i9 + i7))) {
                return false;
            }
        }
        return true;
    }

    private static int escapeAndDecrement(StringBuilder sb, int i5, char c) {
        int i6 = i5 - 1;
        sb.setCharAt(i5, c);
        int i7 = i5 - 2;
        sb.setCharAt(i6, IOUtils.DIR_SEPARATOR_WINDOWS);
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    public static void escapeJson(StringBuilder sb, int i5) {
        int i6 = 0;
        while (i5 < sb.length()) {
            char cCharAt = sb.charAt(i5);
            if (cCharAt != '\f' && cCharAt != '\r' && cCharAt != '\"' && cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                    case '\t':
                    case '\n':
                        i6++;
                        break;
                    default:
                        if (Character.isISOControl(cCharAt)) {
                            i6 += 5;
                        }
                        break;
                }
            } else {
                i6++;
            }
            i5++;
        }
        sb.setLength(sb.length() + i6);
        int length = sb.length() - 1;
        for (int length2 = sb.length() - 1; length > length2; length2--) {
            char cCharAt2 = sb.charAt(length2);
            if (cCharAt2 == '\f') {
                length = escapeAndDecrement(sb, length, 'f');
            } else if (cCharAt2 == '\r') {
                length = escapeAndDecrement(sb, length, 'r');
            } else if (cCharAt2 != '\"' && cCharAt2 != '\\') {
                switch (cCharAt2) {
                    case '\b':
                        length = escapeAndDecrement(sb, length, 'b');
                        break;
                    case '\t':
                        length = escapeAndDecrement(sb, length, 't');
                        break;
                    case '\n':
                        length = escapeAndDecrement(sb, length, 'n');
                        break;
                    default:
                        if (Character.isISOControl(cCharAt2)) {
                            sb.setCharAt(length, Chars.getUpperCaseHex(cCharAt2 & 15));
                            sb.setCharAt(length - 1, Chars.getUpperCaseHex((cCharAt2 & 240) >> 4));
                            sb.setCharAt(length - 2, '0');
                            sb.setCharAt(length - 3, '0');
                            int i7 = length - 5;
                            sb.setCharAt(length - 4, 'u');
                            length -= 6;
                            sb.setCharAt(i7, IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else {
                            sb.setCharAt(length, cCharAt2);
                            length--;
                        }
                        break;
                }
            } else {
                length = escapeAndDecrement(sb, length, cCharAt2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    public static void escapeXml(StringBuilder sb, int i5) {
        int i6 = 0;
        while (i5 < sb.length()) {
            char cCharAt = sb.charAt(i5);
            if (cCharAt == '\"') {
                i6 += 5;
            } else if (cCharAt == '<' || cCharAt == '>') {
                i6 += 3;
            } else if (cCharAt == '&') {
                i6 += 4;
            } else if (cCharAt == '\'') {
                i6 += 5;
            }
            i5++;
        }
        sb.setLength(sb.length() + i6);
        int length = sb.length() - 1;
        for (int length2 = sb.length() - 1; length > length2; length2--) {
            char cCharAt2 = sb.charAt(length2);
            if (cCharAt2 == '\"') {
                sb.setCharAt(length, ';');
                sb.setCharAt(length - 1, 't');
                sb.setCharAt(length - 2, 'o');
                sb.setCharAt(length - 3, 'u');
                int i7 = length - 5;
                sb.setCharAt(length - 4, 'q');
                length -= 6;
                sb.setCharAt(i7, '&');
            } else if (cCharAt2 == '<') {
                sb.setCharAt(length, ';');
                sb.setCharAt(length - 1, 't');
                int i8 = length - 3;
                sb.setCharAt(length - 2, 'l');
                length -= 4;
                sb.setCharAt(i8, '&');
            } else if (cCharAt2 == '>') {
                sb.setCharAt(length, ';');
                sb.setCharAt(length - 1, 't');
                int i9 = length - 3;
                sb.setCharAt(length - 2, 'g');
                length -= 4;
                sb.setCharAt(i9, '&');
            } else if (cCharAt2 == '&') {
                sb.setCharAt(length, ';');
                sb.setCharAt(length - 1, 'p');
                sb.setCharAt(length - 2, 'm');
                int i10 = length - 4;
                sb.setCharAt(length - 3, 'a');
                length -= 5;
                sb.setCharAt(i10, '&');
            } else if (cCharAt2 != '\'') {
                sb.setCharAt(length, cCharAt2);
                length--;
            } else {
                sb.setCharAt(length, ';');
                sb.setCharAt(length - 1, 's');
                sb.setCharAt(length - 2, 'o');
                sb.setCharAt(length - 3, 'p');
                int i11 = length - 5;
                sb.setCharAt(length - 4, 'a');
                length -= 6;
                sb.setCharAt(i11, '&');
            }
        }
    }

    public static void trimToMaxSize(StringBuilder sb, int i5) {
        if (sb == null || sb.capacity() <= i5) {
            return;
        }
        sb.setLength(i5);
        sb.trimToSize();
    }

    public static StringBuilder appendKeyDqValue(StringBuilder sb, String str, Object obj) {
        sb.append(str);
        sb.append(Chars.EQ);
        sb.append(Chars.DQUOTE);
        sb.append(obj);
        sb.append(Chars.DQUOTE);
        return sb;
    }
}
