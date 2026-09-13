package X3;

import A3.AbstractC0157z;
import java.util.Locale;

/* JADX INFO: renamed from: X3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0239e {
    public static final boolean a(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static int checkRadix(int i5) {
        if (2 <= i5 && i5 < 37) {
            return i5;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "radix ", " was not in valid range ");
        sbT.append(new U3.q(2, 36, 1));
        throw new IllegalArgumentException(sbT.toString());
    }

    public static final EnumC0236b getCategory(char c) {
        return EnumC0236b.Companion.valueOf(Character.getType(c));
    }

    public static final EnumC0238d getDirectionality(char c) {
        return EnumC0238d.Companion.valueOf(Character.getDirectionality(c));
    }

    private static final boolean isDefined(char c) {
        return Character.isDefined(c);
    }

    private static final boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static final boolean isHighSurrogate(char c) {
        return Character.isHighSurrogate(c);
    }

    private static final boolean isISOControl(char c) {
        return Character.isISOControl(c);
    }

    private static final boolean isIdentifierIgnorable(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    private static final boolean isJavaIdentifierPart(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    private static final boolean isJavaIdentifierStart(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    private static final boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    private static final boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static final boolean isLowSurrogate(char c) {
        return Character.isLowSurrogate(c);
    }

    private static final boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    private static final boolean isTitleCase(char c) {
        return Character.isTitleCase(c);
    }

    private static final boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    private static final String lowercase(char c) {
        String strValueOf = String.valueOf(c);
        kotlin.jvm.internal.E.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final char lowercaseChar(char c) {
        return Character.toLowerCase(c);
    }

    public static final String titlecase(char c, Locale locale) {
        kotlin.jvm.internal.E.f(locale, "locale");
        String strUppercase = uppercase(c, locale);
        if (strUppercase.length() <= 1) {
            String strValueOf = String.valueOf(c);
            kotlin.jvm.internal.E.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
            if (strUppercase.equals(upperCase)) {
                return String.valueOf(Character.toTitleCase(c));
            }
        } else if (c != 329) {
            char cCharAt = strUppercase.charAt(0);
            String strSubstring = strUppercase.substring(1);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
            return cCharAt + lowerCase;
        }
        return strUppercase;
    }

    private static final char titlecaseChar(char c) {
        return Character.toTitleCase(c);
    }

    private static final char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    private static final char toTitleCase(char c) {
        return Character.toTitleCase(c);
    }

    private static final char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    private static final String uppercase(char c) {
        String strValueOf = String.valueOf(c);
        kotlin.jvm.internal.E.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final char uppercaseChar(char c) {
        return Character.toUpperCase(c);
    }

    public static final String lowercase(char c, Locale locale) {
        kotlin.jvm.internal.E.f(locale, "locale");
        String strValueOf = String.valueOf(c);
        kotlin.jvm.internal.E.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String uppercase(char c, Locale locale) {
        kotlin.jvm.internal.E.f(locale, "locale");
        String strValueOf = String.valueOf(c);
        kotlin.jvm.internal.E.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
