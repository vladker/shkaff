package org.apache.poi.ss.usermodel;

import java.math.BigDecimal;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.format.SimpleFraction;
import org.apache.poi.ss.formula.eval.NotImplementedException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FractionFormat extends Format {
    private static final int MAX_DENOM_POW = 4;
    private final int exactDenom;
    private final int maxDenom;
    private final String wholePartFormatString;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) FractionFormat.class);
    private static final Pattern DENOM_FORMAT_PATTERN = Pattern.compile("(?:(#+)|(\\d+))");

    public FractionFormat(String str, String str2) {
        int iPow;
        this.wholePartFormatString = str;
        Matcher matcher = DENOM_FORMAT_PATTERN.matcher(str2);
        int i5 = -1;
        if (!matcher.find()) {
            iPow = -1;
        } else if (matcher.group(2) != null) {
            try {
                int i6 = Integer.parseInt(matcher.group(2));
                i5 = i6 == 0 ? -1 : i6;
                iPow = -1;
            } catch (NumberFormatException e) {
                throw new IllegalStateException(e);
            }
        } else if (matcher.group(1) != null) {
            iPow = (int) Math.pow(10.0d, Math.min(matcher.group(1).length(), 4));
        } else {
            iPow = -1;
            i5 = 100;
        }
        this.exactDenom = (i5 > 0 || iPow > 0) ? i5 : 100;
        this.maxDenom = iPow;
    }

    public String format(Number number) {
        return format(new BigDecimal(number.doubleValue()));
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new NotImplementedException("Reverse parsing not supported");
    }

    private String format(BigDecimal bigDecimal) {
        SimpleFraction simpleFractionBuildFractionMaxDenominator;
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        boolean z6 = bigDecimal.compareTo(bigDecimal2) < 0;
        BigDecimal bigDecimalAbs = bigDecimal.abs();
        BigDecimal bigDecimal3 = new BigDecimal(bigDecimalAbs.toBigInteger());
        BigDecimal bigDecimal4 = BigDecimal.ONE;
        BigDecimal bigDecimalRemainder = bigDecimalAbs.remainder(bigDecimal4);
        if (bigDecimal3.add(bigDecimalRemainder).compareTo(bigDecimal2) == 0) {
            return "0";
        }
        if (bigDecimalRemainder.compareTo(bigDecimal2) == 0) {
            StringBuilder sb = new StringBuilder();
            if (z6) {
                sb.append('-');
            }
            sb.append(bigDecimal3);
            return sb.toString();
        }
        try {
            if (this.exactDenom > 0) {
                simpleFractionBuildFractionMaxDenominator = SimpleFraction.buildFractionExactDenominator(bigDecimalRemainder.doubleValue(), this.exactDenom);
            } else {
                simpleFractionBuildFractionMaxDenominator = SimpleFraction.buildFractionMaxDenominator(bigDecimalRemainder.doubleValue(), this.maxDenom);
            }
            StringBuilder sb2 = new StringBuilder();
            if (z6) {
                sb2.append('-');
            }
            String str = this.wholePartFormatString;
            if (str != null && !str.isEmpty()) {
                if (simpleFractionBuildFractionMaxDenominator.getNumerator() == 0) {
                    sb2.append(bigDecimal3);
                    return sb2.toString();
                }
                if (simpleFractionBuildFractionMaxDenominator.getNumerator() == simpleFractionBuildFractionMaxDenominator.getDenominator()) {
                    sb2.append(bigDecimal3.add(bigDecimal4));
                    return sb2.toString();
                }
                if (bigDecimal3.compareTo(bigDecimal2) > 0) {
                    sb2.append(bigDecimal3);
                    sb2.append(" ");
                }
                sb2.append(simpleFractionBuildFractionMaxDenominator.getNumerator());
                sb2.append(PackagingURIHelper.FORWARD_SLASH_STRING);
                sb2.append(simpleFractionBuildFractionMaxDenominator.getDenominator());
                return sb2.toString();
            }
            int denominator = simpleFractionBuildFractionMaxDenominator.getDenominator();
            sb2.append(bigDecimal3.multiply(BigDecimal.valueOf(denominator)).add(BigDecimal.valueOf(simpleFractionBuildFractionMaxDenominator.getNumerator())).toBigInteger());
            sb2.append(PackagingURIHelper.FORWARD_SLASH_STRING);
            sb2.append(denominator);
            return sb2.toString();
        } catch (RuntimeException e) {
            LOGGER.atWarn().withThrowable(e).log("Can't format fraction");
            return Double.toString(bigDecimal.doubleValue());
        }
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(format((Number) obj));
        return stringBuffer;
    }
}
