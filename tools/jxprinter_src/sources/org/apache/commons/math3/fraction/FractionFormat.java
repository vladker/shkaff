package org.apache.commons.math3.fraction;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FractionFormat extends AbstractFormat {
    private static final long serialVersionUID = 3008655719530972611L;

    public FractionFormat() {
    }

    public static String formatFraction(Fraction fraction) {
        return getImproperInstance().format(fraction);
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static NumberFormat getDefaultNumberFormat() {
        return AbstractFormat.getDefaultNumberFormat(Locale.getDefault());
    }

    public static FractionFormat getImproperInstance() {
        return getImproperInstance(Locale.getDefault());
    }

    public static FractionFormat getProperInstance() {
        return getProperInstance(Locale.getDefault());
    }

    public StringBuffer format(Fraction fraction, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        getNumeratorFormat().format(fraction.getNumerator(), stringBuffer, fieldPosition);
        stringBuffer.append(" / ");
        getDenominatorFormat().format(fraction.getDenominator(), stringBuffer, fieldPosition);
        return stringBuffer;
    }

    public FractionFormat(NumberFormat numberFormat) {
        super(numberFormat);
    }

    public static FractionFormat getImproperInstance(Locale locale) {
        return new FractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
    }

    public static FractionFormat getProperInstance(Locale locale) {
        return new ProperFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
    }

    public FractionFormat(NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(numberFormat, numberFormat2);
    }

    @Override // java.text.NumberFormat
    public Fraction parse(String str) {
        ParsePosition parsePosition = new ParsePosition(0);
        Fraction fraction = parse(str, parsePosition);
        if (parsePosition.getIndex() != 0) {
            return fraction;
        }
        throw new MathParseException(str, parsePosition.getErrorIndex(), Fraction.class);
    }

    @Override // java.text.NumberFormat, java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Fraction) {
            return format((Fraction) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof Number) {
            return format(new Fraction(((Number) obj).doubleValue()), stringBuffer, fieldPosition);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
    }

    @Override // java.text.NumberFormat
    public Fraction parse(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        AbstractFormat.parseAndIgnoreWhitespace(str, parsePosition);
        Number number = getNumeratorFormat().parse(str, parsePosition);
        if (number == null) {
            parsePosition.setIndex(index);
            return null;
        }
        int index2 = parsePosition.getIndex();
        char nextCharacter = AbstractFormat.parseNextCharacter(str, parsePosition);
        if (nextCharacter == 0) {
            return new Fraction(number.intValue(), 1);
        }
        if (nextCharacter != '/') {
            parsePosition.setIndex(index);
            parsePosition.setErrorIndex(index2);
            return null;
        }
        AbstractFormat.parseAndIgnoreWhitespace(str, parsePosition);
        Number number2 = getDenominatorFormat().parse(str, parsePosition);
        if (number2 == null) {
            parsePosition.setIndex(index);
            return null;
        }
        return new Fraction(number.intValue(), number2.intValue());
    }
}
