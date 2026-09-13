package org.apache.poi.ss.format;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class CellNumberPartHandler implements CellFormatPart.PartHandler {
    private CellNumberFormatter.Special decimalPoint;
    private CellNumberFormatter.Special exponent;
    private boolean improperFraction;
    private char insertSignForExponent;
    private CellNumberFormatter.Special numerator;
    private CellNumberFormatter.Special slash;
    private double scale = 1.0d;
    private final List<CellNumberFormatter.Special> specials = new LinkedList();

    private static CellNumberFormatter.Special firstDigit(List<CellNumberFormatter.Special> list) {
        for (CellNumberFormatter.Special special : list) {
            if (isDigitFmt(special)) {
                return special;
            }
        }
        return null;
    }

    private static boolean isDigitFmt(CellNumberFormatter.Special special) {
        char c = special.ch;
        return c == '0' || c == '?' || c == '#';
    }

    private CellNumberFormatter.Special previousNumber() {
        List<CellNumberFormatter.Special> list = this.specials;
        ListIterator<CellNumberFormatter.Special> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            CellNumberFormatter.Special specialPrevious = listIterator.previous();
            if (isDigitFmt(specialPrevious)) {
                while (listIterator.hasPrevious()) {
                    CellNumberFormatter.Special specialPrevious2 = listIterator.previous();
                    if (specialPrevious.pos - specialPrevious2.pos > 1 || !isDigitFmt(specialPrevious2)) {
                        break;
                    }
                    specialPrevious = specialPrevious2;
                }
                return specialPrevious;
            }
        }
        return null;
    }

    public CellNumberFormatter.Special getDecimalPoint() {
        return this.decimalPoint;
    }

    public CellNumberFormatter.Special getExponent() {
        return this.exponent;
    }

    public CellNumberFormatter.Special getNumerator() {
        return this.numerator;
    }

    public double getScale() {
        return this.scale;
    }

    public CellNumberFormatter.Special getSlash() {
        return this.slash;
    }

    public List<CellNumberFormatter.Special> getSpecials() {
        return this.specials;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    /* JADX WARN: Code duplicated, block: B:40:0x009a  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b3 A[LOOP:0: B:41:0x00ad->B:43:0x00b3, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
    public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
        char c;
        int length = stringBuffer.length();
        char cCharAt = str.charAt(0);
        if (cCharAt == '#') {
            c = this.insertSignForExponent;
            if (c != 0) {
                this.specials.add(new CellNumberFormatter.Special(c, length));
                stringBuffer.append(this.insertSignForExponent);
                this.insertSignForExponent = (char) 0;
                length++;
            }
            for (int i5 = 0; i5 < str.length(); i5++) {
                this.specials.add(new CellNumberFormatter.Special(str.charAt(i5), length + i5));
            }
        } else {
            if (cCharAt == '%') {
                this.scale *= 100.0d;
                return str;
            }
            if (cCharAt == '?') {
                c = this.insertSignForExponent;
                if (c != 0) {
                    this.specials.add(new CellNumberFormatter.Special(c, length));
                    stringBuffer.append(this.insertSignForExponent);
                    this.insertSignForExponent = (char) 0;
                    length++;
                }
                while (i5 < str.length()) {
                    this.specials.add(new CellNumberFormatter.Special(str.charAt(i5), length + i5));
                }
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case '.':
                        if (this.decimalPoint == null && !this.specials.isEmpty()) {
                            CellNumberFormatter.Special special = new CellNumberFormatter.Special('.', length);
                            this.decimalPoint = special;
                            this.specials.add(special);
                            return str;
                        }
                        break;
                    case '/':
                        if (this.slash == null && !this.specials.isEmpty()) {
                            CellNumberFormatter.Special specialPreviousNumber = previousNumber();
                            this.numerator = specialPreviousNumber;
                            this.improperFraction = (specialPreviousNumber == firstDigit(this.specials) ? 1 : 0) | (this.improperFraction ? 1 : 0);
                            CellNumberFormatter.Special special2 = new CellNumberFormatter.Special('.', length);
                            this.slash = special2;
                            this.specials.add(special2);
                            return str;
                        }
                        break;
                    case '0':
                        c = this.insertSignForExponent;
                        if (c != 0) {
                            this.specials.add(new CellNumberFormatter.Special(c, length));
                            stringBuffer.append(this.insertSignForExponent);
                            this.insertSignForExponent = (char) 0;
                            length++;
                        }
                        while (i5 < str.length()) {
                            this.specials.add(new CellNumberFormatter.Special(str.charAt(i5), length + i5));
                        }
                        break;
                    default:
                        return null;
                }
            } else if (this.exponent == null && !this.specials.isEmpty()) {
                CellNumberFormatter.Special special3 = new CellNumberFormatter.Special('.', length);
                this.exponent = special3;
                this.specials.add(special3);
                this.insertSignForExponent = str.charAt(1);
                return str.substring(0, 1);
            }
        }
        return str;
    }

    public boolean isImproperFraction() {
        return this.improperFraction;
    }
}
