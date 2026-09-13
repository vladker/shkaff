package org.apache.poi.ss.util;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NumberToTextConverter {
    private static final long EXCEL_NAN_BITS = -276939487313920L;
    private static final int MAX_TEXT_LEN = 20;

    private NumberToTextConverter() {
    }

    private static void appendExp(StringBuilder sb, int i5) {
        if (i5 >= 10) {
            sb.append(i5);
        } else {
            sb.append('0');
            sb.append((char) (i5 + 48));
        }
    }

    private static void convertToText(StringBuilder sb, NormalisedDecimal normalisedDecimal) {
        String significantDecimalDigits;
        NormalisedDecimal normalisedDecimalRoundUnits = normalisedDecimal.roundUnits();
        int decimalExponent = normalisedDecimalRoundUnits.getDecimalExponent();
        if (Math.abs(decimalExponent) > 98) {
            significantDecimalDigits = normalisedDecimalRoundUnits.getSignificantDecimalDigitsLastDigitRounded();
            if (significantDecimalDigits.length() == 16) {
                decimalExponent++;
            }
        } else {
            significantDecimalDigits = normalisedDecimalRoundUnits.getSignificantDecimalDigits();
        }
        int iCountSignifantDigits = countSignifantDigits(significantDecimalDigits);
        if (decimalExponent < 0) {
            formatLessThanOne(sb, significantDecimalDigits, decimalExponent, iCountSignifantDigits);
        } else {
            formatGreaterThanOne(sb, significantDecimalDigits, decimalExponent, iCountSignifantDigits);
        }
    }

    private static int countSignifantDigits(String str) {
        int length = str.length() - 1;
        while (str.charAt(length) == '0') {
            length--;
            if (length < 0) {
                throw new RuntimeException("No non-zero digits found");
            }
        }
        return length + 1;
    }

    private static void formatGreaterThanOne(StringBuilder sb, String str, int i5, int i6) {
        if (i5 > 19) {
            sb.append(str.charAt(0));
            if (i6 > 1) {
                sb.append('.');
                sb.append(str.subSequence(1, i6));
            }
            sb.append("E+");
            appendExp(sb, i5);
            return;
        }
        int i7 = (i6 - i5) - 1;
        if (i7 > 0) {
            int i8 = i5 + 1;
            sb.append(str.subSequence(0, i8));
            sb.append('.');
            sb.append(str.subSequence(i8, i6));
            return;
        }
        sb.append(str.subSequence(0, i6));
        for (int i9 = -i7; i9 > 0; i9--) {
            sb.append('0');
        }
    }

    private static void formatLessThanOne(StringBuilder sb, String str, int i5, int i6) {
        int i7 = -i5;
        if (!needsScientificNotation(i7 + 1 + i6)) {
            sb.append("0.");
            for (int i8 = i7 - 1; i8 > 0; i8--) {
                sb.append('0');
            }
            sb.append(str.subSequence(0, i6));
            return;
        }
        sb.append(str.charAt(0));
        if (i6 > 1) {
            sb.append('.');
            sb.append(str.subSequence(1, i6));
        }
        sb.append("E-");
        appendExp(sb, i7);
    }

    private static boolean needsScientificNotation(int i5) {
        return i5 > 20;
    }

    public static String rawDoubleBitsToText(long j6) {
        boolean z6 = false;
        boolean z7 = j6 < 0;
        if (z7) {
            j6 &= LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j6 == 0) {
            return z7 ? "-0" : "0";
        }
        ExpandedDouble expandedDouble = new ExpandedDouble(j6);
        if (expandedDouble.getBinaryExponent() < -1022) {
            return z7 ? "-0" : "0";
        }
        if (expandedDouble.getBinaryExponent() != 1024) {
            z6 = z7;
        } else if (j6 == EXCEL_NAN_BITS) {
            return "3.484840871308E+308";
        }
        NormalisedDecimal normalisedDecimalNormaliseBaseTen = expandedDouble.normaliseBaseTen();
        StringBuilder sb = new StringBuilder(21);
        if (z6) {
            sb.append('-');
        }
        convertToText(sb, normalisedDecimalNormaliseBaseTen);
        return sb.toString();
    }

    public static String toText(double d) {
        return rawDoubleBitsToText(Double.doubleToLongBits(d));
    }
}
