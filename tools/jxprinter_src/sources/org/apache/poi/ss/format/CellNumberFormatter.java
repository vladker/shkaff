package org.apache.poi.ss.format;

import A3.AbstractC0157z;
import V2.f;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.android.arouter.utils.Consts;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellNumberFormatter extends CellFormatter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) CellNumberFormatter.class);
    private final CellFormatter SIMPLE_NUMBER;
    private final Special afterFractional;
    private final Special afterInteger;
    private final DecimalFormat decimalFmt;
    private final Special decimalPoint;
    private final String denominatorFmt;
    private final List<Special> denominatorSpecials;
    private final String desc;
    private final Special exponent;
    private final List<Special> exponentDigitSpecials;
    private final List<Special> exponentSpecials;
    private final List<Special> fractionalSpecials;
    private final boolean improperFraction;
    private final List<Special> integerSpecials;
    private final int maxDenominator;
    private final Special numerator;
    private final String numeratorFmt;
    private final List<Special> numeratorSpecials;
    private final String printfFmt;
    private final double scale;
    private final boolean showGroupingSeparator;
    private final Special slash;
    private final List<Special> specials;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class GeneralNumberFormatter extends CellFormatter {
        @Override // org.apache.poi.ss.format.CellFormatter
        public void formatValue(StringBuffer stringBuffer, Object obj) {
            CellFormatter cellNumberFormatter;
            if (obj == null) {
                return;
            }
            if (obj instanceof Number) {
                cellNumberFormatter = ((Number) obj).doubleValue() % 1.0d == 0.0d ? new CellNumberFormatter(this.locale, "#") : new CellNumberFormatter(this.locale, "#.#");
            } else {
                cellNumberFormatter = CellTextFormatter.SIMPLE_TEXT;
            }
            cellNumberFormatter.formatValue(stringBuffer, obj);
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void simpleValue(StringBuffer stringBuffer, Object obj) {
            formatValue(stringBuffer, obj);
        }

        private GeneralNumberFormatter(Locale locale) {
            super(locale, "General");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Special {
        final char ch;
        int pos;

        public Special(char c, int i5) {
            this.ch = c;
            this.pos = i5;
        }

        public String toString() {
            return "'" + this.ch + "' @ " + this.pos;
        }
    }

    public CellNumberFormatter(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    private int calculateIntegerPartWidth() {
        Special next;
        Iterator<Special> it = this.specials.iterator();
        int i5 = 0;
        while (it.hasNext() && (next = it.next()) != this.afterInteger) {
            if (isDigitFmt(next)) {
                i5++;
            }
        }
        return i5;
    }

    private static CellNumberStringMod deleteMod(Special special, boolean z6, Special special2, boolean z7) {
        return new CellNumberStringMod(special, z6, special2, z7);
    }

    private int fractionalEnd() {
        Special special = this.afterFractional;
        return special == null ? this.specials.size() : this.specials.indexOf(special);
    }

    private DecimalFormatSymbols getDecimalFormatSymbols() {
        return DecimalFormatSymbols.getInstance(this.locale);
    }

    private static boolean hasChar(char c, List<Special> list) {
        Iterator<Special> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().ch == c) {
                return true;
            }
        }
        return false;
    }

    private static CellNumberStringMod insertMod(Special special, CharSequence charSequence, int i5) {
        return new CellNumberStringMod(special, charSequence, i5);
    }

    private int integerEnd() {
        Special special = this.afterInteger;
        return special == null ? this.specials.size() : this.specials.indexOf(special);
    }

    private static boolean interpretIntegerCommas(StringBuffer stringBuffer, List<Special> list, Special special, int i5, int i6, double[] dArr) {
        ListIterator<Special> listIterator = list.listIterator(i5);
        int i7 = 0;
        boolean z6 = true;
        boolean z7 = false;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().ch != ',') {
                z6 = false;
            } else if (z6) {
                dArr[0] = dArr[0] / 1000.0d;
            } else {
                z7 = true;
            }
        }
        if (special != null) {
            ListIterator<Special> listIterator2 = list.listIterator(i6);
            while (listIterator2.hasPrevious() && listIterator2.previous().ch == ',') {
                dArr[0] = dArr[0] / 1000.0d;
            }
        }
        ListIterator<Special> listIterator3 = list.listIterator();
        while (listIterator3.hasNext()) {
            Special next = listIterator3.next();
            next.pos -= i7;
            if (next.ch == ',') {
                i7++;
                listIterator3.remove();
                stringBuffer.deleteCharAt(next.pos);
            }
        }
        return z7;
    }

    private static int interpretPrecision(Special special, List<Special> list) {
        int iIndexOf = list.indexOf(special);
        int i5 = 0;
        if (iIndexOf != -1) {
            ListIterator<Special> listIterator = list.listIterator(iIndexOf + 1);
            while (listIterator.hasNext() && isDigitFmt(listIterator.next())) {
                i5++;
            }
        }
        return i5;
    }

    private static boolean isDigitFmt(Special special) {
        char c = special.ch;
        return c == '0' || c == '?' || c == '#';
    }

    private static Special lastSpecial(List<Special> list) {
        return (Special) AbstractC0157z.f(1, list);
    }

    private String localiseFormat(String str) {
        DecimalFormatSymbols decimalFormatSymbols = getDecimalFormatSymbols();
        if (!str.contains(",") || decimalFormatSymbols.getGroupingSeparator() == ',') {
            return (!str.contains(Consts.DOT) || decimalFormatSymbols.getDecimalSeparator() == '.') ? str : str.replace('.', decimalFormatSymbols.getDecimalSeparator());
        }
        return (!str.contains(Consts.DOT) || decimalFormatSymbols.getDecimalSeparator() == '.') ? str.replace(',', decimalFormatSymbols.getGroupingSeparator()) : replaceLast(str, "\\.", "[DECIMAL_SEPARATOR]").replace(',', decimalFormatSymbols.getGroupingSeparator()).replace("[DECIMAL_SEPARATOR]", Character.toString(decimalFormatSymbols.getDecimalSeparator()));
    }

    private static int maxValue(List<Special> list) {
        return Math.toIntExact(Math.round(Math.pow(10.0d, list.size()) - 1.0d));
    }

    private static void placeZeros(StringBuffer stringBuffer, List<Special> list) {
        Iterator<Special> it = list.iterator();
        while (it.hasNext()) {
            if (isDigitFmt(it.next())) {
                stringBuffer.append('0');
            }
        }
    }

    private static String replaceLast(String str, String str2, String str3) {
        return str.replaceFirst(AbstractC0157z.n("(?s)(.*)", str2), "$1" + str3);
    }

    private static CellNumberStringMod replaceMod(Special special, boolean z6, Special special2, boolean z7, char c) {
        return new CellNumberStringMod(special, z6, special2, z7, c);
    }

    private static String singleNumberFormat(List<Special> list) {
        return "%0" + list.size() + "d";
    }

    private List<Special> specialsFor(int i5, int i6) {
        if (i5 >= this.specials.size()) {
            return Collections.EMPTY_LIST;
        }
        int i7 = i6 + i5;
        ListIterator<Special> listIterator = this.specials.listIterator(i7);
        Special next = listIterator.next();
        while (listIterator.hasNext()) {
            Special next2 = listIterator.next();
            if (!isDigitFmt(next2) || next2.pos - next.pos > 1) {
                break;
            }
            i7++;
            next = next2;
        }
        return this.specials.subList(i5, i7 + 1);
    }

    private void writeFraction(double d, StringBuffer stringBuffer, double d6, StringBuffer stringBuffer2, Set<CellNumberStringMod> set) {
        int numerator;
        int denominator = 1;
        if (!this.improperFraction) {
            if (d6 == 0.0d && !hasChar('0', this.numeratorSpecials)) {
                writeInteger(stringBuffer, stringBuffer2, this.integerSpecials, set, false);
                Special specialLastSpecial = lastSpecial(this.integerSpecials);
                Special specialLastSpecial2 = lastSpecial(this.denominatorSpecials);
                if (hasChar('?', this.integerSpecials, this.numeratorSpecials, this.denominatorSpecials)) {
                    set.add(replaceMod(specialLastSpecial, false, specialLastSpecial2, true, Chars.SPACE));
                    return;
                } else {
                    set.add(deleteMod(specialLastSpecial, false, specialLastSpecial2, true));
                    return;
                }
            }
            boolean zHasChar = hasChar('0', this.numeratorSpecials);
            boolean zHasChar2 = hasChar('0', this.integerSpecials);
            boolean z6 = d6 == 0.0d && ((this.integerSpecials.isEmpty() || (this.integerSpecials.size() == 1 && hasChar('#', this.integerSpecials))) || !zHasChar);
            boolean z7 = (d6 == 0.0d || zHasChar2) ? false : true;
            if (d == 0.0d && (z6 || z7)) {
                Special specialLastSpecial3 = lastSpecial(this.integerSpecials);
                set.add(hasChar('?', this.integerSpecials, this.numeratorSpecials) ? replaceMod(specialLastSpecial3, true, this.numerator, false, Chars.SPACE) : deleteMod(specialLastSpecial3, true, this.numerator, false));
            } else {
                writeInteger(stringBuffer, stringBuffer2, this.integerSpecials, set, false);
            }
        }
        if (d6 != 0.0d) {
            try {
                if (this.improperFraction && d6 % 1.0d == 0.0d) {
                    numerator = (int) Math.round(d6);
                } else {
                    SimpleFraction simpleFractionBuildFractionMaxDenominator = SimpleFraction.buildFractionMaxDenominator(d6, this.maxDenominator);
                    numerator = simpleFractionBuildFractionMaxDenominator.getNumerator();
                    denominator = simpleFractionBuildFractionMaxDenominator.getDenominator();
                }
            } catch (RuntimeException e) {
                LOG.atError().withThrowable(e).log("error while fraction evaluation");
                return;
            }
        } else {
            numerator = (int) Math.round(d6);
        }
        if (this.improperFraction) {
            numerator = Math.toIntExact(((long) numerator) + Math.round(((double) denominator) * d));
        }
        writeSingleInteger(this.numeratorFmt, numerator, stringBuffer2, this.numeratorSpecials, set);
        writeSingleInteger(this.denominatorFmt, denominator, stringBuffer2, this.denominatorSpecials, set);
    }

    private void writeFractional(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        char c;
        if (this.fractionalSpecials.isEmpty()) {
            return;
        }
        int iIndexOf = stringBuffer.indexOf(Character.toString(getDecimalFormatSymbols().getDecimalSeparator())) + 1;
        int iIndexOf2 = this.exponent != null ? stringBuffer.indexOf("e") : stringBuffer.length();
        do {
            iIndexOf2--;
            if (iIndexOf2 <= iIndexOf) {
                break;
            }
        } while (stringBuffer.charAt(iIndexOf2) == '0');
        for (Special special : this.fractionalSpecials) {
            char cCharAt = stringBuffer.charAt(iIndexOf);
            if (cCharAt != '0' || (c = special.ch) == '0' || iIndexOf < iIndexOf2) {
                stringBuffer2.setCharAt(special.pos, cCharAt);
            } else if (c == '?') {
                stringBuffer2.setCharAt(special.pos, Chars.SPACE);
            }
            iIndexOf++;
        }
    }

    private void writeInteger(StringBuffer stringBuffer, StringBuffer stringBuffer2, List<Special> list, Set<CellNumberStringMod> set, boolean z6) {
        int i5;
        Special special;
        char c;
        char cCharAt;
        DecimalFormatSymbols decimalFormatSymbols = getDecimalFormatSymbols();
        String string = Character.toString(decimalFormatSymbols.getDecimalSeparator());
        String string2 = Character.toString(decimalFormatSymbols.getGroupingSeparator());
        int i6 = 1;
        int iIndexOf = stringBuffer.indexOf(string) - 1;
        if (iIndexOf < 0) {
            iIndexOf = ((this.exponent == null || list != this.integerSpecials) ? stringBuffer.length() : stringBuffer.indexOf(ExifInterface.LONGITUDE_EAST)) - 1;
        }
        int i7 = 0;
        while (i7 < iIndexOf && ((cCharAt = stringBuffer.charAt(i7)) == '0' || cCharAt == decimalFormatSymbols.getGroupingSeparator())) {
            i7++;
        }
        ListIterator<Special> listIterator = list.listIterator(list.size());
        Special special2 = null;
        int i8 = 0;
        while (listIterator.hasPrevious()) {
            char cCharAt2 = iIndexOf >= 0 ? stringBuffer.charAt(iIndexOf) : '0';
            Special specialPrevious = listIterator.previous();
            int i9 = (z6 && i8 > 0 && i8 % 3 == 0) ? i6 : 0;
            int i10 = i6;
            if (cCharAt2 != '0' || (c = specialPrevious.ch) == '0' || c == '?' || iIndexOf >= i7) {
                i5 = (specialPrevious.ch != '?' || iIndexOf >= i7) ? 0 : i10;
                int i11 = specialPrevious.pos;
                if (i5 != 0) {
                    cCharAt2 = Chars.SPACE;
                }
                stringBuffer2.setCharAt(i11, cCharAt2);
                special = specialPrevious;
            } else {
                special = special2;
                i5 = 0;
            }
            if (i9 != 0) {
                set.add(insertMod(specialPrevious, i5 != 0 ? " " : string2, 2));
            }
            i8++;
            iIndexOf--;
            special2 = special;
            i6 = i10;
        }
        int i12 = i6;
        if (iIndexOf >= 0) {
            int i13 = iIndexOf + 1;
            StringBuffer stringBuffer3 = new StringBuffer(stringBuffer.substring(0, i13));
            if (z6) {
                while (i13 > 0) {
                    if (i8 > 0 && i8 % 3 == 0) {
                        stringBuffer3.insert(i13, string2);
                    }
                    i8++;
                    i13--;
                }
            }
            set.add(insertMod(special2, stringBuffer3, i12));
        }
    }

    private void writeScientific(double d, StringBuffer stringBuffer, Set<CellNumberStringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(1);
        this.decimalFmt.format(d, stringBuffer2, fieldPosition);
        writeInteger(stringBuffer2, stringBuffer, this.integerSpecials, set, this.showGroupingSeparator);
        writeFractional(stringBuffer2, stringBuffer);
        int endIndex = fieldPosition.getEndIndex();
        int i5 = endIndex + 1;
        char cCharAt = stringBuffer2.charAt(i5);
        if (cCharAt != '-') {
            stringBuffer2.insert(i5, '+');
            cCharAt = '+';
        }
        Special next = this.exponentSpecials.listIterator(1).next();
        char c = next.ch;
        if (cCharAt == '-' || c == '+') {
            set.add(replaceMod(next, true, next, true, cCharAt));
        } else {
            set.add(deleteMod(next, true, next, true));
        }
        writeInteger(new StringBuffer(stringBuffer2.substring(endIndex + 2)), stringBuffer, this.exponentDigitSpecials, set, false);
    }

    private void writeSingleInteger(String str, int i5, StringBuffer stringBuffer, List<Special> list, Set<CellNumberStringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        Formatter formatter = new Formatter(stringBuffer2, this.locale);
        try {
            formatter.format(this.locale, str, Integer.valueOf(i5));
            formatter.close();
            writeInteger(stringBuffer2, stringBuffer, list, set, false);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        double d;
        CellNumberFormatter cellNumberFormatter = this;
        double dDoubleValue = BigDecimal.valueOf(((Number) obj).doubleValue()).multiply(BigDecimal.valueOf(cellNumberFormatter.scale)).doubleValue();
        double d6 = 0.0d;
        int i5 = 1;
        boolean z6 = dDoubleValue < 0.0d;
        if (z6) {
            dDoubleValue = -dDoubleValue;
        }
        if (cellNumberFormatter.slash == null) {
            d = d6;
        } else if (cellNumberFormatter.improperFraction) {
            d = dDoubleValue;
            dDoubleValue = 0.0d;
        } else {
            d6 = dDoubleValue % 1.0d;
            dDoubleValue = (long) dDoubleValue;
            d = d6;
        }
        TreeSet treeSet = new TreeSet();
        StringBuffer stringBuffer2 = new StringBuffer(cellNumberFormatter.localiseFormat(cellNumberFormatter.desc));
        if (cellNumberFormatter.exponent != null) {
            cellNumberFormatter.writeScientific(dDoubleValue, stringBuffer2, treeSet);
        } else if (cellNumberFormatter.improperFraction) {
            cellNumberFormatter.writeFraction(dDoubleValue, null, d, stringBuffer2, treeSet);
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            try {
                Formatter formatter = new Formatter(stringBuffer3, cellNumberFormatter.locale);
                try {
                    formatter.format(cellNumberFormatter.locale, cellNumberFormatter.printfFmt, Double.valueOf(dDoubleValue));
                    formatter.close();
                    if (cellNumberFormatter.numerator == null) {
                        cellNumberFormatter.writeFractional(stringBuffer3, stringBuffer2);
                        cellNumberFormatter.writeInteger(stringBuffer3, stringBuffer2, cellNumberFormatter.integerSpecials, treeSet, cellNumberFormatter.showGroupingSeparator);
                        cellNumberFormatter = this;
                    } else {
                        cellNumberFormatter.writeFraction(dDoubleValue, stringBuffer3, d, stringBuffer2, treeSet);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            formatter.close();
                            throw th2;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th2;
                        }
                    }
                }
            } catch (IllegalFormatException e) {
                throw new IllegalArgumentException("Format: " + cellNumberFormatter.printfFmt, e);
            }
        }
        String string = Character.toString(cellNumberFormatter.getDecimalFormatSymbols().getGroupingSeparator());
        Iterator it = treeSet.iterator();
        CellNumberStringMod cellNumberStringMod = it.hasNext() ? (CellNumberStringMod) it.next() : null;
        f fVar = new f();
        int length = 0;
        for (Special special : cellNumberFormatter.specials) {
            int i6 = special.pos;
            int i7 = i6 + length;
            if (!fVar.f(i6) && stringBuffer2.charAt(i7) == '#') {
                stringBuffer2.deleteCharAt(i7);
                length--;
                fVar.j(special.pos);
            }
            while (cellNumberStringMod != null && special == cellNumberStringMod.getSpecial()) {
                int length2 = stringBuffer2.length();
                int i8 = special.pos + length;
                int op = cellNumberStringMod.getOp();
                if (op == i5) {
                    it = it;
                    stringBuffer2.insert(i8, cellNumberStringMod.getToAdd());
                } else if (op == 2) {
                    it = it;
                    if (!cellNumberStringMod.getToAdd().equals(string) || !fVar.f(special.pos)) {
                        stringBuffer2.insert(i8 + 1, cellNumberStringMod.getToAdd());
                    }
                } else {
                    if (op != 3) {
                        throw new IllegalStateException("Unknown op: " + cellNumberStringMod.getOp());
                    }
                    int i9 = special.pos;
                    if (!cellNumberStringMod.isStartInclusive()) {
                        i9++;
                        i8++;
                    }
                    while (fVar.f(i9)) {
                        i9++;
                        i8++;
                    }
                    int i10 = cellNumberStringMod.getEnd().pos;
                    if (cellNumberStringMod.isEndInclusive()) {
                        i10++;
                    }
                    int i11 = i10 + length;
                    if (i8 < i11) {
                        if (cellNumberStringMod.getToAdd() == null || cellNumberStringMod.getToAdd().length() != 0) {
                            char cCharAt = cellNumberStringMod.getToAdd().charAt(0);
                            while (i8 < i11) {
                                stringBuffer2.setCharAt(i8, cCharAt);
                                i8++;
                            }
                        } else {
                            stringBuffer2.delete(i8, i11);
                        }
                        fVar.set(i9, i10);
                    } else {
                        it = it;
                    }
                }
                length += stringBuffer2.length() - length2;
                cellNumberStringMod = it.hasNext() ? (CellNumberStringMod) it.next() : null;
                it = it;
                i5 = 1;
            }
            it = it;
            i5 = 1;
        }
        if (z6) {
            stringBuffer.append('-');
        }
        stringBuffer.append(stringBuffer2);
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        this.SIMPLE_NUMBER.formatValue(stringBuffer, obj);
    }

    public CellNumberFormatter(Locale locale, String str) {
        int i5;
        super(locale, str);
        ArrayList arrayList = new ArrayList();
        this.specials = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.integerSpecials = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.fractionalSpecials = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.numeratorSpecials = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.denominatorSpecials = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        this.exponentSpecials = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        this.exponentDigitSpecials = arrayList7;
        this.SIMPLE_NUMBER = new GeneralNumberFormatter(this.locale);
        CellNumberPartHandler cellNumberPartHandler = new CellNumberPartHandler();
        StringBuffer format = CellFormatPart.parseFormat(str, CellFormatType.NUMBER, cellNumberPartHandler);
        Special exponent = cellNumberPartHandler.getExponent();
        this.exponent = exponent;
        arrayList.addAll(cellNumberPartHandler.getSpecials());
        this.improperFraction = cellNumberPartHandler.isImproperFraction();
        if ((cellNumberPartHandler.getDecimalPoint() == null && cellNumberPartHandler.getExponent() == null) || cellNumberPartHandler.getSlash() == null) {
            this.slash = cellNumberPartHandler.getSlash();
            this.numerator = cellNumberPartHandler.getNumerator();
        } else {
            this.slash = null;
            this.numerator = null;
        }
        int iInterpretPrecision = interpretPrecision(cellNumberPartHandler.getDecimalPoint(), arrayList);
        if (cellNumberPartHandler.getDecimalPoint() != null) {
            int i6 = iInterpretPrecision + 1;
            if (iInterpretPrecision == 0) {
                arrayList.remove(cellNumberPartHandler.getDecimalPoint());
                this.decimalPoint = null;
            } else {
                this.decimalPoint = cellNumberPartHandler.getDecimalPoint();
            }
            i5 = i6;
        } else {
            this.decimalPoint = null;
            i5 = 0;
        }
        Special special = this.decimalPoint;
        if (special != null) {
            this.afterInteger = special;
        } else if (exponent != null) {
            this.afterInteger = exponent;
        } else {
            Special special2 = this.numerator;
            if (special2 != null) {
                this.afterInteger = special2;
            } else {
                this.afterInteger = null;
            }
        }
        if (exponent != null) {
            this.afterFractional = exponent;
        } else {
            Special special3 = this.numerator;
            if (special3 != null) {
                this.afterFractional = special3;
            } else {
                this.afterFractional = null;
            }
        }
        double[] dArr = {cellNumberPartHandler.getScale()};
        boolean z6 = true;
        this.showGroupingSeparator = interpretIntegerCommas(format, arrayList, this.decimalPoint, integerEnd(), fractionalEnd(), dArr);
        if (exponent == null) {
            this.scale = dArr[0];
        } else {
            this.scale = 1.0d;
        }
        if (iInterpretPrecision != 0) {
            arrayList3.addAll(arrayList.subList(arrayList.indexOf(this.decimalPoint) + 1, fractionalEnd()));
        }
        if (exponent != null) {
            int iIndexOf = arrayList.indexOf(exponent);
            arrayList6.addAll(specialsFor(iIndexOf, 2));
            arrayList7.addAll(specialsFor(iIndexOf + 2));
        }
        if (this.slash != null) {
            Special special4 = this.numerator;
            if (special4 != null) {
                arrayList4.addAll(specialsFor(arrayList.indexOf(special4)));
            }
            arrayList5.addAll(specialsFor(arrayList.indexOf(this.slash) + 1));
            if (arrayList5.isEmpty()) {
                arrayList4.clear();
                this.maxDenominator = 1;
                this.numeratorFmt = null;
                this.denominatorFmt = null;
            } else {
                this.maxDenominator = maxValue(arrayList5);
                this.numeratorFmt = singleNumberFormat(arrayList4);
                this.denominatorFmt = singleNumberFormat(arrayList5);
            }
        } else {
            this.maxDenominator = 1;
            this.numeratorFmt = null;
            this.denominatorFmt = null;
        }
        arrayList2.addAll(arrayList.subList(0, integerEnd()));
        if (exponent == null) {
            int iCalculateIntegerPartWidth = calculateIntegerPartWidth() + i5;
            if (iCalculateIntegerPartWidth == 0) {
                this.printfFmt = "";
            } else {
                this.printfFmt = "%0" + iCalculateIntegerPartWidth + '.' + iInterpretPrecision + "f";
            }
            this.decimalFmt = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (arrayList2.size() == 1) {
                stringBuffer.append("0");
                z6 = false;
            } else {
                int size = arrayList2.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj = arrayList2.get(i7);
                    i7++;
                    if (isDigitFmt((Special) obj)) {
                        stringBuffer.append(z6 ? '#' : '0');
                        z6 = false;
                    }
                }
            }
            if (!this.fractionalSpecials.isEmpty()) {
                stringBuffer.append('.');
                Iterator<Special> it = this.fractionalSpecials.iterator();
                while (it.hasNext()) {
                    if (isDigitFmt(it.next())) {
                        if (!z6) {
                            stringBuffer.append('0');
                        }
                        z6 = false;
                    }
                }
            }
            stringBuffer.append('E');
            List<Special> list = this.exponentSpecials;
            placeZeros(stringBuffer, list.subList(2, list.size()));
            this.decimalFmt = new DecimalFormat(stringBuffer.toString(), getDecimalFormatSymbols());
            this.printfFmt = null;
        }
        this.desc = format.toString();
    }

    private static boolean hasChar(char c, List<Special> list, List<Special> list2) {
        return hasChar(c, list) || hasChar(c, list2);
    }

    private static boolean hasChar(char c, List<Special> list, List<Special> list2, List<Special> list3) {
        return hasChar(c, list) || hasChar(c, list2) || hasChar(c, list3);
    }

    private List<Special> specialsFor(int i5) {
        return specialsFor(i5, 0);
    }
}
