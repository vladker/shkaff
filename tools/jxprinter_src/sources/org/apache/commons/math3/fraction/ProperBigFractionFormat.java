package org.apache.commons.math3.fraction;

import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ProperBigFractionFormat extends BigFractionFormat {
    private static final long serialVersionUID = -6337346779577272307L;
    private NumberFormat wholeFormat;

    public ProperBigFractionFormat() {
        this(AbstractFormat.getDefaultNumberFormat());
    }

    @Override // org.apache.commons.math3.fraction.BigFractionFormat
    public StringBuffer format(BigFraction bigFraction, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        BigInteger numerator = bigFraction.getNumerator();
        BigInteger denominator = bigFraction.getDenominator();
        BigInteger bigIntegerDivide = numerator.divide(denominator);
        BigInteger bigIntegerRemainder = numerator.remainder(denominator);
        BigInteger bigInteger = BigInteger.ZERO;
        if (!bigInteger.equals(bigIntegerDivide)) {
            getWholeFormat().format(bigIntegerDivide, stringBuffer, fieldPosition);
            stringBuffer.append(Chars.SPACE);
            if (bigIntegerRemainder.compareTo(bigInteger) < 0) {
                bigIntegerRemainder = bigIntegerRemainder.negate();
            }
        }
        getNumeratorFormat().format(bigIntegerRemainder, stringBuffer, fieldPosition);
        stringBuffer.append(" / ");
        getDenominatorFormat().format(denominator, stringBuffer, fieldPosition);
        return stringBuffer;
    }

    public NumberFormat getWholeFormat() {
        return this.wholeFormat;
    }

    public void setWholeFormat(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT, new Object[0]);
        }
        this.wholeFormat = numberFormat;
    }

    public ProperBigFractionFormat(NumberFormat numberFormat) {
        this(numberFormat, (NumberFormat) numberFormat.clone(), (NumberFormat) numberFormat.clone());
    }

    @Override // org.apache.commons.math3.fraction.BigFractionFormat, java.text.NumberFormat
    public BigFraction parse(String str, ParsePosition parsePosition) {
        BigFraction bigFraction = super.parse(str, parsePosition);
        if (bigFraction != null) {
            return bigFraction;
        }
        int index = parsePosition.getIndex();
        AbstractFormat.parseAndIgnoreWhitespace(str, parsePosition);
        BigInteger nextBigInteger = parseNextBigInteger(str, parsePosition);
        if (nextBigInteger == null) {
            parsePosition.setIndex(index);
            return null;
        }
        AbstractFormat.parseAndIgnoreWhitespace(str, parsePosition);
        BigInteger nextBigInteger2 = parseNextBigInteger(str, parsePosition);
        if (nextBigInteger2 == null) {
            parsePosition.setIndex(index);
            return null;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        if (nextBigInteger2.compareTo(bigInteger) < 0) {
            parsePosition.setIndex(index);
            return null;
        }
        int index2 = parsePosition.getIndex();
        char nextCharacter = AbstractFormat.parseNextCharacter(str, parsePosition);
        if (nextCharacter == 0) {
            return new BigFraction(nextBigInteger2);
        }
        if (nextCharacter != '/') {
            parsePosition.setIndex(index);
            parsePosition.setErrorIndex(index2);
            return null;
        }
        AbstractFormat.parseAndIgnoreWhitespace(str, parsePosition);
        BigInteger nextBigInteger3 = parseNextBigInteger(str, parsePosition);
        if (nextBigInteger3 == null) {
            parsePosition.setIndex(index);
            return null;
        }
        if (nextBigInteger3.compareTo(bigInteger) < 0) {
            parsePosition.setIndex(index);
            return null;
        }
        boolean z6 = nextBigInteger.compareTo(bigInteger) < 0;
        if (z6) {
            nextBigInteger = nextBigInteger.negate();
        }
        BigInteger bigIntegerAdd = nextBigInteger.multiply(nextBigInteger3).add(nextBigInteger2);
        if (z6) {
            bigIntegerAdd = bigIntegerAdd.negate();
        }
        return new BigFraction(bigIntegerAdd, nextBigInteger3);
    }

    public ProperBigFractionFormat(NumberFormat numberFormat, NumberFormat numberFormat2, NumberFormat numberFormat3) {
        super(numberFormat2, numberFormat3);
        setWholeFormat(numberFormat);
    }
}
