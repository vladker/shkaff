package org.apache.commons.math3.util;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CompositeFormat {
    private CompositeFormat() {
    }

    public static StringBuffer formatDouble(double d, NumberFormat numberFormat, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            numberFormat.format(d, stringBuffer, fieldPosition);
            return stringBuffer;
        }
        stringBuffer.append('(');
        stringBuffer.append(d);
        stringBuffer.append(')');
        return stringBuffer;
    }

    public static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }

    public static void parseAndIgnoreWhitespace(String str, ParsePosition parsePosition) {
        parseNextCharacter(str, parsePosition);
        parsePosition.setIndex(parsePosition.getIndex() - 1);
    }

    public static boolean parseFixedstring(String str, String str2, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = str2.length() + index;
        if (index < str.length() && length <= str.length() && str.substring(index, length).compareTo(str2) == 0) {
            parsePosition.setIndex(length);
            return true;
        }
        parsePosition.setIndex(index);
        parsePosition.setErrorIndex(index);
        return false;
    }

    public static char parseNextCharacter(String str, ParsePosition parsePosition) {
        int i5;
        char cCharAt;
        int index = parsePosition.getIndex();
        int length = str.length();
        if (index >= length) {
            return (char) 0;
        }
        while (true) {
            i5 = index + 1;
            cCharAt = str.charAt(index);
            if (!Character.isWhitespace(cCharAt) || i5 >= length) {
                break;
            }
            index = i5;
        }
        parsePosition.setIndex(i5);
        if (i5 < length) {
            return cCharAt;
        }
        return (char) 0;
    }

    private static Number parseNumber(String str, double d, ParsePosition parsePosition) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(d);
        sb.append(')');
        int length = sb.length();
        int index = parsePosition.getIndex();
        int i5 = length + index;
        if (i5 >= str.length() || str.substring(index, i5).compareTo(sb.toString()) != 0) {
            return null;
        }
        Double dValueOf = Double.valueOf(d);
        parsePosition.setIndex(i5);
        return dValueOf;
    }

    public static NumberFormat getDefaultNumberFormat(Locale locale) {
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        numberFormat.setMaximumFractionDigits(10);
        return numberFormat;
    }

    public static Number parseNumber(String str, NumberFormat numberFormat, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        Number number = numberFormat.parse(str, parsePosition);
        if (index == parsePosition.getIndex()) {
            double[] dArr = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
            for (int i5 = 0; i5 < 3; i5++) {
                number = parseNumber(str, dArr[i5], parsePosition);
                if (number != null) {
                    return number;
                }
            }
        }
        return number;
    }
}
