package X3;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h0 {
    public static final String titlecaseImpl(char c) {
        String strValueOf = String.valueOf(c);
        kotlin.jvm.internal.E.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        String strSubstring = upperCase.substring(1);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }
}
