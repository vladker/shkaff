package org.apache.logging.log4j.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Chars {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char EQ = '=';
    public static final char LF = '\n';
    public static final char NUL = 0;
    public static final char QUOTE = '\'';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';

    private Chars() {
    }

    private static char getLowerCaseAlphaDigit(int i5) {
        return (char) (i5 + 87);
    }

    public static char getLowerCaseHex(int i5) {
        if (i5 < 0 || i5 >= 16) {
            return (char) 0;
        }
        return i5 < 10 ? getNumericalDigit(i5) : getLowerCaseAlphaDigit(i5);
    }

    private static char getNumericalDigit(int i5) {
        return (char) (i5 + 48);
    }

    private static char getUpperCaseAlphaDigit(int i5) {
        return (char) (i5 + 55);
    }

    public static char getUpperCaseHex(int i5) {
        if (i5 < 0 || i5 >= 16) {
            return (char) 0;
        }
        return i5 < 10 ? getNumericalDigit(i5) : getUpperCaseAlphaDigit(i5);
    }
}
